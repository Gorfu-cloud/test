package com.bkit.fatdown.dto.diet;

import io.swagger.annotations.ApiModel;

/**
 * @file: FoodInfoDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 食物信息封装类
 * @date: Created in 7/25/19  9:11 PM
 * @modified:
 * @version: 1.0
 */

@ApiModel
public class FoodInfoDTO {
    private String foodName;
    private Double foodGram;

    public FoodInfoDTO() {
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getFoodGram() {
        return foodGram;
    }

    public void setFoodGram(Double foodGram) {
        this.foodGram = foodGram;
    }
}
