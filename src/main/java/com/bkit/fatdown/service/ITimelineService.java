package com.bkit.fatdown.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @file: ITimelineService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 数据时间轴功能接口
 * @date: Created in 9/17/19  10:12 AM
 * @modified:
 * @version: 1.0
 */
public interface ITimelineService {
    /**
     * 获取每天能量
     *
     * @param uid  用户id
     * @param date 日期
     * @return 当天三餐能量
     */
    Double[] getDailyEnergy(Integer uid, Date date);

    /**
     * 获取每天能量评价
     *
     * @param uid  用户id
     * @param date 日期
     * @return 当天三餐能量评价
     */
    Integer[] getDailyEnergyEvaluation(Integer uid, Date date);

    /**
     * 获取每周能量
     * @param uid 用户id
     * @param date 当周日期
     * @return 当周能量
     */
    Map<String, List<Double>> getWeeklyEnergy(Integer uid, Date date);

    /**
     * 获取当周能量评价
     * @param uid 用户id
     * @param date 当周日期
     * @return 当周能量评价
     */
    Map<String, Integer> getWeeklyEnergyEvaluation(Integer uid,Date date);

    /**
     * 获取当月能量评价
     * @param uid 用户id
     * @param date 当月日期
     * @return 当月能量
     */
    Map<String, Object> getMonthEnergy(Integer uid,Date date);

    /**
     * 获取当月能量评价
     * @param uid 用户id
     * @param date 当月日期
     * @return 当月能量评价
     */
    Map<String, Integer> getMonthEnergyEvaluation(Integer uid,Date date);

    /**
     * 获取每周隐私数据
     *
     * @param uid       用户id
     * @param date 当周日期
     * @return 一周的隐私数据
     */
    Map<String, Object> getWeeklyPrivacyInfo(Integer uid, Date date);

}
