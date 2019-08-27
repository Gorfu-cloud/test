package com.bkit.fatdown.entity;

import java.io.Serializable;
import java.util.Date;

public class TbUserPrivacyInfo implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer height;

    private Integer weight;

    private Double bmi;

    private Double fatRate;

    private Integer bust;

    private Integer waist;

    private Integer hip;

    private Integer muscleOxygen;

    private Integer systolicBloodPressure;

    private Integer diastolicBloodPressure;

    private Integer bloodOxygen;

    private Integer heartRate;

    private Double bodyTemperature;

    private Double phUrine;

    private Integer ketonuria;

    private Double foreArm;

    private Double calf;

    private Double thign;

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

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public Double getFatRate() {
        return fatRate;
    }

    public void setFatRate(Double fatRate) {
        this.fatRate = fatRate;
    }

    public Integer getBust() {
        return bust;
    }

    public void setBust(Integer bust) {
        this.bust = bust;
    }

    public Integer getWaist() {
        return waist;
    }

    public void setWaist(Integer waist) {
        this.waist = waist;
    }

    public Integer getHip() {
        return hip;
    }

    public void setHip(Integer hip) {
        this.hip = hip;
    }

    public Integer getMuscleOxygen() {
        return muscleOxygen;
    }

    public void setMuscleOxygen(Integer muscleOxygen) {
        this.muscleOxygen = muscleOxygen;
    }

    public Integer getSystolicBloodPressure() {
        return systolicBloodPressure;
    }

    public void setSystolicBloodPressure(Integer systolicBloodPressure) {
        this.systolicBloodPressure = systolicBloodPressure;
    }

    public Integer getDiastolicBloodPressure() {
        return diastolicBloodPressure;
    }

    public void setDiastolicBloodPressure(Integer diastolicBloodPressure) {
        this.diastolicBloodPressure = diastolicBloodPressure;
    }

    public Integer getBloodOxygen() {
        return bloodOxygen;
    }

    public void setBloodOxygen(Integer bloodOxygen) {
        this.bloodOxygen = bloodOxygen;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public Double getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(Double bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public Double getPhUrine() {
        return phUrine;
    }

    public void setPhUrine(Double phUrine) {
        this.phUrine = phUrine;
    }

    public Integer getKetonuria() {
        return ketonuria;
    }

    public void setKetonuria(Integer ketonuria) {
        this.ketonuria = ketonuria;
    }

    public Double getForeArm() {
        return foreArm;
    }

    public void setForeArm(Double foreArm) {
        this.foreArm = foreArm;
    }

    public Double getCalf() {
        return calf;
    }

    public void setCalf(Double calf) {
        this.calf = calf;
    }

    public Double getThign() {
        return thign;
    }

    public void setThign(Double thign) {
        this.thign = thign;
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
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", bmi=").append(bmi);
        sb.append(", fatRate=").append(fatRate);
        sb.append(", bust=").append(bust);
        sb.append(", waist=").append(waist);
        sb.append(", hip=").append(hip);
        sb.append(", muscleOxygen=").append(muscleOxygen);
        sb.append(", systolicBloodPressure=").append(systolicBloodPressure);
        sb.append(", diastolicBloodPressure=").append(diastolicBloodPressure);
        sb.append(", bloodOxygen=").append(bloodOxygen);
        sb.append(", heartRate=").append(heartRate);
        sb.append(", bodyTemperature=").append(bodyTemperature);
        sb.append(", phUrine=").append(phUrine);
        sb.append(", ketonuria=").append(ketonuria);
        sb.append(", foreArm=").append(foreArm);
        sb.append(", calf=").append(calf);
        sb.append(", thign=").append(thign);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}