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

    Double getTestScoreByRecord(TbTestRecord testRecord);

    /**
     * 根据UID和PaperID查询成绩
     *
     * @param uid
     * @param paperId
     * @return
     */
    Integer listScoreByUidAndPaperId(int uid, int paperId);

    /**
     * 根据UID,date获取考试成绩
     *
     * @param uid
     * @param date
     * @return
     */
    Integer getScoreByUidAndDate(int uid, Date date);

    /**
     * 根据id查找分数
     *
     * @param id
     * @return
     */
    Integer getScoreById(int id);
}
