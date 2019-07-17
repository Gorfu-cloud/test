package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonPageDTO;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbUserBasicInfo;
import com.bkit.fatdown.entity.TbUserLifeStyle;
import com.bkit.fatdown.entity.TbUserPrivacyInfo;
import com.bkit.fatdown.service.IUserBasicInfoService;
import com.bkit.fatdown.service.IUserLifeStyleService;
import com.bkit.fatdown.service.IUserPrivacyInfoService;
import com.bkit.fatdown.utils.CheckInputUtils;
import com.bkit.fatdown.utils.DataMapUtils;
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
    private IUserBasicInfoService basicInfoService;

    @Resource
    private IUserPrivacyInfoService privacyInfoService;

    @Resource
    private IUserLifeStyleService userLifeStyleService;

    @ApiOperation("小程序用户登录,注册,传入session_code")
    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResultDTO registerUser(@RequestBody HashMap<String, String> map) {
        String code = map.get("code");

        if (code == null || code.length() == 0) {
            return CommonResultDTO.validateFailed("code错误");
        }
        return CommonResultDTO.success(basicInfoService.login(code));
    }

    @ApiOperation("通过用户id,获取基础信息")
    @CrossOrigin
    @RequestMapping(value = "/getBasicInfoById/{id}", method = RequestMethod.GET)
    public CommonResultDTO getUserBasicInfoById(@PathVariable Integer id) {
        if (id == null || basicInfoService.countById(id) == 0) {
            return CommonResultDTO.validateFailed("id错误");
        }
        TbUserBasicInfo basicInfo = basicInfoService.getById(id);
        if (basicInfo != null) {
            return CommonResultDTO.success(basicInfo);
        }
        return CommonResultDTO.failed();
    }

    @ApiOperation("通过openid获取基础信息")
    @CrossOrigin
    @RequestMapping(value = "/getBasicInfoByOpenId/{openId}", method = RequestMethod.GET)
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
    public CommonResultDTO getUserPrivacyInfoByUid(@PathVariable Integer uid) {
        if (uid == null) {
            return CommonResultDTO.failed("uid非空");
        }
        List<TbUserPrivacyInfo> privacyInfoList = privacyInfoService.listByUid(uid);
        if (privacyInfoList.size() == 0) {
            return CommonResultDTO.validateFailed("用户不存在");
        }
        return CommonResultDTO.success(privacyInfoList);
    }

    @ApiOperation("更新用户基础信息,id必填")
    @CrossOrigin
    @RequestMapping(value = "/updateBasicInfo", method = RequestMethod.POST)
    public CommonResultDTO updateUserBasicInfo(@RequestBody HashMap<String, String> map) {
        TbUserBasicInfo userBasicInfo = DataMapUtils.getUserBasicInfoFromMap(map);
        if (userBasicInfo.getId() == null) {
            return CommonResultDTO.failed("id为空");
        }

        if (basicInfoService.update(userBasicInfo)) {
            return CommonResultDTO.success("更新成功");
        } else {
            return CommonResultDTO.validateFailed("更新失败");
        }
    }

    @ApiOperation("更新用户隐私信息记录,userId必填")
    @CrossOrigin
    @RequestMapping(value = "/updatePrivacyInfo", method = RequestMethod.POST)
    public CommonResultDTO updateUserPrivacyInfo(@RequestBody HashMap<String, Double> map) {
        TbUserPrivacyInfo privacyInfo = DataMapUtils.getPrivacyInfoFromMap(map);
        if (basicInfoService.countById(privacyInfo.getUserId()) == 0) {
            return CommonResultDTO.validateFailed("用户不存在");
        }
        // 当天有隐私记录存在,更新原来的记录
        if (privacyInfoService.countByUidAndDate(privacyInfo.getUserId(), privacyInfo.getGmtCreate()) > 0) {
            if (privacyInfoService.update(privacyInfo)) {
                return CommonResultDTO.success();
            } else {
                return CommonResultDTO.failed("更新隐私数据记录失败");
            }
        } else {
            if (privacyInfoService.insert(privacyInfo)) {
                return CommonResultDTO.success();
            } else {
                return CommonResultDTO.failed("更新隐私数据记录失败");
            }
        }
    }

    @ApiOperation("通过id获取隐私信息")
    @CrossOrigin
    @RequestMapping(value = "/getPrivacyInfoByUid/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getUserPrivacyInfoByUid(@PathVariable int uid) {
        if (basicInfoService.countById(uid) == 0) {
            return CommonResultDTO.validateFailed("uid出错");
        }

        if (privacyInfoService.listByUid(uid).size() > 0) {
            return CommonResultDTO.success(privacyInfoService.listByUid(uid).get(0));
        }
        return CommonResultDTO.failed();
    }

    @ApiOperation("通过id获取隐私信息")
    @CrossOrigin
    @RequestMapping(value = "/getPrivacyInfoById/{id}", method = RequestMethod.GET)
    public CommonResultDTO getUserPrivacyInfoById(@PathVariable int id) {
        return CommonResultDTO.success(privacyInfoService.getById(id));
    }

    //    TODO :分页处理失败.
