package com.bkit.fatdown.dto.diet;

/**
 * @file: WeeklyNutrientsEvaluation
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 周营养素评价
 * @date: Created in 8/5/19  4:22 PM
 * @modified:
 * @version: 1.0
 */
public class WeeklyNutrientsEvaluation extends NutrientsEvaluation {
    private Evaluation animalFat;
    private Evaluation goodProtein;

    public WeeklyNutrientsEvaluation() {
        super();
        init();
    }

    @Override
    public void init() {
        super.init();
        this.animalFat = new Evaluation();
        this.goodProtein = new Evaluation();
    }

    public Evaluation getAnimalFat() {
        return animalFat;
    }

    public void setAnimalFat(Evaluation animalFat) {
        this.animalFat = animalFat;
    }

    public Evaluation getGoodProtein() {
        return goodProtein;
    }

    public void setGoodProtein(Evaluation goodProtein) {
        this.goodProtein = goodProtein;
    }
}
