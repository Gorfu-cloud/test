package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbSnackRecord;
import com.bkit.fatdown.entity.TbSnackRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSnackRecordMapper {
    long countByExample(TbSnackRecordExample example);

    int deleteByExample(TbSnackRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSnackRecord record);

    int insertSelective(TbSnackRecord record);

    List<TbSnackRecord> selectByExample(TbSnackRecordExample example);

    TbSnackRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSnackRecord record, @Param("example") TbSnackRecordExample example);

    int updateByExample(@Param("record") TbSnackRecord record, @Param("example") TbSnackRecordExample example);

    int updateByPrimaryKeySelective(TbSnackRecord record);

    int updateByPrimaryKey(TbSnackRecord record);
}