package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbUserWeightRecord;
import com.bkit.fatdown.entity.TbUserWeightRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserWeightRecordMapper {
    long countByExample(TbUserWeightRecordExample example);

    int deleteByExample(TbUserWeightRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbUserWeightRecord record);

    int insertSelective(TbUserWeightRecord record);

    List<TbUserWeightRecord> selectByExample(TbUserWeightRecordExample example);

    TbUserWeightRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbUserWeightRecord record, @Param("example") TbUserWeightRecordExample example);

    int updateByExample(@Param("record") TbUserWeightRecord record, @Param("example") TbUserWeightRecordExample example);

    int updateByPrimaryKeySelective(TbUserWeightRecord record);

    int updateByPrimaryKey(TbUserWeightRecord record);
}