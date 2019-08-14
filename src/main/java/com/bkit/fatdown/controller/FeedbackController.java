package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbFeedbackInfo;
import com.bkit.fatdown.service.IFeedbackInfoService;
import com.bkit.fatdown.service.IFeedbackReplyService;
import com.bkit.fatdown.service.IFeedbackTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation("查看用户反馈列表")
    @CrossOrigin
    @RequestMapping(value = "/info/{uid}", method = RequestMethod.GET)
    public CommonResultDTO<List<TbFeedbackInfo>> listInfoByUid(@RequestParam Integer uid) {
        if (infoService.countByUid(uid) == 0) {
            return CommonResultDTO.validateFailed();
        }

        List<TbFeedbackInfo> infoList = infoService.listFeedbackInfo(uid);

        if (infoList == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(infoList);
    }


    @ApiOperation("查看用户反馈详情")
    @CrossOrigin
    @RequestMapping(value = "/info/details/{infoId}", method = RequestMethod.GET)
    public CommonResultDTO<TbFeedbackInfo> getInfo(@PathVariable Integer infoId) {
        if (infoId == null) {
            return CommonResultDTO.validateFailed();
        }

        if (infoService.countById(infoId) == 0) {
            return CommonResultDTO.validateFailed();
        }

        TbFeedbackInfo info = infoService.getFeedbackInfo(infoId);

        if (info == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(info);
    }

}
