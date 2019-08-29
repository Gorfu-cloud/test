package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbCommonQuestion;

import java.util.List;

/**
 * @file: ICommonQuestionService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 常见问题类型
 * @date: Created in 8/13/19  3:08 PM
 * @modified:
 * @version: 1.0
 */
public interface ICommonQuestionService {
    /**
     * @param commonQuestion 常见问题
     * @return 是否成功
     */
    boolean insert(TbCommonQuestion commonQuestion);

    /**
     * @param commonQuestion 常见问题
     * @return 是否成功
     */
    boolean update(TbCommonQuestion commonQuestion);

    /**
     * @param id 问题id
     * @return 是否成功
     */
    boolean delete(int id);

    /**
     * @param id 问题id
     * @return 常见问题信息
     */
    TbCommonQuestion getCommonQuestion(int id);

    /**
     * @param status 开启状态：0 不开启， 1开启
     * @return 参加问题列表
     */
    List<TbCommonQuestion> listCommonQuestion(int status);

    List<TbCommonQuestion> listCommonQuestion(Integer pageNum, Integer pageSize, int status);

    List<TbCommonQuestion> listCommonQuestion(String title,Integer pageNum, Integer pageSize, int status);

    List<TbCommonQuestion> listCommonQuestion(Integer pageNum, Integer pageSize);

    /**
     * @return 所有问题类型
     */
    List<TbCommonQuestion> listCommonQuestion();

    /**
     * @param name 类型名称
     * @return 记录数
     */
    int countCommonQuestion(String name);

    /**
     * @param id 记录编码
     * @return 记录数
     */
    int countCommonQuestion(int id);
}
