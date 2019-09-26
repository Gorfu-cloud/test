package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonPageDTO;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.dto.RedeemCodeDTO;
import com.bkit.fatdown.entity.TbRedeemCode;
import com.bkit.fatdown.service.IRedeemCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @file: CodeController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 随机码控制器
 * @date: Created in 2019/9/25 16:56
 * @modified:
 * @version: 1.0
 */
@Api(value = "/code", tags = "测试码信息模块")
@RestController
@RequestMapping("/code")
@CrossOrigin
public class CodeController {

    private final static Integer TEST_CODE_LENGTH = 6;

    @Resource
    private IRedeemCodeService codeService;

    @ApiOperation("校验测试码,并返回信息")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public CommonResultDTO checking(@RequestParam String code) {
        if (code == null || code.isEmpty() || code.length() != TEST_CODE_LENGTH) {
            return CommonResultDTO.validateFailed();
        }

        if (codeService.check(code)) {
            return CommonResultDTO.success(codeService.get(code).getInfo());
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("创建测试码")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public CommonResultDTO create(@RequestBody RedeemCodeDTO param) {
        if (param == null) {
            return CommonResultDTO.validateFailed();
        }

        if (codeService.insert(param)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("删除测试码")
    @RequestMapping(value = "/test/{id}", method = RequestMethod.DELETE)
    public CommonResultDTO delete(@PathVariable Long id) {
        if (id == null || !codeService.count(id)) {
            return CommonResultDTO.validateFailed();
        }

        if (codeService.delete(id)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("获取测试码信息")
    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    public CommonResultDTO get(@PathVariable Long id) {
        if (id == null || !codeService.count(id)) {
            return CommonResultDTO.validateFailed();
        }

        TbRedeemCode code = codeService.get(id);

        if (code == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(code);
    }

    @ApiOperation("搜索测试码")
    @RequestMapping(value = "/test/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public CommonResultDTO search(@PathVariable Integer pageNum, @PathVariable Integer pageSize,
            @RequestParam Integer status, @RequestParam(required = false) String keyword) {
        if (pageNum == null || pageSize == null || pageNum < 0 || pageSize < 0) {
            return CommonResultDTO.validateFailed();
        }

        return CommonResultDTO.success(CommonPageDTO.restPage(codeService.list(keyword,status, pageNum, pageSize)));
    }

    @ApiOperation("更新测试码")
    @RequestMapping(value = "/test/{id}", method = RequestMethod.PUT)
    public CommonResultDTO update(@PathVariable Long id, @RequestBody RedeemCodeDTO param) {
        if (param == null || !codeService.count(id)) {
            return CommonResultDTO.validateFailed();
        }

        if (codeService.update(id, param)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("批量修改测试码状态")
    @RequestMapping(value = "/test/status", method = RequestMethod.PUT)
    public CommonResultDTO updateStatusByList(@RequestParam List<Long> idList, @RequestParam Integer status) {
        if (status > 1 || status < 0 || idList == null) {
            return CommonResultDTO.validateFailed();
        }

        int count = codeService.updateStatus(idList, status);

        if (count>=0){
            return CommonResultDTO.success(count);
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("批量删除测试码")
    @RequestMapping(value = "/test/list", method = RequestMethod.DELETE)
    public CommonResultDTO deleteByList(@RequestParam List<Long> idList) {
        if (idList == null) {
            return CommonResultDTO.validateFailed();
        }

        int count = codeService.delete(idList);

        if (count>=0){
            return CommonResultDTO.success(count);
        }

        return CommonResultDTO.failed();
    }
}
