package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.common.utils.DateUtils;
import com.bkit.fatdown.entity.TbDietDailyReport;
import com.bkit.fatdown.entity.TbDietMealReport;
import com.bkit.fatdown.entity.TbDietRecord;
import com.bkit.fatdown.service.IDietRecordService;
import com.bkit.fatdown.service.IDietReportService;
import com.bkit.fatdown.service.ITimelineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.bkit.fatdown.common.utils.MathUtils.compress;

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

    /**
     * 获取评价报告
     */
    @Resource
    private IDietReportService reportService;

    /**
     * 获取摄入量统计
     */
    @Resource
    private IDietRecordService recordService;

    /**
     * 报告类型: 0 早餐， 1 午餐， 2 晚餐， 3 加餐， 4 每日， 5 每周， 6每月
     */
    private final static Integer BREAKFAST = 0;
    private final static Integer LUNCH = 1;
    private final static Integer DINNER = 2;
    private final static Integer DAY = 4;

    /**
     * 一周 7天
     */
    private final static Integer WEEKLY_SIZE = 7;

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
            TbDietRecord record = recordService.getDietRecord(date, uid, i);
            if (record != null) {
                meals[i] = record.getEnergy();
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

        map.put("breakfast", getEnergyByType(start, WEEKLY_SIZE, uid, BREAKFAST, false));
        map.put("lunch", getEnergyByType(start, WEEKLY_SIZE, uid, LUNCH, false));
        map.put("dinner", getEnergyByType(start, WEEKLY_SIZE, uid, DINNER, false));

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

        map.put("breakfast", getEvaluationByType(start, WEEKLY_SIZE, uid, BREAKFAST, false));
        map.put("lunch", getEvaluationByType(start, WEEKLY_SIZE, uid, LUNCH, false));
        map.put("dinner", getEvaluationByType(start, WEEKLY_SIZE, uid, DINNER, false));

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

        map.put("breakfast", getStructureEvaluationByType(start, WEEKLY_SIZE, uid, BREAKFAST, false));
        map.put("lunch", getStructureEvaluationByType(start, WEEKLY_SIZE, uid, LUNCH, false));
        map.put("dinner", getStructureEvaluationByType(start, WEEKLY_SIZE, uid, DINNER, false));

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

        return getNutrients(start, WEEKLY_SIZE, uid, false);
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

        return getNutrientsEvaluation(start, WEEKLY_SIZE, uid, false);
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

//    /**
//     * 获取当天维生素
//     *
//     * @param uid  用户id
//     * @param date 当天日期
//     * @return 当天维生素
//     */
//    @Override
//    public Map<String, Double[]> getDailyVitamin(Integer uid, Date date) {
//        return getVitamin(date, 1, uid, false);
//    }

    /**
     * 获取当周维生素
     *
     * @param uid  用户id
     * @param date 当周日期
     * @return 当周维生素
     */
    @Override
    public Map<String, Double[]> getWeeklyVitamin(Integer uid, Date date) {
        // 获取日期循环
        Date start = DateUtils.getCurrentWeekStart(date);
        return getVitamin(start, WEEKLY_SIZE, uid, false);
    }

    /**
     * 获取当月维生素
     *
     * @param uid        用户id
     * @param date       当月日期
     * @param isCompress 是否压缩
     * @return 当月维生素
     */
    @Override
    public Map<String, Double[]> getMonthVitamin(Integer uid, Date date, boolean isCompress) {
        // 获取日期循环
        Date start = DateUtils.getMonthStartDate(date);
        int daysOfMonth = DateUtils.getDaysOfMonth(start);

        return getVitamin(start, daysOfMonth, uid, isCompress);
    }

//    /**
//     * 获取当天矿物质
//     *
//     * @param uid  用户id
//     * @param date 当周日期
//     * @return 当周矿物质
//     */
//    @Override
//    public Map<String, Double[]> getDailyMinerals(Integer uid, Date date) {
//
//        return null;
//    }

    /**
     * 获取当周矿物质
     *
     * @param uid  用户id
     * @param date 当周日期
     * @return 当周矿物质
     */
    @Override
    public Map<String, Double[]> getWeeklyMinerals(Integer uid, Date date) {
        // 获取日期循环
        Date start = DateUtils.getCurrentWeekStart(date);
        return getMinerals(start, WEEKLY_SIZE, uid, false);
    }

    /**
     * 获取当月矿物质
     *
     * @param uid        用户id
     * @param date       当月日期
     * @param isCompress 是否压缩
     * @return 当月矿物质
     */
    @Override
    public Map<String, Double[]> getMonthMinerals(Integer uid, Date date, boolean isCompress) {
        // 获取日期循环
        Date start = DateUtils.getMonthStartDate(date);
        int daysOfMonth = DateUtils.getDaysOfMonth(start);

        return getMinerals(start, daysOfMonth, uid, isCompress);
    }

    /**
     * @param start      第一天
     * @param uid        用户编号
     * @param reportType 报告类型: 0 1 2 (早 午 晚 餐)
     * @return 一周摄入能量
     */
    private Double[] getEnergyByType(Date start, Integer size, Integer uid, Integer reportType, boolean isCompress) {

        Double[] result = new Double[size];
        TbDietRecord record;
        for (int i = 0; i < size; i++) {
            if (recordService.countDietRecord(start, uid, reportType) > 0) {
                record = recordService.getDietRecord(start, uid, reportType);
                result[i] = record.getEnergy();
            }

            start = DateUtils.getTomorrow(start);
        }

        return isCompress ? compress(result) : result;
    }

    /**
     * 获取饮食评价
     *
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
     * 获取结构评价
     *
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
     * 获取营养素评价
     *
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
     * 获取摄入营养素
     *
     * @param start 开始第一天
     * @param uid   用户编号
     * @return 一周摄入主要营养素
     */
    private Map<String, Double[]> getNutrients(Date start, Integer size, Integer uid, boolean isCompress) {

        Double[] fat = new Double[size];
        Double[] col = new Double[size];
        Double[] fibrin = new Double[size];
        Double[] protein = new Double[size];

        TbDietRecord record;
        for (int i = 0; i < size; i++) {
            if (recordService.countDietRecord(start, uid, DAY) > 0) {
                record = recordService.getDietRecord(start, uid, DAY);

                fat[i] = record.getFat();
                col[i] = record.getCarbs();
                fibrin[i] = record.getInsolubleFiber();
                protein[i] = record.getProtein();
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
     * 获取摄入矿物质
     *
     * @param start 开始第一天
     * @param uid   用户编号
     * @return 摄入矿物质
     */
    private Map<String, Double[]> getMinerals(Date start, Integer size, Integer uid, boolean isCompress) {

        Double[] ca = new Double[size];
        Double[] p = new Double[size];
        Double[] k = new Double[size];
        Double[] mg = new Double[size];
        Double[] fe = new Double[size];
        Double[] zn = new Double[size];
        Double[] se = new Double[size];
        Double[] cu = new Double[size];
        Double[] na = new Double[size];
        Double[] mn = new Double[size];

        TbDietRecord record;
        for (int i = 0; i < size; i++) {
            if (recordService.countDietRecord(start, uid, DAY) > 0) {
                record = recordService.getDietRecord(start, uid, DAY);

                ca[i] = record.getCa();
                p[i] = record.getP();
                k[i] = record.getK();
                mg[i] = record.getMn();
                fe[i] = record.getFe();
                zn[i] = record.getZn();
                se[i] = record.getSe();
                cu[i] = record.getCu();
                na[i] = record.getNa();
            }

            start = DateUtils.getTomorrow(start);
        }

        Map<String, Double[]> map = new HashMap<>(4);

        if (isCompress) {
            map.put("ca", compress(ca));
            map.put("p", compress(p));
            map.put("k", compress(k));
            map.put("mg", compress(mg));
            map.put("fe", compress(fe));
            map.put("zn", compress(zn));
            map.put("se", compress(se));
            map.put("cu", compress(cu));
            map.put("na", compress(na));
            map.put("mn", compress(mn));

        } else {
            map.put("ca", ca);
            map.put("p", p);
            map.put("k", k);
            map.put("mg", mg);
            map.put("fe", fe);
            map.put("zn", zn);
            map.put("se", se);
            map.put("cu", cu);
            map.put("na", na);
            map.put("mn", mn);
        }

        return map;
    }

    /**
     * 获取摄入维生素
     *
     * @param start 开始第一天
     * @param uid   用户编号
     * @return 摄入维生素
     */
    private Map<String, Double[]> getVitamin(Date start, Integer size, Integer uid, boolean isCompress) {

        Double[] a = new Double[size];
        Double[] b1 = new Double[size];
        Double[] b2 = new Double[size];
        Double[] b3 = new Double[size];
        Double[] c = new Double[size];
        Double[] e = new Double[size];

        TbDietRecord record;
        for (int i = 0; i < size; i++) {
            if (recordService.countDietRecord(start, uid, DAY) > 0) {
                record = recordService.getDietRecord(start, uid, DAY);


                a[i] = record.getVitaminA();
                b1[i] = record.getVitaminB1();
                b2[i] = record.getVitaminB2();
                b3[i] = record.getVitaminB3();
                c[i] = record.getVitaminC();
                e[i] = record.getVitaminE();
            }

            start = DateUtils.getTomorrow(start);
        }

        Map<String, Double[]> map = new HashMap<>(4);

        if (isCompress) {
            map.put("a", compress(a));
            map.put("b1", compress(b1));
            map.put("b2", compress(b2));
            map.put("b3", compress(b3));
            map.put("c", compress(c));
            map.put("e", compress(e));
        } else {
            map.put("a", a);
            map.put("b1", b1);
            map.put("b2", b2);
            map.put("b3", b3);
            map.put("c", c);
            map.put("e", e);
        }

        return map;
    }

}
