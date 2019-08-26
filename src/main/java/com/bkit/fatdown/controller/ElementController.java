package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonPageDTO;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.entity.TbDietRecord;
import com.bkit.fatdown.service.IDietFoodService;
import com.bkit.fatdown.service.IElementBasicService;
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

    @Resource
    private IElementBasicService elementBasicService;

    private static final int DATA_NOT_EXIST = 0;

    @ApiOperation("计算菜式成分总和")
    @CrossOrigin
    @RequestMapping(value = "/elementTotal/{id}", method = RequestMethod.GET)
    public CommonResultDTO<TbDietRecord> getFoodElementTotalById(@PathVariable Integer id, @RequestParam Double eatPer) {
        if (foodBasicService.countFoodBasic(id) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("id错误");
        }
        return CommonResultDTO.success(foodService.generateDietRecord(id, eatPer / 100));
    }

    @ApiOperation("分页：查找指定所有元素成分（名称可空、所有类型：0）")
    @CrossOrigin
    @RequestMapping(value = "/basic/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public CommonResultDTO listElementInfo(@RequestParam(required = false) String name, @RequestParam Integer type,
                                           @PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        if (type == null || pageNum == null || pageSize == null) {
            return CommonResultDTO.validateFailed();
        }

        return CommonResultDTO.success(CommonPageDTO.restPage(elementBasicService.listByPage(name, type, pageNum, pageSize)));
    }

    @ApiOperation("通过id查找成分所含元素")
    @CrossOrigin
    @RequestMapping(value = "/basic/{id}", method = RequestMethod.GET)
    public CommonResultDTO getElementInfo(@PathVariable Integer id) {
        if (id == null) {
            return CommonResultDTO.validateFailed();
        }
        return CommonResultDTO.success(elementBasicService.getElementBasic(id));
    }
}
