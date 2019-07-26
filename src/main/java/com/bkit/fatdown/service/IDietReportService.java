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
     * 拆解食物生成记录
     *
     * @param date
     * @param uid
     * @param type
     * @return
     */
    TbDietReport updateReport(Date date, Integer uid, Integer type);

}
