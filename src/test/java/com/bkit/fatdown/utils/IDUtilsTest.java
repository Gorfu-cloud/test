package com.bkit.fatdown.utils;

import org.junit.Test;

import java.util.HashMap;

/**
 * @file: IDUtilsTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 8/31/19  5:33 PM
 * @modified:
 * @version: 1.0
 */

public class IDUtilsTest {

    @Test
    public void getImageDirName() {

        String foodName = "测试";

        HashMap<String,Double> map = new HashMap<>();

        map.put("a",11.0);
        map.put("b",10.0);
        map.put("c",12.0);

        System.out.println(IDUtils.getImageDirName(foodName,map));
    }
}