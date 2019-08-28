package com.bkit.fatdown.dto.food;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @file: FoodElementDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 食物组成成分列表
 * @date: Created in 2019/8/28 0:06
 * @modified:
 * @version: 1.0
 */
@ApiModel(value = "食物组成元素记录",description = "能量是根据重量算出来的,不可变.")
public class FoodElementDTO implements Serializable {
    @ApiModelProperty(value="关系编号",name="relationId",example="1")
    private Integer relationId;
    @ApiModelProperty(value="元素编号",name="elementId",example="2")
    private Integer elementId;
    @ApiModelProperty(value="元素名称",name="elementName",example="麦子")
    private String elementName;
    @ApiModelProperty(value="重量",name="gram",example="10.0")
    private Double gram;
    @ApiModelProperty(value="能量(根据重量计算后)",name="energy",example="100.0")
    private Double energy;
    @ApiModelProperty(value="更新日期",name="updateDate",example="2019年8月28日 10点25分")
    private Date updateDate;

    public FoodElementDTO() {
    }

    public FoodElementDTO(Integer elementId, String elementName, Double gram, Double energy, Date updateDate) {
        this.elementId = elementId;
        this.elementName = elementName;
        this.gram = gram;
        this.energy = energy;
        this.updateDate = updateDate;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public Integer getElementId() {
        return elementId;
    }

    public void setElementId(Integer elementId) {
        this.elementId = elementId;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public Double getGram() {
        return gram;
    }

    public void setGram(Double gram) {
        this.gram = gram;
    }

    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "FoodElementDTO{" +
                "elementId=" + elementId +
                ", elementName='" + elementName + '\'' +
                ", gram=" + gram +
                ", energy=" + energy +
                ", updateDate=" + updateDate +
                '}';
    }
}
