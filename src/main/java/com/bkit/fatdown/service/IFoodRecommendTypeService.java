package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbFoodRecommendType;

import java.util.List;

/**
 * @file: IFoodRecommendTypeService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 食物推荐类型
 * @date: Created in 8/7/19  9:37 PM
 * @modified:
 * @version: 1.0
 */
public interface IFoodRecommendTypeService {
    /**
     * 创建食物推荐类型
     *
     * @param recommendType 食物推荐类型
     * @return 是否成功
     */
    boolean insert(TbFoodRecommendType recommendType);

    /**
     * 更新食物推荐类型
     *
     * @param recommendType 食物推荐类型
     * @return 是否成功
     */
    boolean update(TbFoodRecommendType recommendType);

    /**
     * 删除食物推荐类型
     *
     * @param id 类型id
     * @return 是否成功
     */
    boolean delete(int id);

    /**
     * 获取所有食物推荐类型
     *
     * @return 所有食物推荐类型
     */
    List<TbFoodRecommendType> listAllType();

    /**
     * 获取类型信息
     *
     * @param id 类型id
     * @return 类型信息
     */
    TbFoodRecommendType getTypeInfo(int id);

    /**
     * 统计类型记录数
     *
     * @param id 类型id
     * @return 记录数
     */
    int countType(int id);
}
