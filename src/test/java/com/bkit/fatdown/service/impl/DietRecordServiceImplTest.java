package com.bkit.fatdown.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @file: DietRecordServiceImplTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 8/11/19  4:13 PM
 * @modified:
 * @version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DietRecordServiceImplTest {

    @Resource
    private DietRecordServiceImpl recordService;

    @Test
    public void getDietRecordId() {
        System.out.println(recordService.getDietRecordId(new Date(), 60, 2));
    }
}