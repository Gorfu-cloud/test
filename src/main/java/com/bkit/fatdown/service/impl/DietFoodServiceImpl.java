package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.mappers.TbDietUserStandardMapper;
import com.bkit.fatdown.mappers.TbFoodRecordMapper;
import com.bkit.fatdown.service.IDietFoodService;
import com.bkit.fatdown.service.IUserBasicInfoService;
import com.bkit.fatdown.service.IUserLifeStyleService;
import com.bkit.fatdown.service.IUserPrivacyInfoService;
import com.bkit.fatdown.utils.DateUtils;
import com.bkit.fatdown.utils.MathUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @file: DietFoodServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 饮食功能实现类
 * @date: Created in 7/23/19  8:54 AM
 * @modified:
 * @version: 1.0
 */

@Service
public class DietFoodServiceImpl implements IDietFoodService {

    @Resource
    private TbFoodRecordMapper foodRecordMapper;

    @Resource
    private TbDietUserStandardMapper dietStandardMapper;

    @Resource
    private IUserLifeStyleService userLifeStyleService;

    @Resource
    private IUserBasicInfoService userBasicInfoService;

    @Resource
    private IUserPrivacyInfoService privacyInfoService;

    /**
     * 保存饮食记录
     *
     * @param record
     * @return
     */
    @Override
    public boolean insert(TbFoodRecord record) {
        record.setGmtCreate(new Date());
        record.setGmtModified(new Date());
        return foodRecordMapper.insert(record) > 0;
    }

    /**
     * 获取用户某天饮食记录
     *
     * @param uid
     * @param date
     * @return
     */
    @Override
    public List<TbFoodRecord> listFoodRecordByDate(int uid, Date date) {
        TbFoodRecordExample example = new TbFoodRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date));
        return foodRecordMapper.selectByExample(example);
    }

    /**
     * 创建饮食标准
     *
     * @param standard
     * @return
     */
    @Override
    public boolean insertDietStandard(TbDietUserStandard standard) {
        standard.setGmtCreate(new Date());
        standard.setGmtModified(new Date());
        return dietStandardMapper.insert(standard) > 0;
    }

    /**
     * 更新饮食标准
     *
     * @param standard
     * @return
     */
    @Override
    public boolean updateDietStandard(TbDietUserStandard standard) {
        standard.setGmtModified(new Date());
        return dietStandardMapper.updateByPrimaryKeySelective(standard) > 0;
    }

    /**
     * 通过用户信息更新饮食标准
     *
     * @param uid
     * @return
     */
    @Override
    public boolean updateDietStandardByUid(int uid) {
        // 获取用户习惯，隐私信息，基础信息。
        TbUserLifeStyle userLifeStyle = userLifeStyleService.listByUid(uid).get(0);
        TbUserPrivacyInfo privacyInfo = privacyInfoService.listByUid(uid).get(0);
        TbUserBasicInfo basicInfo = userBasicInfoService.getById(uid);

        return updateDietStandard(MathUtils.getDietUserStandard(basicInfo, privacyInfo, userLifeStyle));
    }

    /**
     * 通过用户编号获取饮食标准
     *
     * @param uid
     * @return
     */
    @Override
    public TbDietUserStandard getDietStandard(int uid) {
        return dietStandardMapper.selectByPrimaryKey(uid);
    }
}
