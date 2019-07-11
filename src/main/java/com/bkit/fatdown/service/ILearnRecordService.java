package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbLearnRecord;

import java.util.Date;

/**
 * @file: ILearnRecordService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 学习记录接口
 * @date: Created in 2019/7/11 12:52
 * @modified:
 * @version: 1.0
 */

public interface ILearnRecordService {

    /**
     * 创建学习记录
     *
     * @param learnRecord
     * @return
     */
    boolean insert(TbLearnRecord learnRecord);

    /**
     * 查询指定日期,学习情况
     *
     * @param uid
     * @param startDate
     * @param endDate
     * @return
     */
    long countByUidBetweenDate(int uid, Date startDate, Date endDate);
}
