package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.dto.ElementTotalDTO;
import com.bkit.fatdown.dto.FoodInfoDTO;
import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.mappers.TbDietUserStandardMapper;
import com.bkit.fatdown.mappers.TbFoodRecordMapper;
import com.bkit.fatdown.service.*;
import com.bkit.fatdown.utils.DataTransferUtils;
import com.bkit.fatdown.utils.DateUtils;
import com.bkit.fatdown.utils.MathUtils;
import io.swagger.models.auth.In;
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
     * 存在该菜式拆解: 0
     * 不存在该菜式拆解：1
     */
    private static final int EXIST_FOOD = 0;
    /**
     * 菜式组成元素含量组成单位，100g
     */
    private static final int FOOD_GRAM_BASE = 100;


    /**
     * 保存饮食记录
     *
     * @param record 饮食记录
     * @return 保存结果
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
    public TbDietRecord getDietRecordTotalByRecordList(List<Integer> recordIdList) {
        return getDietRecordTotalByFoodList(recordIdList);
    }

    /**
     * 返回指定菜式搭配总量
     *
     * @param foodIdList
     * @return
     */
    @Override
    public TbDietRecord getDietRecordTotalByFoodList(List<Integer> foodIdList) {

        TbDietRecord target = new TbDietRecord();
        initDietRecord(target);

        // 为空时，直接返回初始化结果
        if (foodIdList.isEmpty()) {
            return target;
        }

        // 记录为1时，直接返回
        if (foodIdList.size() == 1) {
            return getDietRecord(foodIdList.get(0));
        }

        for (int id : foodIdList) {
            TbDietRecord temp = getDietRecord(id);
            target = mergeDietRecord(target, temp);
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
    public TbDietRecord getDietRecord(int foodId) {
        // 能量 ,  脂肪，  蛋白质，  碳水化合物，  膳食纤维 , 动物性脂肪， 优质蛋白质
        double energy = 0, fat = 0, protein = 0, cho = 0, fiber = 0, animalFat = 0, goodProtein = 0;
        // 菜式拥有的营养结构种类
        Set<Integer> structType = new TreeSet<>();

        // 周评价：食物种类均衡
        Set<Integer> proteinSet = new TreeSet<>();
        Set<Integer> stapleFoodSet = new TreeSet<>();
        Set<Integer> fruitVegetableSet = new TreeSet<>();
        Set<Integer> beansSet = new TreeSet<>();

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

                // 能量摄入
                energy += (gram / FOOD_GRAM_BASE) * elementBasic.getEnergy();

                // 营养素
                protein += (gram / FOOD_GRAM_BASE) * elementBasic.getProtein();
                cho += (gram / FOOD_GRAM_BASE) * elementBasic.getCho();
                fiber += (gram / FOOD_GRAM_BASE) * elementBasic.getFiber();
                fat += (gram / FOOD_GRAM_BASE) * elementBasic.getFat();

                // 优质蛋白质摄入量
                if (elementBasic.getGoodProtein() == 1) {
                    goodProtein += elementBasic.getProtein();
                }

                if (elementBasic.getAnimalFat() == 1) {
                    animalFat += elementBasic.getFat();
                }


                // 组成元素结构类型：1,蛋白质， 2主食， 3,蔬菜水果， 4,坚果， 5豆类
                structType.add(elementBasic.getType());
            }
        }

        return setDietRecord(energy, fat, protein, cho, fiber, goodProtein, animalFat, structType);
    }

    private TbDietRecord setDietRecord(double energy, double fat, double protein, double cho, double fiber,
                                       double goodProtein, double animalFat, Set<Integer> structType) {
        TbDietRecord record = new TbDietRecord();
        record.setEnergy(energy);
        record.setFat(fat);
        record.setCho(cho);
        record.setProtein(protein);
        record.setFiber(fiber);
        record.setAnimalFat(animalFat);
        record.setGoodProtein(goodProtein);
        record.setStructureSet(structType.toString());

        return record;
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
     * @param target 原饮食记录
     * @param temp   新增饮食记录
     * @return 饮食记录
     */
    private TbDietRecord mergeDietRecord(TbDietRecord target, TbDietRecord temp) {
        // 能量 ,  脂肪，  蛋白质，  碳水化合物，  膳食纤维
        double energy = target.getEnergy(), fat = target.getFat(), goodProtein = target.getGoodProtein(),
                protein = target.getProtein(), cho = target.getCho(), fiber = target.getFiber(),
                animalFat = target.getAnimalFat();
        // 菜式拥有的营养种类
        Set<Integer> structType = DataTransferUtils.str2Set(target.getStructureSet());

        // 摄入能量
        energy += temp.getEnergy();

        // 营养素
        fat += temp.getFat();
        protein += temp.getProtein();
        cho += temp.getCho();
        fiber += temp.getFiber();

        // 优质蛋白，动物性脂肪
        goodProtein += temp.getGoodProtein();
        animalFat += temp.getAnimalFat();

        structType.addAll(DataTransferUtils.str2Set(temp.getStructureSet()));

        return setDietRecord(energy, fat, protein, cho, fiber, goodProtein, animalFat, structType);
    }

    /**
     * 初始化
     *
     * @param record 饮食记录
     */
    private void initDietRecord(TbDietRecord record) {
        record.setFat(0.0);
        record.setEnergy(0.0);
        record.setFat(0.0);
        record.setCho(0.0);
        record.setProtein(0.0);
        record.setFiber(0.0);
        record.setStructureSet("");
    }
}