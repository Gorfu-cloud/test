package com.bkit.fatdown.service;

import com.bkit.fatdown.dto.ElementTotalDTO;
import com.bkit.fatdown.dto.FoodInfoDTO;
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
    List<FoodInfoDTO> listFoodInfoDTO(int uid, Date date, Integer type);

    /**
     * 返回菜式列表
     *
     * @param uid
     * @param date
     * @param type
     * @return
     */
    List<TbFoodRecord> listFoodBasic(int uid, Date date, Integer type);

    /**
     * 拆解菜式
     *
     * @param foodIdList
     * @return
     */
    TbDietRecord getDietRecordTotalByRecordList(List<Integer> foodIdList);

    /**
     * 通过foodId 获取菜式组成成分，元素总量
     *
     * @param foodId
     * @return
     */
    TbDietRecord getDietRecord(int foodId);

    /**
     * 返回指定菜式搭配总量
     *
     * @param foodIdList
     * @return
     */
    TbDietRecord getDietRecordTotalByFoodList(List<Integer> foodIdList);
}
