package com.bkit.fatdown.utils;

import com.bkit.fatdown.entity.TbDietUserStandard;
import com.bkit.fatdown.entity.TbUserBasicInfo;
import com.bkit.fatdown.entity.TbUserLifeStyle;
import com.bkit.fatdown.entity.TbUserPrivacyInfo;

/**
 * @file: MathUtils
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 公式计算工具类
 * @date: Created in 2019/7/16 14:38
 * @modified:
 * @version: 1.0
 */

public class MathUtils {

    private static final int WOMEN = 2;
    private static final Integer ENERGY_REDUCTION_MAN = 100;
    private static final Integer ENERGY_REDUCTION_WOMEN = 105;
    private static final Double ENERGY_MULTIPLIER = 20.0;

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
     * 获取用户饮食标准
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
        userStandard.setEnergy(getBasicEnergy(basicInfo.getGender(), privacyInfo.getHeight()));
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
     * 获取身高计算出的基础能量
     *
     * @param gender
     * @param height
     * @return
     */
    private static Double getBasicEnergy(Integer gender, Integer height) {
        // 女性
        if (gender == WOMEN) {
            return (height - ENERGY_REDUCTION_WOMEN) * ENERGY_MULTIPLIER;
        } else {
            return (height - ENERGY_REDUCTION_MAN) * ENERGY_MULTIPLIER;
        }
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
