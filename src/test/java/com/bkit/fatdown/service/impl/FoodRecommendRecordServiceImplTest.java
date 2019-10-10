package com.bkit.fatdown.service.impl;

import cn.hutool.core.date.DateUtil;
import com.bkit.fatdown.dto.food.RecommendListDTO;
import com.bkit.fatdown.service.IFoodRecommendRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FoodRecommendRecordServiceImplTest {

    @Resource
    private IFoodRecommendRecordService service;

    @Test
    public void getWeeklyRecommend() {
        Date date = DateUtil.parseDate("2019-08-15");
        int uid = 65;
        System.out.println(service.getWeeklyRecommend(date,uid));
    }
}