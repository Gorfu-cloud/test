package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbUserPrivacyInfo;
import com.bkit.fatdown.entity.TbUserPrivacyInfoExample;
import com.bkit.fatdown.mappers.TbUserPrivacyInfoMapper;
import com.bkit.fatdown.service.IUserPrivacyInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @FileName: UserPrivacyInfoService
 * @Author: YuJian
 * @Description: 用户隐私信息功能实现类
 * @Date: Created in 2019/7/9 17:49
 * @Modified:
 * @Version: 1.0
 */

@Service
public class UserPrivacyInfoService implements IUserPrivacyInfoService {
    @Resource
    private TbUserPrivacyInfoMapper userPrivacyInfoMapper;

    @Override
    public boolean insertUserPrivacyInfo(TbUserPrivacyInfo privacyInfo) {
        int num = userPrivacyInfoMapper.insertSelective(privacyInfo);

        return num > 0;
    }

    @Override
    public boolean deleteUserPrivacyInfoById(int id) {
        int num = userPrivacyInfoMapper.deleteByPrimaryKey(id);

        return num > 0;
    }

    @Override
    public boolean updateUserPrivacyInfo(TbUserPrivacyInfo privacyInfo) {
        int num = userPrivacyInfoMapper.updateByPrimaryKeySelective(privacyInfo);

        return num > 0;
    }

    @Override
    public List<TbUserPrivacyInfo> findAllByUID(int UID) {
        TbUserPrivacyInfoExample userPrivacyInfoExample = new TbUserPrivacyInfoExample();
        TbUserPrivacyInfoExample.Criteria criteria = userPrivacyInfoExample.createCriteria();

        criteria.andUseridEqualTo(UID);

        return userPrivacyInfoMapper.selectByExample(userPrivacyInfoExample);
    }

    @Override
    public List<TbUserPrivacyInfo> findBetweenDate(int UID, Date starDate, Date endDate) {
        TbUserPrivacyInfoExample userPrivacyInfoExample = new TbUserPrivacyInfoExample();
        TbUserPrivacyInfoExample.Criteria criteria = userPrivacyInfoExample.createCriteria();

        criteria.andUseridEqualTo(UID);
        criteria.andCreatedateBetween(starDate, endDate);

        return userPrivacyInfoMapper.selectByExample(userPrivacyInfoExample);
    }

    @Override
    public TbUserPrivacyInfo findByUID(int UID) {
        TbUserPrivacyInfoExample userPrivacyInfoExample = new TbUserPrivacyInfoExample();
        TbUserPrivacyInfoExample.Criteria criteria = userPrivacyInfoExample.createCriteria();

        criteria.andUseridEqualTo(UID);
        List<TbUserPrivacyInfo> userPrivacyInfoList = userPrivacyInfoMapper.selectByExample(userPrivacyInfoExample);

        return userPrivacyInfoList.get(0);
    }
}
