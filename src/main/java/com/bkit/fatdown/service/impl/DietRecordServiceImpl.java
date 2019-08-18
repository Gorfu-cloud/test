package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbDietRecord;
import com.bkit.fatdown.entity.TbDietRecordExample;
import com.bkit.fatdown.entity.TbFoodRecord;
import com.bkit.fatdown.mappers.TbDietRecordMapper;
import com.bkit.fatdown.service.IDietFoodService;
import com.bkit.fatdown.service.IDietRecordService;
import com.bkit.fatdown.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
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
        }
        record.setGmtModified(new Date());
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
        record.setGmtModified(new Date());
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
     * 获取饮食记录
     *
     * @param date 日期
     * @param uid  用户id
     * @param type 类型
     * @return 饮食记录总量
     */
    @Override
    public TbDietRecord getDietRecord(Date date, int uid, int type) {
        TbDietRecordExample example = new TbDietRecordExample();
        example.createCriteria()
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date))
                .andTypeEqualTo(type)
                .andUserIdEqualTo(uid);
        return dietRecordMapper.selectByExample(example).get(0);
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
     * @param date 日期
     * @param uid  用户id
     * @return 是否成功
     */
    @Override
    public boolean updateDailyDietRecord(Date date, int uid) {
        int type = 4;
        return updateDietRecord(date, uid, type);
    }

    /**
     * 更新 饮食成分记录每天
     *
     * @param uid 用户id
     * @return 更新是否成功
     */
    @Override
    public boolean updateDailyDietRecord(int uid) {
        Date now = new Date();
        int type = 4;
        return updateDietRecord(now, uid, type);
    }

    @Override
    public boolean updateDietRecord(Date now, int uid, int type) {
        List<TbFoodRecord> foodRecordList = foodService.listFoodRecord(uid, now, type);

        // 统计食用成分总量
        TbDietRecord record = foodService.getDietRecordTotal(foodRecordList);

        record.setUserId(uid);
        record.setType(type);
        record.setGmtCreate(now);

        return updateOnlyRecord(record);
    }

    /**
     * 更新 饮食成分记录(每餐和每天）
     *
     * @param uid 用户id
     * @return 更新是否成功
     */
    @Override
    public boolean updateDietRecord(int uid) {
        Date now = new Date();
        int type = DateUtils.getMealType(now);
        return updateDietRecord(now, uid, type);
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
     * 获取一天饮食三餐记录
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param uid       用户id
     * @return 饮食记录
     */
    @Override
    public List<TbDietRecord> listDietMealRecord(Date startDate, Date endDate, int uid) {
        TbDietRecordExample example = new TbDietRecordExample();
        example.createCriteria()
                .andGmtCreateBetween(startDate, endDate)
                .andUserIdEqualTo(uid)
                .andTypeLessThanOrEqualTo(3);
        return dietRecordMapper.selectByExample(example);
    }

    /**
     * 获取一段日期指定类型饮食记录
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param uid       用户id
     * @param type      用餐类型
     * @return 饮食列表
     */
    @Override
    public List<TbDietRecord> listDietMealRecord(Date startDate, Date endDate, int uid, int type) {
        TbDietRecordExample example = new TbDietRecordExample();
        example.createCriteria()
                .andGmtCreateBetween(startDate, endDate)
                .andUserIdEqualTo(uid)
                .andTypeEqualTo(type);
        return dietRecordMapper.selectByExample(example);
    }

    /**
     * 统计饮食成分记录
     *
     * @param date 某周的一天
     * @param uid  用户编号
     * @return 记录数
     */
    @Override
    public int countWeeklyDietRecord(Date date, int uid) {
        TbDietRecordExample example = new TbDietRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                // 求早午晚餐
                .andTypeLessThanOrEqualTo(4)
                .andGmtCreateBetween(DateUtils.getCurrentWeekStart(date), DateUtils.getCurrentWeekEnd(date));
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
}
