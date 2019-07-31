package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.dto.DietDailyReport;
import com.bkit.fatdown.dto.DietMealReport;
import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.mappers.TbDietDailyReportMapper;
import com.bkit.fatdown.mappers.TbDietMealReportMapper;
import com.bkit.fatdown.service.IDietReportService;
import com.bkit.fatdown.utils.DataTransferUtils;
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
    private DietFoodServiceImpl foodService;

    @Resource
    private TbDietMealReportMapper mealReportMapper;

    @Resource
    private TbDietDailyReportMapper dailyReportMapper;

    private static final Logger logger = LoggerFactory.getLogger(DietReportServiceImpl.class);

    private static final int BREAKFAST = 0;
    private static final int LUNCH = 1;
    private static final int DINNER = 2;

    /**
     * @param date 报告日期
     * @param uid  用户编号
     * @param type 报告类型：4每天
     * @return 每天饮食报告
     */
    @Override
    public DietDailyReport generateDailyReport(Date date, Integer uid, Integer type) {
        // 获取菜式id列表
        List<Integer> foodIdList = listFoodId(foodService.listFoodBasic(uid, date, type));
        // 计算菜式组成成分总量
        TbDietRecord record = foodService.getDietRecordTotalByFoodList(foodIdList);

        TbDietUserStandard userStandard = foodService.getDietStandard(uid);

        return MathUtils.getDietDailyReport(userStandard, record);
    }

    /**
     * 保存每餐饮食报告
     *
     * @param report 饮食报告
     * @return 结果
     */
    @Override
    public boolean insertMealReport(TbDietMealReport report) {
        if (report.getGmtCreate() == null) {
            report.setGmtCreate(new Date());
            report.setGmtModified(new Date());
        }
        return mealReportMapper.insertSelective(report) > 0;
    }

    /**
     * 删除每餐饮食报告
     *
     * @param id 报告id
     * @return 结果
     */
    @Override
    public boolean deleteMealReport(int id) {
        return mealReportMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 更新饮食报告
     *
     * @param report 报告
     * @return 结果
     */
    @Override
    public boolean updateMealReport(TbDietMealReport report) {
        if (report.getGmtModified() == null) {
            report.setGmtModified(new Date());
        }
        return mealReportMapper.updateByPrimaryKeySelective(report) > 0;
    }

    /**
     * 通过id 获取每餐饮食报告
     *
     * @param id 记录id
     * @return 每餐饮食报告
     */
    @Override
    public TbDietMealReport getDietMealReport(int id) {
        return mealReportMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过id 获取每餐饮食报告
     *
     * @param date 日期
     * @param type 类型：0早餐，1午餐，2晚餐，3加餐
     * @param uid  用户id
     * @return 每餐饮食报告
     */
    @Override
    public TbDietMealReport getDietMealReport(Date date, int type, int uid) {
        return listDietMealReport(date, type, uid).get(0);
    }

    /**
     * 通过日期，类型，用户id，获取饮食报告列表
     *
     * @param date 日期
     * @param type 类型：0早餐，1午餐，2晚餐，3加餐
     * @param uid  用户id
     * @return 饮食报告列表
     */
    @Override
    public List<TbDietMealReport> listDietMealReport(Date date, int type, int uid) {
        TbDietMealReportExample example = new TbDietMealReportExample();
        example.createCriteria()
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date))
                .andTypeEqualTo(type)
                .andUserIdEqualTo(uid);
        return mealReportMapper.selectByExample(example);
    }

    /**
     * 通过日期，用户id，获取饮食报告列表
     *
     * @param date 日期
     * @param uid  用户id
     * @return 饮食报告列表
     */
    @Override
    public List<TbDietMealReport> listDietMealReport(Date date, int uid) {
        TbDietMealReportExample example = new TbDietMealReportExample();
        example.createCriteria()
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date))
                .andUserIdEqualTo(uid);
        return mealReportMapper.selectByExample(example);
    }

    /**
     * 通过日期开始，结束，用户id，获取饮食报告列表
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param uid       用户id
     * @return 饮食报告列表
     */
    @Override
    public List<TbDietMealReport> listDietMealReport(Date startDate, Date endDate, int uid) {
        TbDietMealReportExample example = new TbDietMealReportExample();
        example.createCriteria()
                .andGmtCreateBetween(startDate, endDate)
                .andUserIdEqualTo(uid);
        return mealReportMapper.selectByExample(example);
    }

    /**
     * 通过日期，类型，用户id，获取每餐饮食报告数
     *
     * @param date 日期
     * @param type 类型
     * @param uid  用户id
     * @return 每餐饮食报告
     */
    @Override
    public int countDietMealReport(Date date, int type, int uid) {
        return listDietMealReport(date, type, uid).size();
    }

    /**
     * 通过日期，用户id，获取每餐饮食报告数
     *
     * @param date 日期
     * @param uid  用户id
     * @return 报告记录数
     */
    @Override
    public int countDietMealReport(Date date, int uid) {
        return listDietMealReport(date, uid).size();
    }

    /**
     * 通过开始日期，结束日期，用户id，获取每餐饮食报告数
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param uid       用户id
     * @return 报告记录数
     */
    @Override
    public int countDietMealReport(Date startDate, Date endDate, int uid) {
        return listDietMealReport(startDate, endDate, uid).size();
    }

    /**
     * 通过id，获取饮食报告数
     *
     * @param id 报告id
     * @return 报告记录数
     */
    @Override
    public int countDietMealReport(int id) {
        TbDietMealReportExample example = new TbDietMealReportExample();
        example.createCriteria()
                .andIdEqualTo(id);
        return (int) mealReportMapper.countByExample(example);
    }

    /**
     * 保存每日评价
     *
     * @param report 饮食评价
     * @return 结果
     */
    @Override
    public boolean insertDailyReport(TbDietDailyReport report) {
        if (report.getGmtCreate() == null) {
            report.setGmtCreate(new Date());
            report.setGmtModified(new Date());
        }
        return dailyReportMapper.insertSelective(report) > 0;
    }

    /**
     * 更新饮食评价
     *
     * @param report 饮食评价
     * @return 结果
     */
    @Override
    public boolean updateDailyReport(TbDietDailyReport report) {
        if (report.getGmtModified() == null) {
            report.setGmtModified(new Date());
        }

        return dailyReportMapper.updateByPrimaryKeySelective(report) > 0;
    }

    /**
     * 删除饮食评价
     *
     * @param id 评价id
     * @return 结果
     */
    @Override
    public boolean deleteDailyReport(int id) {
        return dailyReportMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 通过评价id，获取每日饮食评价
     *
     * @param id 评价id
     * @return 饮食评价
     */
    @Override
    public TbDietDailyReport getDietDailyReport(int id) {
        return dailyReportMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过日期，用户id，获取每日饮食评价
     *
     * @param date 日期
     * @param uid  用户id
     * @return 饮食评价
     */
    @Override
    public TbDietDailyReport getDietDailyReport(Date date, int uid) {
        return listDietDailyReport(date, date, uid).get(0);
    }

    /**
     * 通过开始日期，结束日期，用户id，获取每日饮食评价
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param uid       用户id
     * @return 饮食评价
     */
    @Override
    public List<TbDietDailyReport> listDietDailyReport(Date startDate, Date endDate, int uid) {
        TbDietDailyReportExample example = new TbDietDailyReportExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andGmtCreateBetween(DateUtils.getDateStart(startDate), DateUtils.getDateEnd(endDate));

        return dailyReportMapper.selectByExample(example);
    }

    /**
     * 获取每日饮食评价记录数
     *
     * @param date 记录日期
     * @param uid  用户id
     * @return 评价记录数
     */
    @Override
    public int countDietDailyReport(Date date, int uid) {
        return listDietDailyReport(date, date, uid).size();
    }

    /**
     * 获取日期之间的评价记录数
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param uid       用户id
     * @return 评价记录数
     */
    @Override
    public int countDietDailyReport(Date startDate, Date endDate, int uid) {
        return listDietDailyReport(startDate, endDate, uid).size();
    }

    /**
     * 生成每餐饮食报告
     *
     * @param date 报告日期
     * @param uid  用户编号
     * @param type 报告类型：0早餐,1午餐,2晚餐,3加餐,4每日,5每周,6每月
     * @return 每餐饮食报告
     */
    @Override
    public DietMealReport generateMealReport(Date date, Integer uid, Integer type) {

        // 获取菜式id列表
        List<Integer> foodIdList = listFoodId(foodService.listFoodBasic(uid, date, type));
        // 计算菜式组成成分总量
        TbDietRecord record = foodService.getDietRecordTotalByFoodList(foodIdList);
        // 获取用户标准
        TbDietUserStandard userStandard = foodService.getDietStandard(uid);

        DietMealReport report = MathUtils.getDietMealReport(userStandard, record, type);

        // 已经过了用餐时间，记录用餐记录
        if (isFinishMeal(date, type)) {
            TbDietMealReport mealReport = DataTransferUtils.transferDietMealReport(report, uid, type);
            mealReport.setGmtCreate(date);
            mealReport.setGmtModified(date);
            boolean result = insertMealReport(mealReport);
            if (result) {
                logger.info("tb_diet_meal_report insert success, date:{} and uid:{} and type:{}", date, uid, type);
            } else {
                logger.error("tb_diet_meal_report insert fail, date:{} and uid:{} and type:{}", date, uid, type);
            }
        }

        return report;
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

    private boolean isFinishMeal(Date date, int type) {
        Date now = new Date();

        if (type == BREAKFAST) {
            return DateUtils.isLargerTime(now, DateUtils.getBreakfastEndTime(date));
        } else if (type == LUNCH) {
            return DateUtils.isLargerTime(now, DateUtils.getLunchEndTime(date));
        } else if (type == DINNER) {
            return DateUtils.isLargerTime(now, DateUtils.getDinnerEndTime(date));
        } else {
            logger.error("isFinishMeal type out of index, date: {}  type: {}", date, type);
            return false;
        }
    }
}
