package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbFeedbackInfo;
import com.bkit.fatdown.entity.TbFeedbackInfoExample;
import com.bkit.fatdown.mappers.TbFeedbackInfoMapper;
import com.bkit.fatdown.service.IFeedbackInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @file: FeedbackInfoServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 反馈信息功能实现类
 * @date: Created in 8/13/19  6:26 PM
 * @modified:
 * @version: 1.0
 */
@Service
public class FeedbackInfoServiceImpl implements IFeedbackInfoService {

    @Resource
    private TbFeedbackInfoMapper infoMapper;

    /**
     * @param feedbackInfo 反馈信息
     * @return 是否成功
     */
    @Override
    public boolean insert(TbFeedbackInfo feedbackInfo) {
        if (feedbackInfo.getGmtCreate() == null) {
            feedbackInfo.setGmtCreate(new Date());
        }
        feedbackInfo.setGmtModified(new Date());
        return infoMapper.insertSelective(feedbackInfo) > 0;
    }

    /**
     * @param feedbackInfo 反馈信息
     * @return 是否成功
     */
    @Override
    public boolean update(TbFeedbackInfo feedbackInfo) {
        feedbackInfo.setGmtModified(new Date());
        return infoMapper.updateByPrimaryKeySelective(feedbackInfo) > 0;
    }

    /**
     * @param infoId 信息id
     * @return 是否成功
     */
    @Override
    public boolean delete(int infoId) {
        return infoMapper.deleteByPrimaryKey(infoId) > 0;
    }

    /**
     * @param infoId 信息id
     * @return 反馈信息
     */
    @Override
    public TbFeedbackInfo getFeedbackInfo(int infoId) {
        return infoMapper.selectByPrimaryKey(infoId);
    }

    /**
     * @param uid 用户id
     * @return 反馈信息
     */
    @Override
    public List<TbFeedbackInfo> listFeedbackInfo(int uid) {
        TbFeedbackInfoExample example = new TbFeedbackInfoExample();
        example.createCriteria()
                .andUserIdEqualTo(uid);

        // 检索text类型字段
        return infoMapper.selectByExampleWithBLOBs(example);
    }

    /**
     *
     * @param uid 管理员名称
     * @param typeId 类型
     * @param status 状态 -1 所有, 0 打开, 1 关闭
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<TbFeedbackInfo> listFeedbackInfoByPage(Integer uid, Integer typeId, Integer status, Integer pageNum, Integer pageSize) {
        TbFeedbackInfoExample example = new TbFeedbackInfoExample();

        TbFeedbackInfoExample.Criteria criteria = example.createCriteria();

        if (uid != null){
            criteria.andUserIdEqualTo(uid);
        }

//        if ()

        // 检索text类型字段
        return infoMapper.selectByExample(example);
    }

    /**
     * @param uid 用户id
     * @return 记录数
     */
    @Override
    public int countByUid(int uid) {
        TbFeedbackInfoExample example = new TbFeedbackInfoExample();
        example.createCriteria()
                .andUserIdEqualTo(uid);

        return (int) infoMapper.countByExample(example);
    }

    /**
     * @param typeId  反馈类型
     * @param uid     用户id
     * @param content 反馈内容
     * @return infoId
     */
    @Override
    public int getInfoId(Integer typeId, Integer uid, String content) {
        TbFeedbackInfoExample example = new TbFeedbackInfoExample();
        example.setOrderByClause("gmt_create desc");
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andTypeIdEqualTo(typeId)
                .andContentEqualTo(content);
        return infoMapper.selectByExample(example).get(0).getId();
    }

    /**
     * @param id 记录id
     * @return 记录数
     */
    @Override
    public int countById(int id) {
        TbFeedbackInfoExample example = new TbFeedbackInfoExample();
        example.createCriteria()
                .andIdEqualTo(id);
        return (int) infoMapper.countByExample(example);
    }
}
