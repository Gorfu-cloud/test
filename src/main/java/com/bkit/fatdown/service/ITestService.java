package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbPaperBasic;
import com.bkit.fatdown.entity.TbQuestionBasic;
import com.bkit.fatdown.entity.TbTestRecord;
import com.bkit.fatdown.entity.TbTestScore;

import java.util.List;

public interface ITestService {
    /*获取所有试卷*/
    List<TbPaperBasic> getPaperInfo();

    /*根据试卷ID获取试题*/
    List<TbQuestionBasic> getQuestionByPaperID(int paperID);

    /*根据试题ID获取试题*/
    List<TbQuestionBasic> getQuestionByQuestionID(List<Integer> values);

    /*添加答题记录*/
    Boolean insertTestRecord(TbTestRecord ttr);

    /*添加成绩*/
    Boolean insertTestScore(TbTestScore tts);

    /*根据UID和PaperID查询成绩*/
    List<TbTestScore> getScoreByUIDAndPaperID(int UID, int paperID);
}
