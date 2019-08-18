package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @file: AdminController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 管理员控制器
 * @date: Created in 8/17/19  3:03 PM
 * @modified:
 * @version: 1.0
 */
@Api(value = "/admin", tags = "管理相关模块")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private IAdminService adminService;

    private static final Integer OPEN_STATUS = 1;

    @ApiOperation("管理员登陆校验")
    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public CommonResultDTO login(@RequestParam String userName, @RequestParam String password) {
        if (userName.isEmpty() || password.isEmpty()) {
            return CommonResultDTO.validateFailed();
        }

        if (adminService.count(userName, password, OPEN_STATUS) == 0) {
            return CommonResultDTO.failed();
        }
        return CommonResultDTO.success();
    }

//    public CommonResultDTO addAdmin()
}
