package com.bkit.fatdown.dto.diet.common;

/**
 * @file: Evaluation
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 能量分配评价
 * @date: Created in 8/5/19  3:46 PM
 * @modified:
 * @version: 1.0
 */
public class Evaluation {
    private int excellent;
    private int good;
    private int ordinary;
    private double score;

    public Evaluation() {
        init();
    }

    public Evaluation(int excellent, int good, int ordinary, double score) {
        init();
        this.excellent = excellent;
        this.good = good;
        this.ordinary = ordinary;
        this.score = score;
    }

    public void init() {
        this.excellent = 0;
        this.good = 0;
        this.ordinary = 0;
        this.score = 0.0;
    }

    public int getExcellent() {
        return excellent;
    }

    public void setExcellent(int excellent) {
        this.excellent = excellent;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public int getOrdinary() {
        return ordinary;
    }

    public void setOrdinary(int ordinary) {
        this.ordinary = ordinary;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
