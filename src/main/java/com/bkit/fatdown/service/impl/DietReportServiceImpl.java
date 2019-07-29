package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.dto.UserReportDTO;
import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.mappers.TbDietReportMapper;
import com.bkit.fatdown.service.IDietReportService;
import com.bkit.fatdown.utils.DateUtils;
import com.bkit.fatdown.utils.MathUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    private static Logger logger = Logger.getLogger(DietReportServiceImpl.class);

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
     * 更新饮食报告
     *
     * @param report
     * @return
     */
    @Override
    public Boolean update(TbDietReport report) {
        report.setGmtModified(new Date());
        return reportMapper.updateByPrimaryKeySelective(report) > 0;
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
     * 查找特定报告数
     *
     * @param startDate
     * @param endDate
     * @param uid
     * @param typeList
     * @return
     */
    @Override
    public Integer countReportByTypeList(Date startDate, Date endDate, Integer uid, List<Integer> typeList) {
        TbDietReportExample example = new TbDietReportExample();
        example.createCriteria()
                .andGmtCreateBetween(startDate, endDate)
                .andUserIdEqualTo(uid)
                .andTypeIn(typeList);
        return (int) reportMapper.countByExample(example);
    }

    /**
     * 查找特定记录
     *
     * @param date
     * @param uid
     * @return
     */
    @Override
    public Integer countReportByDay(Date date, Integer uid) {
        TbDietReportExample example = new TbDietReportExample();
        example.createCriteria()
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date))
                .andUserIdEqualTo(uid);
        return (int) reportMapper.countByExample(example);
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
        UserReportDTO reportDTO = foodService.getDietElementTotal(listFoodId(foodService.listFoodBasic(uid, date, type)));

        TbDietUserStandard userStandard = foodService.getDietStandard(uid);

        TbDietReport report = reportDTO2DietReport(reportDTO);
        report.setUserId(uid);
        report.setType(type);
        report.setGmtModified(date);
        // 储存实际情况记录
        boolean result;
        if (countReport(date, uid, type) == 0) {
            report.setGmtCreate(date);
            result = insert(report);
        } else {
            int id = getIdByUidType(uid, type, date);
            report.setId(id);
            result = update(report);
        }

        if (!result) {
            logger.error(uid + "饮食报告" + type + "记录，插入失败");
        }

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

    /**
     * 将实际情况转为饮食报告
     *
     * @param reportDTO
     * @return
     */
    private TbDietReport reportDTO2DietReport(UserReportDTO reportDTO) {
        TbDietReport report = new TbDietReport();

        report.setProtein(reportDTO.getProtein());
        report.setFibrin(reportDTO.getFiber());
        report.setEnergy(reportDTO.getRealEnergy());
        report.setCol(reportDTO.getCho());
        report.setFat(reportDTO.getFat());

        return report;
    }

    private Integer getIdByUidType(int uid, int type, Date date) {
        return listDietReport(date, uid, type).get(0).getId();
    }

    // 获取菜式id
    private List<Integer> listFoodId(List<TbFoodRecord> foodRecordList) {
        List<Integer> foodIdList = new ArrayList<>(foodRecordList.size() + 1);

        for (TbFoodRecord record : foodRecordList) {
            foodIdList.add(record.getFoodId());
        }
        return foodIdList;
    }
}
