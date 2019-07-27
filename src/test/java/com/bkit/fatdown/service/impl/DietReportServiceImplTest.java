package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbDietReport;
import com.bkit.fatdown.service.IDietReportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @file: DietReportServiceImplTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 7/27/19  3:33 PM
 * @modified:
 * @version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DietReportServiceImplTest {

    @Resource
    private IDietReportService reportService;

    @Test
    public void insert() {
        TbDietReport report = new TbDietReport();
        report.setUserId(60);
        assertTrue(reportService.insert(report));
    }

    @Test
    public void update() {
    }

    @Test
    public void countReport() {
    }

    @Test
    public void getDietReport() {
    }

    @Test
    public void countReportByTypeList() {
    }

    @Test
    public void generateDietReport() {
    }

    @Test
    public void listDietReport() {
    }
}