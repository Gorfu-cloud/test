package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbTaskList;
import com.bkit.fatdown.entity.TbTaskListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbTaskListMapper {
    long countByExample(TbTaskListExample example);

    int deleteByExample(TbTaskListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbTaskList record);

    int insertSelective(TbTaskList record);

    List<TbTaskList> selectByExample(TbTaskListExample example);

    TbTaskList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbTaskList record, @Param("example") TbTaskListExample example);

    int updateByExample(@Param("record") TbTaskList record, @Param("example") TbTaskListExample example);

    int updateByPrimaryKeySelective(TbTaskList record);

    int updateByPrimaryKey(TbTaskList record);
}