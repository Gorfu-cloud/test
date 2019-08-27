package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbDietUserStandard;
import com.bkit.fatdown.entity.TbDietUserStandardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDietUserStandardMapper {
    long countByExample(TbDietUserStandardExample example);

    int deleteByExample(TbDietUserStandardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbDietUserStandard record);

    int insertSelective(TbDietUserStandard record);

    List<TbDietUserStandard> selectByExample(TbDietUserStandardExample example);

    TbDietUserStandard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbDietUserStandard record, @Param("example") TbDietUserStandardExample example);

    int updateByExample(@Param("record") TbDietUserStandard record, @Param("example") TbDietUserStandardExample example);

    int updateByPrimaryKeySelective(TbDietUserStandard record);

    int updateByPrimaryKey(TbDietUserStandard record);
}