package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbUserPrivacyInfo;
import com.bkit.fatdown.entity.TbUserPrivacyInfoExample;
import com.bkit.fatdown.mappers.TbUserPrivacyInfoMapper;
import com.bkit.fatdown.service.IUserPrivacyInfoService;
import com.bkit.fatdown.utils.DateUtils;
import com.bkit.fatdown.utils.MathUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @file: UserPrivacyInfoServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 用户隐私信息功能实现类
 * @date: Created in 2019/7/10  10:31
 * @modified:
 * @version: 1.0
 */

@Service
public class UserPrivacyInfoServiceImpl implements IUserPrivacyInfoService {
    @Resource
    private TbUserPrivacyInfoMapper userPrivacyInfoMapper;

    @Override
    public boolean insert(TbUserPrivacyInfo privacyInfo) {
        int num = userPrivacyInfoMapper.insert(privacyInfo);

        return num > 0;
    }

    @Override
    public boolean deleteById(int id) {
        int num = userPrivacyInfoMapper.deleteByPrimaryKey(id);

        return num > 0;
    }

    @Override
    public boolean update(TbUserPrivacyInfo privacyInfo) {
        // 查找原来的记录id
        TbUserPrivacyInfoExample example = new TbUserPrivacyInfoExample();
        Date today = privacyInfo.getGmtCreate();
        example.createCriteria()
                .andUserIdEqualTo(privacyInfo.getUserId())
                .andGmtCreateBetween(DateUtils.getDateStart(today), DateUtils.getDateEnd(today));
        // 获取记录id
        int id = userPrivacyInfoMapper.selectByExample(example).get(0).getId();
        privacyInfo.setId(id);
        if (privacyInfo.getHeight() != null && privacyInfo.getWeight() != null) {
            privacyInfo.setBmi(MathUtils.getBMI(privacyInfo.getHeight(),privacyInfo.getWeight()));
        }
        int num = userPrivacyInfoMapper.updateByPrimaryKeySelective(privacyInfo);
        return num > 0;
    }

    @Override
    public List<TbUserPrivacyInfo> listByUid(int uid) {
        TbUserPrivacyInfoExample userPrivacyInfoExample = new TbUserPrivacyInfoExample();
        userPrivacyInfoExample.createCriteria()
                .andUserIdEqualTo(uid);

        return userPrivacyInfoMapper.selectByExample(userPrivacyInfoExample);
    }

    @Override
    public List<TbUserPrivacyInfo> listBetweenDate(int uid, Date starDate, Date endDate) {
        TbUserPrivacyInfoExample userPrivacyInfoExample = new TbUserPrivacyInfoExample();
        userPrivacyInfoExample.createCriteria()
                .andUserIdEqualTo(uid)
                .andGmtCreateBetween(starDate, endDate);
        // 按创建日期降序
        userPrivacyInfoExample.setOrderByClause("createDate desc");
        return userPrivacyInfoMapper.selectByExample(userPrivacyInfoExample);
    }

    @Override
    public int countByUidAndDate(int uid, Date date) {
        TbUserPrivacyInfoExample example = new TbUserPrivacyInfoExample();
        example.createCriteria()
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date))
                .andUserIdEqualTo(uid);
        return (int) userPrivacyInfoMapper.countByExample(example);
    }

    @Override
    public TbUserPrivacyInfo getById(int id) {
        return userPrivacyInfoMapper.selectByPrimaryKey(id);
    }
}
