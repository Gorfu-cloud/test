package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbDietUserStandard;
import com.bkit.fatdown.entity.TbFoodRecord;
import com.bkit.fatdown.service.IDietFoodService;
import com.bkit.fatdown.service.IDietRecordService;
import com.bkit.fatdown.service.IUserBasicInfoService;
import com.bkit.fatdown.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;

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

    @Resource
    private IDietRecordService dietRecordService;


    private static final Logger logger = LoggerFactory.getLogger(DietController.class);

    private static final int DATA_NOT_EXIST = 0;
    private static final int DAY_TYPE = 4;

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

    @ApiOperation("更新菜式食用量")
    @CrossOrigin
    @RequestMapping(value = "/foodRecord/{id}", method = RequestMethod.PUT)
    public CommonResultDTO updateEatPer(@PathVariable Integer id, @RequestBody HashMap<String, Integer> map) {

        if (id == null || !map.containsKey("eatPer")) {
            return CommonResultDTO.validateFailed("更新食用比例");
        }

        Integer eatPer = map.get("eatPer");

        TbFoodRecord record = new TbFoodRecord();
        record.setEatPer(eatPer / 100.0);
        record.setId(id);

        // 更新
        TbFoodRecord foodRecord = foodService.getFoodRecord(id);
        Date date = foodRecord.getGmtCreate();
        int uid = foodRecord.getUserId();
        int type = DateUtils.getMealType(date);

        if (dietRecordService.updateDietRecord(date, uid, type)) {
            logger.info("fix eatPer:{} and update dietRecord success，date：{} and uid：{} and type：{}", eatPer, date, uid, type);
        } else {
            logger.error("fix eatPer:{} and update dietRecord fail，date：{} and uid：{} and type：{}", eatPer, date, uid, type);
        }

        if (dietRecordService.updateDietRecord(date, uid, DAY_TYPE)) {
            logger.info("update dietRecord daily success，date：{} and uid：{} and type：{}", date, uid, DAY_TYPE);
        } else {
            logger.error("update dietRecord daily fail，date：{} and uid：{} and type：{}", date, uid, DAY_TYPE);
        }

        if (foodService.updateFoodRecord(record)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }
}
