package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbRolePermissionRelation;
import com.bkit.fatdown.entity.TbRolePermissionRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRolePermissionRelationMapper {
    long countByExample(TbRolePermissionRelationExample example);

    int deleteByExample(TbRolePermissionRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbRolePermissionRelation record);

    int insertSelective(TbRolePermissionRelation record);

    List<TbRolePermissionRelation> selectByExample(TbRolePermissionRelationExample example);

    TbRolePermissionRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbRolePermissionRelation record, @Param("example") TbRolePermissionRelationExample example);

    int updateByExample(@Param("record") TbRolePermissionRelation record, @Param("example") TbRolePermissionRelationExample example);

    int updateByPrimaryKeySelective(TbRolePermissionRelation record);

    int updateByPrimaryKey(TbRolePermissionRelation record);
}