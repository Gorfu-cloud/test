package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbLearnInfo;
import com.bkit.fatdown.service.ILearnService;

import java.util.Date;
import java.util.List;

/**
 * @file: LearnService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 学习知识功能实现类
 * @date: Created in 2019/7/11 11:59
 * @modified:
 * @version: 1.0
 */

public class LearnService implements ILearnService {


    @Override
    public List<TbLearnInfo> listByDate(Date nowDate) {
        return null;
    }

    @Override
    public List<TbLearnInfo> listAll() {
        return null;
    }

    @Override
    public boolean insert() {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean update(TbLearnInfo learnInfo) {
        return false;
    }

    @Override
    public TbLearnInfo getById(int id) {
        return null;
    }
}
