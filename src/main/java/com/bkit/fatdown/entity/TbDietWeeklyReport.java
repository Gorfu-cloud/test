package com.bkit.fatdown.entity;

import java.io.Serializable;
import java.util.Date;

public class TbDietWeeklyReport implements Serializable {
    private Integer id;

    private Integer userId;

    private Double energyScore;

    private Integer energyExcellent;

    private Integer energyGood;

    private Integer energyOrdinary;

    private Integer energyBad;

    private Double speciesScore;

    private Double proteinSpeciesTotal;

    private Integer proteinSpeciesEvaluation;

    private Double stapleFoodSpeciesTotal;

    private Integer stapleFoodSpeciesEvaluation;

    private Double beanNutSpeciesTotal;

    private Integer beanNutSpeciesEvaluation;

    private Double fruitVegetableSpeciesTotal;

    private Integer fruitVegetableSpeciesEvaluation;

    private Double totalSpeciesTotal;

    private Integer totalSpeciesEvaluation;

    private Double breakfastScore;

    private Integer breakfastExcellent;

    private Integer breakfastGood;

    private Integer breakfastOrdinary;

    private Double lunchScore;

    private Integer lunchExcellent;

    private Integer lunchGood;

    private Integer lunchOrdinary;

    private Double dinnerScore;

    private Integer dinnerExcellent;

    private Integer dinnerGood;

    private Integer dinnerOrdinary;

    private Double nutrientScore;

    private Double proteinScore;

    private Integer proteinExcellent;

    private Integer proteinGood;

    private Integer proteinOrdinary;

    private Double fatScore;

    private Integer fatExcellent;

    private Integer fatGood;

    private Integer fatOrdinary;

    private Double fibrinScore;

    private Integer fibrinExcellent;

    private Integer fibrinGood;

    private Integer fibrinOrdinary;

    private Double carbsScore;

    private Integer carbsGood;

    private Integer carbsExcellent;

    private Integer carbsOrdinary;

    private Double animalFatScore;

    private Double animalFatPer;

    private Integer animalFatEvaluation;

    private Double goodProteinScore;

    private Double goodProteinPer;

    private Integer goodProteinEvaluation;

    private Date gmtCreate;

    private Date gmtModified;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getEnergyScore() {
        return energyScore;
    }

    public void setEnergyScore(Double energyScore) {
        this.energyScore = energyScore;
    }

    public Integer getEnergyExcellent() {
        return energyExcellent;
    }

    public void setEnergyExcellent(Integer energyExcellent) {
        this.energyExcellent = energyExcellent;
    }

    public Integer getEnergyGood() {
        return energyGood;
    }

    public void setEnergyGood(Integer energyGood) {
        this.energyGood = energyGood;
    }

    public Integer getEnergyOrdinary() {
        return energyOrdinary;
    }

    public void setEnergyOrdinary(Integer energyOrdinary) {
        this.energyOrdinary = energyOrdinary;
    }

    public Integer getEnergyBad() {
        return energyBad;
    }

    public void setEnergyBad(Integer energyBad) {
        this.energyBad = energyBad;
    }

    public Double getSpeciesScore() {
        return speciesScore;
    }

    public void setSpeciesScore(Double speciesScore) {
        this.speciesScore = speciesScore;
    }

    public Double getProteinSpeciesTotal() {
        return proteinSpeciesTotal;
    }

    public void setProteinSpeciesTotal(Double proteinSpeciesTotal) {
        this.proteinSpeciesTotal = proteinSpeciesTotal;
    }

    public Integer getProteinSpeciesEvaluation() {
        return proteinSpeciesEvaluation;
    }

    public void setProteinSpeciesEvaluation(Integer proteinSpeciesEvaluation) {
        this.proteinSpeciesEvaluation = proteinSpeciesEvaluation;
    }

    public Double getStapleFoodSpeciesTotal() {
        return stapleFoodSpeciesTotal;
    }

    public void setStapleFoodSpeciesTotal(Double stapleFoodSpeciesTotal) {
        this.stapleFoodSpeciesTotal = stapleFoodSpeciesTotal;
    }

