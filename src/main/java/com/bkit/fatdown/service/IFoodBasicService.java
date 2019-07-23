package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbFoodBasic;
import com.bkit.fatdown.entity.TbFoodRecord;

/**
 * @file: IFoodBasicService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 食物成分基础
 * @date: Created in 7/23/19  3:05 PM
 * @modified:
 * @version: 1.0
 */

public interface IFoodBasicService {
    /**
     * 插入食物成分记录
     *
     * @return
     */
    boolean insert(TbFoodBasic foodBasic);

    /**
     * 查询食物重量，类型
     *
     * @param id
     * @return
     */
    TbFoodBasic getFoodBasic(int id);
}
