package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbUserPrivacyInfo;
import com.bkit.fatdown.entity.TbUserPrivacyInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserPrivacyInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_privacy_info
     *
     * @mbg.generated
     */
    long countByExample(TbUserPrivacyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_privacy_info
     *
     * @mbg.generated
     */
    int deleteByExample(TbUserPrivacyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_privacy_info
     *
     * @mbg.generated
     */
    int insert(TbUserPrivacyInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_privacy_info
     *
     * @mbg.generated
     */
    int insertSelective(TbUserPrivacyInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_privacy_info
     *
     * @mbg.generated
     */
    List<TbUserPrivacyInfo> selectByExample(TbUserPrivacyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_privacy_info
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TbUserPrivacyInfo record, @Param("example") TbUserPrivacyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_privacy_info
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TbUserPrivacyInfo record, @Param("example") TbUserPrivacyInfoExample example);
}