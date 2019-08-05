package com.bkit.fatdown.dto;

/**
 * @file: DietMonthReport
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 每月饮食评价
 * @date: Created in 8/5/19  10:20 AM
 * @modified:
 * @version: 1.0
 */
public class DietMonthReport extends DietWeeklyReport {

    /**
     * 矿物质评价
     */
    private double mineralCa;
    private int mineralCaEvaluation;
    private double mineralP;
    private int mineralPEvaluation;
    private double mineralK;
    private int mineralKEvaluation;
    private double mineralMg;
    private int mineralMgEvaluation;
    private double mineralFe;
    private int mineralFeEvaluation;
    private double mineralZn;
    private int mineralZnEvaluation;
    private double mineralSe;
    private int mineralSeEvaluation;
    private double mineralCu;
    private int mineralCuEvaluation;

    /**
     * 维生素评价
     */
    private double vitaminA;
    private int vitaminAEvaluation;
    private double vitaminB1;
    private int vitaminB1Evaluation;
    private double vitaminB2;
    private int vitaminB2Evaluation;
    private double vitaminB3;
    private int vitaminB3Evaluation;
    private double vitaminC;
    private int vitaminCEvaluation;
    private double vitaminE;
    private int vitaminEEvaluation;

    /**
     * 水溶性纤维，非水溶纤维
     */
    private double waterSolubleFibre;
    private int waterSolubleFibreEvaluation;
    private double nonWaterSolubleFibre;
    private int nonWaterSolubleFibreEvaluation;


    public DietMonthReport() {
        super();
        init();
    }

    @Override
    public void init() {
        super.init();
        // 矿物质
        this.mineralCa = 0.0;
        this.mineralCaEvaluation = 0;
        this.mineralCu = 0.0;
        this.mineralCuEvaluation = 0;
        this.mineralFe = 0.0;
        this.mineralFeEvaluation = 0;
        this.mineralK = 0.0;
        this.mineralKEvaluation = 0;
        this.mineralMg = 0.0;
        this.mineralMgEvaluation = 0;
        this.mineralP = 0.0;
        this.mineralPEvaluation = 0;
        this.mineralSe = 0.0;
        this.mineralSeEvaluation = 0;
        this.mineralZn = 0.0;
        this.mineralZnEvaluation = 0;
        // 维生素
        this.vitaminA = 0.0;
        this.vitaminAEvaluation = 0;
        this.vitaminB1 = 0.0;
        this.vitaminB1Evaluation = 0;
        this.vitaminB2 = 0.0;
        this.vitaminB2Evaluation = 0;
        this.vitaminB3 = 0.0;
        this.vitaminB3Evaluation = 0;
        this.vitaminC = 0.0;
        this.vitaminCEvaluation = 0;
        this.vitaminE = 0.0;
        this.vitaminEEvaluation = 0;

        // 可溶纤维素，不可溶纤维素
        this.waterSolubleFibre = 0.0;
        this.waterSolubleFibreEvaluation = 0;
        this.nonWaterSolubleFibre = 0.0;
        this.nonWaterSolubleFibreEvaluation = 0;

    }

    public double getMineralCa() {
        return mineralCa;
    }

    public void setMineralCa(double mineralCa) {
        this.mineralCa = mineralCa;
    }

    public int getMineralCaEvaluation() {
        return mineralCaEvaluation;
    }

    public void setMineralCaEvaluation(int mineralCaEvaluation) {
        this.mineralCaEvaluation = mineralCaEvaluation;
    }

    public double getMineralP() {
        return mineralP;
    }

    public void setMineralP(double mineralP) {
        this.mineralP = mineralP;
    }

    public int getMineralPEvaluation() {
        return mineralPEvaluation;
    }

    public void setMineralPEvaluation(int mineralPEvaluation) {
        this.mineralPEvaluation = mineralPEvaluation;
    }

    public double getMineralK() {
        return mineralK;
    }

    public void setMineralK(double mineralK) {
        this.mineralK = mineralK;
    }

    public int getMineralKEvaluation() {
        return mineralKEvaluation;
    }

    public void setMineralKEvaluation(int mineralKEvaluation) {
        this.mineralKEvaluation = mineralKEvaluation;
    }

    public double getMineralMg() {
        return mineralMg;
    }

    public void setMineralMg(double mineralMg) {
        this.mineralMg = mineralMg;
    }

    public int getMineralMgEvaluation() {
        return mineralMgEvaluation;
    }

    public void setMineralMgEvaluation(int mineralMgEvaluation) {
        this.mineralMgEvaluation = mineralMgEvaluation;
    }

    public double getMineralFe() {
        return mineralFe;
    }

    public void setMineralFe(double mineralFe) {
        this.mineralFe = mineralFe;
    }

