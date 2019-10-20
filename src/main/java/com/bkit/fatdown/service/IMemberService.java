package com.bkit.fatdown.service;

import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbUserBasicInfo;
import org.springframework.transaction.annotation.Transactional;

/**
 * @file: IMemberService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 会员管理接口
 * @date: Created in 10/20/19  12:12 AM
 * @modified:
 * @version: 1.0
 */

public interface IMemberService {

    /**
     * 生成验证码
     *
     * @param phone 手机号码
     * @return 是否成功
     */
    CommonResultDTO generateAuthCode(String phone);

    /**
     * 获取当前登录会员
     *
     * @return 当前会员信息
     */
    TbUserBasicInfo getCurrentMember();

    /**
     * 更新会员积分
     *
     * @param id          会员id
     * @param integration 积分
     * @return 更新结果
     */
    boolean updateIntegration(Integer id, Integer integration);

    /**
     * 更新密码
     *
     * @param phone    手机号
     * @param password 密码
     * @return 结果
     */
    @Transactional
    boolean updatePassword(String phone, String password);

    /**
     * 注册用户
     *
     * @param phone    手机号
     * @param password 密码
     * @param authCode 验证码
     * @return 注册结果
     */
    @Transactional
    boolean register(String phone, String password, String authCode);

    /**
     * 校验验证码
     *
     * @param phone    手机号码
     * @param authCode 验证码
     * @return 是否成功
     */
    boolean verifyAuthCode(String phone, String authCode);

    /**
     * 登录功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 刷新token
     *
     * @param oldToken 原来的token
     * @return 新token
     */
    String refreshToken(String oldToken);
}
