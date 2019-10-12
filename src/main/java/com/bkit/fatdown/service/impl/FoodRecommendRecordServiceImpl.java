package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.common.utils.DateUtils;
import com.bkit.fatdown.component.ReportHelper;
import com.bkit.fatdown.dto.diet.DietWeeklyReport;
import com.bkit.fatdown.dto.diet.common.WeeklyNutrientsEvaluation;
import com.bkit.fatdown.dto.food.RecommendTypeDTO;
import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.mappers.TbFoodRecommendRecordMapper;
import com.bkit.fatdown.service.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @file: FoodRecommendRecordServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 菜式推荐记录功能实现类
 * @date: Created in 7/30/19  4:18 PM
 * @modified:
 * @version: 1.0
 */
@Service
public class FoodRecommendRecordServiceImpl implements IFoodRecommendRecordService {
    @Resource
    private TbFoodRecommendRecordMapper recordMapper;

    @Resource
    private IDietReportService reportService;

    @Resource
    private IFoodRecommendService recommendService;

    @Resource
    private IFoodRecommendTypeService typeService;

    @Resource
    private IDietRecordService dietRecordService;


    /**
     * 创建推荐菜式记录
     *
     * @param record 菜式记录
     * @return 创建结果
     */
    @Override
    public boolean insert(TbFoodRecommendRecord record) {
        if (record.getGmtCreate() == null) {
            record.setGmtCreate(new Date());
            record.setGmtModified(new Date());
        }
        return recordMapper.insertSelective(record) > 0;
    }

    /**
     * 更新推荐菜式记录
     *
     * @param record 菜式记录
     * @return 更新结果
     */
    @Override
    public boolean update(TbFoodRecommendRecord record) {
        if (record.getGmtModified() == null) {
            record.setGmtModified(new Date());
        }
        return recordMapper.updateByPrimaryKeySelective(record) > 0;
    }

