package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.service.IUserBasicInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @file: UserController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 用户相关控制器
 * @date: Created in 7/10/19  8:53 AM
 * @modified:
 * @version: 1.0
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    IUserBasicInfoService userBasicInfoService;

    @CrossOrigin
    @RequestMapping(value = "/login/{code}", method = RequestMethod.POST)
    public CommonResultDTO registerUser(@PathVariable String code) {
        if (code == null || code.length() == 0) {
            return CommonResultDTO.failed("code错误");
        }
        return CommonResultDTO.success(userBasicInfoService.login(code));
    }

    @CrossOrigin
    @RequestMapping(value = "/getBasicInfoByOpenid/{openid}", method = RequestMethod.POST)
    public CommonResultDTO getUserBasicInfo(@PathVariable String openid) {
        if (openid == null || openid.length() == 0) {
            return CommonResultDTO.failed("openid错误");
        }

        if (userBasicInfoService.countByOpenid(openid) == 0) {
            return CommonResultDTO.failed("用户不存在");
        }

        return CommonResultDTO.success(userBasicInfoService.getByOpenid(openid));
    }

//    @CrossOrigin
//    @RequestMapping(value = "/getBasicInfoByUid/{uid}", method = RequestMethod.POST)
//    public CommonResultDTO getUserBasicInfo(@PathVariable String uid) {
//        if (uid == null || uid.length() == 0) {
//            return CommonResultDTO.failed("uid错误");
//        }
//
//    }
}
