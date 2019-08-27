package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbFoodRecord;
import com.bkit.fatdown.entity.TbFoodRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFoodRecordMapper {
    long countByExample(TbFoodRecordExample example);

    int deleteByExample(TbFoodRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFoodRecord record);

    int insertSelective(TbFoodRecord record);

    List<TbFoodRecord> selectByExample(TbFoodRecordExample example);

    TbFoodRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFoodRecord record, @Param("example") TbFoodRecordExample example);

    int updateByExample(@Param("record") TbFoodRecord record, @Param("example") TbFoodRecordExample example);

    int updateByPrimaryKeySelective(TbFoodRecord record);

    int updateByPrimaryKey(TbFoodRecord record);
}