package com.bkit.fatdown.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbUserPrivacyInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbUserPrivacyInfoExample() {
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

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(Integer value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Integer value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Integer value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Integer value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Integer value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Integer> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Integer> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Integer value1, Integer value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andBmiIsNull() {
            addCriterion("bmi is null");
            return (Criteria) this;
        }

        public Criteria andBmiIsNotNull() {
            addCriterion("bmi is not null");
            return (Criteria) this;
        }

        public Criteria andBmiEqualTo(Double value) {
            addCriterion("bmi =", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiNotEqualTo(Double value) {
            addCriterion("bmi <>", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiGreaterThan(Double value) {
            addCriterion("bmi >", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiGreaterThanOrEqualTo(Double value) {
            addCriterion("bmi >=", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiLessThan(Double value) {
            addCriterion("bmi <", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiLessThanOrEqualTo(Double value) {
            addCriterion("bmi <=", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiIn(List<Double> values) {
            addCriterion("bmi in", values, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiNotIn(List<Double> values) {
            addCriterion("bmi not in", values, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiBetween(Double value1, Double value2) {
            addCriterion("bmi between", value1, value2, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiNotBetween(Double value1, Double value2) {
            addCriterion("bmi not between", value1, value2, "bmi");
            return (Criteria) this;
        }

        public Criteria andFatRateIsNull() {
            addCriterion("fat_rate is null");
            return (Criteria) this;
        }

        public Criteria andFatRateIsNotNull() {
            addCriterion("fat_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFatRateEqualTo(Double value) {
            addCriterion("fat_rate =", value, "fatRate");
            return (Criteria) this;
        }

        public Criteria andFatRateNotEqualTo(Double value) {
            addCriterion("fat_rate <>", value, "fatRate");
            return (Criteria) this;
        }

        public Criteria andFatRateGreaterThan(Double value) {
            addCriterion("fat_rate >", value, "fatRate");
            return (Criteria) this;
        }

        public Criteria andFatRateGreaterThanOrEqualTo(Double value) {
            addCriterion("fat_rate >=", value, "fatRate");
            return (Criteria) this;
        }

        public Criteria andFatRateLessThan(Double value) {
            addCriterion("fat_rate <", value, "fatRate");
            return (Criteria) this;
        }

        public Criteria andFatRateLessThanOrEqualTo(Double value) {
            addCriterion("fat_rate <=", value, "fatRate");
            return (Criteria) this;
        }

        public Criteria andFatRateIn(List<Double> values) {
            addCriterion("fat_rate in", values, "fatRate");
            return (Criteria) this;
        }

        public Criteria andFatRateNotIn(List<Double> values) {
            addCriterion("fat_rate not in", values, "fatRate");
            return (Criteria) this;
        }

        public Criteria andFatRateBetween(Double value1, Double value2) {
            addCriterion("fat_rate between", value1, value2, "fatRate");
            return (Criteria) this;
        }

        public Criteria andFatRateNotBetween(Double value1, Double value2) {
            addCriterion("fat_rate not between", value1, value2, "fatRate");
            return (Criteria) this;
        }

        public Criteria andBustIsNull() {
            addCriterion("bust is null");
            return (Criteria) this;
        }

        public Criteria andBustIsNotNull() {
            addCriterion("bust is not null");
            return (Criteria) this;
        }

        public Criteria andBustEqualTo(Integer value) {
            addCriterion("bust =", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustNotEqualTo(Integer value) {
            addCriterion("bust <>", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustGreaterThan(Integer value) {
            addCriterion("bust >", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustGreaterThanOrEqualTo(Integer value) {
            addCriterion("bust >=", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustLessThan(Integer value) {
            addCriterion("bust <", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustLessThanOrEqualTo(Integer value) {
            addCriterion("bust <=", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustIn(List<Integer> values) {
            addCriterion("bust in", values, "bust");
            return (Criteria) this;
        }

        public Criteria andBustNotIn(List<Integer> values) {
            addCriterion("bust not in", values, "bust");
            return (Criteria) this;
        }

        public Criteria andBustBetween(Integer value1, Integer value2) {
            addCriterion("bust between", value1, value2, "bust");
            return (Criteria) this;
        }

        public Criteria andBustNotBetween(Integer value1, Integer value2) {
            addCriterion("bust not between", value1, value2, "bust");
            return (Criteria) this;
        }

        public Criteria andWaistIsNull() {
            addCriterion("waist is null");
            return (Criteria) this;
        }

        public Criteria andWaistIsNotNull() {
            addCriterion("waist is not null");
            return (Criteria) this;
        }

        public Criteria andWaistEqualTo(Integer value) {
            addCriterion("waist =", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistNotEqualTo(Integer value) {
            addCriterion("waist <>", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistGreaterThan(Integer value) {
            addCriterion("waist >", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistGreaterThanOrEqualTo(Integer value) {
            addCriterion("waist >=", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistLessThan(Integer value) {
            addCriterion("waist <", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistLessThanOrEqualTo(Integer value) {
            addCriterion("waist <=", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistIn(List<Integer> values) {
            addCriterion("waist in", values, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistNotIn(List<Integer> values) {
            addCriterion("waist not in", values, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistBetween(Integer value1, Integer value2) {
            addCriterion("waist between", value1, value2, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistNotBetween(Integer value1, Integer value2) {
            addCriterion("waist not between", value1, value2, "waist");
            return (Criteria) this;
        }

        public Criteria andHipIsNull() {
            addCriterion("hip is null");
            return (Criteria) this;
        }

        public Criteria andHipIsNotNull() {
            addCriterion("hip is not null");
            return (Criteria) this;
        }

        public Criteria andHipEqualTo(Integer value) {
            addCriterion("hip =", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipNotEqualTo(Integer value) {
            addCriterion("hip <>", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipGreaterThan(Integer value) {
            addCriterion("hip >", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipGreaterThanOrEqualTo(Integer value) {
            addCriterion("hip >=", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipLessThan(Integer value) {
            addCriterion("hip <", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipLessThanOrEqualTo(Integer value) {
            addCriterion("hip <=", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipIn(List<Integer> values) {
            addCriterion("hip in", values, "hip");
            return (Criteria) this;
        }

        public Criteria andHipNotIn(List<Integer> values) {
            addCriterion("hip not in", values, "hip");
            return (Criteria) this;
        }

        public Criteria andHipBetween(Integer value1, Integer value2) {
            addCriterion("hip between", value1, value2, "hip");
            return (Criteria) this;
        }

        public Criteria andHipNotBetween(Integer value1, Integer value2) {
            addCriterion("hip not between", value1, value2, "hip");
            return (Criteria) this;
        }

        public Criteria andMuscleOxygenIsNull() {
            addCriterion("muscle_oxygen is null");
            return (Criteria) this;
        }

        public Criteria andMuscleOxygenIsNotNull() {
            addCriterion("muscle_oxygen is not null");
            return (Criteria) this;
        }

        public Criteria andMuscleOxygenEqualTo(Integer value) {
            addCriterion("muscle_oxygen =", value, "muscleOxygen");
            return (Criteria) this;
        }

        public Criteria andMuscleOxygenNotEqualTo(Integer value) {
            addCriterion("muscle_oxygen <>", value, "muscleOxygen");
            return (Criteria) this;
        }

        public Criteria andMuscleOxygenGreaterThan(Integer value) {
            addCriterion("muscle_oxygen >", value, "muscleOxygen");
            return (Criteria) this;
        }

        public Criteria andMuscleOxygenGreaterThanOrEqualTo(Integer value) {
            addCriterion("muscle_oxygen >=", value, "muscleOxygen");
            return (Criteria) this;
        }

        public Criteria andMuscleOxygenLessThan(Integer value) {
            addCriterion("muscle_oxygen <", value, "muscleOxygen");
            return (Criteria) this;
        }

        public Criteria andMuscleOxygenLessThanOrEqualTo(Integer value) {
            addCriterion("muscle_oxygen <=", value, "muscleOxygen");
            return (Criteria) this;
        }

        public Criteria andMuscleOxygenIn(List<Integer> values) {
            addCriterion("muscle_oxygen in", values, "muscleOxygen");
            return (Criteria) this;
        }

        public Criteria andMuscleOxygenNotIn(List<Integer> values) {
            addCriterion("muscle_oxygen not in", values, "muscleOxygen");
            return (Criteria) this;
        }

        public Criteria andMuscleOxygenBetween(Integer value1, Integer value2) {
            addCriterion("muscle_oxygen between", value1, value2, "muscleOxygen");
            return (Criteria) this;
        }

        public Criteria andMuscleOxygenNotBetween(Integer value1, Integer value2) {
            addCriterion("muscle_oxygen not between", value1, value2, "muscleOxygen");
            return (Criteria) this;
        }

        public Criteria andSystolicBloodPressureIsNull() {
            addCriterion("systolic_blood_pressure is null");
            return (Criteria) this;
        }

        public Criteria andSystolicBloodPressureIsNotNull() {
            addCriterion("systolic_blood_pressure is not null");
            return (Criteria) this;
        }

        public Criteria andSystolicBloodPressureEqualTo(Integer value) {
            addCriterion("systolic_blood_pressure =", value, "systolicBloodPressure");
            return (Criteria) this;
        }

        public Criteria andSystolicBloodPressureNotEqualTo(Integer value) {
            addCriterion("systolic_blood_pressure <>", value, "systolicBloodPressure");
            return (Criteria) this;
        }

        public Criteria andSystolicBloodPressureGreaterThan(Integer value) {
            addCriterion("systolic_blood_pressure >", value, "systolicBloodPressure");
            return (Criteria) this;
        }

        public Criteria andSystolicBloodPressureGreaterThanOrEqualTo(Integer value) {
            addCriterion("systolic_blood_pressure >=", value, "systolicBloodPressure");
            return (Criteria) this;
        }

        public Criteria andSystolicBloodPressureLessThan(Integer value) {
            addCriterion("systolic_blood_pressure <", value, "systolicBloodPressure");
            return (Criteria) this;
        }

        public Criteria andSystolicBloodPressureLessThanOrEqualTo(Integer value) {
            addCriterion("systolic_blood_pressure <=", value, "systolicBloodPressure");
            return (Criteria) this;
        }

        public Criteria andSystolicBloodPressureIn(List<Integer> values) {
            addCriterion("systolic_blood_pressure in", values, "systolicBloodPressure");
            return (Criteria) this;
        }

        public Criteria andSystolicBloodPressureNotIn(List<Integer> values) {
            addCriterion("systolic_blood_pressure not in", values, "systolicBloodPressure");
            return (Criteria) this;
        }

        public Criteria andSystolicBloodPressureBetween(Integer value1, Integer value2) {
            addCriterion("systolic_blood_pressure between", value1, value2, "systolicBloodPressure");
            return (Criteria) this;
        }

        public Criteria andSystolicBloodPressureNotBetween(Integer value1, Integer value2) {
            addCriterion("systolic_blood_pressure not between", value1, value2, "systolicBloodPressure");
            return (Criteria) this;
        }

        public Criteria andDiastolicBloodPressureIsNull() {
            addCriterion("diastolic_blood_pressure is null");
            return (Criteria) this;
        }

        public Criteria andDiastolicBloodPressureIsNotNull() {
            addCriterion("diastolic_blood_pressure is not null");
            return (Criteria) this;
        }

        public Criteria andDiastolicBloodPressureEqualTo(Integer value) {
            addCriterion("diastolic_blood_pressure =", value, "diastolicBloodPressure");
            return (Criteria) this;
        }

        public Criteria andDiastolicBloodPressureNotEqualTo(Integer value) {
            addCriterion("diastolic_blood_pressure <>", value, "diastolicBloodPressure");
            return (Criteria) this;
        }

        public Criteria andDiastolicBloodPressureGreaterThan(Integer value) {
            addCriterion("diastolic_blood_pressure >", value, "diastolicBloodPressure");
            return (Criteria) this;
        }

        public Criteria andDiastolicBloodPressureGreaterThanOrEqualTo(Integer value) {
            addCriterion("diastolic_blood_pressure >=", value, "diastolicBloodPressure");
            return (Criteria) this;
        }

        public Criteria andDiastolicBloodPressureLessThan(Integer value) {
            addCriterion("diastolic_blood_pressure <", value, "diastolicBloodPressure");
            return (Criteria) this;
        }

        public Criteria andDiastolicBloodPressureLessThanOrEqualTo(Integer value) {
            addCriterion("diastolic_blood_pressure <=", value, "diastolicBloodPressure");
            return (Criteria) this;
        }

        public Criteria andDiastolicBloodPressureIn(List<Integer> values) {
            addCriterion("diastolic_blood_pressure in", values, "diastolicBloodPressure");
            return (Criteria) this;
        }

        public Criteria andDiastolicBloodPressureNotIn(List<Integer> values) {
            addCriterion("diastolic_blood_pressure not in", values, "diastolicBloodPressure");
            return (Criteria) this;
        }

        public Criteria andDiastolicBloodPressureBetween(Integer value1, Integer value2) {
            addCriterion("diastolic_blood_pressure between", value1, value2, "diastolicBloodPressure");
            return (Criteria) this;
        }

        public Criteria andDiastolicBloodPressureNotBetween(Integer value1, Integer value2) {
            addCriterion("diastolic_blood_pressure not between", value1, value2, "diastolicBloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodOxygenIsNull() {
            addCriterion("blood_oxygen is null");
            return (Criteria) this;
        }

        public Criteria andBloodOxygenIsNotNull() {
            addCriterion("blood_oxygen is not null");
            return (Criteria) this;
        }

        public Criteria andBloodOxygenEqualTo(Integer value) {
            addCriterion("blood_oxygen =", value, "bloodOxygen");
            return (Criteria) this;
        }

        public Criteria andBloodOxygenNotEqualTo(Integer value) {
            addCriterion("blood_oxygen <>", value, "bloodOxygen");
            return (Criteria) this;
        }

        public Criteria andBloodOxygenGreaterThan(Integer value) {
            addCriterion("blood_oxygen >", value, "bloodOxygen");
            return (Criteria) this;
        }

        public Criteria andBloodOxygenGreaterThanOrEqualTo(Integer value) {
            addCriterion("blood_oxygen >=", value, "bloodOxygen");
            return (Criteria) this;
        }

        public Criteria andBloodOxygenLessThan(Integer value) {
            addCriterion("blood_oxygen <", value, "bloodOxygen");
            return (Criteria) this;
        }

        public Criteria andBloodOxygenLessThanOrEqualTo(Integer value) {
            addCriterion("blood_oxygen <=", value, "bloodOxygen");
            return (Criteria) this;
        }

        public Criteria andBloodOxygenIn(List<Integer> values) {
            addCriterion("blood_oxygen in", values, "bloodOxygen");
            return (Criteria) this;
        }

        public Criteria andBloodOxygenNotIn(List<Integer> values) {
            addCriterion("blood_oxygen not in", values, "bloodOxygen");
            return (Criteria) this;
        }

        public Criteria andBloodOxygenBetween(Integer value1, Integer value2) {
            addCriterion("blood_oxygen between", value1, value2, "bloodOxygen");
            return (Criteria) this;
        }

        public Criteria andBloodOxygenNotBetween(Integer value1, Integer value2) {
            addCriterion("blood_oxygen not between", value1, value2, "bloodOxygen");
            return (Criteria) this;
        }

        public Criteria andHeartRateIsNull() {
            addCriterion("heart_rate is null");
            return (Criteria) this;
        }

        public Criteria andHeartRateIsNotNull() {
            addCriterion("heart_rate is not null");
            return (Criteria) this;
        }

        public Criteria andHeartRateEqualTo(Integer value) {
            addCriterion("heart_rate =", value, "heartRate");
            return (Criteria) this;
        }

        public Criteria andHeartRateNotEqualTo(Integer value) {
            addCriterion("heart_rate <>", value, "heartRate");
            return (Criteria) this;
        }

        public Criteria andHeartRateGreaterThan(Integer value) {
            addCriterion("heart_rate >", value, "heartRate");
            return (Criteria) this;
        }

        public Criteria andHeartRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("heart_rate >=", value, "heartRate");
            return (Criteria) this;
        }

        public Criteria andHeartRateLessThan(Integer value) {
            addCriterion("heart_rate <", value, "heartRate");
            return (Criteria) this;
        }

        public Criteria andHeartRateLessThanOrEqualTo(Integer value) {
            addCriterion("heart_rate <=", value, "heartRate");
            return (Criteria) this;
        }

        public Criteria andHeartRateIn(List<Integer> values) {
            addCriterion("heart_rate in", values, "heartRate");
            return (Criteria) this;
        }

        public Criteria andHeartRateNotIn(List<Integer> values) {
            addCriterion("heart_rate not in", values, "heartRate");
            return (Criteria) this;
        }

        public Criteria andHeartRateBetween(Integer value1, Integer value2) {
            addCriterion("heart_rate between", value1, value2, "heartRate");
            return (Criteria) this;
        }

        public Criteria andHeartRateNotBetween(Integer value1, Integer value2) {
            addCriterion("heart_rate not between", value1, value2, "heartRate");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureIsNull() {
            addCriterion("body_temperature is null");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureIsNotNull() {
            addCriterion("body_temperature is not null");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureEqualTo(Double value) {
            addCriterion("body_temperature =", value, "bodyTemperature");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureNotEqualTo(Double value) {
            addCriterion("body_temperature <>", value, "bodyTemperature");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureGreaterThan(Double value) {
            addCriterion("body_temperature >", value, "bodyTemperature");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureGreaterThanOrEqualTo(Double value) {
            addCriterion("body_temperature >=", value, "bodyTemperature");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureLessThan(Double value) {
            addCriterion("body_temperature <", value, "bodyTemperature");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureLessThanOrEqualTo(Double value) {
            addCriterion("body_temperature <=", value, "bodyTemperature");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureIn(List<Double> values) {
            addCriterion("body_temperature in", values, "bodyTemperature");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureNotIn(List<Double> values) {
            addCriterion("body_temperature not in", values, "bodyTemperature");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureBetween(Double value1, Double value2) {
            addCriterion("body_temperature between", value1, value2, "bodyTemperature");
            return (Criteria) this;
        }

        public Criteria andBodyTemperatureNotBetween(Double value1, Double value2) {
            addCriterion("body_temperature not between", value1, value2, "bodyTemperature");
            return (Criteria) this;
        }

        public Criteria andPhUrineIsNull() {
            addCriterion("ph_urine is null");
            return (Criteria) this;
        }

        public Criteria andPhUrineIsNotNull() {
            addCriterion("ph_urine is not null");
            return (Criteria) this;
        }

        public Criteria andPhUrineEqualTo(Double value) {
            addCriterion("ph_urine =", value, "phUrine");
            return (Criteria) this;
        }

        public Criteria andPhUrineNotEqualTo(Double value) {
            addCriterion("ph_urine <>", value, "phUrine");
            return (Criteria) this;
        }

        public Criteria andPhUrineGreaterThan(Double value) {
            addCriterion("ph_urine >", value, "phUrine");
            return (Criteria) this;
        }

        public Criteria andPhUrineGreaterThanOrEqualTo(Double value) {
            addCriterion("ph_urine >=", value, "phUrine");
            return (Criteria) this;
        }

        public Criteria andPhUrineLessThan(Double value) {
            addCriterion("ph_urine <", value, "phUrine");
            return (Criteria) this;
        }

        public Criteria andPhUrineLessThanOrEqualTo(Double value) {
            addCriterion("ph_urine <=", value, "phUrine");
            return (Criteria) this;
        }

        public Criteria andPhUrineIn(List<Double> values) {
            addCriterion("ph_urine in", values, "phUrine");
            return (Criteria) this;
        }

        public Criteria andPhUrineNotIn(List<Double> values) {
            addCriterion("ph_urine not in", values, "phUrine");
            return (Criteria) this;
        }

        public Criteria andPhUrineBetween(Double value1, Double value2) {
            addCriterion("ph_urine between", value1, value2, "phUrine");
            return (Criteria) this;
        }

        public Criteria andPhUrineNotBetween(Double value1, Double value2) {
            addCriterion("ph_urine not between", value1, value2, "phUrine");
            return (Criteria) this;
        }

        public Criteria andKetonuriaIsNull() {
            addCriterion("ketonuria is null");
            return (Criteria) this;
        }

        public Criteria andKetonuriaIsNotNull() {
            addCriterion("ketonuria is not null");
            return (Criteria) this;
        }

        public Criteria andKetonuriaEqualTo(Integer value) {
            addCriterion("ketonuria =", value, "ketonuria");
            return (Criteria) this;
        }

        public Criteria andKetonuriaNotEqualTo(Integer value) {
            addCriterion("ketonuria <>", value, "ketonuria");
            return (Criteria) this;
        }

        public Criteria andKetonuriaGreaterThan(Integer value) {
            addCriterion("ketonuria >", value, "ketonuria");
            return (Criteria) this;
        }

        public Criteria andKetonuriaGreaterThanOrEqualTo(Integer value) {
            addCriterion("ketonuria >=", value, "ketonuria");
            return (Criteria) this;
        }

        public Criteria andKetonuriaLessThan(Integer value) {
            addCriterion("ketonuria <", value, "ketonuria");
            return (Criteria) this;
        }

        public Criteria andKetonuriaLessThanOrEqualTo(Integer value) {
            addCriterion("ketonuria <=", value, "ketonuria");
            return (Criteria) this;
        }

        public Criteria andKetonuriaIn(List<Integer> values) {
            addCriterion("ketonuria in", values, "ketonuria");
            return (Criteria) this;
        }

        public Criteria andKetonuriaNotIn(List<Integer> values) {
            addCriterion("ketonuria not in", values, "ketonuria");
            return (Criteria) this;
        }

        public Criteria andKetonuriaBetween(Integer value1, Integer value2) {
            addCriterion("ketonuria between", value1, value2, "ketonuria");
            return (Criteria) this;
        }

        public Criteria andKetonuriaNotBetween(Integer value1, Integer value2) {
            addCriterion("ketonuria not between", value1, value2, "ketonuria");
            return (Criteria) this;
        }

        public Criteria andForeArmIsNull() {
            addCriterion("fore_arm is null");
            return (Criteria) this;
        }

        public Criteria andForeArmIsNotNull() {
            addCriterion("fore_arm is not null");
            return (Criteria) this;
        }

        public Criteria andForeArmEqualTo(Double value) {
            addCriterion("fore_arm =", value, "foreArm");
            return (Criteria) this;
        }

        public Criteria andForeArmNotEqualTo(Double value) {
            addCriterion("fore_arm <>", value, "foreArm");
            return (Criteria) this;
        }

        public Criteria andForeArmGreaterThan(Double value) {
            addCriterion("fore_arm >", value, "foreArm");
            return (Criteria) this;
        }

        public Criteria andForeArmGreaterThanOrEqualTo(Double value) {
            addCriterion("fore_arm >=", value, "foreArm");
            return (Criteria) this;
        }

        public Criteria andForeArmLessThan(Double value) {
            addCriterion("fore_arm <", value, "foreArm");
            return (Criteria) this;
        }

        public Criteria andForeArmLessThanOrEqualTo(Double value) {
            addCriterion("fore_arm <=", value, "foreArm");
            return (Criteria) this;
        }

        public Criteria andForeArmIn(List<Double> values) {
            addCriterion("fore_arm in", values, "foreArm");
            return (Criteria) this;
        }

        public Criteria andForeArmNotIn(List<Double> values) {
            addCriterion("fore_arm not in", values, "foreArm");
            return (Criteria) this;
        }

        public Criteria andForeArmBetween(Double value1, Double value2) {
            addCriterion("fore_arm between", value1, value2, "foreArm");
            return (Criteria) this;
        }

        public Criteria andForeArmNotBetween(Double value1, Double value2) {
            addCriterion("fore_arm not between", value1, value2, "foreArm");
            return (Criteria) this;
        }

        public Criteria andCalfIsNull() {
            addCriterion("calf is null");
            return (Criteria) this;
        }

        public Criteria andCalfIsNotNull() {
            addCriterion("calf is not null");
            return (Criteria) this;
        }

        public Criteria andCalfEqualTo(Double value) {
            addCriterion("calf =", value, "calf");
            return (Criteria) this;
        }

        public Criteria andCalfNotEqualTo(Double value) {
            addCriterion("calf <>", value, "calf");
            return (Criteria) this;
        }

        public Criteria andCalfGreaterThan(Double value) {
            addCriterion("calf >", value, "calf");
            return (Criteria) this;
        }

        public Criteria andCalfGreaterThanOrEqualTo(Double value) {
            addCriterion("calf >=", value, "calf");
            return (Criteria) this;
        }

        public Criteria andCalfLessThan(Double value) {
            addCriterion("calf <", value, "calf");
            return (Criteria) this;
        }

        public Criteria andCalfLessThanOrEqualTo(Double value) {
            addCriterion("calf <=", value, "calf");
            return (Criteria) this;
        }

        public Criteria andCalfIn(List<Double> values) {
            addCriterion("calf in", values, "calf");
            return (Criteria) this;
        }

        public Criteria andCalfNotIn(List<Double> values) {
            addCriterion("calf not in", values, "calf");
            return (Criteria) this;
        }

        public Criteria andCalfBetween(Double value1, Double value2) {
            addCriterion("calf between", value1, value2, "calf");
            return (Criteria) this;
        }

        public Criteria andCalfNotBetween(Double value1, Double value2) {
            addCriterion("calf not between", value1, value2, "calf");
            return (Criteria) this;
        }

        public Criteria andThignIsNull() {
            addCriterion("thign is null");
            return (Criteria) this;
        }

        public Criteria andThignIsNotNull() {
            addCriterion("thign is not null");
            return (Criteria) this;
        }

        public Criteria andThignEqualTo(Double value) {
            addCriterion("thign =", value, "thign");
            return (Criteria) this;
        }

        public Criteria andThignNotEqualTo(Double value) {
            addCriterion("thign <>", value, "thign");
            return (Criteria) this;
        }

        public Criteria andThignGreaterThan(Double value) {
            addCriterion("thign >", value, "thign");
            return (Criteria) this;
        }

        public Criteria andThignGreaterThanOrEqualTo(Double value) {
            addCriterion("thign >=", value, "thign");
            return (Criteria) this;
        }

        public Criteria andThignLessThan(Double value) {
            addCriterion("thign <", value, "thign");
            return (Criteria) this;
        }

        public Criteria andThignLessThanOrEqualTo(Double value) {
            addCriterion("thign <=", value, "thign");
            return (Criteria) this;
        }

        public Criteria andThignIn(List<Double> values) {
            addCriterion("thign in", values, "thign");
            return (Criteria) this;
        }

        public Criteria andThignNotIn(List<Double> values) {
            addCriterion("thign not in", values, "thign");
            return (Criteria) this;
        }

        public Criteria andThignBetween(Double value1, Double value2) {
            addCriterion("thign between", value1, value2, "thign");
            return (Criteria) this;
        }

        public Criteria andThignNotBetween(Double value1, Double value2) {
            addCriterion("thign not between", value1, value2, "thign");
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