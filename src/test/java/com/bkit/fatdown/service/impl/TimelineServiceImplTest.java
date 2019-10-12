package com.bkit.fatdown.service.impl;

import cn.hutool.core.date.DateUtil;
import com.bkit.fatdown.common.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @file: TimelineServiceImplTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 10/12/19  10:27 PM
 * @modified:
 * @version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TimelineServiceImplTest {

    @Resource
    private TimelineServiceImpl timelineService;

    private Date date = DateUtils.getCurrentWeekStart(DateUtil.parseDate("2019-08-18"));
    private final static int uid = 65;

    @Test
    public void getWeeklyEnergyByType() {
        Date date = DateUtils.getCurrentWeekStart(DateUtil.parseDate("2019-08-18"));
//        int uid = 65;
//        int reportType = 0;
        System.out.println(DateUtil.dayOfMonth(date));
//        System.out.println(timelineService.getWeeklyEnergyByType(date, uid, reportType));
    }

    @Test
    public void getWeeklyEnergy() {
        System.out.println(timelineService.getWeeklyEnergy(uid, date));
    }

    @Test
    public void getWeeklyEnergyEvaluation() {

        System.out.println(timelineService.getWeeklyEnergyEvaluation(uid, date));
    }

    @Test
    public void getWeeklyStructureEvaluation() {
        System.out.println(timelineService.getWeeklyStructureEvaluation(uid, date));
    }
}