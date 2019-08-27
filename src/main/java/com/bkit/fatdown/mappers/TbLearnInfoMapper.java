package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbLearnInfo;
import com.bkit.fatdown.entity.TbLearnInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbLearnInfoMapper {
    long countByExample(TbLearnInfoExample example);

    int deleteByExample(TbLearnInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbLearnInfo record);

    int insertSelective(TbLearnInfo record);

    List<TbLearnInfo> selectByExample(TbLearnInfoExample example);

    TbLearnInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbLearnInfo record, @Param("example") TbLearnInfoExample example);

    int updateByExample(@Param("record") TbLearnInfo record, @Param("example") TbLearnInfoExample example);

    int updateByPrimaryKeySelective(TbLearnInfo record);

    int updateByPrimaryKey(TbLearnInfo record);
}