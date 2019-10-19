package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.service.IMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/code", method = RequestMethod.GET)
    public CommonResultDTO getAuthCode(@RequestParam String phone) {
        // 判断用户是否已经注册过
        return memberService.generateAuthCode(phone);
    }

    @ApiOperation("校验验证码")
    @RequestMapping(value = "/code/verify", method = RequestMethod.POST)
    public CommonResultDTO verifyCode(@RequestParam String phone, @RequestParam String code) {
        return memberService.verifyAuthCode(phone, code);
    }
}
