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
     * @param recommend 推荐菜式
     * @return 返回结果
     */
    boolean insert(TbFoodRecommend recommend);

    /**
     * 更新推荐菜式
     *
     * @param recommend 推荐菜式
     * @return 返回结果
     */
    boolean update(TbFoodRecommend recommend);

    /**
     * 删除推荐菜式
     *
     * @param id 推荐菜式id
     * @return 返回结果
     */
    boolean delete(int id);

    /**
     * 通过类型，查找推荐菜式
     *
     * @param foodType 菜式类型
     * @return 返回菜式列表
     */
    List<TbFoodRecommend> listFoodRecommend(int foodType);

    /**
     * 通过类型，查找推荐菜式
     *
     * @param pageNum  页号
     * @param pageSize 每页数目
     * @return 返回菜式列表
     */
    List<TbFoodRecommend> listFoodRecommend(Integer pageNum, Integer pageSize);

    /**
     * 模糊查询菜式关键词信息
     *
     * @param keyName  菜式关键词
     * @param foodType 类型
     * @param pageNum  页数
     * @param pageSize 每页数目
     * @return 菜式推荐
     */
    List<TbFoodRecommend> listFoodRecommend(String keyName, Integer foodType, Integer pageNum, Integer pageSize);

    /**
     * 通过id查找推荐菜式
     *
     * @param id 推荐菜式id
     * @return 返回推荐菜式
     */
    TbFoodRecommend getFoodRecommend(int id);

    /**
     * 统计推荐菜式
     *
     * @param id 菜式id
     * @return 返回结果
     */
    int countFoodRecommend(int id);

    /**
     * @param foodType 食物类型
     * @param pageNum  页号
     * @param pageSize 每页数目
     * @return 食物类型
     */
    List<TbFoodRecommend> listFoodRecommend(int foodType, Integer pageNum, Integer pageSize);
}
