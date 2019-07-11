package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbTestScore;
import com.bkit.fatdown.entity.TbTestScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbTestScoreMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_test_score
     *
     * @mbg.generated
     */
    long countByExample(TbTestScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_test_score
     *
     * @mbg.generated
     */
    int deleteByExample(TbTestScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_test_score
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_test_score
     *
     * @mbg.generated
     */
    int insert(TbTestScore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_test_score
     *
     * @mbg.generated
     */
    int insertSelective(TbTestScore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_test_score
     *
     * @mbg.generated
     */
    List<TbTestScore> selectByExample(TbTestScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_test_score
     *
     * @mbg.generated
     */
    TbTestScore selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_test_score
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TbTestScore record, @Param("example") TbTestScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_test_score
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TbTestScore record, @Param("example") TbTestScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_test_score
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TbTestScore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_test_score
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TbTestScore record);
}