package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbPaperBasic;
import com.bkit.fatdown.entity.TbPaperBasicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPaperBasicMapper {
    long countByExample(TbPaperBasicExample example);

    int deleteByExample(TbPaperBasicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPaperBasic record);

    int insertSelective(TbPaperBasic record);

    List<TbPaperBasic> selectByExample(TbPaperBasicExample example);

    TbPaperBasic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPaperBasic record, @Param("example") TbPaperBasicExample example);

    int updateByExample(@Param("record") TbPaperBasic record, @Param("example") TbPaperBasicExample example);

    int updateByPrimaryKeySelective(TbPaperBasic record);

    int updateByPrimaryKey(TbPaperBasic record);
}