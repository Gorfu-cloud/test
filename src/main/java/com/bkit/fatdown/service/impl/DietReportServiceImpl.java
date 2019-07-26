package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.dto.UserReportDTO;
import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.mappers.TbDietReportMapper;
import com.bkit.fatdown.service.IDietReportService;
import com.bkit.fatdown.utils.DateUtils;
import com.bkit.fatdown.utils.MathUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @file: DietReportServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 饮食评价实现类
 * @date: Created in 7/25/19  3:26 PM
 * @modified:
 * @version: 1.0
 */

@Service
public class DietReportServiceImpl implements IDietReportService {

    @Resource
    private TbDietReportMapper reportMapper;

    @Resource
    private DietFoodServiceImpl foodService;

    /**
     * 创建饮食报告
     *
     * @param report
     * @return
     */
    @Override
    public Boolean insert(TbDietReport report) {
        report.setGmtCreate(new Date());
        report.setGmtModified(new Date());
        return reportMapper.insertSelective(report) > 0;
    }

    /**
     * 查看报告是否存在
     *
     * @param date
     * @param uid
     * @param type
     * @return
     */
    @Override
    public Integer countReport(Date date, Integer uid, Integer type) {
        TbDietReportExample example = new TbDietReportExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andTypeEqualTo(type)
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date));
        return (int) reportMapper.countByExample(example);
    }

    /**
     * 获取报告
     *
     * @param date
     * @param uid
     * @param type
     * @return
     */
    @Override
    public TbDietReport getDietReport(Date date, Integer uid, Integer type) {
        return listDietReport(date, uid, type).get(0);
    }

    /**
     * 拆解食物生成记录
     *
     * @param date
     * @param uid
     * @param type
     * @return
     */
    @Override
    @Deprecated
    public TbDietReport updateReport(Date date, Integer uid, Integer type) {
        TbDietReport report;
        if (countReport(date, uid, type) > 0) {
            report = getDietReport(date, uid, type);
        } else {
            report = new TbDietReport();
        }

        // 拆解食物记录
        List<TbFoodRecord> recordList = foodService.listFoodBasic(uid, date, type);

        return null;
    }

    /**
     * 生成饮食报告
     *
     * @param date
     * @param uid
     * @param type
     * @return
     */
    @Override
    public UserReportDTO generateDietReport(Date date, Integer uid, Integer type) {
        // 获取生成的记录
        UserReportDTO reportDTO = foodService.foodBasic2DietReport(foodService.listFoodBasic(uid, date, type));
        TbDietUserStandard userStandard = foodService.getDietStandard(uid);

        return MathUtils.getDietReport(userStandard, reportDTO, type);
    }

    /**
     * 获取列表
     *
     * @param date
     * @param uid
     * @param type
     * @return
     */
    @Override
    public List<TbDietReport> listDietReport(Date date, Integer uid, Integer type) {
        TbDietReportExample example = new TbDietReportExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andTypeEqualTo(type)
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date));

        return reportMapper.selectByExample(example);
    }
}
