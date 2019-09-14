package com.bkit.fatdown.mappers.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @file: AdminRoleRelationDaoTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 9/13/19  2:42 PM
 * @modified:
 * @version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminRoleRelationDaoTest {
    @Resource
    AdminRoleRelationDao roleRelationDao;

    private final Integer adminId =4;

    @Test
    public void insertList() {

    }

    @Test
    public void getRoleList() {
        System.out.println(roleRelationDao.getRoleList(adminId));
    }

    @Test
    public void getRolePermissionList() {
        System.out.println(roleRelationDao.getPermissionList(adminId));
    }

    @Test
    public void getPermissionList() {
        System.out.println(roleRelationDao.getRolePermissionList(adminId));
    }
}