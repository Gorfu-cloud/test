package com.bkit.fatdown.utils;

import com.bkit.fatdown.dto.DietDailyReport;
import com.bkit.fatdown.dto.DietMealReport;
import com.bkit.fatdown.dto.DietWeeklyReport;
import com.bkit.fatdown.dto.UserReportDTO;
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

    private static final Double DAILY_FIBRIN_MORE = 60.0;
    private static final Double DAILY_FIBRIN_LITTLE = 40.0;
    private static final Double DAILY_FIBRIN_BAD_UPPER = 1.2;
    private static final Double DAILY_FIBRIN_BAD_LOWER = 0.80;
    private static final Double DAILY_FIBRIN_GOOD_UPPER = 1.10;
    private static final Double DAILY_FIBRIN_GOOD_LOWER = 0.90;

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

        setNutrientEvaluation(dailyReport, dietRecord, energyStandard);

        return dailyReport;
    }

    public static DietWeeklyReport getDietWeeklyReport(TbDietUserStandard userStandard, TbDietRecord dietRecord,
                                                       List<TbDietRecord> breakfastList, List<TbDietRecord> lunchList,
                                                       List<TbDietRecord> dinnerList) {

        DietWeeklyReport weeklyReport = new DietWeeklyReport();
        double weight = userStandard.getWeight();
        int recordTotal = breakfastList.size() + lunchList.size() + dinnerList.size();
        // 一天总能量标准
        double energyStandard = (userStandard.getEnergy() + userStandard.getOilEnergy())
                + (userStandard.getSaltyEnergy() + userStandard.getSpicyEnergy());
        // 一周摄入
        double realEnergy = dietRecord.getEnergy();
        // 每天平均摄入
        double realDailyEnergy = realEnergy / (recordTotal / 3.0);
        // 全天能量评价
        setEnergyEvaluation(weeklyReport, energyStandard, realDailyEnergy);
        // 三餐能量评价
        setMealEnergyEvaluation(weeklyReport, energyStandard, getMeanEnergy(breakfastList),
                getMeanEnergy(lunchList), getMeanEnergy(dinnerList));
        // 种类均衡评价
        setSpeciesEvaluation(weeklyReport, dietRecord);
        // 每周营养素评价
        setNutrientEvaluation(weeklyReport, dietRecord, energyStandard, recordTotal, weight);

        return weeklyReport;
    }

    /**
     * 每周能量评价
     *
     * @param report         每周报告
     * @param energyStandard 每天能量标准
     * @param realEnergy     真实摄入
     */
    private static void setEnergyEvaluation(DietWeeklyReport report, double energyStandard, double realEnergy) {
        double energyPer = realEnergy / energyStandard;

        report.setEnergyPer(energyPer);
        if (energyPer > ENERGY_WEEKLY_SO_BAD_UPPER || energyPer < ENERGY_WEEKLY_SO_BAD_LOWER) {
            report.setEnergyEvaluation(SO_BAD);
        } else if (energyPer > ENERGY_WEEKLY_BAD_UPPER || energyPer < ENERGY_WEEKLY_BAD_LOWER) {
            report.setEnergyEvaluation(BAD);
        } else if (energyPer > ENERGY_WEEKLY_GOOD_UPPER || energyPer < ENERGY_WEEKLY_GOOD_LOWER) {
            report.setEnergyEvaluation(GOOD);
        } else {
            report.setEnergyEvaluation(EXCELLENT);
        }
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
     * @param report 周评价报告
     * @param record 饮食记录
     */
    private static void setSpeciesEvaluation(DietWeeklyReport report, TbDietRecord record) {
        int proteinTotal = DataTransferUtils.str2Set(record.getProteinSet()).size();
        int stapleFoodTotal = DataTransferUtils.str2Set(record.getStapleFoodSet()).size();
        int fruitVegetableTotal = DataTransferUtils.str2Set(record.getFruitVegetableSet()).size();
        int nutTotal = DataTransferUtils.str2Set(record.getNutsSet()).size();
        int beanTotal = DataTransferUtils.str2Set(record.getBeansSet()).size();

        int nutBeanTotal = nutTotal + beanTotal;
        int speciesTotal = proteinTotal + stapleFoodTotal + fruitVegetableTotal + nutTotal + beanTotal;

        setSpeciesTotalEvaluation(report, speciesTotal);
        setProteinSpeciesEvaluation(report, proteinTotal);
        setStapleFoodSpeciesEvaluation(report, stapleFoodTotal);
        setFruitVegetableSpeciesEvaluation(report, fruitVegetableTotal);
        setNutBeanSpeciesEvaluation(report, nutBeanTotal);
    }

    private static void setProteinSpeciesEvaluation(DietWeeklyReport report, Integer total) {
        if (total > WEEKLY_PROTEIN_GOOD) {
            report.setProteinSpeciesEvaluation(EXCELLENT);
        } else if (total < WEEKLY_PROTEIN_BAD) {
            report.setProteinSpeciesEvaluation(BAD);
        } else {
            report.setProteinSpeciesEvaluation(GOOD);
        }
    }

    private static void setStapleFoodSpeciesEvaluation(DietWeeklyReport report, Integer total) {
        if (total > WEEKLY_STAPLE_FOOD_GOOD) {
            report.setStapleFoodSpeciesEvaluation(EXCELLENT);
        } else if (total < WEEKLY_STAPLE_FOOD_BAD) {
            report.setStapleFoodSpeciesEvaluation(BAD);
        } else {
            report.setStapleFoodSpeciesEvaluation(GOOD);
        }
    }

    private static void setFruitVegetableSpeciesEvaluation(DietWeeklyReport report, Integer total) {
        if (total > WEEKLY_FRUIT_VEGETABLE_GOOD) {
            report.setFruitVegetableSpeciesEvaluation(EXCELLENT);
        } else if (total < WEEKLY_FRUIT_VEGETABLE_BAD) {
            report.setFruitVegetableSpeciesEvaluation(BAD);
        } else {
            report.setFruitVegetableSpeciesEvaluation(GOOD);
        }
    }

    private static void setNutBeanSpeciesEvaluation(DietWeeklyReport report, Integer total) {
        if (total > WEEKLY_NUT_BEAN_GOOD) {
            report.setBeanNutSpeciesEvaluation(EXCELLENT);
        } else if (total < WEEKLY_NUT_BEAN_BAD) {
            report.setBeanNutSpeciesEvaluation(BAD);
        } else {
            report.setBeanNutSpeciesEvaluation(GOOD);
        }
    }

    private static void setSpeciesTotalEvaluation(DietWeeklyReport report, Integer total) {
        if (total > WEEKLY_TOTAL_GOOD) {
            report.setTotalSpeciesEvaluation(EXCELLENT);
        } else if (total < WEEKLY_TOTAL_BAD) {
            report.setTotalSpeciesEvaluation(BAD);
        } else {
            report.setTotalSpeciesEvaluation(GOOD);
        }
    }

    /**
     * 每周三餐能量评价
     *
     * @param report              每周评价报告
     * @param energyStandard      能量标准
     * @param breakfastMeanEnergy 早餐能量
     * @param lunchMeanEnergy     午餐能量
     * @param dinnerMeanEnergy    晚餐能量
     */
    private static void setMealEnergyEvaluation(DietWeeklyReport report, double energyStandard, double breakfastMeanEnergy,
                                                double lunchMeanEnergy, double dinnerMeanEnergy) {
        double breakfastPer = breakfastMeanEnergy / energyStandard;
        double lunchPer = lunchMeanEnergy / energyStandard;
        double dinnerPer = dinnerMeanEnergy / energyStandard;

        report.setBreakfastEnergyPer(breakfastPer);
        report.setLunchEnergyPer(lunchPer);
        report.setDinnerEnergyPer(dinnerPer);

        if (breakfastPer > ENERGY_BREAKFAST_BAD_RATIONAL_UPPER || breakfastPer < ENERGY_BREAKFAST_BAD_RATIONAL_LOWER) {
            report.setBreakfastEnergyEvaluation(BAD);
        } else if (breakfastPer > ENERGY_BREAKFAST_RATIONAL_UPPER || breakfastPer < ENERGY_BREAKFAST_RATIONAL_LOWER) {
            report.setBreakfastEnergyEvaluation(GOOD);
        } else {
            report.setBreakfastEnergyEvaluation(EXCELLENT);
        }

        if (lunchPer > ENERGY_LUNCH_BAD_RATIONAL_UPPER || lunchPer < ENERGY_LUNCH_BAD_RATIONAL_LOWER) {
            report.setLunchEnergyEvaluation(BAD);
        } else if (lunchPer > ENERGY_LUNCH_RATIONAL_UPPER || lunchPer < ENERGY_LUNCH_RATIONAL_LOWER) {
            report.setLunchEnergyEvaluation(GOOD);
        } else {
            report.setLunchEnergyEvaluation(EXCELLENT);
        }

        if (dinnerPer > ENERGY_DINNER_BAD_RATIONAL_UPPER || dinnerPer < ENERGY_DINNER_BAD_RATIONAL_LOWER) {
            report.setDinnerEnergyEvaluation(BAD);
        } else if (dinnerPer > ENERGY_DINNER_RATIONAL_UPPER || dinnerPer < ENERGY_DINNER_RATIONAL_LOWER) {
            report.setDinnerEnergyEvaluation(GOOD);
        } else {
            report.setDinnerEnergyEvaluation(EXCELLENT);
        }

    }


    /**
     * 设置每天营养素评价
     *
     * @param dailyReport 每日饮食报告
     * @param record      饮食记录
     * @param standard    饮食标准
     */
    private static void setNutrientEvaluation(DietDailyReport dailyReport, TbDietRecord record, Double standard) {
        setProteinEvaluation(dailyReport, record, standard);
        setFatEvaluation(dailyReport, record, standard);
        setColEvaluation(dailyReport, record, standard);
        setFibrinEvaluation(dailyReport, record);
    }

    private static void setNutrientEvaluation(DietWeeklyReport weeklyReport, TbDietRecord record, Double standard,
                                              int total, double weight) {
        setProteinEvaluation(weeklyReport, record, standard, total);
        setFatEvaluation(weeklyReport, record, standard, total);
        setColEvaluation(weeklyReport, record, standard, total);
        setFibrinEvaluation(weeklyReport, record, total, weight);
        setGoodProteinEvaluation(weeklyReport, record);
        setAnimalFatEvaluation(weeklyReport, record);
    }

    private static void setProteinEvaluation(DietWeeklyReport weeklyReport, TbDietRecord record, Double energyStandard, int total) {
        double proteinPer = (PROTEIN_ENERGY_OF_1G * record.getProtein() / (total / 3.0)) / energyStandard;

        if (proteinPer > DAILY_PROTEIN_MORE) {
            // 多
            weeklyReport.setProteinEvaluation(GOOD);
        } else if (proteinPer < DAILY_PROTEIN_LITTLE) {
            // 少
            weeklyReport.setProteinEvaluation(BAD);
        } else {
            // 合适
            weeklyReport.setProteinEvaluation(EXCELLENT);
        }
        weeklyReport.setProteinPer(proteinPer * PER_BASE);
    }

    private static void setFatEvaluation(DietWeeklyReport weeklyReport, TbDietRecord record, Double energyStandard, int total) {
        double fatPer = (FAT_ENERGY_OF_1G * record.getFat() / (total / 3.0)) / energyStandard;

        if (fatPer > DAILY_FAT_MORE) {
            // 多
            weeklyReport.setFatEvaluation(GOOD);
        } else if (fatPer < DAILY_FAT_LITTLE) {
            // 少
            weeklyReport.setFatEvaluation(BAD);
        } else {
            // 合适
            weeklyReport.setFatEvaluation(EXCELLENT);
        }
        weeklyReport.setFatPer(fatPer * PER_BASE);
    }

    private static void setColEvaluation(DietWeeklyReport weeklyReport, TbDietRecord record, Double energyStandard, int total) {
        double colPer = (COL_ENERGY_OF_1G * record.getCho() / (total / 3.0)) / energyStandard;

        if (colPer > DAILY_COL_MORE) {
            // 多
            weeklyReport.setColEvaluation(GOOD);
        } else if (colPer < DAILY_COL_LITTLE) {
            // 少
            weeklyReport.setColEvaluation(BAD);
        } else {
            // 合适
            weeklyReport.setColEvaluation(EXCELLENT);
        }
        weeklyReport.setColPer(colPer * PER_BASE);
    }

    private static void setFibrinEvaluation(DietWeeklyReport weeklyReport, TbDietRecord record, int total, double weight) {
        double fiber = record.getFiber() / (total / 3.0) / weight;

        if (fiber > DAILY_FIBRIN_BAD_UPPER || fiber < DAILY_FIBRIN_BAD_LOWER) {
            weeklyReport.setFibrinEvaluation(BAD);
        } else if (fiber > DAILY_FIBRIN_GOOD_UPPER || fiber < DAILY_FIBRIN_GOOD_LOWER) {
            weeklyReport.setFibrinEvaluation(GOOD);
        } else {
            weeklyReport.setFibrinEvaluation(EXCELLENT);
        }
        weeklyReport.setFibrinPer(fiber);
    }

    private static void setGoodProteinEvaluation(DietWeeklyReport weeklyReport, TbDietRecord record) {
        double goodProteinPer = record.getGoodProtein() / record.getProtein();
        weeklyReport.setGoodProteinPer(goodProteinPer* PER_BASE);

        if (goodProteinPer > GOOD_PROTEIN_GOOD) {
            weeklyReport.setGoodProteinEvaluation(EXCELLENT);
        } else if (goodProteinPer < GOOD_PROTEIN_BAD) {
            weeklyReport.setGoodProteinEvaluation(BAD);
        } else {
            weeklyReport.setGoodProteinEvaluation(GOOD);
        }
    }

    private static void setAnimalFatEvaluation(DietWeeklyReport weeklyReport, TbDietRecord record) {
        double animalFatPer = record.getAnimalFat() / record.getFat();
        weeklyReport.setAnimalFatPer(animalFatPer* PER_BASE);

        if (animalFatPer < ANIMAL_FAT_GOOD) {
            weeklyReport.setAnimalFatEvaluation(EXCELLENT);
        } else if (animalFatPer > ANIMAL_FAT_BAD) {
            weeklyReport.setAnimalFatEvaluation(BAD);
        } else {
            weeklyReport.setAnimalFatEvaluation(GOOD);
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
        double colPer = (COL_ENERGY_OF_1G * record.getCho()) / energyStandard;
        double colStandard = (DAILY_COL_MORE * energyStandard) / COL_ENERGY_OF_1G;

        if (colPer > DAILY_COL_MORE) {
            // 多
            dailyReport.setColEvaluation(GOOD);
            dailyReport.setColLack(record.getCho() - colStandard);
        } else if (colPer < DAILY_COL_LITTLE) {
            // 少
            dailyReport.setColEvaluation(BAD);
            dailyReport.setColLack(colStandard - record.getCho());
        } else {
            // 合适
            dailyReport.setColEvaluation(EXCELLENT);
        }

        dailyReport.setColPer(colPer * PER_BASE);
    }

    /**
     * 纤维素评价
     *
     * @param dailyReport 每天饮食报告
     * @param record      摄入总和
     */
    private static void setFibrinEvaluation(DietDailyReport dailyReport, TbDietRecord record) {
        double fiber = record.getFiber();

        if (fiber > DAILY_FIBRIN_MORE) {
            dailyReport.setFibrinEvaluation(GOOD);
            dailyReport.setFibrinLack(fiber - DAILY_FIBRIN_MORE);

        } else if (fiber < DAILY_FIBRIN_LITTLE) {
            dailyReport.setFibrinEvaluation(BAD);
            dailyReport.setFibrinLack(DAILY_FIBRIN_LITTLE - fiber);

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

    private static Double getMeanEnergy(List<TbDietRecord> list) {
        if (list.size() == 1) {
            return list.get(0).getEnergy();
        }

        double energyTotal = 0.0;

        for (TbDietRecord record : list) {
            energyTotal += record.getEnergy();
        }

        return energyTotal / list.size();
    }
}
