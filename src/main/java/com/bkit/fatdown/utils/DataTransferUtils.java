package com.bkit.fatdown.utils;

import com.bkit.fatdown.dto.CommonPageDTO;
import com.bkit.fatdown.entity.*;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

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
    public static File multipartFile2File(MultipartFile multipartFile) {
        File file = null;
        try {
            file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