    public Integer getStapleFoodSpeciesEvaluation() {
        return stapleFoodSpeciesEvaluation;
    }

    public void setStapleFoodSpeciesEvaluation(Integer stapleFoodSpeciesEvaluation) {
        this.stapleFoodSpeciesEvaluation = stapleFoodSpeciesEvaluation;
    }

    public Double getBeanNutSpeciesTotal() {
        return beanNutSpeciesTotal;
    }

    public void setBeanNutSpeciesTotal(Double beanNutSpeciesTotal) {
        this.beanNutSpeciesTotal = beanNutSpeciesTotal;
    }

    public Integer getBeanNutSpeciesEvaluation() {
        return beanNutSpeciesEvaluation;
    }

    public void setBeanNutSpeciesEvaluation(Integer beanNutSpeciesEvaluation) {
        this.beanNutSpeciesEvaluation = beanNutSpeciesEvaluation;
    }

    public Double getFruitVegetableSpeciesTotal() {
        return fruitVegetableSpeciesTotal;
    }

    public void setFruitVegetableSpeciesTotal(Double fruitVegetableSpeciesTotal) {
        this.fruitVegetableSpeciesTotal = fruitVegetableSpeciesTotal;
    }

    public Integer getFruitVegetableSpeciesEvaluation() {
        return fruitVegetableSpeciesEvaluation;
    }

    public void setFruitVegetableSpeciesEvaluation(Integer fruitVegetableSpeciesEvaluation) {
        this.fruitVegetableSpeciesEvaluation = fruitVegetableSpeciesEvaluation;
    }

    public Double getTotalSpeciesTotal() {
        return totalSpeciesTotal;
    }

    public void setTotalSpeciesTotal(Double totalSpeciesTotal) {
        this.totalSpeciesTotal = totalSpeciesTotal;
    }

    public Integer getTotalSpeciesEvaluation() {
        return totalSpeciesEvaluation;
    }

    public void setTotalSpeciesEvaluation(Integer totalSpeciesEvaluation) {
        this.totalSpeciesEvaluation = totalSpeciesEvaluation;
    }

    public Double getBreakfastScore() {
        return breakfastScore;
    }

    public void setBreakfastScore(Double breakfastScore) {
        this.breakfastScore = breakfastScore;
    }

    public Integer getBreakfastExcellent() {
        return breakfastExcellent;
    }

    public void setBreakfastExcellent(Integer breakfastExcellent) {
        this.breakfastExcellent = breakfastExcellent;
    }

    public Integer getBreakfastGood() {
        return breakfastGood;
    }

    public void setBreakfastGood(Integer breakfastGood) {
        this.breakfastGood = breakfastGood;
    }

    public Integer getBreakfastOrdinary() {
        return breakfastOrdinary;
    }

    public void setBreakfastOrdinary(Integer breakfastOrdinary) {
        this.breakfastOrdinary = breakfastOrdinary;
    }

    public Double getLunchScore() {
        return lunchScore;
    }

    public void setLunchScore(Double lunchScore) {
        this.lunchScore = lunchScore;
    }

    public Integer getLunchExcellent() {
        return lunchExcellent;
    }

    public void setLunchExcellent(Integer lunchExcellent) {
        this.lunchExcellent = lunchExcellent;
    }

    public Integer getLunchGood() {
        return lunchGood;
    }

    public void setLunchGood(Integer lunchGood) {
        this.lunchGood = lunchGood;
    }

    public Integer getLunchOrdinary() {
        return lunchOrdinary;
    }

    public void setLunchOrdinary(Integer lunchOrdinary) {
        this.lunchOrdinary = lunchOrdinary;
    }

    public Double getDinnerScore() {
        return dinnerScore;
    }

    public void setDinnerScore(Double dinnerScore) {
        this.dinnerScore = dinnerScore;
    }

    public Integer getDinnerExcellent() {
        return dinnerExcellent;
    }

    public void setDinnerExcellent(Integer dinnerExcellent) {
        this.dinnerExcellent = dinnerExcellent;
    }

    public Integer getDinnerGood() {
        return dinnerGood;
    }

    public void setDinnerGood(Integer dinnerGood) {
        this.dinnerGood = dinnerGood;
    }

