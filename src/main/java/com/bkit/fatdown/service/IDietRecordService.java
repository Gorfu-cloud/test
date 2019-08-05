package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbDietRecord;

import java.util.Date;
import java.util.List;

/**
 * @file: IDietRecordService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 饮食元素记录接口
 * @date: Created in 7/30/19  9:30 PM
 * @modified:
 * @version: 1.0
 */
public interface IDietRecordService {
    /**
     * 创建饮食成分记录
     *
     * @param record 饮食成分记录
     * @return 结果
     */
    boolean insert(TbDietRecord record);

    /**
     * 更新饮食成分记录
     *
     * @param record 饮食成分记录
     * @return 结果
     */
    boolean update(TbDietRecord record);

    /**
     * 更新饮食成分记录
     *
     * @param record 饮食成分记录
     * @return 结果
     */
    boolean updateOnlyRecord(TbDietRecord record);

    /**
     * 删除饮食成分记录
     *
     * @param id 饮食成分记录编号
     * @return 结果
     */
    boolean delete(int id);

    /**
     * 通过id，获取饮食成分记录
     *
     * @param id 饮食成分记录编号
     * @return 饮食成分记录
     */
    TbDietRecord getDietRecord(int id);

    /**
     * 饮食成分记录
     *
     * @param date 记录日期
     * @param uid  用户id
     * @param type 饮食类型：0 早餐， 1 午餐， 2 晚餐， 3 加餐， 4 每日， 5 每周， 6每月
     * @return 饮食成分记录编号
     */
    int getDietRecordId(Date date, int uid, int type);

    /**
     * 统计饮食成分记录
     *
     * @param id 饮食成分记录编号
     * @return 记录数
     */
    int countDietRecord(int id);

    /**
     * 统计饮食成分记录
     *
     * @param date 记录日期
     * @param uid  用户编号
     * @return 记录数
     */
    int countDietRecord(Date date, int uid);

    /**
     * 统计饮食成分记录
     *
     * @param date 记录日期
     * @param uid  用户id
     * @param type 饮食类型：0 早餐， 1 午餐， 2 晚餐， 3 加餐， 4 每日， 5 每周， 6每月
     * @return 记录数
     */
    int countDietRecord(Date date, int uid, int type);

    /**
     * 获取某天，饮食成分记录列表
     *
     * @param date 记录日期
     * @param uid  用户编号
     * @return 结果
     */
    List<TbDietRecord> listDietRecord(Date date, int uid);

    /**
     * 获取一天饮食三餐记录
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param uid       用户id
     * @return 饮食记录
     */
    List<TbDietRecord> listDietMealRecord(Date startDate, Date endDate, int uid);

    /**
     * 获取一段日期指定类型饮食记录
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param uid       用户id
     * @param type      用餐类型
     * @return 饮食列表
     */
    List<TbDietRecord> listDietMealRecord(Date startDate, Date endDate, int uid, int type);

    /**
     * 获取某天，饮食成分记录
     *
     * @param date     记录日期
     * @param uid      用户id
     * @param typeList 饮食类型：0 早餐， 1 午餐， 2 晚餐， 3 加餐， 4 每日， 5 每周， 6每月
     * @return 结果
     */
    List<TbDietRecord> listDietRecord(Date date, int uid, List<Integer> typeList);

    /**
     * 保存饮食成份记录
     *
     * @param record 饮食记录
     * @param date   饮食日期
     * @param type   饮食类型
     * @param uid    用户id
     * @return 添加结果
     */
    boolean failInsertDietRecord(TbDietRecord record, Date date, Integer type, Integer uid);
}
