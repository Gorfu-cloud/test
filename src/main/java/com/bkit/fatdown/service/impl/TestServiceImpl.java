package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.mappers.TbPaperBasicMapper;
import com.bkit.fatdown.mappers.TbQuestionBasicMapper;
import com.bkit.fatdown.mappers.TbTestRecordMapper;
import com.bkit.fatdown.mappers.TbTestScoreMapper;
import com.bkit.fatdown.service.ITestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @file: TestServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 测验功能实现类
 * @date: Created in 2019/7/11 15:38
 * @modified:
 * @version: 1.0
 */

@Service
public class TestServiceImpl implements ITestService {

    @Resource
    TbPaperBasicMapper paperBasicMapper;

    @Resource
    TbQuestionBasicMapper questionBasicMapper;

    @Resource
    TbTestRecordMapper testRecordMapper;

    @Resource
    TbTestScoreMapper testScoreMapper;

    /**
     * 获取考试信息
     *
     * @return
     */
    @Override
    public List<TbPaperBasic> listPaperInfo() {
        TbPaperBasicExample example = new TbPaperBasicExample();
        example.createCriteria()
                .andStartTimeIsNotNull();
        // 按日期(从近到远)降序输出
        example.setOrderByClause("start_time asc");
        return paperBasicMapper.selectByExample(example);
    }

    /**
     * 根据试卷ID获取试题
     *
     * @param paperId
     * @return
     */
    @Override
    public TbQuestionBasic getQuestionByPaperId(int paperId) {
        TbQuestionBasicExample example = new TbQuestionBasicExample();
        example.createCriteria()
                .andPaperIdEqualTo(paperId);
        return questionBasicMapper.selectByExample(example).get(0);
    }

    /**
     * 通过题号获取具体题目
     *
     * @param values
     * @return
     */

    @Override
    public List<TbQuestionBasic> listQuestionByQuestionId(List<Integer> values) {
        TbQuestionBasicExample questionBasicExample = new TbQuestionBasicExample();
        questionBasicExample.createCriteria()
                .andIdIn(values);

        return questionBasicMapper.selectByExample(questionBasicExample);
    }

    /**
     * 创建测试记录
     *
     * @param testRecord
     * @return
     */
    @Override
    public Boolean insertTestRecord(TbTestRecord testRecord) {
        testRecord.setGmtCreate(new Date());
        testRecord.setGmtModified(new Date());
        return testRecordMapper.insert(testRecord) > 0;
    }

    @Override
    public Double getTestScoreByRecord(TbTestRecord testRecord){
        String userAnswer = testRecord.getUserAnswer();
        int questionId = testRecord.getQuestionId();
        TbQuestionBasic questionBasic = questionBasicMapper.selectByPrimaryKey(questionId);
        String questionAnswer = questionBasic.getAnswer();
        Double score = questionBasic.getScore();
        // 答对了
        if (questionAnswer.equals(userAnswer)){
            return score;
        }

        return 0.0;
    }

    /**
     * 插入测试分数
     *
     * @param testScore
     * @return
     */
    @Override
    public Boolean insertTestScore(TbTestScore testScore) {
        return testScoreMapper.insert(testScore) > 0;
    }

    /**
     * 查询得分
     *
     * @param uid
     * @param paperId
     * @return
     */
    @Override
    public List<TbTestScore> listScoreByUidAndPaperId(int uid, int paperId) {
        TbTestScoreExample testScoreExample = new TbTestScoreExample();
        testScoreExample.createCriteria()
                .andUserEqualTo(uid)
                .andUserEqualTo(paperId);
        return testScoreMapper.selectByExample(testScoreExample);
    }

    /**
     * 根据UID,date获取考试成绩
     *
     * @param uid
     * @param date
     * @return
     */
    @Override
    public TbTestScore getScoreByUidAndDate(int uid, Date date) {
        return null;
    }

    /**
     * 根据id查找分数
     *
     * @param id
     * @return
     */
    @Override
    public TbTestScore getScoreById(int id) {
        return null;
    }
}
