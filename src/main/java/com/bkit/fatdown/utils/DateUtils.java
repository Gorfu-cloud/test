package com.bkit.fatdown.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @file: DateUtils
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 日期工具类，日期转化
 * @date: Created in 7/22/19  2:25 PM
 * @modified:
 * @version: 1.0
 */

public class DateUtils {
    /**
     * 获取七周前的日期
     *
     * @param now
     * @return
     */
    public static Date getSevenWeekAgo(Date now) {
        Calendar no = Calendar.getInstance();
        no.setTime(now);
        // 获取七周（-7×6=42天前）前日期
        no.set(Calendar.DATE, no.get(Calendar.DATE) - 42);
        no.set(Calendar.HOUR_OF_DAY, 0);
        no.set(Calendar.MINUTE, 0);
        no.set(Calendar.SECOND, 0);
        return no.getTime();
    }

    /**
     * 获取本周, 开始日期
     *
     * @param now
     * @return
     */
    public static Date getCurrentWeekStart(Date now) {
        Calendar no = Calendar.getInstance();
        no.setTime(now);
        no.setFirstDayOfWeek(Calendar.SUNDAY);
        no.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        no.set(Calendar.HOUR_OF_DAY, 0);
        no.set(Calendar.MINUTE, 0);
        no.set(Calendar.SECOND, 0);
        return no.getTime();
    }

    /**
     * 获取本周, 结束日期
     *
     * @param now
     * @return
     */
    public static Date getCurrentWeekEnd(Date now) {
        Calendar no = Calendar.getInstance();
        no.setTime(now);
        no.setFirstDayOfWeek(Calendar.SUNDAY);
        no.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        no.set(Calendar.HOUR_OF_DAY, 23);
        no.set(Calendar.MINUTE, 59);
        no.set(Calendar.SECOND, 59);
        return no.getTime();
    }

    /**
     * 获取明天日期时间
     *
     * @return
     */
    @Deprecated
    public static Map<String, Date> getNextDate() {
        Date date = new Date();
        Date standard = null;
        Date date1 = null;
        Date date2 = null;
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            // 第二天五点开始才算。
            standard = df2.parse(df1.format(date) + " 05:00:00");
            if (date.getTime() > standard.getTime()) {
                Calendar cld = Calendar.getInstance();
                cld.setTime(standard);
                cld.add(Calendar.DATE, 1);
                date2 = cld.getTime();
                date1 = standard;
            } else {
                Calendar cld = Calendar.getInstance();
                cld.setTime(standard);
                cld.add(Calendar.DATE, 1);
                date1 = cld.getTime();
                date2 = standard;
            }
        } catch (Exception e) {
            System.out.println("时间转换出错");
        }
        Map<String, Date> result = new HashMap<>();
        result.put("date1", date1);
        result.put("date2", date2);
        return result;
    }

    /**
     * 返回昨天的日期
     *
     * @param date
     * @return
     */
    public static Date getYesterday(Date date) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.add(Calendar.DATE, -1);
        return cld.getTime();
    }

    /**
     * 获取明天的日期
     *
     * @param date
     * @return
     */
    public static Date getTomorrow(Date date) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.add(Calendar.DATE, 1);
        return cld.getTime();
    }

    /**
     * 获取七天后的日期
     *
     * @param date
     * @return
     */
    public static Date getNextSevenDate(Date date) {
        Date next = null;
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.add(Calendar.DATE, 7);
        next = cld.getTime();
        return next;
    }

    /**
     * 获取今天开始时间
     *
     * @param nowDate
     * @return
     */
    public static Date getDateStart(Date nowDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取今天结束时间
     *
     * @param nowDate
     * @return
     */
    public static Date getDateEnd(Date nowDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }
}
