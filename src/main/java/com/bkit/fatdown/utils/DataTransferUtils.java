package com.bkit.fatdown.utils;

import com.bkit.fatdown.dto.CommonPageDTO;
import com.bkit.fatdown.dto.diet.*;
import com.bkit.fatdown.dto.diet.common.*;
import com.bkit.fatdown.entity.*;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @file: DataTransferUtils
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 从map中获取传入的参数工具类
 * @date: Created in 2019/7/16 11:09
 * @modified: 修改添加当日修改同一个记录
 * @version: 1.0
 */
public class DataTransferUtils {

    /**
     * 劳动强度:0轻度,1中度,2重度
     */
    private final static int[] LABOUR_INTENSITY_ARRAY = {0, 1, 2};
    /**
     * 饮食习惯:1.6很油腻,1.4较油腻,1.2一般.1.0较清淡,0.9清淡
     */
    private final static double[] DIETARY_HABIT_ARRAY = {1.6, 1.4, 1.2, 1.0, 0.9};
    /**
     * 饮食口味:0比较淡,1一般,2较咸,3咸
     */
    private final static int[] FOOD_TASTE_ARRAY = {0, 1, 2, 3};
    /**
     * 吃辣程度:0不辣,1一般辣,2比较辣,3很辣
     */
    private final static int[] SPICY_DEGREE_ARRAY = {0, 1, 2, 3};
    /**
     * 用户类型:0减脂,1增肌,2塑形
     */
    private final static int[] USER_TYPE_ARRAY = {0, 1, 2};

    /**
     * @description: 获取map中的用户信息
     * @params: HashMap
     * @return: TbUserBasicInfo
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 7/12/19
     */
    public static TbUserBasicInfo getUserBasicInfoFromMap(HashMap<String, String> map) {
        TbUserBasicInfo userBasicInfo = new TbUserBasicInfo();
        if (map.containsKey("id")) {
            int id = Integer.parseInt(map.get("id"));
            userBasicInfo.setId(id);
        }
        if (map.containsKey("openId")) {
            userBasicInfo.setOpenId(map.get("openId"));
        }
        if (map.containsKey("avatarUrl")) {
            userBasicInfo.setAvatarUrl(map.get("avatarUrl"));
        }
        if (map.containsKey("nickName")) {
            userBasicInfo.setNickName(map.get("nickName"));
        }
        if (map.containsKey("trueName")) {
            userBasicInfo.setTrueName(map.get("trueName"));
        }
        if (map.containsKey("age")) {
            int age = Integer.parseInt(map.get("age"));
            userBasicInfo.setAge(age);
        }
        if (map.containsKey("gender")) {
            int gender = Integer.parseInt(map.get("gender"));
            userBasicInfo.setGender(gender);
        }
        if (map.containsKey("phone")) {
            userBasicInfo.setPhone(map.get("phone"));
        }
        if (map.containsKey("city")) {
            userBasicInfo.setCity(map.get("city"));
        }
        if (map.containsKey("job")) {
            userBasicInfo.setJob(map.get("job"));
        }
        if (map.containsKey("userLevel")) {
            int userLevel = Integer.parseInt(map.get("userLevel"));
            userBasicInfo.setUserLevel(userLevel);
        }
        if (map.containsKey("province")) {
            userBasicInfo.setProvince(map.get("province"));
        }
        if (map.containsKey("flag")) {
            int flag = Integer.parseInt(map.get("flag"));
            userBasicInfo.setFlag(flag);
        }
        userBasicInfo.setGmtModified(new Date());
        return userBasicInfo;
    }

