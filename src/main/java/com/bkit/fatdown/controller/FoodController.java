package com.bkit.fatdown.controller;

import com.bkit.fatdown.dto.CommonPageDTO;
import com.bkit.fatdown.dto.CommonResultDTO;
import com.bkit.fatdown.dto.food.ElementRelationDTO;
import com.bkit.fatdown.dto.food.FoodBasicDTO;
import com.bkit.fatdown.dto.food.FoodElementDTO;
import com.bkit.fatdown.entity.TbFoodBasic;
import com.bkit.fatdown.entity.TbFoodElementRelation;
import com.bkit.fatdown.service.IFoodBasicService;
import com.bkit.fatdown.service.IFoodElementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @file: BasicController
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 菜式管理
 * @date: Created in 2019/8/28 16:24
 * @modified:
 * @version: 1.0
 */
@Api(value = "/food", tags = "菜式信息模块")
@RestController
@RequestMapping("/food/basic")
public class FoodController {

    @Resource
    private IFoodBasicService foodBasicService;

    @Resource
    private IFoodElementService foodElementService;

    private static final Integer DATA_NOT_EXIST = 0;

    @ApiOperation("添加菜式信息")
    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.POST)
    public CommonResultDTO addFoodBasic(@RequestBody FoodBasicDTO foodBasicDTO) {
        if (foodBasicDTO == null) {
            return CommonResultDTO.validateFailed();
        }

        TbFoodBasic foodBasic = new TbFoodBasic();
        BeanUtils.copyProperties(foodBasicDTO, foodBasic);

        if (foodBasicService.insert(foodBasic)) {
            return CommonResultDTO.success();
        }
        return CommonResultDTO.failed();
    }

    @ApiOperation("更新菜式信息")
    @CrossOrigin
    @RequestMapping(value = "/{foodId}", method = RequestMethod.PUT)
    public CommonResultDTO updateFoodBasic(@PathVariable Integer foodId, @RequestBody FoodBasicDTO foodBasicDTO) {
        if (foodBasicDTO == null || foodId == null || foodBasicService.countFoodBasic(foodId) == 0) {
            return CommonResultDTO.validateFailed();
        }
        TbFoodBasic foodBasic = new TbFoodBasic();
        BeanUtils.copyProperties(foodBasicDTO, foodBasic);
        foodBasic.setId(foodId);

        if (foodBasicService.update(foodBasic)) {
            return CommonResultDTO.success();
        }
        return CommonResultDTO.failed();
    }

    @ApiOperation("删除菜式信息")
    @CrossOrigin
    @RequestMapping(value = "/{foodId}", method = RequestMethod.DELETE)
    public CommonResultDTO deleteFoodBasic(@PathVariable Integer foodId) {
        if (foodId == null || foodBasicService.countFoodBasic(foodId) == 0) {
            return CommonResultDTO.validateFailed();
        }

        if (foodBasicService.delete(foodId)) {
            return CommonResultDTO.success();
        }
        return CommonResultDTO.failed();
    }

    @ApiOperation("获取菜式信息")
    @CrossOrigin
    @RequestMapping(value = "/{foodId}", method = RequestMethod.GET)
    public CommonResultDTO getFoodBasic(@PathVariable Integer foodId) {
        if (foodId == null || foodBasicService.countFoodBasic(foodId) == 0) {
            return CommonResultDTO.validateFailed();
        }

        TbFoodBasic foodBasic = foodBasicService.getFoodBasic(foodId);

        if (foodBasic == null) {
            return CommonResultDTO.failed();
        }

        return CommonResultDTO.success(foodBasic);
    }

    @ApiOperation("分页: 查找菜式信息")
    @CrossOrigin
    @RequestMapping(value = "/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public CommonResultDTO listFoodBasic(@RequestParam(required = false) String foodName,
                                         @PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        if (pageNum == null || pageSize == null) {
            return CommonResultDTO.validateFailed();
        }

        if (foodName == null) {
            return CommonResultDTO.success(CommonPageDTO.restPage(foodBasicService.listByPage(pageNum, pageSize)));
        }

        return CommonResultDTO.success(CommonPageDTO.restPage(foodBasicService.listByPage(foodName, pageNum, pageSize)));
    }

    @ApiOperation("获取菜式成分")
    @CrossOrigin
    @RequestMapping(value = "/relation/{foodId}", method = RequestMethod.GET)
    public CommonResultDTO listElementRelation(@PathVariable Integer foodId) {
        if (foodId == null || foodBasicService.countFoodBasic(foodId) == DATA_NOT_EXIST || foodElementService.countFoodId(foodId) == DATA_NOT_EXIST) {
            return CommonResultDTO.validateFailed();
        }

        List<FoodElementDTO> elementList = foodElementService.listFoodElement(foodId);

        if (elementList.size() == DATA_NOT_EXIST) {
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

        if (foodElementService.insert(relation)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("更新菜式成分")
    @CrossOrigin
    @RequestMapping(value = "/relation/{relationId}", method = RequestMethod.PUT)
    public CommonResultDTO updateElementRelation(@PathVariable Integer relationId, @RequestBody ElementRelationDTO relationDTO) {
        if (relationId == null || relationDTO.getElementId() == null || relationDTO.getFoodId() == null || relationDTO.getGram() == null) {
            return CommonResultDTO.validateFailed();
        }

        TbFoodElementRelation relation = new TbFoodElementRelation();
        relation.setId(relationId);
        relation.setElement(relationDTO.getElementId());
        relation.setFood(relationDTO.getFoodId());
        relation.setGram(relationDTO.getGram());

        if (foodElementService.update(relation)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }

    @ApiOperation("删除菜式成分")
    @CrossOrigin
    @RequestMapping(value = "/relation/{relationId}", method = RequestMethod.DELETE)
    public CommonResultDTO deleteElementRelation(@PathVariable Integer relationId) {
        if (relationId == null || foodElementService.count(relationId).equals(DATA_NOT_EXIST)) {
            return CommonResultDTO.validateFailed();
        }

        if (foodElementService.delete(relationId)) {
            return CommonResultDTO.success();
        }

        return CommonResultDTO.failed();
    }
}
