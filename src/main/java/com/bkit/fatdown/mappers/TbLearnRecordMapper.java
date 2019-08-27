package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbLearnRecord;
import com.bkit.fatdown.entity.TbLearnRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbLearnRecordMapper {
    long countByExample(TbLearnRecordExample example);

    int deleteByExample(TbLearnRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbLearnRecord record);

    int insertSelective(TbLearnRecord record);

    List<TbLearnRecord> selectByExample(TbLearnRecordExample example);

    TbLearnRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbLearnRecord record, @Param("example") TbLearnRecordExample example);

    int updateByExample(@Param("record") TbLearnRecord record, @Param("example") TbLearnRecordExample example);

    int updateByPrimaryKeySelective(TbLearnRecord record);

    int updateByPrimaryKey(TbLearnRecord record);
}