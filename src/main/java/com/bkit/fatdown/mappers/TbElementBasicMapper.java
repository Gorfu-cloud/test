package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbElementBasic;
import com.bkit.fatdown.entity.TbElementBasicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElementBasicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_element_basic
     *
     * @mbg.generated
     */
    long countByExample(TbElementBasicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_element_basic
     *
     * @mbg.generated
     */
    int deleteByExample(TbElementBasicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_element_basic
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_element_basic
     *
     * @mbg.generated
     */
    int insert(TbElementBasic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_element_basic
     *
     * @mbg.generated
     */
    int insertSelective(TbElementBasic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_element_basic
     *
     * @mbg.generated
     */
    List<TbElementBasic> selectByExample(TbElementBasicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_element_basic
     *
     * @mbg.generated
     */
    TbElementBasic selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_element_basic
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TbElementBasic record, @Param("example") TbElementBasicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_element_basic
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TbElementBasic record, @Param("example") TbElementBasicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_element_basic
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TbElementBasic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_element_basic
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TbElementBasic record);
}