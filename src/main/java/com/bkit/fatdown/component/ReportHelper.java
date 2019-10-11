package com.bkit.fatdown.component;

import com.bkit.fatdown.common.utils.DataTransferUtils;
import com.bkit.fatdown.dto.diet.DietDailyReport;
import com.bkit.fatdown.dto.diet.DietMealReport;
import com.bkit.fatdown.dto.diet.DietMonthReport;
import com.bkit.fatdown.dto.diet.DietWeeklyReport;
import com.bkit.fatdown.dto.diet.common.*;
import com.bkit.fatdown.entity.*;

import java.util.*;

/**
 * @file: ReportHelper
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 公式计算工具类
 * @date: Created in 2019/7/16 14:38
 * @modified:
 * @version: 1.0
 */

public class ReportHelper {
    /**
     * 评价类型：0早餐，1午餐，2晚餐，3加餐，4每天，5每周，6每月
     */
    private static final int BREAKFAST = 0;
    private static final int LUNCH = 1;
    private static final int DINNER = 2;
    private static final int DAILY = 4;
//    private static final int WEEKLY = 5;
//    private static final int MOUTH = 6;

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
     * 每天不可溶纤维标准，每kg体重
     */
    private static final Double INSOLUBLE_FIBRE_DAILY = 0.40;

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

    private static final Double ENERGY_DAILY_RATIONAL_UPPER = 1.05;
    private static final Double ENERGY_DAILY_RATIONAL_LOWER = 0.95;
    private static final Double ENERGY_DAILY_BAD_RATIONAL_UPPER = 1.10;
    private static final Double ENERGY_DAILY_BAD_RATIONAL_LOWER = 0.90;

    private static final Double ENERGY_WEEKLY_SO_BAD_LOWER = 0.70;
    private static final Double ENERGY_WEEKLY_SO_BAD_UPPER = 1.20;
    private static final Double ENERGY_WEEKLY_BAD_LOWER = 0.80;
    private static final Double ENERGY_WEEKLY_BAD_UPPER = 1.10;
    private static final Double ENERGY_WEEKLY_GOOD_LOWER = 0.90;
    private static final Double ENERGY_WEEKLY_GOOD_UPPER = 1.00;

    private static final Integer EXCELLENT = 0;
    private static final Integer GOOD = 1;
    private static final Integer BAD = 2;
    private static final Integer SO_BAD = 3;

    /**
     * 结构评价:1,蛋白质，2，主食，3，蔬菜水果，4，坚果，5,豆类
     */
    private static final ArrayList<Integer> STRUCTURE_BREAKFAST = new ArrayList<>(Arrays.asList(1, 2, 3));
    private static final ArrayList<Integer> STRUCTURE_LUNCH = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    private static final ArrayList<Integer> STRUCTURE_DINNER = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    private static final ArrayList<Integer> STRUCTURE_DAILY = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

    /**
     * 每天营养素评价
     */
    private static final Double DAILY_PROTEIN_MORE = 0.35;
    private static final Double DAILY_PROTEIN_LITTLE = 0.25;

    private static final Double DAILY_FAT_MORE = 0.35;
    private static final Double DAILY_FAT_LITTLE = 0.25;

    private static final Double DAILY_COL_MORE = 0.40;
    private static final Double DAILY_COL_LITTLE = 0.20;

    private static final Double DAILY_FIBRIN_GOOD_UPPER = 1.125;
    private static final Double DAILY_FIBRIN_GOOD_LOWER = 0.875;

    private static final Double GOOD_PROTEIN_GOOD = 0.50;
    private static final Double GOOD_PROTEIN_BAD = 0.30;

    private static final Double ANIMAL_FAT_GOOD = 0.50;
    private static final Double ANIMAL_FAT_BAD = 0.60;

    private static final Integer PROTEIN_ENERGY_OF_1G = 9;
    private static final Integer FAT_ENERGY_OF_1G = 9;
    private static final Integer COL_ENERGY_OF_1G = 9;

    private static final Integer PER_BASE = 100;

    /**
     * 每天矿物质评价,单位 mg
     */
    private static final Integer DAILY_CA_GOOD_UP = 1000;
    private static final Integer DAILY_CA_GOOD_DOWN = 600;
    private static final Integer DAILY_CA_BAD_UP = 1500;
    private static final Integer DAILY_CA_BAD_DOWN = 400;

    private static final Integer DAILY_P_GOOD_UP = 900;
    private static final Integer DAILY_P_GOOD_DOWN = 500;
    private static final Integer DAILY_P_BAD_UP = 2000;
    private static final Integer DAILY_P_BAD_DOWN = 200;

    private static final Integer DAILY_K_GOOD_UP = 2300;
    private static final Integer DAILY_K_GOOD_DOWN = 1700;
    private static final Integer DAILY_K_BAD_UP = 3000;
    private static final Integer DAILY_K_BAD_DOWN = 1000;

    private static final Integer DAILY_MG_GOOD_UP = 400;
    private static final Integer DAILY_MG_GOOD_DOWN = 300;
    private static final Integer DAILY_MG_BAD_UP = 600;
    private static final Integer DAILY_MG_BAD_DOWN = 150;

    private static final Integer DAILY_FE_GOOD_UP = 25;
    private static final Integer DAILY_FE_GOOD_DOWN = 10;
    private static final Integer DAILY_FE_BAD_UP = 40;
    private static final Integer DAILY_FE_BAD_DOWN = 5;

    private static final Integer DAILY_ZN_GOOD_UP = 20;
    private static final Integer DAILY_ZN_GOOD_DOWN = 10;
    private static final Integer DAILY_ZN_BAD_UP = 30;
    private static final Integer DAILY_ZN_BAD_DOWN = 5;

    // Se单位是 ug
    private static final Integer DAILY_SE_GOOD_UP = 75;
    private static final Integer DAILY_SE_GOOD_DOWN = 40;
    private static final Integer DAILY_SE_BAD_UP = 120;
    private static final Integer DAILY_SE_BAD_DOWN = 15;

    private static final Double DAILY_CU_GOOD_UP = 3.0;
    private static final Double DAILY_CU_GOOD_DOWN = 1.0;
    private static final Double DAILY_CU_BAD_UP = 5.0;
    private static final Double DAILY_CU_BAD_DOWN = 0.5;

    /**
     * 每天维生素摄入标准
     */
    private static final Double DAILY_VITAMIN_A_GOOD_UP = 900.0;
    private static final Double DAILY_VITAMIN_A_GOOD_DOWN = 600.0;
    private static final Double DAILY_VITAMIN_A_BAD_UP = 1500.0;
    private static final Double DAILY_VITAMIN_A_BAD_DOWN = 300.0;

    private static final Double DAILY_VITAMIN_B1_GOOD_UP = 1.5;
    private static final Double DAILY_VITAMIN_B1_GOOD_DOWN = 1.2;
    private static final Double DAILY_VITAMIN_B1_BAD_UP = 1.8;
    private static final Double DAILY_VITAMIN_B1_BAD_DOWN = 0.9;

    private static final Double DAILY_VITAMIN_B2_GOOD_UP = 1.5;
    private static final Double DAILY_VITAMIN_B2_GOOD_DOWN = 1.1;
    private static final Double DAILY_VITAMIN_B2_BAD_UP = 1.8;
    private static final Double DAILY_VITAMIN_B2_BAD_DOWN = 0.8;

