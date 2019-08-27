package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbUserLifeStyle;
import com.bkit.fatdown.entity.TbUserLifeStyleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserLifeStyleMapper {
    long countByExample(TbUserLifeStyleExample example);

    int deleteByExample(TbUserLifeStyleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbUserLifeStyle record);

    int insertSelective(TbUserLifeStyle record);

    List<TbUserLifeStyle> selectByExample(TbUserLifeStyleExample example);

    TbUserLifeStyle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbUserLifeStyle record, @Param("example") TbUserLifeStyleExample example);

    int updateByExample(@Param("record") TbUserLifeStyle record, @Param("example") TbUserLifeStyleExample example);

    int updateByPrimaryKeySelective(TbUserLifeStyle record);

    int updateByPrimaryKey(TbUserLifeStyle record);
}