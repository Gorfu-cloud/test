package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbLearnInfo;
import com.bkit.fatdown.entity.TbLearnInfoExample;
import com.bkit.fatdown.mappers.TbLearnInfoMapper;
import com.bkit.fatdown.service.ILearnService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @file: LearnServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 学习知识功能实现类
 * @date: Created in 2019/7/11 11:59
 * @modified:
 * @version: 1.0
 */

@Service
public class LearnServiceImpl implements ILearnService {

    @Resource
    TbLearnInfoMapper learnInfoMapper;

    @Override
    public List<TbLearnInfo> listByDate(Date nowDate) {
        TbLearnInfoExample example = new TbLearnInfoExample();
        example.createCriteria()
                .andTimeLessThanOrEqualTo(nowDate);
        // 按类型升序
        example.setOrderByClause("type asc");
        return learnInfoMapper.selectByExample(example);
    }

    @Override
    public List<TbLearnInfo> listAll() {
        TbLearnInfoExample example = new TbLearnInfoExample();
        // 按类型升序
        example.setOrderByClause("type asc");

        return learnInfoMapper.selectByExample(example);
    }

    @Override
    public boolean insert(TbLearnInfo learnInfo) {
        return learnInfoMapper.insert(learnInfo) > 0;
    }

    @Override
    public boolean deleteById(int id) {
        return learnInfoMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean update(TbLearnInfo learnInfo) {
        return learnInfoMapper.updateByPrimaryKey(learnInfo) > 0;
    }

    @Override
    public TbLearnInfo getById(int id) {
        return learnInfoMapper.selectByPrimaryKey(id);
    }
}
