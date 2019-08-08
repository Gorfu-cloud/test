package com.bkit.fatdown.dto.diet;

/**
 * @file: VitaminEvaluation
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 维生素摄入评价
 * @date: Created in 8/5/19  4:51 PM
 * @modified:
 * @version: 1.0
 */
public class VitaminEvaluation {
    private TotalEvaluation a;
    private TotalEvaluation b1;
    private TotalEvaluation b2;
    private TotalEvaluation b3;
    private TotalEvaluation c;
    private TotalEvaluation e;
    private double score;

    public VitaminEvaluation() {
        init();
    }

    private void init() {
        this.a = new TotalEvaluation();
        this.b1 = new TotalEvaluation();
        this.b2 = new TotalEvaluation();
        this.b3 = new TotalEvaluation();
        this.c = new TotalEvaluation();
        this.e = new TotalEvaluation();
    }

    public TotalEvaluation getA() {
        return a;
    }

    public void setA(TotalEvaluation a) {
        this.a = a;
    }

    public TotalEvaluation getB1() {
        return b1;
    }

    public void setB1(TotalEvaluation b1) {
        this.b1 = b1;
    }

    public TotalEvaluation getB2() {
        return b2;
    }

    public void setB2(TotalEvaluation b2) {
        this.b2 = b2;
    }

    public TotalEvaluation getB3() {
        return b3;
    }

    public void setB3(TotalEvaluation b3) {
        this.b3 = b3;
    }

    public TotalEvaluation getC() {
        return c;
    }

    public void setC(TotalEvaluation c) {
        this.c = c;
    }

    public TotalEvaluation getE() {
        return e;
    }

    public void setE(TotalEvaluation e) {
        this.e = e;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
