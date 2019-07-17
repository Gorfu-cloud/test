package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbTaskList;
import com.bkit.fatdown.entity.TbTaskRecord;
import com.bkit.fatdown.service.ITaskListService;
import com.bkit.fatdown.service.ITaskRecordService;
import com.bkit.fatdown.service.IUserBasicInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @file: TaskController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 每日任务控制类
 * @date: Created in 2019/7/12 13:59
 * @modified:
 * @version: 1.0
 */

@RestController
@RequestMapping("/task")
public class TaskController {

    @Resource
    ITaskListService taskListService;

    @Resource
    ITaskRecordService taskRecordService;

    @Resource
    IUserBasicInfoService basicInfoService;

    @ApiOperation("通过uid,获取今天任务")
    @CrossOrigin
    @RequestMapping(value = "/listTodayTask/{uid}", method = RequestMethod.GET)
    public CommonResultDTO listTodayTask(@PathVariable Integer uid) {
        if (uid == null || basicInfoService.countById(uid) == 0) {
            CommonResultDTO.validateFailed("uid为空或无效");
        }

        List<Integer> newTaskList = taskListService.listNewTask(uid);
        // 有新任务时,增加到用户任务记录中
        if (newTaskList.size() > 0) {
            TbTaskRecord taskRecord = new TbTaskRecord();
            for (Integer taskId : newTaskList) {
                taskRecord.setTaskId(taskId);
                taskRecord.setUserId(uid);
                taskRecordService.insert(taskRecord);
            }
        }

        List<TbTaskRecord> taskRecordList = taskRecordService.listTaskRecordByUid(uid);

        // 默认任务不为0
        if (taskRecordList.size() == 0) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(taskRecordList);
    }

    @ApiOperation("获取所有任务")
    @CrossOrigin
    @RequestMapping(value = "/listTask", method = RequestMethod.GET)
    public CommonResultDTO listTask() {
        List<TbTaskList> taskList = taskListService.listTask();

        if (taskList.size() == 0) {
            return CommonResultDTO.validateFailed("任务列表为空");
        }
        return CommonResultDTO.success(taskList);
    }

    @ApiOperation("获取对应的任务详情")
    @CrossOrigin
    @RequestMapping(value = "/getTask/{id}", method = RequestMethod.GET)
    public CommonResultDTO getTaskById(@PathVariable Integer id) {
        if (taskListService.countTaskById(id) == 0) {
            return CommonResultDTO.validateFailed("任务不存在");
        }
        return CommonResultDTO.success(taskListService.getTaskById(id));
    }

    @ApiOperation("添加任务")
    @CrossOrigin
    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public CommonResultDTO addTask(@RequestBody TbTaskList taskList) {
        if (taskList == null) {
            return CommonResultDTO.validateFailed("创建对象不能为空");
        }
        if (taskListService.insert(taskList)) {
            return CommonResultDTO.success();
        } else {
            return CommonResultDTO.failed();
        }

    }

    @ApiOperation("更新任务")
    @CrossOrigin
    @RequestMapping(value = "/updateTask", method = RequestMethod.POST)
    public CommonResultDTO updateTask(@RequestBody TbTaskList taskList) {
        if (taskList == null) {
            return CommonResultDTO.validateFailed("创建对象不能为空");
        }

        if (taskListService.update(taskList)) {
            return CommonResultDTO.success();
        } else {
            return CommonResultDTO.failed();
        }

    }

    @ApiOperation("删除任务")
    @CrossOrigin
    @RequestMapping(value = "/deleteTask", method = RequestMethod.DELETE)
    public CommonResultDTO deleteTask(@RequestBody Integer id) {
        if (taskListService.countTaskById(id) == 0) {
            return CommonResultDTO.validateFailed();
        }

        if (taskListService.delete(id)) {
            return CommonResultDTO.success();
        } else {
            return CommonResultDTO.failed();
        }
    }
}
