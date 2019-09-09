package com.bkit.fatdown.dto.diet.common;

/**
 * @file: VitaminEvaluation
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 维生素摄入评价
 * @date: Created in 8/5/19  4:51 PM
 * @modified:
 * @version: 1.0
 */
public class VitaminEvaluation {
    private Evaluation a;
    private Evaluation b1;
    private Evaluation b2;
    private Evaluation b3;
    private Evaluation c;
    private Evaluation e;
    private double score;

    /**
     * 生成平均分
     */
    public void generateScore() {
        double total = this.a.getScore() + this.b1.getScore() + this.b2.getScore()
                + this.b3.getScore() + this.c.getScore() + this.e.getScore();
        this.score = total / 6.0;
    }

    public VitaminEvaluation() {
        init();
    }

    private void init() {
        this.a = new Evaluation();
        this.b1 = new Evaluation();
        this.b2 = new Evaluation();
        this.b3 = new Evaluation();
        this.c = new Evaluation();
        this.e = new Evaluation();
    }

    public Evaluation getA() {
        return a;
    }

    public void setA(Evaluation a) {
        this.a = a;
    }

    public Evaluation getB1() {
        return b1;
    }

    public void setB1(Evaluation b1) {
        this.b1 = b1;
    }

    public Evaluation getB2() {
        return b2;
    }

    public void setB2(Evaluation b2) {
        this.b2 = b2;
    }

    public Evaluation getB3() {
        return b3;
    }

    public void setB3(Evaluation b3) {
        this.b3 = b3;
    }

    public Evaluation getC() {
        return c;
    }

    public void setC(Evaluation c) {
        this.c = c;
    }

    public Evaluation getE() {
        return e;
    }

    public void setE(Evaluation e) {
        this.e = e;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
