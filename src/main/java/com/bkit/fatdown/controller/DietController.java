package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbDietUserStandard;
import com.bkit.fatdown.service.IDietFoodService;
import com.bkit.fatdown.service.IUserBasicInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @file: DietController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 饮食功能接口
 * @date: Created in 8/11/19  10:08 PM
 * @modified:
 * @version: 1.0
 */
@Api(value = "/diet", tags = "饮食标准模块")
@RestController
@RequestMapping("/diet")
public class DietController {

    @Resource
    private IDietFoodService foodService;

    @Resource
    private IUserBasicInfoService basicInfoService;

    private static final Logger logger = LoggerFactory.getLogger(DietController.class);

    private static final int DATA_NOT_EXIST = 0;

    @ApiOperation("获取用户饮食标准")
    @CrossOrigin
    @RequestMapping(value = "/userStandard/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getUserStandard(@PathVariable Integer uid) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("uid有误");
        }

        if (foodService.updateDietStandardByUid(uid)) {
            logger.info("update userStandard success, uid:{}", uid);
        } else {
            logger.error("update userStandard fail, uid:{}", uid);
        }

        TbDietUserStandard userStandard = foodService.getDietStandard(uid);
        if (userStandard == null) {
            logger.info("getUserStandard fail , uid:{}", uid);
            return CommonResultDTO.failed("获取用户饮食标准失败");
        }

        logger.info("getUserStandard success, uid:{}", uid);
        return CommonResultDTO.success(userStandard);
    }
}
