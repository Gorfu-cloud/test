package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbUserLifeStyle;
import com.bkit.fatdown.mappers.TbUserLifeStyleMapper;
import com.bkit.fatdown.service.IUserLifeStyleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @file: UserLifeStyleServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:  用户口味倾向功能实现类
 * @date: Created in 2019/7/10  10:33
 * @modified:
 * @version: 1.0
 */

@Service
public class UserLifeStyleServiceImpl implements IUserLifeStyleService {

    @Resource
    private TbUserLifeStyleMapper userLifeStyleMapper;

    @Override
    public boolean insert(TbUserLifeStyle userLifeStyle) {
        int num = userLifeStyleMapper.insert(userLifeStyle);
        return num > 0;
    }

    @Override
    public boolean delete(int id) {
        int num = userLifeStyleMapper.deleteByPrimaryKey(id);
        return num > 0;
    }

    @Override
    public TbUserLifeStyle getByUid(int uid) {
        return null;
    }

    @Override
    public TbUserLifeStyle getById(int id) {
        return null;
    }
}
