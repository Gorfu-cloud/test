package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbUserLifeStyle;
import com.bkit.fatdown.mappers.TbUserLifeStyleMapper;
import com.bkit.fatdown.service.IUserLifeStyleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @FileName: UserLifeStyleServiceImpl
 * @Author: YuJian
 * @Description: 用户口味倾向功能实现类
 * @Date: Created in 2019/7/9 18:11
 * @Modified:
 * @Version: 1.0
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