    private static final Double DAILY_VITAMIN_B3_GOOD_UP = 1.5;
    private static final Double DAILY_VITAMIN_B3_GOOD_DOWN = 1.2;
    private static final Double DAILY_VITAMIN_B3_BAD_UP = 1.8;
    private static final Double DAILY_VITAMIN_B3_BAD_DOWN = 0.9;

    private static final Double DAILY_VITAMIN_C_GOOD_UP = 150.0;
    private static final Double DAILY_VITAMIN_C_GOOD_DOWN = 80.0;
    private static final Double DAILY_VITAMIN_C_BAD_UP = 300.0;
    private static final Double DAILY_VITAMIN_C_BAD_DOWN = 40.0;

    private static final Double DAILY_VITAMIN_E_GOOD_UP = 30.0;
    private static final Double DAILY_VITAMIN_E_GOOD_DOWN = 10.0;
    private static final Double DAILY_VITAMIN_E_BAD_UP = 100.0;
    private static final Double DAILY_VITAMIN_E_BAD_DOWN = 5.0;

    /**
     * 周种类均衡评价
     */
    private static final Integer WEEKLY_PROTEIN_GOOD = 5;
    private static final Integer WEEKLY_PROTEIN_BAD = 4;

    private static final Integer WEEKLY_STAPLE_FOOD_GOOD = 4;
    private static final Integer WEEKLY_STAPLE_FOOD_BAD = 3;

    private static final Integer WEEKLY_FRUIT_VEGETABLE_GOOD = 10;
    private static final Integer WEEKLY_FRUIT_VEGETABLE_BAD = 7;

    private static final Integer WEEKLY_NUT_BEAN_GOOD = 5;
    private static final Integer WEEKLY_NUT_BEAN_BAD = 4;

    private static final Integer WEEKLY_TOTAL_GOOD = 25;
    private static final Integer WEEKLY_TOTAL_BAD = 18;

    /**
     * 月种类均衡评价
     */
    private static final Integer MONTH_PROTEIN_GOOD = 7;
    private static final Integer MONTH_PROTEIN_BAD = 5;

    private static final Integer MONTH_STAPLE_FOOD_GOOD = 4;
    private static final Integer MONTH_STAPLE_FOOD_BAD = 3;

    private static final Integer MONTH_FRUIT_VEGETABLE_GOOD = 14;
    private static final Integer MONTH_FRUIT_VEGETABLE_BAD = 10;

    private static final Integer MONTH_NUT_BEAN_GOOD = 5;
    private static final Integer MONTH_NUT_BEAN_BAD = 4;

    private static final Integer MONTH_TOTAL_GOOD = 30;
    private static final Integer MONTH_TOTAL_BAD = 23;

    private static final int WEEKLY_EXCELLENT_SCORE = 20;
    private static final int WEEKLY_GOOD_SCORE = 15;
    private static final int WEEKLY_ORDINARY_SCORE = 10;
    private static final int WEEKLY_BAD_SCORE = 0;

    private static final int MONTH_EXCELLENT_SCORE = 5;
    private static final int MONTH_GOOD_SCORE = 4;
    private static final int MONTH_ORDINARY_SCORE = 3;
    private static final int MONTH_BAD_SCORE = 0;

    /**
     * BMI=体重（千克）/（身高（米）*身高（米））
     *
     * @param height 身高
     * @param weight 体重
     * @return 返回BMI
     */
    public static double getBMI(int height, double weight) {
        return weight / Math.pow((height / 100.0), 2);
    }

    /**
     * 计算用户饮食标准
     *
     * @param basicInfo   用户基础信息，性别
     * @param privacyInfo 用户隐私信息
     * @param lifeStyle   用户生活习惯
     * @return 饮食标准
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
        userStandard.setInsolubleFibre(getInsolubleFibre(privacyInfo.getWeight()));
        return userStandard;
    }

    /**
     * 获取每餐饮食评价
     *
     * @param userStandard 饮食标准
     * @param dietRecord   饮食总量
     * @param type         饮食类型：0早餐，1午餐，2晚餐
     * @return 每餐饮食评价
     */
    public static DietMealReport getDietMealReport(TbDietUserStandard userStandard, TbDietRecord dietRecord, Integer type) {
        // 一天总能量标准
        double energyStandard = (userStandard.getEnergy() + userStandard.getOilEnergy())
                + (userStandard.getSaltyEnergy() + userStandard.getSpicyEnergy());
        // 真实摄入
        double realEnergy = dietRecord.getEnergy();

        DietMealReport mealReport = new DietMealReport();
        mealReport.setRealEnergy(realEnergy);
        if (type == BREAKFAST) {
            // 能量评价
            setEnergyEvaluation(mealReport, energyStandard, realEnergy, ENERGY_BREAKFAST_RATIONAL_LOWER,
                    ENERGY_BREAKFAST_RATIONAL_UPPER, ENERGY_BREAKFAST_BAD_RATIONAL_UPPER, ENERGY_BREAKFAST_BAD_RATIONAL_LOWER);
            // 结构评价
            setStructureBreakEvaluation(mealReport, dietRecord, STRUCTURE_BREAKFAST);
        } else if (type == LUNCH) {
            // 能量评价
            setEnergyEvaluation(mealReport, energyStandard, realEnergy, ENERGY_LUNCH_RATIONAL_LOWER,
                    ENERGY_LUNCH_RATIONAL_UPPER, ENERGY_LUNCH_BAD_RATIONAL_UPPER, ENERGY_LUNCH_BAD_RATIONAL_LOWER);
            // 结构评价
            setStructureBreakEvaluation(mealReport, dietRecord, STRUCTURE_LUNCH);
        } else if (type == DINNER) {
            // 能量评价
            setEnergyEvaluation(mealReport, energyStandard, realEnergy, ENERGY_DINNER_RATIONAL_LOWER,
                    ENERGY_DINNER_RATIONAL_UPPER, ENERGY_DINNER_BAD_RATIONAL_UPPER, ENERGY_DINNER_BAD_RATIONAL_LOWER);
            // 结构评价
            setStructureBreakEvaluation(mealReport, dietRecord, STRUCTURE_DINNER);
        }

        return mealReport;
    }

    /**
     * 获取每天饮食评价
     *
     * @param userStandard 饮食标准
     * @param dietRecord   饮食总量
     * @return 每餐饮食评价
     */
    public static DietDailyReport getDietDailyReport(TbDietUserStandard userStandard, TbDietRecord dietRecord) {
        DietDailyReport dailyReport = new DietDailyReport();
        // 一天总能量标准
        double energyStandard = (userStandard.getEnergy() + userStandard.getOilEnergy())
                + (userStandard.getSaltyEnergy() + userStandard.getSpicyEnergy());
        // 真实摄入
        double realEnergy = dietRecord.getEnergy();
        dailyReport.setRealEnergy(realEnergy);

        // 能量评价
        setEnergyEvaluation(dailyReport, energyStandard, realEnergy, ENERGY_DAILY_RATIONAL_LOWER,
                ENERGY_DAILY_RATIONAL_UPPER, ENERGY_DAILY_BAD_RATIONAL_UPPER, ENERGY_DAILY_BAD_RATIONAL_LOWER);
        // 结构评价
        setStructureBreakEvaluation(dailyReport, dietRecord, STRUCTURE_DAILY);

        // 营养素评价
        setNutrientEvaluation(dailyReport, dietRecord, energyStandard, userStandard.getInsolubleFibre());

        return dailyReport;
    }

