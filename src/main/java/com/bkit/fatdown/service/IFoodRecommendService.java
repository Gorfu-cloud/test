package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbFoodRecommend;

import java.util.List;

/**
 * @file: IFoodRecommendService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 推荐菜式接口
 * @date: Created in 7/26/19  10:00 PM
 * @modified:
 * @version: 1.0
 */

public interface IFoodRecommendService {

    /**
     * 创建推荐菜式
     *
     * @param recommend
     * @return
     */
    boolean insert(TbFoodRecommend recommend);

    /**
     * 更新推荐菜式
     *
     * @param recommend
     * @return
     */
    boolean update(TbFoodRecommend recommend);

    /**
     * 删除推荐菜式
     *
     * @param id
     * @return
     */
    boolean delete(int id);

    /**
     * 通过类型，查找推荐菜式
     *
     * @param foodType
     * @return
     */
    List<TbFoodRecommend> listFoodRecommend(int foodType);

    /**
     * 通过id查找推荐菜式
     *
     * @param id
     * @return
     */
    TbFoodRecommend getFoodRecommend(int id);
}
