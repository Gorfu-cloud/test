package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.*;
import com.bkit.fatdown.dto.diet.*;
import com.bkit.fatdown.entity.TbFoodRecord;
import com.bkit.fatdown.service.*;
import com.bkit.fatdown.common.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Api(value = "/report", tags = "饮食报告模块")
@RestController
@RequestMapping("/report")
public class ReportController {

    @Resource
    private IUserBasicInfoService basicInfoService;

    @Resource
    private IDietReportService reportService;

    @Resource
    private IDietFoodService foodService;

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

    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

    @ApiOperation("查看早餐饮食报告,通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/breakfast/{uid}", method = RequestMethod.GET)
    public CommonResultDTO<DietMealReport> getBreakfastReport(@PathVariable Integer uid, @RequestParam String date) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST || date.isEmpty()) {
            return CommonResultDTO.validateFailed("uid/date无效");
        }

        Date inputDate = DateUtils.string2Date(date);

        // 饮食数据不存在时
        if (dietRecordService.countDietRecord(inputDate, uid, BREAKFAST_TYPE) == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("暂无数据");
        }

        return CommonResultDTO.success(reportService.generateMealReport(inputDate, uid, BREAKFAST_TYPE));
    }

    @ApiOperation("查看午餐饮食报告,通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/lunch/{uid}", method = RequestMethod.GET)
    public CommonResultDTO<DietMealReport> getLunchReport(@PathVariable Integer uid, @RequestParam String date) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("uid无效");
        }
        Date inputDate = DateUtils.string2Date(date);

        // 数据不存在时
        if (dietRecordService.countDietRecord(inputDate, uid, LUNCH_TYPE) == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("暂无数据");
        }

        return CommonResultDTO.success(reportService.generateMealReport(inputDate, uid, LUNCH_TYPE));
    }

    @ApiOperation("查看晚餐饮食报告,通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/dinner/{uid}", method = RequestMethod.GET)
    public CommonResultDTO<DietMealReport> getDinnerReport(@PathVariable Integer uid, @RequestParam String date) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("uid无效");
        }

        Date inputDate = DateUtils.string2Date(date);

        // 数据不存在时
        if (dietRecordService.countDietRecord(inputDate, uid, DINNER_TYPE) == DATA_NOT_EXIST) {
            return CommonResultDTO.failed("暂无数据");
        }

        return CommonResultDTO.success(reportService.generateMealReport(inputDate, uid, DINNER_TYPE));
    }

    @ApiOperation("查看三餐饮食报告，通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/meals/{uid}", method = RequestMethod.GET)
    public CommonResultDTO<List<DietMealReport>> listDailyReport(@PathVariable Integer uid, @RequestParam String date) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST || date.isEmpty()) {
            return CommonResultDTO.validateFailed("uid无效");
        }

        DietMealReport breakfast, lunch, dinner;
        Date inputDate = DateUtils.string2Date(date);
        List<DietMealReport> reportList = new ArrayList<>(DAILY_REPORT_TOTAL);

        if (dietRecordService.countDietRecord(inputDate, uid, BREAKFAST_TYPE) == DATA_NOT_EXIST) {
            breakfast = null;
        } else {
            breakfast = reportService.generateMealReport(inputDate, uid, BREAKFAST_TYPE);
        }

        if (dietRecordService.countDietRecord(inputDate, uid, LUNCH_TYPE) == DATA_NOT_EXIST) {
            lunch = null;
        } else {
            lunch = reportService.generateMealReport(inputDate, uid, LUNCH_TYPE);
        }

        if (dietRecordService.countDietRecord(inputDate, uid, DINNER_TYPE) == DATA_NOT_EXIST) {
            dinner = null;
        } else {
            dinner = reportService.generateMealReport(inputDate, uid, DINNER_TYPE);
        }

        reportList.add(breakfast);
        reportList.add(lunch);
        reportList.add(dinner);

        return CommonResultDTO.success(reportList);
    }

    @ApiOperation("查看每天饮食报告,通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/day/{uid}", method = RequestMethod.GET)
    public CommonResultDTO<DietDailyReport> getDailyReportByUid(@PathVariable Integer uid, @RequestParam String date) {

        if (basicInfoService.countById(uid) == DATA_NOT_EXIST || date.isEmpty()) {
            return CommonResultDTO.validateFailed("uid/date为空无效");
        }
        Date inputDate = DateUtils.string2Date(date);

        // 饮食数据不满足三次，无法进行评价
        if (dietRecordService.countDietRecord(inputDate, uid) < DAILY_REPORT_TOTAL) {
            return CommonResultDTO.failed("数据不足,无法进行评价");
        }

//        if (reportService.countDietDailyReport(inputDate, uid) >= DATA_EXIST) {
//            TbDietDailyReport report = reportService.getDietDailyReport(inputDate, uid);
//            if (report == null) {
//                return CommonResultDTO.failed("记录为空");
//            }
//            return CommonResultDTO.success(DataTransferUtils.transferDailyReport(report));
//        }

        // 生成每日饮食报告
        DietDailyReport dailyReport = reportService.generateDailyReport(inputDate, uid);

        if (dailyReport == null) {
            return CommonResultDTO.failed("数据为空");
        }

        return CommonResultDTO.success(dailyReport);
    }

    @ApiOperation("查看每周饮食报告,通过uid，date")
    @CrossOrigin
    @RequestMapping(value = "/week/{uid}", method = RequestMethod.GET)
    public CommonResultDTO<DietWeeklyReport> getWeeklyReport(@PathVariable Integer uid, @RequestParam String date) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST || date.isEmpty()) {
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

        // 少于15次报告，无法生成数据
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
    @RequestMapping(value = "/month/{uid}", method = RequestMethod.GET)
    public CommonResultDTO<DietMonthReport> getMonthlyReportByUid(@PathVariable Integer uid, @RequestParam String date) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST || date.isEmpty()) {
            return CommonResultDTO.validateFailed("uid无效");
        }

        Date inputDate = DateUtils.string2Date(date);

        //  少于65次报告，无法生成数据
        if (reportService.countDietMealReport(inputDate, uid) < MOUTH_REPORT_MIN_TOTAL) {
            return CommonResultDTO.failed("用餐数据少于65餐，无法生成有效数据");
        }

        // 存在报告记录，直接返回记录

        // 生成每月报告记录
        DietMonthReport report = reportService.generateMonthReport(inputDate, uid);

        // 如果报告为空，返回错误
        if(report==null){
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(report);
    }

    @ApiOperation("查看每周评价报告是否存在")
    @CrossOrigin
    @RequestMapping(value = "/weekCount/{uid}", method = RequestMethod.GET)
    public CommonResultDTO countWeeklyReport(@PathVariable Integer uid, @RequestParam String date) {
        Date inputDate = DateUtils.string2Date(date);

        if (basicInfoService.countById(uid) == DATA_NOT_EXIST || date.isEmpty()) {
            return CommonResultDTO.validateFailed("uid无效");
        }

        if (reportService.countWeeklyReport(inputDate, uid) >= DATA_EXIST) {
            return CommonResultDTO.success(reportService.countWeeklyReport(inputDate, uid) >= DATA_EXIST);
        }

        return CommonResultDTO.success(dietRecordService.countWeeklyDietRecord(inputDate, uid) >= WEEKLY_REPORT_MIN_TOTAL);
    }


    @ApiOperation("根据饮食记录获取对应的报告")
    @CrossOrigin
    @RequestMapping(value = "/meal/{recordId}", method = RequestMethod.GET)
    public CommonResultDTO getMealsReportByType(@PathVariable Integer recordId) {
        if (recordId == null || foodService.count(recordId) == 0) {
            return CommonResultDTO.validateFailed();
        }

        TbFoodRecord foodRecord = foodService.getFoodRecord(recordId);

        int type = DateUtils.getMealType(foodRecord.getGmtCreate());
        DietMealReport report = reportService.generateMealReport(foodRecord.getGmtCreate(), foodRecord.getUserId(), type);

        if (report == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(report);
    }
}
