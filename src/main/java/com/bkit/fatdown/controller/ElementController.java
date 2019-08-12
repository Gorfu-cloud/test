package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.service.IDietFoodService;
import com.bkit.fatdown.service.IFoodBasicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @file: ElementController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 菜式成分模块控制器
 * @date: Created in 8/12/19  4:13 PM
 * @modified:
 * @version: 1.0
 */
@Api(value = "/element", tags = "菜式成分模块")
@RequestMapping("/element")
@RestController
public class ElementController {

    @Resource
    private IDietFoodService foodService;

    @Resource
    private IFoodBasicService foodBasicService;

    private static final int DATA_NOT_EXIST = 0;

    @ApiOperation("计算菜式成分总和")
    @CrossOrigin
    @RequestMapping(value = "/elementTotal/{id}", method = RequestMethod.GET)
    public CommonResultDTO getFoodElementTotalById(@PathVariable Integer id) {
        if (foodBasicService.countFoodBasic(id) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("id错误");
        }
        return CommonResultDTO.success(foodService.generateDietRecord(id));
    }
}
