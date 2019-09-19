package com.bkit.fatdown.common.utils;

/**
 * @file: WxappUtil
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 微信相关工具类
 * @date: Created in 2019/7/10 14:59
 * @modified:
 * @version: 1.0
 */

public class WxUtil {
    /**
     * 微信小程序登录,session请求路径
     */
    private static final String REQUEST_URL = "https://api.weixin.qq.com/sns/jscode2session";
    /**
     * 小程序appid
     */
    private static final String APP_ID = "wxb4d6a676f74115d7";
    /**
     * 小程序会话密钥
     */
    private static final String APP_SECRET = "038f53335163a62c1141344671c752a6";
    /**
     * 默认登录类型
     */
    private static final String GRANT_TYPE = "authorization_code";

    /**
     * 获取openid和Session
     *
     * @param code 会话码
     * @return 结果
     */
    public static String getSessionKeyOrOpenId(String code) {
        String params = "appid=" + APP_ID + "&secret=" + APP_SECRET + "&js_code=" + code
                + "&grant_type=" + GRANT_TYPE;
        // 发送post请求读取调用微信 https://api.weixin.qq.com/sns/jscode2session 接口获取openid用户唯一标识
        return HttpUtil.sendGet(REQUEST_URL, params);
    }
}

