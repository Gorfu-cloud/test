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

    boolean insert(TbFeedbackInfo feedbackInfo);

    boolean update(TbFeedbackInfo feedbackInfo);

    boolean delete(int infoId);

    TbFeedbackInfo getFeedbackInfo(int infoId);

    List<TbFeedbackInfo> listFeedbackInfo(int uid);

    int countByUid(int uid);

    int countById(int id);
}
