package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbFoodElementRelation;
import com.bkit.fatdown.entity.TbFoodElementRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFoodElementRelationMapper {
    long countByExample(TbFoodElementRelationExample example);

    int deleteByExample(TbFoodElementRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFoodElementRelation record);

    int insertSelective(TbFoodElementRelation record);

    List<TbFoodElementRelation> selectByExample(TbFoodElementRelationExample example);

    TbFoodElementRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFoodElementRelation record, @Param("example") TbFoodElementRelationExample example);

    int updateByExample(@Param("record") TbFoodElementRelation record, @Param("example") TbFoodElementRelationExample example);

    int updateByPrimaryKeySelective(TbFoodElementRelation record);

    int updateByPrimaryKey(TbFoodElementRelation record);
}