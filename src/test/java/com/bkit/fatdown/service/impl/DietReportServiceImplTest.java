package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @file: DietReportServiceImplTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 8/1/19  12:06 AM
 * @modified:
 * @version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DietReportServiceImplTest {

    @Resource
    private DietReportServiceImpl reportService;

    private static final String date = "2019-07-27";

    private static final Date inputDate = DateUtils.string2Date(date);

    private static final int uid = 60;

    @Test
    public void countDietMealReport() {
        System.out.println(reportService.countDietMealReport(inputDate, 0, uid));
        System.out.println(reportService.countDietMealReport(inputDate, 1, uid));
        System.out.println(reportService.countDietMealReport(inputDate, 2, uid));
    }

    @Test
    public void countDietMealReport1() {
    }

    @Test
    public void countDietMealReport2() {
    }

    @Test
    public void countDietMealReport3() {
    }
}