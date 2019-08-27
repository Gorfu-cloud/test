package com.bkit.fatdown.entity;

import java.io.Serializable;
import java.util.Date;

public class TbDietUserStandard implements Serializable {
    private Integer id;

    private Double energy;

    private Double oilEnergy;

    private Double saltyEnergy;

    private Double spicyEnergy;

    private Double protein;

    private Double fat;

    private Double carbs;

    private Double insolubleFibre;

    private Double cholesterol;

    private Date gmtCreate;

    private Date gmtModified;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    public Double getOilEnergy() {
        return oilEnergy;
    }

    public void setOilEnergy(Double oilEnergy) {
        this.oilEnergy = oilEnergy;
    }

    public Double getSaltyEnergy() {
        return saltyEnergy;
    }

    public void setSaltyEnergy(Double saltyEnergy) {
        this.saltyEnergy = saltyEnergy;
    }

    public Double getSpicyEnergy() {
        return spicyEnergy;
    }

    public void setSpicyEnergy(Double spicyEnergy) {
        this.spicyEnergy = spicyEnergy;
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

    public Double getInsolubleFibre() {
        return insolubleFibre;
    }

    public void setInsolubleFibre(Double insolubleFibre) {
        this.insolubleFibre = insolubleFibre;
    }

    public Double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(Double cholesterol) {
        this.cholesterol = cholesterol;
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
        sb.append(", energy=").append(energy);
        sb.append(", oilEnergy=").append(oilEnergy);
        sb.append(", saltyEnergy=").append(saltyEnergy);
        sb.append(", spicyEnergy=").append(spicyEnergy);
        sb.append(", protein=").append(protein);
        sb.append(", fat=").append(fat);
        sb.append(", carbs=").append(carbs);
        sb.append(", insolubleFibre=").append(insolubleFibre);
        sb.append(", cholesterol=").append(cholesterol);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}