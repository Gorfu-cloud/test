package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbShareLikeInfo;
import com.bkit.fatdown.entity.TbShareLikeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbShareLikeInfoMapper {
    long countByExample(TbShareLikeInfoExample example);

    int deleteByExample(TbShareLikeInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbShareLikeInfo record);

    int insertSelective(TbShareLikeInfo record);

    List<TbShareLikeInfo> selectByExample(TbShareLikeInfoExample example);

    TbShareLikeInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbShareLikeInfo record, @Param("example") TbShareLikeInfoExample example);

    int updateByExample(@Param("record") TbShareLikeInfo record, @Param("example") TbShareLikeInfoExample example);

    int updateByPrimaryKeySelective(TbShareLikeInfo record);

    int updateByPrimaryKey(TbShareLikeInfo record);
}