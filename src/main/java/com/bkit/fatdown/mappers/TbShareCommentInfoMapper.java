package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbShareCommentInfo;
import com.bkit.fatdown.entity.TbShareCommentInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbShareCommentInfoMapper {
    long countByExample(TbShareCommentInfoExample example);

    int deleteByExample(TbShareCommentInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbShareCommentInfo record);

    int insertSelective(TbShareCommentInfo record);

    List<TbShareCommentInfo> selectByExample(TbShareCommentInfoExample example);

    TbShareCommentInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbShareCommentInfo record, @Param("example") TbShareCommentInfoExample example);

    int updateByExample(@Param("record") TbShareCommentInfo record, @Param("example") TbShareCommentInfoExample example);

    int updateByPrimaryKeySelective(TbShareCommentInfo record);

    int updateByPrimaryKey(TbShareCommentInfo record);
}