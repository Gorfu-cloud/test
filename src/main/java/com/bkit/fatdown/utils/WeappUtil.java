package com.bkit.fatdown.utils;

/**
 * @file: WxappUtil
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 微信相关工具类
 * @date: Created in 2019/7/10 14:59
 * @modified:
 * @version: 1.0
 */

public class WeappUtil {

    // TODO 测试appId待修改

    private static final String REQUEST_URL = "https://api.weixin.qq.com/sns/jscode2session";
    private static final String APP_ID = "wx4243a0b576e90fd9";
    private static final String APP_SECRET = "126bf51300a399ff588ced60caa0ee57";
    private static final String GRANT_TYPE = "authorization_code";

    public static String getSessionKeyOrOpenId(String code) {
        String params = "appid=" + APP_ID + "&secret=" + APP_SECRET + "&js_code=" + code
                + "&grant_type=" + GRANT_TYPE;
        // 发送post请求读取调用微信 https://api.weixin.qq.com/sns/jscode2session 接口获取openid用户唯一标识
        return HttpRequestUtil.sendGet(REQUEST_URL, params);
    }
}
