package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbFeedbackReply;
import com.bkit.fatdown.entity.TbFeedbackReplyExample;
import com.bkit.fatdown.mappers.TbFeedbackReplyMapper;
import com.bkit.fatdown.service.IFeedbackReplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @file: FeedbackReplyServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 反馈回复信息功能实现类
 * @date: Created in 8/13/19  10:23 PM
 * @modified:
 * @version: 1.0
 */
@Service
public class FeedbackReplyServiceImpl implements IFeedbackReplyService {

    @Resource
    private TbFeedbackReplyMapper replyMapper;

    /**
     * @param reply 回复内容
     * @return 是否成功
     */
    @Override
    public boolean insert(TbFeedbackReply reply) {
        if (reply.getGmtCreate() == null) {
            reply.setGmtCreate(new Date());
        }

        reply.setGmtModified(new Date());
        return replyMapper.insertSelective(reply) > 0;
    }

    /**
     * @param reply 回复内容
     * @return 是否成功
     */
    @Override
    public boolean update(TbFeedbackReply reply) {
        reply.setGmtModified(new Date());
        return replyMapper.updateByPrimaryKeySelective(reply) > 0;
    }

    /**
     * @param replyId 回复id
     * @return 是否成功
     */
    @Override
    public boolean delete(int replyId) {
        return replyMapper.deleteByPrimaryKey(replyId) > 0;
    }

    /**
     * @param replyId 回复id
     * @return 回复信息
     */
    @Override
    public TbFeedbackReply get(int replyId) {
        return replyMapper.selectByPrimaryKey(replyId);
    }

    /**
     * @param infoId 反馈信息id
     * @return 回复信息
     */
    @Override
    public TbFeedbackReply getByInfoId(int infoId) {
        TbFeedbackReplyExample example = new TbFeedbackReplyExample();
        example.createCriteria()
                .andInfoIdEqualTo(infoId);
        return replyMapper.selectByExample(example).get(0);
    }

    /**
     * @return 反馈列表
     */
    @Override
    public List<TbFeedbackReply> list() {
        TbFeedbackReplyExample example = new TbFeedbackReplyExample();
        example.setOrderByClause("gmt_create desc");
        return replyMapper.selectByExample(example);
    }

    /**
     * @param replyId 回复id
     * @return 记录数
     */
    @Override
    public int count(int replyId) {
        TbFeedbackReplyExample example = new TbFeedbackReplyExample();
        example.createCriteria()
                .andIdEqualTo(replyId);
        return (int) replyMapper.countByExample(example);
    }

    /**
     * @param infoId 反馈编号
     * @return 记录数
     */
    @Override
    public int countByInfoId(int infoId) {
        TbFeedbackReplyExample example = new TbFeedbackReplyExample();
        example.createCriteria()
                .andInfoIdEqualTo(infoId);
        return (int) replyMapper.countByExample(example);
    }
}
