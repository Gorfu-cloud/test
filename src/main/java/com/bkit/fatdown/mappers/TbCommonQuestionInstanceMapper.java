package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbCommonQuestionInstance;
import com.bkit.fatdown.entity.TbCommonQuestionInstanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCommonQuestionInstanceMapper {
    long countByExample(TbCommonQuestionInstanceExample example);

    int deleteByExample(TbCommonQuestionInstanceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbCommonQuestionInstance record);

    int insertSelective(TbCommonQuestionInstance record);

    List<TbCommonQuestionInstance> selectByExampleWithBLOBs(TbCommonQuestionInstanceExample example);

    List<TbCommonQuestionInstance> selectByExample(TbCommonQuestionInstanceExample example);

    TbCommonQuestionInstance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbCommonQuestionInstance record, @Param("example") TbCommonQuestionInstanceExample example);

    int updateByExampleWithBLOBs(@Param("record") TbCommonQuestionInstance record, @Param("example") TbCommonQuestionInstanceExample example);

    int updateByExample(@Param("record") TbCommonQuestionInstance record, @Param("example") TbCommonQuestionInstanceExample example);

    int updateByPrimaryKeySelective(TbCommonQuestionInstance record);

    int updateByPrimaryKeyWithBLOBs(TbCommonQuestionInstance record);

    int updateByPrimaryKey(TbCommonQuestionInstance record);
}