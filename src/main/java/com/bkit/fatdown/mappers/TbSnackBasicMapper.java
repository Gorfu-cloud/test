package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbSnackBasic;
import com.bkit.fatdown.entity.TbSnackBasicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSnackBasicMapper {
    long countByExample(TbSnackBasicExample example);

    int deleteByExample(TbSnackBasicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSnackBasic record);

    int insertSelective(TbSnackBasic record);

    List<TbSnackBasic> selectByExample(TbSnackBasicExample example);

    TbSnackBasic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSnackBasic record, @Param("example") TbSnackBasicExample example);

    int updateByExample(@Param("record") TbSnackBasic record, @Param("example") TbSnackBasicExample example);

    int updateByPrimaryKeySelective(TbSnackBasic record);

    int updateByPrimaryKey(TbSnackBasic record);
}