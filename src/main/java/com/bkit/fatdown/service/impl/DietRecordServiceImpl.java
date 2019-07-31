package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.dto.DietMealReport;
import com.bkit.fatdown.entity.TbDietRecord;
import com.bkit.fatdown.entity.TbDietRecordExample;
import com.bkit.fatdown.entity.TbDietUserStandard;
import com.bkit.fatdown.entity.TbFoodRecord;
import com.bkit.fatdown.mappers.TbDietRecordMapper;
import com.bkit.fatdown.service.IDietFoodService;
import com.bkit.fatdown.service.IDietRecordService;
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
 * @file: DietRecordServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 饮食记录功能实现类
 * @date: Created in 7/30/19  9:46 PM
 * @modified:
 * @version: 1.0
 */
@Service
public class DietRecordServiceImpl implements IDietRecordService {

    @Resource
    private TbDietRecordMapper dietRecordMapper;

    @Resource
    private IDietFoodService foodService;

    private static final Logger logger = LoggerFactory.getLogger(DietFoodServiceImpl.class);

    /**
     * 创建饮食成分记录
     *
     * @param record 饮食成分记录
     * @return 结果
     */
    @Override
    public boolean insert(TbDietRecord record) {
        if (record.getGmtCreate() == null) {
            record.setGmtCreate(new Date());
            record.setGmtModified(new Date());
        }
        return dietRecordMapper.insertSelective(record) > 0;
    }

    /**
     * 更新饮食成分记录
     *
     * @param record 饮食成分记录
     * @return 结果
     */
    @Override
    public boolean update(TbDietRecord record) {
        if (record.getGmtCreate() == null) {
            record.setGmtModified(new Date());
        }
        return dietRecordMapper.updateByPrimaryKeySelective(record) > 0;
    }

    /**
     * 更新饮食成分记录,不存在是创建新记录
     *
     * @param record 饮食成分记录
     * @return 结果
     */
    @Override
    public boolean updateOnlyRecord(TbDietRecord record) {
        // 记录不存在
        if (countDietRecord(record.getGmtCreate(), record.getUserId(), record.getType()) == 0) {
            return insert(record);
        }

        int id = getDietRecordId(record.getGmtCreate(), record.getUserId(), record.getType());
        record.setId(id);
        record.setGmtModified(new Date());
        return update(record);
    }

    /**
     * 删除饮食成分记录
     *
     * @param id 饮食成分记录编号
     * @return 结果
     */
    @Override
    public boolean delete(int id) {
        return dietRecordMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 通过id，获取饮食成分记录
     *
     * @param id 饮食成分记录编号
     * @return 饮食成分记录
     */
    @Override
    public TbDietRecord getDietRecord(int id) {
        return dietRecordMapper.selectByPrimaryKey(id);
    }

    /**
     * 饮食成分记录
     *
     * @param date 记录日期
     * @param uid  用户id
     * @param type 饮食类型：0 早餐， 1 午餐， 2 晚餐， 3 加餐， 4 每日， 5 每周， 6每月
     * @return 饮食成分记录编号
     */
    @Override
    public int getDietRecordId(Date date, int uid, int type) {
        TbDietRecordExample example = new TbDietRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andTypeEqualTo(type)
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date));
        return dietRecordMapper.selectByExample(example).get(0).getId();
    }

    /**
     * 统计饮食成分记录
     *
     * @param id 饮食成分记录编号
     * @return 记录数
     */
    @Override
    public int countDietRecord(int id) {
        TbDietRecordExample example = new TbDietRecordExample();
        example.createCriteria()
                .andIdEqualTo(id);
        return (int) dietRecordMapper.countByExample(example);
    }

    /**
     * 统计饮食成分记录
     *
     * @param date 记录日期
     * @param uid  用户编号
     * @return 记录数
     */
    @Override
    public int countDietRecord(Date date, int uid) {
        return listDietRecord(date, uid).size();
    }

    /**
     * 统计饮食成分记录
     *
     * @param date 记录日期
     * @param uid  用户id
     * @param type 饮食类型：0 早餐， 1 午餐， 2 晚餐， 3 加餐， 4 每日， 5 每周， 6每月
     * @return 记录数
     */
    @Override
    public int countDietRecord(Date date, int uid, int type) {
        TbDietRecordExample example = new TbDietRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andTypeEqualTo(type)
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date));
        return (int) dietRecordMapper.countByExample(example);
    }

    /**
     * 获取某天，饮食成分记录列表
     *
     * @param date 记录日期
     * @param uid  用户编号
     * @return 结果
     */
    @Override
    public List<TbDietRecord> listDietRecord(Date date, int uid) {
        TbDietRecordExample example = new TbDietRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date));
        return dietRecordMapper.selectByExample(example);
    }

    /**
     * 获取某天，饮食成分记录
     *
     * @param date     记录日期
     * @param uid      用户id
     * @param typeList 饮食类型：0 早餐， 1 午餐， 2 晚餐， 3 加餐， 4 每日， 5 每周， 6每月
     * @return 结果
     */
    @Override
    public List<TbDietRecord> listDietRecord(Date date, int uid, List<Integer> typeList) {
        TbDietRecordExample example = new TbDietRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date))
                .andTypeIn(typeList);
        return dietRecordMapper.selectByExample(example);
    }

    /**
     * 创建饮食成分记录
     *
     * @param date 记录日期
     * @param uid  用户编号
     * @param type 饮食类型：0 早餐， 1 午餐， 2 晚餐， 3 加餐， 4 每日， 5 每周， 6每月
     * @return 饮食成分记录
     */
    @Override
    public DietMealReport generateDietReport(Date date, Integer uid, Integer type) {
        // 获取菜式id列表
        List<Integer> foodIdList = listFoodId(foodService.listFoodBasic(uid, date, type));
        // 计算菜式组成成分总量
        TbDietRecord record = foodService.getDietRecordTotalByFoodList(foodIdList);

        TbDietUserStandard userStandard = foodService.getDietStandard(uid);

//        if (!saveReport(reportDTO, uid, type, date)) {
//            logger.error("tb_diet_report insert or update false，uid：{} and type：{} at date：{}", uid, type, date);
//        }

        return MathUtils.getDietMealReport(userStandard, record, type);

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

//    private boolean saveReport() {
////        logger.info("tb_diet_report insert or update start,uid：{} and type：{} at date：{}", uid, type, date);
//
////        TbDietReport report = reportDTO2DietReport(reportDTO);
////        report.setUserId(uid);
////        report.setType(type);
////        report.setGmtModified(date);
////
////        // 新建记录
////        if (countReport(date, uid, type) == 0) {
////            report.setGmtCreate(date);
////            return insert(report);
////        }
////
////        // 获取饮食记录id，并更新
////        int id = getIdByUidType(uid, type, date);
////        report.setId(id);
////        return update(report);
//    }
}
