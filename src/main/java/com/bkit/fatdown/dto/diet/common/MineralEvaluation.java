package com.bkit.fatdown.dto.diet.common;

/**
 * @file: MineralEvaluation
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 矿物质评价
 * @date: Created in 8/5/19  4:45 PM
 * @modified:
 * @version: 1.0
 */

public class MineralEvaluation {
    private Evaluation ca;
    private Evaluation p;
    private Evaluation k;
    private Evaluation mg;
    private Evaluation fe;
    private Evaluation zn;
    private Evaluation se;
    private Evaluation cu;
    private double score;

    public MineralEvaluation() {
        init();
    }

    private void init() {
        this.ca = new Evaluation();
        this.p = new Evaluation();
        this.k = new Evaluation();
        this.mg = new Evaluation();
        this.fe = new Evaluation();
        this.zn = new Evaluation();
        this.se = new Evaluation();
        this.cu = new Evaluation();
    }

    public Evaluation getCa() {
        return ca;
    }

    public void setCa(Evaluation ca) {
        this.ca = ca;
    }

    public Evaluation getP() {
        return p;
    }

    public void setP(Evaluation p) {
        this.p = p;
    }

    public Evaluation getK() {
        return k;
    }

    public void setK(Evaluation k) {
        this.k = k;
    }

    public Evaluation getMg() {
        return mg;
    }

    public void setMg(Evaluation mg) {
        this.mg = mg;
    }

    public Evaluation getFe() {
        return fe;
    }

    public void setFe(Evaluation fe) {
        this.fe = fe;
    }

    public Evaluation getZn() {
        return zn;
    }

    public void setZn(Evaluation zn) {
        this.zn = zn;
    }

    public Evaluation getSe() {
        return se;
    }

    public void setSe(Evaluation se) {
        this.se = se;
    }

    public Evaluation getCu() {
        return cu;
    }

    public void setCu(Evaluation cu) {
        this.cu = cu;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    /**
     * 生成平均分
     */
    public void generateScore() {
        double total = this.k.getScore() + this.fe.getScore() + this.se.getScore() + this.cu.getScore()
                + this.p.getScore() + this.mg.getScore() + this.ca.getScore() + this.zn.getScore();
        this.score = total / 8.0;
    }
}
