package com.bkit.fatdown.controller;

import cn.hutool.core.date.DateUtil;
import com.bkit.fatdown.common.utils.DateUtils;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.service.IDietReportService;
import com.bkit.fatdown.service.ITimelineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @file: TimelineController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 数据变化时间轴控制器
 * @date: Created in 9/17/19  11:26 AM
 * @modified:
 * @version: 1.0
 */
@Api(value = "/timeline", tags = "健康时间轴模块")
@RestController
@RequestMapping("/timeline")
@CrossOrigin
public class TimelineController {

    @Resource
    private ITimelineService timelineService;

    @Resource
    private IDietReportService reportService;

    @ApiOperation("个人: 查看一天能量变化")
    @RequestMapping(value = "/energy/daily/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getDailyEnergy(@RequestParam String date, @PathVariable Integer uid) {

        Date inputDate = DateUtil.parseDate(date);
        if (reportService.countDietMealReport(inputDate,uid)<3) {
            return CommonResultDTO.validateFailed();
        }

        Double[] energy = timelineService.getDailyEnergy(uid,inputDate);
        Integer[] evaluation = timelineService.getDailyEnergyEvaluation(uid, inputDate);
        if (energy == null) {
            return CommonResultDTO.failed();
        }

        Map<String, Object> map = new HashMap<>(2);
        map.put("energy", energy);
        map.put("evaluation", evaluation);

        return CommonResultDTO.success(map);
    }



//    public CommonResultDTO getMonthEnergy(){
//        return null;
//    }
//
//    public CommonResultDTO getMonthEnergyEvaluation(){
//        return null;
//    }
}
