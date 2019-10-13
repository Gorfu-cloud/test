package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.common.utils.DateUtils;
import com.bkit.fatdown.entity.TbDietDailyReport;
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

    private final static Integer WEEKLY = 7;

    /**
     * 获取每天能量
     *
     * @param uid  用户id
     * @param date 日期
     * @return 当天三餐能量
     */
    @Override
    public Double[] getDailyEnergy(Integer uid, Date date) {

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
     * 获取每天结构评价
     *
     * @param uid  用户id
     * @param date 当周日期
     * @return 当周能量评价
     */
    @Override
    public Integer[] getDailyStructureEvaluation(Integer uid, Date date) {
        Integer[] evaluations = new Integer[3];

        int dinnerType = 2;

        for (int i = 0; i <= dinnerType; i++) {
            TbDietMealReport report = reportService.getDietMealReport(date, i, uid);
            if (report != null) {
                evaluations[i] = report.getStructureEvaluation();
            }
        }

        return evaluations;
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
        Date start = DateUtils.getCurrentWeekStart(date);

        map.put("breakfast", getEnergyByType(start, WEEKLY, uid, BREAKFAST));
        map.put("lunch", getEnergyByType(start, WEEKLY, uid, LUNCH));
        map.put("dinner", getEnergyByType(start, WEEKLY, uid, DINNER));

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
        Date start = DateUtils.getCurrentWeekStart(date);

        map.put("breakfast", getEvaluationByType(start, WEEKLY, uid, BREAKFAST));
        map.put("lunch", getEvaluationByType(start, WEEKLY, uid, LUNCH));
        map.put("dinner", getEvaluationByType(start, WEEKLY, uid, DINNER));

        return map;
    }

    /**
     * 获取当周结构评价
     *
     * @param uid  用户id
     * @param date 当周日期
     * @return 当周能量评价
     */
    @Override
    public Map<String, Integer[]> getWeeklyStructureEvaluation(Integer uid, Date date) {
        Map<String, Integer[]> map = new HashMap<>(3);

        // 获取日期循环
        Date start = DateUtils.getCurrentWeekStart(date);

        map.put("breakfast", getStructureEvaluationByType(start, WEEKLY, uid, BREAKFAST));
        map.put("lunch", getStructureEvaluationByType(start, WEEKLY, uid, LUNCH));
        map.put("dinner", getStructureEvaluationByType(start, WEEKLY, uid, DINNER));

        return map;
    }

    /**
     * 获取当月能量
     *
     * @param uid  用户id
     * @param date 当月日期
     * @return 当月能量
     */
    @Override
    public Map<String, Double[]> getMonthEnergy(Integer uid, Date date) {
        Map<String, Double[]> map = new HashMap<>(3);

        // 获取日期循环
        Date start = DateUtils.getMonthStartDate(date);
        int daysOfMonth = DateUtils.getDaysOfMonth(start);

        map.put("breakfast", getEnergyByType(start, daysOfMonth, uid, BREAKFAST));
        map.put("lunch", getEnergyByType(start, daysOfMonth, uid, LUNCH));
        map.put("dinner", getEnergyByType(start, daysOfMonth, uid, DINNER));

        return map;
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
        Map<String, Integer[]> map = new HashMap<>(3);

        // 获取日期循环
        Date start = DateUtils.getMonthStartDate(date);
        int daysOfMonth = DateUtils.getDaysOfMonth(start);

        map.put("breakfast", getEvaluationByType(start, daysOfMonth, uid, BREAKFAST));
        map.put("lunch", getEvaluationByType(start, daysOfMonth, uid, LUNCH));
        map.put("dinner", getEvaluationByType(start, daysOfMonth, uid, DINNER));

        return map;
    }

    /**
     * 获取当月结构评价
     *
     * @param uid  用户id
     * @param date 当月日期
     * @return 当月能量评价
     */
    @Override
    public Map<String, Integer[]> getMonthStructureEvaluation(Integer uid, Date date) {
        Map<String, Integer[]> map = new HashMap<>(3);

        // 获取日期循环
        Date start = DateUtils.getMonthStartDate(date);
        int daysOfMonth = DateUtils.getDaysOfMonth(start);

        map.put("breakfast", getStructureEvaluationByType(start, daysOfMonth, uid, BREAKFAST));
        map.put("lunch", getStructureEvaluationByType(start, daysOfMonth, uid, LUNCH));
        map.put("dinner", getStructureEvaluationByType(start, daysOfMonth, uid, DINNER));

        return map;
    }

    /**
     * 获取当周主要营养素
     *
     * @param uid  用户id
     * @param date 当周日期
     * @return 当周营养素
     */
    @Override
    public Map<String, Double[]> getWeeklyNutrients(Integer uid, Date date) {
        // 获取日期循环
        Date start = DateUtils.getCurrentWeekStart(date);

        return getNutrients(start, WEEKLY, uid);
    }

    /**
     * 获取当月主要营养素
     *
     * @param uid  用户id
     * @param date 当月日期
     * @return 当月营养素
     */
    @Override
    public Map<String, Double[]> getMonthNutrients(Integer uid, Date date) {
        // 获取日期循环
        Date start = DateUtils.getMonthStartDate(date);
        int daysOfMonth = DateUtils.getDaysOfMonth(start);

        return getNutrients(start, daysOfMonth, uid);
    }

    /**
     * 获取当周主要营养素评价
     *
     * @param uid  用户id
     * @param date 当周日期
     * @return 当周营养素评价
     */
    @Override
    public Map<String, Integer[]> getWeeklyNutrientsEvaluation(Integer uid, Date date) {
        // 获取日期循环
        Date start = DateUtils.getCurrentWeekStart(date);

        return getNutrientsEvaluation(start, WEEKLY, uid);
    }

    /**
     * 获取当月主要营养素评价
     *
     * @param uid  用户id
     * @param date 当月日期
     * @return 当月营养素评价
     */
    @Override
    public Map<String, Integer[]> getMonthNutrientsEvaluation(Integer uid, Date date) {
        // 获取日期循环
        Date start = DateUtils.getMonthStartDate(date);
        int daysOfMonth = DateUtils.getDaysOfMonth(start);

        return getNutrientsEvaluation(start, daysOfMonth, uid);
    }

    /**
     * @param start      每周开始第一天
     * @param uid        用户编号
     * @param reportType 报告类型: 0 1 2 (早 午 晚 餐)
     * @return 一周摄入能量
     */
    private Double[] getEnergyByType(Date start, Integer size, Integer uid, Integer reportType) {

        Double[] result = new Double[size];
        TbDietMealReport report;
        for (int i = 0; i < size; i++) {
            report = reportService.getDietMealReport(start, reportType, uid);
            if (report != null) {
                result[i] = report.getRealEnergy();
            }
            start = DateUtils.getTomorrow(start);
        }

        return result;
    }

    /**
     * @param start      每周开始第一天
     * @param uid        用户编号
     * @param reportType 报告类型: 0 1 2 (早 午 晚 餐)
     * @return 一周饮食评价
     */
    private Integer[] getEvaluationByType(Date start, Integer size, Integer uid, Integer reportType) {

        Integer[] result = new Integer[size];

        TbDietMealReport report;
        for (int i = 0; i < size; i++) {
            report = reportService.getDietMealReport(start, reportType, uid);
            if (report != null) {
                result[i] = report.getEnergyEvaluation();
            }
            start = DateUtils.getTomorrow(start);
        }
        return result;
    }

    /**
     * @param start      每周开始第一天
     * @param uid        用户编号
     * @param reportType 报告类型: 0 1 2 (早 午 晚 餐)
     * @return 一周结构评价
     */
    private Integer[] getStructureEvaluationByType(Date start, Integer size, Integer uid, Integer reportType) {

        Integer[] result = new Integer[size];

        TbDietMealReport report;
        for (int i = 0; i < size; i++) {
            report = reportService.getDietMealReport(start, reportType, uid);
            if (report != null) {
                result[i] = report.getStructureEvaluation();
            }
            start = DateUtils.getTomorrow(start);
        }
        return result;
    }

    /**
     * @param start 开始第一天
     * @param uid   用户编号
     * @return 一周摄入主要营养素评价
     */
    private Map<String, Integer[]> getNutrientsEvaluation(Date start, Integer size, Integer uid) {

        Integer[] fat = new Integer[size];
        Integer[] col = new Integer[size];
        Integer[] fibrin = new Integer[size];
        Integer[] protein = new Integer[size];

        TbDietDailyReport report;
        for (int i = 0; i < size; i++) {
            report = reportService.getDietDailyReport(start, uid);
            if (report != null) {
                fat[i] = report.getFatEvaluation();
                col[i] = report.getColEvaluation();
                fibrin[i] = report.getFibrinEvaluation();
                protein[i] = report.getProteinEvaluation();
            }
            start = DateUtils.getTomorrow(start);
        }

        Map<String, Integer[]> map = new HashMap<>(4);

        map.put("fat", fat);
        map.put("protein", protein);
        map.put("fibrin", fibrin);
        map.put("col", col);

        return map;
    }

    /**
     * @param start 开始第一天
     * @param uid   用户编号
     * @return 一周摄入主要营养素评价
     */
    private Map<String, Double[]> getNutrients(Date start, Integer size, Integer uid) {

        Double[] fat = new Double[size];
        Double[] col = new Double[size];
        Double[] fibrin = new Double[size];
        Double[] protein = new Double[size];

        TbDietDailyReport report;
        for (int i = 0; i < size; i++) {
            report = reportService.getDietDailyReport(start, uid);
            if (report != null) {
                fat[i] = report.getFatPer();
                col[i] = report.getColPer();
                fibrin[i] = report.getFibrinPer();
                protein[i] = report.getProteinPer();
            }
            start = DateUtils.getTomorrow(start);
        }

        Map<String, Double[]> map = new HashMap<>(4);

        map.put("fat", fat);
        map.put("protein", protein);
        map.put("fibrin", fibrin);
        map.put("col", col);

        return map;
    }
}
