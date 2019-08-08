package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.*;
import com.bkit.fatdown.dto.diet.*;
import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.service.*;
import com.bkit.fatdown.utils.DataTransferUtils;
import com.bkit.fatdown.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
@Api(value = "/diet", tags = "饮食报告接口")
@RestController
@RequestMapping("/diet")
public class DietController {

    @Resource
    private IUserBasicInfoService basicInfoService;

    @Resource
    private IDietReportService reportService;

    @Resource
    private IDietRecordService dietRecordService;

    private static final int DATA_NOT_EXIST = 0;
    private static final int DATA_EXIST = 1;

    /**
     * 三餐记录数3
     * 报告类型：
     * 0,早餐，1，午餐，2，晚餐，3,加餐，
     * 4，每天，5,每周，6，每月
     */
    private static final int DAILY_REPORT_TOTAL = 3;
    private static final int WEEKLY_REPORT_MIN_TOTAL = 15;
    private static final int MOUTH_REPORT_MIN_TOTAL = 65;
    private static final int BREAKFAST_TYPE = 0;
    private static final int LUNCH_TYPE = 1;
    private static final int DINNER_TYPE = 2;
    private static final int DAILY_TYPE = 4;

    @ApiOperation("查看每天饮食报告,通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/getDailyReport", method = RequestMethod.GET)
    public CommonResultDTO<DietDailyReport> getDailyReportByUid(@RequestParam Integer uid, @RequestParam String date) {

        if (basicInfoService.countById(uid) == DATA_NOT_EXIST || date == null) {
            return CommonResultDTO.validateFailed("uid/date为空无效");
        }
        Date inputDate = DateUtils.string2Date(date);

        if (dietRecordService.countDietRecord(inputDate, uid) < DAILY_REPORT_TOTAL) {
            return CommonResultDTO.failed("数据不足,无法进行评价");
        }

        if (reportService.countDietDailyReport(inputDate, uid) >= DATA_EXIST) {
            TbDietDailyReport report = reportService.getDietDailyReport(inputDate, uid);
            if (report == null) {
                return CommonResultDTO.failed("记录为空");
            }
            return CommonResultDTO.success(DataTransferUtils.transferDailyReport(report));
        }

        // 生成每日饮食报告
        DietDailyReport dailyReport = reportService.generateDailyReport(inputDate, uid, DAILY_TYPE);

        if (dailyReport == null) {
            return CommonResultDTO.failed("数据为空");
        }

        return CommonResultDTO.success(dailyReport);
    }

    @ApiOperation("查看三餐饮食报告，通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/listDailyReport", method = RequestMethod.GET)
    public CommonResultDTO<List<DietMealReport>> listDailyReport(@RequestParam Integer uid, @RequestParam String date) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST || date == null) {
            return CommonResultDTO.validateFailed("uid无效");
        }

        DietMealReport breakfast, lunch, dinner;
        Date inputDate = DateUtils.string2Date(date);
        List<DietMealReport> reportList = new ArrayList<>(DAILY_REPORT_TOTAL);

        // 存在饮食报告
        if (reportService.countDietMealReport(inputDate, BREAKFAST_TYPE, uid) >= DATA_EXIST) {
            TbDietMealReport report = reportService.getDietMealReport(inputDate, BREAKFAST_TYPE, uid);
            breakfast = DataTransferUtils.transferDietMealReport(report);
        } else {
            breakfast = reportService.generateMealReport(inputDate, uid, BREAKFAST_TYPE);
        }

        // 存在饮食报告
        if (reportService.countDietMealReport(inputDate, LUNCH_TYPE, uid) >= DATA_EXIST) {
            TbDietMealReport report = reportService.getDietMealReport(inputDate, LUNCH_TYPE, uid);
            lunch = DataTransferUtils.transferDietMealReport(report);
        } else {
            lunch = reportService.generateMealReport(inputDate, uid, LUNCH_TYPE);
        }

        // 存在饮食报告
        if (reportService.countDietMealReport(inputDate, DINNER_TYPE, uid) >= DATA_EXIST) {
            TbDietMealReport report = reportService.getDietMealReport(inputDate, DINNER_TYPE, uid);
            dinner = DataTransferUtils.transferDietMealReport(report);
        } else {
            dinner = reportService.generateMealReport(inputDate, uid, DINNER_TYPE);
        }

        reportList.add(breakfast);
        reportList.add(lunch);
        reportList.add(dinner);

        return CommonResultDTO.success(reportList);
    }

    @ApiOperation("查看每周饮食报告,通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/getWeeklyReport", method = RequestMethod.GET)
    public CommonResultDTO<DietWeeklyReport> getWeeklyReport(@RequestParam Integer uid, @RequestParam String date) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST || date == null) {
            return CommonResultDTO.validateFailed("uid无效");
        }

        Date inputDate = DateUtils.string2Date(date);

