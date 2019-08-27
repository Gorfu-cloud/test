package com.bkit.fatdown.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbDietDailyReportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbDietDailyReportExample() {
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

        public Criteria andRealEnergyIsNull() {
            addCriterion("real_energy is null");
            return (Criteria) this;
        }

        public Criteria andRealEnergyIsNotNull() {
            addCriterion("real_energy is not null");
            return (Criteria) this;
        }

        public Criteria andRealEnergyEqualTo(Double value) {
            addCriterion("real_energy =", value, "realEnergy");
            return (Criteria) this;
        }

        public Criteria andRealEnergyNotEqualTo(Double value) {
            addCriterion("real_energy <>", value, "realEnergy");
            return (Criteria) this;
        }

        public Criteria andRealEnergyGreaterThan(Double value) {
            addCriterion("real_energy >", value, "realEnergy");
            return (Criteria) this;
        }

        public Criteria andRealEnergyGreaterThanOrEqualTo(Double value) {
            addCriterion("real_energy >=", value, "realEnergy");
            return (Criteria) this;
        }

        public Criteria andRealEnergyLessThan(Double value) {
            addCriterion("real_energy <", value, "realEnergy");
            return (Criteria) this;
        }

        public Criteria andRealEnergyLessThanOrEqualTo(Double value) {
            addCriterion("real_energy <=", value, "realEnergy");
            return (Criteria) this;
        }

        public Criteria andRealEnergyIn(List<Double> values) {
            addCriterion("real_energy in", values, "realEnergy");
            return (Criteria) this;
        }

        public Criteria andRealEnergyNotIn(List<Double> values) {
            addCriterion("real_energy not in", values, "realEnergy");
            return (Criteria) this;
        }

        public Criteria andRealEnergyBetween(Double value1, Double value2) {
            addCriterion("real_energy between", value1, value2, "realEnergy");
            return (Criteria) this;
        }

        public Criteria andRealEnergyNotBetween(Double value1, Double value2) {
            addCriterion("real_energy not between", value1, value2, "realEnergy");
            return (Criteria) this;
        }

        public Criteria andLowerEnergyIsNull() {
            addCriterion("lower_energy is null");
            return (Criteria) this;
        }

        public Criteria andLowerEnergyIsNotNull() {
            addCriterion("lower_energy is not null");
            return (Criteria) this;
        }

        public Criteria andLowerEnergyEqualTo(Double value) {
            addCriterion("lower_energy =", value, "lowerEnergy");
            return (Criteria) this;
        }

        public Criteria andLowerEnergyNotEqualTo(Double value) {
            addCriterion("lower_energy <>", value, "lowerEnergy");
            return (Criteria) this;
        }

        public Criteria andLowerEnergyGreaterThan(Double value) {
            addCriterion("lower_energy >", value, "lowerEnergy");
            return (Criteria) this;
        }

        public Criteria andLowerEnergyGreaterThanOrEqualTo(Double value) {
            addCriterion("lower_energy >=", value, "lowerEnergy");
            return (Criteria) this;
        }

        public Criteria andLowerEnergyLessThan(Double value) {
            addCriterion("lower_energy <", value, "lowerEnergy");
            return (Criteria) this;
        }

        public Criteria andLowerEnergyLessThanOrEqualTo(Double value) {
            addCriterion("lower_energy <=", value, "lowerEnergy");
            return (Criteria) this;
        }

        public Criteria andLowerEnergyIn(List<Double> values) {
            addCriterion("lower_energy in", values, "lowerEnergy");
            return (Criteria) this;
        }

        public Criteria andLowerEnergyNotIn(List<Double> values) {
            addCriterion("lower_energy not in", values, "lowerEnergy");
            return (Criteria) this;
        }

        public Criteria andLowerEnergyBetween(Double value1, Double value2) {
            addCriterion("lower_energy between", value1, value2, "lowerEnergy");
            return (Criteria) this;
        }

        public Criteria andLowerEnergyNotBetween(Double value1, Double value2) {
            addCriterion("lower_energy not between", value1, value2, "lowerEnergy");
            return (Criteria) this;
        }

        public Criteria andUpperEnergyIsNull() {
            addCriterion("upper_energy is null");
            return (Criteria) this;
        }

        public Criteria andUpperEnergyIsNotNull() {
            addCriterion("upper_energy is not null");
            return (Criteria) this;
        }

        public Criteria andUpperEnergyEqualTo(Double value) {
            addCriterion("upper_energy =", value, "upperEnergy");
            return (Criteria) this;
        }

        public Criteria andUpperEnergyNotEqualTo(Double value) {
            addCriterion("upper_energy <>", value, "upperEnergy");
            return (Criteria) this;
        }

        public Criteria andUpperEnergyGreaterThan(Double value) {
            addCriterion("upper_energy >", value, "upperEnergy");
            return (Criteria) this;
        }

        public Criteria andUpperEnergyGreaterThanOrEqualTo(Double value) {
            addCriterion("upper_energy >=", value, "upperEnergy");
            return (Criteria) this;
        }

        public Criteria andUpperEnergyLessThan(Double value) {
            addCriterion("upper_energy <", value, "upperEnergy");
            return (Criteria) this;
        }

        public Criteria andUpperEnergyLessThanOrEqualTo(Double value) {
            addCriterion("upper_energy <=", value, "upperEnergy");
            return (Criteria) this;
        }

        public Criteria andUpperEnergyIn(List<Double> values) {
            addCriterion("upper_energy in", values, "upperEnergy");
            return (Criteria) this;
        }

        public Criteria andUpperEnergyNotIn(List<Double> values) {
            addCriterion("upper_energy not in", values, "upperEnergy");
            return (Criteria) this;
        }

        public Criteria andUpperEnergyBetween(Double value1, Double value2) {
            addCriterion("upper_energy between", value1, value2, "upperEnergy");
            return (Criteria) this;
        }

        public Criteria andUpperEnergyNotBetween(Double value1, Double value2) {
            addCriterion("upper_energy not between", value1, value2, "upperEnergy");
            return (Criteria) this;
        }

        public Criteria andEnergyEvaluationIsNull() {
            addCriterion("energy_evaluation is null");
            return (Criteria) this;
        }

        public Criteria andEnergyEvaluationIsNotNull() {
            addCriterion("energy_evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyEvaluationEqualTo(Integer value) {
            addCriterion("energy_evaluation =", value, "energyEvaluation");
            return (Criteria) this;
        }

        public Criteria andEnergyEvaluationNotEqualTo(Integer value) {
            addCriterion("energy_evaluation <>", value, "energyEvaluation");
            return (Criteria) this;
        }

        public Criteria andEnergyEvaluationGreaterThan(Integer value) {
            addCriterion("energy_evaluation >", value, "energyEvaluation");
            return (Criteria) this;
        }

        public Criteria andEnergyEvaluationGreaterThanOrEqualTo(Integer value) {
            addCriterion("energy_evaluation >=", value, "energyEvaluation");
            return (Criteria) this;
        }

        public Criteria andEnergyEvaluationLessThan(Integer value) {
            addCriterion("energy_evaluation <", value, "energyEvaluation");
            return (Criteria) this;
        }

        public Criteria andEnergyEvaluationLessThanOrEqualTo(Integer value) {
            addCriterion("energy_evaluation <=", value, "energyEvaluation");
            return (Criteria) this;
        }

        public Criteria andEnergyEvaluationIn(List<Integer> values) {
            addCriterion("energy_evaluation in", values, "energyEvaluation");
            return (Criteria) this;
        }

        public Criteria andEnergyEvaluationNotIn(List<Integer> values) {
            addCriterion("energy_evaluation not in", values, "energyEvaluation");
            return (Criteria) this;
        }

        public Criteria andEnergyEvaluationBetween(Integer value1, Integer value2) {
            addCriterion("energy_evaluation between", value1, value2, "energyEvaluation");
            return (Criteria) this;
        }

        public Criteria andEnergyEvaluationNotBetween(Integer value1, Integer value2) {
            addCriterion("energy_evaluation not between", value1, value2, "energyEvaluation");
            return (Criteria) this;
        }

        public Criteria andStructureEvaluationIsNull() {
            addCriterion("structure_evaluation is null");
            return (Criteria) this;
        }

        public Criteria andStructureEvaluationIsNotNull() {
            addCriterion("structure_evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andStructureEvaluationEqualTo(Integer value) {
            addCriterion("structure_evaluation =", value, "structureEvaluation");
            return (Criteria) this;
        }

        public Criteria andStructureEvaluationNotEqualTo(Integer value) {
            addCriterion("structure_evaluation <>", value, "structureEvaluation");
            return (Criteria) this;
        }

        public Criteria andStructureEvaluationGreaterThan(Integer value) {
            addCriterion("structure_evaluation >", value, "structureEvaluation");
            return (Criteria) this;
        }

        public Criteria andStructureEvaluationGreaterThanOrEqualTo(Integer value) {
            addCriterion("structure_evaluation >=", value, "structureEvaluation");
            return (Criteria) this;
        }

        public Criteria andStructureEvaluationLessThan(Integer value) {
            addCriterion("structure_evaluation <", value, "structureEvaluation");
            return (Criteria) this;
        }

        public Criteria andStructureEvaluationLessThanOrEqualTo(Integer value) {
            addCriterion("structure_evaluation <=", value, "structureEvaluation");
            return (Criteria) this;
        }

        public Criteria andStructureEvaluationIn(List<Integer> values) {
            addCriterion("structure_evaluation in", values, "structureEvaluation");
            return (Criteria) this;
        }

        public Criteria andStructureEvaluationNotIn(List<Integer> values) {
            addCriterion("structure_evaluation not in", values, "structureEvaluation");
            return (Criteria) this;
        }

        public Criteria andStructureEvaluationBetween(Integer value1, Integer value2) {
            addCriterion("structure_evaluation between", value1, value2, "structureEvaluation");
            return (Criteria) this;
        }

        public Criteria andStructureEvaluationNotBetween(Integer value1, Integer value2) {
            addCriterion("structure_evaluation not between", value1, value2, "structureEvaluation");
            return (Criteria) this;
        }

        public Criteria andStructureLackIsNull() {
            addCriterion("structure_lack is null");
            return (Criteria) this;
        }

        public Criteria andStructureLackIsNotNull() {
            addCriterion("structure_lack is not null");
            return (Criteria) this;
        }

        public Criteria andStructureLackEqualTo(String value) {
            addCriterion("structure_lack =", value, "structureLack");
            return (Criteria) this;
        }

        public Criteria andStructureLackNotEqualTo(String value) {
            addCriterion("structure_lack <>", value, "structureLack");
            return (Criteria) this;
        }

        public Criteria andStructureLackGreaterThan(String value) {
            addCriterion("structure_lack >", value, "structureLack");
            return (Criteria) this;
        }

        public Criteria andStructureLackGreaterThanOrEqualTo(String value) {
            addCriterion("structure_lack >=", value, "structureLack");
            return (Criteria) this;
        }

        public Criteria andStructureLackLessThan(String value) {
            addCriterion("structure_lack <", value, "structureLack");
            return (Criteria) this;
        }

        public Criteria andStructureLackLessThanOrEqualTo(String value) {
            addCriterion("structure_lack <=", value, "structureLack");
            return (Criteria) this;
        }

        public Criteria andStructureLackLike(String value) {
            addCriterion("structure_lack like", value, "structureLack");
            return (Criteria) this;
        }

        public Criteria andStructureLackNotLike(String value) {
            addCriterion("structure_lack not like", value, "structureLack");
            return (Criteria) this;
        }

        public Criteria andStructureLackIn(List<String> values) {
            addCriterion("structure_lack in", values, "structureLack");
            return (Criteria) this;
        }

        public Criteria andStructureLackNotIn(List<String> values) {
            addCriterion("structure_lack not in", values, "structureLack");
            return (Criteria) this;
        }

        public Criteria andStructureLackBetween(String value1, String value2) {
            addCriterion("structure_lack between", value1, value2, "structureLack");
            return (Criteria) this;
        }

        public Criteria andStructureLackNotBetween(String value1, String value2) {
            addCriterion("structure_lack not between", value1, value2, "structureLack");
            return (Criteria) this;
        }

        public Criteria andProteinPerIsNull() {
            addCriterion("protein_per is null");
            return (Criteria) this;
        }

        public Criteria andProteinPerIsNotNull() {
            addCriterion("protein_per is not null");
            return (Criteria) this;
        }

        public Criteria andProteinPerEqualTo(Double value) {
            addCriterion("protein_per =", value, "proteinPer");
            return (Criteria) this;
        }

        public Criteria andProteinPerNotEqualTo(Double value) {
            addCriterion("protein_per <>", value, "proteinPer");
            return (Criteria) this;
        }

        public Criteria andProteinPerGreaterThan(Double value) {
            addCriterion("protein_per >", value, "proteinPer");
            return (Criteria) this;
        }

        public Criteria andProteinPerGreaterThanOrEqualTo(Double value) {
            addCriterion("protein_per >=", value, "proteinPer");
            return (Criteria) this;
        }

        public Criteria andProteinPerLessThan(Double value) {
            addCriterion("protein_per <", value, "proteinPer");
            return (Criteria) this;
        }

        public Criteria andProteinPerLessThanOrEqualTo(Double value) {
            addCriterion("protein_per <=", value, "proteinPer");
            return (Criteria) this;
        }

        public Criteria andProteinPerIn(List<Double> values) {
            addCriterion("protein_per in", values, "proteinPer");
            return (Criteria) this;
        }

        public Criteria andProteinPerNotIn(List<Double> values) {
            addCriterion("protein_per not in", values, "proteinPer");
            return (Criteria) this;
        }

        public Criteria andProteinPerBetween(Double value1, Double value2) {
            addCriterion("protein_per between", value1, value2, "proteinPer");
            return (Criteria) this;
        }

        public Criteria andProteinPerNotBetween(Double value1, Double value2) {
            addCriterion("protein_per not between", value1, value2, "proteinPer");
            return (Criteria) this;
        }

        public Criteria andProteinLackIsNull() {
            addCriterion("protein_lack is null");
            return (Criteria) this;
        }

        public Criteria andProteinLackIsNotNull() {
            addCriterion("protein_lack is not null");
            return (Criteria) this;
        }

        public Criteria andProteinLackEqualTo(Double value) {
            addCriterion("protein_lack =", value, "proteinLack");
            return (Criteria) this;
        }

        public Criteria andProteinLackNotEqualTo(Double value) {
            addCriterion("protein_lack <>", value, "proteinLack");
            return (Criteria) this;
        }

        public Criteria andProteinLackGreaterThan(Double value) {
            addCriterion("protein_lack >", value, "proteinLack");
            return (Criteria) this;
        }

        public Criteria andProteinLackGreaterThanOrEqualTo(Double value) {
            addCriterion("protein_lack >=", value, "proteinLack");
            return (Criteria) this;
        }

        public Criteria andProteinLackLessThan(Double value) {
            addCriterion("protein_lack <", value, "proteinLack");
            return (Criteria) this;
        }

        public Criteria andProteinLackLessThanOrEqualTo(Double value) {
            addCriterion("protein_lack <=", value, "proteinLack");
            return (Criteria) this;
        }

        public Criteria andProteinLackIn(List<Double> values) {
            addCriterion("protein_lack in", values, "proteinLack");
            return (Criteria) this;
        }

        public Criteria andProteinLackNotIn(List<Double> values) {
            addCriterion("protein_lack not in", values, "proteinLack");
            return (Criteria) this;
        }

        public Criteria andProteinLackBetween(Double value1, Double value2) {
            addCriterion("protein_lack between", value1, value2, "proteinLack");
            return (Criteria) this;
        }

        public Criteria andProteinLackNotBetween(Double value1, Double value2) {
            addCriterion("protein_lack not between", value1, value2, "proteinLack");
            return (Criteria) this;
        }

        public Criteria andProteinEvaluationIsNull() {
            addCriterion("protein_evaluation is null");
            return (Criteria) this;
        }

        public Criteria andProteinEvaluationIsNotNull() {
            addCriterion("protein_evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andProteinEvaluationEqualTo(Integer value) {
            addCriterion("protein_evaluation =", value, "proteinEvaluation");
            return (Criteria) this;
        }

        public Criteria andProteinEvaluationNotEqualTo(Integer value) {
            addCriterion("protein_evaluation <>", value, "proteinEvaluation");
            return (Criteria) this;
        }

        public Criteria andProteinEvaluationGreaterThan(Integer value) {
            addCriterion("protein_evaluation >", value, "proteinEvaluation");
            return (Criteria) this;
        }

        public Criteria andProteinEvaluationGreaterThanOrEqualTo(Integer value) {
            addCriterion("protein_evaluation >=", value, "proteinEvaluation");
            return (Criteria) this;
        }

        public Criteria andProteinEvaluationLessThan(Integer value) {
            addCriterion("protein_evaluation <", value, "proteinEvaluation");
            return (Criteria) this;
        }

        public Criteria andProteinEvaluationLessThanOrEqualTo(Integer value) {
            addCriterion("protein_evaluation <=", value, "proteinEvaluation");
            return (Criteria) this;
        }

        public Criteria andProteinEvaluationIn(List<Integer> values) {
            addCriterion("protein_evaluation in", values, "proteinEvaluation");
            return (Criteria) this;
        }

        public Criteria andProteinEvaluationNotIn(List<Integer> values) {
            addCriterion("protein_evaluation not in", values, "proteinEvaluation");
            return (Criteria) this;
        }

        public Criteria andProteinEvaluationBetween(Integer value1, Integer value2) {
            addCriterion("protein_evaluation between", value1, value2, "proteinEvaluation");
            return (Criteria) this;
        }

        public Criteria andProteinEvaluationNotBetween(Integer value1, Integer value2) {
            addCriterion("protein_evaluation not between", value1, value2, "proteinEvaluation");
            return (Criteria) this;
        }

        public Criteria andFatPerIsNull() {
            addCriterion("fat_per is null");
            return (Criteria) this;
        }

        public Criteria andFatPerIsNotNull() {
            addCriterion("fat_per is not null");
            return (Criteria) this;
        }

        public Criteria andFatPerEqualTo(Double value) {
            addCriterion("fat_per =", value, "fatPer");
            return (Criteria) this;
        }

        public Criteria andFatPerNotEqualTo(Double value) {
            addCriterion("fat_per <>", value, "fatPer");
            return (Criteria) this;
        }

        public Criteria andFatPerGreaterThan(Double value) {
            addCriterion("fat_per >", value, "fatPer");
            return (Criteria) this;
        }

        public Criteria andFatPerGreaterThanOrEqualTo(Double value) {
            addCriterion("fat_per >=", value, "fatPer");
            return (Criteria) this;
        }

        public Criteria andFatPerLessThan(Double value) {
            addCriterion("fat_per <", value, "fatPer");
            return (Criteria) this;
        }

        public Criteria andFatPerLessThanOrEqualTo(Double value) {
            addCriterion("fat_per <=", value, "fatPer");
            return (Criteria) this;
        }

        public Criteria andFatPerIn(List<Double> values) {
            addCriterion("fat_per in", values, "fatPer");
            return (Criteria) this;
        }

        public Criteria andFatPerNotIn(List<Double> values) {
            addCriterion("fat_per not in", values, "fatPer");
            return (Criteria) this;
        }

        public Criteria andFatPerBetween(Double value1, Double value2) {
            addCriterion("fat_per between", value1, value2, "fatPer");
            return (Criteria) this;
        }

        public Criteria andFatPerNotBetween(Double value1, Double value2) {
            addCriterion("fat_per not between", value1, value2, "fatPer");
            return (Criteria) this;
        }

        public Criteria andFatLackIsNull() {
            addCriterion("fat_lack is null");
            return (Criteria) this;
        }

        public Criteria andFatLackIsNotNull() {
            addCriterion("fat_lack is not null");
            return (Criteria) this;
        }

        public Criteria andFatLackEqualTo(Double value) {
            addCriterion("fat_lack =", value, "fatLack");
            return (Criteria) this;
        }

        public Criteria andFatLackNotEqualTo(Double value) {
            addCriterion("fat_lack <>", value, "fatLack");
            return (Criteria) this;
        }

        public Criteria andFatLackGreaterThan(Double value) {
            addCriterion("fat_lack >", value, "fatLack");
            return (Criteria) this;
        }

        public Criteria andFatLackGreaterThanOrEqualTo(Double value) {
            addCriterion("fat_lack >=", value, "fatLack");
            return (Criteria) this;
        }

        public Criteria andFatLackLessThan(Double value) {
            addCriterion("fat_lack <", value, "fatLack");
            return (Criteria) this;
        }

        public Criteria andFatLackLessThanOrEqualTo(Double value) {
            addCriterion("fat_lack <=", value, "fatLack");
            return (Criteria) this;
        }

        public Criteria andFatLackIn(List<Double> values) {
            addCriterion("fat_lack in", values, "fatLack");
            return (Criteria) this;
        }

        public Criteria andFatLackNotIn(List<Double> values) {
            addCriterion("fat_lack not in", values, "fatLack");
            return (Criteria) this;
        }

        public Criteria andFatLackBetween(Double value1, Double value2) {
            addCriterion("fat_lack between", value1, value2, "fatLack");
            return (Criteria) this;
        }

        public Criteria andFatLackNotBetween(Double value1, Double value2) {
            addCriterion("fat_lack not between", value1, value2, "fatLack");
            return (Criteria) this;
        }

        public Criteria andFatEvaluationIsNull() {
            addCriterion("fat_evaluation is null");
            return (Criteria) this;
        }

        public Criteria andFatEvaluationIsNotNull() {
            addCriterion("fat_evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andFatEvaluationEqualTo(Integer value) {
            addCriterion("fat_evaluation =", value, "fatEvaluation");
            return (Criteria) this;
        }

        public Criteria andFatEvaluationNotEqualTo(Integer value) {
            addCriterion("fat_evaluation <>", value, "fatEvaluation");
            return (Criteria) this;
        }

        public Criteria andFatEvaluationGreaterThan(Integer value) {
            addCriterion("fat_evaluation >", value, "fatEvaluation");
            return (Criteria) this;
        }

        public Criteria andFatEvaluationGreaterThanOrEqualTo(Integer value) {
            addCriterion("fat_evaluation >=", value, "fatEvaluation");
            return (Criteria) this;
        }

        public Criteria andFatEvaluationLessThan(Integer value) {
            addCriterion("fat_evaluation <", value, "fatEvaluation");
            return (Criteria) this;
        }

        public Criteria andFatEvaluationLessThanOrEqualTo(Integer value) {
            addCriterion("fat_evaluation <=", value, "fatEvaluation");
            return (Criteria) this;
        }

        public Criteria andFatEvaluationIn(List<Integer> values) {
            addCriterion("fat_evaluation in", values, "fatEvaluation");
            return (Criteria) this;
        }

        public Criteria andFatEvaluationNotIn(List<Integer> values) {
            addCriterion("fat_evaluation not in", values, "fatEvaluation");
            return (Criteria) this;
        }

        public Criteria andFatEvaluationBetween(Integer value1, Integer value2) {
            addCriterion("fat_evaluation between", value1, value2, "fatEvaluation");
            return (Criteria) this;
        }

        public Criteria andFatEvaluationNotBetween(Integer value1, Integer value2) {
            addCriterion("fat_evaluation not between", value1, value2, "fatEvaluation");
            return (Criteria) this;
        }

        public Criteria andColPerIsNull() {
            addCriterion("col_per is null");
            return (Criteria) this;
        }

        public Criteria andColPerIsNotNull() {
            addCriterion("col_per is not null");
            return (Criteria) this;
        }

        public Criteria andColPerEqualTo(Double value) {
            addCriterion("col_per =", value, "colPer");
            return (Criteria) this;
        }

        public Criteria andColPerNotEqualTo(Double value) {
            addCriterion("col_per <>", value, "colPer");
            return (Criteria) this;
        }

        public Criteria andColPerGreaterThan(Double value) {
            addCriterion("col_per >", value, "colPer");
            return (Criteria) this;
        }

        public Criteria andColPerGreaterThanOrEqualTo(Double value) {
            addCriterion("col_per >=", value, "colPer");
            return (Criteria) this;
        }

        public Criteria andColPerLessThan(Double value) {
            addCriterion("col_per <", value, "colPer");
            return (Criteria) this;
        }

        public Criteria andColPerLessThanOrEqualTo(Double value) {
            addCriterion("col_per <=", value, "colPer");
            return (Criteria) this;
        }

        public Criteria andColPerIn(List<Double> values) {
            addCriterion("col_per in", values, "colPer");
            return (Criteria) this;
        }

        public Criteria andColPerNotIn(List<Double> values) {
            addCriterion("col_per not in", values, "colPer");
            return (Criteria) this;
        }

        public Criteria andColPerBetween(Double value1, Double value2) {
            addCriterion("col_per between", value1, value2, "colPer");
            return (Criteria) this;
        }

        public Criteria andColPerNotBetween(Double value1, Double value2) {
            addCriterion("col_per not between", value1, value2, "colPer");
            return (Criteria) this;
        }

        public Criteria andColLackIsNull() {
            addCriterion("col_lack is null");
            return (Criteria) this;
        }

        public Criteria andColLackIsNotNull() {
            addCriterion("col_lack is not null");
            return (Criteria) this;
        }

        public Criteria andColLackEqualTo(Double value) {
            addCriterion("col_lack =", value, "colLack");
            return (Criteria) this;
        }

        public Criteria andColLackNotEqualTo(Double value) {
            addCriterion("col_lack <>", value, "colLack");
            return (Criteria) this;
        }

        public Criteria andColLackGreaterThan(Double value) {
            addCriterion("col_lack >", value, "colLack");
            return (Criteria) this;
        }

        public Criteria andColLackGreaterThanOrEqualTo(Double value) {
            addCriterion("col_lack >=", value, "colLack");
            return (Criteria) this;
        }

        public Criteria andColLackLessThan(Double value) {
            addCriterion("col_lack <", value, "colLack");
            return (Criteria) this;
        }

        public Criteria andColLackLessThanOrEqualTo(Double value) {
            addCriterion("col_lack <=", value, "colLack");
            return (Criteria) this;
        }

        public Criteria andColLackIn(List<Double> values) {
            addCriterion("col_lack in", values, "colLack");
            return (Criteria) this;
        }

        public Criteria andColLackNotIn(List<Double> values) {
            addCriterion("col_lack not in", values, "colLack");
            return (Criteria) this;
        }

        public Criteria andColLackBetween(Double value1, Double value2) {
            addCriterion("col_lack between", value1, value2, "colLack");
            return (Criteria) this;
        }

        public Criteria andColLackNotBetween(Double value1, Double value2) {
            addCriterion("col_lack not between", value1, value2, "colLack");
            return (Criteria) this;
        }

        public Criteria andColEvaluationIsNull() {
            addCriterion("col_evaluation is null");
            return (Criteria) this;
        }

        public Criteria andColEvaluationIsNotNull() {
            addCriterion("col_evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andColEvaluationEqualTo(Integer value) {
            addCriterion("col_evaluation =", value, "colEvaluation");
            return (Criteria) this;
        }

        public Criteria andColEvaluationNotEqualTo(Integer value) {
            addCriterion("col_evaluation <>", value, "colEvaluation");
            return (Criteria) this;
        }

        public Criteria andColEvaluationGreaterThan(Integer value) {
            addCriterion("col_evaluation >", value, "colEvaluation");
            return (Criteria) this;
        }

        public Criteria andColEvaluationGreaterThanOrEqualTo(Integer value) {
            addCriterion("col_evaluation >=", value, "colEvaluation");
            return (Criteria) this;
        }

        public Criteria andColEvaluationLessThan(Integer value) {
            addCriterion("col_evaluation <", value, "colEvaluation");
            return (Criteria) this;
        }

        public Criteria andColEvaluationLessThanOrEqualTo(Integer value) {
            addCriterion("col_evaluation <=", value, "colEvaluation");
            return (Criteria) this;
        }

        public Criteria andColEvaluationIn(List<Integer> values) {
            addCriterion("col_evaluation in", values, "colEvaluation");
            return (Criteria) this;
        }

        public Criteria andColEvaluationNotIn(List<Integer> values) {
            addCriterion("col_evaluation not in", values, "colEvaluation");
            return (Criteria) this;
        }

        public Criteria andColEvaluationBetween(Integer value1, Integer value2) {
            addCriterion("col_evaluation between", value1, value2, "colEvaluation");
            return (Criteria) this;
        }

        public Criteria andColEvaluationNotBetween(Integer value1, Integer value2) {
            addCriterion("col_evaluation not between", value1, value2, "colEvaluation");
            return (Criteria) this;
        }

        public Criteria andFibrinPerIsNull() {
            addCriterion("fibrin_per is null");
            return (Criteria) this;
        }

        public Criteria andFibrinPerIsNotNull() {
            addCriterion("fibrin_per is not null");
            return (Criteria) this;
        }

        public Criteria andFibrinPerEqualTo(Double value) {
            addCriterion("fibrin_per =", value, "fibrinPer");
            return (Criteria) this;
        }

        public Criteria andFibrinPerNotEqualTo(Double value) {
            addCriterion("fibrin_per <>", value, "fibrinPer");
            return (Criteria) this;
        }

        public Criteria andFibrinPerGreaterThan(Double value) {
            addCriterion("fibrin_per >", value, "fibrinPer");
            return (Criteria) this;
        }

        public Criteria andFibrinPerGreaterThanOrEqualTo(Double value) {
            addCriterion("fibrin_per >=", value, "fibrinPer");
            return (Criteria) this;
        }

        public Criteria andFibrinPerLessThan(Double value) {
            addCriterion("fibrin_per <", value, "fibrinPer");
            return (Criteria) this;
        }

        public Criteria andFibrinPerLessThanOrEqualTo(Double value) {
            addCriterion("fibrin_per <=", value, "fibrinPer");
            return (Criteria) this;
        }

        public Criteria andFibrinPerIn(List<Double> values) {
            addCriterion("fibrin_per in", values, "fibrinPer");
            return (Criteria) this;
        }

        public Criteria andFibrinPerNotIn(List<Double> values) {
            addCriterion("fibrin_per not in", values, "fibrinPer");
            return (Criteria) this;
        }

        public Criteria andFibrinPerBetween(Double value1, Double value2) {
            addCriterion("fibrin_per between", value1, value2, "fibrinPer");
            return (Criteria) this;
        }

        public Criteria andFibrinPerNotBetween(Double value1, Double value2) {
            addCriterion("fibrin_per not between", value1, value2, "fibrinPer");
            return (Criteria) this;
        }

        public Criteria andFibrinLackIsNull() {
            addCriterion("fibrin_lack is null");
            return (Criteria) this;
        }

        public Criteria andFibrinLackIsNotNull() {
            addCriterion("fibrin_lack is not null");
            return (Criteria) this;
        }

        public Criteria andFibrinLackEqualTo(Double value) {
            addCriterion("fibrin_lack =", value, "fibrinLack");
            return (Criteria) this;
        }

        public Criteria andFibrinLackNotEqualTo(Double value) {
            addCriterion("fibrin_lack <>", value, "fibrinLack");
            return (Criteria) this;
        }

        public Criteria andFibrinLackGreaterThan(Double value) {
            addCriterion("fibrin_lack >", value, "fibrinLack");
            return (Criteria) this;
        }

        public Criteria andFibrinLackGreaterThanOrEqualTo(Double value) {
            addCriterion("fibrin_lack >=", value, "fibrinLack");
            return (Criteria) this;
        }

        public Criteria andFibrinLackLessThan(Double value) {
            addCriterion("fibrin_lack <", value, "fibrinLack");
            return (Criteria) this;
        }

        public Criteria andFibrinLackLessThanOrEqualTo(Double value) {
            addCriterion("fibrin_lack <=", value, "fibrinLack");
            return (Criteria) this;
        }

        public Criteria andFibrinLackIn(List<Double> values) {
            addCriterion("fibrin_lack in", values, "fibrinLack");
            return (Criteria) this;
        }

        public Criteria andFibrinLackNotIn(List<Double> values) {
            addCriterion("fibrin_lack not in", values, "fibrinLack");
            return (Criteria) this;
        }

        public Criteria andFibrinLackBetween(Double value1, Double value2) {
            addCriterion("fibrin_lack between", value1, value2, "fibrinLack");
            return (Criteria) this;
        }

        public Criteria andFibrinLackNotBetween(Double value1, Double value2) {
            addCriterion("fibrin_lack not between", value1, value2, "fibrinLack");
            return (Criteria) this;
        }

        public Criteria andFibrinEvaluationIsNull() {
            addCriterion("fibrin_evaluation is null");
            return (Criteria) this;
        }

        public Criteria andFibrinEvaluationIsNotNull() {
            addCriterion("fibrin_evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andFibrinEvaluationEqualTo(Integer value) {
            addCriterion("fibrin_evaluation =", value, "fibrinEvaluation");
            return (Criteria) this;
        }

        public Criteria andFibrinEvaluationNotEqualTo(Integer value) {
            addCriterion("fibrin_evaluation <>", value, "fibrinEvaluation");
            return (Criteria) this;
        }

        public Criteria andFibrinEvaluationGreaterThan(Integer value) {
            addCriterion("fibrin_evaluation >", value, "fibrinEvaluation");
            return (Criteria) this;
        }

        public Criteria andFibrinEvaluationGreaterThanOrEqualTo(Integer value) {
            addCriterion("fibrin_evaluation >=", value, "fibrinEvaluation");
            return (Criteria) this;
        }

        public Criteria andFibrinEvaluationLessThan(Integer value) {
            addCriterion("fibrin_evaluation <", value, "fibrinEvaluation");
            return (Criteria) this;
        }

        public Criteria andFibrinEvaluationLessThanOrEqualTo(Integer value) {
            addCriterion("fibrin_evaluation <=", value, "fibrinEvaluation");
            return (Criteria) this;
        }

        public Criteria andFibrinEvaluationIn(List<Integer> values) {
            addCriterion("fibrin_evaluation in", values, "fibrinEvaluation");
            return (Criteria) this;
        }

        public Criteria andFibrinEvaluationNotIn(List<Integer> values) {
            addCriterion("fibrin_evaluation not in", values, "fibrinEvaluation");
            return (Criteria) this;
        }

        public Criteria andFibrinEvaluationBetween(Integer value1, Integer value2) {
            addCriterion("fibrin_evaluation between", value1, value2, "fibrinEvaluation");
            return (Criteria) this;
        }

        public Criteria andFibrinEvaluationNotBetween(Integer value1, Integer value2) {
            addCriterion("fibrin_evaluation not between", value1, value2, "fibrinEvaluation");
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