    /**
     * @description: 获取map中的用户信息
     * @params: HashMap
     * @return: TbUserPrivacyInfo
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 7/12/19
     */
    public static TbUserPrivacyInfo getPrivacyInfoFromMap(HashMap<String, Double> map) {
        TbUserPrivacyInfo userPrivacyInfo = new TbUserPrivacyInfo();
        if (map.containsKey("id")) {
            userPrivacyInfo.setId(map.get("id").intValue());
        }
        if (map.containsKey("height")) {
            userPrivacyInfo.setHeight(map.get("height").intValue());
        }
        if (map.containsKey("weight")) {
            userPrivacyInfo.setWeight(map.get("weight").intValue());
        }
        if (map.containsKey("userId")) {
            userPrivacyInfo.setUserId(map.get("userId").intValue());
        }
        if (map.containsKey("fatRate")) {
            userPrivacyInfo.setFatRate(map.get("fatRate"));
        }
        if (map.containsKey("bust")) {
            userPrivacyInfo.setBust(map.get("bust").intValue());
        }
        if (map.containsKey("waist")) {
            userPrivacyInfo.setWaist(map.get("waist").intValue());
        }
        if (map.containsKey("hip")) {
            userPrivacyInfo.setHip(map.get("hip").intValue());
        }
        if (map.containsKey("calf")) {
            userPrivacyInfo.setCalf(map.get("calf"));
        }
        if (map.containsKey("thign")) {
            userPrivacyInfo.setThign(map.get("thign"));
        }
        if (map.containsKey("bmi")) {
            userPrivacyInfo.setBmi(map.get("bmi"));
        }
        if (map.containsKey("foreArm")) {
            userPrivacyInfo.setForeArm(map.get("foreArm"));
        }
        if (map.containsKey("muscleOxygen")) {
            userPrivacyInfo.setMuscleOxygen(map.get("muscleOxygen").intValue());
        }
        if (map.containsKey("sbp")) {
            userPrivacyInfo.setSystolicBloodPressure(map.get("sbp").intValue());
        }
        if (map.containsKey("dbp")) {
            userPrivacyInfo.setDiastolicBloodPressure(map.get("dbp").intValue());
        }
        if (map.containsKey("bloodOxygen")) {
            userPrivacyInfo.setBloodOxygen(map.get("bloodOxygen").intValue());
        }
        if (map.containsKey("heartOxygen")) {
            userPrivacyInfo.setHeartRate(map.get("heartOxygen").intValue());
        }
        if (map.containsKey("heartRate")) {
            userPrivacyInfo.setHeartRate(map.get("heartRate").intValue());
        }
        if (map.containsKey("phUrine")) {
            userPrivacyInfo.setPhUrine(map.get("phUrine"));
        }
        if (map.containsKey("ketonuria")) {
            userPrivacyInfo.setKetonuria(map.get("ketonuria").intValue());
        }
        if (map.containsKey("bodyTemperature")) {
            userPrivacyInfo.setBodyTemperature(map.get("bodyTemperature"));
        }
        return userPrivacyInfo;
    }

    /**
     * @description: 获取map中的生活习惯
     * @params: map
     * @return: TbUserLifeStyle
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 2019/7/16
     */
    public static TbUserLifeStyle getUserLifeStyleFromMap(HashMap<String, Integer> map) {

        TbUserLifeStyle lifeStyle = new TbUserLifeStyle();
        if (map.containsKey("id")) {
            lifeStyle.setId(map.get("id"));
        }
        if (map.containsKey("userId")) {
            lifeStyle.setUserId(map.get("userId"));
        }
        if (map.containsKey("labourIntensity")) {
            int labourIntensity = map.get("labourIntensity");
            lifeStyle.setLabourIntensity(LABOUR_INTENSITY_ARRAY[labourIntensity]);
        }
        if (map.containsKey("dietaryHabit")) {
            int dietartHabit = map.get("dietaryHabit");
            lifeStyle.setDietaryHabit(DIETARY_HABIT_ARRAY[dietartHabit]);
        }
        if (map.containsKey("foodTaste")) {
            int foodTaste = map.get("foodTaste");
            lifeStyle.setFoodTaste(FOOD_TASTE_ARRAY[foodTaste]);
        }
        if (map.containsKey("spicyDegree")) {
            int spicyDegree = map.get("spicyDegree");
            lifeStyle.setSpicyDegree(SPICY_DEGREE_ARRAY[spicyDegree]);
        }
        if (map.containsKey("userType")) {
            int userType = map.get("userType");
            lifeStyle.setUserType(USER_TYPE_ARRAY[userType]);
        }
        Date today = new Date();
        lifeStyle.setGmtCreate(DateUtils.getDateStart(today));
        lifeStyle.setGmtModified(DateUtils.getDateStart(today));
        return lifeStyle;
    }

