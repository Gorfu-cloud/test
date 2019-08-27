package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbScoreInfo;
import com.bkit.fatdown.entity.TbScoreInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbScoreInfoMapper {
    long countByExample(TbScoreInfoExample example);

    int deleteByExample(TbScoreInfoExample example);

    int deleteByPrimaryKey(Integer user);

    int insert(TbScoreInfo record);

    int insertSelective(TbScoreInfo record);

    List<TbScoreInfo> selectByExample(TbScoreInfoExample example);

    TbScoreInfo selectByPrimaryKey(Integer user);

    int updateByExampleSelective(@Param("record") TbScoreInfo record, @Param("example") TbScoreInfoExample example);

    int updateByExample(@Param("record") TbScoreInfo record, @Param("example") TbScoreInfoExample example);

    int updateByPrimaryKeySelective(TbScoreInfo record);

    int updateByPrimaryKey(TbScoreInfo record);
}