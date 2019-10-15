package com.bkit.fatdown.service;

import java.util.Date;
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
     * 获取每天结构评价
     *
     * @param uid  用户id
     * @param date 当周日期
     * @return 当周能量评价
     */
    Integer[] getDailyStructureEvaluation(Integer uid, Date date);


    /**
     * 获取每周能量
     *
     * @param uid  用户id
     * @param date 当周日期
     * @return 当周能量
     */
    Map<String, Double[]> getWeeklyEnergy(Integer uid, Date date);

    /**
     * 获取当周能量评价
     *
     * @param uid  用户id
     * @param date 当周日期
     * @return 当周能量评价
     */
    Map<String, Integer[]> getWeeklyEnergyEvaluation(Integer uid, Date date);

    /**
     * 获取当周结构评价
     *
     * @param uid  用户id
     * @param date 当周日期
     * @return 当周能量评价
     */
    Map<String, Integer[]> getWeeklyStructureEvaluation(Integer uid, Date date);

    /**
     * 获取当月能量评价
     *
     * @param uid        用户id
     * @param date       当月日期
     * @param isCompress 压缩返回数据
     * @return 当月能量
     */
    Map<String, Double[]> getMonthEnergy(Integer uid, Date date, boolean isCompress);

    /**
     * 获取当月能量评价
     *
     * @param uid        用户id
     * @param date       当月日期
     * @param isCompress 压缩返回数据
     * @return 当月能量评价
     */
    Map<String, Integer[]> getMonthEnergyEvaluation(Integer uid, Date date, boolean isCompress);

    /**
     * 获取当月结构评价
     *
     * @param uid        用户id
     * @param date       当月日期
     * @param isCompress 压缩返回数据
     * @return 当月能量评价
     */
    Map<String, Integer[]> getMonthStructureEvaluation(Integer uid, Date date, boolean isCompress);

    /**
     * 获取当周主要营养素
     *
     * @param uid  用户id
     * @param date 当周日期
     * @return 当周营养素
     */
    Map<String, Double[]> getWeeklyNutrients(Integer uid, Date date);

    /**
     * 获取当月主要营养素
     *
     * @param uid        用户id
     * @param date       当月日期
     * @param isCompress 压缩返回数据
     * @return 当月营养素
     */
    Map<String, Double[]> getMonthNutrients(Integer uid, Date date, boolean isCompress);

    /**
     * 获取当周主要营养素评价
     *
     * @param uid  用户id
     * @param date 当周日期
     * @return 当周营养素评价
     */
    Map<String, Integer[]> getWeeklyNutrientsEvaluation(Integer uid, Date date);

    /**
     * 获取当月主要营养素评价
     *
     * @param uid        用户id
     * @param date       当月日期
     * @param isCompress 压缩返回数据
     * @return 当月营养素评价
     */
    Map<String, Integer[]> getMonthNutrientsEvaluation(Integer uid, Date date, boolean isCompress);

//    /**
//     * 获取当天维生素
//     *
//     * @param uid  用户id
//     * @param date 当天日期
//     * @return 当天维生素
//     */
//    Map<String, Double[]> getDailyVitamin(Integer uid, Date date);

    /**
     * 获取当周维生素
     *
     * @param uid  用户id
     * @param date 当周日期
     * @return 当周维生素
     */
    Map<String, Double[]> getWeeklyVitamin(Integer uid, Date date);

    /**
     * 获取当月维生素
     *
     * @param uid        用户id
     * @param date       当月日期
     * @param isCompress 是否压缩
     * @return 当月维生素
     */
    Map<String, Double[]> getMonthVitamin(Integer uid, Date date, boolean isCompress);

//    /**
//     * 获取当天矿物质
//     *
//     * @param uid  用户id
//     * @param date 当周日期
//     * @return 当周矿物质
//     */
//    Map<String, Double[]> getDailyMinerals(Integer uid, Date date);

    /**
     * 获取当周矿物质
     *
     * @param uid  用户id
     * @param date 当周日期
     * @return 当周矿物质
     */
    Map<String, Double[]> getWeeklyMinerals(Integer uid, Date date);

    /**
     * 获取当月矿物质
     *
     * @param uid        用户id
     * @param date       当月日期
     * @param isCompress 是否压缩
     * @return 当月矿物质
     */
    Map<String, Double[]> getMonthMinerals(Integer uid, Date date, boolean isCompress);

}
