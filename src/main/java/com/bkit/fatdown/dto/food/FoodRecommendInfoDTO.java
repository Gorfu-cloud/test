package com.bkit.fatdown.dto.food;

import java.io.Serializable;

/**
 * @file: FoodRecommendInfoDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 食物推荐信息封装类
 * @date: Created in 8/9/19  11:09 AM
 * @modified:
 * @version: 1.0
 */
public class FoodRecommendInfoDTO implements Serializable {
    private Integer id;
    private String foodName;
    private Integer foodType;

    public FoodRecommendInfoDTO() {
    }

    public FoodRecommendInfoDTO(Integer id, String foodName, Integer foodType) {
        this.id = id;
        this.foodName = foodName;
        this.foodType = foodType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getFoodType() {
        return foodType;
    }

    public void setFoodType(Integer foodType) {
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return "FoodRecommendInfoDTO{" +
                "id=" + id +
                ", foodName='" + foodName + '\'' +
                ", foodType=" + foodType +
                '}';
    }
}
