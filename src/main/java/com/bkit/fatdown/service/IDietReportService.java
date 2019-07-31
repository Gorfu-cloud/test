package com.bkit.fatdown.service;

import com.bkit.fatdown.dto.DietDailyReport;
import com.bkit.fatdown.dto.DietMealReport;
import com.bkit.fatdown.dto.UserReportDTO;

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
}
