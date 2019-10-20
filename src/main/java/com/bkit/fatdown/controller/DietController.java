package com.bkit.fatdown.controller;

import cn.hutool.core.date.DateUtil;
import com.bkit.fatdown.common.utils.DateUtils;
import com.bkit.fatdown.dto.CommonPageDTO;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.dto.diet.MealEvaluationDTO;
import com.bkit.fatdown.dto.food.FoodRecordDTO;
import com.bkit.fatdown.entity.TbDietRecord;
import com.bkit.fatdown.entity.TbDietUserStandard;
import com.bkit.fatdown.entity.TbFoodBasic;
import com.bkit.fatdown.entity.TbFoodRecord;
import com.bkit.fatdown.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.bkit.fatdown.common.utils.DateUtils;

/**
 * @file: DietController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 饮食功能接口
 * @date: Created in 8/11/19  10:08 PM
 * @modified:
 * @version: 1.0
 */
@Api(value = "/diet", tags = "饮食信息模块")
@RestController
@RequestMapping("/diet")
public class DietController {

    @Resource
    private IDietFoodService foodService;

    @Resource
    private IUserBasicInfoService basicInfoService;

    @Resource
    private IDietRecordService dietRecordService;

    @Resource
    private IPictureService pictureService;

    @Resource
    private IFoodBasicService foodBasicService;

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

