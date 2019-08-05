package com.bkit.fatdown.dto.diet;

/**
 * @file: MineralEvaluation
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 矿物质评价
 * @date: Created in 8/5/19  4:45 PM
 * @modified:
 * @version: 1.0
 */

public class MineralEvaluation {
    private TotalEvaluation ca;
    private TotalEvaluation p;
    private TotalEvaluation k;
    private TotalEvaluation mg;
    private TotalEvaluation fe;
    private TotalEvaluation zn;
    private TotalEvaluation se;
    private TotalEvaluation cu;

    public MineralEvaluation() {
        init();
    }

    private void init() {
        this.ca = new TotalEvaluation();
        this.p = new TotalEvaluation();
        this.k = new TotalEvaluation();
        this.mg = new TotalEvaluation();
        this.fe = new TotalEvaluation();
        this.zn = new TotalEvaluation();
        this.se = new TotalEvaluation();
        this.cu = new TotalEvaluation();
    }

    public TotalEvaluation getCa() {
        return ca;
    }

    public void setCa(TotalEvaluation ca) {
        this.ca = ca;
    }

    public TotalEvaluation getP() {
        return p;
    }

    public void setP(TotalEvaluation p) {
        this.p = p;
    }

    public TotalEvaluation getK() {
        return k;
    }

    public void setK(TotalEvaluation k) {
        this.k = k;
    }

    public TotalEvaluation getMg() {
        return mg;
    }

    public void setMg(TotalEvaluation mg) {
        this.mg = mg;
    }

    public TotalEvaluation getFe() {
        return fe;
    }

    public void setFe(TotalEvaluation fe) {
        this.fe = fe;
    }

    public TotalEvaluation getZn() {
        return zn;
    }

    public void setZn(TotalEvaluation zn) {
        this.zn = zn;
    }

    public TotalEvaluation getSe() {
        return se;
    }

    public void setSe(TotalEvaluation se) {
        this.se = se;
    }

    public TotalEvaluation getCu() {
        return cu;
    }

    public void setCu(TotalEvaluation cu) {
        this.cu = cu;
    }
}
