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
    public Map<String, List<Double>> getWeeklyEnergy(Integer uid, Date date) {
        if (reportService.countDietMealReport(DateUtils.getCurrentWeekStart(date), DateUtils.getCurrentWeekEnd(date), uid) == 0) {
            return null;
        }

        Map<String, List<Double>> map = new HashMap<>(3);

        List<Double> breakfast = new ArrayList<>(), lunch = new ArrayList<>(), dinner = new ArrayList<>();

        List<TbDietMealReport> reportList = reportService.listDietMealReport(DateUtils.getCurrentWeekStart(date), DateUtils.getCurrentWeekEnd(date), uid);

        for (TbDietMealReport report : reportList) {
            int type = report.getType();
            double energy = report.getRealEnergy();

        }

        if (!breakfast.isEmpty()) {
            map.put("breakfast", breakfast);
        }

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
    public Map<String, Integer> getWeeklyEnergyEvaluation(Integer uid, Date date) {
        return null;
    }

    /**
     * 获取当月能量评价
     *
     * @param uid  用户id
     * @param date 当月日期
     * @return 当月能量
     */
    @Override
    public Map<String, Object> getMonthEnergy(Integer uid, Date date) {
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
    public Map<String, Integer> getMonthEnergyEvaluation(Integer uid, Date date) {
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

}
