package com.bkit.fatdown.dto.food;

import java.io.Serializable;

/**
 * @file: RecommendRecordDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 推荐菜式选择记录
 * @date: Created in 10/10/19  10:23 AM
 * @modified:
 * @version: 1.0
 */

public class RecommendRecordDTO implements Serializable {
    private Integer foodType;
    private Integer evaluation;
    private Integer foodRecommendId;

    public RecommendRecordDTO() {
    }

    public Integer getFoodType() {
        return foodType;
    }

    public void setFoodType(Integer foodType) {
        this.foodType = foodType;
    }

    public Integer getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Integer evaluation) {
        this.evaluation = evaluation;
    }

    public Integer getFoodRecommendId() {
        return foodRecommendId;
    }

    public void setFoodRecommendId(Integer foodRecommendId) {
        this.foodRecommendId = foodRecommendId;
    }

    @Override
    public String toString() {
        return "RecommendRecordDTO{" +
                "foodType=" + foodType +
                ", evaluation=" + evaluation +
                ", foodRecommendId=" + foodRecommendId +
                '}';
    }
}
