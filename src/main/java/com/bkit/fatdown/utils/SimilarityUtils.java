package com.bkit.fatdown.utils;


/**
 * @FileName: SimilarityUtils
 * @Author: YuJian
 * @Description: 相似度对比工具
 * @Date: Created in 7/6/19  10:35 AM
 * @Modified:
 * @Version: 1.0.0
 */

public class SimilarityUtils {

    public static void main(String[] args) {
        double p = Levenshtein("", "");
        System.out.println(p);
    }


    /**
     * @Description: 计算俩个字符串相似度
     * @Param: str1, str2
     * @return: float
     * @Author: YuJian
     * @date: 7/6/19
     */

    public static float Levenshtein(String str1, String str2) {
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        // 计算两个字符串的长度。
        int len1 = char1.length;
        int len2 = char2.length;
        // 建二维数组，比字符长度大一个空间
        int[][] dif = new int[len1 + 1][len2 + 1];
        // 赋初值
        for (int a = 0; a <= len1; a++) {
            dif[a][0] = a;
        }
        for (int a = 0; a <= len2; a++) {
            dif[0][a] = a;
        }
        // 计算两个字符是否一样，计算左上的值
        int temp;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (char1[i - 1] == char2[j - 1]) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                //取三个值中最小的
                dif[i][j] = Min(dif[i - 1][j - 1] + temp, dif[i][j - 1] + 1, dif[i - 1][j] + 1);
            }
        }

        // 计算相似度
        return 1 - (float) dif[len1][len2] / Math.max(len1, len2);
    }

    /// <summary>
    /// 求最小值
    /// </summary>
    /// <param name="nums"></param>
    /// <returns></returns>
    //TODO

    /**
     * @Description: 获取输入的最小值
     * @Param: ...nums
     * @return: int
     * @Author: YuJian
     * @date: 7/6/19
     */

    private static int Min(int... nums) {
        int min = Integer.MAX_VALUE;
        for (int item : nums) {
            if (min > item) {
                min = item;
            }
        }
        return min;
    }
}