    public static DietWeeklyReport getDietWeeklyReport(TbDietUserStandard userStandard, TbDietRecord dietRecord,
                                                       List<TbDietDailyReport> dailyReportList) {
        DietWeeklyReport weeklyReport = new DietWeeklyReport();
        // 一天总能量标准
        double energyStandard = (userStandard.getEnergy() + userStandard.getOilEnergy())
                + (userStandard.getSaltyEnergy() + userStandard.getSpicyEnergy());
        // 每天能量评价统计
        EnergyEvaluation energyEvaluation = setEnergyEvaluation(dailyReportList, energyStandard, "weekly");
        weeklyReport.setEnergyEvaluation(energyEvaluation);
        // 种类均衡评价
        setSpeciesEvaluation(weeklyReport.getSpeciesEvaluation(), dietRecord, WEEKLY_TOTAL_GOOD, WEEKLY_TOTAL_BAD, WEEKLY_PROTEIN_GOOD, WEEKLY_PROTEIN_BAD,
                WEEKLY_STAPLE_FOOD_GOOD, WEEKLY_STAPLE_FOOD_BAD, WEEKLY_FRUIT_VEGETABLE_GOOD, WEEKLY_FRUIT_VEGETABLE_BAD, WEEKLY_NUT_BEAN_GOOD, WEEKLY_NUT_BEAN_BAD);
        // 每周营养素评价,优质蛋白质，动物性脂肪
        setWeeklyNutrientEvaluation(weeklyReport.getWeeklyNutrientsEvaluation(), dietRecord);

        return weeklyReport;
    }

    public static DietMonthReport getDietMonthReport(TbDietUserStandard userStandard, TbDietRecord dietRecord, List<TbDietDailyReport> dailyReportList, List<TbDietRecord> recordList) {
        DietMonthReport monthReport = new DietMonthReport();

        double energyStandard = (userStandard.getEnergy() + userStandard.getOilEnergy()) + (userStandard.getSaltyEnergy() + userStandard.getSpicyEnergy());

        // 每天能量评价统计
        EnergyEvaluation energyEvaluation = setEnergyEvaluation(dailyReportList, energyStandard, "month");
        monthReport.setEnergyEvaluation(energyEvaluation);

        setSpeciesEvaluation(monthReport.getSpeciesEvaluation(), dietRecord, MONTH_TOTAL_GOOD, MONTH_TOTAL_BAD, MONTH_PROTEIN_GOOD, MONTH_PROTEIN_BAD,
                MONTH_STAPLE_FOOD_GOOD, MONTH_STAPLE_FOOD_BAD, MONTH_FRUIT_VEGETABLE_GOOD, MONTH_FRUIT_VEGETABLE_BAD, MONTH_NUT_BEAN_GOOD, MONTH_NUT_BEAN_BAD);

        // 设置优质蛋白和动物性脂肪
        setWeeklyNutrientEvaluation(monthReport.getWeeklyNutrientsEvaluation(), dietRecord);

        setVitaminEvaluation(monthReport.getVitaminEvaluation(), recordList);

        setMineralsEvaluation(monthReport.getMineralEvaluation(), recordList);

        return monthReport;
    }

    /**
     * 统计每天能量评价
     *
     * @param reportList     每天饮食报告
     * @param energyStandard 能量标准
     * @return 能量评价
     */
    private static EnergyEvaluation setEnergyEvaluation(List<TbDietDailyReport> reportList, double energyStandard, String type) {
        int excellentTotal = 0, goodTotal = 0, ordinaryTotal = 0, badTotal = 0;

        for (TbDietDailyReport report : reportList) {
            double energyPer = report.getRealEnergy() / energyStandard;
            if (energyPer > ENERGY_WEEKLY_SO_BAD_UPPER || energyPer < ENERGY_WEEKLY_SO_BAD_LOWER) {
                badTotal += 1;
            } else if (energyPer > ENERGY_WEEKLY_BAD_UPPER || energyPer < ENERGY_WEEKLY_BAD_LOWER) {
                ordinaryTotal += 1;
            } else if (energyPer > ENERGY_WEEKLY_GOOD_UPPER || energyPer < ENERGY_WEEKLY_GOOD_LOWER) {
                goodTotal += 1;
            } else {
                excellentTotal += 1;
            }
        }

        double score = 0;
        if ("weekly".equals(type)) {
            score = getWeeklyScore(excellentTotal, goodTotal, ordinaryTotal, badTotal);
        } else {
            score = getMonthScore(excellentTotal, goodTotal, ordinaryTotal, badTotal);
        }

        return new EnergyEvaluation(excellentTotal, goodTotal, ordinaryTotal, badTotal, score);
    }

    /**
     * 设置三餐，每天饮食能量评价
     *
     * @param report                       饮食报告传输对象
     * @param energyStandard               能量标准
     * @param realEnergy                   真实摄入量
     * @param energyDinnerRationalLower    合适标准下限
     * @param energyDinnerRationalUpper    合适标准上限
     * @param energyDinnerBadRationalUpper 超标上限
     * @param energyDinnerBadRationalLower 超标下限
     */
    private static void setEnergyEvaluation(DietMealReport report, double energyStandard, double realEnergy,
                                            Double energyDinnerRationalLower, Double energyDinnerRationalUpper,
                                            Double energyDinnerBadRationalUpper, Double energyDinnerBadRationalLower) {
        // 设置合理范围
        report.setLowerEnergy(energyStandard * energyDinnerRationalLower);
        report.setUpperEnergy(energyStandard * energyDinnerRationalUpper);

        if (realEnergy > (energyStandard * energyDinnerBadRationalUpper)
                || realEnergy < (energyStandard * energyDinnerBadRationalLower)) {
            report.setEnergyEvaluation(BAD);
        } else if (realEnergy < (energyStandard * energyDinnerRationalLower)
                || realEnergy > (energyStandard * energyDinnerRationalUpper)) {
            report.setEnergyEvaluation(GOOD);
        } else {
            report.setEnergyEvaluation(EXCELLENT);
        }
    }

    /**
     * 进行结构评价
     *
     * @param report    饮食报告
     * @param structure 结构标准
     */
    private static void setStructureBreakEvaluation(DietMealReport report, TbDietRecord record, ArrayList<Integer> structure) {
        // 实际摄入种类，减去必须摄入种类
        structure.removeAll(DataTransferUtils.str2Set(record.getStructureSet()));
        if (structure.size() == 0) {
            report.setStructureEvaluation(EXCELLENT);
        } else if (structure.size() == 1) {
            report.setStructureEvaluation(GOOD);
        } else {
            report.setStructureEvaluation(BAD);
        }
        Set<Integer> set = new TreeSet<>(structure);
        report.setStructureLack(set);
    }

