package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbCommonQuestion;
import com.bkit.fatdown.entity.TbCommonQuestionInstance;
import com.bkit.fatdown.service.ICommonQuestionInstanceService;
import com.bkit.fatdown.service.ICommonQuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @file: CommonController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 常见问题
 * @date: Created in 8/13/19  4:55 PM
 * @modified:
 * @version: 1.0
 */

@Api(value = "/common", tags = "常见问题模块")
@RequestMapping("/common")
@RestController
public class CommonController {

    @Resource
    private ICommonQuestionService commonQuestionService;

    @Resource
    private ICommonQuestionInstanceService questionInstanceService;


    private static final Integer OPEN = 1;
    private static final Integer DATA_NO_EXIST = 0;

    @ApiOperation("获取问题列表")
    @RequestMapping(value = "/questionTypes", method = RequestMethod.GET)
    @CrossOrigin
    public CommonResultDTO<List<TbCommonQuestion>> listCommonQuestion() {
        List<TbCommonQuestion> questionList = commonQuestionService.listCommonQuestion(OPEN);
        if (questionList == null) {
            return CommonResultDTO.failed();
        }
        return CommonResultDTO.success(questionList);
    }


    @ApiOperation("删除问题类型")
    @RequestMapping(value = "/questionType/{id}", method = RequestMethod.DELETE)
    @CrossOrigin
    public CommonResultDTO deleteCommonQuestion(@PathVariable int id) {
        if (commonQuestionService.countCommonQuestion(id) == DATA_NO_EXIST) {
            return CommonResultDTO.validateFailed();
        }

        if (commonQuestionService.delete(id)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("获取问题实例列表")
    @CrossOrigin
    @RequestMapping(value = "/questions/{typeId}", method = RequestMethod.GET)
    public CommonResultDTO<List<TbCommonQuestionInstance>> listQuestionInstance(@PathVariable Integer typeId) {
        if (questionInstanceService.count(typeId) == DATA_NO_EXIST) {
            return CommonResultDTO.validateFailed();
        }

        List<TbCommonQuestionInstance> instanceList = questionInstanceService.listCommonQuestionInstance(typeId);
        if (instanceList == null) {
            return CommonResultDTO.failed();
        }
        return CommonResultDTO.success(instanceList);
    }

    @ApiOperation("对问题说明帮助进行评价（map中填写，evaluation: 0未评价，1有帮助，2无帮助")
    @CrossOrigin
    @RequestMapping(value = "/question/evaluation/{instanceId}", method = RequestMethod.PATCH)
    public CommonResultDTO addQuestionInstanceEvaluation(@PathVariable Integer instanceId, @RequestBody HashMap<String, Integer> map) {
        String evaluationStr = "evaluation";

        if (questionInstanceService.countById(instanceId) == DATA_NO_EXIST || !map.containsKey(evaluationStr)) {
            return CommonResultDTO.validateFailed();
        }

        int evaluation = map.get(evaluationStr);

        if (questionInstanceService.instanceEvaluation(instanceId, evaluation)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }


}
