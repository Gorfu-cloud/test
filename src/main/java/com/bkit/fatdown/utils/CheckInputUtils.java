package com.bkit.fatdown.utils;

/**
 * @file: CheckInputUtils
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: //TODO
 * @date: Created in 7/12/19  9:32 PM
 * @modified:
 * @version: 1.0
 */

public class CheckInputUtils {

    /**
     * 检查输入是否为空
     *
     * @param input
     * @return
     */
    public static boolean checkNull(String input) {
        boolean result = true;
        if (input == null || input.length() == 0) {
            result = false;
        }
        return result;
    }

    /**
     * 检查输入是否数字
     *
     * @param input
     * @return
     */
    public static boolean checkNull(Double input) {
        return Double.isNaN(input);
    }

}
