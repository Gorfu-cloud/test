package com.bkit.fatdown.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @file: AdminServiceImplTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 9/17/19  7:24 PM
 * @modified:
 * @version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminServiceImplTest {

    @Resource
    private AdminServiceImpl adminService;

    @Test
    public void getPermissionList() {
        System.out.println(adminService.getPermissionList(7));
    }
}