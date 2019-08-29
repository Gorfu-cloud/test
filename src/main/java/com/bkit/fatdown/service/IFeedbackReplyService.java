package com.bkit.fatdown.service;

import java.util.Date;

import com.bkit.fatdown.entity.TbFeedbackReply;

import java.util.List;

/**
 * @file: IFeedbackReplyService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 反馈回复功能接口
 * @date: Created in 8/13/19  3:07 PM
 * @modified:
 * @version: 1.0
 */

public interface IFeedbackReplyService {
    /**
     * @param reply 回复内容
     * @return 是否成功
     */
    boolean insert(TbFeedbackReply reply);

    /**
     * @param reply 回复内容
     * @return 是否成功
     */
    boolean update(TbFeedbackReply reply);

    /**
     * @param replyId 回复id
     * @return 是否成功
     */
    boolean delete(int replyId);

    /**
     * @param replyId 回复id
     * @return 回复信息
     */
    TbFeedbackReply get(int replyId);

    /**
     * @param infoId 反馈信息id
     * @return 回复信息
     */
    TbFeedbackReply getByInfoId(int infoId);

    /**
     * @return 反馈列表
     */
    List<TbFeedbackReply> list();

    List<TbFeedbackReply> list(String adminName, Date startDate, Date endDate, Integer pageNum, Integer pageSize);

    /**
     * @param replyId 回复id
     * @return 记录数
     */
    int count(int replyId);

    /**
     * @param infoId 反馈编号
     * @return 记录数
     */
    int countByInfoId(int infoId);
}
