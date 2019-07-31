package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.dto.DietDailyReport;
import com.bkit.fatdown.dto.DietMealReport;
import com.bkit.fatdown.dto.ElementTotalDTO;
import com.bkit.fatdown.dto.UserReportDTO;
import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.service.IDietReportService;
import com.bkit.fatdown.utils.DateUtils;
import com.bkit.fatdown.utils.MathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @file: DietReportServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 饮食评价实现类
 * @date: Created in 7/25/19  3:26 PM
 * @modified:
 * @version: 1.0
 */

@Service
public class DietReportServiceImpl implements IDietReportService {

    @Resource
    private DietFoodServiceImpl foodService;

    private static final Logger logger = LoggerFactory.getLogger(DietReportServiceImpl.class);

    /**
     * @param date 报告日期
     * @param uid  用户编号
     * @param type 报告类型：4每天
     * @return 每天饮食报告
     */
    @Override
    public DietDailyReport generateDailyReport(Date date, Integer uid, Integer type) {
        // 获取菜式id列表
        List<Integer> foodIdList = listFoodId(foodService.listFoodBasic(uid, date, type));
        // 计算菜式组成成分总量
        TbDietRecord record = foodService.getDietRecordTotalByFoodList(foodIdList);

        TbDietUserStandard userStandard = foodService.getDietStandard(uid);

        return MathUtils.getDietDailyReport(userStandard, record);
    }

    /**
     * 生成每餐饮食报告
     *
     * @param date 报告日期
     * @param uid  用户编号
     * @param type 报告类型：0早餐,1午餐,2晚餐,3加餐,4每日,5每周,6每月
     * @return 每餐饮食报告
     */
    @Override
    public DietMealReport generateMealReport(Date date, Integer uid, Integer type) {
        // 获取菜式id列表
        List<Integer> foodIdList = listFoodId(foodService.listFoodBasic(uid, date, type));
        // 计算菜式组成成分总量
        TbDietRecord record = foodService.getDietRecordTotalByFoodList(foodIdList);

        TbDietUserStandard userStandard = foodService.getDietStandard(uid);


//        if (!saveReport(reportDTO, uid, type, date)) {
//            logger.error("tb_diet_report insert or update false，uid：{} and type：{} at date：{}", uid, type, date);
//        }
        return MathUtils.getDietMealReport(userStandard, record, type);
    }


    /**
     * 获取菜式id
     *
     * @param foodRecordList 饮食记录
     * @return 返回 菜式列表id
     */
    private List<Integer> listFoodId(List<TbFoodRecord> foodRecordList) {
        List<Integer> foodIdList = new ArrayList<>(foodRecordList.size() + 1);

        for (TbFoodRecord record : foodRecordList) {
            foodIdList.add(record.getFoodId());
        }
        return foodIdList;
    }
}
