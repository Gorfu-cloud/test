package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.AdminLoginInfoDTO;
import com.bkit.fatdown.dto.AdminParam;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbAdmin;
import com.bkit.fatdown.entity.TbPermission;
import com.bkit.fatdown.entity.TbRole;
import com.bkit.fatdown.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    @ApiOperation(value = "用户注册")
    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResultDTO<TbAdmin> register(@RequestBody AdminParam adminParam) {
        TbAdmin admin = adminService.register(adminParam);
        if (admin == null) {
            CommonResultDTO.failed();
        }
        return CommonResultDTO.success(admin);
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @CrossOrigin
    public CommonResultDTO login(@RequestBody AdminLoginInfoDTO adminInfo) {
        String token = adminService.login(adminInfo.getUserName(), adminInfo.getPassword());
        if (token == null) {
            return CommonResultDTO.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>(3);
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResultDTO.success(tokenMap);
    }

    @ApiOperation("刷新Token")
    @RequestMapping(value = "/token/refresh",method = RequestMethod.GET)
    @CrossOrigin
    public CommonResultDTO refreshToken(HttpServletRequest request){
        String token = request.getHeader(tokenHeader);
        String refreshToken = adminService.refreshToken(token);
        if (refreshToken ==null){
            return CommonResultDTO.failed();
        }

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResultDTO.success(tokenMap);
    }

    @ApiOperation("登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @CrossOrigin
    public CommonResultDTO logout() {
        return CommonResultDTO.success();
    }

    @ApiOperation("获取指定用户的角色")
    @RequestMapping(value = "/role/{adminId}", method = RequestMethod.GET)
    @CrossOrigin
    public CommonResultDTO<List<TbRole>> getRoleList(@PathVariable Integer adminId) {
        List<TbRole> roleList = adminService.getRoleList(adminId);
        return CommonResultDTO.success(roleList);
    }

    @ApiOperation("给用户分配+-权限")
    @RequestMapping(value = "/permission/update", method = RequestMethod.POST)
    @CrossOrigin
    public CommonResultDTO updatePermission(@RequestParam Integer adminId,
                                                                @RequestParam("permissionIds") List<Integer> permissionIds) {
        int count = adminService.updatePermission(adminId, permissionIds);
        if (count > 0) {
            return CommonResultDTO.success(count);
        }
        return CommonResultDTO.failed();
    }

    @ApiOperation("获取用户所有权限（包括+ -权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    @CrossOrigin
    public CommonResultDTO<List<TbPermission>> getPermissionList(@PathVariable Integer adminId) {
        List<TbPermission> permissionList = adminService.getPermissionList(adminId);
        return CommonResultDTO.success(permissionList);
    }
}
