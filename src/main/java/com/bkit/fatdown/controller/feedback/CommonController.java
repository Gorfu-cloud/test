package com.bkit.fatdown.controller.feedback;

import com.bkit.fatdown.dto.CommonPageDTO;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbCommonQuestion;
import com.bkit.fatdown.entity.TbCommonQuestionInstance;
import com.bkit.fatdown.service.ICommonQuestionInstanceService;
import com.bkit.fatdown.service.ICommonQuestionService;
import io.swagger.annotations.Api;
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

    @ApiOperation("获取所有问题类型列表（已编辑完成）")
    @RequestMapping(value = "/questionTypes/open", method = RequestMethod.GET)
    @CrossOrigin
    public CommonResultDTO<List<TbCommonQuestion>> listCommonQuestionOpen() {
        List<TbCommonQuestion> questionList = commonQuestionService.listCommonQuestion(OPEN);
        if (questionList == null) {
            return CommonResultDTO.failed();
        }
        return CommonResultDTO.success(questionList);
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

    @ApiOperation("分页: 获取问题实例列表")
    @CrossOrigin
    @RequestMapping(value = "/questions/{typeId}/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public CommonResultDTO listQuestionInstanceByPage(@PathVariable Integer typeId, @PathVariable Integer pageNum,
                                                      @PathVariable Integer pageSize) {
        if (questionInstanceService.count(typeId) == DATA_NO_EXIST) {
            return CommonResultDTO.validateFailed();
        }

        List<TbCommonQuestionInstance> instanceList = questionInstanceService.listCommonQuestionInstanceByPage(typeId, pageNum, pageSize);

        return CommonResultDTO.success(CommonPageDTO.restPage(instanceList));
    }

    @ApiOperation("添加问题类型")
    @CrossOrigin
    @RequestMapping(value = "/questionType", method = RequestMethod.POST)
    public CommonResultDTO addQuestionType(@RequestParam String title, @RequestParam Integer status) {
        if (title.isEmpty() || status == null || status > 1 || status < 0) {
            return CommonResultDTO.validateFailed("status/title错误");
        }

        if (commonQuestionService.countCommonQuestion(title) > 0) {
            return CommonResultDTO.validateFailed("title 存在");
        }

        TbCommonQuestion question = new TbCommonQuestion();
        question.setTitle(title);
        question.setStatus(status);

        if (commonQuestionService.insert(question)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
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

    @ApiOperation("更新问题类型,(map中选填,title,status")
    @CrossOrigin
    @RequestMapping(value = "/questionType/{typeId}", method = RequestMethod.PUT)
    public CommonResultDTO updateQuestionType(@PathVariable Integer typeId, @RequestBody HashMap<String, String> map) {

        if (!map.containsKey("title") || !map.containsKey("status")) {
            return CommonResultDTO.validateFailed("status/title错误");
        }

        String title = map.get("title");
        Integer status = Integer.valueOf(map.get("status"));

        if (title.isEmpty() || status > 1 || status < 0) {
            return CommonResultDTO.validateFailed("status/title错误");
        }

        if (commonQuestionService.countCommonQuestion(title) > 0 || commonQuestionService.countCommonQuestion(typeId) == DATA_NO_EXIST) {
            return CommonResultDTO.validateFailed("title 存在/ 问题类型不存在");
        }

        TbCommonQuestion question = new TbCommonQuestion();
        question.setTitle(title);
        question.setStatus(status);
        question.setId(typeId);

        if (commonQuestionService.update(question)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("获取所有问题类型列表")
    @CrossOrigin
    @RequestMapping(value = "/questionTypes", method = RequestMethod.GET)
    public CommonResultDTO<List<TbCommonQuestion>> listCommonQuestion() {
        List<TbCommonQuestion> questionList = commonQuestionService.listCommonQuestion();
        if (questionList == null) {
            return CommonResultDTO.failed();
        }
        return CommonResultDTO.success(questionList);
    }

    @ApiOperation("分页: 获取所有问题类型列表")
    @CrossOrigin
    @RequestMapping(value = "/questionTypes/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public CommonResultDTO listCommonQuestionByPage(@PathVariable Integer pageNum, @PathVariable Integer pageSize,
                                                    @RequestParam(required = false) String title, @RequestParam Integer status) {
        if (pageNum == null || pageSize == null) {
            return CommonResultDTO.validateFailed();
        }

        List<TbCommonQuestion> questionList;

        if (title == null) {
            questionList = commonQuestionService.listCommonQuestion(pageNum, pageSize, status);
        } else {
            questionList = commonQuestionService.listCommonQuestion(title, pageNum, pageSize, status);
        }

        return CommonResultDTO.success(CommonPageDTO.restPage(questionList));
    }

    @ApiOperation("对问题说明帮助进行评价（map中填写，evaluation: 0未评价，1有帮助，2无帮助")
    @CrossOrigin
    @RequestMapping(value = "/question/evaluation/{instanceId}", method = RequestMethod.PUT)
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

    @ApiOperation("增加问题实例说明")
    @CrossOrigin
    @RequestMapping(value = "/question/{questionType}", method = RequestMethod.POST)
    public CommonResultDTO addQuestionInstance(@PathVariable Integer questionType, @RequestParam String title,
                                               @RequestParam String content, @RequestParam Integer status) {
        if (commonQuestionService.countCommonQuestion(questionType) == DATA_NO_EXIST || title.isEmpty()
                || content.isEmpty() || status > 1 || status < 0) {
            return CommonResultDTO.validateFailed();
        }

        TbCommonQuestionInstance questionInstance = new TbCommonQuestionInstance();
        questionInstance.setQuestionId(questionType);
        questionInstance.setTitle(title);
        questionInstance.setContent(content);
        questionInstance.setStatus(status);

        if (questionInstanceService.insert(questionInstance)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("更新问题实例说明,(map 中选填 title,status,content)")
    @CrossOrigin
    @RequestMapping(value = "/question/{instanceId}", method = RequestMethod.PUT)
    public CommonResultDTO updateQuestionInstance(@PathVariable Integer instanceId,@RequestBody HashMap<String,String> map) {
        if (instanceId==null||map == null){
            return CommonResultDTO.validateFailed();
        }

        TbCommonQuestionInstance instance = new TbCommonQuestionInstance();
        instance.setId(instanceId);

        if (map.containsKey("title")){
            instance.setTitle(map.get("title"));
        }

        if (map.containsKey("content")){
            instance.setContent(map.get("content"));
        }

        if (map.containsKey("status")){
            instance.setStatus(Integer.valueOf(map.get("status")));
        }

        if (questionInstanceService.update(instance)){
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

}
