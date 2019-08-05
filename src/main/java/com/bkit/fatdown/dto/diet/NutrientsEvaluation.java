package com.bkit.fatdown.dto.diet;

/**
 * @file: NutrientsEvaluation
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 营养素评价
 * @date: Created in 8/5/19  4:14 PM
 * @modified:
 * @version: 1.0
 */
public class NutrientsEvaluation {
    private Evaluation protein;
    private Evaluation fat;
    private Evaluation carbs;
    private Evaluation fibrin;

    public void init() {
        this.protein = new Evaluation();
        this.fat = new Evaluation();
        this.carbs = new Evaluation();
        this.fibrin = new Evaluation();
    }

    public Evaluation getProtein() {
        return protein;
    }

    public void setProtein(Evaluation protein) {
        this.protein = protein;
    }

    public Evaluation getFat() {
        return fat;
    }

    public void setFat(Evaluation fat) {
        this.fat = fat;
    }

    public Evaluation getCarbs() {
        return carbs;
    }

    public void setCarbs(Evaluation carbs) {
        this.carbs = carbs;
    }

    public Evaluation getFibrin() {
        return fibrin;
    }

    public void setFibrin(Evaluation fibrin) {
        this.fibrin = fibrin;
    }
}
