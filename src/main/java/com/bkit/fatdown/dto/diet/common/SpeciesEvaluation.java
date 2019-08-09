package com.bkit.fatdown.dto.diet.common;

/**
 * @file: SpeciesEvaluation
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 种类均衡评价
 * @date: Created in 8/5/19  3:38 PM
 * @modified:
 * @version: 1.new TotalEvaluation()
 */

public class SpeciesEvaluation {
    /**
     * 食物种类均衡评价:0 优，1 良，2 一般
     */
    private TotalEvaluation proteinSpecies;
    private TotalEvaluation stapleFoodSpecies;
    private TotalEvaluation beanNutSpecies;
    private TotalEvaluation fruitVegetableSpecies;
    private TotalEvaluation totalSpecies;
    private double score;


    public SpeciesEvaluation() {
        init();
    }

    private void init() {
        this.proteinSpecies = new TotalEvaluation();
        this.stapleFoodSpecies = new TotalEvaluation();
        this.fruitVegetableSpecies = new TotalEvaluation();
        this.beanNutSpecies = new TotalEvaluation();
        this.totalSpecies = new TotalEvaluation();
    }

    public TotalEvaluation getProteinSpecies() {
        return proteinSpecies;
    }

    public void setProteinSpecies(TotalEvaluation proteinSpecies) {
        this.proteinSpecies = proteinSpecies;
    }

    public TotalEvaluation getStapleFoodSpecies() {
        return stapleFoodSpecies;
    }

    public void setStapleFoodSpecies(TotalEvaluation stapleFoodSpecies) {
        this.stapleFoodSpecies = stapleFoodSpecies;
    }

    public TotalEvaluation getBeanNutSpecies() {
        return beanNutSpecies;
    }

    public void setBeanNutSpecies(TotalEvaluation beanNutSpecies) {
        this.beanNutSpecies = beanNutSpecies;
    }

    public TotalEvaluation getFruitVegetableSpecies() {
        return fruitVegetableSpecies;
    }

    public void setFruitVegetableSpecies(TotalEvaluation fruitVegetableSpecies) {
        this.fruitVegetableSpecies = fruitVegetableSpecies;
    }

    public TotalEvaluation getTotalSpecies() {
        return totalSpecies;
    }

    public void setTotalSpecies(TotalEvaluation totalSpecies) {
        this.totalSpecies = totalSpecies;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