    public Integer getDinnerOrdinary() {
        return dinnerOrdinary;
    }

    public void setDinnerOrdinary(Integer dinnerOrdinary) {
        this.dinnerOrdinary = dinnerOrdinary;
    }

    public Double getNutrientScore() {
        return nutrientScore;
    }

    public void setNutrientScore(Double nutrientScore) {
        this.nutrientScore = nutrientScore;
    }

    public Double getProteinScore() {
        return proteinScore;
    }

    public void setProteinScore(Double proteinScore) {
        this.proteinScore = proteinScore;
    }

    public Integer getProteinExcellent() {
        return proteinExcellent;
    }

    public void setProteinExcellent(Integer proteinExcellent) {
        this.proteinExcellent = proteinExcellent;
    }

    public Integer getProteinGood() {
        return proteinGood;
    }

    public void setProteinGood(Integer proteinGood) {
        this.proteinGood = proteinGood;
    }

    public Integer getProteinOrdinary() {
        return proteinOrdinary;
    }

    public void setProteinOrdinary(Integer proteinOrdinary) {
        this.proteinOrdinary = proteinOrdinary;
    }

    public Double getFatScore() {
        return fatScore;
    }

    public void setFatScore(Double fatScore) {
        this.fatScore = fatScore;
    }

    public Integer getFatExcellent() {
        return fatExcellent;
    }

    public void setFatExcellent(Integer fatExcellent) {
        this.fatExcellent = fatExcellent;
    }

    public Integer getFatGood() {
        return fatGood;
    }

    public void setFatGood(Integer fatGood) {
        this.fatGood = fatGood;
    }

    public Integer getFatOrdinary() {
        return fatOrdinary;
    }

    public void setFatOrdinary(Integer fatOrdinary) {
        this.fatOrdinary = fatOrdinary;
    }

    public Double getFibrinScore() {
        return fibrinScore;
    }

    public void setFibrinScore(Double fibrinScore) {
        this.fibrinScore = fibrinScore;
    }

    public Integer getFibrinExcellent() {
        return fibrinExcellent;
    }

    public void setFibrinExcellent(Integer fibrinExcellent) {
        this.fibrinExcellent = fibrinExcellent;
    }

    public Integer getFibrinGood() {
        return fibrinGood;
    }

    public void setFibrinGood(Integer fibrinGood) {
        this.fibrinGood = fibrinGood;
    }

    public Integer getFibrinOrdinary() {
        return fibrinOrdinary;
    }

    public void setFibrinOrdinary(Integer fibrinOrdinary) {
        this.fibrinOrdinary = fibrinOrdinary;
    }

    public Double getCarbsScore() {
        return carbsScore;
    }

    public void setCarbsScore(Double carbsScore) {
        this.carbsScore = carbsScore;
    }

    public Integer getCarbsGood() {
        return carbsGood;
    }

    public void setCarbsGood(Integer carbsGood) {
        this.carbsGood = carbsGood;
    }

    public Integer getCarbsExcellent() {
        return carbsExcellent;
    }

    public void setCarbsExcellent(Integer carbsExcellent) {
        this.carbsExcellent = carbsExcellent;
    }

    public Integer getCarbsOrdinary() {
        return carbsOrdinary;
    }

    public void setCarbsOrdinary(Integer carbsOrdinary) {
        this.carbsOrdinary = carbsOrdinary;
    }

    public Double getAnimalFatScore() {
        return animalFatScore;
    }

    public void setAnimalFatScore(Double animalFatScore) {
        this.animalFatScore = animalFatScore;
    }

    public Double getAnimalFatPer() {
        return animalFatPer;
    }

    public void setAnimalFatPer(Double animalFatPer) {
        this.animalFatPer = animalFatPer;
    }

    public Integer getAnimalFatEvaluation() {
        return animalFatEvaluation;
    }

    public void setAnimalFatEvaluation(Integer animalFatEvaluation) {
        this.animalFatEvaluation = animalFatEvaluation;
    }

    public Double getGoodProteinScore() {
        return goodProteinScore;
    }

    public void setGoodProteinScore(Double goodProteinScore) {
        this.goodProteinScore = goodProteinScore;
    }

