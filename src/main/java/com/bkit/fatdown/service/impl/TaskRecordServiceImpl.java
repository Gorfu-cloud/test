package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbTaskRecord;
import com.bkit.fatdown.entity.TbTaskRecordExample;
import com.bkit.fatdown.mappers.TbTaskRecordMapper;
import com.bkit.fatdown.service.ITaskRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @file: TaskServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 用户任务记录实现类
 * @date: Created in 7/13/19  5:32 PM
 * @modified:
 * @version: 1.0
 */

@Service
public class TaskRecordServiceImpl implements ITaskRecordService {

    @Resource
    private TbTaskRecordMapper taskRecordMapper;

    /**
     * 创建新的任务记录
     *
     * @param taskRecord
     * @return
     */
    @Override
    public boolean insert(TbTaskRecord taskRecord) {
        taskRecord.setGmtCreate(new Date());
        taskRecord.setGmtModified(new Date());
        return taskRecordMapper.insertSelective(taskRecord) > 0;
    }

    /**
     * 更新任务记录
     *
     * @param taskRecord
     * @return
     */
    @Override
    public boolean update(TbTaskRecord taskRecord) {
        taskRecord.setGmtModified(new Date());
        return taskRecordMapper.updateByPrimaryKey(taskRecord) > 0;
    }

    /**
     * 更新完成任务
     *
     * @param id
     * @return
     */
    @Override
    public boolean updateRecordStatus(int id) {
        int finishTask = 1;
        TbTaskRecord taskRecord = new TbTaskRecord();
        taskRecord.setId(id);
        taskRecord.setComplete(finishTask);
        taskRecord.setGmtModified(new Date());
        return taskRecordMapper.updateByPrimaryKey(taskRecord) > 0;
    }

    /**
     * 删除任务记录
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(int id) {
        return taskRecordMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 获取对应id的任务记录
     *
     * @param id
     * @return
     */
    @Override
    public TbTaskRecord getTaskRecordById(int id) {
        return taskRecordMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取用户的任务记录
     * 不存在则新建记录
     * 24点清空触发器
     *
     * @param uid
     * @return
     */
    @Override
    public List<TbTaskRecord> listTaskRecordByUid(int uid) {
        TbTaskRecordExample example = new TbTaskRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(uid);
        return taskRecordMapper.selectByExample(example);
    }

    /**
     * 获取用户记录存在数量
     *
     * @param uid
     * @return
     */
    @Override
    public int countByUid(int uid) {
        TbTaskRecordExample example = new TbTaskRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(uid);
        return (int) taskRecordMapper.countByExample(example);
    }

    @Override
    public List<Integer> listRecordId(int uid) {
        TbTaskRecordExample example = new TbTaskRecordExample();
        example.setOrderByClause("complete desc");
        example.createCriteria()
                .andUserIdEqualTo(uid);
        taskRecordMapper.selectByExample(example);
        return nowTaskList(taskRecordMapper.selectByExample(example));
    }

    /**
     * 当前用户拥有的任务列表编号
     *
     * @param taskList
     * @return
     */
    private List<Integer> nowTaskList(List<TbTaskRecord> taskList) {
        List<Integer> nowTaskList = new ArrayList<>();

        for (TbTaskRecord list : taskList) {
            // 将任务id添加进去
            nowTaskList.add(list.getTaskId());
        }
        return nowTaskList;
    }
}