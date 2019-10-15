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

        map.put("breakfast", getEnergyByType(start, WEEKLY, uid, BREAKFAST, false));
        map.put("lunch", getEnergyByType(start, WEEKLY, uid, LUNCH, false));
        map.put("dinner", getEnergyByType(start, WEEKLY, uid, DINNER, false));

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

        map.put("breakfast", getEvaluationByType(start, WEEKLY, uid, BREAKFAST, false));
        map.put("lunch", getEvaluationByType(start, WEEKLY, uid, LUNCH, false));
        map.put("dinner", getEvaluationByType(start, WEEKLY, uid, DINNER, false));

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

        map.put("breakfast", getStructureEvaluationByType(start, WEEKLY, uid, BREAKFAST, false));
        map.put("lunch", getStructureEvaluationByType(start, WEEKLY, uid, LUNCH, false));
        map.put("dinner", getStructureEvaluationByType(start, WEEKLY, uid, DINNER, false));

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
    public Map<String, Double[]> getMonthEnergy(Integer uid, Date date, boolean isCompress) {
        Map<String, Double[]> map = new HashMap<>(3);

        // 获取日期循环
        Date start = DateUtils.getMonthStartDate(date);
        int daysOfMonth = DateUtils.getDaysOfMonth(start);

        map.put("breakfast", getEnergyByType(start, daysOfMonth, uid, BREAKFAST, isCompress));
        map.put("lunch", getEnergyByType(start, daysOfMonth, uid, LUNCH, isCompress));
        map.put("dinner", getEnergyByType(start, daysOfMonth, uid, DINNER, isCompress));

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
    public Map<String, Integer[]> getMonthEnergyEvaluation(Integer uid, Date date, boolean isCompress) {
        Map<String, Integer[]> map = new HashMap<>(3);

        // 获取日期循环
        Date start = DateUtils.getMonthStartDate(date);
        int daysOfMonth = DateUtils.getDaysOfMonth(start);

        map.put("breakfast", getEvaluationByType(start, daysOfMonth, uid, BREAKFAST, isCompress));
        map.put("lunch", getEvaluationByType(start, daysOfMonth, uid, LUNCH, isCompress));
        map.put("dinner", getEvaluationByType(start, daysOfMonth, uid, DINNER, isCompress));

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
    public Map<String, Integer[]> getMonthStructureEvaluation(Integer uid, Date date, boolean isCompress) {
        Map<String, Integer[]> map = new HashMap<>(3);

        // 获取日期循环
        Date start = DateUtils.getMonthStartDate(date);
        int daysOfMonth = DateUtils.getDaysOfMonth(start);

        map.put("breakfast", getStructureEvaluationByType(start, daysOfMonth, uid, BREAKFAST, isCompress));
        map.put("lunch", getStructureEvaluationByType(start, daysOfMonth, uid, LUNCH, isCompress));
        map.put("dinner", getStructureEvaluationByType(start, daysOfMonth, uid, DINNER, isCompress));

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

        return getNutrients(start, WEEKLY, uid, false);
    }

    /**
     * 获取当月主要营养素
     *
     * @param uid  用户id
     * @param date 当月日期
     * @return 当月营养素
     */
    @Override
    public Map<String, Double[]> getMonthNutrients(Integer uid, Date date, boolean isCompress) {
        // 获取日期循环
        Date start = DateUtils.getMonthStartDate(date);
        int daysOfMonth = DateUtils.getDaysOfMonth(start);

        return getNutrients(start, daysOfMonth, uid, isCompress);
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

        return getNutrientsEvaluation(start, WEEKLY, uid, false);
    }

    /**
     * 获取当月主要营养素评价
     *
     * @param uid  用户id
     * @param date 当月日期
     * @return 当月营养素评价
     */
    @Override
    public Map<String, Integer[]> getMonthNutrientsEvaluation(Integer uid, Date date, boolean isCompress) {
        // 获取日期循环
        Date start = DateUtils.getMonthStartDate(date);
        int daysOfMonth = DateUtils.getDaysOfMonth(start);

        return getNutrientsEvaluation(start, daysOfMonth, uid, isCompress);
    }

    /**
     * @param start      第一天
     * @param uid        用户编号
     * @param reportType 报告类型: 0 1 2 (早 午 晚 餐)
     * @return 一周摄入能量
     */
    private Double[] getEnergyByType(Date start, Integer size, Integer uid, Integer reportType, boolean isCompress) {

        Double[] result = new Double[size];
        TbDietMealReport report;
        for (int i = 0; i < size; i++) {
            if (reportService.countDietMealReport(start, reportType, uid) > 0) {
                report = reportService.getDietMealReport(start, reportType, uid);
                result[i] = report.getRealEnergy();
            }
            start = DateUtils.getTomorrow(start);
        }

        return isCompress ? compress(result) : result;
    }

    /**
     * @param start      每周开始第一天
     * @param uid        用户编号
     * @param reportType 报告类型: 0 1 2 (早 午 晚 餐)
     * @return 一周饮食评价
     */
    private Integer[] getEvaluationByType(Date start, Integer size, Integer uid, Integer reportType, boolean isCompress) {

        Integer[] result = new Integer[size];

        TbDietMealReport report;
        for (int i = 0; i < size; i++) {
            if (reportService.countDietMealReport(start, reportType, uid) > 0) {
                report = reportService.getDietMealReport(start, reportType, uid);
                result[i] = report.getEnergyEvaluation();
            }
            start = DateUtils.getTomorrow(start);
        }

        return isCompress ? compress(result) : result;
    }

    /**
     * @param start      每周开始第一天
     * @param uid        用户编号
     * @param reportType 报告类型: 0 1 2 (早 午 晚 餐)
     * @return 一周结构评价
     */
    private Integer[] getStructureEvaluationByType(Date start, Integer size, Integer uid, Integer reportType, boolean isCompress) {

        Integer[] result = new Integer[size];

        TbDietMealReport report;
        for (int i = 0; i < size; i++) {
            if (reportService.countDietMealReport(start, reportType, uid) > 0) {
                report = reportService.getDietMealReport(start, reportType, uid);
                result[i] = report.getStructureEvaluation();
            }
            start = DateUtils.getTomorrow(start);
        }

        return isCompress ? compress(result) : result;
    }

    /**
     * @param start 开始第一天
     * @param uid   用户编号
     * @return 一周摄入主要营养素评价
     */
    private Map<String, Integer[]> getNutrientsEvaluation(Date start, Integer size, Integer uid, boolean isCompress) {

        Integer[] fat = new Integer[size];
        Integer[] col = new Integer[size];
        Integer[] fibrin = new Integer[size];
        Integer[] protein = new Integer[size];

        TbDietDailyReport report;
        for (int i = 0; i < size; i++) {
            if (reportService.countDietDailyReport(start, uid) > 0) {
                report = reportService.getDietDailyReport(start, uid);

                fat[i] = report.getFatEvaluation();
                col[i] = report.getColEvaluation();
                fibrin[i] = report.getFibrinEvaluation();
                protein[i] = report.getProteinEvaluation();
            }
            start = DateUtils.getTomorrow(start);
        }

        Map<String, Integer[]> map = new HashMap<>(4);

        if (isCompress) {
            map.put("fat", compress(fat));
            map.put("protein", compress(protein));
            map.put("fibrin", compress(fibrin));
            map.put("col", compress(col));
        } else {
            map.put("fat", fat);
            map.put("protein", protein);
            map.put("fibrin", fibrin);
            map.put("col", col);
        }

        return map;
    }

    /**
     * @param start 开始第一天
     * @param uid   用户编号
     * @return 一周摄入主要营养素评价
     */
    private Map<String, Double[]> getNutrients(Date start, Integer size, Integer uid, boolean isCompress) {

        Double[] fat = new Double[size];
        Double[] col = new Double[size];
        Double[] fibrin = new Double[size];
        Double[] protein = new Double[size];

        TbDietDailyReport report;
        for (int i = 0; i < size; i++) {
            if (reportService.countDietDailyReport(start, uid) > 0) {
                report = reportService.getDietDailyReport(start, uid);

                fat[i] = report.getFatPer();
                col[i] = report.getColPer();
                fibrin[i] = report.getFibrinPer();
                protein[i] = report.getProteinPer();
            }
            start = DateUtils.getTomorrow(start);
        }

        Map<String, Double[]> map = new HashMap<>(4);

        if (isCompress) {
            map.put("fat", compress(fat));
            map.put("protein", compress(protein));
            map.put("fibrin", compress(fibrin));
            map.put("col", compress(col));
        } else {
            map.put("fat", fat);
            map.put("protein", protein);
            map.put("fibrin", fibrin);
            map.put("col", col);
        }

        return map;
    }

    /**
     * 将每三个数据整合为一个数据
     *
     * @param input 输入数据
     * @return 整合后数据
     */
    private Integer[] compress(Integer[] input) {
        int size = input.length / 3;
        Integer[] num = new Integer[size];
        Integer[] arr;

        for (int i = 0; i < size; i += 3) {
            arr = new Integer[3];
            arr[0] = input[i];
            arr[1] = input[i + 1];
            arr[2] = input[i + 2];
            num[i] = getMeanValue(arr);
        }

        return num;
    }

    /**
     * 将每三个数据整合为一个数据
     *
     * @param input 输入数据
     * @return 整合后数据
     */
    private Double[] compress(Double[] input) {
        int size = input.length / 3;
        Double[] num = new Double[size];
        Double[] arr;

        // 这里将三个点合并为一个
        for (int i = 0; i < size; i += 3) {
            arr = new Double[3];
            arr[0] = input[i];
            arr[1] = input[i + 1];
            arr[2] = input[i + 2];
            num[i] = getMeanValue(arr);
        }

        return num;
    }

    /**
     * 获取均值
     *
     * @param num 数据
     * @return 均值
     */
    private Integer getMeanValue(Integer[] num) {
        // 有效数据长度
        int count = 0;
        // 总数
        int total = 0;

        for (Integer integer : num) {
            // 当输入值不为空
            if (integer != null) {
                count++;
                total += integer;
            }
        }

        return count == 0 ? null : total / count;
    }

    /**
     * 获取均值
     *
     * @param num 数据
     * @return 均值
     */
    private Double getMeanValue(Double[] num) {
        // 有效数据长度
        double count = 0;
        // 总数
        double total = 0;

        for (Double value : num) {
            // 当输入值不为空
            if (value != null) {
                count++;
                total += value;
            }
        }

        return count == 0 ? null : total / count;
    }
}
