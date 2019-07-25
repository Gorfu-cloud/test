package com.bkit.fatdown.dto;

import java.util.List;

/**
 * @file: UserReportDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 用户饮食报告封装类
 * @date: Created in 7/25/19  3:47 PM
 * @modified:
 * @version: 1.0
 */

public class UserReportDTO {
    private Double realEnergy;
    private Double upperEnergy;
    private Double lowerEnergy;
    /**
     * 结构评价：0,合理，1较合理，2不合理
     */
    private Integer structureEvaluation;
    /**
     * 结构缺乏种类：1,蛋白类，2,主食，3，蔬菜水果，4，坚果，5,豆类
     */
    private List<Integer> structureLack;

    public UserReportDTO() {
    }

    public Double getRealEnergy() {
        return realEnergy;
    }

    public void setRealEnergy(Double realEnergy) {
        this.realEnergy = realEnergy;
    }

    public Double getUpperEnergy() {
        return upperEnergy;
    }

    public void setUpperEnergy(Double upperEnergy) {
        this.upperEnergy = upperEnergy;
    }

    public Double getLowerEnergy() {
        return lowerEnergy;
    }

    public void setLowerEnergy(Double lowerEnergy) {
        this.lowerEnergy = lowerEnergy;
    }

    public Integer getStructureEvaluation() {
        return structureEvaluation;
    }

    public void setStructureEvaluation(Integer structureEvaluation) {
        this.structureEvaluation = structureEvaluation;
    }

    public List<Integer> getStructureLack() {
        return structureLack;
    }

    public void setStructureLack(List<Integer> structureLack) {
        this.structureLack = structureLack;
    }
}