    /**
     * 每周种类均衡评价
     *
     * @param evaluation 周评价报告
     * @param record     饮食记录
     */
    private static void setSpeciesEvaluation(SpeciesEvaluation evaluation, TbDietRecord record, double totalGood, double totalBad, double proteinGood, double proteinBad,
                                             double stapleFoodGood, double stapleFoodBad, double fruitVegetableGood, double fruitVegetableBad, double nutBeanGood,
                                             double nutBeanBad) {
        int proteinTotal = DataTransferUtils.str2Set(record.getProteinSet()).size();
        int stapleFoodTotal = DataTransferUtils.str2Set(record.getStapleFoodSet()).size();
        int fruitVegetableTotal = DataTransferUtils.str2Set(record.getFruitVegetableSet()).size();
        int nutTotal = DataTransferUtils.str2Set(record.getNutsSet()).size();
        int beanTotal = DataTransferUtils.str2Set(record.getBeansSet()).size();

        int nutBeanTotal = nutTotal + beanTotal;
        int speciesTotal = proteinTotal + stapleFoodTotal + fruitVegetableTotal + nutTotal + beanTotal;

        // 种类均衡评价
        setSpeciesTotalEvaluation(evaluation.getTotalSpecies(), speciesTotal, totalGood, totalBad);
        setProteinSpeciesEvaluation(evaluation.getProteinSpecies(), proteinTotal, proteinGood, proteinBad);
        setStapleFoodSpeciesEvaluation(evaluation.getStapleFoodSpecies(), stapleFoodTotal, stapleFoodGood, stapleFoodBad);
        setFruitVegetableSpeciesEvaluation(evaluation.getFruitVegetableSpecies(), fruitVegetableTotal, fruitVegetableGood, fruitVegetableBad);
        setNutBeanSpeciesEvaluation(evaluation.getBeanNutSpecies(), nutBeanTotal, nutBeanGood, nutBeanBad);
        setSpeciesScore(evaluation);
    }

    private static void setProteinSpeciesEvaluation(TotalEvaluation evaluation, Integer total, double good, double bad) {
        setSpeciesEvaluation(evaluation, total, good, bad);
    }

    private static void setStapleFoodSpeciesEvaluation(TotalEvaluation evaluation, Integer total, double good, double bad) {
        setSpeciesEvaluation(evaluation, total, good, bad);
    }

    private static void setFruitVegetableSpeciesEvaluation(TotalEvaluation evaluation, Integer total, double good, double bad) {
        setSpeciesEvaluation(evaluation, total, good, bad);
    }

    private static void setNutBeanSpeciesEvaluation(TotalEvaluation evaluation, Integer total, double good, double bad) {
        setSpeciesEvaluation(evaluation, total, good, bad);
    }

    private static void setSpeciesTotalEvaluation(TotalEvaluation evaluation, Integer total, double good, double bad) {
        setSpeciesEvaluation(evaluation, total, good, bad);
    }

    private static void setSpeciesEvaluation(TotalEvaluation evaluation, Integer total, double good, double bad) {
        evaluation.setTotal(total);
        if (total > good) {
            evaluation.setEvaluation(EXCELLENT);
        } else if (total < bad) {
            evaluation.setEvaluation(BAD);
        } else {
            evaluation.setEvaluation(GOOD);
        }
    }

    private static void setSpeciesScore(SpeciesEvaluation evaluation) {
        double score = ReportHelper.getWeeklyScore(evaluation.getBeanNutSpecies()) + ReportHelper.getWeeklyScore(evaluation.getFruitVegetableSpecies())
                + ReportHelper.getWeeklyScore(evaluation.getProteinSpecies()) + ReportHelper.getWeeklyScore(evaluation.getStapleFoodSpecies())
                + ReportHelper.getWeeklyScore(evaluation.getTotalSpecies());
        evaluation.setScore(score);
    }

    private static void setEvaluation(TotalEvaluation evaluation, double per, double badRationalUpper, double badRationalLower, double rationalUpper, double rationalLower) {
        evaluation.setTotal(per);
        if (per > badRationalUpper || per < badRationalLower) {
            evaluation.setEvaluation(BAD);
        } else if (per > rationalUpper || per < rationalLower) {
            evaluation.setEvaluation(GOOD);
        } else {
            evaluation.setEvaluation(EXCELLENT);
        }
    }

    /**
     * 设置每天营养素评价
     *
     * @param dailyReport 每日饮食报告
     * @param record      饮食记录
     * @param standard    饮食标准
     */
    private static void setNutrientEvaluation(DietDailyReport dailyReport, TbDietRecord record, Double standard, Double insolubleFibre) {
        setProteinEvaluation(dailyReport, record, standard);
        setFatEvaluation(dailyReport, record, standard);
        setColEvaluation(dailyReport, record, standard);
        setInsolubleFibrinEvaluation(dailyReport, record, insolubleFibre);
    }

    /**
     * 设置周营养评价
     *
     * @param weeklyNutrientsEvaluation 营养评价（动物性脂肪，优质蛋白）
     * @param record                    饮食记录总
     */
    private static void setWeeklyNutrientEvaluation(WeeklyNutrientsEvaluation weeklyNutrientsEvaluation, TbDietRecord record) {
        setGoodProteinEvaluation(weeklyNutrientsEvaluation.getGoodProtein(), record);
        setAnimalFatEvaluation(weeklyNutrientsEvaluation.getAnimalFat(), record);
    }

    private static void setGoodProteinEvaluation(TotalEvaluation evaluation, TbDietRecord record) {
        double goodProteinPer = record.getGoodProtein() / record.getProtein();
        evaluation.setTotal(goodProteinPer * PER_BASE);

        if (goodProteinPer > GOOD_PROTEIN_GOOD) {
            evaluation.setEvaluation(EXCELLENT);
        } else if (goodProteinPer < GOOD_PROTEIN_BAD) {
            evaluation.setEvaluation(BAD);
        } else {
            evaluation.setEvaluation(GOOD);
        }
    }

    private static void setAnimalFatEvaluation(TotalEvaluation evaluation, TbDietRecord record) {
        double animalFatPer = record.getAnimalFat() / record.getFat();
        evaluation.setTotal(animalFatPer * PER_BASE);

        if (animalFatPer < ANIMAL_FAT_GOOD) {
            evaluation.setEvaluation(EXCELLENT);
        } else if (animalFatPer > ANIMAL_FAT_BAD) {
            evaluation.setEvaluation(BAD);
        } else {
            evaluation.setEvaluation(GOOD);
        }

    }

    /**
     * 设置蛋白质评价
     *
     * @param dailyReport    每天饮食报告
     * @param record         摄入总和
     * @param energyStandard 能量标准
     */
    private static void setProteinEvaluation(DietDailyReport dailyReport, TbDietRecord record, Double energyStandard) {
        double proteinPer = (PROTEIN_ENERGY_OF_1G * record.getProtein()) / energyStandard;
        double proteinStandard = (DAILY_PROTEIN_MORE * energyStandard / PROTEIN_ENERGY_OF_1G);

        if (proteinPer > DAILY_PROTEIN_MORE) {
            // 多
            dailyReport.setProteinEvaluation(GOOD);
            dailyReport.setProteinLack(record.getProtein() - proteinStandard);
        } else if (proteinPer < DAILY_PROTEIN_LITTLE) {
            // 少
            dailyReport.setProteinEvaluation(BAD);
            dailyReport.setProteinLack(proteinStandard - record.getProtein());
        } else {
            // 合适
            dailyReport.setProteinEvaluation(EXCELLENT);
        }
        dailyReport.setProteinPer(proteinPer * PER_BASE);
    }

