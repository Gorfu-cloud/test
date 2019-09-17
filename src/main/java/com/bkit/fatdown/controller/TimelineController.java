package com.bkit.fatdown.controller;

import com.bkit.fatdown.common.utils.DateUtils;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.service.ITimelineService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @RequestMapping(value = "/energy/daily/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getDailyEnergy(@RequestParam String date, @PathVariable Integer uid) {

        if (date == null || uid ==null) {
            return CommonResultDTO.validateFailed();
        }

        Map<String,Double> map = timelineService.getDailyEnergy(uid,DateUtils.string2Date(date));

        if (map==null){
            return CommonResultDTO.validateFailed();
        }

        return CommonResultDTO.success(map);
    }

    @RequestMapping(value = "/energy/evaluation/daily/{uid}", method = RequestMethod.GET)
    public CommonResultDTO getDailyEnergyEvaluation(@RequestParam String date, @PathVariable Integer uid) {

        if (date == null || uid ==null) {
            return CommonResultDTO.validateFailed();
        }

        Map<String,Integer> map = timelineService.getDailyEnergyEvaluation(uid,DateUtils.string2Date(date));

        if (map==null){
            return CommonResultDTO.validateFailed();
        }

        return CommonResultDTO.success(map);
    }
}
