package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.common.utils.DataTransferUtils;
import com.bkit.fatdown.common.utils.DateUtils;
import com.bkit.fatdown.component.ReportHelper;
import com.bkit.fatdown.dto.diet.DietDailyReport;
import com.bkit.fatdown.dto.diet.DietMealReport;
import com.bkit.fatdown.dto.diet.DietMonthReport;
import com.bkit.fatdown.dto.diet.DietWeeklyReport;
import com.bkit.fatdown.dto.diet.common.Evaluation;
import com.bkit.fatdown.dto.diet.common.NutrientsEvaluation;
import com.bkit.fatdown.dto.diet.common.WeeklyNutrientsEvaluation;
import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.mappers.TbDietDailyReportMapper;
import com.bkit.fatdown.mappers.TbDietMealReportMapper;
import com.bkit.fatdown.mappers.TbDietWeeklyReportMapper;
import com.bkit.fatdown.service.IDietRecordService;
import com.bkit.fatdown.service.IDietReportService;
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

    @Resource
    private IDietRecordService dietRecordService;

    @Resource
    private TbDietWeeklyReportMapper weeklyReportMapper;

    private static final Logger logger = LoggerFactory.getLogger(DietReportServiceImpl.class);

    private static final int BREAKFAST = 0;
    private static final int LUNCH = 1;
    private static final int DINNER = 2;
    private static final int DAILY = 4;
    private static final int WEEKLY = 5;
    private static final int MONTH = 6;

    private static final Integer EXCELLENT = 0;
    private static final Integer GOOD = 1;
    private static final Integer BAD = 2;

    private static final double WEEKLY_NUTRIENT_SIZE = 6;

    private static final String WEEKLY_NAME = "weekly";
    private static final String MONTH_NAME = "month";

    /**
     * @param date 报告日期
     * @param uid  用户编号
     * @return 每天饮食报告
     */
    @Override
    public DietDailyReport generateDailyReport(Date date, Integer uid) {
        // 获取元素总量一天
        TbDietRecord record = dietRecordService.getDietRecord(date, uid, DAILY);
        // 用户饮食标准
        TbDietUserStandard userStandard = foodService.getDietStandard(uid);
        // 生成每天评价报告
        DietDailyReport report = ReportHelper.getDietDailyReport(userStandard, record);

        // 已经过了用餐时间，储存饮食记录
        if (isFinishMeal(date, DAILY)) {
            TbDietDailyReport dailyReport = DataTransferUtils.transferDailyReport(report);
            dailyReport.setUserId(uid);
            dailyReport.setGmtModified(date);
            boolean result;
            if (countDietDailyReport(date, uid) == 0) {
                dailyReport.setGmtCreate(date);
                result = insertDailyReport(dailyReport);
            } else {
                int id = getDietDailyReportId(date, uid);
                dailyReport.setId(id);
                result = updateDailyReport(dailyReport);
            }

            if (result) {
                logger.info("tb_diet_daily_report insert or update success, date:{} and uid:{} ", date, uid);
            } else {
                logger.error("tb_diet_daily_report insert or update fail, date:{} and uid:{} ", date, uid);
            }
        }

        return report;
    }

    /**
     * 生成每周饮食评价
     *
     * @param date 当周日期（周日算第一天）
     * @param uid  用户id
     * @return 每周饮食评价
     */
    @Override
    public DietWeeklyReport generateWeeklyReport(Date date, Integer uid) {
        // 获取菜式id列表
        List<Integer> foodIdList = listFoodId(foodService.listFoodRecord(uid, date, WEEKLY));

        Date startDate = DateUtils.getCurrentWeekStart(date);
        Date endDate = DateUtils.getCurrentWeekEnd(date);

        // 获取元素总量
        List<TbDietRecord> recordList = dietRecordService.listDietMealRecord(startDate, endDate, uid, DAILY);

        // 获取每天饮食记录总量
        TbDietRecord record = foodService.getDietRecord(recordList);

        List<TbDietDailyReport> reportList = listDietDailyReport(startDate, endDate, uid);

        TbDietUserStandard userStandard = foodService.getDietStandard(uid);

        DietWeeklyReport report = ReportHelper.getDietWeeklyReport(userStandard, record, reportList);

        // 营养素评价统计
        WeeklyNutrientsEvaluation nutrientsEvaluation = report.getWeeklyNutrientsEvaluation();
        nutrientsEvaluation.setNutrientsEvaluation(countNutrientEvaluation(uid, startDate, endDate, WEEKLY_NAME));
        nutrientsEvaluation.setScore(ReportHelper.getWeeklyScore(nutrientsEvaluation, WEEKLY_NUTRIENT_SIZE));
        report.setWeeklyNutrientsEvaluation(nutrientsEvaluation);

        // 早午晚餐能量评价统计
        report.setBreakfast(countMealEnergyEvaluation(uid, startDate, endDate, BREAKFAST, WEEKLY_NAME));
        report.setLunch(countMealEnergyEvaluation(uid, startDate, endDate, LUNCH, WEEKLY_NAME));
        report.setDinner(countMealEnergyEvaluation(uid, startDate, endDate, DINNER, WEEKLY_NAME));

        // 储存报告
        if (isFinishMeal(date, WEEKLY)) {
            TbDietWeeklyReport weeklyReport = DataTransferUtils.transferWeeklyReport(report);
            weeklyReport.setUserId(uid);
            weeklyReport.setGmtModified(new Date());
            boolean result;
            if (countWeeklyReport(date, uid) == 0) {
                weeklyReport.setGmtCreate(date);
                result = insert(weeklyReport);
            } else {
                int id = getWeeklyReportId(date, uid);
                weeklyReport.setId(id);
                result = update(weeklyReport);
            }

            if (result) {
                logger.info("tb_diet_weekly_report insert or update success, date:{} and uid:{} ", date, uid);
            } else {
                logger.error("tb_diet_weekly_report insert or update fail, date:{} and uid:{}", date, uid);
            }
        }

        return report;
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
        }
        report.setGmtModified(new Date());
        return mealReportMapper.insertSelective(report) > 0;
    }

    @Override
    public boolean updateMealReportOnly(TbDietMealReport report) {

        if (countDietMealReport(report.getGmtCreate(), report.getType(), report.getUserId()) == 0) {
            return insertMealReport(report);
        } else {
            int id = getDietMealReport(report.getGmtCreate(), report.getType(), report.getUserId()).getId();
            report.setId(id);
            return updateMealReport(report);
        }
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
        report.setGmtModified(new Date());
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
        List<TbDietMealReport> list = listDietMealReport(date, type, uid);
        if (list.size() == 0) {
            return null;
        }

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
     * 获取每种类型用餐，能量报告 优 良 一般 的统计情况
     *
     * @param uid       用户编号
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param type      用餐类型：0,早餐，1午餐，2晚餐
     * @param name      早午晚餐
     * @return 返回值
     */
    @Override
    public Evaluation countMealEnergyEvaluation(int uid, Date startDate, Date endDate, int type, String name) {
        int excellentTotal, goodTotal, ordinaryTotal;

        excellentTotal = countMealEnergyEvaluation(uid, startDate, endDate, type, EXCELLENT);
        goodTotal = countMealEnergyEvaluation(uid, startDate, endDate, type, GOOD);
        ordinaryTotal = countMealEnergyEvaluation(uid, startDate, endDate, type, BAD);

        double score = 0;

        if ("weekly".equals(name)) {
            score = ReportHelper.getWeeklyScore(excellentTotal, goodTotal, ordinaryTotal, 0);
        } else {
            score = ReportHelper.getMonthScore(excellentTotal, goodTotal, ordinaryTotal, 0);
        }

        return new Evaluation(excellentTotal, goodTotal, ordinaryTotal, score);
    }

    private Integer countMealEnergyEvaluation(int uid, Date startDate, Date endDate, int type, int level) {
        TbDietMealReportExample example = new TbDietMealReportExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andGmtCreateBetween(startDate, endDate)
                .andTypeEqualTo(type)
                .andEnergyEvaluationEqualTo(level);
        return (int) mealReportMapper.countByExample(example);
    }

    private Integer countProteinEvaluation(int uid, Date startDate, Date endDate, int level) {
        TbDietDailyReportExample example = new TbDietDailyReportExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andGmtCreateBetween(startDate, endDate)
                .andProteinEvaluationEqualTo(level);
        return (int) dailyReportMapper.countByExample(example);
    }

    private Integer countFatEvaluation(int uid, Date startDate, Date endDate, int level) {
        TbDietDailyReportExample example = new TbDietDailyReportExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andGmtCreateBetween(startDate, endDate)
                .andFatEvaluationEqualTo(level);
        return (int) dailyReportMapper.countByExample(example);
    }

    private Integer countColEvaluation(int uid, Date startDate, Date endDate, int level) {
        TbDietDailyReportExample example = new TbDietDailyReportExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andGmtCreateBetween(startDate, endDate)
                .andColEvaluationEqualTo(level);
        return (int) dailyReportMapper.countByExample(example);
    }

    private Integer countFibrinEvaluation(int uid, Date startDate, Date endDate, int level) {
        TbDietDailyReportExample example = new TbDietDailyReportExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andGmtCreateBetween(startDate, endDate)
                .andFibrinEvaluationEqualTo(level);
        return (int) dailyReportMapper.countByExample(example);
    }

    /**
     * 获取每种类型，营养素评价，报告 优 良 一般 的统计情况
     *
     * @param uid       用户编号
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param name      周或月评价标准
     * @return 返回值
     */
    @Override
    public NutrientsEvaluation countNutrientEvaluation(int uid, Date startDate, Date endDate, String name) {
        Evaluation proteinEvaluation, fatEvaluation, colEvaluation, fibrinEvaluation;

        proteinEvaluation = countProteinEvaluation(uid, startDate, endDate, name);
        fatEvaluation = countFatEvaluation(uid, startDate, endDate, name);
        colEvaluation = countColEvaluation(uid, startDate, endDate, name);
        fibrinEvaluation = countFibrinEvaluation(uid, startDate, endDate, name);

        return new NutrientsEvaluation(proteinEvaluation, fatEvaluation, colEvaluation, fibrinEvaluation);
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
        List<TbDietDailyReport> list = listDietDailyReport(date, date, uid);
        if (list.size() == 0) {
            return null;
        }

        return list.get(0);
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
     * 获取当天饮食报告id
     *
     * @param date 日期
     * @param uid  用户编号
     * @return 用户id
     */
    @Override
    public int getDietDailyReportId(Date date, int uid) {
        return listDietDailyReport(DateUtils.getDateStart(date), DateUtils.getDateEnd(date), uid).get(0).getId();
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
        // 计算菜式组成成分总量
        TbDietRecord record = dietRecordService.getDietRecord(date, uid, type);

        // 获取用户标准
        TbDietUserStandard userStandard = foodService.getDietStandard(uid);

        // 获取用户用餐标准
        DietMealReport report = ReportHelper.getDietMealReport(userStandard, record, type);

        // 已经过了用餐时间，记录用餐记录
        if (isFinishMeal(date, type)) {
            TbDietMealReport mealReport = DataTransferUtils.transferDietMealReport(report, uid, type);
            mealReport.setGmtCreate(date);
            boolean result = updateMealReportOnly(mealReport);
            if (result) {
                logger.info("tb_diet_meal_report insert/update success, date:{} and uid:{} and type:{}", date, uid, type);
            } else {
                logger.error("tb_diet_meal_report insert/update fail, date:{} and uid:{} and type:{}", date, uid, type);
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

    private Evaluation countProteinEvaluation(int uid, Date startDate, Date endDate, String name) {
        int excellentTotal, goodTotal, badTotal;
        excellentTotal = countProteinEvaluation(uid, startDate, endDate, EXCELLENT);
        goodTotal = countProteinEvaluation(uid, startDate, endDate, GOOD);
        badTotal = countProteinEvaluation(uid, startDate, endDate, BAD);

        double score;
        if (WEEKLY_NAME.equals(name)) {
            score = ReportHelper.getWeeklyScore(excellentTotal, goodTotal, badTotal, 0);
        } else {
            score = ReportHelper.getMonthScore(excellentTotal, goodTotal, badTotal, 0);
        }

        return new Evaluation(excellentTotal, goodTotal, badTotal, score);
    }

    private Evaluation countFatEvaluation(int uid, Date startDate, Date endDate, String name) {
        int excellentTotal, goodTotal, badTotal;
        excellentTotal = countFatEvaluation(uid, startDate, endDate, EXCELLENT);
        goodTotal = countFatEvaluation(uid, startDate, endDate, GOOD);
        badTotal = countFatEvaluation(uid, startDate, endDate, BAD);

        double score;
        if (WEEKLY_NAME.equals(name)) {
            score = ReportHelper.getWeeklyScore(excellentTotal, goodTotal, badTotal, 0);
        } else {
            score = ReportHelper.getMonthScore(excellentTotal, goodTotal, badTotal, 0);
        }

        return new Evaluation(excellentTotal, goodTotal, badTotal, score);
    }

    private Evaluation countColEvaluation(int uid, Date startDate, Date endDate, String name) {
        int excellentTotal, goodTotal, badTotal;
        excellentTotal = countColEvaluation(uid, startDate, endDate, EXCELLENT);
        goodTotal = countColEvaluation(uid, startDate, endDate, GOOD);
        badTotal = countColEvaluation(uid, startDate, endDate, BAD);

        double score;
        if (WEEKLY_NAME.equals(name)) {
            score = ReportHelper.getWeeklyScore(excellentTotal, goodTotal, badTotal, 0);
        } else {
            score = ReportHelper.getMonthScore(excellentTotal, goodTotal, badTotal, 0);
        }

        return new Evaluation(excellentTotal, goodTotal, badTotal, score);
    }

    private Evaluation countFibrinEvaluation(int uid, Date startDate, Date endDate, String name) {
        int excellentTotal, goodTotal, badTotal;
        excellentTotal = countFibrinEvaluation(uid, startDate, endDate, EXCELLENT);
        goodTotal = countFibrinEvaluation(uid, startDate, endDate, GOOD);
        badTotal = countFibrinEvaluation(uid, startDate, endDate, BAD);

        double score;
        if (WEEKLY_NAME.equals(name)) {
            score = ReportHelper.getWeeklyScore(excellentTotal, goodTotal, badTotal, 0);
        } else {
            score = ReportHelper.getMonthScore(excellentTotal, goodTotal, badTotal, 0);
        }

        return new Evaluation(excellentTotal, goodTotal, badTotal, score);
    }

    private boolean isFinishMeal(Date date, int type) {
        Date now = new Date();

        if (type == BREAKFAST) {
            return DateUtils.isLargerTime(now, DateUtils.getBreakfastEndTime(date));
        } else if (type == LUNCH) {
            return DateUtils.isLargerTime(now, DateUtils.getLunchEndTime(date));
        } else if (type == DINNER) {
            return DateUtils.isLargerTime(now, DateUtils.getDinnerEndTime(date));
        } else if (type == DAILY) {
            return DateUtils.isLargerTime(now, DateUtils.getDateEnd(date));
        } else if (type == WEEKLY) {
            return DateUtils.isLargerTime(now, DateUtils.getCurrentWeekEnd(date));
        } else if (type == MONTH) {
            return DateUtils.isLargerTime(now, DateUtils.getNextMonthStartDate(date));
        } else {
            logger.error("isFinishMeal type out of index, date: {}  type: {}", date, type);
            return false;
        }
    }

    /**
     * 创建每周饮食报告
     *
     * @param report 每周饮食报告
     * @return 插入结果
     */
    @Override
    public boolean insert(TbDietWeeklyReport report) {
        if (report.getGmtCreate() == null) {
            report.setGmtCreate(new Date());
        }
        return weeklyReportMapper.insertSelective(report) > 0;
    }

    /**
     * 更新每周饮食报告
     *
     * @param report 每周饮食报告
     * @return 更新结果
     */
    @Override
    public boolean update(TbDietWeeklyReport report) {
        if (report.getGmtModified() == null) {
            report.setGmtModified(new Date());
        }
        return weeklyReportMapper.updateByPrimaryKeySelective(report) > 0;
    }

    /**
     * 创建每周饮食报告
     *
     * @param id 报告编号
     * @return 插入结果
     */
    @Override
    public boolean deleteWeeklyReport(int id) {
        return weeklyReportMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 获取每周饮食报告
     *
     * @param id 饮食报告id
     * @return 饮食报告
     */
    @Override
    public TbDietWeeklyReport getDietWeeklyReport(int id) {
        return weeklyReportMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取每周饮食报告
     *
     * @param date 日期
     * @param uid  用户编号
     * @return 每周饮食报告
     */
    @Override
    public TbDietWeeklyReport getDietWeeklyReport(Date date, int uid) {
        return listDietWeeklyReport(DateUtils.getCurrentWeekStart(date), DateUtils.getCurrentWeekEnd(date), uid).get(0);
    }


    /**
     * 获取某段时间的饮食报告
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param uid       用户编号
     * @return 饮食报告
     */
    @Override
    public List<TbDietWeeklyReport> listDietWeeklyReport(Date startDate, Date endDate, int uid) {
        TbDietWeeklyReportExample example = new TbDietWeeklyReportExample();
        example.createCriteria()
                .andGmtCreateBetween(DateUtils.getCurrentWeekStart(startDate), DateUtils.getCurrentWeekEnd(endDate))
                .andUserIdEqualTo(uid);
        return weeklyReportMapper.selectByExample(example);
    }

    /**
     * 获取每周饮食报告记录
     *
     * @param date 某周的其中一天（周日为第一天）
     * @param uid  用户编号
     * @return 用户编号
     */
    @Override
    public int countWeeklyReport(Date date, int uid) {
        return countWeeklyReport(DateUtils.getCurrentWeekStart(date), DateUtils.getCurrentWeekEnd(date), uid);
    }

    /**
     * 生成每月饮食评价
     *
     * @param date 当月日期（1～31）
     * @param uid  用户id
     * @return 每周饮食评价
     */
    @Override
    public DietMonthReport generateMonthReport(Date date, Integer uid) {
        // 获取菜式id列表
        List<Integer> foodIdList = listFoodId(foodService.listFoodRecord(uid, date, MONTH));

        Date startDate = DateUtils.getMonthStartDate(date);
        Date endDate = DateUtils.getNextMonthStartDate(date);

        // 获取每天元素总量
        List<TbDietRecord> recordList = dietRecordService.listDietMealRecord(startDate, endDate, uid, DAILY);

        // 获取每天饮食记录总量
        TbDietRecord record = foodService.getDietRecord(recordList);

        List<TbDietDailyReport> reportList = listDietDailyReport(startDate, endDate, uid);

        TbDietUserStandard userStandard = foodService.getDietStandard(uid);

        DietMonthReport report = ReportHelper.getDietMonthReport(userStandard, record, reportList, recordList);

        // 营养素评价统计
        WeeklyNutrientsEvaluation nutrientsEvaluation = report.getWeeklyNutrientsEvaluation();
        nutrientsEvaluation.setNutrientsEvaluation(countNutrientEvaluation(uid, startDate, endDate, MONTH_NAME));
        nutrientsEvaluation.setScore(ReportHelper.getMonthScore(nutrientsEvaluation, WEEKLY_NUTRIENT_SIZE));
        report.setWeeklyNutrientsEvaluation(nutrientsEvaluation);

        // 早午晚餐能量评价统计
        report.setBreakfast(countMealEnergyEvaluation(uid, startDate, endDate, BREAKFAST, MONTH_NAME));
        report.setLunch(countMealEnergyEvaluation(uid, startDate, endDate, LUNCH, MONTH_NAME));
        report.setDinner(countMealEnergyEvaluation(uid, startDate, endDate, DINNER, MONTH_NAME));

//        // 储存报告
//        if (isFinishMeal(date, MONTH)) {
//            TbDietWeeklyReport weeklyReport = DataTransferUtils.transferWeeklyReport(report);
//
//            weeklyReport.setUserId(uid);
//            weeklyReport.setGmtModified(new Date());
//            boolean result;
//            if (countWeeklyReport(date, uid) == 0) {
//                weeklyReport.setGmtCreate(date);
//                result = insert(weeklyReport);
//            } else {
//                int id = getWeeklyReportId(date, uid);
//                weeklyReport.setId(id);
//                result = update(weeklyReport);
//            }
//
//            if (result) {
//                logger.info("tb_diet_weekly_report insert or update success, date:{} and uid:{} ", date, uid);
//            } else {
//                logger.error("tb_diet_weekly_report insert or update fail, date:{} and uid:{}", date, uid);
//            }
//        }

        return report;
    }

    /**
     * 获取报告id
     *
     * @param date 报告日期
     * @param uid  用户编号
     * @return 用户类型
     */
    @Override
    public int getWeeklyReportId(Date date, int uid) {
        return listDietWeeklyReport(DateUtils.getCurrentWeekStart(date), DateUtils.getCurrentWeekEnd(date), uid).get(0).getId();
    }


    private int countWeeklyReport(Date startDate, Date endDate, int uid) {
        TbDietWeeklyReportExample example = new TbDietWeeklyReportExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andGmtCreateBetween(startDate, endDate);
        return (int) weeklyReportMapper.countByExample(example);
    }
}
