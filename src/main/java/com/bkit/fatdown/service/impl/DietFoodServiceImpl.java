package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.common.utils.DataTransferUtils;
import com.bkit.fatdown.common.utils.DateUtils;
import com.bkit.fatdown.component.ReportHelper;
import com.bkit.fatdown.dto.diet.DietMealReport;
import com.bkit.fatdown.dto.diet.ElementInfo;
import com.bkit.fatdown.dto.diet.MealEvaluationDTO;
import com.bkit.fatdown.dto.food.FoodRecordDTO;
import com.bkit.fatdown.dto.food.FoodRecordInfoDTO;
import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.mappers.TbDietUserStandardMapper;
import com.bkit.fatdown.mappers.TbFoodRecordMapper;
import com.bkit.fatdown.service.*;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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

    @Resource
    private IDietReportService reportService;

    private static final Logger logger = LoggerFactory.getLogger(DietFoodServiceImpl.class);

    private static final int BREAKFAST = 0;
    private static final int LUNCH = 1;
    private static final int DINNER = 2;
    private static final int DAILY = 4;
    private static final int WEEKLY = 5;
    private static final int MONTH = 6;

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
     * 类型：蛋白质1；主食2；蔬菜水果3；坚果4；豆类5。
     */
    private static final int PROTEIN = 1;
    private static final int STAPLE_FOOD = 2;
    private static final int FRUIT_VEGETABLE = 3;
    private static final int NUTS = 4;
    private static final int BEANS = 5;

    private static final int GOOD_PROTEIN = 1;
    private static final int ANIMAL_FAT = 1;
    private static final int FOOD_DEFAULT_TYPE = 0;

    /**
     * 保存饮食记录
     *
     * @param record 饮食记录
     * @return 保存结果
     */
    @Override

    public boolean insert(TbFoodRecord record) {
        if (record.getGmtCreate() == null) {
            record.setGmtCreate(new Date());
        }
        record.setGmtModified(new Date());
        return foodRecordMapper.insertSelective(record) > 0;
    }

    /**
     * 删除饮食记录
     *
     * @param uid 用户id
     * @param url 图片路径
     * @return 删除结果
     */
    @Override
    public boolean delete(int uid, String url) {
        TbFoodRecordExample example = new TbFoodRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andImgUrlEqualTo(url);
        return foodRecordMapper.deleteByExample(example) > 0;
    }

    @Override
    public boolean delete(int recordId) {
        return foodRecordMapper.deleteByPrimaryKey(recordId) > 0;
    }

    /**
     * 获取饮食记录
     *
     * @param id 获取饮食记录
     * @return 饮食记录
     */
    @Override
    public TbFoodRecord getFoodRecord(int id) {
        return foodRecordMapper.selectByPrimaryKey(id);
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
        return dietStandardMapper.insertSelective(standard) > 0;
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
        TbUserLifeStyle userLifeStyle = userLifeStyleService.getNewByUid(uid);
        TbUserPrivacyInfo privacyInfo = privacyInfoService.getNewByUid(uid);
        TbUserBasicInfo basicInfo = userBasicInfoService.getById(uid);

        if (userLifeStyle == null || privacyInfo == null) {
            return false;
        }

        return updateDietStandard(ReportHelper.getDietUserStandard(basicInfo, privacyInfo, userLifeStyle));
    }

    /**
     * 通过用户编号获取饮食标准
     *
     * @param uid 用户编号
     * @return
     */
    @Override
    public TbDietUserStandard getDietStandard(int uid) {
        return dietStandardMapper.selectByPrimaryKey(uid);
    }


    /**
     * 返回元素总和
     *
     * @param recordList 食物记录
     * @return 食物元素总和
     */
    @Override
    public TbDietRecord getDietRecordTotal(List<TbFoodRecord> recordList) {
        TbDietRecord target = new TbDietRecord();
        initDietRecord(target);

        // 为空时，直接返回初始化结果
        if (recordList.isEmpty()) {
            logger.warn("recordList is Empty");
            return target;
        }

        // 记录为1时，直接返回
        if (recordList.size() == 1) {
            int foodId = recordList.get(0).getFoodId();
            double eatPer = recordList.get(0).getEatPer();
            logger.info("recordList size: 1, and foodId:{} and eatPer:{} ", foodId, eatPer);
            return generateDietRecord(foodId, eatPer);
        }

        for (TbFoodRecord record : recordList) {
            int foodId = record.getFoodId();
            double eatPer = record.getEatPer();
            logger.info("recordList size: {}, and foodId:{} and eatPer:{} ", recordList.size(), foodId, eatPer);
            TbDietRecord temp = generateDietRecord(foodId, eatPer);
            target = mergeDietRecord(target, temp);
        }

        return target;
    }

    /**
     * 获取饮食成分总量
     *
     * @param recordList 总量记录
     * @return 总量
     */
    @Override
    public TbDietRecord getDietRecord(List<TbDietRecord> recordList) {

        if (recordList.size() == 1) {
            return recordList.get(0);
        }

        TbDietRecord target = new TbDietRecord();
        initDietRecord(target);
        for (TbDietRecord record : recordList) {
            target = mergeDietRecord(target, record);
        }

        return target;
    }


    /**
     * 更新饮食食物信息
     *
     * @param foodRecord 饮食食物信息
     * @return 更新情况
     */
    @Override
    public boolean updateFoodRecord(TbFoodRecord foodRecord) {
        foodRecord.setGmtModified(new Date());
        return foodRecordMapper.updateByPrimaryKeySelective(foodRecord) > 0;
    }

    @Override
    public List<TbFoodRecord> listFoodRecord(Integer uid, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        TbFoodRecordExample example = new TbFoodRecordExample();
        example.setOrderByClause("gmt_create desc");
        TbFoodRecordExample.Criteria criteria = example.createCriteria();
        if (uid != null) {
            criteria.andUserIdEqualTo(uid);
        }
        return foodRecordMapper.selectByExample(example);
    }

    @Override
    public List<TbFoodRecord> listFoodRecord(Integer uid, Date startDate, Date endDate, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        TbFoodRecordExample example = new TbFoodRecordExample();
        example.setOrderByClause("gmt_create desc");
        TbFoodRecordExample.Criteria criteria = example.createCriteria();

        if (uid != null) {
            criteria.andUserIdEqualTo(uid);
        }
        if (startDate != null && endDate != null) {
            criteria.andGmtCreateBetween(DateUtils.getDateStart(startDate), DateUtils.getDateEnd(endDate));
        }

        return foodRecordMapper.selectByExample(example);
    }

    @Override
    public Integer count(int id) {
        TbFoodRecordExample example = new TbFoodRecordExample();
        example.createCriteria()
                .andIdEqualTo(id);

        return (int) foodRecordMapper.countByExample(example);
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
    public List<TbFoodRecord> listFoodRecord(int uid, Date date, Integer type) {

        List<TbFoodRecord> foodRecordList;

        switch (type) {
            case BREAKFAST:
                foodRecordList = listFoodRecord(uid, DateUtils.getBreakfastStartTime(date), DateUtils.getBreakfastEndTime(date));
                break;
            case LUNCH:
                foodRecordList = listFoodRecord(uid, DateUtils.getLunchStartTime(date), DateUtils.getLunchEndTime(date));
                break;
            case DINNER:
                foodRecordList = listFoodRecord(uid, DateUtils.getDinnerStartTime(date), DateUtils.getDinnerEndTime(date));
                break;
            case DAILY:
                foodRecordList = listFoodRecord(uid, DateUtils.getDateStart(date), DateUtils.getDateEnd(date));
                break;
            case WEEKLY:
                foodRecordList = listFoodRecord(uid, DateUtils.getCurrentWeekStart(date), DateUtils.getCurrentWeekEnd(date));
                break;
            case MONTH:
                foodRecordList = listFoodRecord(uid, DateUtils.getMonthStartDate(date), DateUtils.getMonthStartDate(date));
                break;
            default:
                logger.error("DietFoodServiceImpl listFoodBasic , type out of index ,date:{} and type :{} and uid : {}", date, type, uid);
                foodRecordList = null;
        }

        return foodRecordList;
    }

    /**
     * 返回菜式列表
     *
     * @param uid
     * @param date
     * @param type
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<FoodRecordDTO> listFoodRecord(int uid, Date date, Integer type, Integer pageNum, Integer pageSize) {
        List<TbFoodRecord> foodRecordList = new ArrayList<>();
        switch (type) {
            case BREAKFAST:
                foodRecordList = listFoodRecord(uid, DateUtils.getBreakfastStartTime(date), DateUtils.getBreakfastEndTime(date), pageNum, pageSize);
                break;
            case LUNCH:
                foodRecordList = listFoodRecord(uid, DateUtils.getLunchStartTime(date), DateUtils.getLunchEndTime(date), pageNum, pageSize);
                break;
            case DINNER:
                foodRecordList = listFoodRecord(uid, DateUtils.getDinnerStartTime(date), DateUtils.getDinnerEndTime(date), pageNum, pageSize);
                break;
            case DAILY:
                foodRecordList = listFoodRecord(uid, DateUtils.getDateStart(date), DateUtils.getDateEnd(date), pageNum, pageSize);
                break;
            case WEEKLY:
                foodRecordList = listFoodRecord(uid, DateUtils.getCurrentWeekStart(date), DateUtils.getCurrentWeekEnd(date), pageNum, pageSize);
                break;
            case MONTH:
                foodRecordList = listFoodRecord(uid, DateUtils.getMonthStartDate(date), DateUtils.getMonthStartDate(date), pageNum, pageSize);
                break;
            default:
                logger.error("DietFoodServiceImpl listFoodBasic , type out of index ,date:{} and type :{} and uid : {}", date, type, uid);
        }
        return listFoodRecordByName(foodRecordList);
    }

    private List<FoodRecordDTO> listFoodRecordByName(List<TbFoodRecord> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<FoodRecordDTO> result = new ArrayList<>();
        FoodRecordDTO foodRecord;
        for (TbFoodRecord record : list) {
            foodRecord = new FoodRecordDTO();
            BeanUtils.copyProperties(record, foodRecord);
            // 获取菜式名称
            String foodName = foodBasicService.getFoodBasic(foodRecord.getFoodId()).getFoodName();
            foodRecord.setFoodName(foodName);

            result.add(foodRecord);
        }

        return result;
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
    public List<FoodRecordInfoDTO> listFoodInfoDTO(int uid, Date date, Integer type) {
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
     * 获取元素总和
     *
     * @param foodId 食物编号
     * @param eatPer 食用度
     * @return
     */
    @Override
    public TbDietRecord generateDietRecord(int foodId, double eatPer) {
        // 能量 ,  脂肪，  蛋白质，  碳水化合物，  膳食纤维 , 动物性脂肪， 优质蛋白质
        double energy = 0, fat = 0, protein = 0, carbs = 0, insolubleFiber = 0, animalFat = 0, goodProtein = 0;
        double vitaminA = 0, vitaminB1 = 0, vitaminB2 = 0, vitaminB3 = 0, vitaminC = 0, vitaminE = 0;
        double ca = 0, p = 0, k = 0, mg = 0, fe = 0, zn = 0, se = 0, cu = 0, na = 0, mn = 0;
        // 菜式拥有的营养结构种类
        Set<Integer> structType = new TreeSet<>(), proteinSet = new TreeSet<>(), stapleFoodSet = new TreeSet<>(),
                fruitVegetableSet = new TreeSet<>(), beansSet = new TreeSet<>(), nutsSet = new TreeSet<>();
        // 菜式信息
        TbFoodBasic foodBasic = foodBasicService.getFoodBasic(foodId);
        // 存该菜式记录时,计算菜式组成成分，元素总量
        if (foodBasic.getFlag() == EXIST_FOOD) {
            // 获取食物元素组成(蛋白质等）
            Map<Integer, Double> map = foodElementService.getElementNameAndGram(foodId);
            // 计算组成总量
            for (Map.Entry<Integer, Double> entry : map.entrySet()) {
                // 计算根据每一百克，计算对应的元素含量
                TbElementBasic elementBasic = elementBasicService.getElementBasic(entry.getKey());
                logger.info("elementBasic , id:{} and type:{} and goodProtein: {} and animalFat: {}",
                        elementBasic.getId(), elementBasic.getType(), elementBasic.getGoodProtein(), elementBasic.getAnimalFat());

                // 元素重量基于100g元素成分,转换为干重比的后的比例
                double trueGram = entry.getValue() * elementBasic.getDryPer();
                double elementPer = (trueGram / FOOD_GRAM_BASE);
                // 能量摄入
                energy += (elementPer) * elementBasic.getEnergy();
                // 营养素
                protein += elementPer * elementBasic.getProtein();
                carbs += elementPer * elementBasic.getCarbs();
                insolubleFiber += elementPer * elementBasic.getInsolubleFiber();
                fat += elementPer * elementBasic.getFat();
                // 维生素
                vitaminA += elementPer * elementBasic.getVitaminA();
                vitaminB1 += elementPer * elementBasic.getVitaminB1();
                vitaminB2 += elementPer * elementBasic.getVitaminB2();
                vitaminB3 += elementPer * elementBasic.getVitaminB3();
                vitaminC += elementPer * elementBasic.getVitaminC();
                vitaminE += elementPer * elementBasic.getVitaminE();
                // 矿物质
                ca += elementPer * elementBasic.getCa();
                p += elementPer * elementBasic.getP();
                k += elementPer * elementBasic.getK();
                mg += elementPer * elementBasic.getMg();
                fe += elementPer * elementBasic.getFe();
                zn += elementPer * elementBasic.getZn();
                se += elementPer * elementBasic.getSe();
                cu += elementPer * elementBasic.getCu();
                mn += elementPer * elementBasic.getMn();
                na += elementPer * elementBasic.getNa();

                // 统计优质蛋白
                if (elementBasic.getGoodProtein() == GOOD_PROTEIN) {
                    goodProtein += elementBasic.getProtein() * elementPer;
                }
                // 统计动物性脂肪
                if (elementBasic.getAnimalFat() == ANIMAL_FAT) {
                    animalFat += elementBasic.getFat() * elementPer;
                }
                // 组成元素结构类型：1,蛋白质， 2主食， 3,蔬菜水果， 4,坚果， 5豆类
                if (elementBasic.getType() != FOOD_DEFAULT_TYPE) {
                    logger.info("add structType, type : {} and set:{}", elementBasic.getType(), structType.toString());
                    structType.add(elementBasic.getType());
                }
                // 统计每次食物种类
                switch (elementBasic.getType()) {
                    case PROTEIN:
                        proteinSet.add(elementBasic.getId());
                        break;
                    case STAPLE_FOOD:
                        stapleFoodSet.add(elementBasic.getId());
                        break;
                    case FRUIT_VEGETABLE:
                        fruitVegetableSet.add(elementBasic.getId());
                        break;
                    case BEANS:
                        beansSet.add(elementBasic.getId());
                        break;
                    case NUTS:
                        nutsSet.add(elementBasic.getId());
                        break;
                    default:
                        logger.error("elementBasic type error , type : {}", elementBasic.getType());
                }
            }
        }


        TbDietRecord record = new TbDietRecord();
        initDietRecord(record);
        // 根据实际食用，计算能量
        if (eatPer < 1) {
            // 设置每天评价需要数据
            setDaily(record, (eatPer * energy), (eatPer * fat), (protein * eatPer), (carbs * eatPer), (insolubleFiber * eatPer),
                    (goodProtein * eatPer), (eatPer * animalFat), structType, proteinSet, stapleFoodSet, fruitVegetableSet, beansSet, nutsSet);
            // 设置维生素数据
            setVitamin(record, (eatPer * vitaminA), (eatPer * vitaminB1), (eatPer * vitaminB2), (eatPer * vitaminB3),
                    (eatPer * vitaminC), (eatPer * vitaminE));
            // 设置矿物质数据
            setMinerals(record, (eatPer * ca), (eatPer * p), (k * eatPer), (eatPer * mg), (fe * eatPer), (zn * eatPer),
                    (se * eatPer), (cu * eatPer), (na * eatPer), (mn * eatPer));
        } else {
            setDaily(record, energy, fat, protein, carbs, insolubleFiber, goodProtein, animalFat, structType,
                    proteinSet, stapleFoodSet, fruitVegetableSet, beansSet, nutsSet);
            setVitamin(record, vitaminA, vitaminB1, vitaminB2, vitaminB3, vitaminC, vitaminE);
            setMinerals(record, ca, p, k, mg, fe, zn, se, cu, na, mn);
        }

        return record;
    }

    private void setMinerals(TbDietRecord record, double ca, double p, double k, double mg, double fe, double zn, double se,
                             double cu, double na, double mn) {
        record.setCa(ca);
        record.setP(p);
        record.setK(k);
        record.setMg(mg);
        record.setFe(fe);
        record.setZn(zn);
        record.setSe(se);
        record.setCu(cu);
        record.setNa(na);
        record.setMn(mn);
    }

    private void setVitamin(TbDietRecord record, double va, double vb1, double vb2, double vb3, double vc, double ve) {
        record.setVitaminA(va);
        record.setVitaminB1(vb1);
        record.setVitaminB2(vb2);
        record.setVitaminB3(vb3);
        record.setVitaminC(vc);
        record.setVitaminE(ve);
    }

    private void setDaily(TbDietRecord record, double energy, double fat, double protein, double carbs, double insolubleFibre, double goodProtein,
                          double animalFat, Set<Integer> structType, Set<Integer> proteinSet, Set<Integer> stapleFoodSet,
                          Set<Integer> fruitVegetableSet, Set<Integer> beansSet, Set<Integer> nutsSet) {
        record.setEnergy(energy);

        record.setFat(fat);
        record.setCarbs(carbs);
        record.setProtein(protein);
        record.setInsolubleFiber(insolubleFibre);

        // 动物性脂肪，优质蛋白
        record.setAnimalFat(animalFat);
        record.setGoodProtein(goodProtein);

        // 食物种类结构
        record.setStructureSet(structType.toString());

        // 食物种类均衡评价
        record.setProteinSet(proteinSet.toString());
        record.setStapleFoodSet(stapleFoodSet.toString());
        record.setFruitVegetableSet(fruitVegetableSet.toString());
        record.setBeansSet(beansSet.toString());
        record.setNutsSet(nutsSet.toString());
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

    @Override
    public List<TbFoodRecord> listFoodRecord(int uid, Date start, Date end, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
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
    private List<FoodRecordInfoDTO> listFoodInfoDTO(List<TbFoodRecord> recordList) {
        List<FoodRecordInfoDTO> foodRecordInfoDTOList = new ArrayList<>(8);
        FoodRecordInfoDTO foodRecordInfoDTO;
        for (TbFoodRecord record : recordList) {
            foodRecordInfoDTO = new FoodRecordInfoDTO();
            TbFoodBasic basic = foodBasicService.getFoodBasic(record.getFoodId());
            foodRecordInfoDTO.setId(record.getId());
            // 设置食用比例，×100，方便显示
            foodRecordInfoDTO.setEatPer(record.getEatPer() * 100);
            foodRecordInfoDTO.setFoodName(basic.getFoodName());
            foodRecordInfoDTO.setFoodGram(basic.getQuantity());
            foodRecordInfoDTOList.add(foodRecordInfoDTO);
        }

        return foodRecordInfoDTOList;
    }

    /**
     * 获取饮食评价
     *
     * @param recordId 用餐记录
     * @return 当餐饮食能量分配情况
     */
    @Override
    public MealEvaluationDTO getEvaluationByRecordId(Integer recordId) {
        TbFoodRecord foodRecord = getFoodRecord(recordId);

        if (foodRecord == null) {
            return null;
        }

        // 获取用餐类型:早午晚餐.0 1 2
        int type = DateUtils.getMealType(foodRecord.getGmtCreate());
        Integer uid = foodRecord.getUserId();
        Date date = foodRecord.getGmtCreate();

        // 获取相关摄入记录
        List<TbFoodRecord> recordList = listFoodRecord(uid, date, type);

        if (recordList.size() == 0) {
            return null;
        }

        DietMealReport report = reportService.generateMealReport(date, uid, type);

        // 获取饮食报告
        if (report == null) {
            logger.error("meal report is null, uid: {} and date: {} and type: {}", uid, date, type);
            return null;
        }

        MealEvaluationDTO mealEvaluation = new MealEvaluationDTO();

        mealEvaluation.setEnergyEvaluation(report.getEnergyEvaluation());
        mealEvaluation.setStructureEvaluation(report.getStructureEvaluation());

        HashMap<String, ElementInfo> map = new HashMap<>(10);
        List<TbFoodBasic> lackList = new ArrayList<>(10);

        TbDietRecord record1;
        TbFoodBasic foodBasic;
        for (TbFoodRecord foodRecord1 : recordList) {
            // 获取菜式信息
            foodBasic = foodBasicService.getFoodBasic(foodRecord1.getFoodId());
            // 判断是否已经拆解了。
            if (foodBasic.getFlag() == 1) {
                lackList.add(foodBasic);
                continue;
            }

            // 生成已经拆解的菜式信息
            record1 = generateDietRecord(foodRecord1.getFoodId(), foodRecord1.getEatPer());
            ElementInfo info = new ElementInfo();
            // 复制 record 中的属性
            BeanUtils.copyProperties(record1, info);

            info.setBeansSet(DataTransferUtils.str2Set(record1.getBeansSet()));
            info.setFruitVegetableSet(DataTransferUtils.str2Set(record1.getFruitVegetableSet()));
            info.setStapleFoodSet(DataTransferUtils.str2Set(record1.getStapleFoodSet()));
            info.setProteinSet(DataTransferUtils.str2Set(record1.getProteinSet()));
            info.setNutsSet(DataTransferUtils.str2Set(record1.getNutsSet()));
            info.setStructureSet(DataTransferUtils.str2Set(record1.getStructureSet()));

            map.put(foodBasic.getFoodName(), info);
        }

        mealEvaluation.setElementList(map);
        mealEvaluation.setLackList(lackList);
        return mealEvaluation;
    }

    /**
     * 合并计算总量
     *
     * @param target 原饮食记录
     * @param temp   新增饮食记录
     * @return 饮食记录
     */
    @Override
    public TbDietRecord mergeDietRecord(TbDietRecord target, TbDietRecord temp) {
        // 能量 ,  脂肪，  蛋白质，  碳水化合物，  膳食纤维
        double energy = target.getEnergy(), fat = target.getFat(), goodProtein = target.getGoodProtein(),
                protein = target.getProtein(), carbs = target.getCarbs(), fiber = target.getInsolubleFiber(),
                animalFat = target.getAnimalFat();
        double vitaminA = target.getVitaminA(), vitaminB1 = target.getVitaminB1(), vitaminB2 = target.getVitaminB2(),
                vitaminB3 = target.getVitaminB3(), vitaminC = target.getVitaminC(), vitaminE = target.getVitaminE();
        double ca = target.getCa(), p = target.getP(), k = target.getK(), mg = target.getMg(), fe = target.getFe(),
                zn = target.getZn(), se = target.getSe(), cu = target.getCu(), na = target.getNa(), mn = target.getMn();

        // 菜式拥有的营养种类
        Set<Integer> structType = DataTransferUtils.str2Set(target.getStructureSet());

        // 统计每次食物种类
        Set<Integer> proteinSet = DataTransferUtils.str2Set(target.getProteinSet());
        Set<Integer> stapleFoodSet = DataTransferUtils.str2Set(target.getStapleFoodSet());
        Set<Integer> fruitVegetableSet = DataTransferUtils.str2Set(target.getFruitVegetableSet());
        Set<Integer> beansSet = DataTransferUtils.str2Set(target.getBeansSet());
        Set<Integer> nutsSet = DataTransferUtils.str2Set(target.getNutsSet());

        // 摄入能量
        energy += temp.getEnergy();

        // 营养素
        fat += temp.getFat();
        protein += temp.getProtein();
        carbs += temp.getCarbs();
        fiber += temp.getInsolubleFiber();

        // 优质蛋白，动物性脂肪
        goodProtein += temp.getGoodProtein();
        animalFat += temp.getAnimalFat();
        // 维生素
        vitaminA += temp.getVitaminA();
        vitaminB1 += temp.getVitaminB1();
        vitaminB2 += temp.getVitaminB2();
        vitaminB3 += temp.getVitaminB3();
        vitaminC += temp.getVitaminC();
        vitaminE += temp.getVitaminE();
        // 矿物质
        ca += temp.getCa();
        p += temp.getP();
        k += temp.getK();
        mg += temp.getMg();
        fe += temp.getFe();
        zn += temp.getZn();
        se += temp.getSe();
        cu += temp.getCu();
        mn += temp.getMn();
        na += temp.getNa();

        structType.addAll(DataTransferUtils.str2Set(temp.getStructureSet()));
        proteinSet.addAll(DataTransferUtils.str2Set(temp.getProteinSet()));
        fruitVegetableSet.addAll(DataTransferUtils.str2Set(temp.getFruitVegetableSet()));
        stapleFoodSet.addAll(DataTransferUtils.str2Set(temp.getStapleFoodSet()));
        beansSet.addAll(DataTransferUtils.str2Set(temp.getBeansSet()));
        nutsSet.addAll(DataTransferUtils.str2Set(temp.getNutsSet()));

        TbDietRecord record = new TbDietRecord();
        initDietRecord(record);
        // 设置每天评价需要数据
        setDaily(record, energy, fat, protein, carbs, fiber, goodProtein, animalFat, structType,
                proteinSet, stapleFoodSet, fruitVegetableSet, beansSet, nutsSet);
        logger.info("setDaily record , energy {}, fat {}, protein {}, carbs {}, fiber {}, goodProtein {}, animalFat {}, " +
                        "structType {},proteinSet {}, stapleFoodSet {}, fruitVegetableSet {}, beansSet {}, nutsSet {}",
                energy, fat, protein, carbs, fiber, goodProtein, animalFat, structType.toString(), proteinSet.toString(),
                stapleFoodSet.toString(), fruitVegetableSet.toString(), beansSet.toString(), nutsSet.toString());
        // 设置维生素数据
        setVitamin(record, vitaminA, vitaminB1, vitaminB2, vitaminB3, vitaminC, vitaminE);
        logger.info("set vitamin, v-A {},v-B1 {},v-B2 {},v-B3 {},v-C {},v-E {}",
                vitaminA, vitaminB1, vitaminB2, vitaminB3, vitaminC, vitaminE);
        // 设置矿物质数据
        setMinerals(record, ca, p, k, mg, fe, zn, se, cu, na, mn);
        logger.info("set minerals, ca {},p {},k {},mg {},fe {},zn {},se {},cu {},na {},mn {}", ca, p, k, mg, fe, zn, se, cu, na, mn);
        return record;
    }

    /**
     * 初始化
     *
     * @param record 饮食记录
     */
    private void initDietRecord(TbDietRecord record) {
        record.setEnergy(0.0);

        // 营养素含量
        record.setFat(0.0);
        record.setCarbs(0.0);
        record.setProtein(0.0);
        record.setInsolubleFiber(0.0);
        record.setSolubleFiber(0.0);

        // 饮食结构种类
        record.setStructureSet("");

        // 膳食均衡种类：蛋白质，主食，蔬菜水果，豆类
        record.setProteinSet("");
        record.setStapleFoodSet("");
        record.setFruitVegetableSet("");
        record.setBeansSet("");
        record.setNutsSet("");

        record.setGoodProtein(0.0);
        record.setAnimalFat(0.0);

        record.setCa(0.0);
        record.setP(0.0);
        record.setK(0.0);
        record.setMg(0.0);
        record.setFe(0.0);
        record.setZn(0.0);
        record.setSe(0.0);
        record.setCu(0.0);
        record.setNa(0.0);
        record.setMn(0.0);

        record.setVitaminA(0.0);
        record.setVitaminB1(0.0);
        record.setVitaminB2(0.0);
        record.setVitaminB3(0.0);
        record.setVitaminC(0.0);
        record.setVitaminE(0.0);
    }
}