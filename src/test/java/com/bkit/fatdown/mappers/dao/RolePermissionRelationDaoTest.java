package com.bkit.fatdown.mappers.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @file: RolePermissionRelationDaoTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 9/13/19  2:49 PM
 * @modified:
 * @version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RolePermissionRelationDaoTest {

    private final Integer roleId =1;

    @Resource
    private RolePermissionRelationDao rolePermissionRelationDao;

    @Test
    public void insertList() {
    }

    @Test
    public void getPermissionList() {
        System.out.println(rolePermissionRelationDao.getPermissionList(roleId));
    }
}