    /**
     * 脂肪评价
     *
     * @param dailyReport    每天饮食报告
     * @param record         摄入总和
     * @param energyStandard 能量标准
     */
    private static void setFatEvaluation(DietDailyReport dailyReport, TbDietRecord record, Double energyStandard) {
        double fatPer = (FAT_ENERGY_OF_1G * record.getFat()) / energyStandard;
        double fatStandard = (DAILY_FAT_MORE * energyStandard / FAT_ENERGY_OF_1G);

        if (fatPer > DAILY_FAT_MORE) {
            // 多
            dailyReport.setFatEvaluation(GOOD);
            dailyReport.setFatLack(record.getFat() - fatStandard);
        } else if (fatPer < DAILY_FAT_LITTLE) {
            // 少
            dailyReport.setFatEvaluation(BAD);
            dailyReport.setFatLack(fatStandard - record.getFat());
        } else {
            // 合适
            dailyReport.setFatEvaluation(EXCELLENT);
        }
        dailyReport.setFatPer(fatPer * PER_BASE);
    }

    // 比较标准，0 优， 1 一般 （多），2 差 （少）
    private static int contrast(double target, double upper, double floor) {
        if (target > upper) {
            // 偏多
            return 1;
        } else if (target < floor) {
            // 偏少
            return 2;
        }
        // 合适
        return 0;
    }

    private static int getDailyFatEvaluation(double per) {
        return contrast(per, DAILY_FAT_MORE, DAILY_FAT_LITTLE);
    }

    private static int getDailyProteinEvaluation(double per) {
        return contrast(per, DAILY_PROTEIN_MORE, DAILY_PROTEIN_LITTLE);
    }

    private static int getDailyColEvaluation(double per) {
        return contrast(per, DAILY_COL_MORE, DAILY_COL_LITTLE);
    }

    private static int getDailyInsolubleFibrinEvaluation(double per) {
        return contrast(per, DAILY_COL_MORE, DAILY_COL_LITTLE);
    }

    private static int getDailyGoodProtein(double per) {
        return contrast(per, GOOD_PROTEIN_GOOD, GOOD_PROTEIN_BAD);
    }

    private static int getDailyAnimalFat(double per) {
        return contrast(per, ANIMAL_FAT_GOOD, ANIMAL_FAT_BAD);
    }

    private static int getDailyVitaminA(double num) {
        return contrast(num, DAILY_VITAMIN_A_GOOD_UP, DAILY_VITAMIN_A_GOOD_DOWN);
    }

    private static int getDailyVitaminB1(double num) {
        return contrast(num, DAILY_VITAMIN_B1_GOOD_UP, DAILY_VITAMIN_B1_GOOD_DOWN);
    }

    private static int getDailyVitaminB2(double num) {
        return contrast(num, DAILY_VITAMIN_B2_GOOD_UP, DAILY_VITAMIN_B2_GOOD_DOWN);
    }

    private static int getDailyVitaminB3(double num) {
        return contrast(num, DAILY_VITAMIN_B3_GOOD_UP, DAILY_VITAMIN_B3_GOOD_DOWN);
    }

    private static int getDailyVitaminC(double num) {
        return contrast(num, DAILY_VITAMIN_C_GOOD_UP, DAILY_VITAMIN_C_GOOD_DOWN);
    }

    private static int getDailyVitaminE(double num) {
        return contrast(num, DAILY_VITAMIN_E_GOOD_UP, DAILY_VITAMIN_E_GOOD_DOWN);
    }

    private static int getDailyCa(double num) {
        return contrast(num, DAILY_CA_GOOD_UP, DAILY_CA_GOOD_DOWN);
    }

    private static int getDailyZn(double num) {
        return contrast(num, DAILY_ZN_GOOD_UP, DAILY_ZN_GOOD_DOWN);
    }

    private static int getDailyP(double num) {
        return contrast(num, DAILY_P_GOOD_UP, DAILY_P_GOOD_DOWN);
    }

    private static int getDailyK(double num) {
        return contrast(num, DAILY_K_GOOD_UP, DAILY_K_GOOD_DOWN);
    }

    private static int getDailyCU(double num) {
        return contrast(num, DAILY_CU_GOOD_UP, DAILY_CU_GOOD_DOWN);
    }

    private static int getDailySe(double num) {
        return contrast(num, DAILY_SE_GOOD_UP, DAILY_SE_GOOD_DOWN);
    }

    private static int getDailyMg(double num) {
        return contrast(num, DAILY_MG_GOOD_UP, DAILY_MG_GOOD_DOWN);
    }

    private static int getDailyFe(double num) {
        return contrast(num, DAILY_FE_GOOD_UP, DAILY_FE_GOOD_DOWN);
    }

    // 获取每周饮食推荐
    public static List<Integer> getDailyLackFoodRecommend(double fatPer, double colPer, double proteinPer, double insolubleFibrinPer) {

        List<Integer> type = new ArrayList<>(30);

        int proteinType = 1;
        int colType = 2;
        int fatType = 3;
        int insolubleFibrinType = 4;

        type.add(fatType, getDailyFatEvaluation(fatPer));
        type.add(colType, getDailyColEvaluation(colPer));
        type.add(proteinType, getDailyProteinEvaluation(proteinPer));
        type.add(insolubleFibrinType, getDailyInsolubleFibrinEvaluation(insolubleFibrinPer));

        return type;
    }

    private static List<Integer> listDailyLackVitamin(double vA, double vB1, double vB2, double vB3, double vC, double vE) {
        List<Integer> type = new ArrayList<>(30);

        int vAType = 18;
        int vB1Type = 19;
        int vB2Type = 20;
        int vB3Type = 21;
        int vCType = 22;
        int vEType = 23;

        type.add(vAType, getDailyVitaminA(vA));
        type.add(vB1Type, getDailyVitaminB1(vB1));
        type.add(vB2Type, getDailyVitaminB2(vB2));
        type.add(vB3Type, getDailyVitaminA(vB3));
        type.add(vCType, getDailyVitaminC(vC));
        type.add(vEType, getDailyVitaminE(vE));

        return type;

    }

    private static List<Integer> listDailyLackMiner(double mn, double ca, double zn, double p, double k, double cu, double se, double mg, double fe) {
        List<Integer> type = new ArrayList<>(30);

        int kType = 9;
        int mgType = 10;
        int feType = 11;
        int znType = 12;
        int seType = 13;
        int cuType = 14;
        int mnType = 15;
        int caType = 16;
        int pType = 17;

        // 设置类型
        type.add(kType, getDailyK(k));
        type.add(mgType, getDailyK(mg));
        type.add(caType, getDailyK(ca));
        type.add(pType, getDailyK(p));
        type.add(mnType, getDailyK(mn));
        type.add(feType, getDailyK(fe));
        type.add(cuType, getDailyK(cu));
        type.add(seType, getDailyK(se));
        type.add(znType, getDailyK(zn));

        return type;
    }

