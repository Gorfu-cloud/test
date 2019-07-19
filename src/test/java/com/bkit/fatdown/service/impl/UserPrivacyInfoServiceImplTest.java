package com.bkit.fatdown.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @file: UserPrivacyInfoServiceImplTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 7/19/19  2:31 PM
 * @modified:
 * @version: 1.0
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserPrivacyInfoServiceImplTest {

    @Resource
    UserPrivacyInfoServiceImpl service;

    @Test
    public void countByUidAndDate() {
        int uid = 44;
        Date today = new Date();
        System.out.println(service.countByUidAndDate(uid,today));
    }
}