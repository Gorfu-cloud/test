package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.mappers.TbPaperBasicMapper;
import com.bkit.fatdown.mappers.TbQuestionBasicMapper;
import com.bkit.fatdown.mappers.TbTestRecordMapper;
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
     * 通过record中的uid，paperId，questionId获取答题记录
     *
     * @param record
     * @return
     */
    @Override
    public TbTestRecord getTestRecordByRecord(TbTestRecord record) {
        int userId = record.getUserId();
        int paperId = record.getPaperId();
        int questionId = record.getQuestionId();

        TbTestRecordExample example = new TbTestRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(userId)
                .andPaperIdEqualTo(paperId)
                .andQuestionIdEqualTo(questionId);
        // 按近到远
        example.setOrderByClause("gmt_create desc");

        return testRecordMapper.selectByExample(example).get(0);
    }

    /**
     * 更新得分记录
     *
     * @param record
     * @return
     */
    @Override
    public Boolean update(TbTestRecord record) {
        return testRecordMapper.updateByPrimaryKeySelective(record) > 0;
    }

    @Override
    public Integer countTestRecordByUserIdAndPaperId(int userId, int paperId) {
        TbTestRecordExample example = new TbTestRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(userId)
                .andPaperIdEqualTo(paperId);
        return (int) testRecordMapper.countByExample(example);
    }

    /**
     * 查找记录条数，通过userId，paperId，questionId
     *
     * @param userId
     * @param paperId
     * @param questionId
     */
    @Override
    public Integer countTestRecordByUserIdAndPaperIdAndQuestionId(int userId, int paperId, int questionId) {
        TbTestRecordExample example = new TbTestRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(userId)
                .andPaperIdEqualTo(paperId)
                .andQuestionIdEqualTo(questionId);

        return (int) testRecordMapper.countByExample(example);
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

    /**
     * 获取答题分数
     *
     * @param testRecord
     * @return
     */
    @Override
    public Double getTestScoreByRecord(TbTestRecord testRecord) {
        String userAnswer = testRecord.getUserAnswer();
        int questionId = testRecord.getQuestionId();
        // 获取试卷信息
        TbQuestionBasic questionBasic = questionBasicMapper.selectByPrimaryKey(questionId);
        String questionAnswer = questionBasic.getAnswer();
        Double score = questionBasic.getScore();
        // 答对了
        if (questionAnswer.equals(userAnswer)) {
            return score;
        }

        return 0.0;
    }

    /**
     * 根据id查找分数
     *
     * @param id
     * @return
     */
    @Override
    public Double getScoreById(int id) {

        return testRecordMapper.selectByPrimaryKey(id).getUserScore();
    }

    /**
     * 获取答题排名
     *
     * @param record
     * @return
     */
    @Override
    public Integer getRankByRecord(TbTestRecord record) {
        // 交卷时间，试卷号，试题号
        Date submitTestTime = record.getGmtCreate();
        Integer paperId = record.getPaperId();
        Integer questionId = record.getQuestionId();

        TbTestRecordExample example = new TbTestRecordExample();
        example.createCriteria()
                // 交卷时间大于或小等于自己
                .andGmtCreateLessThanOrEqualTo(submitTestTime)
                // 试卷号
                .andPaperIdEqualTo(paperId)
                // 试题号
                .andQuestionIdEqualTo(questionId);

        return Math.toIntExact(testRecordMapper.countByExample(example));
    }
}
