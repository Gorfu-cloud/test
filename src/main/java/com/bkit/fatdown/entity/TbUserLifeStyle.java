package com.bkit.fatdown.entity;

import java.io.Serializable;
import java.util.Date;

public class TbUserLifeStyle implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer labourIntensity;

    private Double dietaryHabit;

    private Integer foodTaste;

    private Integer spicyDegree;

    private Integer userType;

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

    public Integer getLabourIntensity() {
        return labourIntensity;
    }

    public void setLabourIntensity(Integer labourIntensity) {
        this.labourIntensity = labourIntensity;
    }

    public Double getDietaryHabit() {
        return dietaryHabit;
    }

    public void setDietaryHabit(Double dietaryHabit) {
        this.dietaryHabit = dietaryHabit;
    }

    public Integer getFoodTaste() {
        return foodTaste;
    }

    public void setFoodTaste(Integer foodTaste) {
        this.foodTaste = foodTaste;
    }

    public Integer getSpicyDegree() {
        return spicyDegree;
    }

    public void setSpicyDegree(Integer spicyDegree) {
        this.spicyDegree = spicyDegree;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
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
        sb.append(", labourIntensity=").append(labourIntensity);
        sb.append(", dietaryHabit=").append(dietaryHabit);
        sb.append(", foodTaste=").append(foodTaste);
        sb.append(", spicyDegree=").append(spicyDegree);
        sb.append(", userType=").append(userType);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}