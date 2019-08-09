package com.bkit.fatdown.dto.diet;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

/**
 * @file: DietMealReport
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 每餐饮食报告传输对象
 * @date: Created in 7/30/19  8:33 PM
 * @modified:
 * @version: 1.0
 */
public class DietMealReport implements Serializable {

    /**
     * 能量评价，真实摄入，上限，下限
     */
    private Double realEnergy;
    private Double upperEnergy;
    private Double lowerEnergy;
    /**
     * 能量摄入评价：0,合理，1较合理，2不合理
     */
    private Integer energyEvaluation;
    /**
     * 结构评价：0,合理，1较合理，2不合理
     */
    private Integer structureEvaluation;
    /**
     * 结构缺乏种类：1,蛋白类，2,主食，3，蔬菜水果，4，坚果，5,豆类
     */
    private Set<Integer> structureLack;

    public DietMealReport() {
        init();
    }

    private void init() {
        this.realEnergy = 0.0;
        this.upperEnergy = 0.0;
        this.lowerEnergy = 0.0;
        this.energyEvaluation = 0;
        this.structureEvaluation = 0;
        this.structureLack = new TreeSet<>();
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

    public Set<Integer> getStructureLack() {
        return structureLack;
    }

    public void setStructureLack(Set<Integer> structureLack) {
        this.structureLack = structureLack;
    }

    @Override
    public String toString() {
        return "DietMealReport{" +
                "realEnergy=" + realEnergy +
                ", upperEnergy=" + upperEnergy +
                ", lowerEnergy=" + lowerEnergy +
                ", energyEvaluation=" + energyEvaluation +
                ", structureEvaluation=" + structureEvaluation +
                ", structureLack=" + structureLack +
                '}';
    }
}
