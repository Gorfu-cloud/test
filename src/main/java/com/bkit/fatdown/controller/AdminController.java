package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.AdminLoginInfoDTO;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbAdmin;
import com.bkit.fatdown.entity.TbPermission;
import com.bkit.fatdown.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    private static final Integer OPEN_STATUS = 1;

//    @ApiOperation("管理员登陆校验")
//    @CrossOrigin
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public CommonResultDTO login(@RequestParam String userName, @RequestParam String password) {
//        if (userName.isEmpty() || password.isEmpty()) {
//            return CommonResultDTO.validateFailed();
//        }
//
//        if (adminService.count(userName, password, OPEN_STATUS) == 0) {
//            return CommonResultDTO.failed();
//        }
//        return CommonResultDTO.success();
//    }

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResultDTO<TbAdmin> register(@RequestBody TbAdmin adminParam, BindingResult result) {
        TbAdmin admin = adminService.register(adminParam);
        if (admin == null) {
            CommonResultDTO.failed();
        }
        return CommonResultDTO.success(admin);
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResultDTO login(@RequestBody AdminLoginInfoDTO adminInfo, BindingResult result) {
        String token = adminService.login(adminInfo.getUserName(), adminInfo.getPassword());
        if (token == null) {
            return CommonResultDTO.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>(3);
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResultDTO.success(tokenMap);
    }

    @ApiOperation("获取用户所有权限（包括+ -权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResultDTO<List<TbPermission>> getPermissionList(@PathVariable Integer adminId) {
        List<TbPermission> permissionList = adminService.getPermissionList(adminId);
        return CommonResultDTO.success(permissionList);
    }
}