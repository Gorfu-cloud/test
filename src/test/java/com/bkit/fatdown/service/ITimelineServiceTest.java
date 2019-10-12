package com.bkit.fatdown.service;

import cn.hutool.core.date.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ITimelineServiceTest {

    @Resource
    private ITimelineService service;

    private int uid = 59;
//    private int uid = 88;
    private String  dateStr = "2019-08-05";
    private Date date = DateUtil.parseDate(dateStr);

    @Test
    public void getDailyEnergy() {
        System.out.println(Arrays.asList(service.getDailyEnergy(uid, date)));
    }

    @Test
    public void getDailyEnergyEvaluation() {
        for (double value:service.getDailyEnergyEvaluation(uid,date)){
            System.out.println(value);
        }
        System.out.println(service.getDailyEnergyEvaluation(uid,date).toString());
    }

    @Test
    public void getWeeklyEnergy() {
        System.out.println(service.getWeeklyEnergy(uid,date));
    }

    @Test
    public void getWeeklyEnergyEvaluation() {
        System.out.println(service.getWeeklyEnergyEvaluation(uid,date));
    }
}