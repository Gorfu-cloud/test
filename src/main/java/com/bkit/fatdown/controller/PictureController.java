package com.bkit.fatdown.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.bkit.fatdown.common.utils.DateUtils;
import com.bkit.fatdown.common.utils.IDUtils;
import com.bkit.fatdown.common.utils.RecogniseUtils;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbDietPicture;
import com.bkit.fatdown.entity.TbFoodBasic;
import com.bkit.fatdown.entity.TbFoodRecord;
import com.bkit.fatdown.entity.TbPictureType;
import com.bkit.fatdown.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @file: PictureController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 图片相关功能控制器
 * @date: Created in 8/11/19  9:44 PM
 * @modified:
 * @version: 1.0
 */
@Api(value = "/picture", tags = "图片相关模块")
@RestController
@RequestMapping("/picture")
public class PictureController {

    @Resource
    private IPictureService pictureService;

    @Resource
    private IDietRecordService dietRecordService;

    @Resource
    private IFoodBasicService foodBasicService;

    @Resource
    private IDietFoodService foodService;

    @Resource
    IPictureTypeService pictureTypeService;

    private static final int DATA_NOT_EXIST = 0;

    private static final Logger logger = LoggerFactory.getLogger(PictureController.class);

    @ApiOperation("上传图片并保存菜式信息")
    @CrossOrigin
    @RequestMapping(value = "/upload/diet/{uid}", method = RequestMethod.POST)
    @Transactional
    public CommonResultDTO upload(@RequestParam("picture") MultipartFile picture, @PathVariable Integer uid,
                                  @RequestParam String foodName, @RequestParam Double gram) {
        // 获取上传结果
        Map<String, Object> result = pictureService.upload(picture, uid, new Date());

        String empty = "msg";
        String urlOfString = "url";
        String flagOfExist = "flag";

        // 上传失败
        if (result.containsKey(empty)) {
            return CommonResultDTO.validateFailed("上传文件为空");
        }

        // 判断上传是否成功，url：图片路径，flag=0上传失败
        if (result.containsKey(urlOfString) && result.containsKey(flagOfExist)) {
            int id;
            TbFoodRecord foodRecord;
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
                foodRecord = new TbFoodRecord();
                foodRecord.setFoodId(id);
                foodRecord.setUserId(uid);
                foodRecord.setFoodQuantity(gram);
                foodRecord.setImgUrl(imgUrl);

                if (foodService.insert(foodRecord)) {
                    return CommonResultDTO.success();
                }
                logger.info("insert foodRecord fail, uid: {}", uid);
                return CommonResultDTO.failed("创建饮食记录失败");
            }

            // 插入饮食记录
            TbFoodBasic foodBasicBasic = foodList.get(0);
            foodRecord = new TbFoodRecord();
            foodRecord.setFoodId(foodBasicBasic.getId());
            foodRecord.setUserId(uid);
            foodRecord.setFoodQuantity(gram);
            foodRecord.setImgUrl(imgUrl);

            if (foodService.insert(foodRecord)) {
                // 更新每餐饮食成分记录
                if (dietRecordService.updateDietRecord(uid)) {
                    logger.info("update diet_record success, uid: {}", uid);
                } else {
                    logger.error("update diet_record fail, uid: {}", uid);
                }
                // 更新每天用餐成分总量记录
                if (dietRecordService.updateDailyDietRecord(uid)) {
                    logger.info("update daily dietRecord success, uid: {}", uid);
                } else {
                    logger.error("update daily dietRecord fail, uid: {}", uid);
                }
                return CommonResultDTO.success();
            }
            return CommonResultDTO.failed("创建饮食记录失败");
        }
        return CommonResultDTO.validateFailed("参数错误");
    }

    @ApiOperation("上传图片并补充饮食记录")
    @CrossOrigin
    @RequestMapping(value = "/upload/diet/add/{uid}", method = RequestMethod.POST)
    @Transactional
    public CommonResultDTO uploadDietPicture(@RequestParam("picture") MultipartFile picture, @PathVariable Integer uid,
                                  @RequestParam String foodName, @RequestParam Double gram, @RequestParam Double eatPer
            , @RequestParam String dateTime) {

        if (dateTime==null){
            return CommonResultDTO.validateFailed();
        }

        Date inputDate = DateUtil.parseDateTime(dateTime);

        // 获取上传结果
        Map<String, Object> result = pictureService.upload(picture, uid, new Date());

        String empty = "msg";
        String urlOfString = "url";
        String flagOfExist = "flag";

        // 上传失败
        if (result.containsKey(empty)) {
            return CommonResultDTO.validateFailed("上传文件为空");
        }

        // 判断上传是否成功，url：图片路径，flag=0上传失败
        if (result.containsKey(urlOfString) && result.containsKey(flagOfExist)) {
            int id;
            TbFoodRecord foodRecord;
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
                foodRecord = new TbFoodRecord();
                foodRecord.setFoodId(id);
                foodRecord.setUserId(uid);
                foodRecord.setFoodQuantity(gram);
                foodRecord.setImgUrl(imgUrl);
                foodRecord.setEatPer(eatPer/100.0);
                foodRecord.setGmtCreate(inputDate);

                if (foodService.insert(foodRecord)) {
                    return CommonResultDTO.success();
                }
                logger.info("insert foodRecord fail, uid: {}", uid);
                return CommonResultDTO.failed("补充饮食记录失败");
            }

            // 插入饮食记录
            TbFoodBasic foodBasicBasic = foodList.get(0);
            foodRecord = new TbFoodRecord();
            foodRecord.setFoodId(foodBasicBasic.getId());
            foodRecord.setUserId(uid);
            foodRecord.setFoodQuantity(gram);
            foodRecord.setImgUrl(imgUrl);
            foodRecord.setEatPer(eatPer/100.0);
            foodRecord.setGmtCreate(inputDate);

            if (foodService.insert(foodRecord)) {
                // 更新每餐饮食成分记录
                if (dietRecordService.updateDietRecord(uid)) {
                    logger.info("update diet_record success, uid: {}", uid);
                } else {
                    logger.error("update diet_record fail, uid: {}", uid);
                }
                // 更新每天用餐成分总量记录
                if (dietRecordService.updateDailyDietRecord(uid)) {
                    logger.info("update daily dietRecord success, uid: {}", uid);
                } else {
                    logger.error("update daily dietRecord fail, uid: {}", uid);
                }
                return CommonResultDTO.success();
            }
            return CommonResultDTO.failed("补充饮食记录失败");
        }

        return CommonResultDTO.validateFailed("参数错误");
    }

    @ApiOperation("拍照获取识别食物结果")
    @CrossOrigin
    @RequestMapping(value = "/recognise", method = RequestMethod.POST)
    public CommonResultDTO recognise(@RequestParam MultipartFile file) {
        String foodData = "data";
        // 解析识别返回结果数组
        JSONObject jsonObject = RecogniseUtils.recognise(file);
        if (jsonObject == null) {
            return CommonResultDTO.failed("无法识别或识别结果为空");
        }

        if (jsonObject.getJSONArray(foodData).size() == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("无法识别或识别结果为空");
        }

        return CommonResultDTO.success(jsonObject.getJSONArray(foodData));
    }

    @ApiOperation("拍照获取识别食物结果，返回对应编号")
    @CrossOrigin
    @RequestMapping(value = "/recognise/{num}", method = RequestMethod.POST)
    public CommonResultDTO recogniseById(@PathVariable Integer num, @RequestParam MultipartFile file) {
        HashMap<String, Object> map = new HashMap<>(2);
        String foodData = "data";
        // 解析识别返回结果数组
        JSONObject jsonObject = RecogniseUtils.recognise(file);
        try {


            if (jsonObject.getJSONArray(foodData).size() == DATA_NOT_EXIST) {
                return CommonResultDTO.validateFailed("无法识别或识别结果为空");
            }

            map.put("result", jsonObject.getJSONArray(foodData));
        } catch (Exception e) {
            logger.info("recogniseById error: {}", e.getMessage());
        }
        map.put("num", num);
        return CommonResultDTO.success(map);
    }

    @ApiOperation("获取早餐饮食图库")
    @CrossOrigin
    @RequestMapping(value = "/breakfast/{uid}", method = RequestMethod.GET)
    public CommonResultDTO listBreakfast(@PathVariable Integer uid, @RequestParam String date) {
        List<TbDietPicture> pictureList = pictureService.listBetweenTime(uid, DateUtils.getBreakfastStartTime(DateUtils.string2Date(date)),
                DateUtils.getBreakfastEndTime(DateUtils.string2Date(date)));
        if (pictureList.size() == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("早餐，无记录");
        }
        return CommonResultDTO.success(pictureList);
    }

    @ApiOperation("获取午餐饮食图库")
    @CrossOrigin
    @RequestMapping(value = "/lunch/{uid}", method = RequestMethod.GET)
    public CommonResultDTO listLunch(@PathVariable Integer uid, @RequestParam String date) {

        List<TbDietPicture> pictureList = pictureService.listBetweenTime(uid, DateUtils.getLunchStartTime(DateUtils.string2Date(date)),
                DateUtils.getLunchEndTime(DateUtils.string2Date(date)));
        if (pictureList.size() == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("午餐，无记录");
        }
        return CommonResultDTO.success(pictureList);
    }

    @ApiOperation("获取晚餐饮食图库")
    @CrossOrigin
    @RequestMapping(value = "/dinner/{uid}", method = RequestMethod.GET)
    public CommonResultDTO listDinner(@PathVariable Integer uid, @RequestParam String date) {
        List<TbDietPicture> pictureList = pictureService.listBetweenTime(uid, DateUtils.getDinnerStartTime(DateUtils.string2Date(date)),
                DateUtils.getDinnerEndTime(DateUtils.string2Date(date)));
        if (pictureList.size() == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("晚餐，无记录");
        }
        return CommonResultDTO.success(pictureList);
    }

    @ApiOperation("获取早、午、晚餐饮食图库")
    @CrossOrigin
    @RequestMapping(value = "/day/{uid}", method = RequestMethod.GET)
    public CommonResultDTO listDietPicture(@PathVariable Integer uid, @RequestParam String date) {

        HashMap<String, Object> listMap = pictureService.listByDate(uid, DateUtils.string2Date(date));
        if (listMap.size() == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("该日期下没有记录");
        }
        return CommonResultDTO.success(listMap);
    }

    @ApiOperation("删除饮食图片")
    @CrossOrigin
    @RequestMapping(value = "/meal/{uid}", method = RequestMethod.DELETE)
    public CommonResultDTO deleteMealPicture(@PathVariable Integer uid, @RequestBody HashMap<String, String> map) {
        if (!map.containsKey("url")) {
            return CommonResultDTO.validateFailed();
        }

        String url = map.get("url");

        if (pictureService.count(uid, url) == 0) {
            logger.error("picture fail");
            return CommonResultDTO.validateFailed("图片记录不存在");
        }

        TbDietPicture picture = pictureService.getPicture(uid, url);

        Date date = picture.getGmtCreate();
        int type = DateUtils.getMealType(date);

        // 删除图片
        if (pictureService.delete(uid, url) && foodService.delete(uid, url)) {
            // 这里需要更新饮食评价成分
            if (dietRecordService.updateDietRecord(date, uid, type)) {
                logger.info("update dietRecord success，date：{} and uid：{} and type：{}", date, uid, type);
            } else {
                logger.error("update dietRecord fail，date：{} and uid：{} and type：{}", date, uid, type);
            }

            if (dietRecordService.updateDietRecord(date, uid, 4)) {
                logger.info("update dietRecord daily success，date：{} and uid：{} and type：4", date, uid);
            } else {
                logger.error("update dietRecord daily fail，date：{} and uid：{} and type：4", date, uid);
            }
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }


    @ApiOperation("上传图片(重量训练资料）")
    @CrossOrigin
    @RequestMapping(value = "/upload/data/{typeId}", method = RequestMethod.POST)
    public CommonResultDTO uploadPictureData(@RequestParam MultipartFile picture, @PathVariable Integer typeId, @RequestParam Integer uid) {
        if (pictureTypeService.count(typeId) == DATA_NOT_EXIST || picture == null || typeId == null) {
            return CommonResultDTO.validateFailed();
        }

        if (pictureService.uploadDir(picture, uid, typeId)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("获取上传图片文件夹编号")
    @CrossOrigin
    @RequestMapping(value = "/upload/data/dir", method = RequestMethod.GET)
    public CommonResultDTO getPictureType(@RequestParam String foodName, @RequestParam HashMap<String, Double> map) {
        if (foodName.isEmpty() || map.isEmpty()) {
            return CommonResultDTO.validateFailed();
        }

        String typeName = IDUtils.getImageDirName(foodName, map);

        // 不存在
        if (pictureTypeService.count(typeName) == DATA_NOT_EXIST) {
            TbPictureType type = new TbPictureType();
            type.setTypeName(typeName);
            if (!pictureTypeService.insert(type)) {
                return CommonResultDTO.failed();
            }
        }

        Integer typeId = pictureTypeService.search(typeName);

        if (typeId == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(typeId);
    }
}
