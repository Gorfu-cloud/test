package com.bkit.fatdown.dto.diet;

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
     * 每天饮食能量评价统计
     */
    private EnergyEvaluation energyEvaluation;
    /**
     * 种类均衡评价
     */
    private SpeciesEvaluation speciesEvaluation;
    /**
     * 三餐能量报告
     */
    private Evaluation breakfast;
    private Evaluation lunch;
    private Evaluation dinner;
    /**
     * 营养素评价
     */
    private WeeklyNutrientsEvaluation weeklyNutrientsEvaluation;

    public DietWeeklyReport() {
        init();
    }

    public void init() {
        this.energyEvaluation = new EnergyEvaluation();
        this.speciesEvaluation = new SpeciesEvaluation();
        this.breakfast = new Evaluation();
        this.lunch = new Evaluation();
        this.dinner = new Evaluation();
        this.weeklyNutrientsEvaluation = new WeeklyNutrientsEvaluation();
    }

    public SpeciesEvaluation getSpeciesEvaluation() {
        return speciesEvaluation;
    }

    public void setSpeciesEvaluation(SpeciesEvaluation speciesEvaluation) {
        this.speciesEvaluation = speciesEvaluation;
    }

    public EnergyEvaluation getEnergyEvaluation() {
        return energyEvaluation;
    }

    public void setEnergyEvaluation(EnergyEvaluation energyEvaluation) {
        this.energyEvaluation = energyEvaluation;
    }

    public Evaluation getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Evaluation breakfast) {
        this.breakfast = breakfast;
    }

    public Evaluation getLunch() {
        return lunch;
    }

    public void setLunch(Evaluation lunch) {
        this.lunch = lunch;
    }

    public Evaluation getDinner() {
        return dinner;
    }

    public void setDinner(Evaluation dinner) {
        this.dinner = dinner;
    }

    public WeeklyNutrientsEvaluation getWeeklyNutrientsEvaluation() {
        return weeklyNutrientsEvaluation;
    }

    public void setWeeklyNutrientsEvaluation(WeeklyNutrientsEvaluation weeklyNutrientsEvaluation) {
        this.weeklyNutrientsEvaluation = weeklyNutrientsEvaluation;
    }

    public void setWeeklyNutrientsEvaluation(NutrientsEvaluation nutrientsEvaluation) {
        this.weeklyNutrientsEvaluation.setCarbs(nutrientsEvaluation.getCarbs());
        this.weeklyNutrientsEvaluation.setFat(nutrientsEvaluation.getFat());
        this.weeklyNutrientsEvaluation.setFibrin(nutrientsEvaluation.getFibrin());
        this.weeklyNutrientsEvaluation.setProtein(nutrientsEvaluation.getProtein());
    }
}
