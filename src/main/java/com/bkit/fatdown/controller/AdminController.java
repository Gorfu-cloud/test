package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonPageDTO;
import com.bkit.fatdown.dto.power.AdminLoginInfoDTO;
import com.bkit.fatdown.dto.power.AdminParam;
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
import java.security.Principal;
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
@CrossOrigin
public class AdminController {

    @Resource
    private IAdminService adminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    private static final String DEFAULT_PASSWORD = "123456";

    @ApiOperation(value = "用户注册")
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
    public CommonResultDTO login(@RequestBody AdminLoginInfoDTO loginInfoDTO) {
        String userName = loginInfoDTO.getUsername();
        String password = loginInfoDTO.getPassword();
        if (userName.isEmpty() || password.isEmpty()) {
            return CommonResultDTO.validateFailed();
        }

        String token = adminService.login(userName, password);
        if (token == null) {
            return CommonResultDTO.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>(3);
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResultDTO.success(tokenMap);
    }

    @ApiOperation("刷新Token")
    @RequestMapping(value = "/token/refresh", method = RequestMethod.GET)
    public CommonResultDTO refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = adminService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResultDTO.failed();
        }

        Map<String, String> tokenMap = new HashMap<>(2);
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResultDTO.success(tokenMap);
    }

    @ApiOperation("登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public CommonResultDTO logout() {
        return CommonResultDTO.success();
    }

    @ApiOperation("给用户分配角色")
    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    public CommonResultDTO updateRole(@RequestParam Integer adminId, @RequestParam List<Integer> roleIds) {
        int count = adminService.updateRole(adminId, roleIds);
        if (count >= 0) {
            return CommonResultDTO.success();
        }
        return CommonResultDTO.failed();
    }

    @ApiOperation("给一组用户分配角色")
    @RequestMapping(value = "/role/update/list", method = RequestMethod.POST)
    public CommonResultDTO updateRoleByList(@RequestParam List<Integer> adminIdList, @RequestParam List<Integer> roleIds) {
        int count = adminService.updateRole(adminIdList, roleIds);
        if (count >= 0) {
            return CommonResultDTO.success(count);
        }
        return CommonResultDTO.failed();
    }

    @ApiOperation("获取指定用户的角色")
    @RequestMapping(value = "/role/{adminId}", method = RequestMethod.GET)
    public CommonResultDTO<List<TbRole>> getRoleList(@PathVariable Integer adminId) {
        List<TbRole> roleList = adminService.getRoleList(adminId);
        return CommonResultDTO.success(roleList);
    }

    @ApiOperation("给用户分配+-权限")
    @RequestMapping(value = "/permission/update", method = RequestMethod.POST)
    public CommonResultDTO updatePermission(@RequestParam Integer adminId, @RequestParam("permissionIds") List<Integer> permissionIds) {
        int count = adminService.updatePermission(adminId, permissionIds);
        if (count > 0) {
            return CommonResultDTO.success(count);
        }
        return CommonResultDTO.failed();
    }

    @ApiOperation("获取用户所有权限（包括+ -权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    public CommonResultDTO<List<TbPermission>> getPermissionList(@PathVariable Integer adminId) {
        List<TbPermission> permissionList = adminService.getPermissionList(adminId);
        return CommonResultDTO.success(permissionList);
    }

    @ApiOperation("获取当前登陆用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public CommonResultDTO getAdminInfo(Principal principal) {
        if (principal == null) {
            return CommonResultDTO.validateFailed();
        }

        String userName = principal.getName();
        TbAdmin admin = adminService.getAdminByUsername(userName);

        Map<String, Object> data = new HashMap<>(3);

        data.put("userName", admin.getUserName());
        data.put("roles", adminService.getRoleList(admin.getId()));
        data.put("nickName", admin.getNickName());
        return CommonResultDTO.success(data);
    }

    @ApiOperation("更新管理员信息")
    @RequestMapping(value = "/info/{id}", method = RequestMethod.PUT)
    public CommonResultDTO updateAdminInfo(@PathVariable Integer id, @RequestBody AdminParam param) {
        if (adminService.count(id) == 0 || param == null) {
            return CommonResultDTO.validateFailed();
        }

        int count = adminService.update(id, param);

        if (count > 0) {
            return CommonResultDTO.success(count);
        }
        return CommonResultDTO.failed();
    }

    @ApiOperation("获取管理员信息")
    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public CommonResultDTO getAdminInfoById(@PathVariable Integer id) {
        if (adminService.count(id) == 0) {
            return CommonResultDTO.validateFailed();
        }

        TbAdmin admin = adminService.get(id);

        if (admin == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(admin);
    }

    @ApiOperation("删除管理员信息")
    @RequestMapping(value = "/info/{id}", method = RequestMethod.DELETE)
    public CommonResultDTO deleteAdminInfo(@PathVariable Integer id) {
        if (adminService.count(id) == 0) {
            return CommonResultDTO.validateFailed();
        }

        if (adminService.delete(id) > 0) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("修改密码")
    @RequestMapping(value = "/info/password/{adminId}", method = RequestMethod.PUT)
    public CommonResultDTO updatePassword(@PathVariable Integer adminId, @RequestParam String password) {
        if (adminService.count(adminId) == 0 || password.isEmpty()) {
            return CommonResultDTO.validateFailed();
        }

        if (adminService.updatePassword(adminId, password)) {
            return CommonResultDTO.success();
        }
        return CommonResultDTO.failed();
    }

    @ApiOperation("重置密码，默认123456")
    @RequestMapping(value = "/info/password/reset/{adminId}", method = RequestMethod.PUT)
    public CommonResultDTO resetPassword(@PathVariable Integer adminId) {
        if (adminId == null || adminService.count(adminId) == 0) {
            return CommonResultDTO.validateFailed();
        }
        if (adminService.updatePassword(adminId, DEFAULT_PASSWORD)) {
            return CommonResultDTO.success(DEFAULT_PASSWORD);
        }
        return CommonResultDTO.failed();
    }

    @ApiOperation("根据用户名或姓名分页获取用户列表")
    @RequestMapping(value = "/info/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public CommonResultDTO searchAdminInfo(@RequestParam(required = false) String name, @RequestParam Integer status,
                                           @PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        if (status > 1 || status < -1) {
            return CommonResultDTO.validateFailed();
        }

        List<TbAdmin> adminList = adminService.list(name, status, pageSize, pageNum);
        return CommonResultDTO.success(CommonPageDTO.restPage(adminList));
    }

    @ApiOperation("设置一组账号状态")
    @RequestMapping(value = "/info/status", method = RequestMethod.PUT)
    public CommonResultDTO updateStatus(@RequestParam List<Integer> adminIds, @RequestParam Integer status) {
        if (adminIds.isEmpty() || status > 1 || status < 0) {
            return CommonResultDTO.validateFailed();
        }

        int count = adminService.updateStatus(adminIds, status);

        if (count > 0) {
            return CommonResultDTO.success(count);
        }

        return CommonResultDTO.failed();
    }
}
