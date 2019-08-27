package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbQuestionBasic;
import com.bkit.fatdown.entity.TbQuestionBasicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbQuestionBasicMapper {
    long countByExample(TbQuestionBasicExample example);

    int deleteByExample(TbQuestionBasicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbQuestionBasic record);

    int insertSelective(TbQuestionBasic record);

    List<TbQuestionBasic> selectByExample(TbQuestionBasicExample example);

    TbQuestionBasic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbQuestionBasic record, @Param("example") TbQuestionBasicExample example);

    int updateByExample(@Param("record") TbQuestionBasic record, @Param("example") TbQuestionBasicExample example);

    int updateByPrimaryKeySelective(TbQuestionBasic record);

    int updateByPrimaryKey(TbQuestionBasic record);
}