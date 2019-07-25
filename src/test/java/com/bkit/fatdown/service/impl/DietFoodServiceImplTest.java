package com.bkit.fatdown.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @file: DietFoodServiceImplTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 7/25/19  3:52 PM
 * @modified:
 * @version: 1.0
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class DietFoodServiceImplTest {

    @Resource
    private DietFoodServiceImpl foodService;

    private static final int uid = 54;

    @Test
    public void updateDietStandardByUid() {
        assertTrue(foodService.updateDietStandardByUid(uid));
    }

    @Test
    public void getDietStandard() {
        System.out.println(foodService.getDietStandard(uid).toString());
    }
}