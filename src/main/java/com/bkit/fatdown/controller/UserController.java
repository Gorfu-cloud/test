package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonPageDTO;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbUserBasicInfo;
import com.bkit.fatdown.entity.TbUserPrivacyInfo;
import com.bkit.fatdown.service.IUserBasicInfoService;
import com.bkit.fatdown.service.IUserPrivacyInfoService;
import com.bkit.fatdown.utils.CheckInputUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
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
    IUserBasicInfoService basicInfoService;

    @Resource
    IUserPrivacyInfoService privacyInfoService;

    @ApiOperation("小程序用户登录")
    @ApiImplicitParam(name = "code", value = "session_code", paramType = "query")
    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResultDTO registerUser(@RequestBody HashMap<String, String> map) {
        String code = map.get("code");

        if (code == null || code.length() == 0) {
            return CommonResultDTO.failed("code错误");
        }
        return CommonResultDTO.success(basicInfoService.login(code));
    }

    @ApiOperation("通过openId获取基础信息")
    @CrossOrigin
    @RequestMapping(value = "/getBasicInfo/{openId}", method = RequestMethod.GET)
    public CommonResultDTO getUserBasicInfo(@PathVariable String openId) {
        if (CheckInputUtils.checkNull(openId)) {
            return CommonResultDTO.validateFailed("openId错误");
        }

        if (basicInfoService.countByOpenId(openId) == 0) {
            return CommonResultDTO.failed("用户不存在");
        }

        return CommonResultDTO.success(basicInfoService.getByOpenId(openId));
    }

    @ApiOperation("通过uid获取所有隐私信息")
    @CrossOrigin
    @RequestMapping(value = "/listPrivacyInfo/{uid}", method = RequestMethod.GET)
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

    @ApiOperation("更新用户基础信息,")
    @CrossOrigin
    @RequestMapping(value = "/updateUserBasicInfo", method = RequestMethod.POST)
    public CommonResultDTO addUserBasicInfo(@RequestBody HashMap<String, String> map) {
        TbUserBasicInfo userBasicInfo = getUserBasicInfoFromMap(map);
        if (userBasicInfo.getId() != null) {
            return CommonResultDTO.validateFailed("openId为空");
        }

        if (basicInfoService.insert(userBasicInfo)) {
            return CommonResultDTO.success();
        }
        return CommonResultDTO.failed("更新基础数据失败");

    }

    @ApiOperation("更新用户基础信息,userId必填")
    @CrossOrigin
    @RequestMapping(value = "/updateBasicInfo", method = RequestMethod.POST)
    public CommonResultDTO updateUserBasicInfo(@RequestBody HashMap<String, String> map) {
        TbUserBasicInfo userBasicInfo = getUserBasicInfoFromMap(map);
        if (userBasicInfo.getId() != null) {
            if (basicInfoService.update(userBasicInfo)) {
                return CommonResultDTO.success("更新成功");
            } else {
                return CommonResultDTO.validateFailed("更新失败");
            }
        } else {
            return CommonResultDTO.failed("openId或uid为空");
        }
    }

    @ApiOperation("添加用户隐私信息,userId必填,注意:HashMap<String, Double>")
    @CrossOrigin
    @RequestMapping(value = "/addPrivacyInfo", method = RequestMethod.POST)
    public CommonResultDTO addUserPrivacyInfo(@RequestBody HashMap<String, Double> map) {
        TbUserPrivacyInfo userPrivacyInfo = getPrivacyInfoFromMap(map);
        if (basicInfoService.countById(userPrivacyInfo.getUserId()) != 0) {
            if (privacyInfoService.insert(userPrivacyInfo)) {
                return CommonResultDTO.success();
            } else {
                return CommonResultDTO.failed("创建隐私数据记录失败");
            }
        }
        return CommonResultDTO.validateFailed("用户不存在");
    }

    @ApiOperation("通过id获取隐私信息")
    @CrossOrigin
    @RequestMapping(value = "/getPrivacyInfo/{id}", method = RequestMethod.GET)
    public CommonResultDTO getUserPrivacyInfo(@PathVariable int id) {
        return CommonResultDTO.success(privacyInfoService.getById(id));
    }

    @Deprecated
    @ApiOperation("分页获取用户信息")
    @CrossOrigin
    @RequestMapping(value = "/listBasicInfo", method = RequestMethod.GET)
    public CommonPageDTO listBasicInfo(Integer pageSize, Integer pageNum) {
        return CommonPageDTO.restPage(null);
    }

    @Deprecated
    @ApiOperation("获取同一分组中的所有对象数据")
    @CrossOrigin
    @RequestMapping(value = "/listBasicInfo/{userLever}", method = RequestMethod.GET)
    public CommonPageDTO listBasicInfoByUserLever(@PathVariable Integer userLever, Integer pageSize, Integer pageNum) {

        return CommonPageDTO.restPage(null);
    }

    /**
     * @description: 获取map中的用户信息
     * @params: HashMap
     * @return: TbUserBasicInfo
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 7/12/19
     */
    private TbUserBasicInfo getUserBasicInfoFromMap(HashMap<String, String> map) {
        TbUserBasicInfo userBasicInfo = new TbUserBasicInfo();
        if (map.containsKey("id")) {
            int id = Integer.parseInt(map.get("id"));
            userBasicInfo.setId(id);
        }

        if (map.containsKey("openId")) {
            userBasicInfo.setOpenId(map.get("openId"));
        }

        if (map.containsKey("avatarUrl")) {
            userBasicInfo.setAvatarUrl(map.get("avatarUrl"));
        }

        if (map.containsKey("nickName")) {
            userBasicInfo.setNickName(map.get("nickName"));
        }
        if (map.containsKey("trueName")) {
            userBasicInfo.setTrueName(map.get("trueName"));
        }
        if (map.containsKey("age")) {
            int age = Integer.parseInt(map.get("age"));
            userBasicInfo.setAge(age);
        }

        if (map.containsKey("gender")) {
            int gender = Integer.parseInt(map.get("gender"));
            userBasicInfo.setGender(gender);
        }

        if (map.containsKey("phone")) {
            userBasicInfo.setPhone(map.get("phone"));
        }

        if (map.containsKey("city")) {
            userBasicInfo.setCity(map.get("city"));
        }

        if (map.containsKey("height")) {
            double height = Double.parseDouble(map.get("height"));
            userBasicInfo.setHeight(height);
        }

        if (map.containsKey("weight")) {
            double weight = Double.parseDouble(map.get("weight"));
            userBasicInfo.setWeight(weight);
        }

        if (map.containsKey("job")) {
            userBasicInfo.setJob(map.get("job"));
        }

        if (map.containsKey("userLevel")) {
            int userLevel = Integer.parseInt(map.get("userLevel"));
            userBasicInfo.setUserLevel(userLevel);
        }

        if (map.containsKey("province")) {
            userBasicInfo.setProvince(map.get("province"));
        }

        if (map.containsKey("flag")) {
            int flag = Integer.parseInt(map.get("flag"));
            userBasicInfo.setFlag(flag);
        }

        userBasicInfo.setGmtModified(new Date());
        return userBasicInfo;
    }

    /**
     * @description: 获取map中的用户信息
     * @params: HashMap
     * @return: TbUserPrivacyInfo
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 7/12/19
     */
    private TbUserPrivacyInfo getPrivacyInfoFromMap(HashMap<String, Double> map) {
        TbUserPrivacyInfo userPrivacyInfo = new TbUserPrivacyInfo();
        if (map.containsKey("id")) {
            userPrivacyInfo.setId(map.get("id").intValue());
        }

        if (map.containsKey("userId")) {
            userPrivacyInfo.setUserId(map.get("userId").intValue());
        }

        if (map.containsKey("fatRate")) {
            userPrivacyInfo.setFatRate(map.get("fatRate"));
        }

        if (map.containsKey("bust")) {
            userPrivacyInfo.setBust(map.get("bust"));
        }

        if (map.containsKey("waist")) {
            userPrivacyInfo.setWaist(map.get("waist"));
        }

        if (map.containsKey("hip")) {
            userPrivacyInfo.setHip(map.get("hip"));
        }

        if (map.containsKey("calf")) {
            userPrivacyInfo.setCalf(map.get("calf"));
        }

        if (map.containsKey("thign")) {
            userPrivacyInfo.setThign(map.get("thign"));
        }

        if (map.containsKey("forearm")) {
            userPrivacyInfo.setForeArm(map.get("forearm"));
        }

        if (map.containsKey("muscleOxygen")) {
            userPrivacyInfo.setMuscleOxygen(map.get("muscleOxygen"));
        }

        if (map.containsKey("bloodPressure")) {
            userPrivacyInfo.setBloodOxygen(map.get("bloodPressure"));
        }

        if (map.containsKey("bloodOxygen")) {
            userPrivacyInfo.setBloodOxygen(map.get("bloodOxygen"));
        }

        if (map.containsKey("heartOxygen")) {
            userPrivacyInfo.setHeartRate(map.get("heartOxygen").intValue());
        }

        return userPrivacyInfo;
    }
}
