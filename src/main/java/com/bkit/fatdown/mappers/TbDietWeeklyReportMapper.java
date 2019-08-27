package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbDietWeeklyReport;
import com.bkit.fatdown.entity.TbDietWeeklyReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDietWeeklyReportMapper {
    long countByExample(TbDietWeeklyReportExample example);

    int deleteByExample(TbDietWeeklyReportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbDietWeeklyReport record);

    int insertSelective(TbDietWeeklyReport record);

    List<TbDietWeeklyReport> selectByExample(TbDietWeeklyReportExample example);

    TbDietWeeklyReport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbDietWeeklyReport record, @Param("example") TbDietWeeklyReportExample example);

    int updateByExample(@Param("record") TbDietWeeklyReport record, @Param("example") TbDietWeeklyReportExample example);

    int updateByPrimaryKeySelective(TbDietWeeklyReport record);

    int updateByPrimaryKey(TbDietWeeklyReport record);
}