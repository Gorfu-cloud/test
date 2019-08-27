package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbUserGroup;
import com.bkit.fatdown.entity.TbUserGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserGroupMapper {
    long countByExample(TbUserGroupExample example);

    int deleteByExample(TbUserGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbUserGroup record);

    int insertSelective(TbUserGroup record);

    List<TbUserGroup> selectByExample(TbUserGroupExample example);

    TbUserGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbUserGroup record, @Param("example") TbUserGroupExample example);

    int updateByExample(@Param("record") TbUserGroup record, @Param("example") TbUserGroupExample example);

    int updateByPrimaryKeySelective(TbUserGroup record);

    int updateByPrimaryKey(TbUserGroup record);
}