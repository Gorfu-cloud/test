package com.bkit.fatdown.controller.food;

import java.lang.reflect.Field;
import java.util.ArrayList;

import com.bkit.fatdown.dto.CommonPageDTO;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.dto.food.ElementRelationDTO;
import com.bkit.fatdown.dto.food.FoodElementDTO;
import com.bkit.fatdown.dto.food.FoodRecordInfoDTO;
import com.bkit.fatdown.entity.TbDietRecord;
import com.bkit.fatdown.entity.TbElementBasic;
import com.bkit.fatdown.entity.TbFoodElementRelation;
import com.bkit.fatdown.service.IDietFoodService;
import com.bkit.fatdown.service.IElementBasicService;
import com.bkit.fatdown.service.IFoodBasicService;
import com.bkit.fatdown.service.IFoodElementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Resource
    private IFoodElementService foodElementService;

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

    @ApiOperation("分页：查找名称,指定所有元素成分（名称可空、所有类型：0）")
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
    public CommonResultDTO addElementBasic(@RequestBody TbElementBasic elementBasic) {
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
    @RequestMapping(value = "/basic", method = RequestMethod.PUT)
    public CommonResultDTO updateElementBasic(@RequestBody TbElementBasic elementBasic) {
        if (elementBasic.getType() == null || elementBasic.getName() == null || elementBasic.getId() == null) {
            return CommonResultDTO.validateFailed();
        }

        if (elementBasicService.update(elementBasic)) {
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

    @ApiOperation("获取菜式成分")
    @CrossOrigin
    @RequestMapping(value = "/relation/{foodId}", method = RequestMethod.GET)
    public CommonResultDTO listElementRelation(@PathVariable Integer foodId) {
        if (foodId == null || foodBasicService.countFoodBasic(foodId) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed();
        }

        List<FoodElementDTO> elementList = foodElementService.listFoodElement(foodId);

        if (elementList.size() == DATA_NOT_EXIST){
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(elementList);
    }

    @ApiOperation("添加菜式成分")
    @CrossOrigin
    @RequestMapping(value = "/relation", method = RequestMethod.POST)
    public CommonResultDTO addElementRelation(@RequestBody ElementRelationDTO relationDTO) {
        if (relationDTO.getElementId() == null || relationDTO.getFoodId() == null || relationDTO.getGram() == null) {
            return CommonResultDTO.validateFailed();
        }

        TbFoodElementRelation relation = new TbFoodElementRelation();
        relation.setElement(relationDTO.getElementId());
        relation.setFood(relationDTO.getFoodId());
        relation.setGram(relationDTO.getGram());

        if (foodElementService.insert(relation)){
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("更新菜式成分")
    @CrossOrigin
    @RequestMapping(value = "/relation/{relationId}", method = RequestMethod.PUT)
    public CommonResultDTO updateElementRelation(@PathVariable Integer relationId,@RequestBody ElementRelationDTO relationDTO) {
        if (relationId==null||relationDTO.getElementId() == null || relationDTO.getFoodId() == null || relationDTO.getGram() == null) {
            return CommonResultDTO.validateFailed();
        }

        TbFoodElementRelation relation = new TbFoodElementRelation();
        relation.setId(relationId);
        relation.setElement(relationDTO.getElementId());
        relation.setFood(relationDTO.getFoodId());
        relation.setGram(relationDTO.getGram());

        if (foodElementService.update(relation)){
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("删除菜式成分")
    @CrossOrigin
    @RequestMapping(value = "/relation/{relationId}", method = RequestMethod.DELETE)
    public CommonResultDTO deleteElementRelation(@PathVariable Integer relationId) {
        if (relationId==null||foodElementService.count(relationId)==DATA_NOT_EXIST){
            return CommonResultDTO.validateFailed();
        }

        if (foodElementService.delete(relationId)){
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

//    public CommonResultDTO addFoodBasic(){    }
//    public CommonResultDTO updateFoodBasic(){}
//    public CommonResultDTO deleteFoodBasic(){}
//    public CommonResultDTO getFoodBasic(){}
//    public CommonResultDTO listFoodBasic(){}
}
