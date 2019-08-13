package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbFeedbackType;

import java.util.List;

/**
 * @file: IFeedbackTypeService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 反馈问题类型功能接口
 * @date: Created in 8/13/19  3:08 PM
 * @modified:
 * @version: 1.0
 */

public interface IFeedbackTypeService {

    /**
     * @param feedbackType 反馈类型
     * @return 是否成功
     */
    boolean insert(TbFeedbackType feedbackType);

    /**
     * @param feedbackType 反馈类型
     * @return 是否成功
     */
    boolean update(TbFeedbackType feedbackType);

    /**
     * @param typeId 类型id
     * @return 是否成功
     */
    boolean delete(int typeId);

    /**
     * @param typeId 反馈类型id
     * @return 是否成功
     */
    TbFeedbackType get(int typeId);

    /**
     * @return 所有类型
     */
    List<TbFeedbackType> list();

    /**
     * @param status 类型状态
     * @return 指定状态类型
     */
    List<TbFeedbackType> list(int status);


    /**
     * @param typeId 类型id
     * @return 记录数
     */
    int count(int typeId);
}
