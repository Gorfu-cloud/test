package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.dto.ElementTotalDTO;
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

    // 存在该菜式拆解
    private static final int EXIST_FOOD = 0;
    // 菜式含量组成单位，100g
    private static final int FOOD_GRAM_BASE = 100;


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
     * @param recordIdList
     * @return
     */
    @Override
    public UserReportDTO getDietElementTotal(List<Integer> recordIdList) {

        ElementTotalDTO totalDTO = getElementTotal(recordIdList);
        UserReportDTO reportDTO = new UserReportDTO();

        reportDTO.setRealEnergy(totalDTO.getEnergy());
        reportDTO.setProtein(totalDTO.getProtein());
        reportDTO.setCho(totalDTO.getCho());
        reportDTO.setFat(totalDTO.getFat());
        reportDTO.setFiber(totalDTO.getFiber());
        reportDTO.setStructureLack(totalDTO.getStructType());

        return reportDTO;
    }

    /**
     * 返回指定菜式搭配总量
     *
     * @param foodIdList
     * @return
     */
    @Override
    public ElementTotalDTO getElementTotal(List<Integer> foodIdList) {

        ElementTotalDTO target = new ElementTotalDTO();

        // 为空时，直接返回初始化结果
        if (foodIdList.isEmpty()) {
            return target;
        }

        if (foodIdList.size() == 1) {
            return getElementTotalById(foodIdList.get(0));
        }

        for (int id : foodIdList) {
            ElementTotalDTO temp = getElementTotalById(id);
            target = mergeElementTotalDTO(target, temp);
        }

        return target;
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
     * 通过foodId 获取指定菜式组成成分，各元素总数
     *
     * @param foodId
     * @return
     */
    @Override
    public ElementTotalDTO getElementTotalById(int foodId) {
        // 能量 ,  脂肪，  蛋白质，  碳水化合物，  膳食纤维
        double energy = 0, fat = 0, protein = 0, cho = 0, fiber = 0;
        // 菜式拥有的营养种类
        Set<Integer> structType = new TreeSet<>();
        // 菜式信息
        TbFoodBasic foodBasic = foodBasicService.getFoodBasic(foodId);
        int flag = foodBasic.getFlag();

        // 存该菜式记录时,计算菜式组成成分，元素总量
        if (flag == EXIST_FOOD) {
            // 获取食物元素组成(蛋白质等）
            Map<Integer, Double> map = foodElementService.getElementNameAndGram(foodId);
            // 计算组成总量
            for (Map.Entry<Integer, Double> entry : map.entrySet()) {
                // 组成成分id
                int basicId = entry.getKey();
                // 组成成分重量
                double gram = entry.getValue();
                // 计算根据每一百克，计算对应的元素含量
                TbElementBasic elementBasic = elementBasicService.getElementBasic(basicId);

                energy += (gram / 100) * elementBasic.getEnergy();
                protein += (gram / 100) * elementBasic.getProtein();
                cho += (gram / 100) * elementBasic.getCho();
                fiber += (gram / 100) * elementBasic.getFiber();
                fat += (gram / 100) * elementBasic.getFat();

                // 组成元素结构类型：1,蛋白质， 2主食， 3,蔬菜水果， 4,坚果， 5豆类
                structType.add(elementBasic.getType());
            }
        }

        return new ElementTotalDTO(flag, energy, fat, protein, cho, fiber, structType);
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

    /**
     * 合并计算总量
     *
     * @param target
     * @param temp
     * @return
     */
    private ElementTotalDTO mergeElementTotalDTO(ElementTotalDTO target, ElementTotalDTO temp) {
        // 能量 ,  脂肪，  蛋白质，  碳水化合物，  膳食纤维
        double energy = target.getEnergy(), fat = target.getFat(),
                protein = target.getProtein(), cho = target.getCho(), fiber = target.getFiber();
        // 菜式拥有的营养种类
        Set<Integer> structType = target.getStructType();

        energy += temp.getEnergy();
        fat += temp.getFat();
        protein += temp.getProtein();
        cho += temp.getCho();
        fiber += temp.getFiber();
        structType.addAll(temp.getStructType());

        return new ElementTotalDTO(energy, fat, protein, cho, fiber, structType);
    }
}