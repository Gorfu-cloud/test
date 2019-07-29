package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.service.IFoodBasicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @file: FoodBasicServiceImplTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 7/29/19  9:15 PM
 * @modified:
 * @version: 1.0
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class FoodBasicServiceImplTest {

    @Resource
    private IFoodBasicService foodBasicService;

    @Test
    public void countFoodBasic() {
        System.out.println(foodBasicService.countFoodBasic(1561));
    }
}