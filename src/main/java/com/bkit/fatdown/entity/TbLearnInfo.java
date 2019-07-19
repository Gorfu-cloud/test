package com.bkit.fatdown.entity;

import java.util.Date;

public class TbLearnInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_learn_info.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_learn_info.content
     *
     * @mbg.generated
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_learn_info.explanation
     *
     * @mbg.generated
     */
    private String explanation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_learn_info.time
     *
     * @mbg.generated
     */
    private Date time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_learn_info.type
     *
     * @mbg.generated
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_learn_info.gmt_create
     *
     * @mbg.generated
     */
    private Date gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_learn_info.gmt_modified
     *
     * @mbg.generated
     */
    private Date gmtModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_learn_info.id
     *
     * @return the value of tb_learn_info.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_learn_info.id
     *
     * @param id the value for tb_learn_info.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_learn_info.content
     *
     * @return the value of tb_learn_info.content
     *
     * @mbg.generated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_learn_info.content
     *
     * @param content the value for tb_learn_info.content
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_learn_info.explanation
     *
     * @return the value of tb_learn_info.explanation
     *
     * @mbg.generated
     */
    public String getExplanation() {
        return explanation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_learn_info.explanation
     *
     * @param explanation the value for tb_learn_info.explanation
     *
     * @mbg.generated
     */
    public void setExplanation(String explanation) {
        this.explanation = explanation == null ? null : explanation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_learn_info.time
     *
     * @return the value of tb_learn_info.time
     *
     * @mbg.generated
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_learn_info.time
     *
     * @param time the value for tb_learn_info.time
     *
     * @mbg.generated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_learn_info.type
     *
     * @return the value of tb_learn_info.type
     *
     * @mbg.generated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_learn_info.type
     *
     * @param type the value for tb_learn_info.type
     *
     * @mbg.generated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_learn_info.gmt_create
     *
     * @return the value of tb_learn_info.gmt_create
     *
     * @mbg.generated
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_learn_info.gmt_create
     *
     * @param gmtCreate the value for tb_learn_info.gmt_create
     *
     * @mbg.generated
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_learn_info.gmt_modified
     *
     * @return the value of tb_learn_info.gmt_modified
     *
     * @mbg.generated
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_learn_info.gmt_modified
     *
     * @param gmtModified the value for tb_learn_info.gmt_modified
     *
     * @mbg.generated
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}