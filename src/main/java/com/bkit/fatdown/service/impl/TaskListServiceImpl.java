package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbTaskList;
import com.bkit.fatdown.entity.TbTaskListExample;
import com.bkit.fatdown.mappers.TbTaskListMapper;
import com.bkit.fatdown.service.ITaskListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @file: TaskListServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 任务列表功能实现类
 * @date: Created in 7/13/19  4:15 PM
 * @modified:
 * @version: 1.0
 */

@Service
public class TaskListServiceImpl implements ITaskListService {

    @Resource
    private TbTaskListMapper taskListMapper;

    @Resource
    private TaskRecordServiceImpl taskRecordService;

    @Override
    public boolean insert(TbTaskList taskList) {
        return taskListMapper.insert(taskList) > 0;
    }

    @Override
    public boolean update(TbTaskList taskList) {
        return taskListMapper.updateByPrimaryKey(taskList) > 0;
    }

    @Override
    public boolean delete(int id) {
        return taskListMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<TbTaskList> listTask() {
        TbTaskListExample example = new TbTaskListExample();
        return taskListMapper.selectByExample(example);
    }

    @Override
    public TbTaskList getTaskById(int id) {
        return taskListMapper.selectByPrimaryKey(id);
    }

    /**
     * 检查任务是否存在
     *
     * @param id
     * @return
     */
    @Override
    public int countTaskById(int id) {
        TbTaskListExample example = new TbTaskListExample();
        example.createCriteria()
                .andIdEqualTo(id);
        return (int) taskListMapper.countByExample(example);
    }


    /**
     * 获取新增任务编号
     *
     * @return
     */
    @Override
    public List<Integer> listNewTask(int uid) {
        TbTaskListExample example = new TbTaskListExample();
        example.createCriteria()
                // 已开启任务
                .andFlagEqualTo(1)
                .andIdNotIn(taskRecordService.listRecordId(uid));
        return newTaskList(taskListMapper.selectByExample(example));
    }

    /**
     * 当前任务列表
     *
     * @param taskList
     * @return
     */
    private List<Integer> newTaskList(List<TbTaskList> taskList) {
        List<Integer> nowTaskList = new ArrayList<>();
        for (TbTaskList list : taskList) {
            nowTaskList.add(list.getId());
        }
        return nowTaskList;
    }
}