//        if (reportService.countWeeklyReport(inputDate, uid) >= DATA_EXIST) {
//            DietWeeklyReport report = DataTransferUtils.transferWeeklyReport(reportService.getDietWeeklyReport(inputDate, uid));
//            if (report == null) {
//                return CommonResultDTO.failed("获取报告失败");
//            }
//            return CommonResultDTO.success(report);
//        }
//
//        // 少于15次报告，无法生成数据
//        if (reportService.countDietMealReport(inputDate, uid) < WEEKLY_REPORT_MIN_TOTAL) {
//            return CommonResultDTO.failed("用餐数据少于15餐，无法生成有效数据");
//        }

        // 生成每周报告记录
        DietWeeklyReport report = reportService.generateWeeklyReport(inputDate, uid);
        // 如果报告为空，返回错误
        if (report == null) {
            return CommonResultDTO.failed("报告为空！");
        }

        return CommonResultDTO.success(report);
    }

    @ApiOperation("查看每月饮食报告,通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/getMonthlyReport", method = RequestMethod.GET)
    public CommonResultDTO<DietMonthReport> getMonthlyReportByUid(@RequestParam Integer uid, @RequestParam String date) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST || date == null) {
            return CommonResultDTO.validateFailed("uid无效");
        }

        Date inputDate = DateUtils.string2Date(date);

        // 少于65次报告，无法生成数据
        if (reportService.countDietMealReport(inputDate, uid) < MOUTH_REPORT_MIN_TOTAL) {
            return CommonResultDTO.failed("用餐数据少于65餐，无法生成有效数据");
        }

        // 存在报告记录，直接返回记录

        // 生成每月报告记录

        // 如果报告为空，返回错误

        return CommonResultDTO.success(new DietMonthReport());
    }

    @ApiOperation("查看早餐饮食报告,通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/getBreakfastReport", method = RequestMethod.GET)
    public CommonResultDTO<DietMealReport> getBreakfastReport(@RequestParam Integer uid, @RequestParam String date) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST || date == null) {
            return CommonResultDTO.validateFailed("uid/date无效");
        }

        Date inputDate = DateUtils.string2Date(date);

        // 存在饮食报告
        if (reportService.countDietMealReport(inputDate, BREAKFAST_TYPE, uid) >= DATA_EXIST) {
            TbDietMealReport report = reportService.getDietMealReport(inputDate, BREAKFAST_TYPE, uid);
            if (report == null) {
                return CommonResultDTO.failed("记录为空");
            }
            return CommonResultDTO.success(DataTransferUtils.transferDietMealReport(report));
        }

        // 数据不存在时
        if (dietRecordService.countDietRecord(inputDate, uid, BREAKFAST_TYPE) == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("暂无数据");
        }

        return CommonResultDTO.success(reportService.generateMealReport(inputDate, uid, BREAKFAST_TYPE));
    }

    @ApiOperation("查看午餐饮食报告,通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/getLunchReport", method = RequestMethod.GET)
    public CommonResultDTO<DietMealReport> getLunchReport(@RequestParam Integer uid, @RequestParam String date) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("uid无效");
        }
        Date inputDate = DateUtils.string2Date(date);

        // 存在饮食报告
        if (reportService.countDietMealReport(inputDate, LUNCH_TYPE, uid) >= DATA_EXIST) {
            TbDietMealReport report = reportService.getDietMealReport(inputDate, LUNCH_TYPE, uid);
            if (report == null) {
                return CommonResultDTO.failed("记录为空");
            }
            return CommonResultDTO.success(DataTransferUtils.transferDietMealReport(report));
        }

        // 数据不存在时
        if (dietRecordService.countDietRecord(inputDate, uid, LUNCH_TYPE) == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("暂无数据");
        }

        return CommonResultDTO.success(reportService.generateMealReport(inputDate, uid, LUNCH_TYPE));
    }

    @ApiOperation("查看晚餐饮食报告,通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/getDinnerReport", method = RequestMethod.GET)
    public CommonResultDTO<DietMealReport> getDinnerReport(@RequestParam Integer uid, @RequestParam String date) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("uid无效");
        }

        Date inputDate = DateUtils.string2Date(date);

        // 存在饮食报告
        if (reportService.countDietMealReport(inputDate, DINNER_TYPE, uid) >= DATA_EXIST) {
            TbDietMealReport report = reportService.getDietMealReport(inputDate, DINNER_TYPE, uid);
            if (report == null) {
                return CommonResultDTO.failed("记录为空");
            }
            return CommonResultDTO.success(DataTransferUtils.transferDietMealReport(report));
        }

        // 数据不存在时
        if (dietRecordService.countDietRecord(inputDate, uid, DINNER_TYPE) == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("暂无数据");
        }

        return CommonResultDTO.success(reportService.generateMealReport(inputDate, uid, DINNER_TYPE));
    }
}
