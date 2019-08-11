package com.bkit.fatdown.dto.food;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @file: RecommendTypeDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 食物推荐信息封装类
 * @date: Created in 8/9/19  11:09 AM
 * @modified:
 * @version: 1.0
 */
@ApiModel
public class RecommendTypeDTO implements Serializable {
    @ApiModelProperty(value = "推荐食物类型种类ID", example = "1")
    private Integer id;
    @ApiModelProperty(value = "推荐食物类型种类名称", example = "蛋白质")
    private String typeName;
    @ApiModelProperty(value = "推荐食物类型状态：0 缺乏，1 偏多", example = "0")
    private Integer status;

    public RecommendTypeDTO() {
    }

    public RecommendTypeDTO(Integer id, String typeName, Integer status) {
        this.id = id;
        this.typeName = typeName;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RecommendTypeDTO{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", status=" + status +
                '}';
    }
}
