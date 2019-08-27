package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbTaskRecord;
import com.bkit.fatdown.entity.TbTaskRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbTaskRecordMapper {
    long countByExample(TbTaskRecordExample example);

    int deleteByExample(TbTaskRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbTaskRecord record);

    int insertSelective(TbTaskRecord record);

    List<TbTaskRecord> selectByExample(TbTaskRecordExample example);

    TbTaskRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbTaskRecord record, @Param("example") TbTaskRecordExample example);

    int updateByExample(@Param("record") TbTaskRecord record, @Param("example") TbTaskRecordExample example);

    int updateByPrimaryKeySelective(TbTaskRecord record);

    int updateByPrimaryKey(TbTaskRecord record);
}