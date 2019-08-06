package com.bkit.fatdown.dto.diet;

/**
 * @file: WeeklyNutrientsEvaluation
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 周营养素评价
 * @date: Created in 8/5/19  4:22 PM
 * @modified:
 * @version: 1.0
 */
public class WeeklyNutrientsEvaluation {
    private TotalEvaluation animalFat;
    private TotalEvaluation goodProtein;

    public WeeklyNutrientsEvaluation() {
        init();
    }

    private void init() {
        this.animalFat = new TotalEvaluation();
        this.goodProtein = new TotalEvaluation();
    }

    public TotalEvaluation getAnimalFat() {
        return animalFat;
    }

    public void setAnimalFat(TotalEvaluation animalFat) {
        this.animalFat = animalFat;
    }

    public TotalEvaluation getGoodProtein() {
        return goodProtein;
    }

    public void setGoodProtein(TotalEvaluation goodProtein) {
        this.goodProtein = goodProtein;
    }
}
