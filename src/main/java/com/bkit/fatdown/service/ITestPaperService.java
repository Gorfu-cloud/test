package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbPaperBasic;
import com.bkit.fatdown.entity.TbQuestionBasic;

import java.util.Date;
import java.util.List;

/**
 * @file: ITestPaperService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 抢答模块功能接口
 * @date: Created in 2019/7/18 14:48
 * @modified:
 * @version: 1.0
 */

public interface ITestPaperService {
    /**
     * 获取抢答基础信息
     *
     * @return
     */
    List<TbPaperBasic> listPaperBasic();

    /**
     * 获取对应的题目内容
     *
     * @param id
     * @return
     */
    TbQuestionBasic getQuestionBasicById(int id);

    /**
     * 获取id记录数
     *
     * @param id
     * @return
     */
    boolean countQuestionById(int id);

    /**
     * 删除测试消息
     *
     * @param id
     * @return
     */
    boolean deletePaperInfo(int id);

    /**
     * 添加测试消息
     *
     * @param paperBasic
     * @return
     */
    boolean insertPaperInfo(TbPaperBasic paperBasic);

    /**
     * 修改测试信息
     *
     * @param paperBasic
     * @return
     */
    boolean updatePaperInfo(TbPaperBasic paperBasic);

    /**
     * 通过测试编号获取题目
     *
     * @param paperId
     * @return
     */
    List<TbQuestionBasic> listQuestionByPaperId(int paperId);

    /**
     * 统计试题的题目编号
     *
     * @param paperId
     * @return
     */
    int countQuestionByPaperId(int paperId);

    /**
     * 获取当周考试信息
     *
     * @param date
     * @return
     */
    List<TbPaperBasic> listPaperCurrentWeek(Date date);

    /**
     * 获取本周之前考试信息
     *
     * @param date
     * @return
     */
    List<TbPaperBasic> listPaperBeforeWeek(Date date);
}
