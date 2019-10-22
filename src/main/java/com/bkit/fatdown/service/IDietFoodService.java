package com.bkit.fatdown.service;

import com.bkit.fatdown.dto.diet.MealEvaluationDTO;
import com.bkit.fatdown.dto.food.FoodRecordDTO;
import com.bkit.fatdown.dto.food.FoodRecordInfoDTO;
import com.bkit.fatdown.entity.TbDietRecord;
import com.bkit.fatdown.entity.TbDietUserStandard;
import com.bkit.fatdown.entity.TbFoodRecord;

import java.util.Date;
import java.util.List;

/**
 * @file: IDietFoodService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 饮食功能接口
 * @date: Created in 7/22/19  4:25 PM
 * @modified:
 * @version: 1.0
 */

public interface IDietFoodService {

    /**
     * 保存饮食记录
     *
     * @param record
     * @return
     */
    boolean insert(TbFoodRecord record);

    /**
     * 获取饮食记录
     *
     * @param id 获取饮食记录
     * @return 饮食记录
     */
    TbFoodRecord getFoodRecord(int id);


    boolean delete(int recordId);

    /**
     * 删除饮食记录
     *
     * @param uid 用户id
     * @param url 图片路径
     * @return 删除结果
     */
    boolean delete(int uid, String url);

    /**
     * 获取用户某天饮食记录
     *
     * @param uid
     * @param date
     * @return
     */
    List<TbFoodRecord> listFoodRecordByDate(int uid, Date date);

    /**
     * 创建饮食标准
     *
     * @param standard
     * @return
     */
    boolean insertDietStandard(TbDietUserStandard standard);

    /**
     * 更新饮食标准
     *
     * @param standard
     * @return
     */
    boolean updateDietStandard(TbDietUserStandard standard);

    /**
     * 通过用户信息更新饮食标准
     *
     * @param uid
     * @return
     */
    boolean updateDietStandardByUid(int uid);

    /**
     * 通过用户编号获取饮食标准
     *
     * @param uid
     * @return
     */
    TbDietUserStandard getDietStandard(int uid);

    /**
     * 获取菜式名称和重量
     *
     * @param uid
     * @param date
     * @param type
     * @return
     */
    List<FoodRecordInfoDTO> listFoodInfoDTO(int uid, Date date, Integer type);

    TbDietRecord getDietRecord(List<TbDietRecord> recordList);

    /**
     * 返回菜式列表
     *
     * @param uid
     * @param date
     * @param type
     * @return
     */
    List<TbFoodRecord> listFoodRecord(int uid, Date date, Integer type);

    /**
     * 返回菜式列表
     *
     * @param uid
     * @param date
     * @param type
     * @return
     */
    List<FoodRecordDTO> listFoodRecord(int uid, Date date, Integer type, Integer pageNum, Integer pageSize);

    Integer count(int id);

    List<TbFoodRecord> listFoodRecord(Integer uid, Date startDate, Date endDate, Integer pageNum, Integer pageSize);

    List<TbFoodRecord> listFoodRecord(Integer uid, Integer pageNum, Integer pageSize);


    /**
     * 更新饮食食物信息
     *
     * @param foodRecord 饮食食物信息
     * @return 更新情况
     */
    boolean updateFoodRecord(TbFoodRecord foodRecord);

    /**
     * 通过 食物记录，获取元素总和
     *
     * @param foodId 食物编号
     * @param eatPer 食用度
     * @param gram 食物重量
     * @return 元素总和
     */
    TbDietRecord generateDietRecord(int foodId, double eatPer,double gram);

    /**
     * 返回元素总和
     *
     * @param recordList 食物记录
     * @return 食物元素总和
     */
    TbDietRecord getDietRecordTotal(List<TbFoodRecord> recordList);

    List<TbFoodRecord> listFoodRecord(int uid, Date start, Date end, Integer pageNum, Integer pageSize);

    TbDietRecord mergeDietRecord(TbDietRecord target, TbDietRecord temp);

    /**
     * 获取饮食分配
     * @param recordId 用餐记录
     * @return 当餐饮食分配情况
     */
    MealEvaluationDTO getEvaluationByRecordId(Integer recordId);
}
