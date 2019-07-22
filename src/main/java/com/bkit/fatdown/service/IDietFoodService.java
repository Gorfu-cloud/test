package com.bkit.fatdown.service;

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
     * 创建饮食记录
     *
     * @return
     */
    boolean insert();

    /**
     * 删除饮食记录
     *
     * @param id
     * @return
     */
    boolean delete(int id);
    /**更新饮食记录*/
    boolean update();
}
