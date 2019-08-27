package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbTestRecord;
import com.bkit.fatdown.entity.TbTestRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbTestRecordMapper {
    long countByExample(TbTestRecordExample example);

    int deleteByExample(TbTestRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbTestRecord record);

    int insertSelective(TbTestRecord record);

    List<TbTestRecord> selectByExample(TbTestRecordExample example);

    TbTestRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbTestRecord record, @Param("example") TbTestRecordExample example);

    int updateByExample(@Param("record") TbTestRecord record, @Param("example") TbTestRecordExample example);

    int updateByPrimaryKeySelective(TbTestRecord record);

    int updateByPrimaryKey(TbTestRecord record);
}