    public static List<Integer> getDailyLackFoodRecommend(double vA, double vB1, double vB2, double vB3, double vC, double vE, double mn,
                                                          double ca, double zn, double p, double k, double cu, double se, double mg, double fe) {

        List<Integer> type = new ArrayList<>(30);

        type.addAll(listDailyLackMiner(mn, ca, zn, p, k, cu, se, mg, fe));
        type.addAll(listDailyLackVitamin(vA, vB1, vB2, vB3, vC, vE));

        return type;
    }

    /**
     * 碳水化合物评价
     *
     * @param dailyReport    每天饮食报告
     * @param record         摄入总和
     * @param energyStandard 能量标准
     */
    private static void setColEvaluation(DietDailyReport dailyReport, TbDietRecord record, Double energyStandard) {
        double colPer = (COL_ENERGY_OF_1G * record.getCarbs()) / energyStandard;
        double colStandard = (DAILY_COL_MORE * energyStandard) / COL_ENERGY_OF_1G;

        if (colPer > DAILY_COL_MORE) {
            // 多
            dailyReport.setColEvaluation(GOOD);
            dailyReport.setColLack(record.getCarbs() - colStandard);
        } else if (colPer < DAILY_COL_LITTLE) {
            // 少
            dailyReport.setColEvaluation(BAD);
            dailyReport.setColLack(colStandard - record.getCarbs());
        } else {
            // 合适
            dailyReport.setColEvaluation(EXCELLENT);
        }

        dailyReport.setColPer(colPer * PER_BASE);
    }

    /**
     * 不可溶纤维评价
     *
     * @param dailyReport 每天饮食报告
     * @param record      摄入总和
     */
    private static void setInsolubleFibrinEvaluation(DietDailyReport dailyReport, TbDietRecord record, double insolubleFibre) {
        double fiber = record.getInsolubleFiber();
        double goodStandardUpper = insolubleFibre * DAILY_FIBRIN_GOOD_UPPER;
        double goodStandardLower = insolubleFibre * DAILY_FIBRIN_GOOD_LOWER;

        if (fiber > goodStandardUpper) {
            dailyReport.setFibrinEvaluation(GOOD);
            dailyReport.setFibrinLack(fiber - goodStandardUpper);
        } else if (fiber < goodStandardLower) {
            dailyReport.setFibrinEvaluation(BAD);
            dailyReport.setFibrinLack(goodStandardLower - fiber);
        } else {
            dailyReport.setFibrinEvaluation(EXCELLENT);
        }
        dailyReport.setFibrinPer(fiber);
    }

    /**
     * 维生素评价
     *
     * @param evaluation 维生素评价
     * @param recordList 每天饮食记录
     */
    private static void setVitaminEvaluation(VitaminEvaluation evaluation, List<TbDietRecord> recordList) {
        setVitaminAEvaluation(evaluation.getA(), recordList);
        setVitaminB1Evaluation(evaluation.getB1(), recordList);
        setVitaminB2Evaluation(evaluation.getB2(), recordList);
        setVitaminB3Evaluation(evaluation.getB3(), recordList);
        setVitaminCEvaluation(evaluation.getC(), recordList);
        setVitaminEEvaluation(evaluation.getE(), recordList);
        // 生成平均分
        evaluation.generateScore();
    }

    private static void setVitaminAEvaluation(Evaluation evaluation, List<TbDietRecord> recordList) {
        int good = 0, excellent = 0, bad = 0;

        for (TbDietRecord record : recordList) {
            int evaluationResult = evaluation(record.getVitaminA(), DAILY_VITAMIN_A_BAD_UP, DAILY_VITAMIN_A_BAD_DOWN,
                    DAILY_VITAMIN_A_GOOD_UP, DAILY_VITAMIN_A_GOOD_DOWN);
            if (evaluationResult == BAD) {
                bad += 1;
            } else if (evaluationResult == GOOD) {
                good += 1;
            } else {
                excellent += 1;
            }
        }
        evaluation.setExcellent(excellent);
        evaluation.setGood(good);
        evaluation.setOrdinary(bad);
        evaluation.setScore(getScore(excellent, good, 0, bad, MONTH_EXCELLENT_SCORE, MONTH_GOOD_SCORE, MONTH_ORDINARY_SCORE, MONTH_BAD_SCORE));
    }

    private static void setVitaminB1Evaluation(Evaluation evaluation, List<TbDietRecord> recordList) {
        int good = 0, excellent = 0, bad = 0;

        for (TbDietRecord record : recordList) {
            int evaluationResult = evaluation(record.getVitaminB1(), DAILY_VITAMIN_B1_BAD_UP, DAILY_VITAMIN_B1_BAD_DOWN,
                    DAILY_VITAMIN_B1_GOOD_UP, DAILY_VITAMIN_B1_GOOD_DOWN);
            if (evaluationResult == BAD) {
                bad += 1;
            } else if (evaluationResult == GOOD) {
                good += 1;
            } else {
                excellent += 1;
            }
        }
        evaluation.setExcellent(excellent);
        evaluation.setGood(good);
        evaluation.setOrdinary(bad);
        evaluation.setScore(getScore(excellent, good, 0, bad, MONTH_EXCELLENT_SCORE, MONTH_GOOD_SCORE, MONTH_ORDINARY_SCORE, MONTH_BAD_SCORE));
    }

    private static void setVitaminB2Evaluation(Evaluation evaluation, List<TbDietRecord> recordList) {
        int good = 0, excellent = 0, bad = 0;

        for (TbDietRecord record : recordList) {
            int evaluationResult = evaluation(record.getVitaminB2(), DAILY_VITAMIN_B2_BAD_UP, DAILY_VITAMIN_B2_BAD_DOWN,
                    DAILY_VITAMIN_B2_GOOD_UP, DAILY_VITAMIN_B2_GOOD_DOWN);
            if (evaluationResult == BAD) {
                bad += 1;
            } else if (evaluationResult == GOOD) {
                good += 1;
            } else {
                excellent += 1;
            }
        }
        evaluation.setExcellent(excellent);
        evaluation.setGood(good);
        evaluation.setOrdinary(bad);
        evaluation.setScore(getScore(excellent, good, 0, bad, MONTH_EXCELLENT_SCORE, MONTH_GOOD_SCORE, MONTH_ORDINARY_SCORE, MONTH_BAD_SCORE));
    }

    private static void setVitaminB3Evaluation(Evaluation evaluation, List<TbDietRecord> recordList) {
        Integer good = 0, excellent = 0, bad = 0;

        for (TbDietRecord record : recordList) {
            int evaluationResult = evaluation(record.getVitaminB3(), DAILY_VITAMIN_B3_BAD_UP, DAILY_VITAMIN_B3_BAD_DOWN,
                    DAILY_VITAMIN_B3_GOOD_UP, DAILY_VITAMIN_B3_GOOD_DOWN);
            if (evaluationResult == BAD) {
                bad += 1;
            } else if (evaluationResult == GOOD) {
                good += 1;
            } else {
                excellent += 1;
            }
        }
        evaluation.setExcellent(excellent);
        evaluation.setGood(good);
        evaluation.setOrdinary(bad);
        evaluation.setScore(getScore(excellent, good, 0, bad, MONTH_EXCELLENT_SCORE, MONTH_GOOD_SCORE, MONTH_ORDINARY_SCORE, MONTH_BAD_SCORE));
    }

