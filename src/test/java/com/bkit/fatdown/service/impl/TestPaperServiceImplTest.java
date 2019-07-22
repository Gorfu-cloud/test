package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbPaperBasic;
import com.bkit.fatdown.service.ITestPaperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @file: TestPaperServiceImplTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 7/22/19  3:08 PM
 * @modified:
 * @version: 1.0
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestPaperServiceImplTest {

    @Resource
    private ITestPaperService service;

    @Test
    public void listPaperCurrentWeek() {
        List<TbPaperBasic> list = service.listPaperCurrentWeek(new Date());
        for (TbPaperBasic paperBasic : list) {
            System.out.println(paperBasic.toString());
        }
    }

    @Test
    public void listPaperBeforeWeek() {
        List<TbPaperBasic> list = service.listPaperBeforeWeek(new Date());
        for (TbPaperBasic paperBasic : list) {
            System.out.println(paperBasic.toString());
        }
    }
}