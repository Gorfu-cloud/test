package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbUserBasicInfo;
import com.bkit.fatdown.entity.TbUserBasicInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserBasicInfoMapper {
    long countByExample(TbUserBasicInfoExample example);

    int deleteByExample(TbUserBasicInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbUserBasicInfo record);

    int insertSelective(TbUserBasicInfo record);

    List<TbUserBasicInfo> selectByExample(TbUserBasicInfoExample example);

    TbUserBasicInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbUserBasicInfo record, @Param("example") TbUserBasicInfoExample example);

    int updateByExample(@Param("record") TbUserBasicInfo record, @Param("example") TbUserBasicInfoExample example);

    int updateByPrimaryKeySelective(TbUserBasicInfo record);

    int updateByPrimaryKey(TbUserBasicInfo record);
}