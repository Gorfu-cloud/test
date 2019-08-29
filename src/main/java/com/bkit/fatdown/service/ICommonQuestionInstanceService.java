package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbCommonQuestionInstance;

import java.util.List;

/**
 * @file: ICommonQuestionInstanceService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 反馈问题实例功能接口
 * @date: Created in 8/13/19  3:09 PM
 * @modified:
 * @version: 1.0
 */
public interface ICommonQuestionInstanceService {
    /**
     * @param questionInstance 问题实例
     * @return 是否成功
     */
    boolean insert(TbCommonQuestionInstance questionInstance);

    /**
     * @param questionInstance 问题实例
     * @return 是否成功
     */
    boolean update(TbCommonQuestionInstance questionInstance);

    /**
     * @param id 实例id
     * @return 是否成功
     */
    boolean delete(int id);

    /**
     * @param id 实例id
     * @return 实例
     */
    TbCommonQuestionInstance getCommonQuestionInstance(int id);

    /**
     * @param questionId 类型id
     * @return 常见问题列表
     */
    List<TbCommonQuestionInstance> listCommonQuestionInstance(int questionId);

    /**
     * @param questionId 类型id
     * @return 常见问题列表
     */
    List<TbCommonQuestionInstance> listCommonQuestionInstanceByPage(int questionId,Integer pageNum,Integer pageSize);

    /**
     * @param questionId 问题实例类型
     * @param status     状态
     * @return 相对状态问题实例类型
     */
    List<TbCommonQuestionInstance> listCommonQuestionInstance(int questionId, int status);

    /**
     * @param questionId 类型id
     * @return 记录数
     */
    int count(int questionId);

    /**
     * @param id 问题id
     * @return 记录数
     */
    int countById(int id);

    /**
     * @param instanceId 实例id
     * @param evaluation 评价：0 未，1有帮助，2无帮助
     * @return
     */
    boolean instanceEvaluation(int instanceId, int evaluation);
}
