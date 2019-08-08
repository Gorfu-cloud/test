package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbFoodRecommendType;
import com.bkit.fatdown.entity.TbFoodRecommendTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFoodRecommendTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend_type
     *
     * @mbg.generated
     */
    long countByExample(TbFoodRecommendTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend_type
     *
     * @mbg.generated
     */
    int deleteByExample(TbFoodRecommendTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend_type
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend_type
     *
     * @mbg.generated
     */
    int insert(TbFoodRecommendType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend_type
     *
     * @mbg.generated
     */
    int insertSelective(TbFoodRecommendType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend_type
     *
     * @mbg.generated
     */
    List<TbFoodRecommendType> selectByExample(TbFoodRecommendTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend_type
     *
     * @mbg.generated
     */
    TbFoodRecommendType selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend_type
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TbFoodRecommendType record, @Param("example") TbFoodRecommendTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend_type
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TbFoodRecommendType record, @Param("example") TbFoodRecommendTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend_type
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TbFoodRecommendType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend_type
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TbFoodRecommendType record);
}