    private static void setVitaminCEvaluation(Evaluation evaluation, List<TbDietRecord> recordList) {
        int good = 0, excellent = 0, bad = 0;

        for (TbDietRecord record : recordList) {
            int evaluationResult = evaluation(record.getVitaminC(), DAILY_VITAMIN_C_BAD_UP, DAILY_VITAMIN_C_BAD_DOWN,
                    DAILY_VITAMIN_C_GOOD_UP, DAILY_VITAMIN_C_GOOD_DOWN);
            if (evaluationResult == BAD) {
                bad += 1;
            } else if (evaluationResult == GOOD) {
                good += 1;
            } else {
                excellent += 1;
            }
        }
        evaluation.setExcellent(excellent);
        evaluation.setGood(good);
        evaluation.setOrdinary(bad);
        evaluation.setScore(getScore(excellent, good, 0, bad, MONTH_EXCELLENT_SCORE, MONTH_GOOD_SCORE, MONTH_ORDINARY_SCORE, MONTH_BAD_SCORE));
    }

    private static void setVitaminEEvaluation(Evaluation evaluation, List<TbDietRecord> recordList) {
        int good = 0, excellent = 0, bad = 0;

        for (TbDietRecord record : recordList) {
            int evaluationResult = evaluation(record.getVitaminE(), DAILY_VITAMIN_E_BAD_UP, DAILY_VITAMIN_E_BAD_DOWN,
                    DAILY_VITAMIN_E_GOOD_UP, DAILY_VITAMIN_E_GOOD_DOWN);
            if (evaluationResult == BAD) {
                bad += 1;
            } else if (evaluationResult == GOOD) {
                good += 1;
            } else {
                excellent += 1;
            }
        }
        evaluation.setExcellent(excellent);
        evaluation.setGood(good);
        evaluation.setOrdinary(bad);
        evaluation.setScore(getScore(excellent, good, 0, bad, MONTH_EXCELLENT_SCORE, MONTH_GOOD_SCORE, MONTH_ORDINARY_SCORE, MONTH_BAD_SCORE));
    }


    private static void setMineralsEvaluation(MineralEvaluation evaluation, List<TbDietRecord> recordList) {
        setCaEvaluation(evaluation.getCa(), recordList);
        setFeEvaluation(evaluation.getFe(), recordList);
        setMgEvaluation(evaluation.getMg(), recordList);
        setKEvaluation(evaluation.getK(), recordList);
        setCuEvaluation(evaluation.getCu(), recordList);
        setSeEvaluation(evaluation.getSe(), recordList);
        setZnEvaluation(evaluation.getZn(), recordList);
        setPEvaluation(evaluation.getP(), recordList);
        // 生成平均分
        evaluation.generateScore();
    }

    private static void setCaEvaluation(Evaluation evaluation, List<TbDietRecord> recordList) {
        int good = 0, excellent = 0, bad = 0;

        for (TbDietRecord record : recordList) {
            int evaluationResult = evaluation(record.getCa(), DAILY_CA_BAD_UP, DAILY_CA_BAD_DOWN,
                    DAILY_CA_GOOD_UP, DAILY_CA_GOOD_DOWN);
            if (evaluationResult == BAD) {
                bad += 1;
            } else if (evaluationResult == GOOD) {
                good += 1;
            } else {
                excellent += 1;
            }
        }
        evaluation.setExcellent(excellent);
        evaluation.setGood(good);
        evaluation.setOrdinary(bad);
        evaluation.setScore(getScore(excellent, good, 0, bad, MONTH_EXCELLENT_SCORE, MONTH_GOOD_SCORE, MONTH_ORDINARY_SCORE, MONTH_BAD_SCORE));
    }

    private static void setKEvaluation(Evaluation evaluation, List<TbDietRecord> recordList) {
        int good = 0, excellent = 0, bad = 0;

        for (TbDietRecord record : recordList) {
            int evaluationResult = evaluation(record.getK(), DAILY_K_BAD_UP, DAILY_K_BAD_DOWN,
                    DAILY_K_GOOD_UP, DAILY_K_GOOD_DOWN);
            if (evaluationResult == BAD) {
                bad += 1;
            } else if (evaluationResult == GOOD) {
                good += 1;
            } else {
                excellent += 1;
            }
        }
        evaluation.setExcellent(excellent);
        evaluation.setGood(good);
        evaluation.setOrdinary(bad);
        evaluation.setScore(getScore(excellent, good, 0, bad, MONTH_EXCELLENT_SCORE, MONTH_GOOD_SCORE, MONTH_ORDINARY_SCORE, MONTH_BAD_SCORE));
    }

    private static void setSeEvaluation(Evaluation evaluation, List<TbDietRecord> recordList) {
        int good = 0, excellent = 0, bad = 0;

        for (TbDietRecord record : recordList) {
            int evaluationResult = evaluation(record.getSe(), DAILY_SE_BAD_UP, DAILY_SE_BAD_DOWN,
                    DAILY_SE_GOOD_UP, DAILY_SE_GOOD_DOWN);
            if (evaluationResult == BAD) {
                bad += 1;
            } else if (evaluationResult == GOOD) {
                good += 1;
            } else {
                excellent += 1;
            }
        }
        evaluation.setExcellent(excellent);
        evaluation.setGood(good);
        evaluation.setOrdinary(bad);
        evaluation.setScore(getScore(excellent, good, 0, bad, MONTH_EXCELLENT_SCORE, MONTH_GOOD_SCORE, MONTH_ORDINARY_SCORE, MONTH_BAD_SCORE));
    }

    private static void setFeEvaluation(Evaluation evaluation, List<TbDietRecord> recordList) {
        int good = 0, excellent = 0, bad = 0;

        for (TbDietRecord record : recordList) {
            int evaluationResult = evaluation(record.getFe(), DAILY_FE_BAD_UP, DAILY_FE_BAD_DOWN,
                    DAILY_FE_GOOD_UP, DAILY_FE_GOOD_DOWN);
            if (evaluationResult == BAD) {
                bad += 1;
            } else if (evaluationResult == GOOD) {
                good += 1;
            } else {
                excellent += 1;
            }
        }
        evaluation.setExcellent(excellent);
        evaluation.setGood(good);
        evaluation.setOrdinary(bad);
        evaluation.setScore(getScore(excellent, good, 0, bad, MONTH_EXCELLENT_SCORE, MONTH_GOOD_SCORE, MONTH_ORDINARY_SCORE, MONTH_BAD_SCORE));
    }

    private static void setMgEvaluation(Evaluation evaluation, List<TbDietRecord> recordList) {
        int good = 0, excellent = 0, bad = 0;

        for (TbDietRecord record : recordList) {
            int evaluationResult = evaluation(record.getMg(), DAILY_MG_BAD_UP, DAILY_MG_BAD_DOWN,
                    DAILY_MG_GOOD_UP, DAILY_MG_GOOD_DOWN);
            if (evaluationResult == BAD) {
                bad += 1;
            } else if (evaluationResult == GOOD) {
                good += 1;
            } else {
                excellent += 1;
            }
        }
        evaluation.setExcellent(excellent);
        evaluation.setGood(good);
        evaluation.setOrdinary(bad);
        evaluation.setScore(getScore(excellent, good, 0, bad, MONTH_EXCELLENT_SCORE, MONTH_GOOD_SCORE, MONTH_ORDINARY_SCORE, MONTH_BAD_SCORE));
    }

