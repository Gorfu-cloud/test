package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbUserFatRateRecord;
import com.bkit.fatdown.entity.TbUserFatRateRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserFatRateRecordMapper {
    long countByExample(TbUserFatRateRecordExample example);

    int deleteByExample(TbUserFatRateRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbUserFatRateRecord record);

    int insertSelective(TbUserFatRateRecord record);

    List<TbUserFatRateRecord> selectByExample(TbUserFatRateRecordExample example);

    TbUserFatRateRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbUserFatRateRecord record, @Param("example") TbUserFatRateRecordExample example);

    int updateByExample(@Param("record") TbUserFatRateRecord record, @Param("example") TbUserFatRateRecordExample example);

    int updateByPrimaryKeySelective(TbUserFatRateRecord record);

    int updateByPrimaryKey(TbUserFatRateRecord record);
}