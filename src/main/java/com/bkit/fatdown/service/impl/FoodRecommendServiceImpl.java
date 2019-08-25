package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbFoodRecommend;
import com.bkit.fatdown.entity.TbFoodRecommendExample;
import com.bkit.fatdown.mappers.TbFoodRecommendMapper;
import com.bkit.fatdown.service.IFoodRecommendService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final static Integer ALL_TYPE = 0;

    private static final Logger logger = LoggerFactory.getLogger(FoodRecommendServiceImpl.class);

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
     * 模糊查询菜式关键词信息
     *
     * @param keyName  菜式关键词
     * @param foodType 类型
     * @param pageNum  页数
     * @param pageSize 每页数目
     * @return 菜式推荐
     */
    @Override
    public List<TbFoodRecommend> listFoodRecommend(String keyName, Integer foodType, Integer pageNum, Integer pageSize) {
        logger.info("search keyName:{}, foodType:{}, pageNum:{}, pageSize:{}", keyName, foodType, pageNum, pageSize);
        PageHelper.startPage(pageNum, pageSize);
        TbFoodRecommendExample example = new TbFoodRecommendExample();
        TbFoodRecommendExample.Criteria criteria = example.createCriteria();
        if (keyName != null) {
            criteria.andFoodNameLike("%" + keyName + "%");
        }

        if (!ALL_TYPE.equals(foodType)) {
            criteria.andFoodTypeEqualTo(foodType);
        }

        return recommendMapper.selectByExample(example);
    }

    /**
     * 通过类型，查找推荐菜式
     *
     * @param pageNum  页号
     * @param pageSize 每页数目
     * @return 返回菜式列表
     */
    @Override
    public List<TbFoodRecommend> listFoodRecommend(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return recommendMapper.selectByExample(new TbFoodRecommendExample());
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
     * @param foodType 食物类型
     * @param pageNum  页号
     * @param pageSize 每页数目
     * @return 食物类型
     */
    @Override
    public List<TbFoodRecommend> listFoodRecommend(int foodType, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        TbFoodRecommendExample example = new TbFoodRecommendExample();
        example.createCriteria()
                .andFoodTypeEqualTo(foodType);
        example.setOrderByClause("total desc");
        return recommendMapper.selectByExample(example);
    }

    /**
     * 统计推荐菜式
     *
     * @param id 菜式id
     * @return 返回结果
     */
    @Override
    public int countFoodRecommend(int id) {
        TbFoodRecommendExample example = new TbFoodRecommendExample();
        example.createCriteria()
                .andIdEqualTo(id);
        return (int) recommendMapper.countByExample(example);
    }

    /**
     * 通过id查找推荐菜式
     *
     * @param id 推荐菜式id
     * @return 推荐菜式
     */
    @Override
    public TbFoodRecommend getFoodRecommend(int id) {
        return recommendMapper.selectByPrimaryKey(id);
    }
}
