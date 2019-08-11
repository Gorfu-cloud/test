package com.bkit.fatdown.utils;

import com.bkit.fatdown.dto.diet.*;
import com.bkit.fatdown.dto.diet.common.EnergyEvaluation;
import com.bkit.fatdown.dto.diet.common.SpeciesEvaluation;
import com.bkit.fatdown.dto.diet.common.TotalEvaluation;
import com.bkit.fatdown.dto.diet.common.WeeklyNutrientsEvaluation;
import com.bkit.fatdown.entity.*;

import java.util.*;

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
     * 营养素评价
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

    private static final int WEEKLY_EXCELLENT_SCORE = 20;
    private static final int WEEKLY_GOOD_SCORE = 15;
    private static final int WEEKLY_ORDINARY_SCORE = 10;
    private static final int WEEKLY_BAD_SCORE = 0;


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
        EnergyEvaluation energyEvaluation = setEnergyEvaluation(dailyReportList, energyStandard);
        weeklyReport.setEnergyEvaluation(energyEvaluation);
        // 种类均衡评价
        setSpeciesEvaluation(weeklyReport.getSpeciesEvaluation(), dietRecord, WEEKLY_TOTAL_GOOD, WEEKLY_TOTAL_BAD, WEEKLY_PROTEIN_GOOD, WEEKLY_PROTEIN_BAD,
                WEEKLY_STAPLE_FOOD_GOOD, WEEKLY_STAPLE_FOOD_BAD, WEEKLY_FRUIT_VEGETABLE_GOOD, WEEKLY_FRUIT_VEGETABLE_BAD, WEEKLY_NUT_BEAN_GOOD, WEEKLY_NUT_BEAN_BAD);
        // 每周营养素评价,优质蛋白质，动物性脂肪
        setWeeklyNutrientEvaluation(weeklyReport.getWeeklyNutrientsEvaluation(), dietRecord);

        return weeklyReport;
    }

    /**
     * 统计每天能量评价
     *
     * @param reportList     每天饮食报告
     * @param energyStandard 能量标准
     * @return 能量评价
     */
    private static EnergyEvaluation setEnergyEvaluation(List<TbDietDailyReport> reportList, double energyStandard) {
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

        double score = getWeeklyScore(excellentTotal, goodTotal, ordinaryTotal, badTotal);

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
        double score = MathUtils.getWeeklyScore(evaluation.getBeanNutSpecies()) + MathUtils.getWeeklyScore(evaluation.getFruitVegetableSpecies())
                + MathUtils.getWeeklyScore(evaluation.getProteinSpecies()) + MathUtils.getWeeklyScore(evaluation.getStapleFoodSpecies())
                + MathUtils.getWeeklyScore(evaluation.getTotalSpecies());
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

    public static Double getWeeklyScore(TotalEvaluation evaluation) {
        return getScore(evaluation, WEEKLY_EXCELLENT_SCORE, WEEKLY_GOOD_SCORE,
                WEEKLY_ORDINARY_SCORE, WEEKLY_BAD_SCORE);
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

        total = getWeeklyScore(nutrientsEvaluation.getAnimalFat()) + getWeeklyScore(nutrientsEvaluation.getGoodProtein())
                + nutrientsEvaluation.getCarbs().getScore() + nutrientsEvaluation.getFat().getScore() + nutrientsEvaluation.getProtein().getScore()
                + nutrientsEvaluation.getFibrin().getScore();

        return total / size;
    }
}
