package com.bkit.fatdown.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskRecordServiceImplTest {

    @Resource
    private TaskRecordServiceImpl recordService;

    @Test
    public void listRecordId() {
        int uid = 40;
        for (Integer record : recordService.listRecordId(uid)) {
            System.out.println(record + " ");
        }
    }
}