package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbUserBasicInfo;
import com.bkit.fatdown.entity.TbUserBasicInfoExample;
import com.bkit.fatdown.mappers.TbUserBasicInfoMapper;
import com.bkit.fatdown.service.IUserBasicInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @FileName: UserBasicInfoService
 * @Author: YuJian
 * @Description: 用户基础信息功能实现类
 * @Date: Created in 2019/7/9 15:59
 * @Modified:
 * @Version: 1.0
 */

@Service
public class UserBasicInfoService implements IUserBasicInfoService {

    @Resource
    TbUserBasicInfoMapper userBasicInfoMapper;

    @Override
    public boolean insertUserBasicInfo(TbUserBasicInfo userBasicInfo) {
        int num = userBasicInfoMapper.insertSelective(userBasicInfo);
        return num > 0;
    }

    @Override
    public boolean updateUserBasicInfo(TbUserBasicInfo userBasicInfo) {
        int num = userBasicInfoMapper.updateByPrimaryKeySelective(userBasicInfo);
        return num > 0;
    }

    @Override
    public boolean checkUser(String openid) {
        TbUserBasicInfoExample basicInfoExample = new TbUserBasicInfoExample();
        TbUserBasicInfoExample.Criteria criteria = basicInfoExample.createCriteria();

        criteria.andOpenidEqualTo(openid);
        long num = userBasicInfoMapper.countByExample(basicInfoExample);

        return num > 0;
    }

    @Override
    public TbUserBasicInfo findUserBasicInfoByOpenid(String openid) {
        TbUserBasicInfoExample basicInfoExample = new TbUserBasicInfoExample();
        TbUserBasicInfoExample.Criteria criteria = basicInfoExample.createCriteria();

        criteria.andOpenidEqualTo(openid);
        List<TbUserBasicInfo> userBasicInfos = userBasicInfoMapper.selectByExample(basicInfoExample);

        return userBasicInfos.get(0);
    }

    @Override
    public TbUserBasicInfo findUserBasicInfoById(int id) {
        return userBasicInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteUserById(int id) {
        return userBasicInfoMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<TbUserBasicInfo> findAllByType(int type) {
        TbUserBasicInfoExample basicInfoExample = new TbUserBasicInfoExample();
        TbUserBasicInfoExample.Criteria criteria = basicInfoExample.createCriteria();

        criteria.andTypeEqualTo(type);

        return userBasicInfoMapper.selectByExample(basicInfoExample);
    }

    @Override
    public List<TbUserBasicInfo> findAllByTruename(String trueName) {
        TbUserBasicInfoExample basicInfoExample = new TbUserBasicInfoExample();
        TbUserBasicInfoExample.Criteria criteria = basicInfoExample.createCriteria();

        criteria.andTruenameEqualTo(trueName);

        return userBasicInfoMapper.selectByExample(basicInfoExample);
    }

    @Override
    public List<TbUserBasicInfo> findAllByPhone(String phone) {
        TbUserBasicInfoExample basicInfoExample = new TbUserBasicInfoExample();
        TbUserBasicInfoExample.Criteria criteria = basicInfoExample.createCriteria();

        criteria.andPhotoEqualTo(phone);

        return userBasicInfoMapper.selectByExample(basicInfoExample);
    }

    @Override
    public List<TbUserBasicInfo> findAllByUserlevel(int userLevel) {
        TbUserBasicInfoExample basicInfoExample = new TbUserBasicInfoExample();
        TbUserBasicInfoExample.Criteria criteria = basicInfoExample.createCriteria();

        criteria.andUserlevelEqualTo(userLevel);

        return userBasicInfoMapper.selectByExample(basicInfoExample);
    }
}
