package com.bkit.fatdown.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbDietUserStandardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbDietUserStandardExample() {
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

        public Criteria andEnergyIsNull() {
            addCriterion("energy is null");
            return (Criteria) this;
        }

        public Criteria andEnergyIsNotNull() {
            addCriterion("energy is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyEqualTo(Double value) {
            addCriterion("energy =", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotEqualTo(Double value) {
            addCriterion("energy <>", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyGreaterThan(Double value) {
            addCriterion("energy >", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyGreaterThanOrEqualTo(Double value) {
            addCriterion("energy >=", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyLessThan(Double value) {
            addCriterion("energy <", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyLessThanOrEqualTo(Double value) {
            addCriterion("energy <=", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyIn(List<Double> values) {
            addCriterion("energy in", values, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotIn(List<Double> values) {
            addCriterion("energy not in", values, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyBetween(Double value1, Double value2) {
            addCriterion("energy between", value1, value2, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotBetween(Double value1, Double value2) {
            addCriterion("energy not between", value1, value2, "energy");
            return (Criteria) this;
        }

        public Criteria andOilEnergyIsNull() {
            addCriterion("oil_energy is null");
            return (Criteria) this;
        }

        public Criteria andOilEnergyIsNotNull() {
            addCriterion("oil_energy is not null");
            return (Criteria) this;
        }

        public Criteria andOilEnergyEqualTo(Double value) {
            addCriterion("oil_energy =", value, "oilEnergy");
            return (Criteria) this;
        }

        public Criteria andOilEnergyNotEqualTo(Double value) {
            addCriterion("oil_energy <>", value, "oilEnergy");
            return (Criteria) this;
        }

        public Criteria andOilEnergyGreaterThan(Double value) {
            addCriterion("oil_energy >", value, "oilEnergy");
            return (Criteria) this;
        }

        public Criteria andOilEnergyGreaterThanOrEqualTo(Double value) {
            addCriterion("oil_energy >=", value, "oilEnergy");
            return (Criteria) this;
        }

        public Criteria andOilEnergyLessThan(Double value) {
            addCriterion("oil_energy <", value, "oilEnergy");
            return (Criteria) this;
        }

        public Criteria andOilEnergyLessThanOrEqualTo(Double value) {
            addCriterion("oil_energy <=", value, "oilEnergy");
            return (Criteria) this;
        }

        public Criteria andOilEnergyIn(List<Double> values) {
            addCriterion("oil_energy in", values, "oilEnergy");
            return (Criteria) this;
        }

        public Criteria andOilEnergyNotIn(List<Double> values) {
            addCriterion("oil_energy not in", values, "oilEnergy");
            return (Criteria) this;
        }

        public Criteria andOilEnergyBetween(Double value1, Double value2) {
            addCriterion("oil_energy between", value1, value2, "oilEnergy");
            return (Criteria) this;
        }

        public Criteria andOilEnergyNotBetween(Double value1, Double value2) {
            addCriterion("oil_energy not between", value1, value2, "oilEnergy");
            return (Criteria) this;
        }

        public Criteria andSaltyEnergyIsNull() {
            addCriterion("salty_energy is null");
            return (Criteria) this;
        }

        public Criteria andSaltyEnergyIsNotNull() {
            addCriterion("salty_energy is not null");
            return (Criteria) this;
        }

        public Criteria andSaltyEnergyEqualTo(Double value) {
            addCriterion("salty_energy =", value, "saltyEnergy");
            return (Criteria) this;
        }

        public Criteria andSaltyEnergyNotEqualTo(Double value) {
            addCriterion("salty_energy <>", value, "saltyEnergy");
            return (Criteria) this;
        }

        public Criteria andSaltyEnergyGreaterThan(Double value) {
            addCriterion("salty_energy >", value, "saltyEnergy");
            return (Criteria) this;
        }

        public Criteria andSaltyEnergyGreaterThanOrEqualTo(Double value) {
            addCriterion("salty_energy >=", value, "saltyEnergy");
            return (Criteria) this;
        }

        public Criteria andSaltyEnergyLessThan(Double value) {
            addCriterion("salty_energy <", value, "saltyEnergy");
            return (Criteria) this;
        }

        public Criteria andSaltyEnergyLessThanOrEqualTo(Double value) {
            addCriterion("salty_energy <=", value, "saltyEnergy");
            return (Criteria) this;
        }

        public Criteria andSaltyEnergyIn(List<Double> values) {
            addCriterion("salty_energy in", values, "saltyEnergy");
            return (Criteria) this;
        }

        public Criteria andSaltyEnergyNotIn(List<Double> values) {
            addCriterion("salty_energy not in", values, "saltyEnergy");
            return (Criteria) this;
        }

        public Criteria andSaltyEnergyBetween(Double value1, Double value2) {
            addCriterion("salty_energy between", value1, value2, "saltyEnergy");
            return (Criteria) this;
        }

        public Criteria andSaltyEnergyNotBetween(Double value1, Double value2) {
            addCriterion("salty_energy not between", value1, value2, "saltyEnergy");
            return (Criteria) this;
        }

        public Criteria andSpicyEnergyIsNull() {
            addCriterion("spicy_energy is null");
            return (Criteria) this;
        }

        public Criteria andSpicyEnergyIsNotNull() {
            addCriterion("spicy_energy is not null");
            return (Criteria) this;
        }

        public Criteria andSpicyEnergyEqualTo(Double value) {
            addCriterion("spicy_energy =", value, "spicyEnergy");
            return (Criteria) this;
        }

        public Criteria andSpicyEnergyNotEqualTo(Double value) {
            addCriterion("spicy_energy <>", value, "spicyEnergy");
            return (Criteria) this;
        }

        public Criteria andSpicyEnergyGreaterThan(Double value) {
            addCriterion("spicy_energy >", value, "spicyEnergy");
            return (Criteria) this;
        }

        public Criteria andSpicyEnergyGreaterThanOrEqualTo(Double value) {
            addCriterion("spicy_energy >=", value, "spicyEnergy");
            return (Criteria) this;
        }

        public Criteria andSpicyEnergyLessThan(Double value) {
            addCriterion("spicy_energy <", value, "spicyEnergy");
            return (Criteria) this;
        }

        public Criteria andSpicyEnergyLessThanOrEqualTo(Double value) {
            addCriterion("spicy_energy <=", value, "spicyEnergy");
            return (Criteria) this;
        }

        public Criteria andSpicyEnergyIn(List<Double> values) {
            addCriterion("spicy_energy in", values, "spicyEnergy");
            return (Criteria) this;
        }

        public Criteria andSpicyEnergyNotIn(List<Double> values) {
            addCriterion("spicy_energy not in", values, "spicyEnergy");
            return (Criteria) this;
        }

        public Criteria andSpicyEnergyBetween(Double value1, Double value2) {
            addCriterion("spicy_energy between", value1, value2, "spicyEnergy");
            return (Criteria) this;
        }

        public Criteria andSpicyEnergyNotBetween(Double value1, Double value2) {
            addCriterion("spicy_energy not between", value1, value2, "spicyEnergy");
            return (Criteria) this;
        }

        public Criteria andProteinIsNull() {
            addCriterion("protein is null");
            return (Criteria) this;
        }

        public Criteria andProteinIsNotNull() {
            addCriterion("protein is not null");
            return (Criteria) this;
        }

        public Criteria andProteinEqualTo(Double value) {
            addCriterion("protein =", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinNotEqualTo(Double value) {
            addCriterion("protein <>", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinGreaterThan(Double value) {
            addCriterion("protein >", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinGreaterThanOrEqualTo(Double value) {
            addCriterion("protein >=", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinLessThan(Double value) {
            addCriterion("protein <", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinLessThanOrEqualTo(Double value) {
            addCriterion("protein <=", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinIn(List<Double> values) {
            addCriterion("protein in", values, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinNotIn(List<Double> values) {
            addCriterion("protein not in", values, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinBetween(Double value1, Double value2) {
            addCriterion("protein between", value1, value2, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinNotBetween(Double value1, Double value2) {
            addCriterion("protein not between", value1, value2, "protein");
            return (Criteria) this;
        }

        public Criteria andFatIsNull() {
            addCriterion("fat is null");
            return (Criteria) this;
        }

        public Criteria andFatIsNotNull() {
            addCriterion("fat is not null");
            return (Criteria) this;
        }

        public Criteria andFatEqualTo(Double value) {
            addCriterion("fat =", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatNotEqualTo(Double value) {
            addCriterion("fat <>", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatGreaterThan(Double value) {
            addCriterion("fat >", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatGreaterThanOrEqualTo(Double value) {
            addCriterion("fat >=", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatLessThan(Double value) {
            addCriterion("fat <", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatLessThanOrEqualTo(Double value) {
            addCriterion("fat <=", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatIn(List<Double> values) {
            addCriterion("fat in", values, "fat");
            return (Criteria) this;
        }

        public Criteria andFatNotIn(List<Double> values) {
            addCriterion("fat not in", values, "fat");
            return (Criteria) this;
        }

        public Criteria andFatBetween(Double value1, Double value2) {
            addCriterion("fat between", value1, value2, "fat");
            return (Criteria) this;
        }

        public Criteria andFatNotBetween(Double value1, Double value2) {
            addCriterion("fat not between", value1, value2, "fat");
            return (Criteria) this;
        }

        public Criteria andCarbsIsNull() {
            addCriterion("carbs is null");
            return (Criteria) this;
        }

        public Criteria andCarbsIsNotNull() {
            addCriterion("carbs is not null");
            return (Criteria) this;
        }

        public Criteria andCarbsEqualTo(Double value) {
            addCriterion("carbs =", value, "carbs");
            return (Criteria) this;
        }

        public Criteria andCarbsNotEqualTo(Double value) {
            addCriterion("carbs <>", value, "carbs");
            return (Criteria) this;
        }

        public Criteria andCarbsGreaterThan(Double value) {
            addCriterion("carbs >", value, "carbs");
            return (Criteria) this;
        }

        public Criteria andCarbsGreaterThanOrEqualTo(Double value) {
            addCriterion("carbs >=", value, "carbs");
            return (Criteria) this;
        }

        public Criteria andCarbsLessThan(Double value) {
            addCriterion("carbs <", value, "carbs");
            return (Criteria) this;
        }

        public Criteria andCarbsLessThanOrEqualTo(Double value) {
            addCriterion("carbs <=", value, "carbs");
            return (Criteria) this;
        }

        public Criteria andCarbsIn(List<Double> values) {
            addCriterion("carbs in", values, "carbs");
            return (Criteria) this;
        }

        public Criteria andCarbsNotIn(List<Double> values) {
            addCriterion("carbs not in", values, "carbs");
            return (Criteria) this;
        }

        public Criteria andCarbsBetween(Double value1, Double value2) {
            addCriterion("carbs between", value1, value2, "carbs");
            return (Criteria) this;
        }

        public Criteria andCarbsNotBetween(Double value1, Double value2) {
            addCriterion("carbs not between", value1, value2, "carbs");
            return (Criteria) this;
        }

        public Criteria andInsolubleFibreIsNull() {
            addCriterion("insoluble_fibre is null");
            return (Criteria) this;
        }

        public Criteria andInsolubleFibreIsNotNull() {
            addCriterion("insoluble_fibre is not null");
            return (Criteria) this;
        }

        public Criteria andInsolubleFibreEqualTo(Double value) {
            addCriterion("insoluble_fibre =", value, "insolubleFibre");
            return (Criteria) this;
        }

        public Criteria andInsolubleFibreNotEqualTo(Double value) {
            addCriterion("insoluble_fibre <>", value, "insolubleFibre");
            return (Criteria) this;
        }

        public Criteria andInsolubleFibreGreaterThan(Double value) {
            addCriterion("insoluble_fibre >", value, "insolubleFibre");
            return (Criteria) this;
        }

        public Criteria andInsolubleFibreGreaterThanOrEqualTo(Double value) {
            addCriterion("insoluble_fibre >=", value, "insolubleFibre");
            return (Criteria) this;
        }

        public Criteria andInsolubleFibreLessThan(Double value) {
            addCriterion("insoluble_fibre <", value, "insolubleFibre");
            return (Criteria) this;
        }

        public Criteria andInsolubleFibreLessThanOrEqualTo(Double value) {
            addCriterion("insoluble_fibre <=", value, "insolubleFibre");
            return (Criteria) this;
        }

        public Criteria andInsolubleFibreIn(List<Double> values) {
            addCriterion("insoluble_fibre in", values, "insolubleFibre");
            return (Criteria) this;
        }

        public Criteria andInsolubleFibreNotIn(List<Double> values) {
            addCriterion("insoluble_fibre not in", values, "insolubleFibre");
            return (Criteria) this;
        }

        public Criteria andInsolubleFibreBetween(Double value1, Double value2) {
            addCriterion("insoluble_fibre between", value1, value2, "insolubleFibre");
            return (Criteria) this;
        }

        public Criteria andInsolubleFibreNotBetween(Double value1, Double value2) {
            addCriterion("insoluble_fibre not between", value1, value2, "insolubleFibre");
            return (Criteria) this;
        }

        public Criteria andCholesterolIsNull() {
            addCriterion("cholesterol is null");
            return (Criteria) this;
        }

        public Criteria andCholesterolIsNotNull() {
            addCriterion("cholesterol is not null");
            return (Criteria) this;
        }

        public Criteria andCholesterolEqualTo(Double value) {
            addCriterion("cholesterol =", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolNotEqualTo(Double value) {
            addCriterion("cholesterol <>", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolGreaterThan(Double value) {
            addCriterion("cholesterol >", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolGreaterThanOrEqualTo(Double value) {
            addCriterion("cholesterol >=", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolLessThan(Double value) {
            addCriterion("cholesterol <", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolLessThanOrEqualTo(Double value) {
            addCriterion("cholesterol <=", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolIn(List<Double> values) {
            addCriterion("cholesterol in", values, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolNotIn(List<Double> values) {
            addCriterion("cholesterol not in", values, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolBetween(Double value1, Double value2) {
            addCriterion("cholesterol between", value1, value2, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolNotBetween(Double value1, Double value2) {
            addCriterion("cholesterol not between", value1, value2, "cholesterol");
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