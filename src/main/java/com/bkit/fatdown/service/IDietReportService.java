package com.bkit.fatdown.service;

import com.bkit.fatdown.dto.DietDailyReport;
import com.bkit.fatdown.dto.DietMealReport;
import com.bkit.fatdown.entity.TbDietMealReport;

import java.util.Date;
import java.util.List;

/**
 * @file: IDietReportService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 饮食报告功能接口
 * @date: Created in 7/25/19  11:46 AM
 * @modified:
 * @version: 1.0
 */

public interface IDietReportService {
    /**
     * 生成每餐饮食报告
     *
     * @param date 报告日期
     * @param uid  用户编号
     * @param type 报告类型：0早餐,1午餐,2晚餐,3加餐,4每日,5每周,6每月
     * @return 每餐饮食报告
     */
    DietMealReport generateMealReport(Date date, Integer uid, Integer type);

    /**
     * 生成一天饮食报告
     *
     * @param date 报告日期
     * @param uid  用户编号
     * @param type 报告类型：4每天
     * @return 每天饮食报告
     */
    DietDailyReport generateDailyReport(Date date, Integer uid, Integer type);

    /**
     * 保存每餐饮食报告
     *
     * @param report 饮食报告
     * @return 结果
     */
    boolean insertMealReport(TbDietMealReport report);

    /**
     * 删除每餐饮食报告
     *
     * @param id 报告id
     * @return 结果
     */
    boolean deleteMealReport(int id);

    /**
     * 更新饮食报告
     *
     * @param report 报告
     * @return 结果
     */
    boolean updateMealReport(TbDietMealReport report);

    /**
     * 通过日期，类型，用户id 获取每餐饮食报告
     *
     * @param date 日期
     * @param type 类型：0早餐，1午餐，2晚餐，3加餐
     * @param uid  用户id
     * @return 每餐饮食报告
     */
    TbDietMealReport getDietMealReport(Date date, int type, int uid);

    /**
     * 通过id 获取每餐饮食报告
     *
     * @param id 记录id
     * @return 每餐饮食报告
     */
    TbDietMealReport getDietMealReport(int id);

    /**
     * 通过日期，类型，用户id，获取饮食报告列表
     *
     * @param date 日期
     * @param type 类型：0早餐，1午餐，2晚餐，3加餐
     * @param uid  用户id
     * @return 饮食报告列表
     */
    List<TbDietMealReport> listDietMealReport(Date date, int type, int uid);

    /**
     * 通过日期，用户id，获取饮食报告列表
     *
     * @param date 日期
     * @param uid  用户id
     * @return 饮食报告列表
     */
    List<TbDietMealReport> listDietMealReport(Date date, int uid);

    /**
     * 通过日期开始，结束，用户id，获取饮食报告列表
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param uid       用户id
     * @return 饮食报告列表
     */
    List<TbDietMealReport> listDietMealReport(Date startDate, Date endDate, int uid);

    /**
     * 通过日期，类型，用户id，获取每餐饮食报告数
     *
     * @param date 日期
     * @param type 类型
     * @param uid  用户id
     * @return 每餐饮食报告
     */
    int countDietMealReport(Date date, int type, int uid);

    /**
     * 通过日期，用户id，获取每餐饮食报告数
     *
     * @param date 日期
     * @param uid  用户id
     * @return 报告记录数
     */
    int countDietMealReport(Date date, int uid);

    /**
     * 通过开始日期，结束日期，用户id，获取每餐饮食报告数
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param uid       用户id
     * @return 报告记录数
     */
    int countDietMealReport(Date startDate, Date endDate, int uid);

    /**
     * 通过id，获取饮食报告数
     *
     * @param id 报告id
     * @return 报告记录数
     */
    int countDietMealReport(int id);
}
