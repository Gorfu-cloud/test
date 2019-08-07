package com.bkit.fatdown.dto.diet;

/**
 * @file: TotalEvaluation
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 百分比评价
 * @date: Created in 8/5/19  4:37 PM
 * @modified:
 * @version: 1.0
 */
public class TotalEvaluation {
    private double total;
    private Integer evaluation;

    public TotalEvaluation(double total, Integer evaluation) {
        init();
        this.total = total;
        this.evaluation = evaluation;
    }

    public TotalEvaluation() {
        init();
    }

    private void init() {
        this.total = 0.0;
        this.evaluation = 0;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Integer evaluation) {
        this.evaluation = evaluation;
    }
}
