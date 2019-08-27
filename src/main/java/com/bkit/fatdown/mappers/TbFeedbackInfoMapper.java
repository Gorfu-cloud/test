package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbFeedbackInfo;
import com.bkit.fatdown.entity.TbFeedbackInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFeedbackInfoMapper {
    long countByExample(TbFeedbackInfoExample example);

    int deleteByExample(TbFeedbackInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFeedbackInfo record);

    int insertSelective(TbFeedbackInfo record);

    List<TbFeedbackInfo> selectByExampleWithBLOBs(TbFeedbackInfoExample example);

    List<TbFeedbackInfo> selectByExample(TbFeedbackInfoExample example);

    TbFeedbackInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFeedbackInfo record, @Param("example") TbFeedbackInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") TbFeedbackInfo record, @Param("example") TbFeedbackInfoExample example);

    int updateByExample(@Param("record") TbFeedbackInfo record, @Param("example") TbFeedbackInfoExample example);

    int updateByPrimaryKeySelective(TbFeedbackInfo record);

    int updateByPrimaryKeyWithBLOBs(TbFeedbackInfo record);

    int updateByPrimaryKey(TbFeedbackInfo record);
}