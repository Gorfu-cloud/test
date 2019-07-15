package com.bkit.fatdown.entity;

import java.util.Date;

public class TbUserBasicInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_basic_info.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_basic_info.open_id
     *
     * @mbg.generated
     */
    private String openId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_basic_info.group_id
     *
     * @mbg.generated
     */
    private Integer groupId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_basic_info.avatar_url
     *
     * @mbg.generated
     */
    private String avatarUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_basic_info.nick_name
     *
     * @mbg.generated
     */
    private String nickName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_basic_info.true_name
     *
     * @mbg.generated
     */
    private String trueName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_basic_info.gender
     *
     * @mbg.generated
     */
    private Integer gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_basic_info.age
     *
     * @mbg.generated
     */
    private Integer age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_basic_info.phone
     *
     * @mbg.generated
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_basic_info.province
     *
     * @mbg.generated
     */
    private String province;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_basic_info.city
     *
     * @mbg.generated
     */
    private String city;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_basic_info.height
     *
     * @mbg.generated
     */
    private Double height;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_basic_info.weight
     *
     * @mbg.generated
     */
    private Double weight;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_basic_info.job
     *
     * @mbg.generated
     */
    private String job;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_basic_info.type
     *
     * @mbg.generated
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_basic_info.flag
     *
     * @mbg.generated
     */
    private Integer flag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_basic_info.user_level
     *
     * @mbg.generated
     */
    private Integer userLevel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_basic_info.gmt_create
     *
     * @mbg.generated
     */
    private Date gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_basic_info.gmt_modified
     *
     * @mbg.generated
     */
    private Date gmtModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_basic_info.id
     *
     * @return the value of tb_user_basic_info.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_basic_info.id
     *
     * @param id the value for tb_user_basic_info.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_basic_info.open_id
     *
     * @return the value of tb_user_basic_info.open_id
     *
     * @mbg.generated
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_basic_info.open_id
     *
     * @param openId the value for tb_user_basic_info.open_id
     *
     * @mbg.generated
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_basic_info.group_id
     *
     * @return the value of tb_user_basic_info.group_id
     *
     * @mbg.generated
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_basic_info.group_id
     *
     * @param groupId the value for tb_user_basic_info.group_id
     *
     * @mbg.generated
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_basic_info.avatar_url
     *
     * @return the value of tb_user_basic_info.avatar_url
     *
     * @mbg.generated
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_basic_info.avatar_url
     *
     * @param avatarUrl the value for tb_user_basic_info.avatar_url
     *
     * @mbg.generated
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_basic_info.nick_name
     *
     * @return the value of tb_user_basic_info.nick_name
     *
     * @mbg.generated
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_basic_info.nick_name
     *
     * @param nickName the value for tb_user_basic_info.nick_name
     *
     * @mbg.generated
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_basic_info.true_name
     *
     * @return the value of tb_user_basic_info.true_name
     *
     * @mbg.generated
     */
    public String getTrueName() {
        return trueName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_basic_info.true_name
     *
     * @param trueName the value for tb_user_basic_info.true_name
     *
     * @mbg.generated
     */
    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_basic_info.gender
     *
     * @return the value of tb_user_basic_info.gender
     *
     * @mbg.generated
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_basic_info.gender
     *
     * @param gender the value for tb_user_basic_info.gender
     *
     * @mbg.generated
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_basic_info.age
     *
     * @return the value of tb_user_basic_info.age
     *
     * @mbg.generated
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_basic_info.age
     *
     * @param age the value for tb_user_basic_info.age
     *
     * @mbg.generated
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_basic_info.phone
     *
     * @return the value of tb_user_basic_info.phone
     *
     * @mbg.generated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_basic_info.phone
     *
     * @param phone the value for tb_user_basic_info.phone
     *
     * @mbg.generated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_basic_info.province
     *
     * @return the value of tb_user_basic_info.province
     *
     * @mbg.generated
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_basic_info.province
     *
     * @param province the value for tb_user_basic_info.province
     *
     * @mbg.generated
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_basic_info.city
     *
     * @return the value of tb_user_basic_info.city
     *
     * @mbg.generated
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_basic_info.city
     *
     * @param city the value for tb_user_basic_info.city
     *
     * @mbg.generated
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_basic_info.height
     *
     * @return the value of tb_user_basic_info.height
     *
     * @mbg.generated
     */
    public Double getHeight() {
        return height;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_basic_info.height
     *
     * @param height the value for tb_user_basic_info.height
     *
     * @mbg.generated
     */
    public void setHeight(Double height) {
        this.height = height;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_basic_info.weight
     *
     * @return the value of tb_user_basic_info.weight
     *
     * @mbg.generated
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_basic_info.weight
     *
     * @param weight the value for tb_user_basic_info.weight
     *
     * @mbg.generated
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_basic_info.job
     *
     * @return the value of tb_user_basic_info.job
     *
     * @mbg.generated
     */
    public String getJob() {
        return job;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_basic_info.job
     *
     * @param job the value for tb_user_basic_info.job
     *
     * @mbg.generated
     */
    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_basic_info.type
     *
     * @return the value of tb_user_basic_info.type
     *
     * @mbg.generated
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_basic_info.type
     *
     * @param type the value for tb_user_basic_info.type
     *
     * @mbg.generated
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_basic_info.flag
     *
     * @return the value of tb_user_basic_info.flag
     *
     * @mbg.generated
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_basic_info.flag
     *
     * @param flag the value for tb_user_basic_info.flag
     *
     * @mbg.generated
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_basic_info.user_level
     *
     * @return the value of tb_user_basic_info.user_level
     *
     * @mbg.generated
     */
    public Integer getUserLevel() {
        return userLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_basic_info.user_level
     *
     * @param userLevel the value for tb_user_basic_info.user_level
     *
     * @mbg.generated
     */
    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_basic_info.gmt_create
     *
     * @return the value of tb_user_basic_info.gmt_create
     *
     * @mbg.generated
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_basic_info.gmt_create
     *
     * @param gmtCreate the value for tb_user_basic_info.gmt_create
     *
     * @mbg.generated
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_basic_info.gmt_modified
     *
     * @return the value of tb_user_basic_info.gmt_modified
     *
     * @mbg.generated
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_basic_info.gmt_modified
     *
     * @param gmtModified the value for tb_user_basic_info.gmt_modified
     *
     * @mbg.generated
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}