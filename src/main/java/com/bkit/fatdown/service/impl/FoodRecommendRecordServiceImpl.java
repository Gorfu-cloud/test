package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.common.utils.DateUtils;
import com.bkit.fatdown.component.ReportHelper;
import com.bkit.fatdown.dto.diet.DietWeeklyReport;
import com.bkit.fatdown.dto.food.RecommendTypeDTO;
import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.mappers.TbFoodRecommendRecordMapper;
import com.bkit.fatdown.service.IDietReportService;
import com.bkit.fatdown.service.IFoodRecommendRecordService;
import com.bkit.fatdown.service.IFoodRecommendService;
import com.bkit.fatdown.service.IFoodRecommendTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        if (countFoodRecommendRecord(record.getUserId(), record.getGmtCreate(), record.getFoodType()) > 0) {
            int id = getFoodRecommendRecordId(record.getUserId(), record.getGmtCreate(), record.getFoodType());
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
     * 查找指定日期推荐菜式记录
     *
     * @param uid  用户id
     * @param date 记录日期
     * @return 推荐记录
     */
    @Override
    public List<TbFoodRecommendRecord> listFoodRecommendRecord(int uid, Date date,Integer reportType) {
        TbFoodRecommendRecordExample example = new TbFoodRecommendRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andReportTypeEqualTo(reportType)
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date));
        return recordMapper.selectByExample(example);
    }

    /**
     * 获取每周菜式推荐情况
     *
     * @param date 日期
     * @param uid 用户id
     * @return 多或少
     */
    @Override
    public List<RecommendTypeDTO> getWeeklyRecommend(Date date, Integer uid) {

        // 获取每日报告
        List<TbDietDailyReport> reportList = reportService.listDietDailyReport(DateUtils.getCurrentWeekStart(date),
                DateUtils.getCurrentWeekEnd(date), uid);

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
        int[] result = ReportHelper.getDailyLackFoodRecommend(fatPer, proteinPer, colPer, fibrinPer);
        // 偏多或者偏少
        int more = 1;
        int lack = 2;

        List<Integer> lackList = getEqualsList(result, lack);
        List<Integer> moreList = getEqualsList(result, more);

       List<RecommendTypeDTO> list  = new ArrayList<>();

       list.addAll(listTypeInfo(lackList,lack,uid,date));
       list.addAll(listTypeInfo(moreList,more,uid,date));

       // 优质蛋白，动物性脂肪
        DietWeeklyReport report =reportService.generateWeeklyReport(date, uid);
        // 动物性脂肪
        int animalFat =report.getWeeklyNutrientsEvaluation().getAnimalFat().getEvaluation();
        if (animalFat!=0){
            List<Integer> integers = new ArrayList<>();
            integers.add(8);
            list.addAll(listTypeInfo(integers,animalFat,uid,date));
        }

        int goodProtein = report.getWeeklyNutrientsEvaluation().getGoodProtein().getEvaluation();
        if (goodProtein!=0){
            List<Integer> integers = new ArrayList<>();
            integers.add(7);
            list.addAll(listTypeInfo(integers,goodProtein,uid,date));
        }

        return list;
    }

    // 获取菜式信息与选择记录
    private List<RecommendTypeDTO> listTypeInfo(List<Integer> list, Integer value, Integer uid, Date date){

        List<RecommendTypeDTO> result = new ArrayList<>();

        RecommendTypeDTO typeDTO ;
        for (Integer type : list) {
            typeDTO = new RecommendTypeDTO();
            // 获取对应类型食物信息, 默认显示10条
            List<TbFoodRecommend> foodList = recommendService.listFoodRecommend(type, 1, 10);
            String typeName = typeService.getTypeInfo(type).getTypeName();
            typeDTO.setFoodList(foodList);
            typeDTO.setTypeName(typeName);
            typeDTO.setStatus(value);

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
     * 获取相同值的下标
     *
     * @param result 数组
     * @param value  相同值
     * @return 相同值的下标
     */
    private List<Integer> getEqualsList(int[] result, int value) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < result.length; i++) {
            if (result[i] == value) {
                list.add(i);
            }
        }

        return list;
    }
}
