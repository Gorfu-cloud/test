package com.bkit.fatdown.entity;

import java.io.Serializable;
import java.util.Date;

public class TbDietMealReport implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer type;

    private Double realEnergy;

    private Double upperEnergy;

    private Double lowerEnergy;

    private Integer energyEvaluation;

    private Integer structureEvaluation;

    private String structureLack;

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

    public Double getRealEnergy() {
        return realEnergy;
    }

    public void setRealEnergy(Double realEnergy) {
        this.realEnergy = realEnergy;
    }

    public Double getUpperEnergy() {
        return upperEnergy;
    }

    public void setUpperEnergy(Double upperEnergy) {
        this.upperEnergy = upperEnergy;
    }

    public Double getLowerEnergy() {
        return lowerEnergy;
    }

    public void setLowerEnergy(Double lowerEnergy) {
        this.lowerEnergy = lowerEnergy;
    }

    public Integer getEnergyEvaluation() {
        return energyEvaluation;
    }

    public void setEnergyEvaluation(Integer energyEvaluation) {
        this.energyEvaluation = energyEvaluation;
    }

    public Integer getStructureEvaluation() {
        return structureEvaluation;
    }

    public void setStructureEvaluation(Integer structureEvaluation) {
        this.structureEvaluation = structureEvaluation;
    }

    public String getStructureLack() {
        return structureLack;
    }

    public void setStructureLack(String structureLack) {
        this.structureLack = structureLack == null ? null : structureLack.trim();
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
        sb.append(", realEnergy=").append(realEnergy);
        sb.append(", upperEnergy=").append(upperEnergy);
        sb.append(", lowerEnergy=").append(lowerEnergy);
        sb.append(", energyEvaluation=").append(energyEvaluation);
        sb.append(", structureEvaluation=").append(structureEvaluation);
        sb.append(", structureLack=").append(structureLack);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}