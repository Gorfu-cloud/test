package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbLearnInfo;
import com.bkit.fatdown.entity.TbLearnRecord;
import com.bkit.fatdown.service.ILearnRecordService;
import com.bkit.fatdown.service.ILearnService;
import com.bkit.fatdown.common.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @file: LearnController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 学习模块控制器
 * @date: Created in 2019/7/11 13:23
 * @modified:
 * @version: 1.0
 */
@Api(value = "/learn", tags = "学习知识模块")
@RestController
@RequestMapping("/learn")
public class LearnController {

    /**
     * 学习积分最大数
     */
    private static final int MAX_RECORD_COUNT = 10;

    @Resource
    ILearnRecordService learnRecordService;

    @Resource
    ILearnService learnService;

    @ApiOperation("创建学习记录")
    @CrossOrigin
    @RequestMapping(value = "/Record", method = RequestMethod.POST)
    public CommonResultDTO insertLearnRecord(@RequestParam Integer uid, @RequestParam Integer learnId) {

        Date today = new Date();

        // 学习积分已满的时候
        if (learnRecordService.countByUidBetweenDate(uid, DateUtils.getDateStart(today), DateUtils.getDateEnd(today)) >= MAX_RECORD_COUNT) {
            return CommonResultDTO.validateFailed("今天获取的学习积分已满.");
        }

        TbLearnRecord learnRecord = new TbLearnRecord();
        learnRecord.setGmtCreate(new Date());
        learnRecord.setGmtModified(new Date());
        learnRecord.setUserId(uid);
        learnRecord.setLearnId(learnId);

        // 执行插入操作
        if (learnRecordService.insert(learnRecord)) {
            return CommonResultDTO.success("创建记录成功");
        } else {
            return CommonResultDTO.failed("插入记录失败");
        }
    }

    @ApiOperation("获取开启的学习内容")
    @CrossOrigin
    @RequestMapping(value = "/LearnInfo", method = RequestMethod.GET)
    public CommonResultDTO listLearnInfo() {
        Date today = new Date();

        List<TbLearnInfo> learnInfoList = learnService.listByDate(today);

        if (learnInfoList.size() > 0) {
            return CommonResultDTO.success(learnInfoList);
        }

        return CommonResultDTO.failed("目前没有学习内容");
    }

    @ApiOperation("获取所有学习内容")
    @CrossOrigin
    @RequestMapping(value = "/getAllLearnInfo", method = RequestMethod.GET)
    public CommonResultDTO getAllLearnInfo() {
        return CommonResultDTO.success(learnService.listAll());
    }

    @ApiOperation("通过ID获取指定学习内容")
    @CrossOrigin
    @RequestMapping(value = "/LearnInfo/{id}", method = RequestMethod.GET)
    public CommonResultDTO getLearnInfoById(@PathVariable Integer id) {
        return CommonResultDTO.success(learnService.getById(id));
    }

    @ApiOperation("通过uid,获取学习分数")
    @CrossOrigin
    @RequestMapping(value = "/Points/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getPointsByUid(@PathVariable Integer uid) {
        return CommonResultDTO.failed("未完成");
    }

    @ApiOperation("通过id,获取题目解析")
    @CrossOrigin
    @RequestMapping(value = "/Explanation/{id}", method = RequestMethod.GET)
    public CommonResultDTO getExplanationById(@PathVariable Integer id) {
        return CommonResultDTO.success(learnService.getById(id));
    }
}
