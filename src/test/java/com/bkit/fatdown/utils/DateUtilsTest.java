package com.bkit.fatdown.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @file: DateUtilsTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 7/22/19  3:26 PM
 * @modified:
 * @version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DateUtilsTest {

//    @Test
//    public void getCurrentWeekStart() {
//        System.out.println(DateUtils.getCurrentWeekStart(new Date()));
//    }
//
//    @Test
//    public void getCurrentWeekEnd() {
//        System.out.println(DateUtils.getCurrentWeekEnd(new Date()));
//    }

    @Test
    public void getBreakfastStartTime() {
        System.out.println("1" + DateUtils.getBreakfastStartTime(new Date()));
    }

    @Test
    public void getBreakfastEndTime() {
        System.out.println("2" + DateUtils.getBreakfastEndTime(new Date()));
    }

    @Test
    public void getLunchStartTime() {
        System.out.println("3" + DateUtils.getLunchStartTime(new Date()));
    }

    @Test
    public void getLunchEndTime() {
        System.out.println("4" + DateUtils.getLunchEndTime(new Date()));
    }

    @Test
    public void getDinnerStartTime() {
        System.out.println("5" + DateUtils.getDinnerStartTime(new Date()));
    }

    @Test
    public void getDinnerEndTime() {
        System.out.println("6" + DateUtils.getDinnerEndTime(new Date()));
    }

    @Test
    public void string2Date() {
        System.out.println(DateUtils.string2Date("2019-07-23"));
    }

    @Test
    public void getMonthStartDate() {
        Date date = DateUtils.string2Date("2019-01-12");
        System.out.println(date);
        System.out.println(DateUtils.getMonthStartDate(date));

        date = DateUtils.string2Date("2019-02-28");
        System.out.println(date);
        System.out.println(DateUtils.getMonthStartDate(date));

        date = DateUtils.string2Date("2019-12-30");
        System.out.println(date);
        System.out.println(DateUtils.getMonthStartDate(date));
    }

    @Test
    public void getNextMonthStartDate() {
        Date date = DateUtils.string2Date("2019-01-12");
        System.out.println(date);
        System.out.println(DateUtils.getNextMonthStartDate(date));

        date = DateUtils.string2Date("2019-02-28 19:00:01");
        System.out.println(date);
        System.out.println(DateUtils.getNextMonthStartDate(date));

        date = DateUtils.string2Date("2019-02-29 19:0:1");
        System.out.println(date);
        System.out.println(DateUtils.getNextMonthStartDate(date));

        date = DateUtils.string2Date("2019-12-01");
        System.out.println(date);
        System.out.println(DateUtils.getNextMonthStartDate(date));
    }

    @Test
    public void getMealType() {
        System.out.println(DateUtils.getMealType(new Date()));
    }

}