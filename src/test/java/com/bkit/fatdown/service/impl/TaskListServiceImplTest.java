package com.bkit.fatdown.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListServiceImplTest {

    @Resource
    private TaskListServiceImpl taskListService;

    @Test
    public void listNewTask() {
        int uid = 30;
        for (int i : taskListService.listNewTask(uid)) {
            System.out.println(i + " ");
        }
    }
}