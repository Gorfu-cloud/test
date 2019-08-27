package com.bkit.fatdown.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbUserLifeStyleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbUserLifeStyleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andLabourIntensityIsNull() {
            addCriterion("labour_intensity is null");
            return (Criteria) this;
        }

        public Criteria andLabourIntensityIsNotNull() {
            addCriterion("labour_intensity is not null");
            return (Criteria) this;
        }

        public Criteria andLabourIntensityEqualTo(Integer value) {
            addCriterion("labour_intensity =", value, "labourIntensity");
            return (Criteria) this;
        }

        public Criteria andLabourIntensityNotEqualTo(Integer value) {
            addCriterion("labour_intensity <>", value, "labourIntensity");
            return (Criteria) this;
        }

        public Criteria andLabourIntensityGreaterThan(Integer value) {
            addCriterion("labour_intensity >", value, "labourIntensity");
            return (Criteria) this;
        }

        public Criteria andLabourIntensityGreaterThanOrEqualTo(Integer value) {
            addCriterion("labour_intensity >=", value, "labourIntensity");
            return (Criteria) this;
        }

        public Criteria andLabourIntensityLessThan(Integer value) {
            addCriterion("labour_intensity <", value, "labourIntensity");
            return (Criteria) this;
        }

        public Criteria andLabourIntensityLessThanOrEqualTo(Integer value) {
            addCriterion("labour_intensity <=", value, "labourIntensity");
            return (Criteria) this;
        }

        public Criteria andLabourIntensityIn(List<Integer> values) {
            addCriterion("labour_intensity in", values, "labourIntensity");
            return (Criteria) this;
        }

        public Criteria andLabourIntensityNotIn(List<Integer> values) {
            addCriterion("labour_intensity not in", values, "labourIntensity");
            return (Criteria) this;
        }

        public Criteria andLabourIntensityBetween(Integer value1, Integer value2) {
            addCriterion("labour_intensity between", value1, value2, "labourIntensity");
            return (Criteria) this;
        }

        public Criteria andLabourIntensityNotBetween(Integer value1, Integer value2) {
            addCriterion("labour_intensity not between", value1, value2, "labourIntensity");
            return (Criteria) this;
        }

        public Criteria andDietaryHabitIsNull() {
            addCriterion("dietary_habit is null");
            return (Criteria) this;
        }

        public Criteria andDietaryHabitIsNotNull() {
            addCriterion("dietary_habit is not null");
            return (Criteria) this;
        }

        public Criteria andDietaryHabitEqualTo(Double value) {
            addCriterion("dietary_habit =", value, "dietaryHabit");
            return (Criteria) this;
        }

        public Criteria andDietaryHabitNotEqualTo(Double value) {
            addCriterion("dietary_habit <>", value, "dietaryHabit");
            return (Criteria) this;
        }

        public Criteria andDietaryHabitGreaterThan(Double value) {
            addCriterion("dietary_habit >", value, "dietaryHabit");
            return (Criteria) this;
        }

        public Criteria andDietaryHabitGreaterThanOrEqualTo(Double value) {
            addCriterion("dietary_habit >=", value, "dietaryHabit");
            return (Criteria) this;
        }

        public Criteria andDietaryHabitLessThan(Double value) {
            addCriterion("dietary_habit <", value, "dietaryHabit");
            return (Criteria) this;
        }

        public Criteria andDietaryHabitLessThanOrEqualTo(Double value) {
            addCriterion("dietary_habit <=", value, "dietaryHabit");
            return (Criteria) this;
        }

        public Criteria andDietaryHabitIn(List<Double> values) {
            addCriterion("dietary_habit in", values, "dietaryHabit");
            return (Criteria) this;
        }

        public Criteria andDietaryHabitNotIn(List<Double> values) {
            addCriterion("dietary_habit not in", values, "dietaryHabit");
            return (Criteria) this;
        }

        public Criteria andDietaryHabitBetween(Double value1, Double value2) {
            addCriterion("dietary_habit between", value1, value2, "dietaryHabit");
            return (Criteria) this;
        }

        public Criteria andDietaryHabitNotBetween(Double value1, Double value2) {
            addCriterion("dietary_habit not between", value1, value2, "dietaryHabit");
            return (Criteria) this;
        }

        public Criteria andFoodTasteIsNull() {
            addCriterion("food_taste is null");
            return (Criteria) this;
        }

        public Criteria andFoodTasteIsNotNull() {
            addCriterion("food_taste is not null");
            return (Criteria) this;
        }

        public Criteria andFoodTasteEqualTo(Integer value) {
            addCriterion("food_taste =", value, "foodTaste");
            return (Criteria) this;
        }

        public Criteria andFoodTasteNotEqualTo(Integer value) {
            addCriterion("food_taste <>", value, "foodTaste");
            return (Criteria) this;
        }

        public Criteria andFoodTasteGreaterThan(Integer value) {
            addCriterion("food_taste >", value, "foodTaste");
            return (Criteria) this;
        }

        public Criteria andFoodTasteGreaterThanOrEqualTo(Integer value) {
            addCriterion("food_taste >=", value, "foodTaste");
            return (Criteria) this;
        }

        public Criteria andFoodTasteLessThan(Integer value) {
            addCriterion("food_taste <", value, "foodTaste");
            return (Criteria) this;
        }

        public Criteria andFoodTasteLessThanOrEqualTo(Integer value) {
            addCriterion("food_taste <=", value, "foodTaste");
            return (Criteria) this;
        }

        public Criteria andFoodTasteIn(List<Integer> values) {
            addCriterion("food_taste in", values, "foodTaste");
            return (Criteria) this;
        }

        public Criteria andFoodTasteNotIn(List<Integer> values) {
            addCriterion("food_taste not in", values, "foodTaste");
            return (Criteria) this;
        }

        public Criteria andFoodTasteBetween(Integer value1, Integer value2) {
            addCriterion("food_taste between", value1, value2, "foodTaste");
            return (Criteria) this;
        }

        public Criteria andFoodTasteNotBetween(Integer value1, Integer value2) {
            addCriterion("food_taste not between", value1, value2, "foodTaste");
            return (Criteria) this;
        }

        public Criteria andSpicyDegreeIsNull() {
            addCriterion("spicy_degree is null");
            return (Criteria) this;
        }

        public Criteria andSpicyDegreeIsNotNull() {
            addCriterion("spicy_degree is not null");
            return (Criteria) this;
        }

        public Criteria andSpicyDegreeEqualTo(Integer value) {
            addCriterion("spicy_degree =", value, "spicyDegree");
            return (Criteria) this;
        }

        public Criteria andSpicyDegreeNotEqualTo(Integer value) {
            addCriterion("spicy_degree <>", value, "spicyDegree");
            return (Criteria) this;
        }

        public Criteria andSpicyDegreeGreaterThan(Integer value) {
            addCriterion("spicy_degree >", value, "spicyDegree");
            return (Criteria) this;
        }

        public Criteria andSpicyDegreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("spicy_degree >=", value, "spicyDegree");
            return (Criteria) this;
        }

        public Criteria andSpicyDegreeLessThan(Integer value) {
            addCriterion("spicy_degree <", value, "spicyDegree");
            return (Criteria) this;
        }

        public Criteria andSpicyDegreeLessThanOrEqualTo(Integer value) {
            addCriterion("spicy_degree <=", value, "spicyDegree");
            return (Criteria) this;
        }

        public Criteria andSpicyDegreeIn(List<Integer> values) {
            addCriterion("spicy_degree in", values, "spicyDegree");
            return (Criteria) this;
        }

        public Criteria andSpicyDegreeNotIn(List<Integer> values) {
            addCriterion("spicy_degree not in", values, "spicyDegree");
            return (Criteria) this;
        }

        public Criteria andSpicyDegreeBetween(Integer value1, Integer value2) {
            addCriterion("spicy_degree between", value1, value2, "spicyDegree");
            return (Criteria) this;
        }

        public Criteria andSpicyDegreeNotBetween(Integer value1, Integer value2) {
            addCriterion("spicy_degree not between", value1, value2, "spicyDegree");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Integer value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Integer value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Integer value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Integer value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Integer> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Integer> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Integer value1, Integer value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}