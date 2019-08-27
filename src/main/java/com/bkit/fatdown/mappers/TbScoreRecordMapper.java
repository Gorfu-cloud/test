package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbScoreRecord;
import com.bkit.fatdown.entity.TbScoreRecordExample;
import com.bkit.fatdown.entity.TbScoreRecordKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbScoreRecordMapper {
    long countByExample(TbScoreRecordExample example);

    int deleteByExample(TbScoreRecordExample example);

    int deleteByPrimaryKey(TbScoreRecordKey key);

    int insert(TbScoreRecord record);

    int insertSelective(TbScoreRecord record);

    List<TbScoreRecord> selectByExample(TbScoreRecordExample example);

    TbScoreRecord selectByPrimaryKey(TbScoreRecordKey key);

    int updateByExampleSelective(@Param("record") TbScoreRecord record, @Param("example") TbScoreRecordExample example);

    int updateByExample(@Param("record") TbScoreRecord record, @Param("example") TbScoreRecordExample example);

    int updateByPrimaryKeySelective(TbScoreRecord record);

    int updateByPrimaryKey(TbScoreRecord record);
}