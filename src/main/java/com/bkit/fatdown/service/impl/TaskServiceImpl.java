package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbTaskRecord;
import com.bkit.fatdown.entity.TbTaskRecordExample;
import com.bkit.fatdown.mappers.TbTaskRecordMapper;
import com.bkit.fatdown.service.ITaskRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class TaskServiceImpl implements ITaskRecordService {

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
        return taskRecordMapper.insert(taskRecord) > 0;
    }

    /**
     * 更新任务记录
     *
     * @param taskRecord
     * @return
     */
    @Override
    public boolean update(TbTaskRecord taskRecord) {
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
}
