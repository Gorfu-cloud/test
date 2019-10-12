package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.common.utils.DateUtils;
import com.bkit.fatdown.entity.TbDietMealReport;
import com.bkit.fatdown.service.IDietReportService;
import com.bkit.fatdown.service.ITimelineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @file: TimelineServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 数据时间轴功能接口
 * @date: Created in 9/17/19  10:32 AM
 * @modified:
 * @version: 1.0
 */
@Service
public class TimelineServiceImpl implements ITimelineService {

    @Resource
    private IDietReportService reportService;

    private final static Integer BREAKFAST = 0;
    private final static Integer LUNCH = 1;
    private final static Integer DINNER = 2;

    /**
     * 获取每天能量
     *
     * @param uid  用户id
     * @param date 日期
     * @return 当天三餐能量
     */
    @Override
    public Double[] getDailyEnergy(Integer uid, Date date) {

        if (reportService.countDietMealReport(DateUtils.getDateStart(date), DateUtils.getDateEnd(date), uid) == 0) {
            return null;
        }

        Double[] meals = new Double[3];

        int dinnerType = 2;

        for (int i = 0; i <= dinnerType; i++) {
            TbDietMealReport report = reportService.getDietMealReport(date, i, uid);
            if (report != null) {
                meals[i] = report.getRealEnergy();
            }
        }

        return meals;
    }

    /**
     * 获取每天能量评价
     *
     * @param uid  用户id
     * @param date 日期
     * @return 当天三餐能量评价
     */
    @Override
    public Integer[] getDailyEnergyEvaluation(Integer uid, Date date) {

        if (reportService.countDietMealReport(DateUtils.getDateStart(date), DateUtils.getDateEnd(date), uid) == 0) {
            return null;
        }

        Integer[] evaluations = new Integer[3];

        int dinnerType = 2;

        for (int i = 0; i <= dinnerType; i++) {
            TbDietMealReport report = reportService.getDietMealReport(date, i, uid);
            if (report != null) {
                evaluations[i] = report.getEnergyEvaluation();
            }
        }

        return evaluations;
    }

    /**
     * 获取每周能量
     *
     * @param uid  用户id
     * @param date 当周日期
     * @return 当周能量
     */
    @Override
    public Map<String, Double[]> getWeeklyEnergy(Integer uid, Date date) {
        Map<String, Double[]> map = new HashMap<>(3);

        // 获取日期循环
        Date weekStart = DateUtils.getCurrentWeekStart(date);

        map.put("breakfast", getWeeklyEnergyByType(weekStart, uid, BREAKFAST));
        map.put("lunch", getWeeklyEnergyByType(weekStart, uid, LUNCH));
        map.put("dinner", getWeeklyEnergyByType(weekStart, uid, DINNER));

        return map;
    }


    /**
     * 获取当周能量评价
     *
     * @param uid  用户id
     * @param date 当周日期
     * @return 当周能量评价
     */
    @Override
    public Map<String, Integer[]> getWeeklyEnergyEvaluation(Integer uid, Date date) {
        Map<String, Integer[]> map = new HashMap<>(3);

        // 获取日期循环
        Date weekStart = DateUtils.getCurrentWeekStart(date);

        map.put("breakfast", getWeeklyEvaluationByType(weekStart, uid, BREAKFAST));
        map.put("lunch", getWeeklyEvaluationByType(weekStart, uid, LUNCH));
        map.put("dinner", getWeeklyEvaluationByType(weekStart, uid, DINNER));

        return map;
    }

    @Override
    public Map<String,Integer[]> getWeeklyStructureEvaluation(Integer uid, Date date) {
        Map<String, Integer[]> map = new HashMap<>(3);

        // 获取日期循环
        Date weekStart = DateUtils.getCurrentWeekStart(date);

        map.put("breakfast", getWeeklyStructureEvaluationByType(weekStart, uid, BREAKFAST));
        map.put("lunch", getWeeklyStructureEvaluationByType(weekStart, uid, LUNCH));
        map.put("dinner", getWeeklyStructureEvaluationByType(weekStart, uid, DINNER));

        return map;
    }

    /**
     * 获取当月能量评价
     *
     * @param uid  用户id
     * @param date 当月日期
     * @return 当月能量
     */
    @Override
    public Map<String, Double[]> getMonthEnergy(Integer uid, Date date) {
        return null;
    }

    /**
     * 获取当月能量评价
     *
     * @param uid  用户id
     * @param date 当月日期
     * @return 当月能量评价
     */
    @Override
    public Map<String, Integer[]> getMonthEnergyEvaluation(Integer uid, Date date) {
        return null;
    }

    /**
     * 获取每周隐私数据
     *
     * @param uid  用户id
     * @param date 当周日期
     * @return 一周的隐私数据
     */
    @Override
    public Map<String, Object> getWeeklyPrivacyInfo(Integer uid, Date date) {
        return null;
    }


    /**
     *
     * @param start 每周开始第一天
     * @param uid 用户编号
     * @param reportType 报告类型: 0 1 2 (早 午 晚 餐)
     * @return 一周摄入能量
     */
    private Double[] getWeeklyEnergyByType(Date start, Integer uid, Integer reportType) {

        Double[] result = new Double[7];
        TbDietMealReport report;
        for (int i = 0; i < 7; i++) {
            report = reportService.getDietMealReport(start, reportType, uid);
            if (report != null) {
                result[i] = report.getRealEnergy();
            }
            start = DateUtils.getTomorrow(start);
        }

        return result;
    }

    /**
     *
     * @param start 每周开始第一天
     * @param uid 用户编号
     * @param reportType 报告类型: 0 1 2 (早 午 晚 餐)
     * @return 一周饮食评价
     */
    private Integer[] getWeeklyEvaluationByType(Date start, Integer uid, Integer reportType) {

        Integer[] result = new Integer[7];

        TbDietMealReport report;
        for (int i = 0; i < 7; i++) {
            report = reportService.getDietMealReport(start, reportType, uid);
            if (report != null) {
                result[i] = report.getEnergyEvaluation();
            }
            start = DateUtils.getTomorrow(start);
        }
        return result;
    }

    /**
     *
     * @param start 每周开始第一天
     * @param uid 用户编号
     * @param reportType 报告类型: 0 1 2 (早 午 晚 餐)
     * @return 一周结构评价
     */
    private Integer[] getWeeklyStructureEvaluationByType(Date start, Integer uid, Integer reportType) {

        Integer[] result = new Integer[7];

        TbDietMealReport report;
        for (int i = 0; i < 7; i++) {
            report = reportService.getDietMealReport(start, reportType, uid);
            if (report != null) {
                result[i] = report.getStructureEvaluation();
            }
            start = DateUtils.getTomorrow(start);
        }
        return result;
    }

}
