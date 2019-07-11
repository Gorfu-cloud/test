package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.mappers.*;
import com.bkit.fatdown.service.ITestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    TbPaperQuestionRelationMapper paperQuestionRelationMapper;

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
                .andDateIsNotNull();
        // 按日期降序输出
        example.setOrderByClause("date desc");
        return paperBasicMapper.selectByExample(example);
    }

    @Override
    public List<TbQuestionBasic> listQuestionByPaperId(int paperId) {

        TbPaperQuestionRelationExample paperQuestionRelationExample = new TbPaperQuestionRelationExample();
        paperQuestionRelationExample.createCriteria()
                .andPaperIdEqualTo(paperId);
        // 获取同一套试卷的题目
        List<TbPaperQuestionRelation> relations = paperQuestionRelationMapper.selectByExample(paperQuestionRelationExample);
        List<Integer> keys = new ArrayList<>();

        for (TbPaperQuestionRelation p : relations) {
            keys.add(p.getQuestionId());
        }

        // 查找题目详情
        TbQuestionBasicExample questionBasicExample = new TbQuestionBasicExample();
        questionBasicExample.createCriteria()
                .andIdIn(keys);

        return questionBasicMapper.selectByExample(questionBasicExample);
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
        return testRecordMapper.insert(testRecord) > 0;
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
}
