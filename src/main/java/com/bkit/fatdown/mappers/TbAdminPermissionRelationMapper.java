package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbAdminPermissionRelation;
import com.bkit.fatdown.entity.TbAdminPermissionRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAdminPermissionRelationMapper {
    long countByExample(TbAdminPermissionRelationExample example);

    int deleteByExample(TbAdminPermissionRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbAdminPermissionRelation record);

    int insertSelective(TbAdminPermissionRelation record);

    List<TbAdminPermissionRelation> selectByExample(TbAdminPermissionRelationExample example);

    TbAdminPermissionRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbAdminPermissionRelation record, @Param("example") TbAdminPermissionRelationExample example);

    int updateByExample(@Param("record") TbAdminPermissionRelation record, @Param("example") TbAdminPermissionRelationExample example);

    int updateByPrimaryKeySelective(TbAdminPermissionRelation record);

    int updateByPrimaryKey(TbAdminPermissionRelation record);
}