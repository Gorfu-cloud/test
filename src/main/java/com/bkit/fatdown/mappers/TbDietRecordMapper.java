package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbDietRecord;
import com.bkit.fatdown.entity.TbDietRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDietRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_record
     *
     * @mbg.generated
     */
    long countByExample(TbDietRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_record
     *
     * @mbg.generated
     */
    int deleteByExample(TbDietRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_record
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_record
     *
     * @mbg.generated
     */
    int insert(TbDietRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_record
     *
     * @mbg.generated
     */
    int insertSelective(TbDietRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_record
     *
     * @mbg.generated
     */
    List<TbDietRecord> selectByExample(TbDietRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_record
     *
     * @mbg.generated
     */
    TbDietRecord selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_record
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TbDietRecord record, @Param("example") TbDietRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_record
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TbDietRecord record, @Param("example") TbDietRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_record
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TbDietRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_record
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TbDietRecord record);
}