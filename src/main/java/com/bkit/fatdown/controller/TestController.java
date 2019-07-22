package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbPaperBasic;
import com.bkit.fatdown.entity.TbQuestionBasic;
import com.bkit.fatdown.entity.TbTestRecord;
import com.bkit.fatdown.service.ITestPaperService;
import com.bkit.fatdown.service.ITestService;
import com.bkit.fatdown.utils.DataMapUtils;
import com.sun.org.apache.xml.internal.security.c14n.implementations.Canonicalizer11_OmitComments;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @file: TestController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 测试模块控制器
 * @date: Created in 2019/7/11 15:34
 * @modified:
 * @version: 1.0
 */

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private ITestService testService;

    @Resource
    private ITestPaperService paperService;

    @ApiOperation("获取所有试题基础信息(编号,日期,标题)")
    @CrossOrigin
    @RequestMapping(value = "/listTestInfo", method = RequestMethod.GET)
    public CommonResultDTO listAllTestInfo() {
        List<TbPaperBasic> paperBasicList = testService.listPaperInfo();
        if (paperBasicList.size() == 0) {
            return CommonResultDTO.failed("当前没有考试");
        }
        return CommonResultDTO.success(paperBasicList);
    }

    @ApiOperation("通过questionId,获取试题中题目内容")
    @CrossOrigin
    @RequestMapping(value = "/getQuestionById/{id}", method = RequestMethod.GET)
    public CommonResultDTO getQuestionById(@PathVariable Integer id) {
        if (id == null || !paperService.countQuestionById(id)) {
            return CommonResultDTO.validateFailed("id无效!");
        }
        TbQuestionBasic questionBasic = paperService.getQuestionBasicById(id);
        if (questionBasic != null) {
            return CommonResultDTO.success(questionBasic);
        } else {
            return CommonResultDTO.failed();
        }
    }

    @ApiOperation("通过测试paperId,获取对应试题")
    @CrossOrigin
    @RequestMapping(value = "/listQuestionInfo/{paperId}", method = RequestMethod.GET)
    public CommonResultDTO listQuestionInfo(@PathVariable Integer paperId) {
        if (paperId == null || paperService.countQuestionByPaperId(paperId) == 0) {
            return CommonResultDTO.validateFailed("paperId无效");
        }
        List<TbQuestionBasic> questionBasicList = paperService.listQuestionByPaperId(paperId);
        if (questionBasicList.size() > 0) {
            return CommonResultDTO.success(questionBasicList);
        } else {
            return CommonResultDTO.failed();
        }
    }

    @ApiOperation("提交抢答，需要，userId，paperId，questionId，userAnswer")
    @CrossOrigin
    @RequestMapping(value = "/submitAnswer", method = RequestMethod.POST)
    public CommonResultDTO submitAnswer(@RequestBody HashMap<String, String> map) {
        // 缺乏需要条件，返回400
        if (!map.containsKey("userId") || !map.containsKey("paperId")
                || !map.containsKey("questionId") || !map.containsKey("userAnswer")) {
            return CommonResultDTO.validateFailed("userId/paperId/questionId/userAnswer/错误");
        }

        TbTestRecord record = DataMapUtils.getTestRecordFromMap(map);
        // 获取用户答题得分
        Double userScore = testService.getTestScoreByRecord(record);

        record.setUserScore(userScore);

        if (testService.insertTestRecord(record)) {

            if (userScore > 0) {
                // 排名加分
                double addRankScore = 0.0;
                // 加分分值
                double[] addScoreArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

                TbTestRecord testRecord = testService.getTestRecordByRecord(record);
                // 排名名次
                int rank = testService.getRankByRecord(testRecord);
                System.out.println(rank);
                // 排名前十加分
                if (rank < addScoreArray.length + 1) {
                    addRankScore = addScoreArray[rank];
                    double score = testRecord.getUserScore();
                    testRecord.setUserScore(score + addRankScore);
                    testService.update(testRecord);
                    return CommonResultDTO.success(score + addRankScore);
                }
            }

            return CommonResultDTO.success(userScore);
        }


        return CommonResultDTO.failed();
    }

    @ApiOperation("检查是否已经答题过,通过userID，paperId，questionId")
    @CrossOrigin
    @RequestMapping(value = "/checkTestStatus", method = RequestMethod.GET)
    public CommonResultDTO checkTestStatus(Integer userId, Integer paperId, Integer questionId) {
        HashMap<String, Integer> map = new HashMap<>(2);
        if (testService.countTestRecordByUserIdAndPaperIdAndQuestionId(userId, paperId, questionId) == 0) {
            map.put("testStatus", 0);
        } else {
            map.put("testStatus", 1);
        }
        return CommonResultDTO.success(map);
    }
}
