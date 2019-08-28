package com.bkit.fatdown.service;

import com.bkit.fatdown.dto.food.FoodElementDTO;
import com.bkit.fatdown.entity.TbFoodElementRelation;

import java.util.HashMap;
import java.util.List;

/**
 * @file: IFoodElementService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 食物组成元素接口
 * @date: Created in 7/26/19  10:39 AM
 * @modified:
 * @version: 1.0
 */

public interface IFoodElementService {
    /**
     * 创建关系
     *
     * @param foodElementRelation
     * @return
     */
    boolean insert(TbFoodElementRelation foodElementRelation);

    /**
     * 更新关系
     *
     * @param foodElementRelation
     * @return
     */
    boolean update(TbFoodElementRelation foodElementRelation);

    /**
     * 删除关系
     *
     * @param id
     * @return
     */
    boolean delete(int id);

    /**
     * 获取关系
     *
     * @param id
     * @return
     */
    TbFoodElementRelation getFoodElementRelation(int id);

    /**
     * 获取食物组成id
     *
     * @param foodId
     * @return
     */
    List<Integer> listElementId(int foodId);

    /**
     * 获取菜式组成
     *
     * @param foodId 食物id
     * @return
     */
    List<TbFoodElementRelation> listByFoodId(int foodId);

    /**
     * 获取食物组成id
     *
     * @param foodId
     * @return
     */
    HashMap<Integer, Double> getElementNameAndGram(int foodId);

    /**
     * @param relationId 记录id
     * @return
     */
    Integer count(int relationId);

    /**
     * 获取菜式成分列表
     * @param foodId 菜式id
     * @return
     */
    List<FoodElementDTO> listFoodElement(Integer foodId);
}
