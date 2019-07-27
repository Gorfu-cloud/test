package com.bkit.fatdown.dto;

import io.swagger.annotations.ApiModel;

import java.util.Set;

/**
 * @file: UserReportDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 用户饮食报告封装类
 * @date: Created in 7/25/19  3:47 PM
 * @modified:
 * @version: 1.0
 */

@ApiModel
public class UserReportDTO {

    private Double realEnergy;
    private Double upperEnergy;
    private Double lowerEnergy;

    private Integer energyEvaluation;

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
     * 脂肪
     */
    private Double fat;

    /**
     * 结构评价：0,合理，1较合理，2不合理
     */
    private Integer structureEvaluation;

    /**
     * 结构缺乏种类：1,蛋白类，2,主食，3，蔬菜水果，4，坚果，5,豆类
     */
    private Set<Integer> structureLack;

    /**
     * 营养素评价
     */
    private Double colPer;
    private Double fatPer;
    private Double fibrinPer;
    private Double proteinPer;

    /**
     * 营养素百分比
     */

    private Integer colEvaluation;
    private Integer fatEvaluation;
    private Integer fibrinEvaluation;
    private Integer proteinEvaluation;

    /**
     * 缺乏或多
     */
    private Double colLack;
    private Double fatLack;
    private Double fibrinLack;
    private Double proteinLack;

    public UserReportDTO() {
    }

    public Integer getEnergyEvaluation() {
        return energyEvaluation;
    }

    public void setEnergyEvaluation(Integer energyEvaluation) {
        this.energyEvaluation = energyEvaluation;
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

    public Set<Integer> getStructureLack() {
        return structureLack;
    }

    public void setStructureLack(Set<Integer> structureLack) {
        this.structureLack = structureLack;
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

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Integer getColEvaluation() {
        return colEvaluation;
    }

    public void setColEvaluation(Integer colEvaluation) {
        this.colEvaluation = colEvaluation;
    }

    public Integer getFatEvaluation() {
        return fatEvaluation;
    }

    public void setFatEvaluation(Integer fatEvaluation) {
        this.fatEvaluation = fatEvaluation;
    }

    public Integer getFibrinEvaluation() {
        return fibrinEvaluation;
    }

    public void setFibrinEvaluation(Integer fibrinEvaluation) {
        this.fibrinEvaluation = fibrinEvaluation;
    }

    public Integer getProteinEvaluation() {
        return proteinEvaluation;
    }

    public void setProteinEvaluation(Integer proteinEvaluation) {
        this.proteinEvaluation = proteinEvaluation;
    }

    public Double getColLack() {
        return colLack;
    }

    public void setColLack(Double colLack) {
        this.colLack = colLack;
    }

    public Double getFatLack() {
        return fatLack;
    }

    public void setFatLack(Double fatLack) {
        this.fatLack = fatLack;
    }

    public Double getFibrinLack() {
        return fibrinLack;
    }

    public void setFibrinLack(Double fibrinLack) {
        this.fibrinLack = fibrinLack;
    }

    public Double getProteinLack() {
        return proteinLack;
    }

    public void setProteinLack(Double proteinLack) {
        this.proteinLack = proteinLack;
    }

    public Double getColPer() {
        return colPer;
    }

    public void setColPer(Double colPer) {
        this.colPer = colPer;
    }

    public Double getFatPer() {
        return fatPer;
    }

    public void setFatPer(Double fatPer) {
        this.fatPer = fatPer;
    }

    public Double getFibrinPer() {
        return fibrinPer;
    }

    public void setFibrinPer(Double fibrinPer) {
        this.fibrinPer = fibrinPer;
    }

    public Double getProteinPer() {
        return proteinPer;
    }

    public void setProteinPer(Double proteinPer) {
        this.proteinPer = proteinPer;
    }
}
