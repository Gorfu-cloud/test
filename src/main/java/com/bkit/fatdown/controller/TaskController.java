package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbTaskList;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("获取今天任务")
    @CrossOrigin
    @RequestMapping(value = "/listTodayTask", method = RequestMethod.GET)
    public CommonResultDTO listTodayTask(@RequestBody Integer uid) {
        return CommonResultDTO.failed();
    }

    @ApiOperation("获取所有任务")
    @CrossOrigin
    @RequestMapping(value = "/listTask", method = RequestMethod.GET)
    public CommonResultDTO listTask() {
        return CommonResultDTO.failed();
    }

    @ApiOperation("获取对应的任务详情")
    @CrossOrigin
    @RequestMapping(value = "/getTask/{id}", method = RequestMethod.GET)
    public CommonResultDTO getTaskById(@PathVariable Integer id) {
        return CommonResultDTO.failed();
    }

    @ApiOperation("添加任务")
    @CrossOrigin
    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public CommonResultDTO addTask(@RequestBody TbTaskList taskList) {
        return CommonResultDTO.failed();
    }

    @ApiOperation("更新任务")
    @CrossOrigin
    @RequestMapping(value = "/updateTask", method = RequestMethod.POST)
    public CommonResultDTO updateTask(@RequestBody TbTaskList taskList) {
        return CommonResultDTO.failed();
    }

    @ApiOperation("删除任务")
    @CrossOrigin
    @RequestMapping(value = "/deleteTask", method = RequestMethod.DELETE)
    public CommonResultDTO deleteTask(@RequestBody Integer id) {
        return CommonResultDTO.failed();
    }

}
