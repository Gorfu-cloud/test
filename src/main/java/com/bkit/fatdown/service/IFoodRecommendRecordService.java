package com.bkit.fatdown.service;

import com.bkit.fatdown.dto.food.RecommendTypeDTO;
import com.bkit.fatdown.entity.TbFoodRecommendRecord;

import java.util.Date;
import java.util.List;

/**
 * @file: IFoodRecommendRecordService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 推荐菜式记录类
 * @date: Created in 7/30/19  4:11 PM
 * @modified:
 * @version: 1.0
 */

public interface IFoodRecommendRecordService {
    /**
     * 创建推荐菜式记录
     *
     * @param record 菜式记录
     * @return 创建结果
     */
    boolean insert(TbFoodRecommendRecord record);

    /**
     * 更新推荐菜式记录
     *
     * @param record 菜式记录
     * @return 更新结果
     */
    boolean update(TbFoodRecommendRecord record);

    /**
     * 删除推荐菜式记录
     *
     * @param id 菜式id
     * @return 删除结果
     */
    boolean delete(int id);

    int countFoodRecommendRecord(int uid, Date date, int foodType, int reportType);

    /**
     * 查找推荐菜式记录
     *
     * @param uid  用户id
     * @param date 记录日期
     * @return 推荐记录
     */
    List<TbFoodRecommendRecord> listFoodRecommendRecord(int uid, Date date,Integer reportType);

    /**
     * 统计推荐菜式记录
     *
     * @param uid      用户id
     * @param date     记录日期
     * @param foodType 菜式类型
     * @return 返回记录数
     */
    int countFoodRecommendRecord(int uid, Date date, int foodType);

    TbFoodRecommendRecord get(int id);

    /**
     * 获取记录id
     *
     * @param uid      用户id
     * @param date     记录日期
     * @param foodType 菜式类型
     * @return 记录id
     */
    int getFoodRecommendRecordId(int uid, Date date, int foodType);

    /**
     * 更新菜式，选择记录 不存在时，创建记录
     *
     * @param record 记录
     * @return 创建结果
     */
    boolean updateOnlyRecord(TbFoodRecommendRecord record);

    int getFoodRecommendRecordId(int uid, Date date, int foodType, int reportType);

    /**
     * 获取某天，推荐菜式记录数
     *
     * @param uid  用户id
     * @param date 记录日期
     * @param reportType 报告类型
     * @return 记录数
     */
    int countFoodRecommendRecordByDate(int uid, Date date,Integer reportType);

    List<RecommendTypeDTO> getDailyRecommend(Date date, Integer uid);

    /**
     *获取每周菜式推荐信息
     * @param date 日期
     * @param uid 用户编号
     * @return 获取每周菜式推荐信息
     */
    List<RecommendTypeDTO> getWeeklyRecommend(Date date, Integer uid);

    /**
     * 获取每月菜式推荐信息
     * @param date 日期
     * @param uid 用户编号
     * @return 获取每月菜式推荐信息。
     */
    List<RecommendTypeDTO> getMonthRecommend(Date date, Integer uid);
}
