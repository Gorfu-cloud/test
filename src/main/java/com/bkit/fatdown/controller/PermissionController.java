package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonPageDTO;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.dto.power.PermissionNode;
import com.bkit.fatdown.dto.power.PermissionParam;
import com.bkit.fatdown.entity.TbPermission;
import com.bkit.fatdown.service.IAdminPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @file: PermissionController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 权限管理模块
 * @date: Created in 2019/10/5 17:09
 * @modified:
 * @version: 1.0
 */
@Api(value = "/permission", tags = "权限管理模块")
@CrossOrigin
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Resource
    private IAdminPermissionService permissionService;

    @ApiOperation("添加权限")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResultDTO create(@RequestBody PermissionParam permission) {
        int count = permissionService.insert(permission);
        if (count > 0) {
            return CommonResultDTO.success(count);
        }
        return CommonResultDTO.failed();
    }

    @ApiOperation("修改权限")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public CommonResultDTO update(@PathVariable Integer id, @RequestBody PermissionParam permission) {
        int count = permissionService.update(id, permission);
        if (count > 0) {
            return CommonResultDTO.success(count);
        }
        return CommonResultDTO.failed();
    }

    @ApiOperation("搜索权限")
    @RequestMapping(value = "/search/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public CommonResultDTO listByPage(@RequestParam(required = false) String keyWord, @PathVariable Integer pageNum, @PathVariable Integer pageSize, @RequestParam Integer status, @RequestParam Integer type) {
        if (pageNum == null || pageSize == null || status > 2 || status < -1 || type > 3 || type < -1) {
            return CommonResultDTO.validateFailed();
        }

        List<TbPermission> list = permissionService.list(keyWord, type, status, pageNum, pageSize);

        return CommonResultDTO.success(CommonPageDTO.restPage(list));
    }

    @ApiOperation("根据id批量删除权限")
    @RequestMapping(value = "/list", method = RequestMethod.DELETE)
    public CommonResultDTO delete(@RequestParam("ids") List<Integer> ids) {
        int count = permissionService.delete(ids);
        if (count > 0) {
            return CommonResultDTO.success(count);
        }
        return CommonResultDTO.failed();
    }

    @ApiOperation("以层级结构返回所有权限")
    @RequestMapping(value = "/treeList", method = RequestMethod.GET)
    public CommonResultDTO<List<PermissionNode>> treeList() {
        List<PermissionNode> permissionNodeList = permissionService.treeList();
        return CommonResultDTO.success(permissionNodeList);
    }

    @ApiOperation("获取所有权限列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResultDTO<List<TbPermission>> list() {
        List<TbPermission> permissionList = permissionService.list();
        return CommonResultDTO.success(permissionList);
    }

    @ApiOperation("获取父权限列表")
    @RequestMapping(value = "/list/{type}", method = RequestMethod.GET)
    public CommonResultDTO<List<TbPermission>> listByType(@PathVariable Integer type) {
        if (type < 1 || type > 3) {
            return CommonResultDTO.validateFailed();
        }
        List<TbPermission> permissionList = permissionService.list(type);
        return CommonResultDTO.success(permissionList);
    }
}
