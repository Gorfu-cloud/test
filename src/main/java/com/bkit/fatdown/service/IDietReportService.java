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
     * @param report
     * @return
     */
    Boolean insert(TbDietReport report);

    /**
     * 更新饮食报告
     *
     * @param report
     * @return
     */
    Boolean update(TbDietReport report);

    /**
     * 查看报告是否存在
     *
     * @param date
     * @param uid
     * @param type
     * @return
     */
    Integer countReport(Date date, Integer uid, Integer type);

    /**
     * 获取报告
     *
     * @param date
     * @param uid
     * @param type
     * @return
     */
    TbDietReport getDietReport(Date date, Integer uid, Integer type);

    /**
     * 获取列表
     *
     * @param date
     * @param uid
     * @param type
     * @return
     */
    List<TbDietReport> listDietReport(Date date, Integer uid, Integer type);

    /**
     * 生成饮食报告
     *
     * @param date
     * @param uid
     * @param type
     * @return
     */
    UserReportDTO generateDietReport(Date date, Integer uid, Integer type);

    /**
     * 查找特定报告数
     *
     * @param startDate
     * @param endDate
     * @param uid
     * @param typeList
     * @return
     */
    Integer countReportByTypeList(Date startDate, Date endDate, Integer uid, List<Integer> typeList);

    /**
     * 查找特定记录
     *
     * @param date
     * @param uid
     * @return
     */
    Integer countReportByDay(Date date, Integer uid);
}
