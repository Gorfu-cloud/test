package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbFoodRecommend;
import com.bkit.fatdown.entity.TbFoodRecommendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFoodRecommendMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend
     *
     * @mbg.generated
     */
    long countByExample(TbFoodRecommendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend
     *
     * @mbg.generated
     */
    int deleteByExample(TbFoodRecommendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend
     *
     * @mbg.generated
     */
    int insert(TbFoodRecommend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend
     *
     * @mbg.generated
     */
    int insertSelective(TbFoodRecommend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend
     *
     * @mbg.generated
     */
    List<TbFoodRecommend> selectByExample(TbFoodRecommendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend
     *
     * @mbg.generated
     */
    TbFoodRecommend selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TbFoodRecommend record, @Param("example") TbFoodRecommendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TbFoodRecommend record, @Param("example") TbFoodRecommendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TbFoodRecommend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_food_recommend
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TbFoodRecommend record);
}