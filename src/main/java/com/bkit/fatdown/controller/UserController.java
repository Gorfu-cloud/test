package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbUserPrivacyInfo;
import com.bkit.fatdown.service.IUserBasicInfoService;
import com.bkit.fatdown.service.IUserPrivacyInfoService;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    IUserPrivacyInfoService privacyInfoService;

    @ApiOperation("小程序用户登录")
    @CrossOrigin
    @RequestMapping(value = "/login/{code}", method = RequestMethod.POST)
    public CommonResultDTO registerUser(@PathVariable @NotNull String code) {
        if (code == null || code.length() == 0) {
            return CommonResultDTO.failed("code错误");
        }
        return CommonResultDTO.success(userBasicInfoService.login(code));
    }

    @ApiOperation("通过openid获取基础信息")
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

    @ApiOperation("通过uid获取隐私信息")
    @CrossOrigin
    @RequestMapping(value = "/getPrivacyInfo/{uid}", method = RequestMethod.POST)
    public CommonResultDTO getUserPrivacyInfo(@PathVariable Integer uid) {
        if (uid == null) {
            return CommonResultDTO.failed("uid非空");
        }
        List<TbUserPrivacyInfo> privacyInfoList = privacyInfoService.getByUid(uid);
        if (privacyInfoList.size() == 0) {
            return CommonResultDTO.validateFailed("用户不存在");
        }
        return CommonResultDTO.success(privacyInfoList.get(0));
    }

}
