package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbTaskRecord;

import java.util.List;

/**
 * @file: ITaskRecordService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 用户任务记录情况功能接口
 * @date: Created in 7/13/19  4:44 PM
 * @modified:
 * @version: 1.0
 */

public interface ITaskRecordService {
    /**
     * 创建新的任务记录
     *
     * @param taskRecord
     * @return
     */
    boolean insert(TbTaskRecord taskRecord);

    /**
     * 更新任务记录
     *
     * @param taskRecord
     * @return
     */
    boolean update(TbTaskRecord taskRecord);

    /**
     * 更新完成任务
     *
     * @param id
     * @return
     */
    boolean updateRecordStatus(int id);

    /**
     * 删除任务记录
     *
     * @param id
     * @return
     */
    boolean delete(int id);

    /**
     * 获取对应id的任务记录
     *
     * @param id
     * @return
     */
    TbTaskRecord getTaskRecordById(int id);

    /**
     * 获取用户的任务记录
     *
     * @param uid
     * @return
     */
    List<TbTaskRecord> listTaskRecordByUid(int uid);

    /**
     * 获取用户记录存在数量
     *
     * @param uid
     * @return
     */
    int countByUid(int uid);
}
