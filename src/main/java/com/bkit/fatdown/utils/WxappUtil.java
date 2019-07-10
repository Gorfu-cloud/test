package com.bkit.fatdown.utils;

import java.util.*;

/**
 * @file: WxappUtil
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 微信相关工具类
 * @date: Created in 2019/7/10 14:59
 * @modified:
 * @version: 1.0
 */

public class WxappUtil {

    public static String getSessionKeyOropenid(String code) {
        // 微信端登录code值
        String wxCode = code;
        Locale locale = new Locale("en", "US");
        // 读取属性文件
        ResourceBundle resource = ResourceBundle.getBundle("config/wxConfig.properties", locale);
        // 请求地址 https://api.weixin.qq.com/sns/jscode2session
        String requestUrl = resource.getString("url");
        Map<String, String> requestUrlParam = new HashMap<>(8);
        // 小程序调用wx.login返回的code
        requestUrlParam.put("js_code", wxCode);
        // 开发者设置中的appId
        requestUrlParam.put("appid", resource.getString("appId"));
        // 开发者设置中的appSecret
        requestUrlParam.put("secret", resource.getString("appSecret"));
        // 默认参数 authorization_code
        requestUrlParam.put("grant_type", resource.getString("grantType"));
        // 发送post请求读取调用微信 https://api.weixin.qq.com/sns/jscode2session 接口获取openid用户唯一标识
        return HttpRequestUtil.sendPost(requestUrl, requestUrlParam.toString());
    }

}
