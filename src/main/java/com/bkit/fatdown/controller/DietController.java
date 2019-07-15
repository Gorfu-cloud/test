package com.bkit.fatdown.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.utils.RecogniseUtils;
import com.google.gson.JsonObject;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

import static com.bkit.fatdown.utils.RecogniseUtils.getRecognise;

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

    @ApiOperation("上传饮食照片")
    @CrossOrigin
    @RequestMapping(value = "/uploadPicture/{uid}", method = RequestMethod.POST)
    public CommonResultDTO uploadPicture(@PathVariable Integer uid) {
        return null;
    }

    @ApiOperation("查看所有饮食图片，通过uid")
    @CrossOrigin
    @RequestMapping(value = "/listPicture/{uid}", method = RequestMethod.GET)
    public CommonResultDTO listPictureByUid(@PathVariable Integer uid) {
        return null;
    }

    @ApiOperation("查看每日饮食报告,通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/listDailyReport", method = RequestMethod.GET)
    public CommonResultDTO listDailyReportByUid(@RequestBody Integer uid, Date date) {
        return null;
    }

    @ApiOperation("查看每周饮食报告,通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/listWeeklyReport", method = RequestMethod.GET)
    public CommonResultDTO listWeeklyReportByUid(@RequestBody Integer uid, Date date) {
        return null;
    }

    @ApiOperation("查看每月饮食报告,通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/listMonthlyReport", method = RequestMethod.GET)
    public CommonResultDTO listMonthlyReportByUid(@RequestBody Integer uid, Date date) {
        return null;
    }

    @ApiOperation("获取食物列表")
    @CrossOrigin
    @RequestMapping(value = "/getFood", method = RequestMethod.GET)
    public CommonResultDTO listFoodName() {
        return null;
    }

    @ApiOperation("获取零食列表")
    @CrossOrigin
    @RequestMapping(value = "/listSnack", method = RequestMethod.POST)
    public CommonResultDTO listSnack() {
        return null;
    }

    @ApiOperation("拍照获取识别食物结果")
    @CrossOrigin
    @RequestMapping(value = "/recognise", method = RequestMethod.GET)
    public CommonResultDTO recognise(@RequestParam MultipartFile file) {
        StringBuffer recogniseBuffer = RecogniseUtils.getRecognise(file);
        JSONObject object = JSON.parseObject(recogniseBuffer.toString());
        return CommonResultDTO.success(object);
    }
}
