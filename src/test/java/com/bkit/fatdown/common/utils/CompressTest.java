package com.bkit.fatdown.common.utils;

import org.junit.Test;

/**
 * @file: CompressTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 压缩测试
 * @date: Created in 10/15/19  6:20 PM
 * @modified:
 * @version: 1.0
 */

public class CompressTest {

    @Test
    public void compressTest() {
        Integer[] arr = new Integer[10];
        arr[1] = 1;
        arr[2] = 0;

        arr[3] = 1;
        arr[4] = 2;

        arr[7] = 1;
        arr[6] = 1;

        System.out.println(compress(arr));
    }

    public static Integer[] compress(Integer[] input) {
        int size = input.length / 3;
        Integer[] num = new Integer[size];
        Integer[] arr;

        for (int i = 0; i < size; i++) {
            arr = new Integer[3];
            arr[0] = input[i];
            arr[1] = input[i + 1];
            arr[2] = input[i + 2];
            num[i] = getMeanValue(arr);
        }

        return num;
    }


    /**
     * 获取均值
     *
     * @param num 数据
     * @return 均值
     */
    public static Integer getMeanValue(Integer[] num) {
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
     * 将每三个数据整合为一个数据
     *
     * @param input 输入数据
     * @return 整合后数据
     */
    public static Double[] compress(Double[] input) {
        int size = input.length / 3;
        Double[] num = new Double[size];
        Double[] arr;

        for (int i = 0; i < size; i++) {
            arr = new Double[3];
            arr[0] = input[i];
            arr[1] = input[i + 1];
            arr[2] = input[i + 2];
            num[i] = getMeanValue(arr);
        }

        return num;
    }


    /**
     * 获取均值
     *
     * @param num 数据
     * @return 均值
     */
    public static Double getMeanValue(Double[] num) {
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
