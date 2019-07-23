package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbFoodBasic;
import com.bkit.fatdown.entity.TbFoodBasicExample;
import com.bkit.fatdown.mappers.TbFoodBasicMapper;
import com.bkit.fatdown.service.IFoodBasicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @file: FoodBasicServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 菜式功能接口实现类
 * @date: Created in 7/23/19  10:22 PM
 * @modified:
 * @version: 1.0
 */

@Service
public class FoodBasicServiceImpl implements IFoodBasicService {

    @Resource
    private TbFoodBasicMapper foodBasicMapper;

    /**
     * 插入菜式列表
     *
     * @param foodBasic
     * @return
     */
    @Override
    public boolean insert(TbFoodBasic foodBasic) {
        foodBasic.setGmtCreate(new Date());
        foodBasic.setGmtModified(new Date());
        return foodBasicMapper.insertSelective(foodBasic) > 0;
    }

    /**
     * 删除菜式列表
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(int id) {
        return foodBasicMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 更新菜式列表
     *
     * @param foodBasic
     * @return
     */
    @Override
    public boolean update(TbFoodBasic foodBasic) {
        foodBasic.setGmtModified(new Date());
        return foodBasicMapper.updateByPrimaryKeySelective(foodBasic) > 0;
    }

    /**
     * 查询食物重量，类型
     *
     * @param id
     * @return
     */
    @Override
    public TbFoodBasic getFoodBasic(int id) {
        return foodBasicMapper.selectByPrimaryKey(id);
    }

    /**
     * 创建新记录并返回id, -1 插入失败
     *
     * @param foodBasic
     * @return
     */
    @Override
    public Integer insertReturnId(TbFoodBasic foodBasic) {
        //插入记录失败
        if (!insert(foodBasic)) {
            return -1;
        }

        // 查找插入记录的id
        TbFoodBasicExample example = new TbFoodBasicExample();
        example.createCriteria()
                .andNameEqualTo(foodBasic.getName())
                .andFlagEqualTo(foodBasic.getFlag())
                .andTypeEqualTo(foodBasic.getType())
                .andQuantityEqualTo(foodBasic.getQuantity());
        return foodBasicMapper.selectByExample(example).get(0).getId();
    }

    /**
     * 查询食物组成表
     *
     * @param foodName
     * @return
     */
    @Override
    public List<TbFoodBasic> listByName(String foodName) {
        TbFoodBasicExample example = new TbFoodBasicExample();
        example.createCriteria()
                .andNameEqualTo(foodName);
        return foodBasicMapper.selectByExample(example);
    }
}
