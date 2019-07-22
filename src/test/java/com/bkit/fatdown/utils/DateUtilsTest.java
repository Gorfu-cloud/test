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

    @Test
    public void getCurrentWeekStart() {
        System.out.println(DateUtils.getCurrentWeekStart(new Date()));
    }

    @Test
    public void getCurrentWeekEnd() {
        System.out.println(DateUtils.getCurrentWeekEnd(new Date()));
    }
}