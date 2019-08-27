package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbShareInfo;
import com.bkit.fatdown.entity.TbShareInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbShareInfoMapper {
    long countByExample(TbShareInfoExample example);

    int deleteByExample(TbShareInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbShareInfo record);

    int insertSelective(TbShareInfo record);

    List<TbShareInfo> selectByExample(TbShareInfoExample example);

    TbShareInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbShareInfo record, @Param("example") TbShareInfoExample example);

    int updateByExample(@Param("record") TbShareInfo record, @Param("example") TbShareInfoExample example);

    int updateByPrimaryKeySelective(TbShareInfo record);

    int updateByPrimaryKey(TbShareInfo record);
}