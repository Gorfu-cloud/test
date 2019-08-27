package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbCommonQuestion;
import com.bkit.fatdown.entity.TbCommonQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCommonQuestionMapper {
    long countByExample(TbCommonQuestionExample example);

    int deleteByExample(TbCommonQuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbCommonQuestion record);

    int insertSelective(TbCommonQuestion record);

    List<TbCommonQuestion> selectByExample(TbCommonQuestionExample example);

    TbCommonQuestion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbCommonQuestion record, @Param("example") TbCommonQuestionExample example);

    int updateByExample(@Param("record") TbCommonQuestion record, @Param("example") TbCommonQuestionExample example);

    int updateByPrimaryKeySelective(TbCommonQuestion record);

    int updateByPrimaryKey(TbCommonQuestion record);
}