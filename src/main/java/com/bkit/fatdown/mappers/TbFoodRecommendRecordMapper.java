package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbFoodRecommendRecord;
import com.bkit.fatdown.entity.TbFoodRecommendRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFoodRecommendRecordMapper {
    long countByExample(TbFoodRecommendRecordExample example);

    int deleteByExample(TbFoodRecommendRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFoodRecommendRecord record);

    int insertSelective(TbFoodRecommendRecord record);

    List<TbFoodRecommendRecord> selectByExample(TbFoodRecommendRecordExample example);

    TbFoodRecommendRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFoodRecommendRecord record, @Param("example") TbFoodRecommendRecordExample example);

    int updateByExample(@Param("record") TbFoodRecommendRecord record, @Param("example") TbFoodRecommendRecordExample example);

    int updateByPrimaryKeySelective(TbFoodRecommendRecord record);

    int updateByPrimaryKey(TbFoodRecommendRecord record);
}