package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.service.IPictureService;
import com.bkit.fatdown.common.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.HashMap;

/**
 * @file: PictureServiceImplTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 7/23/19  2:42 PM
 * @modified:
 * @version: 1.0
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class PictureServiceImplTest {

    @Resource
    IPictureService pictureService;

    @Test
    public void listBetweenTime() {
        System.out.println(pictureService.listBetweenTime(4, DateUtils.getBreakfastStartTime(new Date()),
                DateUtils.getBreakfastEndTime(new Date())).get(0).getUrl());
    }

    @Test
    public void listByDate() {
        HashMap<String, Object> map = pictureService.listByDate(4, new Date());
        System.out.println(map.get("breakfast"));
        System.out.println(map.get("lunch"));
        System.out.println(map.get("dinner"));
    }
}