    private static void setPEvaluation(Evaluation evaluation, List<TbDietRecord> recordList) {
        int good = 0, excellent = 0, bad = 0;

        for (TbDietRecord record : recordList) {
            int evaluationResult = evaluation(record.getP(), DAILY_P_BAD_UP, DAILY_P_BAD_DOWN,
                    DAILY_P_GOOD_UP, DAILY_P_GOOD_DOWN);
            if (evaluationResult == BAD) {
                bad += 1;
            } else if (evaluationResult == GOOD) {
                good += 1;
            } else {
                excellent += 1;
            }
        }
        evaluation.setExcellent(excellent);
        evaluation.setGood(good);
        evaluation.setOrdinary(bad);
        evaluation.setScore(getScore(excellent, good, 0, bad, MONTH_EXCELLENT_SCORE, MONTH_GOOD_SCORE, MONTH_ORDINARY_SCORE, MONTH_BAD_SCORE));
    }

    private static void setZnEvaluation(Evaluation evaluation, List<TbDietRecord> recordList) {
        int good = 0, excellent = 0, bad = 0;

        for (TbDietRecord record : recordList) {
            int evaluationResult = evaluation(record.getZn(), DAILY_ZN_BAD_UP, DAILY_ZN_BAD_DOWN,
                    DAILY_ZN_GOOD_UP, DAILY_ZN_GOOD_DOWN);
            if (evaluationResult == BAD) {
                bad += 1;
            } else if (evaluationResult == GOOD) {
                good += 1;
            } else {
                excellent += 1;
            }
        }
        evaluation.setExcellent(excellent);
        evaluation.setGood(good);
        evaluation.setOrdinary(bad);
        evaluation.setScore(getScore(excellent, good, 0, bad, MONTH_EXCELLENT_SCORE, MONTH_GOOD_SCORE, MONTH_ORDINARY_SCORE, MONTH_BAD_SCORE));
    }

    private static void setCuEvaluation(Evaluation evaluation, List<TbDietRecord> recordList) {
        int good = 0, excellent = 0, bad = 0;

        for (TbDietRecord record : recordList) {
            int evaluationResult = evaluation(record.getCu(), DAILY_CU_BAD_UP, DAILY_CU_BAD_DOWN,
                    DAILY_CU_GOOD_UP, DAILY_CU_GOOD_DOWN);
            if (evaluationResult == BAD) {
                bad += 1;
            } else if (evaluationResult == GOOD) {
                good += 1;
            } else {
                excellent += 1;
            }
        }
        evaluation.setExcellent(excellent);
        evaluation.setGood(good);
        evaluation.setOrdinary(bad);
        evaluation.setScore(getScore(excellent, good, 0, bad, MONTH_EXCELLENT_SCORE, MONTH_GOOD_SCORE, MONTH_ORDINARY_SCORE, MONTH_BAD_SCORE));
    }

    // 判断优良差
    private static int evaluation(double inputValue, double badUpper, double badLower, double goodUpper, double goodLower) {
        if (inputValue > badUpper || inputValue < badLower) {
            return BAD;
        } else if (inputValue > goodUpper || inputValue < goodLower) {
            return GOOD;
        } else {
            return EXCELLENT;
        }
    }

//    private static void

    /**
     * 获取身高计算出的基础能量
     *
     * @param gender 性别：0未知，1男，2女
     * @param height 身高
     * @return 基础能量标准
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
     * @param sexReduction 性别对应减数
     * @param height       身高
     * @param weight       体重
     * @return 返回每日理论能量
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

    private static Double getInsolubleFibre(Integer weight) {
        return weight * INSOLUBLE_FIBRE_DAILY;
    }

    public static Double getWeeklyScore(int excellent, int good, int ordinary, int bad) {
        return getScore(excellent, good, ordinary, bad, WEEKLY_EXCELLENT_SCORE, WEEKLY_GOOD_SCORE,
                WEEKLY_ORDINARY_SCORE, WEEKLY_BAD_SCORE);
    }

    public static Double getMonthScore(int excellent, int good, int ordinary, int bad) {
        return getScore(excellent, good, ordinary, bad, MONTH_EXCELLENT_SCORE, MONTH_GOOD_SCORE,
                MONTH_ORDINARY_SCORE, MONTH_BAD_SCORE);
    }

    private static Double getScore(int excellent, int good, int ordinary, int bad, int excellentScore,
                                   int goodScore, int ordinaryScore, int badScore) {
        return (double) (excellent * excellentScore + good * goodScore + ordinary * ordinaryScore + bad * badScore);
    }

    private static Double getScore(TotalEvaluation evaluation, int excellentScore, int goodScore, int ordinaryScore, int badScore) {
        int level = evaluation.getEvaluation();
        double result;
        if (level == EXCELLENT) {
            result = excellentScore;
        } else if (level == GOOD) {
            result = goodScore;
        } else if (level == BAD) {
            result = ordinaryScore;
        } else {
            result = badScore;
        }
        return result;
    }

    public static double getWeeklyScore(WeeklyNutrientsEvaluation nutrientsEvaluation, double size) {
        double total;
        int dayCount = 5;
        // 均衡比例，优质蛋白，动物性脂肪 × size
        total = getWeeklyScore(nutrientsEvaluation.getAnimalFat()) * dayCount + getWeeklyScore(nutrientsEvaluation.getGoodProtein()) * dayCount
                + nutrientsEvaluation.getCarbs().getScore() + nutrientsEvaluation.getFat().getScore() + nutrientsEvaluation.getProtein().getScore()
                + nutrientsEvaluation.getFibrin().getScore();

        return total / size;
    }

    public static Double getWeeklyScore(TotalEvaluation evaluation) {
        return getScore(evaluation, WEEKLY_EXCELLENT_SCORE, WEEKLY_GOOD_SCORE,
                WEEKLY_ORDINARY_SCORE, WEEKLY_BAD_SCORE);
    }

    public static Double getMonthScore(TotalEvaluation evaluation) {
        return getScore(evaluation, MONTH_EXCELLENT_SCORE, MONTH_GOOD_SCORE,
                MONTH_ORDINARY_SCORE, MONTH_BAD_SCORE);
    }

    public static double getMonthScore(WeeklyNutrientsEvaluation nutrientsEvaluation, double size) {
        double total;
        int dayCount = 20;
        // 均衡比例，优质蛋白，动物性脂肪 × size
        total = getMonthScore(nutrientsEvaluation.getAnimalFat()) * dayCount + getMonthScore(nutrientsEvaluation.getGoodProtein()) * dayCount
                + nutrientsEvaluation.getCarbs().getScore() + nutrientsEvaluation.getFat().getScore() + nutrientsEvaluation.getProtein().getScore()
                + nutrientsEvaluation.getFibrin().getScore();

        return total / size;
    }


}
