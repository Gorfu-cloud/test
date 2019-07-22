package com.bkit.fatdown.utils;

import java.util.Random;

/**
 * @file: IDUtils
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 生成图片名ID 实例 1562376638673034
 * @date: Created in 7/22/19  8:55 PM
 * @modified:
 * @version: 1.0
 */

public class IDUtils {

    /**
     * @description: 生成图片名ID
     * @params:
     * @return:
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 7/22/19
     */

    public static String getImageName() {

        // 取当前时间的长整型值包含毫秒
        long millis = System.currentTimeMillis();

        // 加上三位随机数
        Random random = new Random();
        int end3 = random.nextInt(999);

        // 如果不足三位随机数前面补0
        return millis + String.format("%03d", end3);
    }
}
