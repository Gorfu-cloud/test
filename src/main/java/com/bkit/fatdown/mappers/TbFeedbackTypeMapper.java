package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbFeedbackType;
import com.bkit.fatdown.entity.TbFeedbackTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFeedbackTypeMapper {
    long countByExample(TbFeedbackTypeExample example);

    int deleteByExample(TbFeedbackTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFeedbackType record);

    int insertSelective(TbFeedbackType record);

    List<TbFeedbackType> selectByExample(TbFeedbackTypeExample example);

    TbFeedbackType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFeedbackType record, @Param("example") TbFeedbackTypeExample example);

    int updateByExample(@Param("record") TbFeedbackType record, @Param("example") TbFeedbackTypeExample example);

    int updateByPrimaryKeySelective(TbFeedbackType record);

    int updateByPrimaryKey(TbFeedbackType record);
}