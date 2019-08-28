package com.bkit.fatdown.dto.food;

import java.io.Serializable;

/**
 * @file: ElementRelationDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 菜式组成元素成分
 * @date: Created in 2019/8/28 10:41
 * @modified:
 * @version: 1.0
 */
public class ElementRelationDTO implements Serializable {
    private Integer foodId;
    private Integer elementId;
    private Double gram;

    public ElementRelationDTO() {
    }

    public ElementRelationDTO(Integer foodId, Integer elementId, Double gram) {
        this.foodId = foodId;
        this.elementId = elementId;
        this.gram = gram;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getElementId() {
        return elementId;
    }

    public void setElementId(Integer elementId) {
        this.elementId = elementId;
    }

    public Double getGram() {
        return gram;
    }

    public void setGram(Double gram) {
        this.gram = gram;
    }
}
