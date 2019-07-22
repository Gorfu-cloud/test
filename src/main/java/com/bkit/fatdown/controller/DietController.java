package com.bkit.fatdown.controller;

import com.alibaba.fastjson.JSONObject;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.service.IPictureService;
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

// TODO 完善后在识别

//    @ApiOperation("上传饮食照片")
//    @CrossOrigin
//    @RequestMapping(value = "/uploadPicture/{uid}", method = RequestMethod.POST)
//    public CommonResultDTO uploadPicture(@PathVariable Integer uid) {
//        return null;
//    }
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
    @ApiOperation("上传饮食图片")
    @CrossOrigin
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public CommonResultDTO upload(@RequestParam MultipartFile picture, Integer uid, String foodName, Integer gram) {
        Map result = pictureService.upload(picture, uid, new Date());
        System.out.println(result.toString());
        return CommonResultDTO.success(result);
    }

    @ApiOperation("拍照获取识别食物结果")
    @CrossOrigin
    @RequestMapping(value = "/recognise", method = RequestMethod.POST)
    public CommonResultDTO recognise(@RequestParam MultipartFile file) {
        // 解析返回结果数组
        JSONObject jsonObject = RecogniseUtils.recognise(file);
        if (jsonObject.getString("data") == null) {
            return CommonResultDTO.failed();
        } else {
            return CommonResultDTO.success(jsonObject.getJSONArray("data"));
        }
    }

}
