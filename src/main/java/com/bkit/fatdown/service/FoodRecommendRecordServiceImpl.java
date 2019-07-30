package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbFoodRecommendRecord;
import com.bkit.fatdown.entity.TbFoodRecommendRecordExample;
import com.bkit.fatdown.mappers.TbFoodRecommendRecordMapper;
import com.bkit.fatdown.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
     * @param uid  用户id
     * @param date 记录日期
     * @return 记录数
     */
    @Override
    public int countFoodRecommendRecordByDate(int uid, Date date) {
        return listFoodRecommendRecord(uid, date).size();
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
            record.setGmtModified(new Date());
            return update(record);
        }

        return insert(record);
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
    public List<TbFoodRecommendRecord> listFoodRecommendRecord(int uid, Date date) {
        TbFoodRecommendRecordExample example = new TbFoodRecommendRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date));
        return recordMapper.selectByExample(example);
    }


}
