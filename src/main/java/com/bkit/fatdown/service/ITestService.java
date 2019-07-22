package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbPaperBasic;
import com.bkit.fatdown.entity.TbQuestionBasic;
import com.bkit.fatdown.entity.TbTestRecord;

import java.util.Date;
import java.util.List;

/**
 * @file: ITestService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 测验功能接口
 * @date: Created in 2019/7/11  15:37
 * @modified:
 * @version: 1.0
 */

public interface ITestService {

    /**
     * 获取所有试卷
     *
     * @return
     */
    List<TbPaperBasic> listPaperInfo();

    /**
     * 根据试卷ID获取试题
     *
     * @param paperId
     * @return
     */
    TbQuestionBasic getQuestionByPaperId(int paperId);

    /**
     * 根据试题ID获取试题
     *
     * @param values
     * @return
     */
    List<TbQuestionBasic> listQuestionByQuestionId(List<Integer> values);

    /**
     * 添加答题记录
     *
     * @param testRecord
     * @return
     */
    Boolean insertTestRecord(TbTestRecord testRecord);

    /**
     * 获取考试成绩
     *
     * @param testRecord
     * @return
     */
    Double getTestScoreByRecord(TbTestRecord testRecord);

    /**
     * 根据id查找分数
     *
     * @param id
     * @return
     */
    Double getScoreById(int id);

    /**
     * 更新得分记录
     *
     * @param record
     * @return
     */
    Boolean update(TbTestRecord record);

    /**
     * 获取答题排名
     *
     * @param record
     * @return
     */
    Integer getRankByRecord(TbTestRecord record);

    /**
     * 通过record中的uid，paperId，questionId获取答题记录
     *
     * @param record
     * @return
     */
    TbTestRecord getTestRecordByRecord(TbTestRecord record);

    /**
     * 查找记录条数，通过userId，paperId，questionId
     */
    Integer countTestRecordByUserIdAndPaperIdAndQuestionId(int userId, int paperId, int questionId);
}
