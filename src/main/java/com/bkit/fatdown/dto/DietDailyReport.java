package com.bkit.fatdown.dto;

/**
 * @file: DietDailyReport
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 每天饮食评价传输对象
 * @date: Created in 7/30/19  8:41 PM
 * @modified:
 * @version: 1.0
 */
public class DietDailyReport extends DietMealReport {
    /**
     * 营养素评价: 0,合适，1,较合理，2,不合理
     */
    private Integer colEvaluation;
    private Integer fatEvaluation;
    private Integer fibrinEvaluation;
    private Integer proteinEvaluation;
    /**
     * 营养素百分比
     */
    private Double colPer;
    private Double fatPer;
    private Double fibrinPer;
    private Double proteinPer;
    /**
     * 缺乏或多的数量：0，合适，1，多，2,少
     */
    private Double colLack;
    private Double fatLack;
    private Double fibrinLack;
    private Double proteinLack;

    public DietDailyReport() {
        super();
        init();
    }

    private void init() {
        this.colPer = 0.0;
        this.fatPer = 0.0;
        this.fibrinPer = 0.0;
        this.proteinPer = 0.0;

        this.colEvaluation = 0;
        this.fatEvaluation = 0;
        this.fibrinEvaluation = 0;
        this.proteinEvaluation = 0;

        this.colLack = 0.0;
        this.fatLack = 0.0;
        this.fibrinLack = 0.0;
        this.proteinLack = 0.0;
    }

    public Integer getColEvaluation() {
        return colEvaluation;
    }

    public void setColEvaluation(Integer colEvaluation) {
        this.colEvaluation = colEvaluation;
    }

    public Integer getFatEvaluation() {
        return fatEvaluation;
    }

    public void setFatEvaluation(Integer fatEvaluation) {
        this.fatEvaluation = fatEvaluation;
    }

    public Integer getFibrinEvaluation() {
        return fibrinEvaluation;
    }

    public void setFibrinEvaluation(Integer fibrinEvaluation) {
        this.fibrinEvaluation = fibrinEvaluation;
    }

    public Integer getProteinEvaluation() {
        return proteinEvaluation;
    }

    public void setProteinEvaluation(Integer proteinEvaluation) {
        this.proteinEvaluation = proteinEvaluation;
    }

    public Double getColPer() {
        return colPer;
    }

    public void setColPer(Double colPer) {
        this.colPer = colPer;
    }

    public Double getFatPer() {
        return fatPer;
    }

    public void setFatPer(Double fatPer) {
        this.fatPer = fatPer;
    }

    public Double getFibrinPer() {
        return fibrinPer;
    }

    public void setFibrinPer(Double fibrinPer) {
        this.fibrinPer = fibrinPer;
    }

    public Double getProteinPer() {
        return proteinPer;
    }

    public void setProteinPer(Double proteinPer) {
        this.proteinPer = proteinPer;
    }

    public Double getColLack() {
        return colLack;
    }

    public void setColLack(Double colLack) {
        this.colLack = colLack;
    }

    public Double getFatLack() {
        return fatLack;
    }

    public void setFatLack(Double fatLack) {
        this.fatLack = fatLack;
    }

    public Double getFibrinLack() {
        return fibrinLack;
    }

    public void setFibrinLack(Double fibrinLack) {
        this.fibrinLack = fibrinLack;
    }

    public Double getProteinLack() {
        return proteinLack;
    }

    public void setProteinLack(Double proteinLack) {
        this.proteinLack = proteinLack;
    }
}
