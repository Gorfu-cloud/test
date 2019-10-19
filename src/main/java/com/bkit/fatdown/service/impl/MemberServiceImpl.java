package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.common.utils.AliSendSmsUtils;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.service.IMemberService;
import com.bkit.fatdown.service.IRedisService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @file: MemberServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 会员管理接口实现类
 * @date: Created in 10/20/19  12:17 AM
 * @modified:
 * @version: 1.0
 */

@Service
public class MemberServiceImpl implements IMemberService {

    @Resource
    private IRedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    /**
     * 生成验证码
     *
     * @param phone 手机号码
     * @return 是否成功
     */
    @Override
    public CommonResultDTO generateAuthCode(String phone) {
        StringBuilder sb = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }

        String code = sb.toString();

        // 验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + phone, code);

        // 设置超时时间
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + phone, AUTH_CODE_EXPIRE_SECONDS);

        if (AliSendSmsUtils.sendRegisterCode(phone, code)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    /**
     * 校验验证码
     *
     * @param phone 手机号码
     * @param code  验证码
     * @return 是否成功
     */
    @Override
    public CommonResultDTO verifyAuthCode(String phone, String code) {
        if (StringUtils.isEmpty(code)) {
            return CommonResultDTO.failed("请输入验证码");
        }

        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + phone);
        boolean result = code.equals(realAuthCode);

        if (result) {
            return CommonResultDTO.success(null, "验证码校验成功");
        } else {
            return CommonResultDTO.failed("验证码不正确");
        }
    }
}
