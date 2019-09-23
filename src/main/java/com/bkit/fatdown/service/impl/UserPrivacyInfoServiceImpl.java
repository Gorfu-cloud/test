package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.common.utils.DateUtils;
import com.bkit.fatdown.component.ReportHelper;
import com.bkit.fatdown.entity.TbUserPrivacyInfo;
import com.bkit.fatdown.entity.TbUserPrivacyInfoExample;
import com.bkit.fatdown.mappers.TbUserPrivacyInfoMapper;
import com.bkit.fatdown.service.IUserPrivacyInfoService;
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
        privacyInfo.setGmtCreate(new Date());
        privacyInfo.setGmtModified(new Date());
        int num = userPrivacyInfoMapper.insertSelective(privacyInfo);

        return num > 0;
    }

    @Override
    public boolean deleteById(int id) {
        int num = userPrivacyInfoMapper.deleteByPrimaryKey(id);

        return num > 0;
    }

    /**
     * 这里的更新是指更新今天原来的第一条记录
     * @param privacyInfo
     * @return
     */

    @Override
    public boolean update(TbUserPrivacyInfo privacyInfo) {
        // 查找原来的记录id
        TbUserPrivacyInfoExample example = new TbUserPrivacyInfoExample();
        Date today = new Date();
        example.createCriteria()
                .andUserIdEqualTo(privacyInfo.getUserId())
                // 查找今天是否有记录,有就更新
                .andGmtCreateBetween(DateUtils.getDateStart(today), DateUtils.getDateEnd(today));

        // 获取今天的，第一条记录记录id
        int id = userPrivacyInfoMapper.selectByExample(example).get(0).getId();
        privacyInfo.setId(id);

        // 计算BMI值
        if (privacyInfo.getHeight() != null && privacyInfo.getWeight() != null) {
            privacyInfo.setBmi(ReportHelper.getBMI(privacyInfo.getHeight(), privacyInfo.getWeight()));
        }

        // 设置更新日期
        privacyInfo.setGmtModified(today);

        return userPrivacyInfoMapper.updateByPrimaryKeySelective(privacyInfo) > 0;
    }

    @Override
    public List<TbUserPrivacyInfo> listByUid(int uid) {
        TbUserPrivacyInfoExample userPrivacyInfoExample = new TbUserPrivacyInfoExample();
        userPrivacyInfoExample.createCriteria()
                .andUserIdEqualTo(uid);
        // 按创建日期降序（从近到远）
        userPrivacyInfoExample.setOrderByClause("gmt_create desc");
        return userPrivacyInfoMapper.selectByExample(userPrivacyInfoExample);
    }

    @Override
    public TbUserPrivacyInfo getNewByUid(int uid) {
        if (listByUid(uid).isEmpty()) {
            return null;
        }

        return listByUid(uid).get(0);
    }

    @Override
    public List<TbUserPrivacyInfo> listBetweenDate(int uid, Date starDate, Date endDate) {
        TbUserPrivacyInfoExample userPrivacyInfoExample = new TbUserPrivacyInfoExample();
        userPrivacyInfoExample.createCriteria()
                .andUserIdEqualTo(uid)
                .andGmtCreateBetween(DateUtils.getDateStart(starDate), DateUtils.getDateEnd(endDate));
        // 按创建日期降序（从近到远）
        userPrivacyInfoExample.setOrderByClause("gmt_create desc");
        return userPrivacyInfoMapper.selectByExample(userPrivacyInfoExample);
    }

    /**
     * 查看当天是否有隐私记录。
     * @param uid
     * @param date
     * @return
     */
    @Override
    public int countByUidAndDate(int uid, Date date) {
        TbUserPrivacyInfoExample example = new TbUserPrivacyInfoExample();
        example.createCriteria()
                // 用户uid
                .andUserIdEqualTo(uid)
                // 获取今天0-24点之间的记录
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date));
        return (int) userPrivacyInfoMapper.countByExample(example);
    }

    @Override
    public TbUserPrivacyInfo getById(int id) {
        return userPrivacyInfoMapper.selectByPrimaryKey(id);
    }
}
