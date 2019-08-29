package com.bkit.fatdown.dto.food;

import java.io.Serializable;
import java.util.Date;

/**
 * @file: FoodBasicDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 菜式信息
 * @date: Created in 2019/8/28 17:04
 * @modified:
 * @version: 1.0
 */

public class FoodBasicDTO implements Serializable {

    private String foodName;

    private String type;

    private Integer flag;

    private Double quantity;

    private static final long serialVersionUID = 1L;

    public FoodBasicDTO() {
    }

    public FoodBasicDTO(String foodName, String type, Integer flag, Double quantity) {
        this.foodName = foodName;
        this.type = type;
        this.flag = flag;
        this.quantity = quantity;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
