package com.bkit.fatdown.dto.diet;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @file: MealEvaluationDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 当餐饮食评价数据
 * @date: Created in 9/18/19  11:26 PM
 * @modified:
 * @version: 1.0
 */
@ApiModel(value = "当餐饮食评价")
public class MealEvaluationDTO implements Serializable {
    @ApiModelProperty("能量评价：0 合理，1 一般，2 不合理")
    private Integer energyEvaluation;
    @ApiModelProperty("结构评价：0 合理，1 一般，2 不合理")
    private Integer structureEvaluation;
    @ApiModelProperty("菜式成分元素： 菜式名称 + 成分元素信息")
    private HashMap<String,ElementInfo> elementList;

    public MealEvaluationDTO(){

    }

    public Integer getEnergyEvaluation() {
        return energyEvaluation;
    }

    public void setEnergyEvaluation(Integer energyEvaluation) {
        this.energyEvaluation = energyEvaluation;
    }

    public Integer getStructureEvaluation() {
        return structureEvaluation;
    }

    public void setStructureEvaluation(Integer structureEvaluation) {
        this.structureEvaluation = structureEvaluation;
    }

    public HashMap<String, ElementInfo> getElementList() {
        return elementList;
    }

    public void setElementList(HashMap<String, ElementInfo> elementList) {
        this.elementList = elementList;
    }

    @Override
    public String toString() {
        return "MealEvaluationDTO{" +
                "energyEvaluation=" + energyEvaluation +
                ", structureEvaluation=" + structureEvaluation +
                ", elementList=" + elementList +
                '}';
    }
}
