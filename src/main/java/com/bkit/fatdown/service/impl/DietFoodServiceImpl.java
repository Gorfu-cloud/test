package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.dto.FoodInfoDTO;
import com.bkit.fatdown.dto.UserReportDTO;
import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.mappers.TbDietUserStandardMapper;
import com.bkit.fatdown.mappers.TbFoodRecordMapper;
import com.bkit.fatdown.service.*;
import com.bkit.fatdown.utils.DateUtils;
import com.bkit.fatdown.utils.MathUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @file: DietFoodServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 饮食功能实现类
 * @date: Created in 7/23/19  8:54 AM
 * @modified:
 * @version: 1.0
 */

@Service
public class DietFoodServiceImpl implements IDietFoodService {

    @Resource
    private TbFoodRecordMapper foodRecordMapper;

    @Resource
    private TbDietUserStandardMapper dietStandardMapper;

    @Resource
    private IUserLifeStyleService userLifeStyleService;

    @Resource
    private IUserBasicInfoService userBasicInfoService;

    @Resource
    private IUserPrivacyInfoService privacyInfoService;

    @Resource
    private IFoodBasicService foodBasicService;

    @Resource
    private IElementBasicService elementBasicService;

    @Resource
    private IFoodElementService foodElementService;

    private static Logger logger = Logger.getLogger(DietFoodServiceImpl.class);

    /**
     * 保存饮食记录
     *
     * @param record
     * @return
     */
    @Override
    public boolean insert(TbFoodRecord record) {
        record.setGmtCreate(new Date());
        record.setGmtModified(new Date());
        return foodRecordMapper.insert(record) > 0;
    }

    /**
     * 获取用户某天饮食记录
     *
     * @param uid
     * @param date
     * @return
     */
    @Override
    public List<TbFoodRecord> listFoodRecordByDate(int uid, Date date) {
        TbFoodRecordExample example = new TbFoodRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andGmtCreateBetween(DateUtils.getDateStart(date), DateUtils.getDateEnd(date));
        return foodRecordMapper.selectByExample(example);
    }

    /**
     * 创建饮食标准
     *
     * @param standard
     * @return
     */
    @Override
    public boolean insertDietStandard(TbDietUserStandard standard) {
        standard.setGmtCreate(new Date());
        standard.setGmtModified(new Date());
        return dietStandardMapper.insert(standard) > 0;
    }

    /**
     * 更新饮食标准
     *
     * @param standard
     * @return
     */
    @Override
    public boolean updateDietStandard(TbDietUserStandard standard) {
        standard.setGmtModified(new Date());
        return dietStandardMapper.updateByPrimaryKeySelective(standard) > 0;
    }

    /**
     * 通过用户信息更新饮食标准
     *
     * @param uid
     * @return
     */
    @Override
    public boolean updateDietStandardByUid(int uid) {
        // 获取用户习惯，隐私信息，基础信息。
        TbUserLifeStyle userLifeStyle = userLifeStyleService.listByUid(uid).get(0);
        TbUserPrivacyInfo privacyInfo = privacyInfoService.listByUid(uid).get(0);
        TbUserBasicInfo basicInfo = userBasicInfoService.getById(uid);

        return updateDietStandard(MathUtils.getDietUserStandard(basicInfo, privacyInfo, userLifeStyle));
    }

    /**
     * 通过用户编号获取饮食标准
     *
     * @param uid
     * @return
     */
    @Override
    public TbDietUserStandard getDietStandard(int uid) {
        return dietStandardMapper.selectByPrimaryKey(uid);
    }

