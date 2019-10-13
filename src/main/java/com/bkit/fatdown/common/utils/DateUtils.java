package com.bkit.fatdown.common.utils;

import java.text.DateFormat;
import java.text.ParsePosition;
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
     * 返回本月第一天
     *
     * @param now
     * @return
     */
    public static Date getMonthStartDate(Date now) {
        int month = now.getMonth();
        Calendar no = Calendar.getInstance();
        no.setTime(now);
        no.set(Calendar.DAY_OF_MONTH, 1);
        no.set(Calendar.MONTH, month);
        return no.getTime();
    }

    /**
     * 返回下一个月第一天
     *
     * @param now
     * @return
     */
    public static Date getNextMonthStartDate(Date now) {
        int month = now.getMonth() + 1;
        Calendar no = Calendar.getInstance();
        no.setTime(now);
        no.set(Calendar.DAY_OF_MONTH, 1);
        no.set(Calendar.MONTH, month);
        return no.getTime();
    }

    /**
     * 获取本周, 开始日期
     *
     * @param now 本周日期
     * @return 周日 00:00:00
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
     * @param now 本周日期
     * @return 周日 23:59:59
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
     * 获取本月有多少天
     * @param date 本月日期
     * @return 天数
     */
    public static int getDaysOfMonth(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

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

    /**
     * 字符串转日期类型
     *
     * @param strDate
     * @return
     */
    public static Date string2Date(String strDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(strDate, new ParsePosition(0));
    }

    public static Date string2DateTime(String strDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.parse(strDate, new ParsePosition(0));
    }

    /**
     * 获取早餐开始时间
     *
     * @param now
     * @return
     */
    public static Date getBreakfastStartTime(Date now) {
        return getDateStart(now);
    }

    /**
     * 获取早餐 结束时间
     *
     * @param now
     * @return
     */
    public static Date getBreakfastEndTime(Date now) {
        Calendar no = Calendar.getInstance();
        no.setTime(now);
        no.set(Calendar.HOUR_OF_DAY, 9);
        no.set(Calendar.MINUTE, 59);
        no.set(Calendar.SECOND, 59);
        return no.getTime();
    }

    /**
     * 获取午餐 开始时间
     *
     * @param now
     * @return
     */
    public static Date getLunchStartTime(Date now) {
        Calendar no = Calendar.getInstance();
        no.setTime(now);
        // 10点开始算午餐
        no.set(Calendar.HOUR_OF_DAY, 10);
        no.set(Calendar.MINUTE, 0);
        no.set(Calendar.SECOND, 0);
        return no.getTime();
    }

    /**
     * 获取午餐 结束时间
     *
     * @param now
     * @return
     */
    public static Date getLunchEndTime(Date now) {
        Calendar no = Calendar.getInstance();
        no.setTime(now);
        // 14:59:59点结束
        no.set(Calendar.HOUR_OF_DAY, 14);
        no.set(Calendar.MINUTE, 59);
        no.set(Calendar.SECOND, 59);
        return no.getTime();
    }

    /**
     * 获取晚餐 开始时间
     *
     * @param now
     * @return
     */
    public static Date getDinnerStartTime(Date now) {
        Calendar no = Calendar.getInstance();
        no.setTime(now);
        // 15点开始算午餐
        no.set(Calendar.HOUR_OF_DAY, 15);
        no.set(Calendar.MINUTE, 0);
        no.set(Calendar.SECOND, 0);
        return no.getTime();
    }

    /**
     * 获取晚餐 结束时间
     *
     * @param now
     * @return
     */
    public static Date getDinnerEndTime(Date now) {
        return getDateEnd(now);
    }

    /**
     * 对比俩个日期，如果大于等于比较日期时间，返回true
     *
     * @param object
     * @param target
     * @return
     */
    public static Boolean isLargerTime(Date object, Date target) {
        return object.getTime() > target.getTime();
    }

    public static int getMealType(Date now) {
        if (isLargerTime(getBreakfastEndTime(now), now)) {
            return 0;
        } else if (isLargerTime(getLunchEndTime(now), now)) {
            return 1;
        } else {
            return 2;
        }
    }
}