package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbFoodRecommend;
import com.bkit.fatdown.entity.TbFoodRecommendExample;
import com.bkit.fatdown.mappers.TbFoodRecommendMapper;
import com.bkit.fatdown.service.IFoodRecommendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @file: FoodRecommendServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 推荐菜式实现类
 * @date: Created in 7/26/19  10:03 PM
 * @modified:
 * @version: 1.0
 */

@Service
public class FoodRecommendServiceImpl implements IFoodRecommendService {

    @Resource
    private TbFoodRecommendMapper recommendMapper;

    /**
     * 创建推荐菜式
     *
     * @param recommend
     * @return
     */
    @Override
    public boolean insert(TbFoodRecommend recommend) {
        recommend.setGmtCreate(new Date());
        recommend.setGmtModified(new Date());
        return recommendMapper.insertSelective(recommend) > 0;
    }

    /**
     * 更新推荐菜式
     *
     * @param recommend
     * @return
     */
    @Override
    public boolean update(TbFoodRecommend recommend) {
        recommend.setGmtModified(new Date());
        return recommendMapper.updateByPrimaryKeySelective(recommend) > 0;
    }

    /**
     * 删除推荐菜式
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(int id) {
        return recommendMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 通过类型，查找推荐菜式
     *
     * @param foodType
     * @return
     */
    @Override
    public List<TbFoodRecommend> listFoodRecommend(int foodType) {
        TbFoodRecommendExample example = new TbFoodRecommendExample();
        example.createCriteria()
                .andFoodTypeEqualTo(foodType);
        example.setOrderByClause("total desc");
        return recommendMapper.selectByExample(example);
    }

    /**
     * 通过id查找推荐菜式
     *
     * @param id
     * @return
     */
    @Override
    public TbFoodRecommend getFoodRecommend(int id) {
        return recommendMapper.selectByPrimaryKey(id);
    }
}
