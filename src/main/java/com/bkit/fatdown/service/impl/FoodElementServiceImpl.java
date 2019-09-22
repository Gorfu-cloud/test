package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.dto.food.FoodElementDTO;
import com.bkit.fatdown.entity.TbElementBasic;
import com.bkit.fatdown.entity.TbFoodElementRelation;
import com.bkit.fatdown.entity.TbFoodElementRelationExample;
import com.bkit.fatdown.mappers.TbFoodElementRelationMapper;
import com.bkit.fatdown.service.IElementBasicService;
import com.bkit.fatdown.service.IFoodElementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @file: FoodElementServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 食物元素关系表
 * @date: Created in 7/26/19  10:44 AM
 * @modified:
 * @version: 1.0
 */

@Service
public class FoodElementServiceImpl implements IFoodElementService {

    @Resource
    private TbFoodElementRelationMapper relationMapper;

    @Resource
    private IFoodElementService foodElementService;

    @Resource
    private IElementBasicService elementBasicService;

    /**
     * 创建关系
     *
     * @param foodElementRelation
     * @return
     */
    @Override
    public boolean insert(TbFoodElementRelation foodElementRelation) {
        foodElementRelation.setGmtCreate(new Date());
        foodElementRelation.setGmtModified(new Date());
        return relationMapper.insert(foodElementRelation) > 0;
    }

    /**
     * 更新关系
     *
     * @param foodElementRelation
     * @return
     */
    @Override
    public boolean update(TbFoodElementRelation foodElementRelation) {
        foodElementRelation.setGmtModified(new Date());
        return relationMapper.updateByPrimaryKeySelective(foodElementRelation) > 0;
    }

    /**
     * 删除关系
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(int id) {
        return relationMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 获取关系
     *
     * @param id
     * @return
     */
    @Override
    public TbFoodElementRelation getFoodElementRelation(int id) {
        return relationMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取菜式成分列表
     *
     * @param foodId 菜式id
     * @return
     */
    @Override
    public List<FoodElementDTO> listFoodElement(Integer foodId) {

        List<TbFoodElementRelation> relationList = foodElementService.listByFoodId(foodId);

        if (relationList.size() ==0) {
            return null;
        }

        List<FoodElementDTO> elementList = new ArrayList<>();
        FoodElementDTO element;

        for (TbFoodElementRelation relation : relationList) {
            Integer elementId = relation.getElement();
            Double gram = relation.getGram();
            TbElementBasic elementBasic = elementBasicService.getElementBasic(elementId);

            element = new FoodElementDTO();
            element.setRelationId(relation.getId());
            element.setElementId(elementId);
            element.setUpdateDate(relation.getGmtModified());
            element.setElementName(elementBasic.getName());
            element.setGram(gram);
            element.setEnergy(gram / 100 * elementBasic.getEnergy());

            elementList.add(element);
        }
        return elementList;
    }

    @Override
    public int countFoodId(int foodId) {
        TbFoodElementRelationExample example = new TbFoodElementRelationExample();
        example.createCriteria()
                .andFoodEqualTo(foodId);
        return (int)relationMapper.countByExample(example);
    }

    /**
     * @param relationId 记录id
     * @return
     */
    @Override
    public Integer count(int relationId) {
        TbFoodElementRelationExample example = new TbFoodElementRelationExample();
        example.createCriteria()
                .andIdEqualTo(relationId);
        return (int)relationMapper.countByExample(example);
    }

    /**
     * 获取食物组成元素名称和种类
     *
     * @param foodId
     * @return
     */
    @Override
    public HashMap<Integer, Double> getElementNameAndGram(int foodId) {
        TbFoodElementRelationExample example = new TbFoodElementRelationExample();
        example.createCriteria()
                .andFoodEqualTo(foodId);

        HashMap<Integer, Double> map = new HashMap<>(10);

        for (TbFoodElementRelation relation : relationMapper.selectByExample(example)) {
            map.put(relation.getElement(), relation.getGram());
        }

        return map;
    }

    /**
     * 获取菜式组成
     *
     * @param foodId 食物id
     * @return
     */
    @Override
    public List<TbFoodElementRelation> listByFoodId(int foodId) {
        TbFoodElementRelationExample example = new TbFoodElementRelationExample();
        example.createCriteria()
                .andFoodEqualTo(foodId);
        return relationMapper.selectByExample(example);
    }

    /**
     * 获取食物组成id
     *
     * @param foodId
     * @return
     */
    @Override
    public List<Integer> listElementId(int foodId) {
        TbFoodElementRelationExample example = new TbFoodElementRelationExample();
        example.createCriteria()
                .andFoodEqualTo(foodId);
        return transferList(relationMapper.selectByExample(example));
    }


    /**
     * 获取元素组成
     *
     * @param list
     * @return
     */
    private List<Integer> transferList(List<TbFoodElementRelation> list) {
        List<Integer> result = new ArrayList<>(list.size() + 1);
        for (TbFoodElementRelation relation : list) {
            result.add(relation.getId());
        }
        return result;
    }
}
