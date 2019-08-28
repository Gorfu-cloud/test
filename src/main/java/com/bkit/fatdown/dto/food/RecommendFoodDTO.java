package com.bkit.fatdown.dto.food;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @file: RecommendFoodDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 后台管理菜式类型信息
 * @date: Created in 2019/8/28 11:48
 * @modified:
 * @version: 1.0
 */
@ApiModel
public class RecommendFoodDTO implements Serializable {
    @ApiModelProperty(value = "食物推荐ID")
    private Integer id;
    @ApiModelProperty(value = "食物推荐名称")
    private String foodName;
    @ApiModelProperty(value = "食物推荐类型名称")
    private String typeName;
    @ApiModelProperty(value = "热度")
    private Integer total;
    @ApiModelProperty(value = "更新日期")
    private Date updateDate;

    public RecommendFoodDTO() {
    }

    public RecommendFoodDTO(Integer id, String foodName, String typeName, Integer total, Date updateDate) {
        this.id = id;
        this.foodName = foodName;
        this.typeName = typeName;
        this.total = total;
        this.updateDate = updateDate;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "RecommendFoodDTO{" +
                "id=" + id +
                ", foodName='" + foodName + '\'' +
                ", typeName=" + typeName +
                ", total=" + total +
                ", updateDate=" + updateDate +
                '}';
    }
}
