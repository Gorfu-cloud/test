package com.bkit.fatdown.service;

import com.bkit.fatdown.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @file: IDietReportServiceTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 7/29/19  9:47 PM
 * @modified:
 * @version: 1.0
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class IDietReportServiceTest {

    @Resource
    private IDietReportService reportService;

    private Date date = DateUtils.string2Date("2019-07-29");

    @Test
    public void countReport() {
        Date date = DateUtils.string2Date("2019-07-29");
        System.out.println(reportService.countReport(date, 1, 1));
    }

    @Test
    public void countReportByDay() {
        System.out.println(reportService.countReportByDay(date, 1));
    }
}