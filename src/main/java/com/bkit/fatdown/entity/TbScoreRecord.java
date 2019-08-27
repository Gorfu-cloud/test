package com.bkit.fatdown.entity;

import java.io.Serializable;

public class TbScoreRecord extends TbScoreRecordKey implements Serializable {
    private Double diet;

    private Double sport;

    private Double learn;

    private Double test;

    private Double active;

    private Double share;

    private Double total;

    private static final long serialVersionUID = 1L;

    public Double getDiet() {
        return diet;
    }

    public void setDiet(Double diet) {
        this.diet = diet;
    }

    public Double getSport() {
        return sport;
    }

    public void setSport(Double sport) {
        this.sport = sport;
    }

    public Double getLearn() {
        return learn;
    }

    public void setLearn(Double learn) {
        this.learn = learn;
    }

    public Double getTest() {
        return test;
    }

    public void setTest(Double test) {
        this.test = test;
    }

    public Double getActive() {
        return active;
    }

    public void setActive(Double active) {
        this.active = active;
    }

    public Double getShare() {
        return share;
    }

    public void setShare(Double share) {
        this.share = share;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", diet=").append(diet);
        sb.append(", sport=").append(sport);
        sb.append(", learn=").append(learn);
        sb.append(", test=").append(test);
        sb.append(", active=").append(active);
        sb.append(", share=").append(share);
        sb.append(", total=").append(total);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}