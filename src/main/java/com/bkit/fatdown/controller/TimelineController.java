package com.bkit.fatdown.controller;

import cn.hutool.core.date.DateUtil;
import com.bkit.fatdown.common.utils.DateUtils;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.service.IDietReportService;
import com.bkit.fatdown.service.ITimelineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

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
    private final static Integer MIN_MEAL_OF_WEEKLY = 15;
    // 为了测试
    private final static Integer MIN_MEAL_OF_MONTHLY = 15;

    private final static Integer MIN_DAY_OF_WEEKLY = 5;
    private final static Integer MIN_DAY_OF_MONTHLY = 22;

    @ApiOperation("个人: 查看每天能量变化")
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

    @ApiOperation("个人: 查看每周能量变化")
    @RequestMapping(value = "/energy/weekly/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getWeeklyEnergy(@RequestParam String date, @PathVariable Integer uid) {
        Date inputDate = DateUtil.parseDate(date);
        if (reportService.countDietMealReport(DateUtils.getCurrentWeekStart(inputDate),
                DateUtils.getCurrentWeekEnd(inputDate), uid) < MIN_MEAL_OF_WEEKLY) {
            return CommonResultDTO.validateFailed();
        }

        Map<String, Double[]> evaluation = timelineService.getWeeklyEnergy(uid, inputDate);
        if (evaluation == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(evaluation);
    }

    @ApiOperation("个人: 查看每月能量变化(压缩)")
    @RequestMapping(value = "/energy/monthly/compress/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getCompressMonthlyEnergy(@RequestParam String date, @PathVariable Integer uid) {
        Date inputDate = DateUtil.parseDate(date);
        if (reportService.countDietMealReport(DateUtils.getMonthStartDate(inputDate),
                DateUtils.getNextMonthStartDate(inputDate), uid) < MIN_MEAL_OF_MONTHLY) {
            return CommonResultDTO.validateFailed();
        }

        Map<String, Double[]> evaluation = timelineService.getMonthEnergy(uid, inputDate, true);
        if (evaluation == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(evaluation);
    }

    @ApiOperation("个人: 查看每月能量变化")
    @RequestMapping(value = "/energy/monthly/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getMonthlyEnergy(@RequestParam String date, @PathVariable Integer uid) {
        Date inputDate = DateUtil.parseDate(date);
        if (reportService.countDietMealReport(DateUtils.getMonthStartDate(inputDate),
                DateUtils.getNextMonthStartDate(inputDate), uid) < MIN_MEAL_OF_MONTHLY) {
            return CommonResultDTO.validateFailed();
        }

        Map<String, Double[]> evaluation = timelineService.getMonthEnergy(uid, inputDate, false);
        if (evaluation == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(evaluation);
    }

    @ApiOperation("个人: 查看每天能量评价变化")
    @RequestMapping(value = "/evaluation/energy/daily/{uid}", method = RequestMethod.GET)
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

    @ApiOperation("个人: 查看每周能量评价变化")
    @RequestMapping(value = "/evaluation/energy/weekly/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getWeeklyEvaluation(@RequestParam String date, @PathVariable Integer uid) {
        Date inputDate = DateUtil.parseDate(date);
        if (reportService.countDietMealReport(DateUtils.getCurrentWeekStart(inputDate),
                DateUtils.getCurrentWeekEnd(inputDate), uid) < MIN_MEAL_OF_WEEKLY) {
            return CommonResultDTO.validateFailed();
        }

        Map<String, Integer[]> evaluation = timelineService.getWeeklyEnergyEvaluation(uid, inputDate);
        if (evaluation == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(evaluation);
    }

    @ApiOperation("个人: 查看每月能量评价变化(压缩)")
    @RequestMapping(value = "/evaluation/energy/monthly/compress{uid}", method = RequestMethod.GET)
    public CommonResultDTO getCompressMonthlyEvaluation(@RequestParam String date, @PathVariable Integer uid) {
        Date inputDate = DateUtil.parseDate(date);
        if (reportService.countDietMealReport(DateUtils.getMonthStartDate(inputDate),
                DateUtils.getNextMonthStartDate(inputDate), uid) < MIN_MEAL_OF_MONTHLY) {
            return CommonResultDTO.validateFailed();
        }

        Map<String, Integer[]> evaluation = timelineService.getMonthEnergyEvaluation(uid, inputDate, true);
        if (evaluation == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(evaluation);
    }

    @ApiOperation("个人: 查看每月能量评价变化")
    @RequestMapping(value = "/evaluation/energy/monthly/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getMonthlyEvaluation(@RequestParam String date, @PathVariable Integer uid) {
        Date inputDate = DateUtil.parseDate(date);
        if (reportService.countDietMealReport(DateUtils.getMonthStartDate(inputDate),
                DateUtils.getNextMonthStartDate(inputDate), uid) < MIN_MEAL_OF_MONTHLY) {
            return CommonResultDTO.validateFailed();
        }

        Map<String, Integer[]> evaluation = timelineService.getMonthEnergyEvaluation(uid, inputDate, false);
        if (evaluation == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(evaluation);
    }

    @ApiOperation("个人: 查看每天结构评价变化")
    @RequestMapping(value = "/evaluation/structure/daily/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getDailyStructureEvaluation(@RequestParam String date, @PathVariable Integer uid) {
        Date inputDate = DateUtil.parseDate(date);
        if (reportService.countDietMealReport(inputDate, uid) < MIN_MEAL_OF_DAY) {
            return CommonResultDTO.validateFailed();
        }

        Integer[] evaluation = timelineService.getDailyStructureEvaluation(uid, inputDate);

        if (evaluation == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(evaluation);
    }

    @ApiOperation("个人: 查看每周结构评价变化")
    @RequestMapping(value = "/evaluation/structure/weekly/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getWeeklyStructureEvaluation(@RequestParam String date, @PathVariable Integer uid) {
        Date inputDate = DateUtil.parseDate(date);
        if (reportService.countDietMealReport(DateUtils.getCurrentWeekStart(inputDate),
                DateUtils.getCurrentWeekEnd(inputDate), uid) < MIN_MEAL_OF_WEEKLY) {
            return CommonResultDTO.validateFailed();
        }

        Map<String, Integer[]> evaluation = timelineService.getWeeklyStructureEvaluation(uid, inputDate);
        if (evaluation == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(evaluation);
    }

    @ApiOperation("个人: 查看每月结构评价变化(压缩)")
    @RequestMapping(value = "/evaluation/structure/monthly/compress/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getCompressMonthlyStructureEvaluation(@RequestParam String date, @PathVariable Integer uid) {
        Date inputDate = DateUtil.parseDate(date);
        if (reportService.countDietMealReport(DateUtils.getMonthStartDate(inputDate),
                DateUtils.getNextMonthStartDate(inputDate), uid) < MIN_MEAL_OF_MONTHLY) {
            return CommonResultDTO.validateFailed();
        }

        Map<String, Integer[]> evaluation = timelineService.getMonthStructureEvaluation(uid, inputDate, true);
        if (evaluation == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(evaluation);
    }

    @ApiOperation("个人: 查看每月结构评价变化")
    @RequestMapping(value = "/evaluation/structure/monthly/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getMonthlyStructureEvaluation(@RequestParam String date, @PathVariable Integer uid) {
        Date inputDate = DateUtil.parseDate(date);
        if (reportService.countDietMealReport(DateUtils.getMonthStartDate(inputDate),
                DateUtils.getNextMonthStartDate(inputDate), uid) < MIN_MEAL_OF_MONTHLY) {
            return CommonResultDTO.validateFailed();
        }

        Map<String, Integer[]> evaluation = timelineService.getMonthStructureEvaluation(uid, inputDate, false);
        if (evaluation == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(evaluation);
    }

    @ApiOperation("个人: 查看每周营养素评价变化")
    @RequestMapping(value = "/evaluation/nutrients/weekly/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getWeeklyNutrientsEvaluation(@RequestParam String date, @PathVariable Integer uid) {
        Date inputDate = DateUtil.parseDate(date);
//        if (reportService.countDietDailyReport(DateUtils.getCurrentWeekStart(inputDate),
//                DateUtils.getCurrentWeekEnd(inputDate), uid) < MIN_DAY_OF_WEEKLY) {
//            return CommonResultDTO.validateFailed();
//        }

        Map<String, Integer[]> evaluation = timelineService.getWeeklyNutrientsEvaluation(uid, inputDate);
        if (evaluation == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(evaluation);
    }

    @ApiOperation("个人: 查看每月营养素评价变化")
    @RequestMapping(value = "/evaluation/nutrients/monthly/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getMonthlyNutrientsEvaluation(@RequestParam String date, @PathVariable Integer uid) {
        Date inputDate = DateUtil.parseDate(date);
//        if (reportService.countDietDailyReport(DateUtils.getMonthStartDate(inputDate),
//                DateUtils.getNextMonthStartDate(inputDate), uid) < MIN_DAY_OF_MONTHLY) {
//            return CommonResultDTO.validateFailed();
//        }

        Map<String, Integer[]> evaluation = timelineService.getMonthNutrientsEvaluation(uid, inputDate, false);
        if (evaluation == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(evaluation);
    }

    @ApiOperation("个人: 查看每月营养素评价变化(压缩)")
    @RequestMapping(value = "/evaluation/nutrients/monthly/compress/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getCompressMonthlyNutrientsEvaluation(@RequestParam String date, @PathVariable Integer uid) {
        Date inputDate = DateUtil.parseDate(date);
//        if (reportService.countDietDailyReport(DateUtils.getMonthStartDate(inputDate),
//                DateUtils.getNextMonthStartDate(inputDate), uid) < MIN_DAY_OF_MONTHLY) {
//            return CommonResultDTO.validateFailed();
//        }

        Map<String, Integer[]> evaluation = timelineService.getMonthNutrientsEvaluation(uid, inputDate, true);
        if (evaluation == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(evaluation);
    }

    @ApiOperation("个人: 查看每周营养素摄入变化")
    @RequestMapping(value = "/nutrients/weekly/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getWeeklyNutrients(@RequestParam String date, @PathVariable Integer uid) {
        Date inputDate = DateUtil.parseDate(date);
//        if (reportService.countDietDailyReport(DateUtils.getCurrentWeekStart(inputDate),
//                DateUtils.getCurrentWeekEnd(inputDate), uid) < MIN_DAY_OF_WEEKLY) {
//            return CommonResultDTO.validateFailed();
//        }

        Map<String, Double[]> evaluation = timelineService.getWeeklyNutrients(uid, inputDate);
        if (evaluation == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(evaluation);
    }

    @ApiOperation("个人: 查看每月营养素摄入变化")
    @RequestMapping(value = "/nutrients/monthly/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getMonthlyNutrients(@RequestParam String date, @PathVariable Integer uid) {
        Date inputDate = DateUtil.parseDate(date);
//        if (reportService.countDietDailyReport(DateUtils.getMonthStartDate(inputDate),
//                DateUtils.getNextMonthStartDate(inputDate), uid) < MIN_DAY_OF_MONTHLY) {
//            return CommonResultDTO.validateFailed();
//        }

        Map<String, Double[]> evaluation = timelineService.getMonthNutrients(uid, inputDate, false);
        if (evaluation == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(evaluation);
    }

    @ApiOperation("个人: 查看每月营养素摄入变化(压缩)")
    @RequestMapping(value = "/nutrients/monthly/compress/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getCompressMonthlyNutrients(@RequestParam String date, @PathVariable Integer uid) {
        Date inputDate = DateUtil.parseDate(date);
//        if (reportService.countDietDailyReport(DateUtils.getMonthStartDate(inputDate),
//                DateUtils.getNextMonthStartDate(inputDate), uid) < MIN_DAY_OF_MONTHLY) {
//            return CommonResultDTO.validateFailed();
//        }

        Map<String, Double[]> evaluation = timelineService.getMonthNutrients(uid, inputDate, true);
        if (evaluation == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(evaluation);
    }
}
