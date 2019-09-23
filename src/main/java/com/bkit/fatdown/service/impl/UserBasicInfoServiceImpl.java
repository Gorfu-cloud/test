package com.bkit.fatdown.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bkit.fatdown.entity.TbUserBasicInfo;
import com.bkit.fatdown.entity.TbUserBasicInfoExample;
import com.bkit.fatdown.entity.TbUserLifeStyle;
import com.bkit.fatdown.mappers.TbUserBasicInfoMapper;
import com.bkit.fatdown.service.IUserBasicInfoService;
import com.bkit.fatdown.common.utils.WxUtil;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @file: UserBasicInfoServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 用户基础信息功能实现类
 * @date: Created in 2019/7/10  10:32
 * @modified:
 * @version: 1.0
 */

@Service
public class UserBasicInfoServiceImpl implements IUserBasicInfoService {
    @Resource
    private TbUserBasicInfoMapper userBasicInfoMapper;

    private static Logger logger = LoggerFactory.getLogger(UserBasicInfoServiceImpl.class);

    @Override
    public boolean insert(TbUserBasicInfo userBasicInfo) {
        userBasicInfo.setGmtCreate(new Date());
        userBasicInfo.setGmtModified(new Date());
        int num = userBasicInfoMapper.insertSelective(userBasicInfo);
        logger.info("user register start , openId :{} ", userBasicInfo.getOpenId());
        return num > 0;
    }

    @Override
    public boolean update(TbUserBasicInfo userBasicInfo) {
        logger.info("user start login, uid :{}", userBasicInfo.getId());
        userBasicInfo.setGmtModified(new Date());
        int num = userBasicInfoMapper.updateByPrimaryKeySelective(userBasicInfo);
        return num > 0;
    }

    @Override
    public int countByOpenId(String openId) {
        TbUserBasicInfoExample basicInfoExample = new TbUserBasicInfoExample();
        TbUserBasicInfoExample.Criteria criteria = basicInfoExample.createCriteria();

        criteria.andOpenIdEqualTo(openId);

        return (int) userBasicInfoMapper.countByExample(basicInfoExample);
    }

    @Override
    public List<TbUserBasicInfo> listByUserLever(Integer userLever, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageSize, pageNum);
        TbUserBasicInfoExample example = new TbUserBasicInfoExample();
        example.createCriteria()
                .andUserLevelEqualTo(userLever);
        return userBasicInfoMapper.selectByExample(example);
    }

    /**
     * 分页查找用户
     *
     * @return 用户
     */
    @Override
    public List<TbUserBasicInfo> listAll(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageSize, pageNum);
        return userBasicInfoMapper.selectByExample(new TbUserBasicInfoExample());
    }

    @Override
    public int countById(int id) {
        TbUserBasicInfoExample example = new TbUserBasicInfoExample();
        return (int) userBasicInfoMapper.countByExample(example);
    }

    @Override
    public TbUserBasicInfo login(String code) {
        JSONObject jsonObject = JSONObject.parseObject(WxUtil.getSessionKeyOrOpenId(code));
        String openId = jsonObject.getString("openid");

        // 用户不存在时,创建用户
        if (countByOpenId(openId) < 1) {
            TbUserBasicInfo userBasicInfo = new TbUserBasicInfo();
            userBasicInfo.setOpenId(openId);
            insert(userBasicInfo);
        }
        return getByOpenId(openId);
    }

    @Override
    public TbUserBasicInfo getByOpenId(String openId) {
        TbUserBasicInfoExample basicInfoExample = new TbUserBasicInfoExample();
        TbUserBasicInfoExample.Criteria criteria = basicInfoExample.createCriteria();

        criteria.andOpenIdEqualTo(openId);
        List<TbUserBasicInfo> userBasicInfos = userBasicInfoMapper.selectByExample(basicInfoExample);

        return userBasicInfos.get(0);
    }

    @Override
    public TbUserBasicInfo getById(int id) {
        return userBasicInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteUserById(int id) {
        return userBasicInfoMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<TbUserBasicInfo> listByType(int type) {
        TbUserBasicInfoExample basicInfoExample = new TbUserBasicInfoExample();
        TbUserBasicInfoExample.Criteria criteria = basicInfoExample.createCriteria();

        criteria.andTypeEqualTo(type);

        return userBasicInfoMapper.selectByExample(basicInfoExample);
    }

    @Override
    public List<TbUserBasicInfo> listByTrueName(String trueName) {
        TbUserBasicInfoExample basicInfoExample = new TbUserBasicInfoExample();
        TbUserBasicInfoExample.Criteria criteria = basicInfoExample.createCriteria();

        criteria.andTrueNameEqualTo(trueName);

        return userBasicInfoMapper.selectByExample(basicInfoExample);
    }

    @Override
    public List<TbUserBasicInfo> listByPhone(String phone) {
        TbUserBasicInfoExample basicInfoExample = new TbUserBasicInfoExample();
        TbUserBasicInfoExample.Criteria criteria = basicInfoExample.createCriteria();

        criteria.andPhoneEqualTo(phone);

        return userBasicInfoMapper.selectByExample(basicInfoExample);
    }
}
