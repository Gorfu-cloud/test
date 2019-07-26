package com.bkit.fatdown.utils;

import com.bkit.fatdown.dto.UserReportDTO;
import com.bkit.fatdown.entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @file: MathUtils
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 公式计算工具类
 * @date: Created in 2019/7/16 14:38
 * @modified:
 * @version: 1.0
 */

public class MathUtils {

    /**
     * 每日能量理论系数
     */
    private static final int WOMEN = 2;
    private static final Integer ENERGY_REDUCTION_MAN = 100;
    private static final Integer ENERGY_REDUCTION_WOMEN = 105;
    private static final Double MAX_WEIGHT_RATIO = 0.2;

    /**
     * 能量相关系数
     */
    private static final Integer OIL_ENERGY_MULTIPLIER = 9;
    private static final Double ENERGY_COEFFICIENT = 0.42;

    /**
     * 蛋白质相关系数
     */
    private static final Integer PROTEIN_REDUCTION = 105;
    private static final Double PROTEIN_COEFFICIENT = 1.2;

    /**
     * 维生素默认相关系数
     */
    private static final Double V_B1_MAN = 1.4;
    private static final Double V_B2_MAN = 1.4;
    private static final Double V_B1_WOMEN = 1.3;
    private static final Double V_B2_WOMEN = 1.2;

    /**
     * 矿物质
     */
    private static final Double FE_MAN = 15.0;
    private static final Double FE_WOMEN = 20.0;

    /**
     * 能量范围
     */
    private static final Double ENERGY_BREAKFAST_RATIONAL_UPPER = 0.33;
    private static final Double ENERGY_BREAKFAST_RATIONAL_LOWER = 0.28;
    private static final Double ENERGY_BREAKFAST_BAD_RATIONAL_UPPER = 0.40;
    private static final Double ENERGY_BREAKFAST_BAD_RATIONAL_LOWER = 0.20;

    private static final Double ENERGY_LUNCH_RATIONAL_UPPER = 0.43;
    private static final Double ENERGY_LUNCH_RATIONAL_LOWER = 0.38;
    private static final Double ENERGY_LUNCH_BAD_RATIONAL_UPPER = 0.50;
    private static final Double ENERGY_LUNCH_BAD_RATIONAL_LOWER = 0.30;

    private static final Double ENERGY_DINNER_RATIONAL_UPPER = 0.33;
    private static final Double ENERGY_DINNER_RATIONAL_LOWER = 0.28;
    private static final Double ENERGY_DINNER_BAD_RATIONAL_UPPER = 0.40;
    private static final Double ENERGY_DINNER_BAD_RATIONAL_LOWER = 0.20;

    private static final Integer EXCELLENT = 0;
    private static final Integer GOOD = 1;
    private static final Integer BAD = 2;

    /**
     * 结构评价:1,蛋白质，2，主食，3，蔬菜水果，4，坚果，5,豆类
     */
    private static final ArrayList<Integer> STRUCTURE_BREAKFAST = new ArrayList<>(Arrays.asList(1, 2, 3));
    private static final ArrayList<Integer> STRUCTURE_LUNCH = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    private static final ArrayList<Integer> STRUCTURE_DINNER = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

    /**
     * BMI=体重（千克）/（身高（米）*身高（米））
     *
     * @param height
     * @param weight
     * @return
     */
    public static double getBMI(int height, double weight) {
        return weight / Math.pow((height / 100.0), 2);
    }

    /**
     * 计算用户饮食标准
     *
     * @param basicInfo
     * @param privacyInfo
     * @param lifeStyle
     * @return
     */
    public static TbDietUserStandard getDietUserStandard(TbUserBasicInfo basicInfo, TbUserPrivacyInfo privacyInfo,
                                                         TbUserLifeStyle lifeStyle) {
        TbDietUserStandard userStandard = new TbDietUserStandard();
        userStandard.setId(basicInfo.getId());
        userStandard.setEnergy(getBasicEnergy(basicInfo.getGender(), privacyInfo.getHeight(), privacyInfo.getWeight()));
        // 饮食口味导致的标准
        userStandard.setOilEnergy(getOilEnergy(privacyInfo.getWeight(), lifeStyle.getDietaryHabit()));
        userStandard.setSaltyEnergy(getSaltyEnergy(privacyInfo.getWeight(), lifeStyle.getFoodTaste()));
        userStandard.setSpicyEnergy(getSpicyEnergy(privacyInfo.getWeight(), lifeStyle.getSpicyDegree()));
        userStandard.setProtein(getProtein(privacyInfo.getHeight()));

        if (basicInfo.getGender() == WOMEN) {
            userStandard.setVitaminB1(V_B1_WOMEN);
            userStandard.setVitaminB2(V_B2_WOMEN);
            userStandard.setFe(FE_WOMEN);
        } else {
            userStandard.setVitaminB1(V_B1_MAN);
            userStandard.setVitaminB2(V_B2_MAN);
            userStandard.setFe(FE_MAN);
        }

        return userStandard;
    }

