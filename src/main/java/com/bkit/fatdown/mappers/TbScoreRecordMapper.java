package com.bkit.fatdown.mappers;

import com.bkit.fatdown.entity.TbScoreRecord;
import com.bkit.fatdown.entity.TbScoreRecordExample;
import com.bkit.fatdown.entity.TbScoreRecordKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbScoreRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_score_record
     *
     * @mbg.generated
     */
    long countByExample(TbScoreRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_score_record
     *
     * @mbg.generated
     */
    int deleteByExample(TbScoreRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_score_record
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(TbScoreRecordKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_score_record
     *
     * @mbg.generated
     */
    int insert(TbScoreRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_score_record
     *
     * @mbg.generated
     */
    int insertSelective(TbScoreRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_score_record
     *
     * @mbg.generated
     */
    List<TbScoreRecord> selectByExample(TbScoreRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_score_record
     *
     * @mbg.generated
     */
    TbScoreRecord selectByPrimaryKey(TbScoreRecordKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_score_record
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TbScoreRecord record, @Param("example") TbScoreRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_score_record
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TbScoreRecord record, @Param("example") TbScoreRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_score_record
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TbScoreRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_score_record
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TbScoreRecord record);
}