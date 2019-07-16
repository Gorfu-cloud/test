package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbUserLifeStyle;
import com.bkit.fatdown.entity.TbUserLifeStyleExample;
import com.bkit.fatdown.mappers.TbUserLifeStyleMapper;
import com.bkit.fatdown.service.IUserLifeStyleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @file: UserLifeStyleServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 用户口味倾向功能实现类
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
    public List<TbUserLifeStyle> listByUid(int uid) {
        TbUserLifeStyleExample example = new TbUserLifeStyleExample();
        example.createCriteria()
                .andUserIdEqualTo(uid);
        example.setOrderByClause("gmt_modified desc");

        return userLifeStyleMapper.selectByExample(example);
    }

    @Override
    public TbUserLifeStyle getById(int id) {
        return userLifeStyleMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(TbUserLifeStyle userLifeStyle) {
        // 查找当天记录
        TbUserLifeStyleExample example = new TbUserLifeStyleExample();
        example.createCriteria()
                .andGmtCreateEqualTo(userLifeStyle.getGmtCreate())
                .andUserIdEqualTo(userLifeStyle.getUserId());
        // 获取用户ID
        int id = userLifeStyleMapper.selectByExample(example).get(0).getId();
        userLifeStyle.setId(id);
        return userLifeStyleMapper.updateByPrimaryKeySelective(userLifeStyle) > 0;
    }

    @Override
    public int countByUidAndCreateDate(int uid, Date date) {
        TbUserLifeStyleExample example = new TbUserLifeStyleExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andGmtCreateEqualTo(date);
        return (int) userLifeStyleMapper.countByExample(example);
    }

    @Override
    public int countByUid(int uid) {
        TbUserLifeStyleExample example = new TbUserLifeStyleExample();
        example.createCriteria()
                .andUserIdEqualTo(uid);
        return (int) userLifeStyleMapper.countByExample(example);
    }
}