    @ApiOperation("添加饮食记录")
    @CrossOrigin
    @RequestMapping(value = "/foodRecord/{uid}", method = RequestMethod.POST)
    public CommonResultDTO addFoodRecord(@PathVariable Integer uid, @RequestParam MultipartFile picture, @RequestParam Integer eatPer,
                                         @RequestParam Double gram, @RequestParam String foodName, @RequestParam String date) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST || picture == null || date == null) {
            return CommonResultDTO.validateFailed();
        }
        logger.info("insert foodRecord uid:{} and date:{},foodName:{} and eatPer:{} and  picture :{} gram: {}", uid, date, foodName, eatPer, picture.toString(), gram);
        Date inputDate = DateUtil.parseDateTime(date);
        String empty = "msg", urlOfString = "url", flagOfExist = "flag";

        // 获取上传结果
        Map<String, Object> result = pictureService.upload(picture, uid, inputDate);

        // 上传失败
        if (result.containsKey(empty)) {
            logger.error("update picture is empty, uid:{}", uid);
            return CommonResultDTO.validateFailed("上传文件为空");
        }

        // 判断上传是否成功，url：图片路径，flag=0上传失败
        if (result.containsKey(urlOfString) && result.containsKey(flagOfExist)) {
            int id;
            int flag = Integer.parseInt(result.get(flagOfExist).toString());
            String imgUrl = result.get(urlOfString).toString();

            // 上传图片失败
            if (flag == DATA_NOT_EXIST) {
                logger.error("upload picture fail, uid:{}", uid);
                return CommonResultDTO.failed("上传图片失败");
            }

            // 查找食物基础信息是否存在？
            List<TbFoodBasic> foodList = foodBasicService.listByName(foodName);
            // 菜式不在数据库中,插入新菜式记录,flag= 0 -> 已有菜式，flag= 1 -> 新菜式
            if (foodList.size() == DATA_NOT_EXIST) {
                TbFoodBasic newFoodBasic = new TbFoodBasic();
                newFoodBasic.setFoodName(foodName);
                newFoodBasic.setQuantity(gram);
                newFoodBasic.setType("未知");
                // 菜式不存在
                newFoodBasic.setFlag(1);

                // 创建记录并返回创建id，id = -1 -> 插入失败
                id = foodBasicService.insertReturnId(newFoodBasic);
                if (id == -1) {
                    return CommonResultDTO.failed("创建菜式记录失败");
                }

                // 插入饮食记录
                TbFoodRecord foodRecord;
                foodRecord = new TbFoodRecord();
                foodRecord.setFoodId(id);
                foodRecord.setUserId(uid);
                foodRecord.setEatPer(eatPer / 100.0);
                foodRecord.setFoodQuantity(gram);
                foodRecord.setImgUrl(imgUrl);
                foodRecord.setGmtCreate(inputDate);

                if (foodService.insert(foodRecord)) {
                    int type = DateUtils.getMealType(inputDate);
                    // 更新每餐饮食成分记录
                    if (dietRecordService.updateDietRecord(inputDate, uid, type)) {
                        logger.info("update diet_record success, date:{} and uid: {} and type :{}", date, uid, type);
                    } else {
                        logger.error("update diet_record fail, date:{} and uid: {} and type :{}", date, uid, type);
                    }
                    // 更新每天用餐成分总量记录
                    if (dietRecordService.updateDailyDietRecord(inputDate, uid)) {
                        logger.info("update daily dietRecord success, date:{} and uid: {} ", date, uid);
                    } else {
                        logger.error("update daily dietRecord fail, date:{} and uid: {} ", date, uid);
                    }
                    return CommonResultDTO.success();
                }

                logger.info("insert foodRecord fail, uid: {}", uid);
                return CommonResultDTO.failed("创建饮食记录失败");
            }

            // 插入饮食记录
            TbFoodBasic foodBasicBasic = foodList.get(0);
            TbFoodRecord foodRecord;
            foodRecord = new TbFoodRecord();
            foodRecord.setFoodId(foodBasicBasic.getId());
            foodRecord.setUserId(uid);
            foodRecord.setEatPer(eatPer / 100.0);
            foodRecord.setFoodQuantity(gram);
            foodRecord.setImgUrl(imgUrl);
            foodRecord.setGmtCreate(inputDate);

            int type = DateUtils.getMealType(inputDate);

            if (foodService.insert(foodRecord)) {
                // 更新每餐饮食成分记录
                if (dietRecordService.updateDietRecord(inputDate, uid, type)) {
                    logger.info("update diet_record success, date:{} and uid: {} and type :{}", date, uid, type);
                } else {
                    logger.error("update diet_record fail, date:{} and uid: {} and type :{}", date, uid, type);
                }
                // 更新每天用餐成分总量记录
                if (dietRecordService.updateDailyDietRecord(inputDate, uid)) {
                    logger.info("update daily dietRecord success, date:{} and uid: {} ", date, uid);
                } else {
                    logger.error("update daily dietRecord fail, date:{} and uid: {} ", date, uid);
                }
                return CommonResultDTO.success();
            }
            return CommonResultDTO.failed("创建饮食记录失败");
        }
        return CommonResultDTO.validateFailed("参数错误");
    }

    @ApiOperation("补充饮食记录(临时)")
    @CrossOrigin
    @RequestMapping(value = "/record/add/test/{uid}", method = RequestMethod.POST)
    public CommonResultDTO addTestRecord(@PathVariable Integer uid, @RequestParam Integer eatPer,
                                         @RequestParam Double gram, @RequestParam String foodName, @RequestParam String date) {
        if (eatPer > 100 || eatPer < 0 || foodName.isEmpty() || date.isEmpty()) {
            return CommonResultDTO.validateFailed();
        }

        Date inputDate = DateUtil.parseDateTime(date);

        // 查找食物基础信息是否存在？
        List<TbFoodBasic> foodList = foodBasicService.listByName(foodName);
        // 菜式不在数据库中,插入新菜式记录,flag= 0 -> 已有菜式，flag= 1 -> 新菜式
        if (foodList.size() == DATA_NOT_EXIST) {
            TbFoodBasic newFoodBasic = new TbFoodBasic();
            newFoodBasic.setFoodName(foodName);
            newFoodBasic.setQuantity(gram);
            newFoodBasic.setType("未知");
            // 菜式不存在
            newFoodBasic.setFlag(1);

            // 创建记录并返回创建id，id = -1 -> 插入失败
            int id = foodBasicService.insertReturnId(newFoodBasic);

            if (id == -1) {
                return CommonResultDTO.failed("创建菜式记录失败");
            }

            // 插入饮食记录
            TbFoodRecord foodRecord;
            foodRecord = new TbFoodRecord();
            foodRecord.setFoodId(id);
            foodRecord.setUserId(uid);
            foodRecord.setEatPer(eatPer / 100.0);
            foodRecord.setFoodQuantity(gram);
            foodRecord.setImgUrl("http://image.sunnyqcloud.com/favicon.ico");
            foodRecord.setGmtCreate(inputDate);

            if (foodService.insert(foodRecord)) {
                int type = DateUtils.getMealType(inputDate);
                // 更新每餐饮食成分记录
                if (dietRecordService.updateDietRecord(inputDate, uid, type)) {
                    logger.info("update diet_record success, date:{} and uid: {} and type :{}", date, uid, type);
                } else {
                    logger.error("update diet_record fail, date:{} and uid: {} and type :{}", date, uid, type);
                }
                // 更新每天用餐成分总量记录
                if (dietRecordService.updateDailyDietRecord(inputDate, uid)) {
                    logger.info("update daily dietRecord success, date:{} and uid: {} ", date, uid);
                } else {
                    logger.error("update daily dietRecord fail, date:{} and uid: {} ", date, uid);
                }
                return CommonResultDTO.success();
            }

            logger.info("insert foodRecord fail, uid: {}", uid);
            return CommonResultDTO.failed("创建饮食记录失败");
        }

        // 插入饮食记录
        TbFoodBasic foodBasicBasic = foodList.get(0);

        TbFoodRecord foodRecord;
        foodRecord = new TbFoodRecord();
        foodRecord.setFoodId(foodBasicBasic.getId());
        foodRecord.setUserId(uid);
        foodRecord.setEatPer(eatPer / 100.0);
        foodRecord.setFoodQuantity(gram);
        foodRecord.setImgUrl("http://image.sunnyqcloud.com/favicon.ico");
        foodRecord.setGmtCreate(inputDate);

        // 获取饮食类型
        int type = DateUtils.getMealType(inputDate);

        // 更新饮食摄入
        if (foodService.insert(foodRecord)) {
            // 更新每餐饮食成分记录
            if (dietRecordService.updateDietRecord(inputDate, uid, type)) {
                logger.info("update diet_record success, date:{} and uid: {} and type :{}", date, uid, type);
            } else {
                logger.error("update diet_record fail, date:{} and uid: {} and type :{}", date, uid, type);
            }
            // 更新每天用餐成分总量记录
            if (dietRecordService.updateDailyDietRecord(inputDate, uid)) {
                logger.info("update daily dietRecord success, date:{} and uid: {} ", date, uid);
            } else {
                logger.error("update daily dietRecord fail, date:{} and uid: {} ", date, uid);
            }
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed("创建饮食记录失败");

    }

    @ApiOperation("更新饮食记录")
    @CrossOrigin
    @RequestMapping(value = "/record/update/{uid}/{date}", method = RequestMethod.GET)
    public CommonResultDTO updateDietRecord(@PathVariable Integer uid, @PathVariable String date) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST || date.isEmpty()) {
            return CommonResultDTO.validateFailed();
        }

        Date dateTime = DateUtils.string2Date(date);

        if (dietRecordService.updateDailyDietRecord(dateTime, uid) && dietRecordService.updateDietRecord(dateTime, uid, 0)
                && dietRecordService.updateDietRecord(dateTime, uid, 1) && dietRecordService.updateDietRecord(dateTime, uid, 2)) {
            return CommonResultDTO.success();
        } else {
            return CommonResultDTO.failed();
        }
    }

    @ApiOperation("分页:获取饮食记录")
    @CrossOrigin
    @RequestMapping(value = "/records/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public CommonResultDTO listFoodRecordBySearch(@RequestParam(required = false) Integer uid, @RequestParam(required = false) String startDate,
                                                  @RequestParam(required = false) String endDate, @PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        if (pageNum == null || pageSize == null) {
            return CommonResultDTO.validateFailed();
        }

        if (startDate == null || endDate == null) {
            return CommonResultDTO.success(CommonPageDTO.restPage(foodService.listFoodRecord(uid, pageNum, pageSize)));
        }

        List<TbFoodRecord> list = foodService.listFoodRecord(uid, DateUtils.string2Date(startDate), DateUtils.string2Date(endDate), pageNum, pageSize);

        return CommonResultDTO.success(CommonPageDTO.restPage(list));
    }

    @ApiOperation("获取饮食记录")
    @CrossOrigin
    @RequestMapping(value = "/record/{recordId}", method = RequestMethod.GET)
    public CommonResultDTO getFoodRecord(@PathVariable Integer recordId) {
        if (recordId == null || foodService.count(recordId) == 0) {
            return CommonResultDTO.validateFailed();
        }

        TbFoodRecord foodRecord = foodService.getFoodRecord(recordId);

        if (foodRecord == null) {
            return CommonResultDTO.failed();
        }
        return CommonResultDTO.success(foodRecord);
    }

    @ApiOperation("分页: 查看当餐相关饮食记录")
    @CrossOrigin
    @RequestMapping(value = "/records/meals/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public CommonResultDTO listFoodRecordByPage(@RequestParam Integer recordId, @PathVariable Integer pageNum,
                                                @PathVariable Integer pageSize) {
        if (recordId == null || foodService.count(recordId) == 0 || pageNum == null || pageSize == null) {
            return CommonResultDTO.validateFailed();
        }

        TbFoodRecord foodRecord = foodService.getFoodRecord(recordId);
        if (foodRecord == null) {
            return CommonResultDTO.failed();
        }

        // 用餐类型
        Integer type = DateUtils.getMealType(foodRecord.getGmtCreate());
        List<FoodRecordDTO> list = foodService.listFoodRecord(foodRecord.getUserId(), foodRecord.getGmtCreate(), type, pageNum, pageSize);

        return CommonResultDTO.success(CommonPageDTO.restPage(list));
    }

    @ApiOperation("根据recordId，获取当餐 摄入分配")
    @CrossOrigin
    @RequestMapping(value = "/record/meals/{recordId}", method = RequestMethod.GET)
    public CommonResultDTO<MealEvaluationDTO> getMealsElementRecordId(@PathVariable Integer recordId) {
        if (recordId == null) {
            return CommonResultDTO.validateFailed();
        }

        MealEvaluationDTO mealEvaluationDTO = foodService.getEvaluationByRecordId(recordId);

        if (mealEvaluationDTO == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(mealEvaluationDTO);
    }

    @ApiOperation("根据FoodRecord,获取摄入成分")
    @CrossOrigin
    @RequestMapping(value = "/record/dietRecord/{recordId}", method = RequestMethod.GET)
    public CommonResultDTO getDietRecordByRecord(@PathVariable Integer recordId) {
        if (recordId == null || foodService.count(recordId) == 0) {
            return CommonResultDTO.validateFailed();
        }

        TbFoodRecord foodRecord = foodService.getFoodRecord(recordId);
        if (foodRecord == null) {
            return CommonResultDTO.failed();
        }

        // 用餐类型
        int type = DateUtils.getMealType(foodRecord.getGmtCreate());

        TbDietRecord record = dietRecordService.getDietRecord(foodRecord.getGmtCreate(), foodRecord.getUserId(), type);

        if (record == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(record);
    }

    @ApiOperation("通过ID,更新饮食记录")
    @CrossOrigin
    @RequestMapping(value = "/record/update/{recordId}", method = RequestMethod.GET)
    public CommonResultDTO updateFoodRecord(@PathVariable Integer recordId, @RequestParam(required = false) Integer eatPer,
                                            @RequestParam(required = false) Integer status, @RequestParam(required = false) Double foodQuantity) {
        if (recordId == null || foodService.count(recordId) == 0) {
            return CommonResultDTO.validateFailed();
        }

        TbFoodRecord foodRecord = new TbFoodRecord();
        foodRecord.setId(recordId);

        if (eatPer != null) {
            foodRecord.setEatPer(eatPer / 100.0);
        }

        if (foodQuantity != null) {
            foodRecord.setFoodQuantity(foodQuantity);
        }

        if (status != null) {
            foodRecord.setStatus(status);
        }

        if (foodService.updateFoodRecord(foodRecord)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("删除饮食记录")
    @CrossOrigin
    @RequestMapping(value = "/record/{recordId}", method = RequestMethod.DELETE)
    public CommonResultDTO deleteFoodRecord(@PathVariable Integer recordId) {
        if (recordId == null || foodService.count(recordId) == 0) {
            return CommonResultDTO.validateFailed();
        }

        if (foodService.delete(recordId)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }
}
