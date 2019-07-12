package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbUserPrivacyInfo;
import com.bkit.fatdown.service.IUserBasicInfoService;
import com.bkit.fatdown.service.IUserPrivacyInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
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
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResultDTO registerUser(@RequestBody HashMap<String, String> map) {
        String code = map.get("code");

        if (code == null || code.length() == 0) {
            return CommonResultDTO.failed("code错误");
        }
        return CommonResultDTO.success(userBasicInfoService.login(code));
    }

    @ApiOperation("通过openId获取基础信息")
    @CrossOrigin
    @RequestMapping(value = "/getBasicInfoByOpenId/{openId}", method = RequestMethod.POST)
    public CommonResultDTO getUserBasicInfo(@PathVariable String openId) {
        if (openId == null || openId.length() == 0) {
            return CommonResultDTO.failed("openId错误");
        }

        if (userBasicInfoService.countByOpenId(openId) == 0) {
            return CommonResultDTO.failed("用户不存在");
        }

        return CommonResultDTO.success(userBasicInfoService.getByOpenId(openId));
    }

    @ApiOperation("通过uid获取所有隐私信息")
    @CrossOrigin
    @RequestMapping(value = "/listPrivacyInfoByUid/{uid}", method = RequestMethod.POST)
    public CommonResultDTO getUserPrivacyInfo(@PathVariable Integer uid) {
        if (uid == null) {
            return CommonResultDTO.failed("uid非空");
        }
        List<TbUserPrivacyInfo> privacyInfoList = privacyInfoService.listByUid(uid);
        if (privacyInfoList.size() == 0) {
            return CommonResultDTO.validateFailed("用户不存在");
        }
        return CommonResultDTO.success(privacyInfoList.get(0));
    }

}
