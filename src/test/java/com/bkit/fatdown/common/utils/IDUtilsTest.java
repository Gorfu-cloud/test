package com.bkit.fatdown.common.utils;

import org.junit.Test;

import java.util.HashMap;

public class IDUtilsTest {

    @Test
    public void getImageDirName() {
        HashMap<String, Double> map = new HashMap<>();
        map.put("皮蛋", 100.0);
        map.put("瘦肉", 50.1);
        map.put("大米", 50.3);
        System.out.println(IDUtils.getImageDirName("皮蛋瘦肉粥", map));
    }
}