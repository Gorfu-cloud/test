package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbFeedbackReply;
import com.bkit.fatdown.entity.TbFeedbackReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFeedbackReplyMapper {
    long countByExample(TbFeedbackReplyExample example);

    int deleteByExample(TbFeedbackReplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFeedbackReply record);

    int insertSelective(TbFeedbackReply record);

    List<TbFeedbackReply> selectByExample(TbFeedbackReplyExample example);

    TbFeedbackReply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFeedbackReply record, @Param("example") TbFeedbackReplyExample example);

    int updateByExample(@Param("record") TbFeedbackReply record, @Param("example") TbFeedbackReplyExample example);

    int updateByPrimaryKeySelective(TbFeedbackReply record);

    int updateByPrimaryKey(TbFeedbackReply record);
}