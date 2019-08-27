package com.bkit.fatdown.entity;

import java.io.Serializable;
import java.util.Date;

public class TbDietRecord implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer type;

    private Double energy;

    private Double protein;

    private Double carbs;

    private Double fat;

    private String structureSet;

    private String proteinSet;

    private String stapleFoodSet;

    private String fruitVegetableSet;

    private String beansSet;

    private String nutsSet;

    private Double goodProtein;

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

    private Double solubleFiber;

    private Double insolubleFiber;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getStructureSet() {
        return structureSet;
    }

    public void setStructureSet(String structureSet) {
        this.structureSet = structureSet == null ? null : structureSet.trim();
    }

    public String getProteinSet() {
        return proteinSet;
    }

    public void setProteinSet(String proteinSet) {
        this.proteinSet = proteinSet == null ? null : proteinSet.trim();
    }

    public String getStapleFoodSet() {
        return stapleFoodSet;
    }

    public void setStapleFoodSet(String stapleFoodSet) {
        this.stapleFoodSet = stapleFoodSet == null ? null : stapleFoodSet.trim();
    }

    public String getFruitVegetableSet() {
        return fruitVegetableSet;
    }

    public void setFruitVegetableSet(String fruitVegetableSet) {
        this.fruitVegetableSet = fruitVegetableSet == null ? null : fruitVegetableSet.trim();
    }

    public String getBeansSet() {
        return beansSet;
    }

    public void setBeansSet(String beansSet) {
        this.beansSet = beansSet == null ? null : beansSet.trim();
    }

    public String getNutsSet() {
        return nutsSet;
    }

    public void setNutsSet(String nutsSet) {
        this.nutsSet = nutsSet == null ? null : nutsSet.trim();
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
        sb.append(", type=").append(type);
        sb.append(", energy=").append(energy);
        sb.append(", protein=").append(protein);
        sb.append(", carbs=").append(carbs);
        sb.append(", fat=").append(fat);
        sb.append(", structureSet=").append(structureSet);
        sb.append(", proteinSet=").append(proteinSet);
        sb.append(", stapleFoodSet=").append(stapleFoodSet);
        sb.append(", fruitVegetableSet=").append(fruitVegetableSet);
        sb.append(", beansSet=").append(beansSet);
        sb.append(", nutsSet=").append(nutsSet);
        sb.append(", goodProtein=").append(goodProtein);
        sb.append(", animalFat=").append(animalFat);
        sb.append(", ca=").append(ca);
        sb.append(", p=").append(p);
        sb.append(", k=").append(k);
        sb.append(", mg=").append(mg);
        sb.append(", fe=").append(fe);
        sb.append(", zn=").append(zn);
        sb.append(", se=").append(se);
        sb.append(", cu=").append(cu);
        sb.append(", na=").append(na);
        sb.append(", mn=").append(mn);
        sb.append(", vitaminA=").append(vitaminA);
        sb.append(", vitaminB1=").append(vitaminB1);
        sb.append(", vitaminB2=").append(vitaminB2);
        sb.append(", vitaminB3=").append(vitaminB3);
        sb.append(", vitaminC=").append(vitaminC);
        sb.append(", vitaminE=").append(vitaminE);
        sb.append(", solubleFiber=").append(solubleFiber);
        sb.append(", insolubleFiber=").append(insolubleFiber);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}