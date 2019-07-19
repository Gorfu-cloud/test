package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbPaperBasic;
import com.bkit.fatdown.entity.TbPaperBasicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPaperBasicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_paper_basic
     *
     * @mbg.generated
     */
    long countByExample(TbPaperBasicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_paper_basic
     *
     * @mbg.generated
     */
    int deleteByExample(TbPaperBasicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_paper_basic
     *
     * @mbg.generated
     */
    int insert(TbPaperBasic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_paper_basic
     *
     * @mbg.generated
     */
    int insertSelective(TbPaperBasic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_paper_basic
     *
     * @mbg.generated
     */
    List<TbPaperBasic> selectByExample(TbPaperBasicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_paper_basic
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TbPaperBasic record, @Param("example") TbPaperBasicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_paper_basic
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TbPaperBasic record, @Param("example") TbPaperBasicExample example);
}