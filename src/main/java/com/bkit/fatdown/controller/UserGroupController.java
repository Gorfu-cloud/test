package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonPageDTO;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.dto.group.GroupParam;
import com.bkit.fatdown.entity.TbUserGroup;
import com.bkit.fatdown.service.IAdminService;
import com.bkit.fatdown.service.IUserBasicInfoService;
import com.bkit.fatdown.service.IUserGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @file: GroupController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 分组管理模块
 * @date: Created in 10/12/19  2:12 PM
 * @modified:
 * @version: 1.0
 */

@Api(value = "/user/group", tags = "分组管理控制器")
@RestController
@RequestMapping("/user/group")
@CrossOrigin
public class UserGroupController {

    @Resource
    private IUserGroupService groupService;

    @Resource
    private IAdminService adminService;

    @Resource
    private IUserBasicInfoService infoService;

    @ApiOperation("添加分组")
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public CommonResultDTO create(@RequestBody GroupParam param) {

        if (groupService.insert(param)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("删除分组")
    @RequestMapping(value = "/{groupId}", method = RequestMethod.DELETE)
    public CommonResultDTO delete(@PathVariable Integer groupId) {
        if (groupService.count(groupId) == 0) {
            return CommonResultDTO.validateFailed();
        }

        if (groupService.delete(groupId)) {
            // 删除,同时修改原有成员分组
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("编辑分组")
    @RequestMapping(value = "/{groupId}", method = RequestMethod.PUT)
    public CommonResultDTO update(@PathVariable Integer groupId, @RequestBody GroupParam param) {
        if (groupService.count(groupId) == 0) {
            return CommonResultDTO.validateFailed();
        }

        if (groupService.update(groupId, param)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("获取分组信息")
    @RequestMapping(value = "/{groupId}", method = RequestMethod.GET)
    public CommonResultDTO get(@PathVariable Integer groupId) {
        if (groupService.count(groupId) == 0) {
            return CommonResultDTO.validateFailed();
        }

        TbUserGroup group = groupService.get(groupId);

        if (group == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(group);
    }

    @ApiOperation("分页: 查找分组信息")
    @RequestMapping(value = "/list/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public CommonResultDTO search(@PathVariable Integer pageNum, @PathVariable Integer pageSize,
                                  @RequestParam(required = false) String keyWord) {
        return CommonResultDTO.success(CommonPageDTO.restPage(groupService.list(keyWord, pageNum, pageSize)));
    }

    @ApiOperation("设置状态")
    @RequestMapping(value = "/list/status", method = RequestMethod.PUT)
    public CommonResultDTO updateStatus(@RequestParam Integer status, @RequestParam List<Integer> list) {
        if (list.size() == 0 || status > 1 || status < -1) {
            return CommonResultDTO.validateFailed();
        }

        return CommonResultDTO.success(groupService.updateStatus(status, list));
    }

    @ApiOperation("设置管理员")
    @RequestMapping(value = "/list/admin", method = RequestMethod.PUT)
    public CommonResultDTO updateAdmin(@RequestParam Integer adminId, @RequestParam List<Integer> list) {
        if (list.size() == 0 || adminService.count(adminId) == 0) {
            return CommonResultDTO.validateFailed();
        }

        return CommonResultDTO.success(groupService.updateAdmin(adminId, list));
    }

    @ApiOperation("查看分组(成员)")
    @RequestMapping(value = "/list/user/{groupId}", method = RequestMethod.GET)
    public CommonResultDTO listGroup(@PathVariable Integer groupId, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        if (groupService.count(groupId) == 0) {
            return CommonResultDTO.validateFailed();
        }
        return CommonResultDTO.success(CommonPageDTO.restPage(infoService.listByUserGroup(groupId, pageSize, pageNum)));
    }
}
