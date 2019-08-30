package com.bkit.fatdown.controller.feedback;

import com.bkit.fatdown.dto.CommonPageDTO;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.dto.feedback.FeedbackInfoDTO;
import com.bkit.fatdown.entity.TbFeedbackInfo;
import com.bkit.fatdown.entity.TbFeedbackReply;
import com.bkit.fatdown.entity.TbFeedbackType;
import com.bkit.fatdown.service.IFeedbackInfoService;
import com.bkit.fatdown.service.IFeedbackReplyService;
import com.bkit.fatdown.service.IFeedbackTypeService;
import com.bkit.fatdown.service.IUserBasicInfoService;
import com.bkit.fatdown.utils.DataTransferUtils;
import com.bkit.fatdown.utils.DateUtils;
import com.bkit.fatdown.utils.FtpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.*;

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

    @Resource
    private IUserBasicInfoService basicInfoService;

    private static final int DATA_NOT_EXIST = 0;

    private static final String EVALUATION_STR = "evaluation";
    private static final String TYPE_NAME_STR = "typeName";
    private static final String STATUS_STR = "status";

    private static final Logger logger = LoggerFactory.getLogger(FeedbackController.class);

    @ApiOperation("添加用户反馈信息图片")
    @CrossOrigin
    @RequestMapping(value = "/info/{uid}/{infoId}", method = RequestMethod.POST)
    public CommonResultDTO addInfoPicture(@PathVariable Integer uid, @PathVariable Integer infoId, @RequestParam MultipartFile file) {
        if (basicInfoService.countById(uid) == DATA_NOT_EXIST || infoService.countById(infoId) == DATA_NOT_EXIST || file == null) {
            return CommonResultDTO.validateFailed();
        }

        TbFeedbackInfo info = new TbFeedbackInfo();

        Set<String> urlSet = DataTransferUtils.string2Set(infoService.getFeedbackInfo(infoId).getImgUrlSet());

        Date now = new Date();
        Map<String, String> result;

        // 上传图片结果：imgUrl，flag（true/false）
        result = FtpUtils.uploadPicture(file, uid, now);

        // 上传失败
        if ("false".equals(result.get("flag"))) {
            logger.error("upload picture fail, uid:{} and infoId:{} and file: {}", uid, infoId, file.getOriginalFilename());
            return CommonResultDTO.failed();
        }

        if ("true".equals(result.get("flag"))) {
            urlSet.add(result.get("imgUrl"));
            logger.info("upload picture success, uid:{} and infoId:{} and file: {} and imgUrl: {}", uid, infoId, file.getOriginalFilename(), result.get("imgUrl"));
        }

        info.setId(infoId);
        info.setImgUrlSet(urlSet.toString());

        if (infoService.update(info)) {
            return CommonResultDTO.success();
        }
        return CommonResultDTO.failed();
    }

    @ApiOperation("添加用户反馈信息,返回infoId")
    @CrossOrigin
    @RequestMapping(value = "/info/{uid}", method = RequestMethod.POST)
    public CommonResultDTO addInfo(@PathVariable Integer uid, @RequestBody HashMap<String, String> map) {
        if (!map.containsKey("typeId") || !map.containsKey("content")) {
            return CommonResultDTO.validateFailed();
        }

        Integer typeId = Integer.valueOf(map.get("typeId"));
        String content = map.get("content");

        if (basicInfoService.countById(uid) == DATA_NOT_EXIST || typeService.count(typeId) == DATA_NOT_EXIST || content.isEmpty()) {
            return CommonResultDTO.validateFailed();
        }

        TbFeedbackInfo info = new TbFeedbackInfo();
        info.setTypeId(typeId);
        info.setUserId(uid);
        info.setContent(content);
        info.setImgUrlSet("");

        if (infoService.insert(info)) {
            int id = infoService.getInfoId(typeId, uid, content);
            return CommonResultDTO.success(id);
        }
        return CommonResultDTO.failed();
    }

    @ApiOperation("删除用户反馈信息")
    @CrossOrigin
    @RequestMapping(value = "/info/{infoId}", method = RequestMethod.DELETE)
    public CommonResultDTO deleteInfo(@PathVariable Integer infoId) {
        if (infoId == null || infoService.countById(infoId) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed();
        }

        if (infoService.delete(infoId)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("用户查看反馈列表")
    @CrossOrigin
    @RequestMapping(value = "/info/{uid}", method = RequestMethod.GET)
    public CommonResultDTO<List<FeedbackInfoDTO>> listInfoByUid(@PathVariable Integer uid) {
        if (infoService.countByUid(uid) == 0) {
            return CommonResultDTO.validateFailed();
        }

        List<TbFeedbackInfo> infoList = infoService.listFeedbackInfo(uid);

        if (infoList == null) {
            return CommonResultDTO.failed();
        }

        List<FeedbackInfoDTO> dtos = new ArrayList<>();

        for (TbFeedbackInfo info : infoList) {
            dtos.add(transferFeedbackInfo(info));
        }

        return CommonResultDTO.success(dtos);
    }

    @ApiOperation("查看用户反馈详情")
    @CrossOrigin
    @RequestMapping(value = "/infos/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public CommonResultDTO listInfoByPage(@PathVariable Integer pageNum, @PathVariable Integer pageSize, @RequestParam(required = false) Integer uid,
                                          @RequestParam Integer typeId, @RequestParam Integer status) {
        if (pageNum == null || pageSize == null || typeId == null || status == null) {
            return CommonResultDTO.validateFailed();
        }

        List<TbFeedbackInfo> list = infoService.listFeedbackInfoByPage(uid, typeId, status, pageNum, pageSize);

        return CommonResultDTO.success(CommonPageDTO.restPage(list));
    }

    @ApiOperation("更新用户反馈详情状态")
    @CrossOrigin
    @RequestMapping(value = "/info/details/{infoId}/{status}", method = RequestMethod.PUT)
    public CommonResultDTO<FeedbackInfoDTO> updateInfoStatus(@PathVariable Integer infoId, @PathVariable Integer status) {
        if (infoId == null || infoService.countById(infoId) == 0 || status == null) {
            return CommonResultDTO.validateFailed();
        }

        TbFeedbackInfo info = new TbFeedbackInfo();
        info.setId(infoId);
        info.setStatus(status);

        if (infoService.update(info)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }


    @ApiOperation("查看用户反馈详情")
    @CrossOrigin
    @RequestMapping(value = "/info/details/{infoId}", method = RequestMethod.GET)
    public CommonResultDTO<FeedbackInfoDTO> getInfo(@PathVariable Integer infoId) {
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

        return CommonResultDTO.success(transferFeedbackInfo(info));
    }

    @ApiOperation("添加反馈回复信息")
    @CrossOrigin
    @RequestMapping(value = "/reply/{infoId}", method = RequestMethod.POST)
    public CommonResultDTO addReply(@PathVariable Integer infoId, @RequestParam String content, @RequestParam String adminName) {
        if (infoService.countById(infoId) == DATA_NOT_EXIST || content.isEmpty()) {
            return CommonResultDTO.validateFailed();
        }

        TbFeedbackReply reply = new TbFeedbackReply();
        reply.setInfoId(infoId);
        reply.setContent(content);
        reply.setAdminName(adminName);

        if (replyService.insert(reply)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("删除反馈回复信息")
    @CrossOrigin
    @RequestMapping(value = "/reply/{replyId}", method = RequestMethod.DELETE)
    public CommonResultDTO deleteReply(@PathVariable Integer replyId) {
        if (replyService.count(replyId) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed();
        }

        if (replyService.delete(replyId)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("更新反馈回复信息内容（map中填写，content")
    @CrossOrigin
    @RequestMapping(value = "/reply/content/{replyId}", method = RequestMethod.PUT)
    public CommonResultDTO updateReplyContent(@PathVariable Integer replyId, @RequestBody HashMap<String, String> map) {
        if (!map.containsKey("content") || replyService.count(replyId) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed();
        }

        String content = map.get("content");

        TbFeedbackReply reply = new TbFeedbackReply();
        reply.setId(replyId);
        reply.setContent(content);

        if (replyService.update(reply)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("更新反馈回复信息评价（map中填写，evaluation: 0，未评价，1有帮助，2没帮助")
    @CrossOrigin
    @RequestMapping(value = "/reply/evaluation/{replyId}", method = RequestMethod.PUT)
    public CommonResultDTO updateReply(@PathVariable Integer replyId, @RequestBody HashMap<String, Integer> map) {
        if (!map.containsKey(EVALUATION_STR) || replyService.count(replyId) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed();
        }

        int evaluation = map.get(EVALUATION_STR);

        if (evaluation > 2 || evaluation < 0) {
            return CommonResultDTO.validateFailed();
        }

        TbFeedbackReply reply = new TbFeedbackReply();
        reply.setId(replyId);
        reply.setHelpful(evaluation);

        if (replyService.update(reply)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("分页,获取反馈回复信息")
    @CrossOrigin
    @RequestMapping(value = "/replys/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public CommonResultDTO listReplyByPage(@PathVariable Integer pageNum, @PathVariable Integer pageSize,
                                           @RequestParam(required = false) String adminName, @RequestParam(required = false) String startTime,
                                           @RequestParam(required = false) String endTime) {
        if (pageNum == null || pageSize == null) {
            return CommonResultDTO.validateFailed();
        }

        if (startTime == null || endTime == null) {
            return CommonResultDTO.success(CommonPageDTO.restPage(replyService.list(adminName, pageNum, pageSize)));
        }

        List<TbFeedbackReply> list = replyService.list(adminName, DateUtils.string2Date(startTime),
                DateUtils.string2Date(endTime), pageNum, pageSize);

        return CommonResultDTO.success(CommonPageDTO.restPage(list));
    }

    @ApiOperation("获取反馈回复信息，通过replyId")
    @CrossOrigin
    @RequestMapping(value = "/reply/{replyId}", method = RequestMethod.GET)
    public CommonResultDTO<TbFeedbackReply> getReplyById(@PathVariable Integer replyId) {
        if (replyService.count(replyId) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed();
        }

        TbFeedbackReply reply = replyService.get(replyId);

        if (reply == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(reply);
    }

    @ApiOperation("获取反馈回复信息，通过infoId")
    @CrossOrigin
    @RequestMapping(value = "/reply/user/{infoId}", method = RequestMethod.GET)
    public CommonResultDTO<TbFeedbackReply> getReplyByUid(@PathVariable Integer infoId) {
        if (replyService.countByInfoId(infoId) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed();
        }

        TbFeedbackReply reply = replyService.getByInfoId(infoId);

        if (reply == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(reply);
    }

    @ApiOperation("添加反馈类型")
    @CrossOrigin
    @RequestMapping(value = "/type", method = RequestMethod.POST)
    public CommonResultDTO addReplyType(@RequestParam String typeName, @RequestParam Integer status) {
        // 添加类型名称不存在
        if (typeService.count(typeName) != DATA_NOT_EXIST || status < 0 || status > 1 || typeName.isEmpty()) {
            return CommonResultDTO.validateFailed();
        }

        TbFeedbackType type = new TbFeedbackType();
        type.setStatus(status);
        type.setTypeName(typeName);

        if (typeService.insert(type)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("更新反馈类型,typeName, status")
    @CrossOrigin
    @RequestMapping(value = "/type/{typeId}", method = RequestMethod.PUT)
    public CommonResultDTO updateReplyType(@PathVariable Integer typeId, @RequestBody HashMap<String, String> map) {
        if (!map.containsKey(TYPE_NAME_STR) || !map.containsKey(STATUS_STR)) {
            return CommonResultDTO.validateFailed();
        }
        String typeName = map.get(TYPE_NAME_STR);
        Integer status = Integer.valueOf(map.get(STATUS_STR));

        if (typeService.count(typeName) != DATA_NOT_EXIST || status < 0 || status > 1 || typeName.isEmpty()
                || typeService.count(typeId) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed();
        }

        TbFeedbackType type = new TbFeedbackType();
        type.setId(typeId);
        type.setStatus(status);
        type.setTypeName(typeName);

        if (typeService.update(type)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("删除反馈类型")
    @CrossOrigin
    @RequestMapping(value = "/type/{typeId}", method = RequestMethod.DELETE)
    public CommonResultDTO deleteReplyType(@PathVariable Integer typeId) {
        if (typeId == null || typeService.count(typeId) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed();
        }

        if (typeService.delete(typeId)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("获取反馈类型信息")
    @CrossOrigin
    @RequestMapping(value = "/type/{typeId}", method = RequestMethod.GET)
    public CommonResultDTO<TbFeedbackType> getReplyType(@PathVariable Integer typeId) {
        if (typeId == null || typeService.count(typeId) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed();
        }

        TbFeedbackType type = typeService.get(typeId);

        if (type == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(type);
    }


    @ApiOperation("获取所有反馈类型")
    @CrossOrigin
    @RequestMapping(value = "/types", method = RequestMethod.GET)
    public CommonResultDTO<List<TbFeedbackType>> listReplyType() {

        List<TbFeedbackType> typeList = typeService.list();

        if (typeList == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(typeList);
    }

    @ApiOperation("分页: 查找反馈类型")
    @CrossOrigin
    @RequestMapping(value = "/types/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public CommonResultDTO listReplyTypeByPage(@PathVariable Integer pageNum, @PathVariable Integer pageSize,
                                               @RequestParam(required = false) String typeName, @RequestParam Integer status) {

        if (pageNum == null || pageSize == null || status == null) {
            return CommonResultDTO.validateFailed();
        }

        List<TbFeedbackType> typeList = typeService.listByPage(typeName, status, pageNum, pageSize);

        if (typeList == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(CommonPageDTO.restPage(typeList));
    }

    @ApiOperation("获取反馈类型（已编辑）")
    @CrossOrigin
    @RequestMapping(value = "/types/open", method = RequestMethod.GET)
    public CommonResultDTO<List<TbFeedbackType>> listReplyTypeOpen() {

        int openStatus = 1;

        List<TbFeedbackType> typeList = typeService.list(openStatus);

        if (typeList == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(typeList);
    }

    /**
     * @param info 反馈信息
     * @return 封装后信息
     */
    private FeedbackInfoDTO transferFeedbackInfo(TbFeedbackInfo info) {
        FeedbackInfoDTO infoDTO = new FeedbackInfoDTO(info);
        String typeName = typeService.get(info.getTypeId()).getTypeName();
        infoDTO.setTypeName(typeName);

        return infoDTO;
    }
}
