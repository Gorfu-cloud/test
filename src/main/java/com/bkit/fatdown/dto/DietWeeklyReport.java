package com.bkit.fatdown.dto;

/**
 * @file: DietWeeklyReport
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 每周饮食报告传输对象
 * @date: Created in 7/30/19  9:09 PM
 * @modified:
 * @version: 1.0
 */
public class DietWeeklyReport {
    /**
     * 能量摄入评价：0 优，1 良，2 一般，3 差
     */
    private Integer energyEvaluation;
    private Double energyPer;

    /**
     * 食物种类均衡评价:0 优，1 良，2 一般
     */
    private Integer proteinSpeciesEvaluation;
    private Integer stapleFoodSpeciesEvaluation;
    private Integer fruitVegetableSpeciesEvaluation;
    private Integer beanNutSpeciesEvaluation;
    private Integer totalSpeciesEvaluation;

    /**
     * 三餐能量分配评价
     */
    private Double breakfastEnergyPer;
    private Double lunchEnergyPer;
    private Double dinnerEnergyPer;
    private Integer breakfastEnergyEvaluation;
    private Integer lunchEnergyEvaluation;
    private Integer dinnerEnergyEvaluation;

    /**
     * 营养素评价: 0,合适，1,较合理，2,不合理
     */
    private Integer colEvaluation;
    private Integer fatEvaluation;
    private Integer fibrinEvaluation;
    private Integer proteinEvaluation;
    private Integer goodProteinEvaluation;
    private Integer animalFatEvaluation;
    /**
     * 营养素百分比
     */
    private Double colPer;
    private Double fatPer;
    private Double fibrinPer;
    private Double proteinPer;
    private Double goodProteinPer;
    private Double animalFatPer;

    public DietWeeklyReport() {
        init();
    }

    private void init() {

        this.energyEvaluation = 0;
        this.energyPer = 0.0;

        this.proteinSpeciesEvaluation = 0;
        this.stapleFoodSpeciesEvaluation = 0;
        this.fruitVegetableSpeciesEvaluation = 0;
        this.beanNutSpeciesEvaluation = 0;
        this.totalSpeciesEvaluation = 0;

        this.breakfastEnergyPer = 0.0;
        this.lunchEnergyPer = 0.0;
        this.dinnerEnergyPer = 0.0;

        this.breakfastEnergyEvaluation = 0;
        this.lunchEnergyEvaluation = 0;
        this.dinnerEnergyEvaluation = 0;

        this.colEvaluation = 0;
        this.fatEvaluation = 0;
        this.fibrinEvaluation = 0;
        this.proteinEvaluation = 0;
        this.goodProteinEvaluation = 0;
        this.animalFatEvaluation = 0;

        this.colPer = 0.0;
        this.fatPer = 0.0;
        this.fibrinPer = 0.0;
        this.proteinPer = 0.0;
        this.goodProteinPer = 0.0;
        this.animalFatPer = 0.0;
    }

    public Integer getEnergyEvaluation() {
        return energyEvaluation;
    }

    public void setEnergyEvaluation(Integer energyEvaluation) {
        this.energyEvaluation = energyEvaluation;
    }

    public Double getEnergyPer() {
        return energyPer;
    }

    public void setEnergyPer(Double energyPer) {
        this.energyPer = energyPer;
    }

    public Integer getProteinSpeciesEvaluation() {
        return proteinSpeciesEvaluation;
    }

    public void setProteinSpeciesEvaluation(Integer proteinSpeciesEvaluation) {
        this.proteinSpeciesEvaluation = proteinSpeciesEvaluation;
    }

    public Integer getStapleFoodSpeciesEvaluation() {
        return stapleFoodSpeciesEvaluation;
    }

    public void setStapleFoodSpeciesEvaluation(Integer stapleFoodSpeciesEvaluation) {
        this.stapleFoodSpeciesEvaluation = stapleFoodSpeciesEvaluation;
    }

    public Integer getFruitVegetableSpeciesEvaluation() {
        return fruitVegetableSpeciesEvaluation;
    }

    public Integer getBreakfastEnergyEvaluation() {
        return breakfastEnergyEvaluation;
    }

    public void setBreakfastEnergyEvaluation(Integer breakfastEnergyEvaluation) {
        this.breakfastEnergyEvaluation = breakfastEnergyEvaluation;
    }

    public Integer getLunchEnergyEvaluation() {
        return lunchEnergyEvaluation;
    }

    public void setLunchEnergyEvaluation(Integer lunchEnergyEvaluation) {
        this.lunchEnergyEvaluation = lunchEnergyEvaluation;
    }

    public Integer getDinnerEnergyEvaluation() {
        return dinnerEnergyEvaluation;
    }

    public void setDinnerEnergyEvaluation(Integer dinnerEnergyEvaluation) {
        this.dinnerEnergyEvaluation = dinnerEnergyEvaluation;
    }

    public void setFruitVegetableSpeciesEvaluation(Integer fruitVegetableSpeciesEvaluation) {
        this.fruitVegetableSpeciesEvaluation = fruitVegetableSpeciesEvaluation;
    }

    public Integer getBeanNutSpeciesEvaluation() {
        return beanNutSpeciesEvaluation;
    }

    public void setBeanNutSpeciesEvaluation(Integer beanNutSpeciesEvaluation) {
        this.beanNutSpeciesEvaluation = beanNutSpeciesEvaluation;
    }

    public Integer getTotalSpeciesEvaluation() {
        return totalSpeciesEvaluation;
    }

    public void setTotalSpeciesEvaluation(Integer totalSpeciesEvaluation) {
        this.totalSpeciesEvaluation = totalSpeciesEvaluation;
    }

    public Double getBreakfastEnergyPer() {
        return breakfastEnergyPer;
    }

    public void setBreakfastEnergyPer(Double breakfastEnergyPer) {
        this.breakfastEnergyPer = breakfastEnergyPer;
    }

    public Double getLunchEnergyPer() {
        return lunchEnergyPer;
    }

    public void setLunchEnergyPer(Double lunchEnergyPer) {
        this.lunchEnergyPer = lunchEnergyPer;
    }

    public Double getDinnerEnergyPer() {
        return dinnerEnergyPer;
    }

    public void setDinnerEnergyPer(Double dinnerEnergyPer) {
        this.dinnerEnergyPer = dinnerEnergyPer;
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

    public Integer getGoodProteinEvaluation() {
        return goodProteinEvaluation;
    }

    public void setGoodProteinEvaluation(Integer goodProteinEvaluation) {
        this.goodProteinEvaluation = goodProteinEvaluation;
    }

    public Integer getAnimalFatEvaluation() {
        return animalFatEvaluation;
    }

    public void setAnimalFatEvaluation(Integer animalFatEvaluation) {
        this.animalFatEvaluation = animalFatEvaluation;
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

    public Double getGoodProteinPer() {
        return goodProteinPer;
    }

    public void setGoodProteinPer(Double goodProteinPer) {
        this.goodProteinPer = goodProteinPer;
    }

    public Double getAnimalFatPer() {
        return animalFatPer;
    }

    public void setAnimalFatPer(Double animalFatPer) {
        this.animalFatPer = animalFatPer;
    }
}