    public int getMineralFeEvaluation() {
        return mineralFeEvaluation;
    }

    public void setMineralFeEvaluation(int mineralFeEvaluation) {
        this.mineralFeEvaluation = mineralFeEvaluation;
    }

    public double getMineralZn() {
        return mineralZn;
    }

    public void setMineralZn(double mineralZn) {
        this.mineralZn = mineralZn;
    }

    public int getMineralZnEvaluation() {
        return mineralZnEvaluation;
    }

    public void setMineralZnEvaluation(int mineralZnEvaluation) {
        this.mineralZnEvaluation = mineralZnEvaluation;
    }

    public double getMineralSe() {
        return mineralSe;
    }

    public void setMineralSe(double mineralSe) {
        this.mineralSe = mineralSe;
    }

    public int getMineralSeEvaluation() {
        return mineralSeEvaluation;
    }

    public void setMineralSeEvaluation(int mineralSeEvaluation) {
        this.mineralSeEvaluation = mineralSeEvaluation;
    }

    public double getMineralCu() {
        return mineralCu;
    }

    public void setMineralCu(double mineralCu) {
        this.mineralCu = mineralCu;
    }

    public int getMineralCuEvaluation() {
        return mineralCuEvaluation;
    }

    public void setMineralCuEvaluation(int mineralCuEvaluation) {
        this.mineralCuEvaluation = mineralCuEvaluation;
    }

    public double getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(double vitaminA) {
        this.vitaminA = vitaminA;
    }

    public int getVitaminAEvaluation() {
        return vitaminAEvaluation;
    }

    public void setVitaminAEvaluation(int vitaminAEvaluation) {
        this.vitaminAEvaluation = vitaminAEvaluation;
    }

    public double getVitaminB1() {
        return vitaminB1;
    }

    public void setVitaminB1(double vitaminB1) {
        this.vitaminB1 = vitaminB1;
    }

    public int getVitaminB1Evaluation() {
        return vitaminB1Evaluation;
    }

    public void setVitaminB1Evaluation(int vitaminB1Evaluation) {
        this.vitaminB1Evaluation = vitaminB1Evaluation;
    }

    public double getVitaminB2() {
        return vitaminB2;
    }

    public void setVitaminB2(double vitaminB2) {
        this.vitaminB2 = vitaminB2;
    }

    public int getVitaminB2Evaluation() {
        return vitaminB2Evaluation;
    }

    public void setVitaminB2Evaluation(int vitaminB2Evaluation) {
        this.vitaminB2Evaluation = vitaminB2Evaluation;
    }

    public double getVitaminB3() {
        return vitaminB3;
    }

    public void setVitaminB3(double vitaminB3) {
        this.vitaminB3 = vitaminB3;
    }

    public int getVitaminB3Evaluation() {
        return vitaminB3Evaluation;
    }

    public void setVitaminB3Evaluation(int vitaminB3Evaluation) {
        this.vitaminB3Evaluation = vitaminB3Evaluation;
    }

    public double getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(double vitaminC) {
        this.vitaminC = vitaminC;
    }

    public int getVitaminCEvaluation() {
        return vitaminCEvaluation;
    }

    public void setVitaminCEvaluation(int vitaminCEvaluation) {
        this.vitaminCEvaluation = vitaminCEvaluation;
    }

    public double getVitaminE() {
        return vitaminE;
    }

    public void setVitaminE(double vitaminE) {
        this.vitaminE = vitaminE;
    }

    public int getVitaminEEvaluation() {
        return vitaminEEvaluation;
    }

    public void setVitaminEEvaluation(int vitaminEEvaluation) {
        this.vitaminEEvaluation = vitaminEEvaluation;
    }

    public double getWaterSolubleFibre() {
        return waterSolubleFibre;
    }

    public void setWaterSolubleFibre(double waterSolubleFibre) {
        this.waterSolubleFibre = waterSolubleFibre;
    }

    public int getWaterSolubleFibreEvaluation() {
        return waterSolubleFibreEvaluation;
    }

    public void setWaterSolubleFibreEvaluation(int waterSolubleFibreEvaluation) {
        this.waterSolubleFibreEvaluation = waterSolubleFibreEvaluation;
    }

    public double getNonWaterSolubleFibre() {
        return nonWaterSolubleFibre;
    }

    public void setNonWaterSolubleFibre(double nonWaterSolubleFibre) {
        this.nonWaterSolubleFibre = nonWaterSolubleFibre;
    }

    public int getNonWaterSolubleFibreEvaluation() {
        return nonWaterSolubleFibreEvaluation;
    }

    public void setNonWaterSolubleFibreEvaluation(int nonWaterSolubleFibreEvaluation) {
        this.nonWaterSolubleFibreEvaluation = nonWaterSolubleFibreEvaluation;
    }
}
