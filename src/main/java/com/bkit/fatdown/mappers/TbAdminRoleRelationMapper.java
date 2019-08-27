package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbAdminRoleRelation;
import com.bkit.fatdown.entity.TbAdminRoleRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAdminRoleRelationMapper {
    long countByExample(TbAdminRoleRelationExample example);

    int deleteByExample(TbAdminRoleRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbAdminRoleRelation record);

    int insertSelective(TbAdminRoleRelation record);

    List<TbAdminRoleRelation> selectByExample(TbAdminRoleRelationExample example);

    TbAdminRoleRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbAdminRoleRelation record, @Param("example") TbAdminRoleRelationExample example);

    int updateByExample(@Param("record") TbAdminRoleRelation record, @Param("example") TbAdminRoleRelationExample example);

    int updateByPrimaryKeySelective(TbAdminRoleRelation record);

    int updateByPrimaryKey(TbAdminRoleRelation record);
}