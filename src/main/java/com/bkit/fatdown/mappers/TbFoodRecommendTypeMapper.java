package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbFoodRecommendType;
import com.bkit.fatdown.entity.TbFoodRecommendTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFoodRecommendTypeMapper {
    long countByExample(TbFoodRecommendTypeExample example);

    int deleteByExample(TbFoodRecommendTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFoodRecommendType record);

    int insertSelective(TbFoodRecommendType record);

    List<TbFoodRecommendType> selectByExample(TbFoodRecommendTypeExample example);

    TbFoodRecommendType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFoodRecommendType record, @Param("example") TbFoodRecommendTypeExample example);

    int updateByExample(@Param("record") TbFoodRecommendType record, @Param("example") TbFoodRecommendTypeExample example);

    int updateByPrimaryKeySelective(TbFoodRecommendType record);

    int updateByPrimaryKey(TbFoodRecommendType record);
}