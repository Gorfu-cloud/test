package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbUserBasicInfo;
import com.bkit.fatdown.entity.TbUserLifeStyle;
import com.bkit.fatdown.entity.TbUserPrivacyInfo;
import com.bkit.fatdown.service.IDietFoodService;
import com.bkit.fatdown.service.IUserBasicInfoService;
import com.bkit.fatdown.service.IUserLifeStyleService;
import com.bkit.fatdown.service.IUserPrivacyInfoService;
import com.bkit.fatdown.common.utils.DataTransferUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
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
@Api(value = "/user", tags = "用户信息模块")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserBasicInfoService basicInfoService;

    @Resource
    private IUserPrivacyInfoService privacyInfoService;

    @Resource
    private IUserLifeStyleService userLifeStyleService;

    @Resource
    private IDietFoodService dietFoodService;

    private static Logger logger = Logger.getLogger(UserController.class);

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
        if (openId.isEmpty()) {
            return CommonResultDTO.validateFailed("openId错误");
        }

        if (basicInfoService.countByOpenId(openId) == 0) {
            return CommonResultDTO.failed("用户不存在");
        }

        return CommonResultDTO.success(basicInfoService.getByOpenId(openId));
    }

    @ApiOperation("更新用户基础信息,id必填")
    @CrossOrigin
    @RequestMapping(value = "/updateBasicInfo", method = RequestMethod.POST)
    public CommonResultDTO updateUserBasicInfo(@RequestBody HashMap<String, String> map) {
        TbUserBasicInfo userBasicInfo = DataTransferUtils.getUserBasicInfoFromMap(map);
        if (userBasicInfo.getId() == null || map.get("id").isEmpty() || map.get("id").length() == 0) {
            return CommonResultDTO.failed("id为空");
        }

        if (basicInfoService.update(userBasicInfo)) {
            if (userBasicInfo.getGender() != null) {
                updateDietStandard(userBasicInfo.getId());
            }
            return CommonResultDTO.success("更新成功");
        } else {
            return CommonResultDTO.validateFailed("更新失败");
        }
    }

    @ApiOperation("更新用户隐私信息记录,userId必填")
    @CrossOrigin
    @RequestMapping(value = "/updatePrivacyInfo", method = RequestMethod.POST)
    public CommonResultDTO updateUserPrivacyInfo(@RequestBody HashMap<String, Double> map) {
        // userId参数无效时
        if (!map.containsKey("userId") || basicInfoService.countById(map.get("userId").intValue()) == 0) {
            return CommonResultDTO.validateFailed("userId无效");
        }
        // 获取传入的参数
        TbUserPrivacyInfo privacyInfo = DataTransferUtils.getPrivacyInfoFromMap(map);

        if (updatePrivacyInfo(privacyInfo)) {
            if (privacyInfo.getHeight() != null || privacyInfo.getWeight() != null) {
                updateDietStandard(privacyInfo.getUserId());
            }
            return CommonResultDTO.success();
        } else {
            return CommonResultDTO.failed("更新失败");
        }
    }

    @ApiOperation("通过uid,获取隐私信息")
    @CrossOrigin
    @RequestMapping(value = "/getPrivacyInfoByUid/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getUserPrivacyInfoByUid(@PathVariable int uid) {
        if (basicInfoService.countById(uid) == 0) {
            return CommonResultDTO.validateFailed("uid出错");
        }

        if (privacyInfoService.listByUid(uid).size() > 0) {
            TbUserPrivacyInfo privacyInfo = privacyInfoService.listByUid(uid).get(0);
            // 判断结果是否为空
            if (privacyInfo != null) {
                return CommonResultDTO.success(privacyInfo);
            }
        }
        return CommonResultDTO.failed();
    }

    @ApiOperation("通过uid获取所有隐私信息")
    @CrossOrigin
    @RequestMapping(value = "/listPrivacyInfo/{uid}", method = RequestMethod.GET)
    public CommonResultDTO listUserPrivacyInfoByUid(@PathVariable Integer uid) {
        if (uid == null) {
            return CommonResultDTO.failed("uid非空");
        }
        List<TbUserPrivacyInfo> privacyInfoList = privacyInfoService.listByUid(uid);
        if (privacyInfoList.size() == 0) {
            return CommonResultDTO.validateFailed("用户不存在");
        }
        return CommonResultDTO.success(privacyInfoList);
    }

    @ApiOperation("通过id,获取隐私信息")
    @CrossOrigin
    @RequestMapping(value = "/getPrivacyInfoById/{id}", method = RequestMethod.GET)
    public CommonResultDTO getUserPrivacyInfoById(@PathVariable int id) {
        return CommonResultDTO.success(privacyInfoService.getById(id));
    }

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
    @PreAuthorize("hasAnyAuthority('user:lifeStyle:read')")
    public CommonResultDTO listLifeStyleByUid(@RequestParam Integer uid) {

        if (userLifeStyleService.countByUid(uid) > 0) {
            return CommonResultDTO.success(userLifeStyleService.listByUid(uid));
        }

        return CommonResultDTO.validateFailed();
    }

    @ApiOperation("更新用户生活习惯,必传userId")
    @CrossOrigin
    @RequestMapping(value = "/updateLifeStyle", method = RequestMethod.POST)
    public CommonResultDTO updateLifeStyle(@RequestBody HashMap<String, Integer> map) {
        // 用户id不存在时
        if (!map.containsKey("userId") || basicInfoService.countById(map.get("userId")) == 0) {
            return CommonResultDTO.validateFailed("userId出错");
        }
        // 读取用户中的信息
        TbUserLifeStyle lifeStyle = DataTransferUtils.getUserLifeStyleFromMap(map);
        // 查看今天是否有记录
        if (userLifeStyleService.countByUidAndCreateDate(lifeStyle.getUserId(), new Date()) > 0) {
            if (userLifeStyleService.update(lifeStyle)) {
                updateDietStandard(lifeStyle.getUserId());
                return CommonResultDTO.success();
            } else {
                return CommonResultDTO.failed();
            }
        } else {
            if (userLifeStyleService.insert(lifeStyle)) {
                updateDietStandard(lifeStyle.getUserId());
                return CommonResultDTO.success();
            } else {
                return CommonResultDTO.failed();
            }
        }
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

    /**
     * 更新隐私数据
     *
     * @param privacyInfo 饮食数据
     * @return 更新情况
     */
    private boolean updatePrivacyInfo(TbUserPrivacyInfo privacyInfo) {
        // 当天有隐私记录存在,获取原来的id，并更新原来记录
        if (privacyInfoService.countByUidAndDate(privacyInfo.getUserId(), new Date()) > 0) {
            // 更新成功
            return privacyInfoService.update(privacyInfo);
        } else {
            // 隐私记录不存在的时候，新建隐私记录
            return privacyInfoService.insert(privacyInfo);
        }
    }

    private void updateDietStandard(int uid) {
        boolean result = dietFoodService.updateDietStandardByUid(uid);
        logger.info("更新用户饮食标准：" + uid + " > " + result);
    }
}
