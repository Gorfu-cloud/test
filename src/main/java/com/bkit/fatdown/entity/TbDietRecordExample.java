package com.bkit.fatdown.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbDietRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbDietRecordExample() {
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andStructureSetIsNull() {
            addCriterion("structure_set is null");
            return (Criteria) this;
        }

        public Criteria andStructureSetIsNotNull() {
            addCriterion("structure_set is not null");
            return (Criteria) this;
        }

        public Criteria andStructureSetEqualTo(String value) {
            addCriterion("structure_set =", value, "structureSet");
            return (Criteria) this;
        }

        public Criteria andStructureSetNotEqualTo(String value) {
            addCriterion("structure_set <>", value, "structureSet");
            return (Criteria) this;
        }

        public Criteria andStructureSetGreaterThan(String value) {
            addCriterion("structure_set >", value, "structureSet");
            return (Criteria) this;
        }

        public Criteria andStructureSetGreaterThanOrEqualTo(String value) {
            addCriterion("structure_set >=", value, "structureSet");
            return (Criteria) this;
        }

        public Criteria andStructureSetLessThan(String value) {
            addCriterion("structure_set <", value, "structureSet");
            return (Criteria) this;
        }

        public Criteria andStructureSetLessThanOrEqualTo(String value) {
            addCriterion("structure_set <=", value, "structureSet");
            return (Criteria) this;
        }

        public Criteria andStructureSetLike(String value) {
            addCriterion("structure_set like", value, "structureSet");
            return (Criteria) this;
        }

        public Criteria andStructureSetNotLike(String value) {
            addCriterion("structure_set not like", value, "structureSet");
            return (Criteria) this;
        }

        public Criteria andStructureSetIn(List<String> values) {
            addCriterion("structure_set in", values, "structureSet");
            return (Criteria) this;
        }

        public Criteria andStructureSetNotIn(List<String> values) {
            addCriterion("structure_set not in", values, "structureSet");
            return (Criteria) this;
        }

        public Criteria andStructureSetBetween(String value1, String value2) {
            addCriterion("structure_set between", value1, value2, "structureSet");
            return (Criteria) this;
        }

        public Criteria andStructureSetNotBetween(String value1, String value2) {
            addCriterion("structure_set not between", value1, value2, "structureSet");
            return (Criteria) this;
        }

        public Criteria andProteinSetIsNull() {
            addCriterion("protein_set is null");
            return (Criteria) this;
        }

        public Criteria andProteinSetIsNotNull() {
            addCriterion("protein_set is not null");
            return (Criteria) this;
        }

        public Criteria andProteinSetEqualTo(String value) {
            addCriterion("protein_set =", value, "proteinSet");
            return (Criteria) this;
        }

        public Criteria andProteinSetNotEqualTo(String value) {
            addCriterion("protein_set <>", value, "proteinSet");
            return (Criteria) this;
        }

        public Criteria andProteinSetGreaterThan(String value) {
            addCriterion("protein_set >", value, "proteinSet");
            return (Criteria) this;
        }

        public Criteria andProteinSetGreaterThanOrEqualTo(String value) {
            addCriterion("protein_set >=", value, "proteinSet");
            return (Criteria) this;
        }

        public Criteria andProteinSetLessThan(String value) {
            addCriterion("protein_set <", value, "proteinSet");
            return (Criteria) this;
        }

        public Criteria andProteinSetLessThanOrEqualTo(String value) {
            addCriterion("protein_set <=", value, "proteinSet");
            return (Criteria) this;
        }

        public Criteria andProteinSetLike(String value) {
            addCriterion("protein_set like", value, "proteinSet");
            return (Criteria) this;
        }

        public Criteria andProteinSetNotLike(String value) {
            addCriterion("protein_set not like", value, "proteinSet");
            return (Criteria) this;
        }

        public Criteria andProteinSetIn(List<String> values) {
            addCriterion("protein_set in", values, "proteinSet");
            return (Criteria) this;
        }

        public Criteria andProteinSetNotIn(List<String> values) {
            addCriterion("protein_set not in", values, "proteinSet");
            return (Criteria) this;
        }

        public Criteria andProteinSetBetween(String value1, String value2) {
            addCriterion("protein_set between", value1, value2, "proteinSet");
            return (Criteria) this;
        }

        public Criteria andProteinSetNotBetween(String value1, String value2) {
            addCriterion("protein_set not between", value1, value2, "proteinSet");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSetIsNull() {
            addCriterion("staple_food_set is null");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSetIsNotNull() {
            addCriterion("staple_food_set is not null");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSetEqualTo(String value) {
            addCriterion("staple_food_set =", value, "stapleFoodSet");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSetNotEqualTo(String value) {
            addCriterion("staple_food_set <>", value, "stapleFoodSet");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSetGreaterThan(String value) {
            addCriterion("staple_food_set >", value, "stapleFoodSet");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSetGreaterThanOrEqualTo(String value) {
            addCriterion("staple_food_set >=", value, "stapleFoodSet");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSetLessThan(String value) {
            addCriterion("staple_food_set <", value, "stapleFoodSet");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSetLessThanOrEqualTo(String value) {
            addCriterion("staple_food_set <=", value, "stapleFoodSet");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSetLike(String value) {
            addCriterion("staple_food_set like", value, "stapleFoodSet");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSetNotLike(String value) {
            addCriterion("staple_food_set not like", value, "stapleFoodSet");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSetIn(List<String> values) {
            addCriterion("staple_food_set in", values, "stapleFoodSet");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSetNotIn(List<String> values) {
            addCriterion("staple_food_set not in", values, "stapleFoodSet");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSetBetween(String value1, String value2) {
            addCriterion("staple_food_set between", value1, value2, "stapleFoodSet");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSetNotBetween(String value1, String value2) {
            addCriterion("staple_food_set not between", value1, value2, "stapleFoodSet");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSetIsNull() {
            addCriterion("fruit_vegetable_set is null");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSetIsNotNull() {
            addCriterion("fruit_vegetable_set is not null");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSetEqualTo(String value) {
            addCriterion("fruit_vegetable_set =", value, "fruitVegetableSet");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSetNotEqualTo(String value) {
            addCriterion("fruit_vegetable_set <>", value, "fruitVegetableSet");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSetGreaterThan(String value) {
            addCriterion("fruit_vegetable_set >", value, "fruitVegetableSet");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSetGreaterThanOrEqualTo(String value) {
            addCriterion("fruit_vegetable_set >=", value, "fruitVegetableSet");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSetLessThan(String value) {
            addCriterion("fruit_vegetable_set <", value, "fruitVegetableSet");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSetLessThanOrEqualTo(String value) {
            addCriterion("fruit_vegetable_set <=", value, "fruitVegetableSet");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSetLike(String value) {
            addCriterion("fruit_vegetable_set like", value, "fruitVegetableSet");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSetNotLike(String value) {
            addCriterion("fruit_vegetable_set not like", value, "fruitVegetableSet");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSetIn(List<String> values) {
            addCriterion("fruit_vegetable_set in", values, "fruitVegetableSet");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSetNotIn(List<String> values) {
            addCriterion("fruit_vegetable_set not in", values, "fruitVegetableSet");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSetBetween(String value1, String value2) {
            addCriterion("fruit_vegetable_set between", value1, value2, "fruitVegetableSet");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSetNotBetween(String value1, String value2) {
            addCriterion("fruit_vegetable_set not between", value1, value2, "fruitVegetableSet");
            return (Criteria) this;
        }

        public Criteria andBeansSetIsNull() {
            addCriterion("beans_set is null");
            return (Criteria) this;
        }

        public Criteria andBeansSetIsNotNull() {
            addCriterion("beans_set is not null");
            return (Criteria) this;
        }

        public Criteria andBeansSetEqualTo(String value) {
            addCriterion("beans_set =", value, "beansSet");
            return (Criteria) this;
        }

        public Criteria andBeansSetNotEqualTo(String value) {
            addCriterion("beans_set <>", value, "beansSet");
            return (Criteria) this;
        }

        public Criteria andBeansSetGreaterThan(String value) {
            addCriterion("beans_set >", value, "beansSet");
            return (Criteria) this;
        }

        public Criteria andBeansSetGreaterThanOrEqualTo(String value) {
            addCriterion("beans_set >=", value, "beansSet");
            return (Criteria) this;
        }

        public Criteria andBeansSetLessThan(String value) {
            addCriterion("beans_set <", value, "beansSet");
            return (Criteria) this;
        }

        public Criteria andBeansSetLessThanOrEqualTo(String value) {
            addCriterion("beans_set <=", value, "beansSet");
            return (Criteria) this;
        }

        public Criteria andBeansSetLike(String value) {
            addCriterion("beans_set like", value, "beansSet");
            return (Criteria) this;
        }

        public Criteria andBeansSetNotLike(String value) {
            addCriterion("beans_set not like", value, "beansSet");
            return (Criteria) this;
        }

        public Criteria andBeansSetIn(List<String> values) {
            addCriterion("beans_set in", values, "beansSet");
            return (Criteria) this;
        }

        public Criteria andBeansSetNotIn(List<String> values) {
            addCriterion("beans_set not in", values, "beansSet");
            return (Criteria) this;
        }

        public Criteria andBeansSetBetween(String value1, String value2) {
            addCriterion("beans_set between", value1, value2, "beansSet");
            return (Criteria) this;
        }

        public Criteria andBeansSetNotBetween(String value1, String value2) {
            addCriterion("beans_set not between", value1, value2, "beansSet");
            return (Criteria) this;
        }

        public Criteria andNutsSetIsNull() {
            addCriterion("nuts_set is null");
            return (Criteria) this;
        }

        public Criteria andNutsSetIsNotNull() {
            addCriterion("nuts_set is not null");
            return (Criteria) this;
        }

        public Criteria andNutsSetEqualTo(String value) {
            addCriterion("nuts_set =", value, "nutsSet");
            return (Criteria) this;
        }

        public Criteria andNutsSetNotEqualTo(String value) {
            addCriterion("nuts_set <>", value, "nutsSet");
            return (Criteria) this;
        }

        public Criteria andNutsSetGreaterThan(String value) {
            addCriterion("nuts_set >", value, "nutsSet");
            return (Criteria) this;
        }

        public Criteria andNutsSetGreaterThanOrEqualTo(String value) {
            addCriterion("nuts_set >=", value, "nutsSet");
            return (Criteria) this;
        }

        public Criteria andNutsSetLessThan(String value) {
            addCriterion("nuts_set <", value, "nutsSet");
            return (Criteria) this;
        }

        public Criteria andNutsSetLessThanOrEqualTo(String value) {
            addCriterion("nuts_set <=", value, "nutsSet");
            return (Criteria) this;
        }

        public Criteria andNutsSetLike(String value) {
            addCriterion("nuts_set like", value, "nutsSet");
            return (Criteria) this;
        }

        public Criteria andNutsSetNotLike(String value) {
            addCriterion("nuts_set not like", value, "nutsSet");
            return (Criteria) this;
        }

        public Criteria andNutsSetIn(List<String> values) {
            addCriterion("nuts_set in", values, "nutsSet");
            return (Criteria) this;
        }

        public Criteria andNutsSetNotIn(List<String> values) {
            addCriterion("nuts_set not in", values, "nutsSet");
            return (Criteria) this;
        }

        public Criteria andNutsSetBetween(String value1, String value2) {
            addCriterion("nuts_set between", value1, value2, "nutsSet");
            return (Criteria) this;
        }

        public Criteria andNutsSetNotBetween(String value1, String value2) {
            addCriterion("nuts_set not between", value1, value2, "nutsSet");
            return (Criteria) this;
        }

        public Criteria andGoodProteinIsNull() {
            addCriterion("good_protein is null");
            return (Criteria) this;
        }

        public Criteria andGoodProteinIsNotNull() {
            addCriterion("good_protein is not null");
            return (Criteria) this;
        }

        public Criteria andGoodProteinEqualTo(Double value) {
            addCriterion("good_protein =", value, "goodProtein");
            return (Criteria) this;
        }

        public Criteria andGoodProteinNotEqualTo(Double value) {
            addCriterion("good_protein <>", value, "goodProtein");
            return (Criteria) this;
        }

        public Criteria andGoodProteinGreaterThan(Double value) {
            addCriterion("good_protein >", value, "goodProtein");
            return (Criteria) this;
        }

        public Criteria andGoodProteinGreaterThanOrEqualTo(Double value) {
            addCriterion("good_protein >=", value, "goodProtein");
            return (Criteria) this;
        }

        public Criteria andGoodProteinLessThan(Double value) {
            addCriterion("good_protein <", value, "goodProtein");
            return (Criteria) this;
        }

        public Criteria andGoodProteinLessThanOrEqualTo(Double value) {
            addCriterion("good_protein <=", value, "goodProtein");
            return (Criteria) this;
        }

        public Criteria andGoodProteinIn(List<Double> values) {
            addCriterion("good_protein in", values, "goodProtein");
            return (Criteria) this;
        }

        public Criteria andGoodProteinNotIn(List<Double> values) {
            addCriterion("good_protein not in", values, "goodProtein");
            return (Criteria) this;
        }

        public Criteria andGoodProteinBetween(Double value1, Double value2) {
            addCriterion("good_protein between", value1, value2, "goodProtein");
            return (Criteria) this;
        }

        public Criteria andGoodProteinNotBetween(Double value1, Double value2) {
            addCriterion("good_protein not between", value1, value2, "goodProtein");
            return (Criteria) this;
        }

        public Criteria andAnimalFatIsNull() {
            addCriterion("animal_fat is null");
            return (Criteria) this;
        }

        public Criteria andAnimalFatIsNotNull() {
            addCriterion("animal_fat is not null");
            return (Criteria) this;
        }

        public Criteria andAnimalFatEqualTo(Double value) {
            addCriterion("animal_fat =", value, "animalFat");
            return (Criteria) this;
        }

        public Criteria andAnimalFatNotEqualTo(Double value) {
            addCriterion("animal_fat <>", value, "animalFat");
            return (Criteria) this;
        }

        public Criteria andAnimalFatGreaterThan(Double value) {
            addCriterion("animal_fat >", value, "animalFat");
            return (Criteria) this;
        }

        public Criteria andAnimalFatGreaterThanOrEqualTo(Double value) {
            addCriterion("animal_fat >=", value, "animalFat");
            return (Criteria) this;
        }

        public Criteria andAnimalFatLessThan(Double value) {
            addCriterion("animal_fat <", value, "animalFat");
            return (Criteria) this;
        }

        public Criteria andAnimalFatLessThanOrEqualTo(Double value) {
            addCriterion("animal_fat <=", value, "animalFat");
            return (Criteria) this;
        }

        public Criteria andAnimalFatIn(List<Double> values) {
            addCriterion("animal_fat in", values, "animalFat");
            return (Criteria) this;
        }

        public Criteria andAnimalFatNotIn(List<Double> values) {
            addCriterion("animal_fat not in", values, "animalFat");
            return (Criteria) this;
        }

        public Criteria andAnimalFatBetween(Double value1, Double value2) {
            addCriterion("animal_fat between", value1, value2, "animalFat");
            return (Criteria) this;
        }

        public Criteria andAnimalFatNotBetween(Double value1, Double value2) {
            addCriterion("animal_fat not between", value1, value2, "animalFat");
            return (Criteria) this;
        }

        public Criteria andCaIsNull() {
            addCriterion("ca is null");
            return (Criteria) this;
        }

        public Criteria andCaIsNotNull() {
            addCriterion("ca is not null");
            return (Criteria) this;
        }

        public Criteria andCaEqualTo(Double value) {
            addCriterion("ca =", value, "ca");
            return (Criteria) this;
        }

        public Criteria andCaNotEqualTo(Double value) {
            addCriterion("ca <>", value, "ca");
            return (Criteria) this;
        }

        public Criteria andCaGreaterThan(Double value) {
            addCriterion("ca >", value, "ca");
            return (Criteria) this;
        }

        public Criteria andCaGreaterThanOrEqualTo(Double value) {
            addCriterion("ca >=", value, "ca");
            return (Criteria) this;
        }

        public Criteria andCaLessThan(Double value) {
            addCriterion("ca <", value, "ca");
            return (Criteria) this;
        }

        public Criteria andCaLessThanOrEqualTo(Double value) {
            addCriterion("ca <=", value, "ca");
            return (Criteria) this;
        }

        public Criteria andCaIn(List<Double> values) {
            addCriterion("ca in", values, "ca");
            return (Criteria) this;
        }

        public Criteria andCaNotIn(List<Double> values) {
            addCriterion("ca not in", values, "ca");
            return (Criteria) this;
        }

        public Criteria andCaBetween(Double value1, Double value2) {
            addCriterion("ca between", value1, value2, "ca");
            return (Criteria) this;
        }

        public Criteria andCaNotBetween(Double value1, Double value2) {
            addCriterion("ca not between", value1, value2, "ca");
            return (Criteria) this;
        }

        public Criteria andPIsNull() {
            addCriterion("p is null");
            return (Criteria) this;
        }

        public Criteria andPIsNotNull() {
            addCriterion("p is not null");
            return (Criteria) this;
        }

        public Criteria andPEqualTo(Double value) {
            addCriterion("p =", value, "p");
            return (Criteria) this;
        }

        public Criteria andPNotEqualTo(Double value) {
            addCriterion("p <>", value, "p");
            return (Criteria) this;
        }

        public Criteria andPGreaterThan(Double value) {
            addCriterion("p >", value, "p");
            return (Criteria) this;
        }

        public Criteria andPGreaterThanOrEqualTo(Double value) {
            addCriterion("p >=", value, "p");
            return (Criteria) this;
        }

        public Criteria andPLessThan(Double value) {
            addCriterion("p <", value, "p");
            return (Criteria) this;
        }

        public Criteria andPLessThanOrEqualTo(Double value) {
            addCriterion("p <=", value, "p");
            return (Criteria) this;
        }

        public Criteria andPIn(List<Double> values) {
            addCriterion("p in", values, "p");
            return (Criteria) this;
        }

        public Criteria andPNotIn(List<Double> values) {
            addCriterion("p not in", values, "p");
            return (Criteria) this;
        }

        public Criteria andPBetween(Double value1, Double value2) {
            addCriterion("p between", value1, value2, "p");
            return (Criteria) this;
        }

        public Criteria andPNotBetween(Double value1, Double value2) {
            addCriterion("p not between", value1, value2, "p");
            return (Criteria) this;
        }

        public Criteria andKIsNull() {
            addCriterion("k is null");
            return (Criteria) this;
        }

        public Criteria andKIsNotNull() {
            addCriterion("k is not null");
            return (Criteria) this;
        }

        public Criteria andKEqualTo(Double value) {
            addCriterion("k =", value, "k");
            return (Criteria) this;
        }

        public Criteria andKNotEqualTo(Double value) {
            addCriterion("k <>", value, "k");
            return (Criteria) this;
        }

        public Criteria andKGreaterThan(Double value) {
            addCriterion("k >", value, "k");
            return (Criteria) this;
        }

        public Criteria andKGreaterThanOrEqualTo(Double value) {
            addCriterion("k >=", value, "k");
            return (Criteria) this;
        }

        public Criteria andKLessThan(Double value) {
            addCriterion("k <", value, "k");
            return (Criteria) this;
        }

        public Criteria andKLessThanOrEqualTo(Double value) {
            addCriterion("k <=", value, "k");
            return (Criteria) this;
        }

        public Criteria andKIn(List<Double> values) {
            addCriterion("k in", values, "k");
            return (Criteria) this;
        }

        public Criteria andKNotIn(List<Double> values) {
            addCriterion("k not in", values, "k");
            return (Criteria) this;
        }

        public Criteria andKBetween(Double value1, Double value2) {
            addCriterion("k between", value1, value2, "k");
            return (Criteria) this;
        }

        public Criteria andKNotBetween(Double value1, Double value2) {
            addCriterion("k not between", value1, value2, "k");
            return (Criteria) this;
        }

        public Criteria andMgIsNull() {
            addCriterion("mg is null");
            return (Criteria) this;
        }

        public Criteria andMgIsNotNull() {
            addCriterion("mg is not null");
            return (Criteria) this;
        }

        public Criteria andMgEqualTo(Double value) {
            addCriterion("mg =", value, "mg");
            return (Criteria) this;
        }

        public Criteria andMgNotEqualTo(Double value) {
            addCriterion("mg <>", value, "mg");
            return (Criteria) this;
        }

        public Criteria andMgGreaterThan(Double value) {
            addCriterion("mg >", value, "mg");
            return (Criteria) this;
        }

        public Criteria andMgGreaterThanOrEqualTo(Double value) {
            addCriterion("mg >=", value, "mg");
            return (Criteria) this;
        }

        public Criteria andMgLessThan(Double value) {
            addCriterion("mg <", value, "mg");
            return (Criteria) this;
        }

        public Criteria andMgLessThanOrEqualTo(Double value) {
            addCriterion("mg <=", value, "mg");
            return (Criteria) this;
        }

        public Criteria andMgIn(List<Double> values) {
            addCriterion("mg in", values, "mg");
            return (Criteria) this;
        }

        public Criteria andMgNotIn(List<Double> values) {
            addCriterion("mg not in", values, "mg");
            return (Criteria) this;
        }

        public Criteria andMgBetween(Double value1, Double value2) {
            addCriterion("mg between", value1, value2, "mg");
            return (Criteria) this;
        }

        public Criteria andMgNotBetween(Double value1, Double value2) {
            addCriterion("mg not between", value1, value2, "mg");
            return (Criteria) this;
        }

        public Criteria andFeIsNull() {
            addCriterion("fe is null");
            return (Criteria) this;
        }

        public Criteria andFeIsNotNull() {
            addCriterion("fe is not null");
            return (Criteria) this;
        }

        public Criteria andFeEqualTo(Double value) {
            addCriterion("fe =", value, "fe");
            return (Criteria) this;
        }

        public Criteria andFeNotEqualTo(Double value) {
            addCriterion("fe <>", value, "fe");
            return (Criteria) this;
        }

        public Criteria andFeGreaterThan(Double value) {
            addCriterion("fe >", value, "fe");
            return (Criteria) this;
        }

        public Criteria andFeGreaterThanOrEqualTo(Double value) {
            addCriterion("fe >=", value, "fe");
            return (Criteria) this;
        }

        public Criteria andFeLessThan(Double value) {
            addCriterion("fe <", value, "fe");
            return (Criteria) this;
        }

        public Criteria andFeLessThanOrEqualTo(Double value) {
            addCriterion("fe <=", value, "fe");
            return (Criteria) this;
        }

        public Criteria andFeIn(List<Double> values) {
            addCriterion("fe in", values, "fe");
            return (Criteria) this;
        }

        public Criteria andFeNotIn(List<Double> values) {
            addCriterion("fe not in", values, "fe");
            return (Criteria) this;
        }

        public Criteria andFeBetween(Double value1, Double value2) {
            addCriterion("fe between", value1, value2, "fe");
            return (Criteria) this;
        }

        public Criteria andFeNotBetween(Double value1, Double value2) {
            addCriterion("fe not between", value1, value2, "fe");
            return (Criteria) this;
        }

        public Criteria andZnIsNull() {
            addCriterion("zn is null");
            return (Criteria) this;
        }

        public Criteria andZnIsNotNull() {
            addCriterion("zn is not null");
            return (Criteria) this;
        }

        public Criteria andZnEqualTo(Double value) {
            addCriterion("zn =", value, "zn");
            return (Criteria) this;
        }

        public Criteria andZnNotEqualTo(Double value) {
            addCriterion("zn <>", value, "zn");
            return (Criteria) this;
        }

        public Criteria andZnGreaterThan(Double value) {
            addCriterion("zn >", value, "zn");
            return (Criteria) this;
        }

        public Criteria andZnGreaterThanOrEqualTo(Double value) {
            addCriterion("zn >=", value, "zn");
            return (Criteria) this;
        }

        public Criteria andZnLessThan(Double value) {
            addCriterion("zn <", value, "zn");
            return (Criteria) this;
        }

        public Criteria andZnLessThanOrEqualTo(Double value) {
            addCriterion("zn <=", value, "zn");
            return (Criteria) this;
        }

        public Criteria andZnIn(List<Double> values) {
            addCriterion("zn in", values, "zn");
            return (Criteria) this;
        }

        public Criteria andZnNotIn(List<Double> values) {
            addCriterion("zn not in", values, "zn");
            return (Criteria) this;
        }

        public Criteria andZnBetween(Double value1, Double value2) {
            addCriterion("zn between", value1, value2, "zn");
            return (Criteria) this;
        }

        public Criteria andZnNotBetween(Double value1, Double value2) {
            addCriterion("zn not between", value1, value2, "zn");
            return (Criteria) this;
        }

        public Criteria andSeIsNull() {
            addCriterion("se is null");
            return (Criteria) this;
        }

        public Criteria andSeIsNotNull() {
            addCriterion("se is not null");
            return (Criteria) this;
        }

        public Criteria andSeEqualTo(Double value) {
            addCriterion("se =", value, "se");
            return (Criteria) this;
        }

        public Criteria andSeNotEqualTo(Double value) {
            addCriterion("se <>", value, "se");
            return (Criteria) this;
        }

        public Criteria andSeGreaterThan(Double value) {
            addCriterion("se >", value, "se");
            return (Criteria) this;
        }

        public Criteria andSeGreaterThanOrEqualTo(Double value) {
            addCriterion("se >=", value, "se");
            return (Criteria) this;
        }

        public Criteria andSeLessThan(Double value) {
            addCriterion("se <", value, "se");
            return (Criteria) this;
        }

        public Criteria andSeLessThanOrEqualTo(Double value) {
            addCriterion("se <=", value, "se");
            return (Criteria) this;
        }

        public Criteria andSeIn(List<Double> values) {
            addCriterion("se in", values, "se");
            return (Criteria) this;
        }

        public Criteria andSeNotIn(List<Double> values) {
            addCriterion("se not in", values, "se");
            return (Criteria) this;
        }

        public Criteria andSeBetween(Double value1, Double value2) {
            addCriterion("se between", value1, value2, "se");
            return (Criteria) this;
        }

        public Criteria andSeNotBetween(Double value1, Double value2) {
            addCriterion("se not between", value1, value2, "se");
            return (Criteria) this;
        }

        public Criteria andCuIsNull() {
            addCriterion("cu is null");
            return (Criteria) this;
        }

        public Criteria andCuIsNotNull() {
            addCriterion("cu is not null");
            return (Criteria) this;
        }

        public Criteria andCuEqualTo(Double value) {
            addCriterion("cu =", value, "cu");
            return (Criteria) this;
        }

        public Criteria andCuNotEqualTo(Double value) {
            addCriterion("cu <>", value, "cu");
            return (Criteria) this;
        }

        public Criteria andCuGreaterThan(Double value) {
            addCriterion("cu >", value, "cu");
            return (Criteria) this;
        }

        public Criteria andCuGreaterThanOrEqualTo(Double value) {
            addCriterion("cu >=", value, "cu");
            return (Criteria) this;
        }

        public Criteria andCuLessThan(Double value) {
            addCriterion("cu <", value, "cu");
            return (Criteria) this;
        }

        public Criteria andCuLessThanOrEqualTo(Double value) {
            addCriterion("cu <=", value, "cu");
            return (Criteria) this;
        }

        public Criteria andCuIn(List<Double> values) {
            addCriterion("cu in", values, "cu");
            return (Criteria) this;
        }

        public Criteria andCuNotIn(List<Double> values) {
            addCriterion("cu not in", values, "cu");
            return (Criteria) this;
        }

        public Criteria andCuBetween(Double value1, Double value2) {
            addCriterion("cu between", value1, value2, "cu");
            return (Criteria) this;
        }

        public Criteria andCuNotBetween(Double value1, Double value2) {
            addCriterion("cu not between", value1, value2, "cu");
            return (Criteria) this;
        }

        public Criteria andNaIsNull() {
            addCriterion("na is null");
            return (Criteria) this;
        }

        public Criteria andNaIsNotNull() {
            addCriterion("na is not null");
            return (Criteria) this;
        }

        public Criteria andNaEqualTo(Double value) {
            addCriterion("na =", value, "na");
            return (Criteria) this;
        }

        public Criteria andNaNotEqualTo(Double value) {
            addCriterion("na <>", value, "na");
            return (Criteria) this;
        }

        public Criteria andNaGreaterThan(Double value) {
            addCriterion("na >", value, "na");
            return (Criteria) this;
        }

        public Criteria andNaGreaterThanOrEqualTo(Double value) {
            addCriterion("na >=", value, "na");
            return (Criteria) this;
        }

        public Criteria andNaLessThan(Double value) {
            addCriterion("na <", value, "na");
            return (Criteria) this;
        }

        public Criteria andNaLessThanOrEqualTo(Double value) {
            addCriterion("na <=", value, "na");
            return (Criteria) this;
        }

        public Criteria andNaIn(List<Double> values) {
            addCriterion("na in", values, "na");
            return (Criteria) this;
        }

        public Criteria andNaNotIn(List<Double> values) {
            addCriterion("na not in", values, "na");
            return (Criteria) this;
        }

        public Criteria andNaBetween(Double value1, Double value2) {
            addCriterion("na between", value1, value2, "na");
            return (Criteria) this;
        }

        public Criteria andNaNotBetween(Double value1, Double value2) {
            addCriterion("na not between", value1, value2, "na");
            return (Criteria) this;
        }

        public Criteria andMnIsNull() {
            addCriterion("mn is null");
            return (Criteria) this;
        }

        public Criteria andMnIsNotNull() {
            addCriterion("mn is not null");
            return (Criteria) this;
        }

        public Criteria andMnEqualTo(Double value) {
            addCriterion("mn =", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnNotEqualTo(Double value) {
            addCriterion("mn <>", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnGreaterThan(Double value) {
            addCriterion("mn >", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnGreaterThanOrEqualTo(Double value) {
            addCriterion("mn >=", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnLessThan(Double value) {
            addCriterion("mn <", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnLessThanOrEqualTo(Double value) {
            addCriterion("mn <=", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnIn(List<Double> values) {
            addCriterion("mn in", values, "mn");
            return (Criteria) this;
        }

        public Criteria andMnNotIn(List<Double> values) {
            addCriterion("mn not in", values, "mn");
            return (Criteria) this;
        }

        public Criteria andMnBetween(Double value1, Double value2) {
            addCriterion("mn between", value1, value2, "mn");
            return (Criteria) this;
        }

        public Criteria andMnNotBetween(Double value1, Double value2) {
            addCriterion("mn not between", value1, value2, "mn");
            return (Criteria) this;
        }

        public Criteria andVitaminAIsNull() {
            addCriterion("vitamin_a is null");
            return (Criteria) this;
        }

        public Criteria andVitaminAIsNotNull() {
            addCriterion("vitamin_a is not null");
            return (Criteria) this;
        }

        public Criteria andVitaminAEqualTo(Double value) {
            addCriterion("vitamin_a =", value, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminANotEqualTo(Double value) {
            addCriterion("vitamin_a <>", value, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminAGreaterThan(Double value) {
            addCriterion("vitamin_a >", value, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminAGreaterThanOrEqualTo(Double value) {
            addCriterion("vitamin_a >=", value, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminALessThan(Double value) {
            addCriterion("vitamin_a <", value, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminALessThanOrEqualTo(Double value) {
            addCriterion("vitamin_a <=", value, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminAIn(List<Double> values) {
            addCriterion("vitamin_a in", values, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminANotIn(List<Double> values) {
            addCriterion("vitamin_a not in", values, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminABetween(Double value1, Double value2) {
            addCriterion("vitamin_a between", value1, value2, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminANotBetween(Double value1, Double value2) {
            addCriterion("vitamin_a not between", value1, value2, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminB1IsNull() {
            addCriterion("vitamin_b1 is null");
            return (Criteria) this;
        }

        public Criteria andVitaminB1IsNotNull() {
            addCriterion("vitamin_b1 is not null");
            return (Criteria) this;
        }

        public Criteria andVitaminB1EqualTo(Double value) {
            addCriterion("vitamin_b1 =", value, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB1NotEqualTo(Double value) {
            addCriterion("vitamin_b1 <>", value, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB1GreaterThan(Double value) {
            addCriterion("vitamin_b1 >", value, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB1GreaterThanOrEqualTo(Double value) {
            addCriterion("vitamin_b1 >=", value, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB1LessThan(Double value) {
            addCriterion("vitamin_b1 <", value, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB1LessThanOrEqualTo(Double value) {
            addCriterion("vitamin_b1 <=", value, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB1In(List<Double> values) {
            addCriterion("vitamin_b1 in", values, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB1NotIn(List<Double> values) {
            addCriterion("vitamin_b1 not in", values, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB1Between(Double value1, Double value2) {
            addCriterion("vitamin_b1 between", value1, value2, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB1NotBetween(Double value1, Double value2) {
            addCriterion("vitamin_b1 not between", value1, value2, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB2IsNull() {
            addCriterion("vitamin_b2 is null");
            return (Criteria) this;
        }

        public Criteria andVitaminB2IsNotNull() {
            addCriterion("vitamin_b2 is not null");
            return (Criteria) this;
        }

        public Criteria andVitaminB2EqualTo(Double value) {
            addCriterion("vitamin_b2 =", value, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andVitaminB2NotEqualTo(Double value) {
            addCriterion("vitamin_b2 <>", value, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andVitaminB2GreaterThan(Double value) {
            addCriterion("vitamin_b2 >", value, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andVitaminB2GreaterThanOrEqualTo(Double value) {
            addCriterion("vitamin_b2 >=", value, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andVitaminB2LessThan(Double value) {
            addCriterion("vitamin_b2 <", value, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andVitaminB2LessThanOrEqualTo(Double value) {
            addCriterion("vitamin_b2 <=", value, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andVitaminB2In(List<Double> values) {
            addCriterion("vitamin_b2 in", values, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andVitaminB2NotIn(List<Double> values) {
            addCriterion("vitamin_b2 not in", values, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andVitaminB2Between(Double value1, Double value2) {
            addCriterion("vitamin_b2 between", value1, value2, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andVitaminB2NotBetween(Double value1, Double value2) {
            addCriterion("vitamin_b2 not between", value1, value2, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andVitaminB3IsNull() {
            addCriterion("vitamin_b3 is null");
            return (Criteria) this;
        }

        public Criteria andVitaminB3IsNotNull() {
            addCriterion("vitamin_b3 is not null");
            return (Criteria) this;
        }

        public Criteria andVitaminB3EqualTo(Double value) {
            addCriterion("vitamin_b3 =", value, "vitaminB3");
            return (Criteria) this;
        }

        public Criteria andVitaminB3NotEqualTo(Double value) {
            addCriterion("vitamin_b3 <>", value, "vitaminB3");
            return (Criteria) this;
        }

        public Criteria andVitaminB3GreaterThan(Double value) {
            addCriterion("vitamin_b3 >", value, "vitaminB3");
            return (Criteria) this;
        }

        public Criteria andVitaminB3GreaterThanOrEqualTo(Double value) {
            addCriterion("vitamin_b3 >=", value, "vitaminB3");
            return (Criteria) this;
        }

        public Criteria andVitaminB3LessThan(Double value) {
            addCriterion("vitamin_b3 <", value, "vitaminB3");
            return (Criteria) this;
        }

        public Criteria andVitaminB3LessThanOrEqualTo(Double value) {
            addCriterion("vitamin_b3 <=", value, "vitaminB3");
            return (Criteria) this;
        }

        public Criteria andVitaminB3In(List<Double> values) {
            addCriterion("vitamin_b3 in", values, "vitaminB3");
            return (Criteria) this;
        }

        public Criteria andVitaminB3NotIn(List<Double> values) {
            addCriterion("vitamin_b3 not in", values, "vitaminB3");
            return (Criteria) this;
        }

        public Criteria andVitaminB3Between(Double value1, Double value2) {
            addCriterion("vitamin_b3 between", value1, value2, "vitaminB3");
            return (Criteria) this;
        }

        public Criteria andVitaminB3NotBetween(Double value1, Double value2) {
            addCriterion("vitamin_b3 not between", value1, value2, "vitaminB3");
            return (Criteria) this;
        }

        public Criteria andVitaminCIsNull() {
            addCriterion("vitamin_c is null");
            return (Criteria) this;
        }

        public Criteria andVitaminCIsNotNull() {
            addCriterion("vitamin_c is not null");
            return (Criteria) this;
        }

        public Criteria andVitaminCEqualTo(Double value) {
            addCriterion("vitamin_c =", value, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andVitaminCNotEqualTo(Double value) {
            addCriterion("vitamin_c <>", value, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andVitaminCGreaterThan(Double value) {
            addCriterion("vitamin_c >", value, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andVitaminCGreaterThanOrEqualTo(Double value) {
            addCriterion("vitamin_c >=", value, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andVitaminCLessThan(Double value) {
            addCriterion("vitamin_c <", value, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andVitaminCLessThanOrEqualTo(Double value) {
            addCriterion("vitamin_c <=", value, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andVitaminCIn(List<Double> values) {
            addCriterion("vitamin_c in", values, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andVitaminCNotIn(List<Double> values) {
            addCriterion("vitamin_c not in", values, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andVitaminCBetween(Double value1, Double value2) {
            addCriterion("vitamin_c between", value1, value2, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andVitaminCNotBetween(Double value1, Double value2) {
            addCriterion("vitamin_c not between", value1, value2, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andVitaminEIsNull() {
            addCriterion("vitamin_e is null");
            return (Criteria) this;
        }

        public Criteria andVitaminEIsNotNull() {
            addCriterion("vitamin_e is not null");
            return (Criteria) this;
        }

        public Criteria andVitaminEEqualTo(Double value) {
            addCriterion("vitamin_e =", value, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andVitaminENotEqualTo(Double value) {
            addCriterion("vitamin_e <>", value, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andVitaminEGreaterThan(Double value) {
            addCriterion("vitamin_e >", value, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andVitaminEGreaterThanOrEqualTo(Double value) {
            addCriterion("vitamin_e >=", value, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andVitaminELessThan(Double value) {
            addCriterion("vitamin_e <", value, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andVitaminELessThanOrEqualTo(Double value) {
            addCriterion("vitamin_e <=", value, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andVitaminEIn(List<Double> values) {
            addCriterion("vitamin_e in", values, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andVitaminENotIn(List<Double> values) {
            addCriterion("vitamin_e not in", values, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andVitaminEBetween(Double value1, Double value2) {
            addCriterion("vitamin_e between", value1, value2, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andVitaminENotBetween(Double value1, Double value2) {
            addCriterion("vitamin_e not between", value1, value2, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andSolubleFiberIsNull() {
            addCriterion("soluble_fiber is null");
            return (Criteria) this;
        }

        public Criteria andSolubleFiberIsNotNull() {
            addCriterion("soluble_fiber is not null");
            return (Criteria) this;
        }

        public Criteria andSolubleFiberEqualTo(Double value) {
            addCriterion("soluble_fiber =", value, "solubleFiber");
            return (Criteria) this;
        }

        public Criteria andSolubleFiberNotEqualTo(Double value) {
            addCriterion("soluble_fiber <>", value, "solubleFiber");
            return (Criteria) this;
        }

        public Criteria andSolubleFiberGreaterThan(Double value) {
            addCriterion("soluble_fiber >", value, "solubleFiber");
            return (Criteria) this;
        }

        public Criteria andSolubleFiberGreaterThanOrEqualTo(Double value) {
            addCriterion("soluble_fiber >=", value, "solubleFiber");
            return (Criteria) this;
        }

        public Criteria andSolubleFiberLessThan(Double value) {
            addCriterion("soluble_fiber <", value, "solubleFiber");
            return (Criteria) this;
        }

        public Criteria andSolubleFiberLessThanOrEqualTo(Double value) {
            addCriterion("soluble_fiber <=", value, "solubleFiber");
            return (Criteria) this;
        }

        public Criteria andSolubleFiberIn(List<Double> values) {
            addCriterion("soluble_fiber in", values, "solubleFiber");
            return (Criteria) this;
        }

        public Criteria andSolubleFiberNotIn(List<Double> values) {
            addCriterion("soluble_fiber not in", values, "solubleFiber");
            return (Criteria) this;
        }

        public Criteria andSolubleFiberBetween(Double value1, Double value2) {
            addCriterion("soluble_fiber between", value1, value2, "solubleFiber");
            return (Criteria) this;
        }

        public Criteria andSolubleFiberNotBetween(Double value1, Double value2) {
            addCriterion("soluble_fiber not between", value1, value2, "solubleFiber");
            return (Criteria) this;
        }

        public Criteria andInsolubleFiberIsNull() {
            addCriterion("insoluble_fiber is null");
            return (Criteria) this;
        }

        public Criteria andInsolubleFiberIsNotNull() {
            addCriterion("insoluble_fiber is not null");
            return (Criteria) this;
        }

        public Criteria andInsolubleFiberEqualTo(Double value) {
            addCriterion("insoluble_fiber =", value, "insolubleFiber");
            return (Criteria) this;
        }

        public Criteria andInsolubleFiberNotEqualTo(Double value) {
            addCriterion("insoluble_fiber <>", value, "insolubleFiber");
            return (Criteria) this;
        }

        public Criteria andInsolubleFiberGreaterThan(Double value) {
            addCriterion("insoluble_fiber >", value, "insolubleFiber");
            return (Criteria) this;
        }

        public Criteria andInsolubleFiberGreaterThanOrEqualTo(Double value) {
            addCriterion("insoluble_fiber >=", value, "insolubleFiber");
            return (Criteria) this;
        }

        public Criteria andInsolubleFiberLessThan(Double value) {
            addCriterion("insoluble_fiber <", value, "insolubleFiber");
            return (Criteria) this;
        }

        public Criteria andInsolubleFiberLessThanOrEqualTo(Double value) {
            addCriterion("insoluble_fiber <=", value, "insolubleFiber");
            return (Criteria) this;
        }

        public Criteria andInsolubleFiberIn(List<Double> values) {
            addCriterion("insoluble_fiber in", values, "insolubleFiber");
            return (Criteria) this;
        }

        public Criteria andInsolubleFiberNotIn(List<Double> values) {
            addCriterion("insoluble_fiber not in", values, "insolubleFiber");
            return (Criteria) this;
        }

        public Criteria andInsolubleFiberBetween(Double value1, Double value2) {
            addCriterion("insoluble_fiber between", value1, value2, "insolubleFiber");
            return (Criteria) this;
        }

        public Criteria andInsolubleFiberNotBetween(Double value1, Double value2) {
            addCriterion("insoluble_fiber not between", value1, value2, "insolubleFiber");
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