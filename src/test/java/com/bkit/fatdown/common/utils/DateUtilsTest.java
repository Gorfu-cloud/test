package com.bkit.fatdown.common.utils;

import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @file: DateUtilsTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 10/4/19  3:26 PM
 * @modified:
 * @version: 1.0
 */
public class DateUtilsTest {

//   private final static String strDate  ="2019-10-1 11:00:00";

    @Test
    public void test() {
        String strDate1 = "2019-10-1 4:2:24";
        String strDate2 = "2019-10-1 4:2:0";
        String strDate3 = "2019-10-11 4:2:4";
        String strDate4 = "2019-10-10 1:00:00";
        Date date = parseDateTime(strDate1);

        System.out.println(date);

        date = parseDateTime(strDate2);
        System.out.println(date);

        date = parseDateTime(strDate3);
        System.out.println(date);

        date = parseDateTime(strDate4);
        System.out.println(date);
    }

    public static Date parseDateTime(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        return formatter.parse(strDate, pos);
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

    @Test
    public void getDaysOfMonth() {
        System.out.println(DateUtils.getDaysOfMonth(DateUtil.parse("2019-02-01")));
        System.out.println(DateUtils.getDaysOfMonth(DateUtil.parse("2000-02-01")));
        System.out.println(DateUtils.getDaysOfMonth(DateUtil.parse("2012-02-01")));
        System.out.println(DateUtils.getDaysOfMonth(DateUtil.parse("2016-02-01")));
        System.out.println(DateUtils.getDaysOfMonth(DateUtil.parse("2020-02-27")));
    }
}