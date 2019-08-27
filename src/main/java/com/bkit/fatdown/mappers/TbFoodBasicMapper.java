package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbFoodBasic;
import com.bkit.fatdown.entity.TbFoodBasicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFoodBasicMapper {
    long countByExample(TbFoodBasicExample example);

    int deleteByExample(TbFoodBasicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFoodBasic record);

    int insertSelective(TbFoodBasic record);

    List<TbFoodBasic> selectByExample(TbFoodBasicExample example);

    TbFoodBasic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFoodBasic record, @Param("example") TbFoodBasicExample example);

    int updateByExample(@Param("record") TbFoodBasic record, @Param("example") TbFoodBasicExample example);

    int updateByPrimaryKeySelective(TbFoodBasic record);

    int updateByPrimaryKey(TbFoodBasic record);
}