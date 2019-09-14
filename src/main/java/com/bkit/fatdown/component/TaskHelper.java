package com.bkit.fatdown.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * @file: TaskHelper
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 定时执行任务工具类
 * @date: Created in 9/11/19  1:29 PM
 * @modified:
 * @version: 1.0
 */
@Component
public class TaskHelper {

    private final static Logger LOGGER = LoggerFactory.getLogger("TaskHelper");


    /**
     * 秒 分 时 日 月 年
     */
    @Scheduled(cron = "0 0/10 * ? * ?")
    private void test() {
        LOGGER.info("10分钟测试执行");
    }

    /**
     * Cron Example patterns:
     * <li>"0 0 * * * *" = the top of every hour of every day.</li>
     * <li>"0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.</li>
     * <li>"0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30 and 10 o'clock every day.</li>
     * <li>"0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays</li>
     * <li>"0 0 0 25 12 ?" = every Christmas Day at midnight</li>
     */
    @Scheduled(cron = "0 0 14 * * *")
    private void test2() {
        LOGGER.info("每天14:00执行");
    }

    @Scheduled(cron = "0 0 14 * * MON")
    private void test3(){
        LOGGER.info("每周二 14:00执行");
    }

    @Scheduled(cron = "0 0 6 * * WED")
    private void test4(){
        LOGGER.info("每周三 14:00执行");
    }

    @Scheduled(cron = "0 0 14 * * WED")
    private void test5(){
        LOGGER.info("每周三 14:00执行");
    }

}