    public Double getGoodProteinPer() {
        return goodProteinPer;
    }

    public void setGoodProteinPer(Double goodProteinPer) {
        this.goodProteinPer = goodProteinPer;
    }

    public Integer getGoodProteinEvaluation() {
        return goodProteinEvaluation;
    }

    public void setGoodProteinEvaluation(Integer goodProteinEvaluation) {
        this.goodProteinEvaluation = goodProteinEvaluation;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", energyScore=").append(energyScore);
        sb.append(", energyExcellent=").append(energyExcellent);
        sb.append(", energyGood=").append(energyGood);
        sb.append(", energyOrdinary=").append(energyOrdinary);
        sb.append(", energyBad=").append(energyBad);
        sb.append(", speciesScore=").append(speciesScore);
        sb.append(", proteinSpeciesTotal=").append(proteinSpeciesTotal);
        sb.append(", proteinSpeciesEvaluation=").append(proteinSpeciesEvaluation);
        sb.append(", stapleFoodSpeciesTotal=").append(stapleFoodSpeciesTotal);
        sb.append(", stapleFoodSpeciesEvaluation=").append(stapleFoodSpeciesEvaluation);
        sb.append(", beanNutSpeciesTotal=").append(beanNutSpeciesTotal);
        sb.append(", beanNutSpeciesEvaluation=").append(beanNutSpeciesEvaluation);
        sb.append(", fruitVegetableSpeciesTotal=").append(fruitVegetableSpeciesTotal);
        sb.append(", fruitVegetableSpeciesEvaluation=").append(fruitVegetableSpeciesEvaluation);
        sb.append(", totalSpeciesTotal=").append(totalSpeciesTotal);
        sb.append(", totalSpeciesEvaluation=").append(totalSpeciesEvaluation);
        sb.append(", breakfastScore=").append(breakfastScore);
        sb.append(", breakfastExcellent=").append(breakfastExcellent);
        sb.append(", breakfastGood=").append(breakfastGood);
        sb.append(", breakfastOrdinary=").append(breakfastOrdinary);
        sb.append(", lunchScore=").append(lunchScore);
        sb.append(", lunchExcellent=").append(lunchExcellent);
        sb.append(", lunchGood=").append(lunchGood);
        sb.append(", lunchOrdinary=").append(lunchOrdinary);
        sb.append(", dinnerScore=").append(dinnerScore);
        sb.append(", dinnerExcellent=").append(dinnerExcellent);
        sb.append(", dinnerGood=").append(dinnerGood);
        sb.append(", dinnerOrdinary=").append(dinnerOrdinary);
        sb.append(", nutrientScore=").append(nutrientScore);
        sb.append(", proteinScore=").append(proteinScore);
        sb.append(", proteinExcellent=").append(proteinExcellent);
        sb.append(", proteinGood=").append(proteinGood);
        sb.append(", proteinOrdinary=").append(proteinOrdinary);
        sb.append(", fatScore=").append(fatScore);
        sb.append(", fatExcellent=").append(fatExcellent);
        sb.append(", fatGood=").append(fatGood);
        sb.append(", fatOrdinary=").append(fatOrdinary);
        sb.append(", fibrinScore=").append(fibrinScore);
        sb.append(", fibrinExcellent=").append(fibrinExcellent);
        sb.append(", fibrinGood=").append(fibrinGood);
        sb.append(", fibrinOrdinary=").append(fibrinOrdinary);
        sb.append(", carbsScore=").append(carbsScore);
        sb.append(", carbsGood=").append(carbsGood);
        sb.append(", carbsExcellent=").append(carbsExcellent);
        sb.append(", carbsOrdinary=").append(carbsOrdinary);
        sb.append(", animalFatScore=").append(animalFatScore);
        sb.append(", animalFatPer=").append(animalFatPer);
        sb.append(", animalFatEvaluation=").append(animalFatEvaluation);
        sb.append(", goodProteinScore=").append(goodProteinScore);
        sb.append(", goodProteinPer=").append(goodProteinPer);
        sb.append(", goodProteinEvaluation=").append(goodProteinEvaluation);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}