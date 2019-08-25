package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbFoodRecommendType;
import com.bkit.fatdown.entity.TbFoodRecommendTypeExample;
import com.bkit.fatdown.mappers.TbFoodRecommendTypeMapper;
import com.bkit.fatdown.service.IFoodRecommendTypeService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @file: FoodRecommendTypeServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 菜式推荐类型功能实现类
 * @date: Created in 8/7/19  9:48 PM
 * @modified:
 * @version: 1.0
 */
@Service
public class FoodRecommendTypeServiceImpl implements IFoodRecommendTypeService {

    @Resource
    private TbFoodRecommendTypeMapper recommendTypeMapper;

    /**
     * 创建食物推荐类型
     *
     * @param recommendType 食物推荐类型
     * @return 是否成功
     */
    @Override
    public boolean insert(TbFoodRecommendType recommendType) {
        Date now = new Date();
        recommendType.setGmtCreate(now);
        recommendType.setGmtModified(now);

        return recommendTypeMapper.insertSelective(recommendType) > 0;
    }

    /**
     * 更新食物推荐类型
     *
     * @param recommendType 食物推荐类型
     * @return 是否成功
     */
    @Override
    public boolean update(TbFoodRecommendType recommendType) {
        Date now = new Date();
        recommendType.setGmtModified(now);
        return recommendTypeMapper.updateByPrimaryKeySelective(recommendType) > 0;
    }

    /**
     * 删除食物推荐类型
     *
     * @param id 类型id
     * @return 是否成功
     */
    @Override
    public boolean delete(int id) {
        return recommendTypeMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<TbFoodRecommendType> listAllType(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return recommendTypeMapper.selectByExample(new TbFoodRecommendTypeExample());
    }

    /**
     * 获取所有食物推荐类型
     *
     * @return 所有食物推荐类型
     */
    @Override
    public List<TbFoodRecommendType> listAllType() {
        return recommendTypeMapper.selectByExample(new TbFoodRecommendTypeExample());
    }

    /**
     * 获取类型信息
     *
     * @param id 类型id
     * @return 类型信息
     */
    @Override
    public TbFoodRecommendType getTypeInfo(int id) {
        return recommendTypeMapper.selectByPrimaryKey(id);
    }

    /**
     * 查找类型
     *
     * @param typeName 类型名称
     * @param pageNum  页数
     * @param pageSize 每页数目
     * @return 类型列表
     */
    @Override
    public List<TbFoodRecommendType> listType(String typeName, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        TbFoodRecommendTypeExample example = new TbFoodRecommendTypeExample();
        TbFoodRecommendTypeExample.Criteria criteria = example.createCriteria();

        if (typeName != null) {
            criteria.andTypeNameLike("%" + typeName + "%");
        }

        return recommendTypeMapper.selectByExample(example);
    }

    /**
     * 统计类型记录数
     *
     * @param id 类型id
     * @return 记录数
     */
    @Override
    public int countType(int id) {
        TbFoodRecommendTypeExample example = new TbFoodRecommendTypeExample();
        example.createCriteria()
                .andIdEqualTo(id);
        return (int) recommendTypeMapper.countByExample(example);
    }
}
