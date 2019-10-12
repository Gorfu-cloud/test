package com.bkit.fatdown.controller;

import cn.hutool.core.date.DateUtil;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.service.IDietReportService;
import com.bkit.fatdown.service.ITimelineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @file: TimelineController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 数据变化时间轴控制器
 * @date: Created in 9/17/19  11:26 AM
 * @modified:
 * @version: 1.0
 */
@Api(value = "/timeline", tags = "健康时间轴模块")
@RestController
@RequestMapping("/timeline")
@CrossOrigin
public class TimelineController {

    @Resource
    private ITimelineService timelineService;

    @Resource
    private IDietReportService reportService;

    private final static Integer MIN_MEAL_OF_DAY = 3;
    private final static Integer MIN_MEAL_OF_WEEKLY = 5;

    @ApiOperation("个人: 查看一天能量变化")
    @RequestMapping(value = "/energy/daily/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getDailyEnergy(@RequestParam String date, @PathVariable Integer uid) {

        Date inputDate = DateUtil.parseDate(date);
        if (reportService.countDietMealReport(inputDate, uid) < MIN_MEAL_OF_DAY) {
            return CommonResultDTO.validateFailed();
        }

        Double[] energy = timelineService.getDailyEnergy(uid, inputDate);
        if (energy == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(energy);
    }


    @ApiOperation("个人: 查看一天能量变化")
    @RequestMapping(value = "/energy/weekly/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getWeeklyEnergy(@RequestParam String date, @PathVariable Integer uid) {

        Date inputDate = DateUtil.parseDate(date);
        if (reportService.countDietDailyReport(inputDate, uid) < MIN_MEAL_OF_DAY) {
            return CommonResultDTO.validateFailed();
        }

        Double[] energy = timelineService.getDailyEnergy(uid, inputDate);
        if (energy == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(energy);
    }


    @ApiOperation("个人: 查看一天饮食评价变化")
    @RequestMapping(value = "/evaluation/daily/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getDailyEvaluation(@RequestParam String date, @PathVariable Integer uid) {
        Date inputDate = DateUtil.parseDate(date);
        if (reportService.countDietMealReport(inputDate, uid) < MIN_MEAL_OF_DAY) {
            return CommonResultDTO.validateFailed();
        }

        Integer[] evaluation = timelineService.getDailyEnergyEvaluation(uid, inputDate);
        if (evaluation == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(evaluation);
    }


}
