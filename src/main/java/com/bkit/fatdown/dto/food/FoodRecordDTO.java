package com.bkit.fatdown.dto.food;

import java.util.Date;

/**
 * @file: FoodRecordDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 饮食记录，封装菜式名称接口
 * @date: Created in 2019/10/9 11:32
 * @modified:
 * @version: 1.0
 */

public class FoodRecordDTO  {
    private Integer id;

    private String imgUrl;

    private Integer userId;

    private Integer foodId;

    private String foodName;

    private Double eatPer;

    private Double foodQuantity;

    private Integer status;

    private Date gmtCreate;

    private Date gmtModified;

    public FoodRecordDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getEatPer() {
        return eatPer;
    }

    public void setEatPer(Double eatPer) {
        this.eatPer = eatPer;
    }

    public Double getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(Double foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "FoodRecordDTO{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                ", userId=" + userId +
                ", foodId=" + foodId +
                ", foodName='" + foodName + '\'' +
                ", eatPer=" + eatPer +
                ", foodQuantity=" + foodQuantity +
                ", status=" + status +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
