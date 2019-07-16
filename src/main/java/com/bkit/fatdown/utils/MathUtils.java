package com.bkit.fatdown.utils;

/**
 * @file: MathUtils
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 公式计算工具类
 * @date: Created in 2019/7/16 14:38
 * @modified:
 * @version: 1.0
 */

public class MathUtils {

    /**
     * BMI=体重（千克）/（身高（米）*身高（米））
     *
     * @param height
     * @param weight
     * @return
     */
    public static double getBMI(int height, double weight) {
        double bmi = weight / Math.pow((height / 100.0), 2);
        return bmi;
    }
}