    /**
     * 获取饮食评价
     *
     * @param userStandard
     * @param reportDTO
     * @param type
     * @return
     */
    public static UserReportDTO getDietReport(TbDietUserStandard userStandard, UserReportDTO reportDTO, Integer type) {
        // 一天总能量标准
        double energyStandard = (userStandard.getEnergy() + userStandard.getOilEnergy())
                + (userStandard.getSaltyEnergy() + userStandard.getSpicyEnergy());
        // 真实摄入
        double realEnergy = reportDTO.getRealEnergy();

        if (type == 0) {
            // 能量评价
            setEnergyEvaluation(reportDTO, energyStandard, realEnergy, ENERGY_BREAKFAST_RATIONAL_LOWER,
                    ENERGY_BREAKFAST_RATIONAL_UPPER, ENERGY_BREAKFAST_BAD_RATIONAL_UPPER, ENERGY_BREAKFAST_BAD_RATIONAL_LOWER);
            // 结构评价
            setStructureBreakEvaluation(reportDTO, STRUCTURE_BREAKFAST);
        } else if (type == 1) {
            // 能量评价
            setEnergyEvaluation(reportDTO, energyStandard, realEnergy, ENERGY_LUNCH_RATIONAL_LOWER,
                    ENERGY_LUNCH_RATIONAL_UPPER, ENERGY_LUNCH_BAD_RATIONAL_UPPER, ENERGY_LUNCH_BAD_RATIONAL_LOWER);
            // 结构评价
            setStructureBreakEvaluation(reportDTO, STRUCTURE_LUNCH);
        } else {
            // 能量评价
            setEnergyEvaluation(reportDTO, energyStandard, realEnergy, ENERGY_DINNER_RATIONAL_LOWER,
                    ENERGY_DINNER_RATIONAL_UPPER, ENERGY_DINNER_BAD_RATIONAL_UPPER, ENERGY_DINNER_BAD_RATIONAL_LOWER);
            // 结构评价
            setStructureBreakEvaluation(reportDTO, STRUCTURE_DINNER);
        }

        return reportDTO;
    }

    /**
     * 设置饮食评价
     *
     * @param reportDTO
     * @param energyStandard
     * @param realEnergy
     * @param energyDinnerRationalLower
     * @param energyDinnerRationalUpper
     * @param energyDinnerBadRationalUpper
     * @param energyDinnerBadRationalLower
     */
    private static void setEnergyEvaluation(UserReportDTO reportDTO, double energyStandard, double realEnergy,
                                            Double energyDinnerRationalLower, Double energyDinnerRationalUpper,
                                            Double energyDinnerBadRationalUpper, Double energyDinnerBadRationalLower) {
        // 设置合理范围
        reportDTO.setLowerEnergy(energyStandard * energyDinnerRationalLower);
        reportDTO.setUpperEnergy(energyStandard * energyDinnerRationalUpper);

        if (realEnergy > (energyStandard * energyDinnerBadRationalUpper)
                || realEnergy < (energyStandard * energyDinnerBadRationalLower)) {
            reportDTO.setEnergyEvaluation(BAD);
        } else if (realEnergy < (energyStandard * energyDinnerRationalLower)
                || realEnergy > (energyStandard * energyDinnerRationalUpper)) {
            reportDTO.setEnergyEvaluation(GOOD);
        } else {
            reportDTO.setEnergyEvaluation(EXCELLENT);
        }
    }

    /**
     * 进行结构评价
     *
     * @param reportDTO
     * @param structure
     */
    private static void setStructureBreakEvaluation(UserReportDTO reportDTO, ArrayList<Integer> structure) {
        structure.removeAll(reportDTO.getStructureLack());
        if (structure.size() == 0) {
            reportDTO.setStructureEvaluation(EXCELLENT);
        } else if (structure.size() == 1) {
            reportDTO.setStructureEvaluation(GOOD);
        } else {
            reportDTO.setStructureEvaluation(BAD);
        }
        Set<Integer> set = new TreeSet<>(structure);
        reportDTO.setStructureLack(set);
    }

    /**
     * 获取身高计算出的基础能量
     *
     * @param gender
     * @param height
     * @return
     */
    private static Double getBasicEnergy(Integer gender, Integer height, Integer weight) {
        if (gender == WOMEN) {
            return getDailyEnergy(ENERGY_REDUCTION_WOMEN, height, weight);
        } else {
            return getDailyEnergy(ENERGY_REDUCTION_MAN, height, weight);
        }
    }

    /**
     * 每日理论计算公式
     *
     * @param sexReduction
     * @param height
     * @param weight
     * @return
     */
    private static Double getDailyEnergy(int sexReduction, Integer height, Integer weight) {
        double weightRatio;
        int standardWeight = height - sexReduction;
        int x1 = Math.abs(weight - standardWeight);
        // 体重率x2，控制在+-20%内
        weightRatio = x1 / standardWeight;
        if (weightRatio > MAX_WEIGHT_RATIO) {
            weightRatio = MAX_WEIGHT_RATIO;
        }

        // 25kcal=千卡
        return standardWeight * (1 - weightRatio) * 25;
    }

    private static Double getOilEnergy(Integer weight, Double dietaryHabit) {
        Double oilEnergyFixedValue = (ENERGY_COEFFICIENT * weight) * OIL_ENERGY_MULTIPLIER;
        return oilEnergyFixedValue * dietaryHabit;
    }

    private static Double getSaltyEnergy(Integer weight, Integer foodTaste) {
        return (ENERGY_COEFFICIENT * weight) * foodTaste;
    }

    private static Double getSpicyEnergy(Integer weight, Integer spicyDegree) {
        return (ENERGY_COEFFICIENT * weight) * spicyDegree;
    }

    private static Double getProtein(Integer height) {
        return (height - PROTEIN_REDUCTION) * PROTEIN_COEFFICIENT;
    }

}
