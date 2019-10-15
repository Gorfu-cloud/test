package com.bkit.fatdown.common.utils;

/**
 * @file: MathUtils
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 数据整合工具类
 * @date: Created in 10/15/19  10:56 PM
 * @modified:
 * @version: 1.0
 */

public class MathUtils {

    /**
     * 将每三个数据整合为一个数据
     *
     * @param input 输入数据
     * @return 整合后数据
     */
    public static Integer[] compress(Integer[] input) {
        int size = input.length / 3;
        Integer[] num = new Integer[size];
        Integer[] arr = new Integer[3];

        // 这里将三个点合并为一个
        for (int i = 0, j = 0; i < size; i++) {
            arr[0] = input[j];
            arr[1] = input[j + 1];
            arr[2] = input[j + 2];

            // 结果
            num[i] = getMeanValue(arr);

            // 原来的三个点
            j += 3;
        }

        return num;
    }

    /**
     * 将每三个数据整合为一个数据
     *
     * @param input 输入数据
     * @return 整合后数据
     */
    public static Double[] compress(Double[] input) {
        int size = input.length / 3;
        Double[] num = new Double[size];
        Double[] arr = new Double[3];

        // 这里将三个点合并为一个
        for (int i = 0, j = 0; i < size; i++) {
            arr[0] = input[j];
            arr[1] = input[j + 1];
            arr[2] = input[j + 2];

            // 结果
            num[i] = getMeanValue(arr);

            // 原来的三个点
            j += 3;
        }

        return num;
    }

    /**
     * 获取均值
     *
     * @param num 数据
     * @return 均值
     */
    private static Integer getMeanValue(Integer[] num) {
        // 有效数据长度
        int count = 0;
        // 总数
        int total = 0;

        for (Integer integer : num) {
            // 当输入值不为空
            if (integer != null) {
                count++;
                total += integer;
            }
        }

        return count == 0 ? null : total / count;
    }

    /**
     * 获取均值
     *
     * @param num 数据
     * @return 均值
     */
    private static Double getMeanValue(Double[] num) {
        // 有效数据长度
        double count = 0;
        // 总数
        double total = 0;

        for (Double value : num) {
            // 当输入值不为空
            if (value != null) {
                count++;
                total += value;
            }
        }

        return count == 0 ? null : total / count;
    }
}
