package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbFeedbackInfo;
import com.bkit.fatdown.service.IFeedbackInfoService;
import com.bkit.fatdown.service.IFeedbackReplyService;
import com.bkit.fatdown.service.IFeedbackTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.omg.CORBA.COMM_FAILURE;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @file: FeedbackController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 用户反馈模块
 * @date: Created in 8/13/19  2:21 PM
 * @modified:
 * @version: 1.0
 */
@Api(value = "/feedback", tags = "用户反馈模块")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Resource
    private IFeedbackReplyService replyService;

    @Resource
    private IFeedbackTypeService typeService;

    @Resource
    private IFeedbackInfoService infoService;

    @ApiOperation("添加反馈信息")
    @CrossOrigin
    @RequestMapping(value = "/info/{uid}", method = RequestMethod.POST)
    public CommonResultDTO addInfo(@PathVariable Integer uid) {
        return CommonResultDTO.success();
    }

    public CommonResultDTO updateInfo() {
        return CommonResultDTO.success();
    }

    public CommonResultDTO deleteInfo() {
        return CommonResultDTO.success();
    }

    public CommonResultDTO<List<TbFeedbackInfo>> listInfoByUid() {
        return CommonResultDTO.success();
    }

    public CommonResultDTO<TbFeedbackInfo> getInfo() {
        return CommonResultDTO.success();
    }


}
