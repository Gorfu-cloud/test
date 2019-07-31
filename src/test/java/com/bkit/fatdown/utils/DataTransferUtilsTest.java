package com.bkit.fatdown.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

/**
 * @file: DataTransferUtilsTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 7/31/19  3:53 PM
 * @modified:
 * @version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DataTransferUtilsTest {

    @Test
    public void str2Set() {
        Set<Integer> set = new TreeSet<>();
        assertEquals(set, DataTransferUtils.str2Set(set.toString()));
        set.add(1);
        assertEquals(set, DataTransferUtils.str2Set(set.toString()));
        set.add(2);
        assertEquals(set, DataTransferUtils.str2Set(set.toString()));
    }
}