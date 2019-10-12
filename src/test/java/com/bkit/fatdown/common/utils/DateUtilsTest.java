package com.bkit.fatdown.common.utils;

import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @file: DateUtilsTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 10/4/19  3:26 PM
 * @modified:
 * @version: 1.0
 */
public class DateUtilsTest {

   private final static String strDate  ="2019-10-1 11:00:00";

    @Test
    public void test(){
        String strDate  ="2019-10-1 11:00:00";
        System.out.println(DateUtil.parse(strDate));
        System.out.println(DateUtil.parse("2019-10-01"));
        System.out.println(DateUtil.parseDateTime(strDate));
    }

    @Test
    public void getYesterday() {
        System.out.println(DateUtils.getYesterday(new Date()));
        System.out.println(new Date());
        System.out.println(DateUtils.getTomorrow(new Date()));
    }

    @Test
    public void getTomorrow() {
    }
}