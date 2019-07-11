package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbLearnRecord;
import com.bkit.fatdown.entity.TbLearnRecordExample;
import com.bkit.fatdown.mappers.TbLearnRecordMapper;
import com.bkit.fatdown.service.ILearnRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @file: LearnRecordServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 用户学习记录实现类
 * @date: Created in 2019/7/11 13:07
 * @modified:
 * @version: 1.0
 */

@Service
public class LearnRecordServiceImpl implements ILearnRecordService {

    @Resource
    TbLearnRecordMapper learnRecordMapper;

    @Override
    public boolean insert(TbLearnRecord learnRecord) {
        return learnRecordMapper.insert(learnRecord) > 0;
    }

    @Override
    public long countByUidBetweenDate(int uid, Date startDate, Date endDate) {
        TbLearnRecordExample example = new TbLearnRecordExample();
        example.createCriteria()
                .andGmtCreateBetween(startDate, endDate)
                .andUserIdEqualTo(uid);

        return learnRecordMapper.countByExample(example);
    }

}
