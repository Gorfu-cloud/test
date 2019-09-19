package com.bkit.fatdown.dto.diet;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Set;

/**
 * @file: ElementInfo
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 评价元素信息
 * @date: Created in 9/19/19  9:58 AM
 * @modified:
 * @version: 1.0
 */

@ApiModel("成分元素列表")
public class ElementInfo implements Serializable {
    private Double energy;

    private Double protein;

    private Double carbs;

    private Double fat;

    @ApiModelProperty("所有成分类型集合")
    private Set structureSet;

    @ApiModelProperty("蛋白质类型集合")
    private Set proteinSet;

    @ApiModelProperty("主食类型集合")
    private Set stapleFoodSet;

    @ApiModelProperty("水果蔬菜类型集合")
    private Set fruitVegetableSet;

    @ApiModelProperty("豆类类型集合")
    private Set beansSet;

    @ApiModelProperty("坚果类型集合")
    private Set nutsSet;

    @ApiModelProperty("优质蛋白")
    private Double goodProtein;

    @ApiModelProperty("动物性脂肪")
    private Double animalFat;

    private Double ca;

    private Double p;

    private Double k;

    private Double mg;

    private Double fe;

    private Double zn;

    private Double se;

    private Double cu;

    private Double na;

    private Double mn;

    private Double vitaminA;

    private Double vitaminB1;

    private Double vitaminB2;

    private Double vitaminB3;

    private Double vitaminC;

    private Double vitaminE;

    @ApiModelProperty("可溶性纤维素")
    private Double solubleFiber;

    @ApiModelProperty("不可溶纤维素")
    private Double insolubleFiber;

    public ElementInfo() {
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

    public Double getCarbs() {
        return carbs;
    }

    public void setCarbs(Double carbs) {
        this.carbs = carbs;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Set getStructureSet() {
        return structureSet;
    }

    public void setStructureSet(Set structureSet) {
        this.structureSet = structureSet;
    }

    public Set getProteinSet() {
        return proteinSet;
    }

    public void setProteinSet(Set proteinSet) {
        this.proteinSet = proteinSet;
    }

    public Set getStapleFoodSet() {
        return stapleFoodSet;
    }

    public void setStapleFoodSet(Set stapleFoodSet) {
        this.stapleFoodSet = stapleFoodSet;
    }

    public Set getFruitVegetableSet() {
        return fruitVegetableSet;
    }

    public void setFruitVegetableSet(Set fruitVegetableSet) {
        this.fruitVegetableSet = fruitVegetableSet;
    }

    public Set getBeansSet() {
        return beansSet;
    }

    public void setBeansSet(Set beansSet) {
        this.beansSet = beansSet;
    }

    public Set getNutsSet() {
        return nutsSet;
    }

    public void setNutsSet(Set nutsSet) {
        this.nutsSet = nutsSet;
    }

    public Double getGoodProtein() {
        return goodProtein;
    }

    public void setGoodProtein(Double goodProtein) {
        this.goodProtein = goodProtein;
    }

    public Double getAnimalFat() {
        return animalFat;
    }

    public void setAnimalFat(Double animalFat) {
        this.animalFat = animalFat;
    }

    public Double getCa() {
        return ca;
    }

    public void setCa(Double ca) {
        this.ca = ca;
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

    public Double getZn() {
        return zn;
    }

    public void setZn(Double zn) {
        this.zn = zn;
    }

    public Double getSe() {
        return se;
    }

    public void setSe(Double se) {
        this.se = se;
    }

    public Double getCu() {
        return cu;
    }

    public void setCu(Double cu) {
        this.cu = cu;
    }

    public Double getNa() {
        return na;
    }

    public void setNa(Double na) {
        this.na = na;
    }

    public Double getMn() {
        return mn;
    }

    public void setMn(Double mn) {
        this.mn = mn;
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

    @Override
    public String toString() {
        return "ElementInfo{" +
                "energy=" + energy +
                ", protein=" + protein +
                ", carbs=" + carbs +
                ", fat=" + fat +
                ", structureSet=" + structureSet +
                ", proteinSet=" + proteinSet +
                ", stapleFoodSet=" + stapleFoodSet +
                ", fruitVegetableSet=" + fruitVegetableSet +
                ", beansSet=" + beansSet +
                ", nutsSet=" + nutsSet +
                ", goodProtein=" + goodProtein +
                ", animalFat=" + animalFat +
                ", ca=" + ca +
                ", p=" + p +
                ", k=" + k +
                ", mg=" + mg +
                ", fe=" + fe +
                ", zn=" + zn +
                ", se=" + se +
                ", cu=" + cu +
                ", na=" + na +
                ", mn=" + mn +
                ", vitaminA=" + vitaminA +
                ", vitaminB1=" + vitaminB1 +
                ", vitaminB2=" + vitaminB2 +
                ", vitaminB3=" + vitaminB3 +
                ", vitaminC=" + vitaminC +
                ", vitaminE=" + vitaminE +
                ", solubleFiber=" + solubleFiber +
                ", insolubleFiber=" + insolubleFiber +
                '}';
    }
}
