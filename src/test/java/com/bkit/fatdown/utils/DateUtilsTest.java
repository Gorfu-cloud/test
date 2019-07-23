package com.bkit.fatdown.utils;

import org.junit.Test;

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
}