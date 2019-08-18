package com.bkit.fatdown.service;

import org.assertj.core.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @file: IDietFoodServiceTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 8/18/19  1:49 PM
 * @modified:
 * @version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class IDietFoodServiceTest {

    @Resource
    private IDietFoodService foodService;

    @Test
    public void testFoodIdList() {
        System.out.println(DateUtil.parse("2019-08-18 08:00:00"));
        System.out.println(foodService.listFoodRecord(60, DateUtil.parse("2019-08-18 08:00:00"), 0));
    }
}