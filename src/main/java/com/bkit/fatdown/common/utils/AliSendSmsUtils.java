package com.bkit.fatdown.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @file: AliSendSmsUtils
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 啊里云短信服务工具类
 * @date: Created in 10/19/19  10:19 AM
 * @modified:
 * @version: 1.0
 */

public class AliSendSmsUtils {

    private final static Logger LOGGER = LoggerFactory.getLogger(AliSendSmsUtils.class);

    private final static String REGION_ID = "cn-hangzhou";
    private final static String ACCESS_KEY_ID = "LTAI4FiB2jV8KT6kMg2ERzrU";
    private final static String ACCESS_SECRET = "oeT2Xb5dW5BGrqmYIgdsnuK9gCkSPG";
    private final static String DOMAIN = "dysmsapi.aliyuncs.com";
    private final static String VERSION = "2017-05-25";
    private final static String SIGN_NAME = "广东健康服务管理";


    /**
     * 发送短信
     *
     * @param phoneNumber   手机好
     * @param templateCode  短信模板
     * @param templateParam 模板参数
     * @return 是否成功
     */
    private static boolean sendMessage(String phoneNumber, String templateCode, String templateParam) {

        DefaultProfile profile = DefaultProfile.getProfile(REGION_ID, ACCESS_KEY_ID, ACCESS_SECRET);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();

        request.setMethod(MethodType.POST);
        request.setDomain(DOMAIN);
        request.setVersion(VERSION);
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", REGION_ID);
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", SIGN_NAME);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", templateParam);

        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response);
            JSONObject jsonObject = JSONObject.parseObject(response.getData());

            if ("OK".equals(jsonObject.getString("Code"))) {
                return true;
            }

        } catch (ClientException e) {
            e.printStackTrace();
            LOGGER.error("send message fail :{}", e.getMessage());
        }

        return false;
    }

    /**
     * 发送注册验证码
     *
     * @param phoneNumber 手机号码
     * @param code        验证码
     * @return 是否成功
     */
    public static boolean sendRegisterCode(String phoneNumber, String code) {
        String loginTemplate = "SMS_175537657";

        String param = "{\"code\":\"" + code + "\"}";

        return sendMessage(phoneNumber, loginTemplate, param);
    }

}
