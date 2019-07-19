package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbUserLifeStyle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @file: UserLifeStyleServiceImplTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 7/19/19  2:57 PM
 * @modified:
 * @version: 1.0
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserLifeStyleServiceImplTest {

    @Resource
    UserLifeStyleServiceImpl lifeStyleService;

    @Test
    public void update() {
        TbUserLifeStyle lifeStyle = new TbUserLifeStyle();
        lifeStyle.setUserId(46);
        lifeStyle.setUserType(3);
        lifeStyle.setDietaryHabit(3.0);
        lifeStyle.setFoodTaste(3);
        lifeStyle.setLabourIntensity(3);
        lifeStyle.setSpicyDegree(3);
        assertTrue(lifeStyleService.update(lifeStyle));
    }

    @Test
    public void countByUidAndCreateDate() {
        int uid = 46;
        Date today = new Date();
        System.out.println(lifeStyleService.countByUidAndCreateDate(uid,today));
    }
}