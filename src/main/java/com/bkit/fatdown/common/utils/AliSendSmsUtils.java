package com.bkit.fatdown.common.utils;

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

    private final static String regionId = "cn-guangzhou";
    private final static String accessKeyId = "LTAI4FiB2jV8KT6kMg2ERzrU";
    private final static String accessSecret = "oeT2Xb5dW5BGrqmYIgdsnuK9gCkSPG";

    public void sendMessage() {

        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();

        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", regionId);

        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ClientException e) {
            e.printStackTrace();
            LOGGER.error("send message fail :{}", e.getMessage());
        }
    }
}
