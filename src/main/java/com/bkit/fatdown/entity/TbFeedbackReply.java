package com.bkit.fatdown.entity;

import java.util.Date;

public class TbFeedbackReply {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_feedback_reply.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_feedback_reply.info_id
     *
     * @mbg.generated
     */
    private Integer infoId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_feedback_reply.content
     *
     * @mbg.generated
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_feedback_reply.helpful
     *
     * @mbg.generated
     */
    private Integer helpful;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_feedback_reply.gmt_create
     *
     * @mbg.generated
     */
    private Date gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_feedback_reply.gmt_modified
     *
     * @mbg.generated
     */
    private Date gmtModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_feedback_reply.id
     *
     * @return the value of tb_feedback_reply.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_feedback_reply.id
     *
     * @param id the value for tb_feedback_reply.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_feedback_reply.info_id
     *
     * @return the value of tb_feedback_reply.info_id
     *
     * @mbg.generated
     */
    public Integer getInfoId() {
        return infoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_feedback_reply.info_id
     *
     * @param infoId the value for tb_feedback_reply.info_id
     *
     * @mbg.generated
     */
    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_feedback_reply.content
     *
     * @return the value of tb_feedback_reply.content
     *
     * @mbg.generated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_feedback_reply.content
     *
     * @param content the value for tb_feedback_reply.content
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_feedback_reply.helpful
     *
     * @return the value of tb_feedback_reply.helpful
     *
     * @mbg.generated
     */
    public Integer getHelpful() {
        return helpful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_feedback_reply.helpful
     *
     * @param helpful the value for tb_feedback_reply.helpful
     *
     * @mbg.generated
     */
    public void setHelpful(Integer helpful) {
        this.helpful = helpful;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_feedback_reply.gmt_create
     *
     * @return the value of tb_feedback_reply.gmt_create
     *
     * @mbg.generated
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_feedback_reply.gmt_create
     *
     * @param gmtCreate the value for tb_feedback_reply.gmt_create
     *
     * @mbg.generated
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_feedback_reply.gmt_modified
     *
     * @return the value of tb_feedback_reply.gmt_modified
     *
     * @mbg.generated
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_feedback_reply.gmt_modified
     *
     * @param gmtModified the value for tb_feedback_reply.gmt_modified
     *
     * @mbg.generated
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}