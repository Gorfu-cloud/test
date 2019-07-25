package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.dto.FoodInfoDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @file: DietFoodServiceImplTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 7/25/19  3:52 PM
 * @modified:
 * @version: 1.0
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class DietFoodServiceImplTest {

    @Resource
    private DietFoodServiceImpl foodService;

    private static final int uid = 54;

    @Test
    public void updateDietStandardByUid() {
        assertTrue(foodService.updateDietStandardByUid(uid));
    }

    @Test
    public void getDietStandard() {
        System.out.println(foodService.getDietStandard(uid).toString());
    }

    @Test
    public void listFoodRecord() {
        List<FoodInfoDTO> foodInfoDTOList = foodService.listFoodRecord(uid, new Date(), 1);
        for (FoodInfoDTO foodInfoDTO : foodInfoDTOList) {
            System.out.println(foodInfoDTO.getFoodName() + " " + foodInfoDTO.getFoodGram());
        }
    }
}