package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonPageDTO;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.dto.food.ElementBasicDTO;
import com.bkit.fatdown.entity.TbDietRecord;
import com.bkit.fatdown.entity.TbElementBasic;
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

    @ApiOperation("根据菜式id,获取元素成分总和")
    @CrossOrigin
    @RequestMapping(value = "/elementTotal/{id}", method = RequestMethod.GET)
    public CommonResultDTO<TbDietRecord> getFoodElementTotalById(@PathVariable Integer id, @RequestParam Double eatPer) {
        if (foodBasicService.countFoodBasic(id) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed("id错误");
        }
        return CommonResultDTO.success(foodService.generateDietRecord(id, eatPer / 100));
    }

    @ApiOperation("分页：查找名称,指定元素成分（名称可空、所有类型：-1）")
    @CrossOrigin
    @RequestMapping(value = "/basic/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public CommonResultDTO listElementInfo(@RequestParam(required = false) String name, @RequestParam Integer type,
                                           @PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        if (type == null || pageNum == null || pageSize == null) {
            return CommonResultDTO.validateFailed();
        }

        return CommonResultDTO.success(CommonPageDTO.restPage(elementBasicService.listByPage(name, type, pageNum, pageSize)));
    }

    @ApiOperation("添加元素成分")
    @CrossOrigin
    @RequestMapping(value = "/basic", method = RequestMethod.POST)
    public CommonResultDTO addElementBasic(@RequestBody ElementBasicDTO elementBasic) {
        if (elementBasic.getType() == null || elementBasic.getName() == null) {
            return CommonResultDTO.validateFailed();
        }

        if (elementBasicService.insert(elementBasic)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("删除元素成分")
    @CrossOrigin
    @RequestMapping(value = "/basic/{id}", method = RequestMethod.DELETE)
    public CommonResultDTO deleteElementBasic(@PathVariable Integer id) {
        if (id == null) {
            return CommonResultDTO.validateFailed();
        }

        if (elementBasicService.delete(id)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("更新元素成分")
    @CrossOrigin
    @RequestMapping(value = "/basic/{id}", method = RequestMethod.PUT)
    public CommonResultDTO updateElementBasic(@RequestBody ElementBasicDTO elementBasic,@PathVariable Integer id) {
        if (elementBasic == null||id==null) {
            return CommonResultDTO.validateFailed();
        }

        if (elementBasicService.update(id,elementBasic)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("通过id,获取元素成分")
    @CrossOrigin
    @RequestMapping(value = "/basic/{id}", method = RequestMethod.GET)
    public CommonResultDTO getElementBasic(@PathVariable Integer id) {
        if (id == null) {
            return CommonResultDTO.validateFailed();
        }

        TbElementBasic elementBasic = elementBasicService.getElementBasic(id);
        if (elementBasic == null) {
            return CommonResultDTO.failed();
        }
        return CommonResultDTO.success(elementBasic);
    }
}
