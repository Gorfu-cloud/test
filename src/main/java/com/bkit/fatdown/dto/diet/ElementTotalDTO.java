package com.bkit.fatdown.dto.diet;

import java.util.Set;
import java.util.TreeSet;

/**
 * @file: ElementTotalDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 菜式组成成分，元素总量统计类
 * @date: Created in 7/29/19  5:09 PM
 * @modified:
 * @version: 1.0
 */

public class ElementTotalDTO {
    /**
     * 是否存在该菜式拆解:0存在，1不存在，默认存在
     */
    private Integer flag;
    /**
     * 能量
     */
    private Double energy;
    /**
     * 脂肪
     */
    private Double fat;
    /**
     * 蛋白质
     */
    private Double protein;
    /**
     * 碳水化合物
     */
    private Double cho;
    /**
     * 膳食纤维
     */
    private Double fiber;
    /**
     * 饮食结构
     */
    private Set<Integer> structType;

    public ElementTotalDTO() {
        init();
    }

    public ElementTotalDTO(Integer flag, Double energy, Double fat, Double protein, Double cho, Double fiber,
                           Set<Integer> structType) {
        init();
        this.flag = flag;
        this.energy = energy;
        this.fat = fat;
        this.protein = protein;
        this.cho = cho;
        this.fiber = fiber;
        this.structType = structType;
    }

    public ElementTotalDTO(Double energy, Double fat, Double protein, Double cho, Double fiber, Set<Integer> structType) {
        init();
        this.energy = energy;
        this.fat = fat;
        this.protein = protein;
        this.cho = cho;
        this.fiber = fiber;
        this.structType = structType;
    }

    /**
     * 初始化
     */
    private void init() {
        this.flag = 0;
        this.energy = 0.0;
        this.fat = 0.0;
        this.protein = 0.0;
        this.cho = 0.0;
        this.fiber = 0.0;
        this.structType = new TreeSet<>();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getCho() {
        return cho;
    }

    public void setCho(Double cho) {
        this.cho = cho;
    }

    public Double getFiber() {
        return fiber;
    }

    public void setFiber(Double fiber) {
        this.fiber = fiber;
    }

    public Set<Integer> getStructType() {
        return structType;
    }

    public void setStructType(Set<Integer> structType) {
        this.structType = structType;
    }
}
