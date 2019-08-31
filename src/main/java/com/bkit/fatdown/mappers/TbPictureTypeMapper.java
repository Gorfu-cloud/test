package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbPictureType;
import com.bkit.fatdown.entity.TbPictureTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPictureTypeMapper {
    long countByExample(TbPictureTypeExample example);

    int deleteByExample(TbPictureTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPictureType record);

    int insertSelective(TbPictureType record);

    List<TbPictureType> selectByExample(TbPictureTypeExample example);

    TbPictureType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPictureType record, @Param("example") TbPictureTypeExample example);

    int updateByExample(@Param("record") TbPictureType record, @Param("example") TbPictureTypeExample example);

    int updateByPrimaryKeySelective(TbPictureType record);

    int updateByPrimaryKey(TbPictureType record);
}