package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbDietMealReport;
import com.bkit.fatdown.entity.TbDietMealReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDietMealReportMapper {
    long countByExample(TbDietMealReportExample example);

    int deleteByExample(TbDietMealReportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbDietMealReport record);

    int insertSelective(TbDietMealReport record);

    List<TbDietMealReport> selectByExample(TbDietMealReportExample example);

    TbDietMealReport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbDietMealReport record, @Param("example") TbDietMealReportExample example);

    int updateByExample(@Param("record") TbDietMealReport record, @Param("example") TbDietMealReportExample example);

    int updateByPrimaryKeySelective(TbDietMealReport record);

    int updateByPrimaryKey(TbDietMealReport record);
}