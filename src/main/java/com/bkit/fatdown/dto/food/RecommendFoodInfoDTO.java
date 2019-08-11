package com.bkit.fatdown.dto.food;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @file: RecommendFoodInfoDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 食物推荐类型食物信息
 * @date: Created in 8/11/19  9:06 PM
 * @modified:
 * @version: 1.0
 */
@ApiModel
public class RecommendFoodInfoDTO implements Serializable {
    @ApiModelProperty(value = "食物推荐ID")
    private Integer id;
    @ApiModelProperty(value = "食物推荐名称")
    private String foodName;
    @ApiModelProperty(value = "食物推荐类型ID")
    private Integer foodType;

    public RecommendFoodInfoDTO() {
    }

    public RecommendFoodInfoDTO(Integer id, String foodName, Integer foodType) {
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
        return "RecommendFoodInfoDTO{" +
                "id=" + id +
                ", foodName='" + foodName + '\'' +
                ", foodType=" + foodType +
                '}';
    }
}
