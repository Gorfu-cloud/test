package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbRedeemCode;
import com.bkit.fatdown.entity.TbRedeemCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRedeemCodeMapper {
    long countByExample(TbRedeemCodeExample example);

    int deleteByExample(TbRedeemCodeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbRedeemCode record);

    int insertSelective(TbRedeemCode record);

    List<TbRedeemCode> selectByExample(TbRedeemCodeExample example);

    TbRedeemCode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbRedeemCode record, @Param("example") TbRedeemCodeExample example);

    int updateByExample(@Param("record") TbRedeemCode record, @Param("example") TbRedeemCodeExample example);

    int updateByPrimaryKeySelective(TbRedeemCode record);

    int updateByPrimaryKey(TbRedeemCode record);
}