//    @Deprecated
    @ApiOperation("分页获取用户信息")
    @CrossOrigin
    @RequestMapping(value = "/listBasicInfo", method = RequestMethod.GET)
    public CommonPageDTO listBasicInfo(@RequestBody HashMap<String, Integer> map) {
        CommonPageDTO pageDTO = DataMapUtils.getCommonPageDTOFromMap(map);
        if (pageDTO.getPageNum() == null || pageDTO.getPageSize() == null) {
            return CommonPageDTO.restPage(null);
        }

        System.out.println(basicInfoService.listAll(pageDTO.getPageSize(), pageDTO.getPageNum()).size());
        return CommonPageDTO.restPage(basicInfoService.listAll(pageDTO.getPageSize(), pageDTO.getPageNum()));
    }

//    TODO :分页处理失败
//    @Deprecated
//    @ApiOperation("获取同一分组中的所有对象数据")
//    @CrossOrigin
//    @RequestMapping(value = "/listBasicInfo/{userLever}", method = RequestMethod.GET)
//    public CommonPageDTO listBasicInfoByUserLever(@PathVariable Integer userLever, Integer pageSize, Integer pageNum) {
//        return CommonPageDTO.restPage(null);
//    }


    @ApiOperation("获取最新生活习惯")
    @CrossOrigin
    @RequestMapping(value = "/getLifeStyle/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getLifeStyle(@PathVariable Integer uid) {
        if (uid == null || userLifeStyleService.countByUid(uid) == 0) {
            return CommonResultDTO.validateFailed();
        }
        return CommonResultDTO.success(userLifeStyleService.listByUid(uid).get(0));
    }


    @ApiOperation("通过UID获取用户所有生活习惯")
    @CrossOrigin
    @RequestMapping(value = "/listLifeStyle", method = RequestMethod.GET)
    public CommonResultDTO listLifeStyleByUid(@RequestBody HashMap<String, Integer> map) {
        if (map.containsKey("uid")) {
            int uid = map.get("uid");
            if (userLifeStyleService.countByUid(uid) > 0) {
                return CommonResultDTO.success(userLifeStyleService.listByUid(uid));
            }
        }
        return CommonResultDTO.validateFailed();
    }


    @ApiOperation("更新用户生活习惯,必传userId")
    @CrossOrigin
    @RequestMapping(value = "/updateLifeStyle", method = RequestMethod.POST)
    public CommonResultDTO updateLifeStyle(@RequestBody HashMap<String, Integer> map) {
        if (map.containsKey("userId")) {
            TbUserLifeStyle lifeStyle = DataMapUtils.getUserLifeStyleFromMap(map);
            if (userLifeStyleService.countByUidAndCreateDate(lifeStyle.getUserId(), lifeStyle.getGmtCreate()) > 0) {
                if (userLifeStyleService.update(lifeStyle)) {
                    return CommonResultDTO.success();
                } else {
                    return CommonResultDTO.failed();
                }
            } else {
                if (userLifeStyleService.insert(lifeStyle)) {
                    return CommonResultDTO.success();
                } else {
                    return CommonResultDTO.failed();
                }
            }
        }
        return CommonResultDTO.validateFailed("userId出错");
    }

    @ApiOperation("查看最新的生活习惯详情")
    @CrossOrigin
    @RequestMapping(value = "/getLifeStyleDetail/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getLifeStyleDetail(@PathVariable Integer uid) {
        if (userLifeStyleService.countByUid(uid) > 0) {
            CommonResultDTO.success(userLifeStyleService.listByUid(uid).get(0));
        }
        return CommonResultDTO.validateFailed();
    }
}
