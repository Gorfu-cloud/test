package com.bkit.fatdown.dto.food;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * @file: FoodRecordInfoDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 食物信息封装类
 * @date: Created in 7/25/19  9:11 PM
 * @modified:
 * @version: 1.0
 */
public class FoodRecordInfoDTO implements Serializable {
    private Integer id;
    private String foodName;
    private Double foodGram;
    private Double eatPer;

    public FoodRecordInfoDTO() {
    }

    public FoodRecordInfoDTO(Integer id, String foodName, Double foodGram, Double eatPer) {
        this.id = id;
        this.foodName = foodName;
        this.foodGram = foodGram;
        this.eatPer = eatPer;
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

    public Double getEatPer() {
        return eatPer;
    }

    public void setEatPer(Double eatPer) {
        this.eatPer = eatPer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FoodRecordInfoDTO{" +
                "id=" + id +
                ", foodName='" + foodName + '\'' +
                ", foodGram=" + foodGram +
                ", eatPer=" + eatPer +
                '}';
    }
}
