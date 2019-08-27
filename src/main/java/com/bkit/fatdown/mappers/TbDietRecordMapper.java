package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbDietRecord;
import com.bkit.fatdown.entity.TbDietRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDietRecordMapper {
    long countByExample(TbDietRecordExample example);

    int deleteByExample(TbDietRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbDietRecord record);

    int insertSelective(TbDietRecord record);

    List<TbDietRecord> selectByExample(TbDietRecordExample example);

    TbDietRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbDietRecord record, @Param("example") TbDietRecordExample example);

    int updateByExample(@Param("record") TbDietRecord record, @Param("example") TbDietRecordExample example);

    int updateByPrimaryKeySelective(TbDietRecord record);

    int updateByPrimaryKey(TbDietRecord record);
}