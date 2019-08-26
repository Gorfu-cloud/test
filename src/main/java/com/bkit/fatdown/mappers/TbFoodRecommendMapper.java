package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbFoodRecommend;
import com.bkit.fatdown.entity.TbFoodRecommendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFoodRecommendMapper {
    long countByExample(TbFoodRecommendExample example);

    int deleteByExample(TbFoodRecommendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFoodRecommend record);

    int insertSelective(TbFoodRecommend record);

    List<TbFoodRecommend> selectByExample(TbFoodRecommendExample example);

    TbFoodRecommend selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFoodRecommend record, @Param("example") TbFoodRecommendExample example);

    int updateByExample(@Param("record") TbFoodRecommend record, @Param("example") TbFoodRecommendExample example);

    int updateByPrimaryKeySelective(TbFoodRecommend record);

    int updateByPrimaryKey(TbFoodRecommend record);
}