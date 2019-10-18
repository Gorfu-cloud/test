package com.bkit.fatdown.dto.food;

import java.io.Serializable;

/**
 * @file: ElementBasicDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 食物元素成分
 * @date: Created in 2019/8/28 14:56
 * @modified:
 * @version: 1.0
 */
public class ElementBasicDTO implements Serializable {
    private String name;

    private Integer type;

    private Integer goodProtein;

    private Integer animalFat;

    private Double eatPer;

    private Double dryPer;

    private Double water;

    private Double energy;

    private Double protein;

    private Double fat;

    private Double carbs;

    private Double vitaminA;

    private Double vitaminB1;

    private Double vitaminB2;

    private Double vitaminB3;

    private Double vitaminC;

    private Double vitaminE;

    private Double ca;

    private Double zn;

    private Double mn;

    private Double p;

    private Double k;

    private Double na;

    private Double mg;

    private Double fe;

    private Double cu;

    private Double se;

    private Double solubleFiber;

    private Double insolubleFiber;

    private Double cholesterol;

    private static final long serialVersionUID = 1L;

    public ElementBasicDTO() {
    }

    public ElementBasicDTO(String name, Integer type, Integer goodProtein, Integer animalFat, Double eatPer,
                           Double dryPer, Double water, Double energy, Double protein, Double fat, Double carbs,
                           Double vitaminA, Double vitaminB1, Double vitaminB2, Double vitaminB3, Double vitaminC,
                           Double vitaminE, Double ca, Double zn, Double mn, Double p, Double k, Double na, Double mg,
                           Double fe, Double cu, Double se, Double solubleFiber, Double insolubleFiber, Double cholesterol) {
        this.name = name;
        this.type = type;
        this.goodProtein = goodProtein;
        this.animalFat = animalFat;
        this.eatPer = eatPer;
        this.dryPer = dryPer;
        this.water = water;
        this.energy = energy;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
        this.vitaminA = vitaminA;
        this.vitaminB1 = vitaminB1;
        this.vitaminB2 = vitaminB2;
        this.vitaminB3 = vitaminB3;
        this.vitaminC = vitaminC;
        this.vitaminE = vitaminE;
        this.ca = ca;
        this.zn = zn;
        this.mn = mn;
        this.p = p;
        this.k = k;
        this.na = na;
        this.mg = mg;
        this.fe = fe;
        this.cu = cu;
        this.se = se;
        this.solubleFiber = solubleFiber;
        this.insolubleFiber = insolubleFiber;
        this.cholesterol = cholesterol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getGoodProtein() {
        return goodProtein;
    }

    public void setGoodProtein(Integer goodProtein) {
        this.goodProtein = goodProtein;
    }

    public Integer getAnimalFat() {
        return animalFat;
    }

    public void setAnimalFat(Integer animalFat) {
        this.animalFat = animalFat;
    }

    public Double getEatPer() {
        return eatPer;
    }

    public void setEatPer(Double eatPer) {
        this.eatPer = eatPer;
    }

    public Double getWater() {
        return water;
    }

    public void setWater(Double water) {
        this.water = water;
    }

    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getCarbs() {
        return carbs;
    }

    public void setCarbs(Double carbs) {
        this.carbs = carbs;
    }

    public Double getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(Double vitaminA) {
        this.vitaminA = vitaminA;
    }

    public Double getVitaminB1() {
        return vitaminB1;
    }

    public void setVitaminB1(Double vitaminB1) {
        this.vitaminB1 = vitaminB1;
    }

    public Double getVitaminB2() {
        return vitaminB2;
    }

    public void setVitaminB2(Double vitaminB2) {
        this.vitaminB2 = vitaminB2;
    }

    public Double getVitaminB3() {
        return vitaminB3;
    }

    public void setVitaminB3(Double vitaminB3) {
        this.vitaminB3 = vitaminB3;
    }

    public Double getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(Double vitaminC) {
        this.vitaminC = vitaminC;
    }

    public Double getVitaminE() {
        return vitaminE;
    }

    public void setVitaminE(Double vitaminE) {
        this.vitaminE = vitaminE;
    }

    public Double getCa() {
        return ca;
    }

    public void setCa(Double ca) {
        this.ca = ca;
    }

    public Double getZn() {
        return zn;
    }

    public void setZn(Double zn) {
        this.zn = zn;
    }

    public Double getMn() {
        return mn;
    }

    public void setMn(Double mn) {
        this.mn = mn;
    }

    public Double getP() {
        return p;
    }

    public void setP(Double p) {
        this.p = p;
    }

    public Double getK() {
        return k;
    }

    public void setK(Double k) {
        this.k = k;
    }

    public Double getNa() {
        return na;
    }

    public void setNa(Double na) {
        this.na = na;
    }

    public Double getMg() {
        return mg;
    }

    public void setMg(Double mg) {
        this.mg = mg;
    }

    public Double getFe() {
        return fe;
    }

    public void setFe(Double fe) {
        this.fe = fe;
    }

    public Double getCu() {
        return cu;
    }

    public void setCu(Double cu) {
        this.cu = cu;
    }

    public Double getSe() {
        return se;
    }

    public void setSe(Double se) {
        this.se = se;
    }

    public Double getSolubleFiber() {
        return solubleFiber;
    }

    public void setSolubleFiber(Double solubleFiber) {
        this.solubleFiber = solubleFiber;
    }

    public Double getInsolubleFiber() {
        return insolubleFiber;
    }

    public void setInsolubleFiber(Double insolubleFiber) {
        this.insolubleFiber = insolubleFiber;
    }

    public Double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(Double cholesterol) {
        this.cholesterol = cholesterol;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Double getDryPer() {
        return dryPer;
    }

    public void setDryPer(Double dryPer) {
        this.dryPer = dryPer;
    }

    @Override
    public String toString() {
        return "ElementBasicDTO{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", goodProtein=" + goodProtein +
                ", animalFat=" + animalFat +
                ", eatPer=" + eatPer +
                ", dryPer=" + dryPer +
                ", water=" + water +
                ", energy=" + energy +
                ", protein=" + protein +
                ", fat=" + fat +
                ", carbs=" + carbs +
                ", vitaminA=" + vitaminA +
                ", vitaminB1=" + vitaminB1 +
                ", vitaminB2=" + vitaminB2 +
                ", vitaminB3=" + vitaminB3 +
                ", vitaminC=" + vitaminC +
                ", vitaminE=" + vitaminE +
                ", ca=" + ca +
                ", zn=" + zn +
                ", mn=" + mn +
                ", p=" + p +
                ", k=" + k +
                ", na=" + na +
                ", mg=" + mg +
                ", fe=" + fe +
                ", cu=" + cu +
                ", se=" + se +
                ", solubleFiber=" + solubleFiber +
                ", insolubleFiber=" + insolubleFiber +
                ", cholesterol=" + cholesterol +
                '}';
    }
}
