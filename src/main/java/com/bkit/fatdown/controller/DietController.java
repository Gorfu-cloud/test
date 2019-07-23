package com.bkit.fatdown.controller;

import com.alibaba.fastjson.JSONObject;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbDietPicture;
import com.bkit.fatdown.service.IPictureService;
import com.bkit.fatdown.utils.DateUtils;
import com.bkit.fatdown.utils.RecogniseUtils;
import io.swagger.annotations.ApiOperation;
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

    @Deprecated
    @ApiOperation("上传饮食图片，foodName，uid，gram（重量）")
    @CrossOrigin
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public CommonResultDTO upload(@RequestParam MultipartFile picture, @RequestParam Integer uid,
                                  @RequestParam String foodName, @RequestParam Integer gram) {
        Map<String, Object> result = pictureService.upload(picture, uid, new Date());
        // 判断上传是否成功，url：图片路径，flag=0上传失败
        if (result.containsKey("url") && result.containsKey("flag")) {
            String imgUrl = result.get("url").toString();
            int flag = Integer.parseInt(result.get("flag").toString());

            // 查找食物基础信息是否存在？

            // 插入饮食记录，type：

            return CommonResultDTO.success();
        }
        return CommonResultDTO.validateFailed();
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
    @RequestMapping(value = "/listBreakfast", method = RequestMethod.GET)
    public CommonResultDTO listBreakfast(@RequestParam Integer uid, @RequestParam Date date) {
        List<TbDietPicture> pictureList = pictureService.listBetweenTime(uid, DateUtils.getBreakfastStartTime(date),
                DateUtils.getBreakfastEndTime(date));
        if (pictureList.size() == 0) {
            return CommonResultDTO.failed("早餐，无记录");
        }
        return CommonResultDTO.success(pictureList);
    }

    @ApiOperation("获取当天午餐图库")
    @CrossOrigin
    @RequestMapping(value = "/listLunch", method = RequestMethod.GET)
    public CommonResultDTO listLunch(@RequestParam Integer uid, @RequestParam Date date) {
        List<TbDietPicture> pictureList = pictureService.listBetweenTime(uid, DateUtils.getLunchStartTime(date),
                DateUtils.getLunchEndTime(date));
        if (pictureList.size() == 0) {
            return CommonResultDTO.failed("午餐，无记录");
        }
        return CommonResultDTO.success(pictureList);
    }

    @ApiOperation("获取当天晚餐图库")
    @CrossOrigin
    @RequestMapping(value = "/listDinner", method = RequestMethod.GET)
    public CommonResultDTO listDinner(@RequestParam Integer uid, @RequestParam Date date) {
        List<TbDietPicture> pictureList = pictureService.listBetweenTime(uid, DateUtils.getDinnerStartTime(date),
                DateUtils.getDinnerEndTime(date));
        if (pictureList.size() == 0) {
            return CommonResultDTO.failed("晚餐，无记录");
        }
        return CommonResultDTO.success(pictureList);
    }

    @ApiOperation("获取当天三餐图库")
    @CrossOrigin
    @RequestMapping(value = "/listDietPicture", method = RequestMethod.GET)
    public CommonResultDTO listDietPicture(@RequestParam Integer uid, @RequestParam Date date) {
        HashMap<String, Object> map = pictureService.listByDate(uid, date);
        if (map.size() == 0) {
            return CommonResultDTO.failed("该日期下没有记录");
        }
        return CommonResultDTO.success(map);
    }
}
