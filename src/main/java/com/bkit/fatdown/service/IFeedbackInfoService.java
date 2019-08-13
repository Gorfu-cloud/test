package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbFeedbackInfo;

import java.util.List;

/**
 * @file: IFeedbackInfoService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 反馈信息功能接口
 * @date: Created in 8/13/19  3:06 PM
 * @modified:
 * @version: 1.0
 */
public interface IFeedbackInfoService {

    /**
     * @param feedbackInfo 反馈信息
     * @return 是否成功
     */
    boolean insert(TbFeedbackInfo feedbackInfo);

    /**
     * @param feedbackInfo 反馈信息
     * @return 是否成功
     */
    boolean update(TbFeedbackInfo feedbackInfo);

    /**
     * @param infoId 信息id
     * @return 是否成功
     */
    boolean delete(int infoId);

    /**
     * @param infoId 信息id
     * @return 反馈信息
     */
    TbFeedbackInfo getFeedbackInfo(int infoId);

    /**
     * @param uid 用户id
     * @return 反馈信息
     */
    List<TbFeedbackInfo> listFeedbackInfo(int uid);

    /**
     * @param uid 用户id
     * @return 记录数
     */
    int countByUid(int uid);

    /**
     * @param id 记录id
     * @return 记录数
     */
    int countById(int id);
}