    /**
     * @description: 获取map中的数据
     * @params:
     * @return:
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 2019/7/17
     */
    public static CommonPageDTO getCommonPageFromMap(HashMap<String, Integer> map) {
        CommonPageDTO pageDTO = new CommonPageDTO();
        if (map.containsKey("pageSize")) {
            pageDTO.setPageSize(map.get("pageSize"));
        }

        if (map.containsKey("pageNum")) {
            pageDTO.setPageNum(map.get("pageNum"));
        }
        return pageDTO;
    }

    /**
     * @description: 获取map中的参数
     * @params:
     * @return:
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 2019/7/17
     */
    public static TbTaskRecord getTaskRecordFromMap(HashMap<String, Integer> map) {
        TbTaskRecord taskRecord = new TbTaskRecord();
        if (map.containsKey("userId")) {
            taskRecord.setUserId(map.get("userId"));
        }
        if (map.containsKey("taskId")) {
            taskRecord.setTaskId(map.get("taskId"));
        }
        return taskRecord;
    }

    /**
     * @description: 获取map中的参数
     * @params:
     * @return:
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 2019/7/18
     */
    public static TbTaskList getTaskListFromMap(HashMap<String, String> map) {
        TbTaskList taskList = new TbTaskList();
        if (map.containsKey("id")) {
            taskList.setId(Integer.valueOf(map.get("id")));
        }
        if (map.containsKey("type")) {
            taskList.setType(map.get("type"));
        }
        if (map.containsKey("title")) {
            taskList.setTitle(map.get("title"));
        }
        if (map.containsKey("score")) {
            taskList.setScore(Integer.valueOf(map.get("score")));
        }
        if (map.containsKey("taskPageUrl")) {
            taskList.setTaskPageUrl(map.get("taskPageUrl"));
        }
        if (map.containsKey("flag")) {
            taskList.setFlag(Integer.valueOf(map.get("flag")));
        }
        if (map.containsKey("cycle")) {
            taskList.setCycle(Integer.valueOf(map.get("cycle")));
        }
        return taskList;
    }

    /**
     * @description: 从请求中获取taskRecord对象
     * @params:
     * @return:
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 7/19/19
     */
    public static TbTestRecord getTestRecordFromMap(HashMap<String, String> map) {
        TbTestRecord record = new TbTestRecord();

        if (map.containsKey("userId")) {
            record.setUserId(Integer.valueOf(map.get("userId")));
        }
        if (map.containsKey("questionId")) {
            record.setQuestionId(Integer.valueOf(map.get("questionId")));
        }
        if (map.containsKey("paperId")) {
            record.setPaperId(Integer.valueOf(map.get("paperId")));
        }
        if (map.containsKey("userAnswer")) {
            record.setUserAnswer(map.get("userAnswer"));
        }
        return record;
    }

