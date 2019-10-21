package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.service.IUserLoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @file: LogController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 日志模块
 * @date: Created in 2019/10/21 21:05
 * @modified:
 * @version: 1.0
 */
@Api("日志模块")
@RestController
@CrossOrigin
@RequestMapping("/log")
public class LogController {

    @Resource
    private IUserLoginLogService userLoginLogService;

    @ApiOperation("用户日志删除")
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public CommonResultDTO deleteUserLoginLog(@PathVariable Long id){

        if (userLoginLogService.count(id)==0){
            return CommonResultDTO.validateFailed();
        }

        if (userLoginLogService.delete(id)){
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

}
