package com.bkit.fatdown.service;

import com.bkit.fatdown.dto.UserReportDTO;
import com.bkit.fatdown.entity.TbDietReport;

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
     * 创建饮食报告
     *
     * @param report 饮食报告
     * @return 返回结果
     */
    Boolean insert(TbDietReport report);

    /**
     * 更新饮食报告
     *
     * @param report 饮食报告
     * @return 返回结果
     */
    Boolean update(TbDietReport report);

    /**
     * 查看报告是否存在
     *
     * @param date 报告日期
     * @param uid  用户id
     * @param type 报告类型：0早餐,1午餐,2晚餐,3加餐,4每日,5每周,6每月
     * @return 返回报告数目
     */
    Integer countReport(Date date, Integer uid, Integer type);

    /**
     * 获取报告
     *
     * @param date 报告日期
     * @param uid  用户编号
     * @param type 报告类型：0早餐,1午餐,2晚餐,3加餐,4每日,5每周,6每月
     * @return 返回：报告内容
     */
    TbDietReport getDietReport(Date date, Integer uid, Integer type);

    /**
     * 获取列表
     *
     * @param date 报告日期
     * @param uid  用户编号
     * @param type 报告类型：0早餐,1午餐,2晚餐,3加餐,4每日,5每周,6每月
     * @return 返回 饮食报告列表
     */
    List<TbDietReport> listDietReport(Date date, Integer uid, Integer type);

    /**
     * 生成饮食报告
     *
     * @param date 报告日期
     * @param uid  用户编号
     * @param type 报告类型：0早餐,1午餐,2晚餐,3加餐,4每日,5每周,6每月
     * @return 返回 饮食报告
     */
    UserReportDTO generateDietReport(Date date, Integer uid, Integer type);

    /**
     * 查找特定报告数
     *
     * @param startDate 开始日期 0：00
     * @param endDate   结束日期 23：59
     * @param uid       用户编号
     * @param typeList  报告类型：0早餐,1午餐,2晚餐,3加餐,4每日,5每周,6每月
     * @return 返回 报告数目
     */
    Integer countReportByTypeList(Date startDate, Date endDate, Integer uid, List<Integer> typeList);


    /**
     * 查找特定记录
     *
     * @param date 报告日期
     * @param uid  用户编号
     * @return 返回某天报告数
     */
    Integer countReportByDay(Date date, Integer uid);
}
