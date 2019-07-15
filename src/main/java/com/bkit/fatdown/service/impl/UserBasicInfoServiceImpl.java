package com.bkit.fatdown.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bkit.fatdown.entity.TbUserBasicInfo;
import com.bkit.fatdown.entity.TbUserBasicInfoExample;
import com.bkit.fatdown.mappers.TbUserBasicInfoMapper;
import com.bkit.fatdown.service.IUserBasicInfoService;
import com.bkit.fatdown.utils.WeappUtil;
import com.github.pagehelper.PageHelper;
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
        int num = userBasicInfoMapper.insert(userBasicInfo);
        return num > 0;
    }

    @Override
    public boolean update(TbUserBasicInfo userBasicInfo) {
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
        List<TbUserBasicInfo> list = userBasicInfoMapper.selectByExample(example);
        return list;
    }

    /**
     * 分页查找用户
     *
     * @return
     */
    @Override
    public List<TbUserBasicInfo> listAll(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageSize, pageNum);
        TbUserBasicInfoExample example = new TbUserBasicInfoExample();
        return userBasicInfoMapper.selectByExample(example);
    }

    @Override
    public int countById(int id) {
        TbUserBasicInfoExample example = new TbUserBasicInfoExample();
        return (int) userBasicInfoMapper.countByExample(example);
    }

    @Override
    public TbUserBasicInfo login(String code) {
        JSONObject jsonObject = JSONObject.parseObject(WeappUtil.getSessionKeyOrOpenId(code));
        System.out.println(jsonObject.toJSONString());
        String openId = jsonObject.getString("openid");
        // 用户不存在时,创建用户
        if (countByOpenId(openId)< 1) {
            TbUserBasicInfo userBasicInfo = new TbUserBasicInfo();
            // TODO 以后获取解码后信息再进行补充,2019年7月10日, 预计2019年7月15日
            userBasicInfo.setOpenId(openId);
            // 创建新用户
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
