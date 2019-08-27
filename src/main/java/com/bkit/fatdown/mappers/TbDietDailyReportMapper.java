package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbDietDailyReport;
import com.bkit.fatdown.entity.TbDietDailyReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDietDailyReportMapper {
    long countByExample(TbDietDailyReportExample example);

    int deleteByExample(TbDietDailyReportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbDietDailyReport record);

    int insertSelective(TbDietDailyReport record);

    List<TbDietDailyReport> selectByExample(TbDietDailyReportExample example);

    TbDietDailyReport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbDietDailyReport record, @Param("example") TbDietDailyReportExample example);

    int updateByExample(@Param("record") TbDietDailyReport record, @Param("example") TbDietDailyReportExample example);

    int updateByPrimaryKeySelective(TbDietDailyReport record);

    int updateByPrimaryKey(TbDietDailyReport record);
}