    /**
     * 拆解菜式
     *
     * @param recordList
     * @return
     */
    @Override
    public UserReportDTO foodBasic2DietReport(List<TbFoodRecord> recordList) {
        // 能量
        double energy = 0.0;
        // 脂肪
        double fat = 0.0;
        // 蛋白质
        double protein = 0.0;
        // 碳水化合物
        double cho = 0.0;
        // 膳食纤维
        double fiber = 0.0;
        // 饮食结构
        Set<Integer> structType = new TreeSet<>();

        // 计算用餐成分
        for (TbFoodRecord foodRecord : recordList) {
            int id = foodRecord.getFoodId();
            // 菜式信息
            TbFoodBasic foodBasic = foodBasicService.getFoodBasic(id);

            // 存该菜式记录时
            if (foodBasic.getFlag() == 0) {
                // 获取食物元素组成(蛋白质等）
                Map<Integer, Double> map = foodElementService.listElementById(id);

                // 计算组成总量
                for (Map.Entry<Integer, Double> entry : map.entrySet()) {
                    int basicId = entry.getKey();
                    // 对应元素含量
                    double gram = entry.getValue();
                    // 计算每一百克对应的元素含量
                    TbElementBasic elementBasic = elementBasicService.getElementBasic(basicId);
                    energy += (gram / 100) * elementBasic.getEnergy();
                    protein += (gram / 100) * elementBasic.getProtein();
                    cho += (gram / 100) * elementBasic.getCho();
                    fiber += (gram / 100) * elementBasic.getFiber();
                    fat += (gram / 100) * elementBasic.getFat();
                    // 添加结构类型1,蛋白质，2主食，3,蔬菜水果，4,坚果，5豆类
                    structType.add(elementBasic.getType());
                }
            }
        }

        UserReportDTO reportDTO = new UserReportDTO();

        reportDTO.setRealEnergy(energy);
        reportDTO.setProtein(protein);
        reportDTO.setCho(cho);
        reportDTO.setFat(fat);
        reportDTO.setFiber(fiber);
        reportDTO.setStructureLack(structType);

        return reportDTO;
    }

    /**
     * 返回菜式列表
     *
     * @param uid
     * @param date
     * @param type
     * @return
     */
    @Override
    public List<TbFoodRecord> listFoodBasic(int uid, Date date, Integer type) {
        // 早餐
        if (type == 0) {
            return listFoodRecord(uid, DateUtils.getBreakfastStartTime(date), DateUtils.getBreakfastEndTime(date));
        } else if (type == 1) {
            // 午餐
            return listFoodRecord(uid, DateUtils.getLunchStartTime(date), DateUtils.getLunchEndTime(date));
        } else if (type == 2) {
            // 晚餐
            return listFoodRecord(uid, DateUtils.getDinnerStartTime(date), DateUtils.getDinnerEndTime(date));
        } else if (type == 4) {
            // 一天
            return listFoodRecord(uid, DateUtils.getDateStart(date), DateUtils.getDateEnd(date));
        } else {
            logger.error(uid + "菜式列表错误");
            return null;
        }
    }

    /**
     * 获取菜式名称和重量
     *
     * @param uid
     * @param date
     * @param type
     * @return
     */
    @Override
    public List<FoodInfoDTO> listFoodInfoDTO(int uid, Date date, Integer type) {
        List<TbFoodRecord> recordList;
        // 早餐
        if (type == 0) {
            recordList = listFoodRecord(uid, DateUtils.getBreakfastStartTime(date), DateUtils.getBreakfastEndTime(date));
        } else if (type == 1) {
            // 午餐
            recordList = listFoodRecord(uid, DateUtils.getLunchStartTime(date), DateUtils.getLunchEndTime(date));
        } else {
            // 晚餐
            recordList = listFoodRecord(uid, DateUtils.getDinnerStartTime(date), DateUtils.getDinnerEndTime(date));
        }

        return listFoodInfoDTO(recordList);
    }

    /**
     * 返回日期时间内饮食记录
     *
     * @param uid
     * @param start
     * @param end
     * @return
     */
    private List<TbFoodRecord> listFoodRecord(int uid, Date start, Date end) {
        TbFoodRecordExample example = new TbFoodRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andGmtCreateBetween(start, end);

        return foodRecordMapper.selectByExample(example);
    }

    /**
     * 将用户饮食记录封装为菜式信息类
     *
     * @param recordList
     * @return
     */
    private List<FoodInfoDTO> listFoodInfoDTO(List<TbFoodRecord> recordList) {
        List<FoodInfoDTO> foodInfoDTOList = new ArrayList<>(8);
        FoodInfoDTO foodInfoDTO;
        for (TbFoodRecord record : recordList) {
            foodInfoDTO = new FoodInfoDTO();
            TbFoodBasic basic = foodBasicService.getFoodBasic(record.getFoodId());

            foodInfoDTO.setFoodName(basic.getFoodName());
            foodInfoDTO.setFoodGram(basic.getQuantity());
            foodInfoDTOList.add(foodInfoDTO);
        }

        return foodInfoDTOList;
    }

}
