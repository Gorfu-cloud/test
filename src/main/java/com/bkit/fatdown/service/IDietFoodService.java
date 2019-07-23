package com.bkit.fatdown.service;

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

}
