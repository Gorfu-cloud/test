package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbUserLifeStyle;
import com.bkit.fatdown.entity.TbUserLifeStyleExample;
import com.bkit.fatdown.mappers.TbUserLifeStyleMapper;
import com.bkit.fatdown.service.IUserLifeStyleService;
import com.bkit.fatdown.common.utils.DateUtils;
import com.github.pagehelper.PageHelper;
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
        userLifeStyle.setGmtCreate(new Date());
        userLifeStyle.setGmtModified(new Date());
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
    public List<TbUserLifeStyle> list(int uid, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        TbUserLifeStyleExample example = new TbUserLifeStyleExample();
        example.createCriteria()
                .andUserIdEqualTo(uid);
        example.setOrderByClause("gmt_modified desc");

        return userLifeStyleMapper.selectByExample(example);
    }

    /**
     * 这里是更新今天的记录
     *
     * @param userLifeStyle
     * @return
     */
    @Override
    public boolean update(TbUserLifeStyle userLifeStyle) {
        // 查找当天记录
        TbUserLifeStyleExample example = new TbUserLifeStyleExample();
        example.createCriteria()
                .andUserIdEqualTo(userLifeStyle.getUserId());
        // 从近到远输出
        example.setOrderByClause("gmt_create desc");
        // 获取用户ID
        int id = userLifeStyleMapper.selectByExample(example).get(0).getId();
        userLifeStyle.setId(id);
        userLifeStyle.setGmtModified(new Date());
        return userLifeStyleMapper.updateByPrimaryKeySelective(userLifeStyle) > 0;
    }

    @Override
    public int countByUidAndCreateDate(int uid, Date date) {
        TbUserLifeStyleExample example = new TbUserLifeStyleExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                // 查看今天是否有新的记录。
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date));
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
