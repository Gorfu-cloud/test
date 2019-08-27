package com.bkit.fatdown.entity;

import java.io.Serializable;
import java.util.Date;

public class TbDietDailyReport implements Serializable {
    private Integer id;

    private Integer userId;

    private Double realEnergy;

    private Double lowerEnergy;

    private Double upperEnergy;

    private Integer energyEvaluation;

    private Integer structureEvaluation;

    private String structureLack;

    private Double proteinPer;

    private Double proteinLack;

    private Integer proteinEvaluation;

    private Double fatPer;

    private Double fatLack;

    private Integer fatEvaluation;

    private Double colPer;

    private Double colLack;

    private Integer colEvaluation;

    private Double fibrinPer;

    private Double fibrinLack;

    private Integer fibrinEvaluation;

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

    public Double getRealEnergy() {
        return realEnergy;
    }

    public void setRealEnergy(Double realEnergy) {
        this.realEnergy = realEnergy;
    }

    public Double getLowerEnergy() {
        return lowerEnergy;
    }

    public void setLowerEnergy(Double lowerEnergy) {
        this.lowerEnergy = lowerEnergy;
    }

    public Double getUpperEnergy() {
        return upperEnergy;
    }

    public void setUpperEnergy(Double upperEnergy) {
        this.upperEnergy = upperEnergy;
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

    public Double getProteinPer() {
        return proteinPer;
    }

    public void setProteinPer(Double proteinPer) {
        this.proteinPer = proteinPer;
    }

    public Double getProteinLack() {
        return proteinLack;
    }

    public void setProteinLack(Double proteinLack) {
        this.proteinLack = proteinLack;
    }

    public Integer getProteinEvaluation() {
        return proteinEvaluation;
    }

    public void setProteinEvaluation(Integer proteinEvaluation) {
        this.proteinEvaluation = proteinEvaluation;
    }

    public Double getFatPer() {
        return fatPer;
    }

    public void setFatPer(Double fatPer) {
        this.fatPer = fatPer;
    }

    public Double getFatLack() {
        return fatLack;
    }

    public void setFatLack(Double fatLack) {
        this.fatLack = fatLack;
    }

    public Integer getFatEvaluation() {
        return fatEvaluation;
    }

    public void setFatEvaluation(Integer fatEvaluation) {
        this.fatEvaluation = fatEvaluation;
    }

    public Double getColPer() {
        return colPer;
    }

    public void setColPer(Double colPer) {
        this.colPer = colPer;
    }

    public Double getColLack() {
        return colLack;
    }

    public void setColLack(Double colLack) {
        this.colLack = colLack;
    }

    public Integer getColEvaluation() {
        return colEvaluation;
    }

    public void setColEvaluation(Integer colEvaluation) {
        this.colEvaluation = colEvaluation;
    }

    public Double getFibrinPer() {
        return fibrinPer;
    }

    public void setFibrinPer(Double fibrinPer) {
        this.fibrinPer = fibrinPer;
    }

    public Double getFibrinLack() {
        return fibrinLack;
    }

    public void setFibrinLack(Double fibrinLack) {
        this.fibrinLack = fibrinLack;
    }

    public Integer getFibrinEvaluation() {
        return fibrinEvaluation;
    }

    public void setFibrinEvaluation(Integer fibrinEvaluation) {
        this.fibrinEvaluation = fibrinEvaluation;
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
        sb.append(", realEnergy=").append(realEnergy);
        sb.append(", lowerEnergy=").append(lowerEnergy);
        sb.append(", upperEnergy=").append(upperEnergy);
        sb.append(", energyEvaluation=").append(energyEvaluation);
        sb.append(", structureEvaluation=").append(structureEvaluation);
        sb.append(", structureLack=").append(structureLack);
        sb.append(", proteinPer=").append(proteinPer);
        sb.append(", proteinLack=").append(proteinLack);
        sb.append(", proteinEvaluation=").append(proteinEvaluation);
        sb.append(", fatPer=").append(fatPer);
        sb.append(", fatLack=").append(fatLack);
        sb.append(", fatEvaluation=").append(fatEvaluation);
        sb.append(", colPer=").append(colPer);
        sb.append(", colLack=").append(colLack);
        sb.append(", colEvaluation=").append(colEvaluation);
        sb.append(", fibrinPer=").append(fibrinPer);
        sb.append(", fibrinLack=").append(fibrinLack);
        sb.append(", fibrinEvaluation=").append(fibrinEvaluation);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}