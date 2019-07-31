package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbDietMealReport;
import com.bkit.fatdown.entity.TbDietMealReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDietMealReportMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_meal_report
     *
     * @mbg.generated
     */
    long countByExample(TbDietMealReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_meal_report
     *
     * @mbg.generated
     */
    int deleteByExample(TbDietMealReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_meal_report
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_meal_report
     *
     * @mbg.generated
     */
    int insert(TbDietMealReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_meal_report
     *
     * @mbg.generated
     */
    int insertSelective(TbDietMealReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_meal_report
     *
     * @mbg.generated
     */
    List<TbDietMealReport> selectByExample(TbDietMealReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_meal_report
     *
     * @mbg.generated
     */
    TbDietMealReport selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_meal_report
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TbDietMealReport record, @Param("example") TbDietMealReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_meal_report
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TbDietMealReport record, @Param("example") TbDietMealReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_meal_report
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TbDietMealReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_diet_meal_report
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TbDietMealReport record);
}