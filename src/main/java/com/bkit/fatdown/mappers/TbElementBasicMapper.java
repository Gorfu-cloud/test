package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbElementBasic;
import com.bkit.fatdown.entity.TbElementBasicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElementBasicMapper {
    long countByExample(TbElementBasicExample example);

    int deleteByExample(TbElementBasicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbElementBasic record);

    int insertSelective(TbElementBasic record);

    List<TbElementBasic> selectByExample(TbElementBasicExample example);

    TbElementBasic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbElementBasic record, @Param("example") TbElementBasicExample example);

    int updateByExample(@Param("record") TbElementBasic record, @Param("example") TbElementBasicExample example);

    int updateByPrimaryKeySelective(TbElementBasic record);

    int updateByPrimaryKey(TbElementBasic record);
}