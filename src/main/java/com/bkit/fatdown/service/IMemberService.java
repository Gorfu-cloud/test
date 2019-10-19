package com.bkit.fatdown.service;

import com.bkit.fatdown.dto.CommonResultDTO;

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
     * 校验验证码
     *
     * @param phone 手机号码
     * @param code  验证码
     * @return 是否成功
     */
    CommonResultDTO verifyAuthCode(String phone, String code);
}
