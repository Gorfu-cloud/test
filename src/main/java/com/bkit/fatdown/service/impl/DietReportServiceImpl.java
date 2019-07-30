package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.dto.ElementTotalDTO;
import com.bkit.fatdown.dto.UserReportDTO;
import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.mappers.TbDietReportMapper;
import com.bkit.fatdown.service.IDietReportService;
import com.bkit.fatdown.utils.DateUtils;
import com.bkit.fatdown.utils.MathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(DietReportServiceImpl.class);

    /**
     * 创建饮食报告
     *
     * @param report 饮食报告
     * @return 返回结果
     */
    @Override
    public Boolean insert(TbDietReport report) {
        if (report.getGmtCreate() == null) {
            report.setGmtCreate(new Date());
            report.setGmtModified(new Date());
        }
        return reportMapper.insertSelective(report) > 0;
    }

    /**
     * 更新饮食报告
     *
     * @param report 饮食报告
     * @return 返回结果
     */
    @Override
    public Boolean update(TbDietReport report) {
        if (report.getGmtModified() == null) {
            report.setGmtModified(new Date());
        }
        return reportMapper.updateByPrimaryKeySelective(report) > 0;
    }

    /**
     * 查看报告是否存在
     *
     * @param date 报告日期
     * @param uid  用户id
     * @param type 报告类型：0早餐,1午餐,2晚餐,3加餐,4每日,5每周,6每月
     * @return 返回报告数目
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
     * @param date 报告日期
     * @param uid  用户编号
     * @param type 报告类型：0早餐,1午餐,2晚餐,3加餐,4每日,5每周,6每月
     * @return 返回：报告内容
     */
    @Override
    public TbDietReport getDietReport(Date date, Integer uid, Integer type) {
        return listDietReport(date, uid, type).get(0);
    }

    /**
     * 查找特定报告数
     *
     * @param startDate 开始日期 0：00
     * @param endDate   结束日期 23：59
     * @param uid       用户编号
     * @param typeList  报告类型：0早餐,1午餐,2晚餐,3加餐,4每日,5每周,6每月
     * @return 返回 报告数目
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
     * @param date 报告日期
     * @param uid  用户编号
     * @return 返回某天报告数
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
     * @param date 报告日期
     * @param uid  用户编号
     * @param type 报告类型：0早餐,1午餐,2晚餐,3加餐,4每日,5每周,6每月
     * @return 返回 饮食报告
     */
    @Override
    public UserReportDTO generateDietReport(Date date, Integer uid, Integer type) {
        // 获取菜式id列表
        List<Integer> foodIdList = listFoodId(foodService.listFoodBasic(uid, date, type));
        // 计算菜式组成成分总量
        ElementTotalDTO totalDTO = foodService.getDietElementTotal(foodIdList);

        TbDietUserStandard userStandard = foodService.getDietStandard(uid);

        UserReportDTO reportDTO = transferUserReport(totalDTO);

        if (!saveReport(reportDTO, uid, type, date)) {
            logger.error("tb_diet_report insert or update false，uid：{} and type：{} at date：{}", uid, type, date);
        }

        return MathUtils.getDietReport(userStandard, reportDTO, type);
    }

    /**
     * 获取列表
     *
     * @param date 报告日期
     * @param uid  用户编号
     * @param type 报告类型：0早餐,1午餐,2晚餐,3加餐,4每日,5每周,6每月
     * @return 返回 饮食报告列表
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
     * 保存饮食报告
     *
     * @param reportDTO 饮食报告
     * @param uid       用户id
     * @param type      报告类型：0早餐,1午餐,2晚餐,3加餐,4每日,5每周,6每月
     * @param date      报告日期
     * @return 返回结果
     */
    private boolean saveReport(UserReportDTO reportDTO, Integer uid, Integer type, Date date) {
        logger.info("tb_diet_report insert or update start,uid：{} and type：{} at date：{}", uid, type, date);

        TbDietReport report = reportDTO2DietReport(reportDTO);
        report.setUserId(uid);
        report.setType(type);
        report.setGmtModified(date);

        // 新建记录
        if (countReport(date, uid, type) == 0) {
            report.setGmtCreate(date);
            return insert(report);
        }

        // 获取饮食记录id，并更新
        int id = getIdByUidType(uid, type, date);
        report.setId(id);
        return update(report);
    }

    /**
     * 将实际情况转为饮食报告
     *
     * @param reportDTO 报告传输对象
     * @return 返回饮食报告
     */
    private TbDietReport reportDTO2DietReport(UserReportDTO reportDTO) {
        TbDietReport report = new TbDietReport();

        report.setProtein(reportDTO.getProtein());
        report.setFiber(reportDTO.getFiber());
        report.setEnergy(reportDTO.getRealEnergy());
        report.setCho(reportDTO.getCho());
        report.setFat(reportDTO.getFat());

        return report;
    }

    /**
     * 获取同一类型记录列表
     *
     * @param uid  用户编号
     * @param type 报告类型：0早餐,1午餐,2晚餐,3加餐,4每日,5每周,6每月
     * @param date 报告日期
     * @return 返回 报告编号
     */
    private Integer getIdByUidType(int uid, int type, Date date) {
        return listDietReport(date, uid, type).get(0).getId();
    }

    /**
     * 获取菜式id
     *
     * @param foodRecordList 饮食记录
     * @return 返回 菜式列表id
     */
    private List<Integer> listFoodId(List<TbFoodRecord> foodRecordList) {
        List<Integer> foodIdList = new ArrayList<>(foodRecordList.size() + 1);

        for (TbFoodRecord record : foodRecordList) {
            foodIdList.add(record.getFoodId());
        }
        return foodIdList;
    }

    /**
     * 转为UserReport
     *
     * @param totalDTO 菜式元素总量
     * @return 用户饮食报告
     */
    private UserReportDTO transferUserReport(ElementTotalDTO totalDTO) {
        UserReportDTO reportDTO = new UserReportDTO();
        reportDTO.setRealEnergy(totalDTO.getEnergy());
        reportDTO.setProtein(totalDTO.getProtein());
        reportDTO.setCho(totalDTO.getCho());
        reportDTO.setFat(totalDTO.getFat());
        reportDTO.setFiber(totalDTO.getFiber());
        reportDTO.setStructureLack(totalDTO.getStructType());
        return reportDTO;
    }
}
