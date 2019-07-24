package com.bkit.fatdown.controller;

import com.alibaba.fastjson.JSONObject;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbDietPicture;
import com.bkit.fatdown.entity.TbFoodBasic;
import com.bkit.fatdown.entity.TbFoodRecord;
import com.bkit.fatdown.service.IDietFoodService;
import com.bkit.fatdown.service.IFoodBasicService;
import com.bkit.fatdown.service.IPictureService;
import com.bkit.fatdown.utils.DateUtils;
import com.bkit.fatdown.utils.RecogniseUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.*;

/**
 * @file: DietController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 饮食模块控制器
 * @date: Created in 7/12/19  10:50 PM
 * @modified:
 * @version: 1.0
 */

@RestController
@RequestMapping("/diet")
public class DietController {
    @Resource
    private IPictureService pictureService;

    @Resource
    private IFoodBasicService foodBasicService;

    @Resource
    private IDietFoodService foodService;

//
//    @ApiOperation("查看所有饮食图片，通过uid")
//    @CrossOrigin
//    @RequestMapping(value = "/listPicture/{uid}", method = RequestMethod.GET)
//    public CommonResultDTO listPictureByUid(@PathVariable Integer uid) {
//        return null;
//    }
//
//    @ApiOperation("查看每日饮食报告,通过uid，date")
//    @CrossOrigin
//    @RequestMapping(value = "/listDailyReport", method = RequestMethod.GET)
//    public CommonResultDTO listDailyReportByUid(@RequestBody Integer uid, Date date) {
//        return null;
//    }
//
//    @ApiOperation("查看每周饮食报告,通过uid，date")
//    @CrossOrigin
//    @RequestMapping(value = "/listWeeklyReport", method = RequestMethod.GET)
//    public CommonResultDTO listWeeklyReportByUid(@RequestBody Integer uid, Date date) {
//        return null;
//    }
//
//    @ApiOperation("查看每月饮食报告,通过uid，date")
//    @CrossOrigin
//    @RequestMapping(value = "/listMonthlyReport", method = RequestMethod.GET)
//    public CommonResultDTO listMonthlyReportByUid(@RequestBody Integer uid, Date date) {
//        return null;
//    }
//
//    @ApiOperation("获取食物列表")
//    @CrossOrigin
//    @RequestMapping(value = "/getFood", method = RequestMethod.GET)
//    public CommonResultDTO listFoodName() {
//        return null;
//    }
//
//    @ApiOperation("获取零食列表")
//    @CrossOrigin
//    @RequestMapping(value = "/listSnack", method = RequestMethod.POST)
//    public CommonResultDTO listSnack() {
//        return null;
//    }

    @ApiOperation("上传饮食图片,保存饮食记录，uid，foodName(识别不出时，必填），gram（重量，识别不出时，必填）")
    @CrossOrigin
    @RequestMapping(value = "/upload/{uid}/{foodName}/{gram}", method = RequestMethod.POST)
    @Transactional
    public CommonResultDTO upload(@RequestParam MultipartFile picture, @PathVariable Integer uid,
                                  @PathVariable String foodName, @PathVariable Double gram) {
        Map<String, Object> result = pictureService.upload(picture, uid, new Date());

        // 判断上传是否成功，url：图片路径，flag=0上传失败
        if (result.containsKey("url") && result.containsKey("flag")) {
            int id;
            TbFoodRecord foodRecord;
            int flag = Integer.parseInt(result.get("flag").toString());
            String imgUrl = result.get("url").toString();

            // 上传图片失败
            if (flag == 0) {
                return CommonResultDTO.failed("上传图片失败");
            }

            // 查找食物基础信息是否存在？
            List<TbFoodBasic> foodList = foodBasicService.listByName(foodName);
            // 菜式不在数据库中,插入新菜式记录,flag=0->已有菜式，flag=1->新菜式
            if (foodList.size() == 0) {
                TbFoodBasic newFoodBasic = new TbFoodBasic();
                newFoodBasic.setFoodName(foodName);
                newFoodBasic.setQuantity(gram);
                newFoodBasic.setType("未知");
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
                return CommonResultDTO.success();
            }
            return CommonResultDTO.failed("创建饮食记录失败");
        }
        return CommonResultDTO.validateFailed("图片上传失败");
    }

    @ApiOperation("拍照获取识别食物结果")
    @CrossOrigin
    @RequestMapping(value = "/recognise", method = RequestMethod.POST)
    public CommonResultDTO recognise(@RequestParam MultipartFile file) {
        // 解析返回结果数组
        JSONObject jsonObject = RecogniseUtils.recognise(file);
        if (jsonObject.getJSONArray("data").size() == 0) {
            return CommonResultDTO.validateFailed("无法识别或识别结果为空");
        } else {
            return CommonResultDTO.success(jsonObject.getJSONArray("data"));
        }
    }

    @ApiOperation("获取当天早餐图库")
    @CrossOrigin
    @RequestMapping(value = "/listBreakfast/{uid}/{date}", method = RequestMethod.GET)
    public CommonResultDTO listBreakfast(@PathVariable Integer uid, @PathVariable String date) {
        List<TbDietPicture> pictureList = pictureService.listBetweenTime(uid, DateUtils.getBreakfastStartTime(DateUtils.string2Date(date)),
                DateUtils.getBreakfastEndTime(DateUtils.string2Date(date)));
        if (pictureList.size() == 0) {
            return CommonResultDTO.failed("早餐，无记录");
        }
        return CommonResultDTO.success(pictureList);
    }

    @ApiOperation("获取当天午餐图库")
    @CrossOrigin
    @RequestMapping(value = "/listLunch/{uid}/{date}", method = RequestMethod.GET)
    public CommonResultDTO listLunch(@PathVariable Integer uid, @PathVariable String date) {

        List<TbDietPicture> pictureList = pictureService.listBetweenTime(uid, DateUtils.getLunchStartTime(DateUtils.string2Date(date)),
                DateUtils.getLunchEndTime(DateUtils.string2Date(date)));
        if (pictureList.size() == 0) {
            return CommonResultDTO.failed("午餐，无记录");
        }
        return CommonResultDTO.success(pictureList);
    }

    @ApiOperation("获取当天晚餐图库")
    @CrossOrigin
    @RequestMapping(value = "/listDinner/{uid}/{date}", method = RequestMethod.GET)
    public CommonResultDTO listDinner(@PathVariable Integer uid, @PathVariable String date) {
        List<TbDietPicture> pictureList = pictureService.listBetweenTime(uid, DateUtils.getDinnerStartTime(DateUtils.string2Date(date)),
                DateUtils.getDinnerEndTime(DateUtils.string2Date(date)));
        if (pictureList.size() == 0) {
            return CommonResultDTO.failed("晚餐，无记录");
        }
        return CommonResultDTO.success(pictureList);
    }

    @ApiOperation("获取当天三餐图库")
    @CrossOrigin
    @RequestMapping(value = "/listDietPicture/{uid}/{date}", method = RequestMethod.GET)
    public CommonResultDTO listDietPicture(@PathVariable Integer uid, @PathVariable String date) {

        HashMap<String, Object> listMap = pictureService.listByDate(uid, DateUtils.string2Date(date));
        if (listMap.size() == 0) {
            return CommonResultDTO.failed("该日期下没有记录");
        }
        return CommonResultDTO.success(listMap);
    }
}
