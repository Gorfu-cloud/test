package com.bkit.fatdown.dto.diet;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @file: FoodRecordDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 饮食记录DTO
 * @date: Created in 9/20/19  2:38 PM
 * @modified:
 * @version: 1.0
 */
@ApiModel("饮食记录参数")
public class FoodRecordDTO implements Serializable {
    @ApiModelProperty("菜式ID")
    private Integer foodId;
    @ApiModelProperty("食用量：100为基准")
    private Double eatPer;
    @ApiModelProperty("菜式重量： g")
    private Double foodQuantity;
    @ApiModelProperty("评价状态： 0 未评价， 1 已评价")
    private Integer status;

    public FoodRecordDTO() {
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Double getEatPer() {
        return eatPer;
    }

    public void setEatPer(Double eatPer) {
        this.eatPer = eatPer;
    }

    public Double getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(Double foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FoodRecordDTO{" +
                "foodId=" + foodId +
                ", eatPer=" + eatPer +
                ", foodQuantity=" + foodQuantity +
                ", status=" + status +
                '}';
    }
}
