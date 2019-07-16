package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbTaskList;

import java.util.List;

/**
 * @file: ITaskListService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 任务列表功能接口
 * @date: Created in 7/13/19  3:59 PM
 * @modified:
 * @version: 1.0
 */

public interface ITaskListService {
    /**
     * 创建新的每日任务
     *
     * @param taskList
     * @return
     */

    boolean insert(TbTaskList taskList);

    /**
     * 更新任务信息
     *
     * @param taskList
     * @return
     */
    boolean update(TbTaskList taskList);

    /**
     * 删除任务
     *
     * @param id
     * @return
     */
    boolean delete(int id);

    /**
     * 获取所有任务
     *
     * @return
     */
    List<TbTaskList> listTask();

    /**
     * 通过id查找任务详情
     *
     * @param id
     * @return
     */
    TbTaskList getTaskById(int id);

    /**
     * 检查任务是否存在
     *
     * @param id
     * @return
     */
    int countTaskById(int id);

    /**
     * 获取新增的任务列表编号
     *
     * @return
     */

    List<Integer> listNewTask(int uid);
}
