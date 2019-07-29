package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbFoodBasic;
import com.bkit.fatdown.entity.TbFoodRecord;

import java.util.List;

/**
 * @file: IFoodBasicService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 菜式列表
 * @date: Created in 7/23/19  3:05 PM
 * @modified:
 * @version: 1.0
 */

public interface IFoodBasicService {
    /**
     * 插入菜式列表
     *
     * @return
     */
    boolean insert(TbFoodBasic foodBasic);

    /**
     * 删除菜式列表
     *
     * @param id
     * @return
     */
    boolean delete(int id);

    /**
     * 更新菜式列表
     *
     * @param foodBasic
     * @return
     */
    boolean update(TbFoodBasic foodBasic);

    /**
     * 查询食物重量，类型
     *
     * @param id
     * @return
     */
    TbFoodBasic getFoodBasic(int id);

    /**
     * 查询食物组成表
     *
     * @param foodName
     * @return
     */
    List<TbFoodBasic> listByName(String foodName);

    /**
     * 创建新记录并返回id
     *
     * @param foodBasic
     * @return
     */
    Integer insertReturnId(TbFoodBasic foodBasic);

    /**
     * 查找菜式存在数
     *
     * @param foodId
     * @return
     */
    int countFoodBasic(int foodId);
}
