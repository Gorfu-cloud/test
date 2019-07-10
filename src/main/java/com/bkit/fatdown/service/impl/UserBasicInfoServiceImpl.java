package com.bkit.fatdown.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bkit.fatdown.entity.TbUserBasicInfo;
import com.bkit.fatdown.entity.TbUserBasicInfoExample;
import com.bkit.fatdown.mappers.TbUserBasicInfoMapper;
import com.bkit.fatdown.service.IUserBasicInfoService;
import com.bkit.fatdown.utils.WxappUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    TbUserBasicInfoMapper userBasicInfoMapper;

    @Override
    public boolean insert(TbUserBasicInfo userBasicInfo) {
        int num = userBasicInfoMapper.insertSelective(userBasicInfo);
        return num > 0;
    }

    @Override
    public boolean update(TbUserBasicInfo userBasicInfo) {
        int num = userBasicInfoMapper.updateByPrimaryKeySelective(userBasicInfo);
        return num > 0;
    }

    @Override
    public int countByOpenid(String openid) {
        TbUserBasicInfoExample basicInfoExample = new TbUserBasicInfoExample();
        TbUserBasicInfoExample.Criteria criteria = basicInfoExample.createCriteria();

        criteria.andOpenidEqualTo(openid);

        return (int) userBasicInfoMapper.countByExample(basicInfoExample);
    }

    @Override
    public TbUserBasicInfo login(String code) {
        JSONObject jsonObject = JSONObject.parseObject(WxappUtil.getSessionKeyOropenid(code));
        System.out.println(jsonObject.toJSONString());
        String openid = (String) jsonObject.get("openid");

        // 用户不存在时
        if (countByOpenid(openid) == 0) {
            TbUserBasicInfo userBasicInfo = new TbUserBasicInfo();
            // TODO 以后获取解码后信息再进行补充,2019年7月10日, 预计2019年7月15日
            userBasicInfo.setOpenid(openid);
            // 创建新用户
            insert(userBasicInfo);
        }

        return getByOpenid(openid);
    }

    @Override
    public TbUserBasicInfo getByOpenid(String openid) {
        TbUserBasicInfoExample basicInfoExample = new TbUserBasicInfoExample();
        TbUserBasicInfoExample.Criteria criteria = basicInfoExample.createCriteria();

        criteria.andOpenidEqualTo(openid);
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
    public List<TbUserBasicInfo> listByTruename(String trueName) {
        TbUserBasicInfoExample basicInfoExample = new TbUserBasicInfoExample();
        TbUserBasicInfoExample.Criteria criteria = basicInfoExample.createCriteria();

        criteria.andTruenameEqualTo(trueName);

        return userBasicInfoMapper.selectByExample(basicInfoExample);
    }

    @Override
    public List<TbUserBasicInfo> listByPhone(String phone) {
        TbUserBasicInfoExample basicInfoExample = new TbUserBasicInfoExample();
        TbUserBasicInfoExample.Criteria criteria = basicInfoExample.createCriteria();

        criteria.andPhotoEqualTo(phone);

        return userBasicInfoMapper.selectByExample(basicInfoExample);
    }

    @Override
    public List<TbUserBasicInfo> listByUserlevel(int userLevel) {
        TbUserBasicInfoExample basicInfoExample = new TbUserBasicInfoExample();
        TbUserBasicInfoExample.Criteria criteria = basicInfoExample.createCriteria();

        criteria.andUserlevelEqualTo(userLevel);

        return userBasicInfoMapper.selectByExample(basicInfoExample);
    }
}
