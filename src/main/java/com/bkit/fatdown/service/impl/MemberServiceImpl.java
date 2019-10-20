package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.common.utils.AliSendSmsUtils;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbUserBasicInfo;
import com.bkit.fatdown.service.IMemberService;
import com.bkit.fatdown.service.IRedisService;
import com.bkit.fatdown.service.IUserBasicInfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
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

    @Resource
    private IUserBasicInfoService basicInfoService;

    @Resource
    private PasswordEncoder passwordEncoder;

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
     * 获取当前登录会员
     *
     * @return 当前会员信息
     */
    @Override
    public TbUserBasicInfo getCurrentMember() {
        return null;
    }

    /**
     * 更新会员积分
     *
     * @param id          会员id
     * @param integration 积分
     * @return 更新结果
     */
    @Override
    public boolean updateIntegration(Integer id, Integer integration) {
        return false;
    }

    /**
     * 更新密码
     *
     * @param phone    手机号
     * @param password 密码
     * @return 结果
     */
    @Override
    public boolean updatePassword(String phone, String password) {

        List<TbUserBasicInfo> basicInfoList = basicInfoService.listByPhone(phone);

        if (CollectionUtils.isEmpty(basicInfoList)) {
            return false;
        }

        TbUserBasicInfo basicInfo = basicInfoList.get(0);

        basicInfo.setPassword(passwordEncoder.encode(password));

        return basicInfoService.update(basicInfo);
    }

    /**
     * 注册用户
     *
     * @param phone    手机号
     * @param password 密码
     * @param authCode 验证码
     * @return 注册结果
     */
    @Override
    public boolean register(String phone, String password, String authCode) {

        TbUserBasicInfo basicInfo = new TbUserBasicInfo();
        basicInfo.setPhone(phone);
        // 默认启用用户
        basicInfo.setFlag(1);
        basicInfo.setPassword(passwordEncoder.encode(password));

        if (basicInfoService.insert(basicInfo)) {
            basicInfo.setPassword(null);
            return true;
        }

        return false;
    }

    /**
     * 校验验证码
     *
     * @param phone    手机号码
     * @param authCode 验证码
     * @return 是否成功
     */
    @Override
    public boolean verifyAuthCode(String phone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return false;
        }

        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + phone);

        return authCode.equals(realAuthCode);
    }

}
