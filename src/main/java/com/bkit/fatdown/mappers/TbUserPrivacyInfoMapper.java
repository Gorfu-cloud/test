package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbUserPrivacyInfo;
import com.bkit.fatdown.entity.TbUserPrivacyInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserPrivacyInfoMapper {
    long countByExample(TbUserPrivacyInfoExample example);

    int deleteByExample(TbUserPrivacyInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbUserPrivacyInfo record);

    int insertSelective(TbUserPrivacyInfo record);

    List<TbUserPrivacyInfo> selectByExample(TbUserPrivacyInfoExample example);

    TbUserPrivacyInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbUserPrivacyInfo record, @Param("example") TbUserPrivacyInfoExample example);

    int updateByExample(@Param("record") TbUserPrivacyInfo record, @Param("example") TbUserPrivacyInfoExample example);

    int updateByPrimaryKeySelective(TbUserPrivacyInfo record);

    int updateByPrimaryKey(TbUserPrivacyInfo record);
}