    /**
     * 删除推荐菜式记录
     *
     * @param id 菜式id
     * @return 删除结果
     */
    @Override
    public boolean delete(int id) {
        return recordMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 获取记录id
     *
     * @param uid      用户id
     * @param date     记录日期
     * @param foodType 菜式类型
     * @return 记录id
     */
    @Override
    public int getFoodRecommendRecordId(int uid, Date date, int foodType) {
        TbFoodRecommendRecordExample example = new TbFoodRecommendRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andFoodTypeEqualTo(foodType)
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date));
        return recordMapper.selectByExample(example).get(0).getId();
    }

    /**
     * 获取记录id
     *
     * @param uid      用户id
     * @param date     记录日期
     * @param foodType 菜式类型
     * @return 记录id
     */
    @Override
    public int getFoodRecommendRecordId(int uid, Date date, int foodType,int reportType) {
        TbFoodRecommendRecordExample example = new TbFoodRecommendRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andFoodTypeEqualTo(foodType)
                .andReportTypeEqualTo(reportType)
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date));
        return recordMapper.selectByExample(example).get(0).getId();
    }

    /**
     * 获取某天，推荐菜式记录数
     *
     * @param uid        用户id
     * @param date       记录日期
     * @param reportType 报告类型
     * @return 记录数
     */
    @Override
    public int countFoodRecommendRecordByDate(int uid, Date date, Integer reportType) {
        TbFoodRecommendRecordExample example = new TbFoodRecommendRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date))
                .andReportTypeEqualTo(reportType);
        return (int) recordMapper.countByExample(example);
    }




    /**
     * 更新菜式，选择记录 不存在时，创建记录
     *
     * @param record 记录
     * @return 创建结果
     */
    @Override
    public boolean updateOnlyRecord(TbFoodRecommendRecord record) {
        // 记录存在，更新记录
        if (countFoodRecommendRecord(record.getUserId(), record.getGmtCreate(), record.getFoodType(),record.getReportType()) > 0) {
            int id = getFoodRecommendRecordId(record.getUserId(), record.getGmtCreate(), record.getFoodType(),record.getReportType());
            record.setId(id);
            record.setGmtModified(new Date());
            return update(record);
        }

        return insert(record);
    }

    @Override
    public TbFoodRecommendRecord get(int id) {
        return recordMapper.selectByPrimaryKey(id);
    }

    /**
     * 统计推荐菜式
     *
     * @param uid      用户id
     * @param date     记录日期
     * @param foodType 菜式类型
     * @return 返回结果
     */
    @Override
    public int countFoodRecommendRecord(int uid, Date date, int foodType) {
        TbFoodRecommendRecordExample example = new TbFoodRecommendRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andFoodTypeEqualTo(foodType)
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date));
        return (int) recordMapper.countByExample(example);
    }

    /**
     * 统计推荐菜式
     *
     * @param uid      用户id
     * @param date     记录日期
     * @param foodType 菜式类型
     * @return 返回结果
     */
    @Override
    public int countFoodRecommendRecord(int uid, Date date, int foodType, int reportType) {
        TbFoodRecommendRecordExample example = new TbFoodRecommendRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andFoodTypeEqualTo(foodType)
                .andReportTypeEqualTo(reportType)
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date));
        return (int) recordMapper.countByExample(example);
    }

    /**
     * 查找指定日期推荐菜式记录
     *
     * @param uid  用户id
     * @param date 记录日期
     * @return 推荐记录
     */
    @Override
    public List<TbFoodRecommendRecord> listFoodRecommendRecord(int uid, Date date, Integer reportType) {
        TbFoodRecommendRecordExample example = new TbFoodRecommendRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andReportTypeEqualTo(reportType)
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date));
        return recordMapper.selectByExample(example);
    }

    /**
     * 获取每天菜式推荐情况
     *
     * @param date 日期
     * @param uid  用户id
     * @return 多或少
     */
    @Override
    public List<RecommendTypeDTO> getDailyRecommend(Date date, Integer uid) {
        Integer daily = 4;

        return new ArrayList<>(getMainFoodRecommend(date, uid,daily));
    }

    /**
     * 获取每周菜式推荐情况
     *
     * @param date 日期
     * @param uid  用户id
     * @return 多或少
     */
    @Override
    public List<RecommendTypeDTO> getWeeklyRecommend(Date date, Integer uid) {
        Integer weekly = 5;
        List<RecommendTypeDTO> list = new ArrayList<>(getMainFoodRecommend(date, uid, weekly));

        // 优质蛋白，动物性脂肪
        DietWeeklyReport report = reportService.generateWeeklyReport(date, uid);
        list.addAll(listAnimalFatAndGoodProtein(report.getWeeklyNutrientsEvaluation(), uid, date));

        return list;
    }

    private List<RecommendTypeDTO> getMainFoodRecommend(Date date, Integer uid, Integer reportType) {

        List<TbDietDailyReport> reportList;
        int weekly = 5;
        int monthly =6;

        // 获取每日报告
        if (reportType == weekly) {
            reportList = reportService.listDietDailyReport(DateUtils.getCurrentWeekStart(date),
                    DateUtils.getCurrentWeekEnd(date), uid);
        } else if (reportType == monthly){
            reportList = reportService.listDietDailyReport(DateUtils.getMonthStartDate(date),
                    DateUtils.getNextMonthStartDate(date), uid);
        } else {
            reportList = reportService.listDietDailyReport(DateUtils.getDateStart(date),
                    DateUtils.getDateEnd(date), uid);
        }

        // 主要营养素
        double fatTotal = 0;
        double proteinTotal = 0;
        double colTotal = 0;
        double fibrinTotal = 0;

        for (TbDietDailyReport report : reportList) {
            fatTotal += report.getFatPer();
            proteinTotal += report.getProteinPer();
            colTotal += report.getColPer();
            fibrinTotal += report.getFibrinPer();
        }

        int size = reportList.size();

        // 获取下列成分的值
        double fatPer = fatTotal / size;
        double proteinPer = proteinTotal / size;
        double colPer = colTotal / size;
        double fibrinPer = fibrinTotal / size;

        // 判断是否符合标准
        Map<Integer, Integer> result = ReportHelper.getDailyLackFoodRecommend(fatPer, proteinPer, colPer, fibrinPer);
        // 偏多或者偏少
        int more = 1;
        int lack = 2;

        List<Integer> lackList = getEqualsList(result, lack);
        List<Integer> moreList = getEqualsList(result, more);

        List<RecommendTypeDTO> list = new ArrayList<>();

        list.addAll(listTypeInfo(lackList, lack, uid, date));
        list.addAll(listTypeInfo(moreList, more, uid, date));
        return list;
    }

    // 优质蛋白，动物性脂肪
    private List<RecommendTypeDTO> listAnimalFatAndGoodProtein(WeeklyNutrientsEvaluation weeklyNutrientsEvaluation, Integer uid, Date date) {
        List<RecommendTypeDTO> list = new ArrayList<>();

        int animalFat = weeklyNutrientsEvaluation.getAnimalFat().getEvaluation();
        if (animalFat != 0) {
            List<Integer> integers = new ArrayList<>();
            integers.add(8);
            list.addAll(listTypeInfo(integers, animalFat, uid, date));
        }

        int goodProtein = weeklyNutrientsEvaluation.getGoodProtein().getEvaluation();
        if (goodProtein != 0) {
            List<Integer> integers = new ArrayList<>();
            integers.add(7);
            list.addAll(listTypeInfo(integers, goodProtein, uid, date));
        }
        return list;
    }

    // 获取菜式信息与选择记录
    private List<RecommendTypeDTO> listTypeInfo(List<Integer> list, Integer value, Integer uid, Date date) {

        List<RecommendTypeDTO> result = new ArrayList<>();

        RecommendTypeDTO typeDTO;
        for (Integer type : list) {
            typeDTO = new RecommendTypeDTO();
            // 获取对应类型食物信息, 默认显示10条
            List<TbFoodRecommend> foodList = recommendService.listFoodRecommend(type, 1, 10);
            String typeName = typeService.getTypeInfo(type).getTypeName();
            typeDTO.setFoodList(foodList);
            typeDTO.setTypeName(typeName);
            typeDTO.setStatus(value);
            typeDTO.setTypeId(type);
            // 默认情况,0 未选
            typeDTO.setChooseId(0);
            // 获取选择情况
            if (countFoodRecommendRecord(uid, date, type) > 0) {
                int id = getFoodRecommendRecordId(uid, date, type);
                TbFoodRecommendRecord recommendRecord = get(id);
                typeDTO.setChooseId(recommendRecord.getFoodRecommendId());
            }

            result.add(typeDTO);
        }

        return result;
    }

    /**
     * 获取每月菜式推荐信息
     *
     * @param date 日期
     * @param uid  用户编号
     * @return 获取每月菜式推荐信息。
     */
    @Override
    public List<RecommendTypeDTO> getMonthRecommend(Date date, Integer uid) {
        // 获取一个月饮食报告

        List<TbDietRecord> dietRecordList = dietRecordService.listDietMealRecord(DateUtils.getMonthStartDate(date),
                DateUtils.getNextMonthStartDate(date), uid, 4);

        double pTotal = 0;
        double kTotal = 0;
        double seTotal = 0;
        double feTotal = 0;
        double cuTotal = 0;
        double znTotal = 0;
        double caTotal = 0;
        double mgTotal = 0;
        double mnTotal = 0;

        double vATotal = 0;
        double vB1Total = 0;
        double vB2Total = 0;
        double vB3Total = 0;
        double vCTotal = 0;
        double vETotal = 0;

        for (TbDietRecord record : dietRecordList) {
            seTotal += record.getSe();
            pTotal += record.getP();
            feTotal += record.getFe();
            cuTotal += record.getCu();
            znTotal += record.getZn();
            mgTotal += record.getMg();
            caTotal += record.getCa();
            mnTotal += record.getMn();
            kTotal += record.getK();

            vATotal += record.getVitaminA();
            vB1Total += record.getVitaminB1();
            vB2Total += record.getVitaminB2();
            vB3Total += record.getVitaminB3();
            vCTotal += record.getVitaminC();
            vETotal += record.getVitaminE();
        }

        int size = dietRecordList.size();

        // 获取下列成分的值
        double pPer = pTotal / size;
        double kPer = kTotal / size;
        double sePer = seTotal / size;
        double fePer = feTotal / size;
        double cuPer = cuTotal / size;
        double znPer = znTotal / size;

        double caPer = caTotal / size;
        double mgPer = mgTotal / size;
        double mnPer = mnTotal / size;

        double vAPer = vATotal / size;
        double vB1Per = vB1Total / size;
        double vB2Per = vB2Total / size;
        double vB3Per = vB3Total / size;
        double vCPer = vCTotal / size;
        double vEPer = vETotal / size;


        // 判断是否符合标准
        Map<Integer, Integer> result = ReportHelper.getDailyLackFoodRecommend(vAPer, vB1Per, vB2Per, vB3Per, vCPer, vEPer, mnPer,
                caPer, znPer, pPer, kPer, cuPer, sePer, mgPer, fePer);

        // 偏多或者偏少
        int more = 1;
        int lack = 2;

        List<Integer> lackList = getEqualsList(result, lack);
        List<Integer> moreList = getEqualsList(result, more);

        List<RecommendTypeDTO> list = new ArrayList<>(30);

        int monthly = 6;
        // 添加主要营养素和优质蛋白质，动物性脂肪。
        list.addAll(getMainFoodRecommend(date, uid,monthly));

        // 优质蛋白，动物性脂肪
        DietWeeklyReport report = reportService.generateMonthReport(date, uid);
        list.addAll(listAnimalFatAndGoodProtein(report.getWeeklyNutrientsEvaluation(), uid, date));

        // 设置月评价情况
        list.addAll(listTypeInfo(lackList, lack, uid, date));
        list.addAll(listTypeInfo(moreList, more, uid, date));

        return list;
    }

    /**
     * 获取相同值的下标
     *
     * @param result map
     * @param value  相同值
     * @return 相同值的下标
     */
    private List<Integer> getEqualsList(Map<Integer, Integer> result, int value) {

        List<Integer> list = new ArrayList<>(30);

        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            if (entry.getValue() == value) {
                list.add(entry.getKey());
            }
        }

        return list;
    }
}
