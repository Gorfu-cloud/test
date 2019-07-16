package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbLearnInfo;
import com.bkit.fatdown.entity.TbLearnInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbLearnInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_learn_info
     *
     * @mbg.generated
     */
    long countByExample(TbLearnInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_learn_info
     *
     * @mbg.generated
     */
    int deleteByExample(TbLearnInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_learn_info
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_learn_info
     *
     * @mbg.generated
     */
    int insert(TbLearnInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_learn_info
     *
     * @mbg.generated
     */
    int insertSelective(TbLearnInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_learn_info
     *
     * @mbg.generated
     */
    List<TbLearnInfo> selectByExample(TbLearnInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_learn_info
     *
     * @mbg.generated
     */
    TbLearnInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_learn_info
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TbLearnInfo record, @Param("example") TbLearnInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_learn_info
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TbLearnInfo record, @Param("example") TbLearnInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_learn_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TbLearnInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_learn_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TbLearnInfo record);
}