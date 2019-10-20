package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.dto.power.AdminLoginInfoDTO;
import com.bkit.fatdown.service.IMemberService;
import com.bkit.fatdown.service.IUserBasicInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @file: MemberController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 用户管理模块
 * @date: Created in 10/20/19  12:09 AM
 * @modified:
 * @version: 1.0
 */
@Api(value = "/member", tags = "会员管理模块")
@CrossOrigin
@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    private IMemberService memberService;

    @Resource
    private IUserBasicInfoService basicInfoService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/code", method = RequestMethod.GET)
    public CommonResultDTO getAuthCode(@RequestParam String phone) {
        // 判断用户是否已经注册过
        return memberService.generateAuthCode(phone);
    }

    @ApiOperation("校验验证码")
    @RequestMapping(value = "/code/verify", method = RequestMethod.POST)
    public CommonResultDTO verifyCode(@RequestParam String phone, @RequestParam String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return CommonResultDTO.failed("请输入验证码");
        }

        if (memberService.verifyAuthCode(phone, authCode)) {
            return CommonResultDTO.success(null, "验证码校验成功");
        }

        return CommonResultDTO.failed("验证码不正确");
    }


    @ApiOperation("会员注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResultDTO registerMember(@RequestParam String phone, @RequestParam String authCode, @RequestParam String password) {

        if (!memberService.verifyAuthCode(phone, authCode)) {
            return CommonResultDTO.failed("验证码错误");
        }

        if (basicInfoService.countByPhone(phone) > 0) {
            return CommonResultDTO.failed("用户已存在");
        }

        if (memberService.register(phone, authCode, password)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("获取用户是否存在")
    @RequestMapping(value = "/phone/verify", method = RequestMethod.GET)
    public CommonResultDTO verifyPhone(@RequestParam String phone) {
        if (StringUtils.isEmpty(phone)) {
            return CommonResultDTO.validateFailed();
        }

        if (basicInfoService.countByPhone(phone) > 0) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("更新密码")
    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public CommonResultDTO updateMemberPassword(@RequestParam String phone, @RequestParam String password,
                                                @RequestParam String authCode) {
        if (StringUtils.isEmpty(phone)) {
            return CommonResultDTO.validateFailed();
        }

        if (!memberService.verifyAuthCode(phone, authCode)) {
            return CommonResultDTO.validateFailed("验证码错误");
        }

        if (memberService.updatePassword(phone, password)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("会员登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResultDTO loginMember(@RequestBody AdminLoginInfoDTO loginInfoDTO) {
        String userName = loginInfoDTO.getUsername();
        String password = loginInfoDTO.getPassword();

        if (userName.isEmpty() || password.isEmpty()) {
            return CommonResultDTO.validateFailed();
        }

        String token = memberService.login(userName, password);

        if (token == null) {
            return CommonResultDTO.validateFailed("用户名或密码错误");
        }

        Map<String, String> tokenMap = new HashMap<>(3);

        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);

        return CommonResultDTO.success(tokenMap);
    }

    @ApiOperation("刷新Token")
    @RequestMapping(value = "/token/refresh", method = RequestMethod.GET)
    public CommonResultDTO refreshMemberToken(HttpServletRequest request) {

        String token = request.getHeader(tokenHeader);
        String refreshToken = memberService.refreshToken(token);

        if (refreshToken == null) {
            return CommonResultDTO.failed();
        }

        Map<String, String> tokenMap = new HashMap<>(2);

        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);

        return CommonResultDTO.success(tokenMap);
    }

    @ApiOperation("登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public CommonResultDTO logoutMember() {
        return CommonResultDTO.success();
    }
}
