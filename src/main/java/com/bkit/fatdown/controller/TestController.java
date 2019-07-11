package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbPaperBasic;
import com.bkit.fatdown.entity.TbQuestionBasic;
import com.bkit.fatdown.service.ITestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    ITestService testService;

    @ApiOperation("获取所有试题基础信息(编号,日期,标题)")
    @CrossOrigin
    @RequestMapping(value = "/getAllTestInfo", method = RequestMethod.GET)
    public CommonResultDTO listAllTestInfo() {
        List<TbPaperBasic> paperBasicList = testService.listPaperInfo();
        if (paperBasicList.size() == 0) {
            return CommonResultDTO.failed("当前没有考试");
        }
        return CommonResultDTO.success(paperBasicList);
    }

    @ApiOperation("通过试题号,获取试题中题目内容")
    @CrossOrigin
    @RequestMapping(value = "/getQuestionByPaperId/{paperId}", method = RequestMethod.GET)
    public CommonResultDTO listQuestionByPaperId(@PathVariable Integer paperId) {
        List<TbQuestionBasic> questionBasicList = testService.listQuestionByPaperId(paperId);
        if (questionBasicList.size() == 0) {
            return CommonResultDTO.failed("当前试题没有题目");
        }
        return CommonResultDTO.success(questionBasicList);
    }

    // 通过提交答案,这里提交后查询排名,由此查看排名进行加分
    //    public CommonResultDTO submitAnswers(@PathVariable int uid,)

}