    /**
     * @description: 转换为图片
     * @params: multipartFile
     * @return:
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 7/15/19
     */
    static File multipartFile2File(MultipartFile multipartFile) {
        File file = null;
        try {
            file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * 将数据库中字符串的set转为 str对象
     *
     * @param strSet 字符串集合
     * @return set
     */
    public static Set<Integer> str2Set(String strSet) {
        Set<Integer> set = new TreeSet<>();
        int minSetSize = 3;
        if (strSet.length() < minSetSize) {
            return set;
        }

        int startIndex = 1;
        int endIndex = strSet.length() - 1;
        // 注意：逗号之后有一个空格
        String splitStr = ", ";
        // 去除首尾[]
        String newStr = strSet.substring(startIndex, endIndex);
        for (String s : newStr.split(splitStr)) {
            set.add(Integer.parseInt(s));
        }
        return set;
    }

    /**
     * 转换为数据库储存对象
     *
     * @param report 饮食报告
     * @return 结果
     */
    public static TbDietMealReport transferDietMealReport(DietMealReport report, int uid, int type) {
        TbDietMealReport mealReport = new TbDietMealReport();
        // 设置用户id
        mealReport.setUserId(uid);
        mealReport.setType(type);

        // 能量评价
        mealReport.setEnergyEvaluation(report.getEnergyEvaluation());
        mealReport.setLowerEnergy(report.getLowerEnergy());
        mealReport.setRealEnergy(report.getRealEnergy());
        mealReport.setUpperEnergy(report.getUpperEnergy());

        // 结构评价
        mealReport.setStructureEvaluation(report.getStructureEvaluation());
        mealReport.setStructureLack(report.getStructureLack().toString());

        return mealReport;
    }

    /**
     * 转化为每餐数据封装类
     *
     * @param report 饮食报告
     * @return 饮食报告封装
     */
    public static DietMealReport transferDietMealReport(TbDietMealReport report) {
        DietMealReport mealReport = new DietMealReport();

        // 能量评价
        mealReport.setEnergyEvaluation(report.getEnergyEvaluation());
        mealReport.setLowerEnergy(report.getLowerEnergy());
        mealReport.setRealEnergy(report.getRealEnergy());
        mealReport.setUpperEnergy(report.getUpperEnergy());

        // 结构评价
        mealReport.setStructureEvaluation(report.getStructureEvaluation());
        Set<Integer> structureLack = str2Set(report.getStructureLack());
        mealReport.setStructureLack(structureLack);

        return mealReport;
    }

    /**
     * 转化为数据库储存对象
     *
     * @param report 每日饮食报告
     * @return 每日饮食报告
     */
    public static TbDietDailyReport transferDailyReport(DietDailyReport report) {
        TbDietDailyReport dailyReport = new TbDietDailyReport();

        // 能量评价
        dailyReport.setEnergyEvaluation(report.getEnergyEvaluation());
        dailyReport.setLowerEnergy(report.getLowerEnergy());
        dailyReport.setUpperEnergy(report.getUpperEnergy());
        dailyReport.setRealEnergy(report.getRealEnergy());

        // 结构评价
        dailyReport.setStructureEvaluation(report.getStructureEvaluation());
        dailyReport.setStructureLack(report.getStructureLack().toString());

        // 蛋白质评价
        dailyReport.setProteinEvaluation(report.getProteinEvaluation());
        dailyReport.setProteinPer(report.getProteinPer());
        dailyReport.setProteinLack(report.getProteinLack());

        // 脂肪评价
        dailyReport.setFatEvaluation(report.getFatEvaluation());
        dailyReport.setFatPer(report.getFatPer());
        dailyReport.setFatLack(report.getFatLack());

        // 碳水化合物评价
        dailyReport.setColEvaluation(report.getColEvaluation());
        dailyReport.setColPer(report.getColPer());
        dailyReport.setColLack(report.getColLack());

        // 纤维评价
        dailyReport.setFibrinEvaluation(report.getFibrinEvaluation());
        dailyReport.setFibrinPer(report.getFibrinPer());
        dailyReport.setFibrinLack(report.getFibrinLack());

        return dailyReport;
    }

    /**
     * 转换为每天饮食报告封装类
     *
     * @param report 饮食报告
     * @return 饮食报告
     */
    public static DietDailyReport transferDailyReport(TbDietDailyReport report) {

        DietDailyReport dailyReport = new DietDailyReport();

        // 能量评价
        dailyReport.setEnergyEvaluation(report.getEnergyEvaluation());
        dailyReport.setLowerEnergy(report.getLowerEnergy());
        dailyReport.setUpperEnergy(report.getUpperEnergy());
        dailyReport.setRealEnergy(report.getRealEnergy());

        // 结构评价
        dailyReport.setStructureEvaluation(report.getStructureEvaluation());
        Set<Integer> structureLack = str2Set(report.getStructureLack());
        dailyReport.setStructureLack(structureLack);

        // 蛋白质评价
        dailyReport.setProteinEvaluation(report.getProteinEvaluation());
        dailyReport.setProteinPer(report.getProteinPer());
        dailyReport.setProteinLack(report.getProteinLack());

        // 脂肪评价
        dailyReport.setFatEvaluation(report.getFatEvaluation());
        dailyReport.setFatPer(report.getFatPer());
        dailyReport.setFatLack(report.getFatLack());

        // 碳水化合物评价
        dailyReport.setColEvaluation(report.getColEvaluation());
        dailyReport.setColPer(report.getColPer());
        dailyReport.setColLack(report.getColLack());

        // 纤维评价
        dailyReport.setFibrinEvaluation(report.getFibrinEvaluation());
        dailyReport.setFibrinPer(report.getFibrinPer());
        dailyReport.setFibrinLack(report.getFibrinLack());

        return dailyReport;
    }

    /**
     * 转换为数据库对象
     *
     * @param dietReport 饮食报告
     * @return 数据库存储对象
     */
    public static TbDietWeeklyReport transferWeeklyReport(DietWeeklyReport dietReport) {
        TbDietWeeklyReport report = new TbDietWeeklyReport();
        //设置能量评价
        report.setEnergyScore(dietReport.getEnergyEvaluation().getScore());
        report.setEnergyExcellent(dietReport.getEnergyEvaluation().getExcellent());
        report.setEnergyGood(dietReport.getEnergyEvaluation().getGood());
        report.setEnergyBad(dietReport.getEnergyEvaluation().getBad());
        report.setEnergyOrdinary(dietReport.getEnergyEvaluation().getOrdinary());

        //设置均衡评价
        report.setSpeciesScore(dietReport.getSpeciesEvaluation().getScore());
        report.setProteinSpeciesEvaluation(dietReport.getSpeciesEvaluation().getProteinSpecies().getEvaluation());
        report.setProteinSpeciesTotal(dietReport.getSpeciesEvaluation().getProteinSpecies().getTotal());
        report.setStapleFoodSpeciesEvaluation(dietReport.getSpeciesEvaluation().getStapleFoodSpecies().getEvaluation());
        report.setStapleFoodSpeciesTotal(dietReport.getSpeciesEvaluation().getStapleFoodSpecies().getTotal());
        report.setFruitVegetableSpeciesEvaluation(dietReport.getSpeciesEvaluation().getFruitVegetableSpecies().getEvaluation());
        report.setFruitVegetableSpeciesTotal(dietReport.getSpeciesEvaluation().getFruitVegetableSpecies().getTotal());
        report.setBeanNutSpeciesEvaluation(dietReport.getSpeciesEvaluation().getBeanNutSpecies().getEvaluation());
        report.setBeanNutSpeciesTotal(dietReport.getSpeciesEvaluation().getBeanNutSpecies().getTotal());
        report.setTotalSpeciesEvaluation(dietReport.getSpeciesEvaluation().getTotalSpecies().getEvaluation());
        report.setTotalSpeciesTotal(dietReport.getSpeciesEvaluation().getTotalSpecies().getTotal());

        //三餐能量评价
        report.setBreakfastScore(dietReport.getBreakfast().getScore());
        report.setBreakfastExcellent(dietReport.getBreakfast().getExcellent());
        report.setBreakfastGood(dietReport.getBreakfast().getGood());
        report.setBreakfastOrdinary(dietReport.getBreakfast().getOrdinary());

        report.setLunchExcellent(dietReport.getLunch().getExcellent());
        report.setLunchGood(dietReport.getLunch().getGood());
        report.setLunchOrdinary(dietReport.getLunch().getOrdinary());
        report.setLunchScore(dietReport.getLunch().getScore());

        report.setDinnerExcellent(dietReport.getDinner().getExcellent());
        report.setDinnerGood(dietReport.getDinner().getGood());
        report.setDinnerOrdinary(dietReport.getDinner().getOrdinary());
        report.setDinnerScore(dietReport.getDinner().getScore());

        // 营养素评价
        report.setNutrientScore(dietReport.getWeeklyNutrientsEvaluation().getScore());

        report.setProteinExcellent(dietReport.getWeeklyNutrientsEvaluation().getProtein().getExcellent());
        report.setProteinGood(dietReport.getWeeklyNutrientsEvaluation().getProtein().getGood());
        report.setProteinOrdinary(dietReport.getWeeklyNutrientsEvaluation().getProtein().getOrdinary());
        report.setProteinScore(dietReport.getWeeklyNutrientsEvaluation().getProtein().getScore());

        report.setFatExcellent(dietReport.getWeeklyNutrientsEvaluation().getFat().getExcellent());
        report.setFatGood(dietReport.getWeeklyNutrientsEvaluation().getFat().getGood());
        report.setFatOrdinary(dietReport.getWeeklyNutrientsEvaluation().getFat().getOrdinary());
        report.setFatScore(dietReport.getWeeklyNutrientsEvaluation().getFat().getScore());

        report.setFibrinExcellent(dietReport.getWeeklyNutrientsEvaluation().getFibrin().getExcellent());
        report.setFibrinGood(dietReport.getWeeklyNutrientsEvaluation().getFibrin().getGood());
        report.setFibrinOrdinary(dietReport.getWeeklyNutrientsEvaluation().getFibrin().getOrdinary());
        report.setFibrinScore(dietReport.getWeeklyNutrientsEvaluation().getFibrin().getScore());

        report.setCarbsExcellent(dietReport.getWeeklyNutrientsEvaluation().getCarbs().getExcellent());
        report.setCarbsGood(dietReport.getWeeklyNutrientsEvaluation().getCarbs().getGood());
        report.setCarbsOrdinary(dietReport.getWeeklyNutrientsEvaluation().getCarbs().getOrdinary());
        report.setCarbsScore(dietReport.getWeeklyNutrientsEvaluation().getCarbs().getScore());

        // 优质蛋白，动物性脂肪
        report.setGoodProteinEvaluation(dietReport.getWeeklyNutrientsEvaluation().getGoodProtein().getEvaluation());
        report.setGoodProteinPer(dietReport.getWeeklyNutrientsEvaluation().getGoodProtein().getTotal());
        report.setGoodProteinScore(MathUtils.getWeeklyScore(dietReport.getWeeklyNutrientsEvaluation().getGoodProtein()));

        report.setAnimalFatEvaluation(dietReport.getWeeklyNutrientsEvaluation().getAnimalFat().getEvaluation());
        report.setAnimalFatPer(dietReport.getWeeklyNutrientsEvaluation().getAnimalFat().getTotal());
        report.setAnimalFatScore(MathUtils.getWeeklyScore(dietReport.getWeeklyNutrientsEvaluation().getAnimalFat()));

        return report;
    }

    /**
     * 转换为Dto
     *
     * @param dietReport 数据库对象
     * @return dto
     */
    public static DietWeeklyReport transferWeeklyReport(TbDietWeeklyReport dietReport) {
        DietWeeklyReport report = new DietWeeklyReport();
        report.setEnergyEvaluation(getEnergyEvaluation(dietReport));
        report.setBreakfast(getBreakfastEvaluation(dietReport));
        report.setLunch(getLunchEvaluation(dietReport));
        report.setDinner(getDinnerEvaluation(dietReport));
        report.setSpeciesEvaluation(getSpeciesEvaluation(dietReport));
        report.setWeeklyNutrientsEvaluation(getWeeklyNutrientsEvaluation(dietReport));
        return report;
    }

    private static EnergyEvaluation getEnergyEvaluation(TbDietWeeklyReport dietReport) {
        EnergyEvaluation energyEvaluation = new EnergyEvaluation();
        energyEvaluation.setExcellent(dietReport.getEnergyExcellent());
        energyEvaluation.setGood(dietReport.getEnergyGood());
        energyEvaluation.setOrdinary(dietReport.getEnergyOrdinary());
        energyEvaluation.setBad(dietReport.getEnergyBad());
        energyEvaluation.setScore(dietReport.getEnergyScore());
        return energyEvaluation;
    }

    private static Evaluation getBreakfastEvaluation(TbDietWeeklyReport dietReport) {
        Evaluation evaluation = new Evaluation();
        evaluation.setExcellent(dietReport.getBreakfastExcellent());
        evaluation.setGood(dietReport.getBreakfastGood());
        evaluation.setOrdinary(dietReport.getBreakfastOrdinary());
        evaluation.setScore(dietReport.getBreakfastScore());
        return evaluation;
    }

    private static Evaluation getLunchEvaluation(TbDietWeeklyReport dietReport) {
        Evaluation evaluation = new Evaluation();
        evaluation.setExcellent(dietReport.getLunchExcellent());
        evaluation.setGood(dietReport.getLunchGood());
        evaluation.setOrdinary(dietReport.getLunchOrdinary());
        evaluation.setScore(dietReport.getLunchScore());
        return evaluation;
    }

    private static Evaluation getDinnerEvaluation(TbDietWeeklyReport dietReport) {
        Evaluation evaluation = new Evaluation();
        evaluation.setExcellent(dietReport.getDinnerExcellent());
        evaluation.setGood(dietReport.getDinnerGood());
        evaluation.setOrdinary(dietReport.getDinnerOrdinary());
        evaluation.setScore(dietReport.getDinnerScore());
        return evaluation;
    }

    private static SpeciesEvaluation getSpeciesEvaluation(TbDietWeeklyReport report) {
        SpeciesEvaluation evaluation = new SpeciesEvaluation();

        TotalEvaluation beanNut = new TotalEvaluation(report.getBeanNutSpeciesTotal(), report.getBeanNutSpeciesEvaluation());
        TotalEvaluation fruitVegetable = new TotalEvaluation(report.getFruitVegetableSpeciesTotal(), report.getFruitVegetableSpeciesEvaluation());
        TotalEvaluation protein = new TotalEvaluation(report.getStapleFoodSpeciesTotal(), report.getStapleFoodSpeciesEvaluation());
        TotalEvaluation stapleFood = new TotalEvaluation(report.getStapleFoodSpeciesTotal(), report.getStapleFoodSpeciesEvaluation());
        TotalEvaluation total = new TotalEvaluation(report.getTotalSpeciesTotal(), report.getTotalSpeciesEvaluation());
        evaluation.setBeanNutSpecies(beanNut);
        evaluation.setFruitVegetableSpecies(fruitVegetable);
        evaluation.setProteinSpecies(protein);
        evaluation.setStapleFoodSpecies(stapleFood);
        evaluation.setTotalSpecies(total);
        evaluation.setScore(report.getSpeciesScore());

        return evaluation;
    }

    private static WeeklyNutrientsEvaluation getWeeklyNutrientsEvaluation(TbDietWeeklyReport report) {
        WeeklyNutrientsEvaluation evaluation = new WeeklyNutrientsEvaluation();
        evaluation.setAnimalFat(new TotalEvaluation(report.getAnimalFatPer(), report.getAnimalFatEvaluation()));
        evaluation.setGoodProtein(new TotalEvaluation(report.getGoodProteinPer(), report.getGoodProteinEvaluation()));
        evaluation.setCarbs(new Evaluation(report.getCarbsExcellent(), report.getCarbsGood(), report.getCarbsOrdinary(), report.getCarbsScore()));
        evaluation.setFat(new Evaluation(report.getFatExcellent(), report.getFatGood(), report.getFatOrdinary(), report.getFatScore()));
        evaluation.setFibrin(new Evaluation(report.getFibrinExcellent(), report.getFibrinGood(), report.getFibrinOrdinary(), report.getFibrinScore()));
        evaluation.setProtein(new Evaluation(report.getProteinExcellent(), report.getProteinGood(), report.getProteinOrdinary(), report.getProteinScore()));
        evaluation.setScore(report.getNutrientScore());
        return evaluation;
    }

//    private static
}
