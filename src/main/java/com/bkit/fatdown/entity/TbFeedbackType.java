package com.bkit.fatdown.entity;

import java.util.Date;

public class TbFeedbackType {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_feedback_type.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_feedback_type.type_name
     *
     * @mbg.generated
     */
    private String typeName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_feedback_type.total
     *
     * @mbg.generated
     */
    private Integer total;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_feedback_type.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_feedback_type.gmt_create
     *
     * @mbg.generated
     */
    private Date gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_feedback_type.gmt_modified
     *
     * @mbg.generated
     */
    private Date gmtModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_feedback_type.id
     *
     * @return the value of tb_feedback_type.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_feedback_type.id
     *
     * @param id the value for tb_feedback_type.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_feedback_type.type_name
     *
     * @return the value of tb_feedback_type.type_name
     *
     * @mbg.generated
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_feedback_type.type_name
     *
     * @param typeName the value for tb_feedback_type.type_name
     *
     * @mbg.generated
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_feedback_type.total
     *
     * @return the value of tb_feedback_type.total
     *
     * @mbg.generated
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_feedback_type.total
     *
     * @param total the value for tb_feedback_type.total
     *
     * @mbg.generated
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_feedback_type.status
     *
     * @return the value of tb_feedback_type.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_feedback_type.status
     *
     * @param status the value for tb_feedback_type.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_feedback_type.gmt_create
     *
     * @return the value of tb_feedback_type.gmt_create
     *
     * @mbg.generated
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_feedback_type.gmt_create
     *
     * @param gmtCreate the value for tb_feedback_type.gmt_create
     *
     * @mbg.generated
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_feedback_type.gmt_modified
     *
     * @return the value of tb_feedback_type.gmt_modified
     *
     * @mbg.generated
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_feedback_type.gmt_modified
     *
     * @param gmtModified the value for tb_feedback_type.gmt_modified
     *
     * @mbg.generated
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}