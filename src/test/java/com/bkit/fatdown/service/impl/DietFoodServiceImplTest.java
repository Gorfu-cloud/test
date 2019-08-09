package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.dto.food.FoodInfoDTO;
import com.bkit.fatdown.entity.TbFoodRecord;
import com.bkit.fatdown.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        List<FoodInfoDTO> foodInfoDTOList = foodService.listFoodInfoDTO(uid, new Date(), 1);
        for (FoodInfoDTO foodInfoDTO : foodInfoDTOList) {
            System.out.println(foodInfoDTO.getFoodName() + " " + foodInfoDTO.getFoodGram());
        }
    }

    @Test
    public void listFoodBasic() {
        List<TbFoodRecord> list = foodService.listFoodBasic(uid, DateUtils.string2Date("2019-07-25"), 1);
        for (TbFoodRecord record : list) {
            System.out.println(record.getFoodId());
        }
    }
}