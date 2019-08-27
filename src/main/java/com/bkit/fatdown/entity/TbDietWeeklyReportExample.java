package com.bkit.fatdown.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbDietWeeklyReportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbDietWeeklyReportExample() {
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

        public Criteria andEnergyScoreIsNull() {
            addCriterion("energy_score is null");
            return (Criteria) this;
        }

        public Criteria andEnergyScoreIsNotNull() {
            addCriterion("energy_score is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyScoreEqualTo(Double value) {
            addCriterion("energy_score =", value, "energyScore");
            return (Criteria) this;
        }

        public Criteria andEnergyScoreNotEqualTo(Double value) {
            addCriterion("energy_score <>", value, "energyScore");
            return (Criteria) this;
        }

        public Criteria andEnergyScoreGreaterThan(Double value) {
            addCriterion("energy_score >", value, "energyScore");
            return (Criteria) this;
        }

        public Criteria andEnergyScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("energy_score >=", value, "energyScore");
            return (Criteria) this;
        }

        public Criteria andEnergyScoreLessThan(Double value) {
            addCriterion("energy_score <", value, "energyScore");
            return (Criteria) this;
        }

        public Criteria andEnergyScoreLessThanOrEqualTo(Double value) {
            addCriterion("energy_score <=", value, "energyScore");
            return (Criteria) this;
        }

        public Criteria andEnergyScoreIn(List<Double> values) {
            addCriterion("energy_score in", values, "energyScore");
            return (Criteria) this;
        }

        public Criteria andEnergyScoreNotIn(List<Double> values) {
            addCriterion("energy_score not in", values, "energyScore");
            return (Criteria) this;
        }

        public Criteria andEnergyScoreBetween(Double value1, Double value2) {
            addCriterion("energy_score between", value1, value2, "energyScore");
            return (Criteria) this;
        }

        public Criteria andEnergyScoreNotBetween(Double value1, Double value2) {
            addCriterion("energy_score not between", value1, value2, "energyScore");
            return (Criteria) this;
        }

        public Criteria andEnergyExcellentIsNull() {
            addCriterion("energy_excellent is null");
            return (Criteria) this;
        }

        public Criteria andEnergyExcellentIsNotNull() {
            addCriterion("energy_excellent is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyExcellentEqualTo(Integer value) {
            addCriterion("energy_excellent =", value, "energyExcellent");
            return (Criteria) this;
        }

        public Criteria andEnergyExcellentNotEqualTo(Integer value) {
            addCriterion("energy_excellent <>", value, "energyExcellent");
            return (Criteria) this;
        }

        public Criteria andEnergyExcellentGreaterThan(Integer value) {
            addCriterion("energy_excellent >", value, "energyExcellent");
            return (Criteria) this;
        }

        public Criteria andEnergyExcellentGreaterThanOrEqualTo(Integer value) {
            addCriterion("energy_excellent >=", value, "energyExcellent");
            return (Criteria) this;
        }

        public Criteria andEnergyExcellentLessThan(Integer value) {
            addCriterion("energy_excellent <", value, "energyExcellent");
            return (Criteria) this;
        }

        public Criteria andEnergyExcellentLessThanOrEqualTo(Integer value) {
            addCriterion("energy_excellent <=", value, "energyExcellent");
            return (Criteria) this;
        }

        public Criteria andEnergyExcellentIn(List<Integer> values) {
            addCriterion("energy_excellent in", values, "energyExcellent");
            return (Criteria) this;
        }

        public Criteria andEnergyExcellentNotIn(List<Integer> values) {
            addCriterion("energy_excellent not in", values, "energyExcellent");
            return (Criteria) this;
        }

        public Criteria andEnergyExcellentBetween(Integer value1, Integer value2) {
            addCriterion("energy_excellent between", value1, value2, "energyExcellent");
            return (Criteria) this;
        }

        public Criteria andEnergyExcellentNotBetween(Integer value1, Integer value2) {
            addCriterion("energy_excellent not between", value1, value2, "energyExcellent");
            return (Criteria) this;
        }

        public Criteria andEnergyGoodIsNull() {
            addCriterion("energy_good is null");
            return (Criteria) this;
        }

        public Criteria andEnergyGoodIsNotNull() {
            addCriterion("energy_good is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyGoodEqualTo(Integer value) {
            addCriterion("energy_good =", value, "energyGood");
            return (Criteria) this;
        }

        public Criteria andEnergyGoodNotEqualTo(Integer value) {
            addCriterion("energy_good <>", value, "energyGood");
            return (Criteria) this;
        }

        public Criteria andEnergyGoodGreaterThan(Integer value) {
            addCriterion("energy_good >", value, "energyGood");
            return (Criteria) this;
        }

        public Criteria andEnergyGoodGreaterThanOrEqualTo(Integer value) {
            addCriterion("energy_good >=", value, "energyGood");
            return (Criteria) this;
        }

        public Criteria andEnergyGoodLessThan(Integer value) {
            addCriterion("energy_good <", value, "energyGood");
            return (Criteria) this;
        }

        public Criteria andEnergyGoodLessThanOrEqualTo(Integer value) {
            addCriterion("energy_good <=", value, "energyGood");
            return (Criteria) this;
        }

        public Criteria andEnergyGoodIn(List<Integer> values) {
            addCriterion("energy_good in", values, "energyGood");
            return (Criteria) this;
        }

        public Criteria andEnergyGoodNotIn(List<Integer> values) {
            addCriterion("energy_good not in", values, "energyGood");
            return (Criteria) this;
        }

        public Criteria andEnergyGoodBetween(Integer value1, Integer value2) {
            addCriterion("energy_good between", value1, value2, "energyGood");
            return (Criteria) this;
        }

        public Criteria andEnergyGoodNotBetween(Integer value1, Integer value2) {
            addCriterion("energy_good not between", value1, value2, "energyGood");
            return (Criteria) this;
        }

        public Criteria andEnergyOrdinaryIsNull() {
            addCriterion("energy_ordinary is null");
            return (Criteria) this;
        }

        public Criteria andEnergyOrdinaryIsNotNull() {
            addCriterion("energy_ordinary is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyOrdinaryEqualTo(Integer value) {
            addCriterion("energy_ordinary =", value, "energyOrdinary");
            return (Criteria) this;
        }

        public Criteria andEnergyOrdinaryNotEqualTo(Integer value) {
            addCriterion("energy_ordinary <>", value, "energyOrdinary");
            return (Criteria) this;
        }

        public Criteria andEnergyOrdinaryGreaterThan(Integer value) {
            addCriterion("energy_ordinary >", value, "energyOrdinary");
            return (Criteria) this;
        }

        public Criteria andEnergyOrdinaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("energy_ordinary >=", value, "energyOrdinary");
            return (Criteria) this;
        }

        public Criteria andEnergyOrdinaryLessThan(Integer value) {
            addCriterion("energy_ordinary <", value, "energyOrdinary");
            return (Criteria) this;
        }

        public Criteria andEnergyOrdinaryLessThanOrEqualTo(Integer value) {
            addCriterion("energy_ordinary <=", value, "energyOrdinary");
            return (Criteria) this;
        }

        public Criteria andEnergyOrdinaryIn(List<Integer> values) {
            addCriterion("energy_ordinary in", values, "energyOrdinary");
            return (Criteria) this;
        }

        public Criteria andEnergyOrdinaryNotIn(List<Integer> values) {
            addCriterion("energy_ordinary not in", values, "energyOrdinary");
            return (Criteria) this;
        }

        public Criteria andEnergyOrdinaryBetween(Integer value1, Integer value2) {
            addCriterion("energy_ordinary between", value1, value2, "energyOrdinary");
            return (Criteria) this;
        }

        public Criteria andEnergyOrdinaryNotBetween(Integer value1, Integer value2) {
            addCriterion("energy_ordinary not between", value1, value2, "energyOrdinary");
            return (Criteria) this;
        }

        public Criteria andEnergyBadIsNull() {
            addCriterion("energy_bad is null");
            return (Criteria) this;
        }

        public Criteria andEnergyBadIsNotNull() {
            addCriterion("energy_bad is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyBadEqualTo(Integer value) {
            addCriterion("energy_bad =", value, "energyBad");
            return (Criteria) this;
        }

        public Criteria andEnergyBadNotEqualTo(Integer value) {
            addCriterion("energy_bad <>", value, "energyBad");
            return (Criteria) this;
        }

        public Criteria andEnergyBadGreaterThan(Integer value) {
            addCriterion("energy_bad >", value, "energyBad");
            return (Criteria) this;
        }

        public Criteria andEnergyBadGreaterThanOrEqualTo(Integer value) {
            addCriterion("energy_bad >=", value, "energyBad");
            return (Criteria) this;
        }

        public Criteria andEnergyBadLessThan(Integer value) {
            addCriterion("energy_bad <", value, "energyBad");
            return (Criteria) this;
        }

        public Criteria andEnergyBadLessThanOrEqualTo(Integer value) {
            addCriterion("energy_bad <=", value, "energyBad");
            return (Criteria) this;
        }

        public Criteria andEnergyBadIn(List<Integer> values) {
            addCriterion("energy_bad in", values, "energyBad");
            return (Criteria) this;
        }

        public Criteria andEnergyBadNotIn(List<Integer> values) {
            addCriterion("energy_bad not in", values, "energyBad");
            return (Criteria) this;
        }

        public Criteria andEnergyBadBetween(Integer value1, Integer value2) {
            addCriterion("energy_bad between", value1, value2, "energyBad");
            return (Criteria) this;
        }

        public Criteria andEnergyBadNotBetween(Integer value1, Integer value2) {
            addCriterion("energy_bad not between", value1, value2, "energyBad");
            return (Criteria) this;
        }

        public Criteria andSpeciesScoreIsNull() {
            addCriterion("species_score is null");
            return (Criteria) this;
        }

        public Criteria andSpeciesScoreIsNotNull() {
            addCriterion("species_score is not null");
            return (Criteria) this;
        }

        public Criteria andSpeciesScoreEqualTo(Double value) {
            addCriterion("species_score =", value, "speciesScore");
            return (Criteria) this;
        }

        public Criteria andSpeciesScoreNotEqualTo(Double value) {
            addCriterion("species_score <>", value, "speciesScore");
            return (Criteria) this;
        }

        public Criteria andSpeciesScoreGreaterThan(Double value) {
            addCriterion("species_score >", value, "speciesScore");
            return (Criteria) this;
        }

        public Criteria andSpeciesScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("species_score >=", value, "speciesScore");
            return (Criteria) this;
        }

        public Criteria andSpeciesScoreLessThan(Double value) {
            addCriterion("species_score <", value, "speciesScore");
            return (Criteria) this;
        }

        public Criteria andSpeciesScoreLessThanOrEqualTo(Double value) {
            addCriterion("species_score <=", value, "speciesScore");
            return (Criteria) this;
        }

        public Criteria andSpeciesScoreIn(List<Double> values) {
            addCriterion("species_score in", values, "speciesScore");
            return (Criteria) this;
        }

        public Criteria andSpeciesScoreNotIn(List<Double> values) {
            addCriterion("species_score not in", values, "speciesScore");
            return (Criteria) this;
        }

        public Criteria andSpeciesScoreBetween(Double value1, Double value2) {
            addCriterion("species_score between", value1, value2, "speciesScore");
            return (Criteria) this;
        }

        public Criteria andSpeciesScoreNotBetween(Double value1, Double value2) {
            addCriterion("species_score not between", value1, value2, "speciesScore");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesTotalIsNull() {
            addCriterion("protein_species_total is null");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesTotalIsNotNull() {
            addCriterion("protein_species_total is not null");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesTotalEqualTo(Double value) {
            addCriterion("protein_species_total =", value, "proteinSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesTotalNotEqualTo(Double value) {
            addCriterion("protein_species_total <>", value, "proteinSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesTotalGreaterThan(Double value) {
            addCriterion("protein_species_total >", value, "proteinSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("protein_species_total >=", value, "proteinSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesTotalLessThan(Double value) {
            addCriterion("protein_species_total <", value, "proteinSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesTotalLessThanOrEqualTo(Double value) {
            addCriterion("protein_species_total <=", value, "proteinSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesTotalIn(List<Double> values) {
            addCriterion("protein_species_total in", values, "proteinSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesTotalNotIn(List<Double> values) {
            addCriterion("protein_species_total not in", values, "proteinSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesTotalBetween(Double value1, Double value2) {
            addCriterion("protein_species_total between", value1, value2, "proteinSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesTotalNotBetween(Double value1, Double value2) {
            addCriterion("protein_species_total not between", value1, value2, "proteinSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesEvaluationIsNull() {
            addCriterion("protein_species_evaluation is null");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesEvaluationIsNotNull() {
            addCriterion("protein_species_evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesEvaluationEqualTo(Integer value) {
            addCriterion("protein_species_evaluation =", value, "proteinSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesEvaluationNotEqualTo(Integer value) {
            addCriterion("protein_species_evaluation <>", value, "proteinSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesEvaluationGreaterThan(Integer value) {
            addCriterion("protein_species_evaluation >", value, "proteinSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesEvaluationGreaterThanOrEqualTo(Integer value) {
            addCriterion("protein_species_evaluation >=", value, "proteinSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesEvaluationLessThan(Integer value) {
            addCriterion("protein_species_evaluation <", value, "proteinSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesEvaluationLessThanOrEqualTo(Integer value) {
            addCriterion("protein_species_evaluation <=", value, "proteinSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesEvaluationIn(List<Integer> values) {
            addCriterion("protein_species_evaluation in", values, "proteinSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesEvaluationNotIn(List<Integer> values) {
            addCriterion("protein_species_evaluation not in", values, "proteinSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesEvaluationBetween(Integer value1, Integer value2) {
            addCriterion("protein_species_evaluation between", value1, value2, "proteinSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andProteinSpeciesEvaluationNotBetween(Integer value1, Integer value2) {
            addCriterion("protein_species_evaluation not between", value1, value2, "proteinSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesTotalIsNull() {
            addCriterion("staple_food_species_total is null");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesTotalIsNotNull() {
            addCriterion("staple_food_species_total is not null");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesTotalEqualTo(Double value) {
            addCriterion("staple_food_species_total =", value, "stapleFoodSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesTotalNotEqualTo(Double value) {
            addCriterion("staple_food_species_total <>", value, "stapleFoodSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesTotalGreaterThan(Double value) {
            addCriterion("staple_food_species_total >", value, "stapleFoodSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("staple_food_species_total >=", value, "stapleFoodSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesTotalLessThan(Double value) {
            addCriterion("staple_food_species_total <", value, "stapleFoodSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesTotalLessThanOrEqualTo(Double value) {
            addCriterion("staple_food_species_total <=", value, "stapleFoodSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesTotalIn(List<Double> values) {
            addCriterion("staple_food_species_total in", values, "stapleFoodSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesTotalNotIn(List<Double> values) {
            addCriterion("staple_food_species_total not in", values, "stapleFoodSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesTotalBetween(Double value1, Double value2) {
            addCriterion("staple_food_species_total between", value1, value2, "stapleFoodSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesTotalNotBetween(Double value1, Double value2) {
            addCriterion("staple_food_species_total not between", value1, value2, "stapleFoodSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesEvaluationIsNull() {
            addCriterion("staple_food_species_evaluation is null");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesEvaluationIsNotNull() {
            addCriterion("staple_food_species_evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesEvaluationEqualTo(Integer value) {
            addCriterion("staple_food_species_evaluation =", value, "stapleFoodSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesEvaluationNotEqualTo(Integer value) {
            addCriterion("staple_food_species_evaluation <>", value, "stapleFoodSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesEvaluationGreaterThan(Integer value) {
            addCriterion("staple_food_species_evaluation >", value, "stapleFoodSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesEvaluationGreaterThanOrEqualTo(Integer value) {
            addCriterion("staple_food_species_evaluation >=", value, "stapleFoodSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesEvaluationLessThan(Integer value) {
            addCriterion("staple_food_species_evaluation <", value, "stapleFoodSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesEvaluationLessThanOrEqualTo(Integer value) {
            addCriterion("staple_food_species_evaluation <=", value, "stapleFoodSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesEvaluationIn(List<Integer> values) {
            addCriterion("staple_food_species_evaluation in", values, "stapleFoodSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesEvaluationNotIn(List<Integer> values) {
            addCriterion("staple_food_species_evaluation not in", values, "stapleFoodSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesEvaluationBetween(Integer value1, Integer value2) {
            addCriterion("staple_food_species_evaluation between", value1, value2, "stapleFoodSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andStapleFoodSpeciesEvaluationNotBetween(Integer value1, Integer value2) {
            addCriterion("staple_food_species_evaluation not between", value1, value2, "stapleFoodSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesTotalIsNull() {
            addCriterion("bean_nut_species_total is null");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesTotalIsNotNull() {
            addCriterion("bean_nut_species_total is not null");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesTotalEqualTo(Double value) {
            addCriterion("bean_nut_species_total =", value, "beanNutSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesTotalNotEqualTo(Double value) {
            addCriterion("bean_nut_species_total <>", value, "beanNutSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesTotalGreaterThan(Double value) {
            addCriterion("bean_nut_species_total >", value, "beanNutSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("bean_nut_species_total >=", value, "beanNutSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesTotalLessThan(Double value) {
            addCriterion("bean_nut_species_total <", value, "beanNutSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesTotalLessThanOrEqualTo(Double value) {
            addCriterion("bean_nut_species_total <=", value, "beanNutSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesTotalIn(List<Double> values) {
            addCriterion("bean_nut_species_total in", values, "beanNutSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesTotalNotIn(List<Double> values) {
            addCriterion("bean_nut_species_total not in", values, "beanNutSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesTotalBetween(Double value1, Double value2) {
            addCriterion("bean_nut_species_total between", value1, value2, "beanNutSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesTotalNotBetween(Double value1, Double value2) {
            addCriterion("bean_nut_species_total not between", value1, value2, "beanNutSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesEvaluationIsNull() {
            addCriterion("bean_nut_species_evaluation is null");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesEvaluationIsNotNull() {
            addCriterion("bean_nut_species_evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesEvaluationEqualTo(Integer value) {
            addCriterion("bean_nut_species_evaluation =", value, "beanNutSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesEvaluationNotEqualTo(Integer value) {
            addCriterion("bean_nut_species_evaluation <>", value, "beanNutSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesEvaluationGreaterThan(Integer value) {
            addCriterion("bean_nut_species_evaluation >", value, "beanNutSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesEvaluationGreaterThanOrEqualTo(Integer value) {
            addCriterion("bean_nut_species_evaluation >=", value, "beanNutSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesEvaluationLessThan(Integer value) {
            addCriterion("bean_nut_species_evaluation <", value, "beanNutSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesEvaluationLessThanOrEqualTo(Integer value) {
            addCriterion("bean_nut_species_evaluation <=", value, "beanNutSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesEvaluationIn(List<Integer> values) {
            addCriterion("bean_nut_species_evaluation in", values, "beanNutSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesEvaluationNotIn(List<Integer> values) {
            addCriterion("bean_nut_species_evaluation not in", values, "beanNutSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesEvaluationBetween(Integer value1, Integer value2) {
            addCriterion("bean_nut_species_evaluation between", value1, value2, "beanNutSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andBeanNutSpeciesEvaluationNotBetween(Integer value1, Integer value2) {
            addCriterion("bean_nut_species_evaluation not between", value1, value2, "beanNutSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesTotalIsNull() {
            addCriterion("fruit_vegetable_species_total is null");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesTotalIsNotNull() {
            addCriterion("fruit_vegetable_species_total is not null");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesTotalEqualTo(Double value) {
            addCriterion("fruit_vegetable_species_total =", value, "fruitVegetableSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesTotalNotEqualTo(Double value) {
            addCriterion("fruit_vegetable_species_total <>", value, "fruitVegetableSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesTotalGreaterThan(Double value) {
            addCriterion("fruit_vegetable_species_total >", value, "fruitVegetableSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("fruit_vegetable_species_total >=", value, "fruitVegetableSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesTotalLessThan(Double value) {
            addCriterion("fruit_vegetable_species_total <", value, "fruitVegetableSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesTotalLessThanOrEqualTo(Double value) {
            addCriterion("fruit_vegetable_species_total <=", value, "fruitVegetableSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesTotalIn(List<Double> values) {
            addCriterion("fruit_vegetable_species_total in", values, "fruitVegetableSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesTotalNotIn(List<Double> values) {
            addCriterion("fruit_vegetable_species_total not in", values, "fruitVegetableSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesTotalBetween(Double value1, Double value2) {
            addCriterion("fruit_vegetable_species_total between", value1, value2, "fruitVegetableSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesTotalNotBetween(Double value1, Double value2) {
            addCriterion("fruit_vegetable_species_total not between", value1, value2, "fruitVegetableSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesEvaluationIsNull() {
            addCriterion("fruit_vegetable_species_evaluation is null");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesEvaluationIsNotNull() {
            addCriterion("fruit_vegetable_species_evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesEvaluationEqualTo(Integer value) {
            addCriterion("fruit_vegetable_species_evaluation =", value, "fruitVegetableSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesEvaluationNotEqualTo(Integer value) {
            addCriterion("fruit_vegetable_species_evaluation <>", value, "fruitVegetableSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesEvaluationGreaterThan(Integer value) {
            addCriterion("fruit_vegetable_species_evaluation >", value, "fruitVegetableSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesEvaluationGreaterThanOrEqualTo(Integer value) {
            addCriterion("fruit_vegetable_species_evaluation >=", value, "fruitVegetableSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesEvaluationLessThan(Integer value) {
            addCriterion("fruit_vegetable_species_evaluation <", value, "fruitVegetableSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesEvaluationLessThanOrEqualTo(Integer value) {
            addCriterion("fruit_vegetable_species_evaluation <=", value, "fruitVegetableSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesEvaluationIn(List<Integer> values) {
            addCriterion("fruit_vegetable_species_evaluation in", values, "fruitVegetableSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesEvaluationNotIn(List<Integer> values) {
            addCriterion("fruit_vegetable_species_evaluation not in", values, "fruitVegetableSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesEvaluationBetween(Integer value1, Integer value2) {
            addCriterion("fruit_vegetable_species_evaluation between", value1, value2, "fruitVegetableSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andFruitVegetableSpeciesEvaluationNotBetween(Integer value1, Integer value2) {
            addCriterion("fruit_vegetable_species_evaluation not between", value1, value2, "fruitVegetableSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesTotalIsNull() {
            addCriterion("total_species_total is null");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesTotalIsNotNull() {
            addCriterion("total_species_total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesTotalEqualTo(Double value) {
            addCriterion("total_species_total =", value, "totalSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesTotalNotEqualTo(Double value) {
            addCriterion("total_species_total <>", value, "totalSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesTotalGreaterThan(Double value) {
            addCriterion("total_species_total >", value, "totalSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("total_species_total >=", value, "totalSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesTotalLessThan(Double value) {
            addCriterion("total_species_total <", value, "totalSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesTotalLessThanOrEqualTo(Double value) {
            addCriterion("total_species_total <=", value, "totalSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesTotalIn(List<Double> values) {
            addCriterion("total_species_total in", values, "totalSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesTotalNotIn(List<Double> values) {
            addCriterion("total_species_total not in", values, "totalSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesTotalBetween(Double value1, Double value2) {
            addCriterion("total_species_total between", value1, value2, "totalSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesTotalNotBetween(Double value1, Double value2) {
            addCriterion("total_species_total not between", value1, value2, "totalSpeciesTotal");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesEvaluationIsNull() {
            addCriterion("total_species_evaluation is null");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesEvaluationIsNotNull() {
            addCriterion("total_species_evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesEvaluationEqualTo(Integer value) {
            addCriterion("total_species_evaluation =", value, "totalSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesEvaluationNotEqualTo(Integer value) {
            addCriterion("total_species_evaluation <>", value, "totalSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesEvaluationGreaterThan(Integer value) {
            addCriterion("total_species_evaluation >", value, "totalSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesEvaluationGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_species_evaluation >=", value, "totalSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesEvaluationLessThan(Integer value) {
            addCriterion("total_species_evaluation <", value, "totalSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesEvaluationLessThanOrEqualTo(Integer value) {
            addCriterion("total_species_evaluation <=", value, "totalSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesEvaluationIn(List<Integer> values) {
            addCriterion("total_species_evaluation in", values, "totalSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesEvaluationNotIn(List<Integer> values) {
            addCriterion("total_species_evaluation not in", values, "totalSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesEvaluationBetween(Integer value1, Integer value2) {
            addCriterion("total_species_evaluation between", value1, value2, "totalSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andTotalSpeciesEvaluationNotBetween(Integer value1, Integer value2) {
            addCriterion("total_species_evaluation not between", value1, value2, "totalSpeciesEvaluation");
            return (Criteria) this;
        }

        public Criteria andBreakfastScoreIsNull() {
            addCriterion("breakfast_score is null");
            return (Criteria) this;
        }

        public Criteria andBreakfastScoreIsNotNull() {
            addCriterion("breakfast_score is not null");
            return (Criteria) this;
        }

        public Criteria andBreakfastScoreEqualTo(Double value) {
            addCriterion("breakfast_score =", value, "breakfastScore");
            return (Criteria) this;
        }

        public Criteria andBreakfastScoreNotEqualTo(Double value) {
            addCriterion("breakfast_score <>", value, "breakfastScore");
            return (Criteria) this;
        }

        public Criteria andBreakfastScoreGreaterThan(Double value) {
            addCriterion("breakfast_score >", value, "breakfastScore");
            return (Criteria) this;
        }

        public Criteria andBreakfastScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("breakfast_score >=", value, "breakfastScore");
            return (Criteria) this;
        }

        public Criteria andBreakfastScoreLessThan(Double value) {
            addCriterion("breakfast_score <", value, "breakfastScore");
            return (Criteria) this;
        }

        public Criteria andBreakfastScoreLessThanOrEqualTo(Double value) {
            addCriterion("breakfast_score <=", value, "breakfastScore");
            return (Criteria) this;
        }

        public Criteria andBreakfastScoreIn(List<Double> values) {
            addCriterion("breakfast_score in", values, "breakfastScore");
            return (Criteria) this;
        }

        public Criteria andBreakfastScoreNotIn(List<Double> values) {
            addCriterion("breakfast_score not in", values, "breakfastScore");
            return (Criteria) this;
        }

        public Criteria andBreakfastScoreBetween(Double value1, Double value2) {
            addCriterion("breakfast_score between", value1, value2, "breakfastScore");
            return (Criteria) this;
        }

        public Criteria andBreakfastScoreNotBetween(Double value1, Double value2) {
            addCriterion("breakfast_score not between", value1, value2, "breakfastScore");
            return (Criteria) this;
        }

        public Criteria andBreakfastExcellentIsNull() {
            addCriterion("breakfast_excellent is null");
            return (Criteria) this;
        }

        public Criteria andBreakfastExcellentIsNotNull() {
            addCriterion("breakfast_excellent is not null");
            return (Criteria) this;
        }

        public Criteria andBreakfastExcellentEqualTo(Integer value) {
            addCriterion("breakfast_excellent =", value, "breakfastExcellent");
            return (Criteria) this;
        }

        public Criteria andBreakfastExcellentNotEqualTo(Integer value) {
            addCriterion("breakfast_excellent <>", value, "breakfastExcellent");
            return (Criteria) this;
        }

        public Criteria andBreakfastExcellentGreaterThan(Integer value) {
            addCriterion("breakfast_excellent >", value, "breakfastExcellent");
            return (Criteria) this;
        }

        public Criteria andBreakfastExcellentGreaterThanOrEqualTo(Integer value) {
            addCriterion("breakfast_excellent >=", value, "breakfastExcellent");
            return (Criteria) this;
        }

        public Criteria andBreakfastExcellentLessThan(Integer value) {
            addCriterion("breakfast_excellent <", value, "breakfastExcellent");
            return (Criteria) this;
        }

        public Criteria andBreakfastExcellentLessThanOrEqualTo(Integer value) {
            addCriterion("breakfast_excellent <=", value, "breakfastExcellent");
            return (Criteria) this;
        }

        public Criteria andBreakfastExcellentIn(List<Integer> values) {
            addCriterion("breakfast_excellent in", values, "breakfastExcellent");
            return (Criteria) this;
        }

        public Criteria andBreakfastExcellentNotIn(List<Integer> values) {
            addCriterion("breakfast_excellent not in", values, "breakfastExcellent");
            return (Criteria) this;
        }

        public Criteria andBreakfastExcellentBetween(Integer value1, Integer value2) {
            addCriterion("breakfast_excellent between", value1, value2, "breakfastExcellent");
            return (Criteria) this;
        }

        public Criteria andBreakfastExcellentNotBetween(Integer value1, Integer value2) {
            addCriterion("breakfast_excellent not between", value1, value2, "breakfastExcellent");
            return (Criteria) this;
        }

        public Criteria andBreakfastGoodIsNull() {
            addCriterion("breakfast_good is null");
            return (Criteria) this;
        }

        public Criteria andBreakfastGoodIsNotNull() {
            addCriterion("breakfast_good is not null");
            return (Criteria) this;
        }

        public Criteria andBreakfastGoodEqualTo(Integer value) {
            addCriterion("breakfast_good =", value, "breakfastGood");
            return (Criteria) this;
        }

        public Criteria andBreakfastGoodNotEqualTo(Integer value) {
            addCriterion("breakfast_good <>", value, "breakfastGood");
            return (Criteria) this;
        }

        public Criteria andBreakfastGoodGreaterThan(Integer value) {
            addCriterion("breakfast_good >", value, "breakfastGood");
            return (Criteria) this;
        }

        public Criteria andBreakfastGoodGreaterThanOrEqualTo(Integer value) {
            addCriterion("breakfast_good >=", value, "breakfastGood");
            return (Criteria) this;
        }

        public Criteria andBreakfastGoodLessThan(Integer value) {
            addCriterion("breakfast_good <", value, "breakfastGood");
            return (Criteria) this;
        }

        public Criteria andBreakfastGoodLessThanOrEqualTo(Integer value) {
            addCriterion("breakfast_good <=", value, "breakfastGood");
            return (Criteria) this;
        }

        public Criteria andBreakfastGoodIn(List<Integer> values) {
            addCriterion("breakfast_good in", values, "breakfastGood");
            return (Criteria) this;
        }

        public Criteria andBreakfastGoodNotIn(List<Integer> values) {
            addCriterion("breakfast_good not in", values, "breakfastGood");
            return (Criteria) this;
        }

        public Criteria andBreakfastGoodBetween(Integer value1, Integer value2) {
            addCriterion("breakfast_good between", value1, value2, "breakfastGood");
            return (Criteria) this;
        }

        public Criteria andBreakfastGoodNotBetween(Integer value1, Integer value2) {
            addCriterion("breakfast_good not between", value1, value2, "breakfastGood");
            return (Criteria) this;
        }

        public Criteria andBreakfastOrdinaryIsNull() {
            addCriterion("breakfast_ordinary is null");
            return (Criteria) this;
        }

        public Criteria andBreakfastOrdinaryIsNotNull() {
            addCriterion("breakfast_ordinary is not null");
            return (Criteria) this;
        }

        public Criteria andBreakfastOrdinaryEqualTo(Integer value) {
            addCriterion("breakfast_ordinary =", value, "breakfastOrdinary");
            return (Criteria) this;
        }

        public Criteria andBreakfastOrdinaryNotEqualTo(Integer value) {
            addCriterion("breakfast_ordinary <>", value, "breakfastOrdinary");
            return (Criteria) this;
        }

        public Criteria andBreakfastOrdinaryGreaterThan(Integer value) {
            addCriterion("breakfast_ordinary >", value, "breakfastOrdinary");
            return (Criteria) this;
        }

        public Criteria andBreakfastOrdinaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("breakfast_ordinary >=", value, "breakfastOrdinary");
            return (Criteria) this;
        }

        public Criteria andBreakfastOrdinaryLessThan(Integer value) {
            addCriterion("breakfast_ordinary <", value, "breakfastOrdinary");
            return (Criteria) this;
        }

        public Criteria andBreakfastOrdinaryLessThanOrEqualTo(Integer value) {
            addCriterion("breakfast_ordinary <=", value, "breakfastOrdinary");
            return (Criteria) this;
        }

        public Criteria andBreakfastOrdinaryIn(List<Integer> values) {
            addCriterion("breakfast_ordinary in", values, "breakfastOrdinary");
            return (Criteria) this;
        }

        public Criteria andBreakfastOrdinaryNotIn(List<Integer> values) {
            addCriterion("breakfast_ordinary not in", values, "breakfastOrdinary");
            return (Criteria) this;
        }

        public Criteria andBreakfastOrdinaryBetween(Integer value1, Integer value2) {
            addCriterion("breakfast_ordinary between", value1, value2, "breakfastOrdinary");
            return (Criteria) this;
        }

        public Criteria andBreakfastOrdinaryNotBetween(Integer value1, Integer value2) {
            addCriterion("breakfast_ordinary not between", value1, value2, "breakfastOrdinary");
            return (Criteria) this;
        }

        public Criteria andLunchScoreIsNull() {
            addCriterion("lunch_score is null");
            return (Criteria) this;
        }

        public Criteria andLunchScoreIsNotNull() {
            addCriterion("lunch_score is not null");
            return (Criteria) this;
        }

        public Criteria andLunchScoreEqualTo(Double value) {
            addCriterion("lunch_score =", value, "lunchScore");
            return (Criteria) this;
        }

        public Criteria andLunchScoreNotEqualTo(Double value) {
            addCriterion("lunch_score <>", value, "lunchScore");
            return (Criteria) this;
        }

        public Criteria andLunchScoreGreaterThan(Double value) {
            addCriterion("lunch_score >", value, "lunchScore");
            return (Criteria) this;
        }

        public Criteria andLunchScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("lunch_score >=", value, "lunchScore");
            return (Criteria) this;
        }

        public Criteria andLunchScoreLessThan(Double value) {
            addCriterion("lunch_score <", value, "lunchScore");
            return (Criteria) this;
        }

        public Criteria andLunchScoreLessThanOrEqualTo(Double value) {
            addCriterion("lunch_score <=", value, "lunchScore");
            return (Criteria) this;
        }

        public Criteria andLunchScoreIn(List<Double> values) {
            addCriterion("lunch_score in", values, "lunchScore");
            return (Criteria) this;
        }

        public Criteria andLunchScoreNotIn(List<Double> values) {
            addCriterion("lunch_score not in", values, "lunchScore");
            return (Criteria) this;
        }

        public Criteria andLunchScoreBetween(Double value1, Double value2) {
            addCriterion("lunch_score between", value1, value2, "lunchScore");
            return (Criteria) this;
        }

        public Criteria andLunchScoreNotBetween(Double value1, Double value2) {
            addCriterion("lunch_score not between", value1, value2, "lunchScore");
            return (Criteria) this;
        }

        public Criteria andLunchExcellentIsNull() {
            addCriterion("lunch_excellent is null");
            return (Criteria) this;
        }

        public Criteria andLunchExcellentIsNotNull() {
            addCriterion("lunch_excellent is not null");
            return (Criteria) this;
        }

        public Criteria andLunchExcellentEqualTo(Integer value) {
            addCriterion("lunch_excellent =", value, "lunchExcellent");
            return (Criteria) this;
        }

        public Criteria andLunchExcellentNotEqualTo(Integer value) {
            addCriterion("lunch_excellent <>", value, "lunchExcellent");
            return (Criteria) this;
        }

        public Criteria andLunchExcellentGreaterThan(Integer value) {
            addCriterion("lunch_excellent >", value, "lunchExcellent");
            return (Criteria) this;
        }

        public Criteria andLunchExcellentGreaterThanOrEqualTo(Integer value) {
            addCriterion("lunch_excellent >=", value, "lunchExcellent");
            return (Criteria) this;
        }

        public Criteria andLunchExcellentLessThan(Integer value) {
            addCriterion("lunch_excellent <", value, "lunchExcellent");
            return (Criteria) this;
        }

        public Criteria andLunchExcellentLessThanOrEqualTo(Integer value) {
            addCriterion("lunch_excellent <=", value, "lunchExcellent");
            return (Criteria) this;
        }

        public Criteria andLunchExcellentIn(List<Integer> values) {
            addCriterion("lunch_excellent in", values, "lunchExcellent");
            return (Criteria) this;
        }

        public Criteria andLunchExcellentNotIn(List<Integer> values) {
            addCriterion("lunch_excellent not in", values, "lunchExcellent");
            return (Criteria) this;
        }

        public Criteria andLunchExcellentBetween(Integer value1, Integer value2) {
            addCriterion("lunch_excellent between", value1, value2, "lunchExcellent");
            return (Criteria) this;
        }

        public Criteria andLunchExcellentNotBetween(Integer value1, Integer value2) {
            addCriterion("lunch_excellent not between", value1, value2, "lunchExcellent");
            return (Criteria) this;
        }

        public Criteria andLunchGoodIsNull() {
            addCriterion("lunch_good is null");
            return (Criteria) this;
        }

        public Criteria andLunchGoodIsNotNull() {
            addCriterion("lunch_good is not null");
            return (Criteria) this;
        }

        public Criteria andLunchGoodEqualTo(Integer value) {
            addCriterion("lunch_good =", value, "lunchGood");
            return (Criteria) this;
        }

        public Criteria andLunchGoodNotEqualTo(Integer value) {
            addCriterion("lunch_good <>", value, "lunchGood");
            return (Criteria) this;
        }

        public Criteria andLunchGoodGreaterThan(Integer value) {
            addCriterion("lunch_good >", value, "lunchGood");
            return (Criteria) this;
        }

        public Criteria andLunchGoodGreaterThanOrEqualTo(Integer value) {
            addCriterion("lunch_good >=", value, "lunchGood");
            return (Criteria) this;
        }

        public Criteria andLunchGoodLessThan(Integer value) {
            addCriterion("lunch_good <", value, "lunchGood");
            return (Criteria) this;
        }

        public Criteria andLunchGoodLessThanOrEqualTo(Integer value) {
            addCriterion("lunch_good <=", value, "lunchGood");
            return (Criteria) this;
        }

        public Criteria andLunchGoodIn(List<Integer> values) {
            addCriterion("lunch_good in", values, "lunchGood");
            return (Criteria) this;
        }

        public Criteria andLunchGoodNotIn(List<Integer> values) {
            addCriterion("lunch_good not in", values, "lunchGood");
            return (Criteria) this;
        }

        public Criteria andLunchGoodBetween(Integer value1, Integer value2) {
            addCriterion("lunch_good between", value1, value2, "lunchGood");
            return (Criteria) this;
        }

        public Criteria andLunchGoodNotBetween(Integer value1, Integer value2) {
            addCriterion("lunch_good not between", value1, value2, "lunchGood");
            return (Criteria) this;
        }

        public Criteria andLunchOrdinaryIsNull() {
            addCriterion("lunch_ordinary is null");
            return (Criteria) this;
        }

        public Criteria andLunchOrdinaryIsNotNull() {
            addCriterion("lunch_ordinary is not null");
            return (Criteria) this;
        }

        public Criteria andLunchOrdinaryEqualTo(Integer value) {
            addCriterion("lunch_ordinary =", value, "lunchOrdinary");
            return (Criteria) this;
        }

        public Criteria andLunchOrdinaryNotEqualTo(Integer value) {
            addCriterion("lunch_ordinary <>", value, "lunchOrdinary");
            return (Criteria) this;
        }

        public Criteria andLunchOrdinaryGreaterThan(Integer value) {
            addCriterion("lunch_ordinary >", value, "lunchOrdinary");
            return (Criteria) this;
        }

        public Criteria andLunchOrdinaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("lunch_ordinary >=", value, "lunchOrdinary");
            return (Criteria) this;
        }

        public Criteria andLunchOrdinaryLessThan(Integer value) {
            addCriterion("lunch_ordinary <", value, "lunchOrdinary");
            return (Criteria) this;
        }

        public Criteria andLunchOrdinaryLessThanOrEqualTo(Integer value) {
            addCriterion("lunch_ordinary <=", value, "lunchOrdinary");
            return (Criteria) this;
        }

        public Criteria andLunchOrdinaryIn(List<Integer> values) {
            addCriterion("lunch_ordinary in", values, "lunchOrdinary");
            return (Criteria) this;
        }

        public Criteria andLunchOrdinaryNotIn(List<Integer> values) {
            addCriterion("lunch_ordinary not in", values, "lunchOrdinary");
            return (Criteria) this;
        }

        public Criteria andLunchOrdinaryBetween(Integer value1, Integer value2) {
            addCriterion("lunch_ordinary between", value1, value2, "lunchOrdinary");
            return (Criteria) this;
        }

        public Criteria andLunchOrdinaryNotBetween(Integer value1, Integer value2) {
            addCriterion("lunch_ordinary not between", value1, value2, "lunchOrdinary");
            return (Criteria) this;
        }

        public Criteria andDinnerScoreIsNull() {
            addCriterion("dinner_score is null");
            return (Criteria) this;
        }

        public Criteria andDinnerScoreIsNotNull() {
            addCriterion("dinner_score is not null");
            return (Criteria) this;
        }

        public Criteria andDinnerScoreEqualTo(Double value) {
            addCriterion("dinner_score =", value, "dinnerScore");
            return (Criteria) this;
        }

        public Criteria andDinnerScoreNotEqualTo(Double value) {
            addCriterion("dinner_score <>", value, "dinnerScore");
            return (Criteria) this;
        }

        public Criteria andDinnerScoreGreaterThan(Double value) {
            addCriterion("dinner_score >", value, "dinnerScore");
            return (Criteria) this;
        }

        public Criteria andDinnerScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("dinner_score >=", value, "dinnerScore");
            return (Criteria) this;
        }

        public Criteria andDinnerScoreLessThan(Double value) {
            addCriterion("dinner_score <", value, "dinnerScore");
            return (Criteria) this;
        }

        public Criteria andDinnerScoreLessThanOrEqualTo(Double value) {
            addCriterion("dinner_score <=", value, "dinnerScore");
            return (Criteria) this;
        }

        public Criteria andDinnerScoreIn(List<Double> values) {
            addCriterion("dinner_score in", values, "dinnerScore");
            return (Criteria) this;
        }

        public Criteria andDinnerScoreNotIn(List<Double> values) {
            addCriterion("dinner_score not in", values, "dinnerScore");
            return (Criteria) this;
        }

        public Criteria andDinnerScoreBetween(Double value1, Double value2) {
            addCriterion("dinner_score between", value1, value2, "dinnerScore");
            return (Criteria) this;
        }

        public Criteria andDinnerScoreNotBetween(Double value1, Double value2) {
            addCriterion("dinner_score not between", value1, value2, "dinnerScore");
            return (Criteria) this;
        }

        public Criteria andDinnerExcellentIsNull() {
            addCriterion("dinner_excellent is null");
            return (Criteria) this;
        }

        public Criteria andDinnerExcellentIsNotNull() {
            addCriterion("dinner_excellent is not null");
            return (Criteria) this;
        }

        public Criteria andDinnerExcellentEqualTo(Integer value) {
            addCriterion("dinner_excellent =", value, "dinnerExcellent");
            return (Criteria) this;
        }

        public Criteria andDinnerExcellentNotEqualTo(Integer value) {
            addCriterion("dinner_excellent <>", value, "dinnerExcellent");
            return (Criteria) this;
        }

        public Criteria andDinnerExcellentGreaterThan(Integer value) {
            addCriterion("dinner_excellent >", value, "dinnerExcellent");
            return (Criteria) this;
        }

        public Criteria andDinnerExcellentGreaterThanOrEqualTo(Integer value) {
            addCriterion("dinner_excellent >=", value, "dinnerExcellent");
            return (Criteria) this;
        }

        public Criteria andDinnerExcellentLessThan(Integer value) {
            addCriterion("dinner_excellent <", value, "dinnerExcellent");
            return (Criteria) this;
        }

        public Criteria andDinnerExcellentLessThanOrEqualTo(Integer value) {
            addCriterion("dinner_excellent <=", value, "dinnerExcellent");
            return (Criteria) this;
        }

        public Criteria andDinnerExcellentIn(List<Integer> values) {
            addCriterion("dinner_excellent in", values, "dinnerExcellent");
            return (Criteria) this;
        }

        public Criteria andDinnerExcellentNotIn(List<Integer> values) {
            addCriterion("dinner_excellent not in", values, "dinnerExcellent");
            return (Criteria) this;
        }

        public Criteria andDinnerExcellentBetween(Integer value1, Integer value2) {
            addCriterion("dinner_excellent between", value1, value2, "dinnerExcellent");
            return (Criteria) this;
        }

        public Criteria andDinnerExcellentNotBetween(Integer value1, Integer value2) {
            addCriterion("dinner_excellent not between", value1, value2, "dinnerExcellent");
            return (Criteria) this;
        }

        public Criteria andDinnerGoodIsNull() {
            addCriterion("dinner_good is null");
            return (Criteria) this;
        }

        public Criteria andDinnerGoodIsNotNull() {
            addCriterion("dinner_good is not null");
            return (Criteria) this;
        }

        public Criteria andDinnerGoodEqualTo(Integer value) {
            addCriterion("dinner_good =", value, "dinnerGood");
            return (Criteria) this;
        }

        public Criteria andDinnerGoodNotEqualTo(Integer value) {
            addCriterion("dinner_good <>", value, "dinnerGood");
            return (Criteria) this;
        }

        public Criteria andDinnerGoodGreaterThan(Integer value) {
            addCriterion("dinner_good >", value, "dinnerGood");
            return (Criteria) this;
        }

        public Criteria andDinnerGoodGreaterThanOrEqualTo(Integer value) {
            addCriterion("dinner_good >=", value, "dinnerGood");
            return (Criteria) this;
        }

        public Criteria andDinnerGoodLessThan(Integer value) {
            addCriterion("dinner_good <", value, "dinnerGood");
            return (Criteria) this;
        }

        public Criteria andDinnerGoodLessThanOrEqualTo(Integer value) {
            addCriterion("dinner_good <=", value, "dinnerGood");
            return (Criteria) this;
        }

        public Criteria andDinnerGoodIn(List<Integer> values) {
            addCriterion("dinner_good in", values, "dinnerGood");
            return (Criteria) this;
        }

        public Criteria andDinnerGoodNotIn(List<Integer> values) {
            addCriterion("dinner_good not in", values, "dinnerGood");
            return (Criteria) this;
        }

        public Criteria andDinnerGoodBetween(Integer value1, Integer value2) {
            addCriterion("dinner_good between", value1, value2, "dinnerGood");
            return (Criteria) this;
        }

        public Criteria andDinnerGoodNotBetween(Integer value1, Integer value2) {
            addCriterion("dinner_good not between", value1, value2, "dinnerGood");
            return (Criteria) this;
        }

        public Criteria andDinnerOrdinaryIsNull() {
            addCriterion("dinner_ordinary is null");
            return (Criteria) this;
        }

        public Criteria andDinnerOrdinaryIsNotNull() {
            addCriterion("dinner_ordinary is not null");
            return (Criteria) this;
        }

        public Criteria andDinnerOrdinaryEqualTo(Integer value) {
            addCriterion("dinner_ordinary =", value, "dinnerOrdinary");
            return (Criteria) this;
        }

        public Criteria andDinnerOrdinaryNotEqualTo(Integer value) {
            addCriterion("dinner_ordinary <>", value, "dinnerOrdinary");
            return (Criteria) this;
        }

        public Criteria andDinnerOrdinaryGreaterThan(Integer value) {
            addCriterion("dinner_ordinary >", value, "dinnerOrdinary");
            return (Criteria) this;
        }

        public Criteria andDinnerOrdinaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("dinner_ordinary >=", value, "dinnerOrdinary");
            return (Criteria) this;
        }

        public Criteria andDinnerOrdinaryLessThan(Integer value) {
            addCriterion("dinner_ordinary <", value, "dinnerOrdinary");
            return (Criteria) this;
        }

        public Criteria andDinnerOrdinaryLessThanOrEqualTo(Integer value) {
            addCriterion("dinner_ordinary <=", value, "dinnerOrdinary");
            return (Criteria) this;
        }

        public Criteria andDinnerOrdinaryIn(List<Integer> values) {
            addCriterion("dinner_ordinary in", values, "dinnerOrdinary");
            return (Criteria) this;
        }

        public Criteria andDinnerOrdinaryNotIn(List<Integer> values) {
            addCriterion("dinner_ordinary not in", values, "dinnerOrdinary");
            return (Criteria) this;
        }

        public Criteria andDinnerOrdinaryBetween(Integer value1, Integer value2) {
            addCriterion("dinner_ordinary between", value1, value2, "dinnerOrdinary");
            return (Criteria) this;
        }

        public Criteria andDinnerOrdinaryNotBetween(Integer value1, Integer value2) {
            addCriterion("dinner_ordinary not between", value1, value2, "dinnerOrdinary");
            return (Criteria) this;
        }

        public Criteria andNutrientScoreIsNull() {
            addCriterion("nutrient_score is null");
            return (Criteria) this;
        }

        public Criteria andNutrientScoreIsNotNull() {
            addCriterion("nutrient_score is not null");
            return (Criteria) this;
        }

        public Criteria andNutrientScoreEqualTo(Double value) {
            addCriterion("nutrient_score =", value, "nutrientScore");
            return (Criteria) this;
        }

        public Criteria andNutrientScoreNotEqualTo(Double value) {
            addCriterion("nutrient_score <>", value, "nutrientScore");
            return (Criteria) this;
        }

        public Criteria andNutrientScoreGreaterThan(Double value) {
            addCriterion("nutrient_score >", value, "nutrientScore");
            return (Criteria) this;
        }

        public Criteria andNutrientScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("nutrient_score >=", value, "nutrientScore");
            return (Criteria) this;
        }

        public Criteria andNutrientScoreLessThan(Double value) {
            addCriterion("nutrient_score <", value, "nutrientScore");
            return (Criteria) this;
        }

        public Criteria andNutrientScoreLessThanOrEqualTo(Double value) {
            addCriterion("nutrient_score <=", value, "nutrientScore");
            return (Criteria) this;
        }

        public Criteria andNutrientScoreIn(List<Double> values) {
            addCriterion("nutrient_score in", values, "nutrientScore");
            return (Criteria) this;
        }

        public Criteria andNutrientScoreNotIn(List<Double> values) {
            addCriterion("nutrient_score not in", values, "nutrientScore");
            return (Criteria) this;
        }

        public Criteria andNutrientScoreBetween(Double value1, Double value2) {
            addCriterion("nutrient_score between", value1, value2, "nutrientScore");
            return (Criteria) this;
        }

        public Criteria andNutrientScoreNotBetween(Double value1, Double value2) {
            addCriterion("nutrient_score not between", value1, value2, "nutrientScore");
            return (Criteria) this;
        }

        public Criteria andProteinScoreIsNull() {
            addCriterion("protein_score is null");
            return (Criteria) this;
        }

        public Criteria andProteinScoreIsNotNull() {
            addCriterion("protein_score is not null");
            return (Criteria) this;
        }

        public Criteria andProteinScoreEqualTo(Double value) {
            addCriterion("protein_score =", value, "proteinScore");
            return (Criteria) this;
        }

        public Criteria andProteinScoreNotEqualTo(Double value) {
            addCriterion("protein_score <>", value, "proteinScore");
            return (Criteria) this;
        }

        public Criteria andProteinScoreGreaterThan(Double value) {
            addCriterion("protein_score >", value, "proteinScore");
            return (Criteria) this;
        }

        public Criteria andProteinScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("protein_score >=", value, "proteinScore");
            return (Criteria) this;
        }

        public Criteria andProteinScoreLessThan(Double value) {
            addCriterion("protein_score <", value, "proteinScore");
            return (Criteria) this;
        }

        public Criteria andProteinScoreLessThanOrEqualTo(Double value) {
            addCriterion("protein_score <=", value, "proteinScore");
            return (Criteria) this;
        }

        public Criteria andProteinScoreIn(List<Double> values) {
            addCriterion("protein_score in", values, "proteinScore");
            return (Criteria) this;
        }

        public Criteria andProteinScoreNotIn(List<Double> values) {
            addCriterion("protein_score not in", values, "proteinScore");
            return (Criteria) this;
        }

        public Criteria andProteinScoreBetween(Double value1, Double value2) {
            addCriterion("protein_score between", value1, value2, "proteinScore");
            return (Criteria) this;
        }

        public Criteria andProteinScoreNotBetween(Double value1, Double value2) {
            addCriterion("protein_score not between", value1, value2, "proteinScore");
            return (Criteria) this;
        }

        public Criteria andProteinExcellentIsNull() {
            addCriterion("protein_excellent is null");
            return (Criteria) this;
        }

        public Criteria andProteinExcellentIsNotNull() {
            addCriterion("protein_excellent is not null");
            return (Criteria) this;
        }

        public Criteria andProteinExcellentEqualTo(Integer value) {
            addCriterion("protein_excellent =", value, "proteinExcellent");
            return (Criteria) this;
        }

        public Criteria andProteinExcellentNotEqualTo(Integer value) {
            addCriterion("protein_excellent <>", value, "proteinExcellent");
            return (Criteria) this;
        }

        public Criteria andProteinExcellentGreaterThan(Integer value) {
            addCriterion("protein_excellent >", value, "proteinExcellent");
            return (Criteria) this;
        }

        public Criteria andProteinExcellentGreaterThanOrEqualTo(Integer value) {
            addCriterion("protein_excellent >=", value, "proteinExcellent");
            return (Criteria) this;
        }

        public Criteria andProteinExcellentLessThan(Integer value) {
            addCriterion("protein_excellent <", value, "proteinExcellent");
            return (Criteria) this;
        }

        public Criteria andProteinExcellentLessThanOrEqualTo(Integer value) {
            addCriterion("protein_excellent <=", value, "proteinExcellent");
            return (Criteria) this;
        }

        public Criteria andProteinExcellentIn(List<Integer> values) {
            addCriterion("protein_excellent in", values, "proteinExcellent");
            return (Criteria) this;
        }

        public Criteria andProteinExcellentNotIn(List<Integer> values) {
            addCriterion("protein_excellent not in", values, "proteinExcellent");
            return (Criteria) this;
        }

        public Criteria andProteinExcellentBetween(Integer value1, Integer value2) {
            addCriterion("protein_excellent between", value1, value2, "proteinExcellent");
            return (Criteria) this;
        }

        public Criteria andProteinExcellentNotBetween(Integer value1, Integer value2) {
            addCriterion("protein_excellent not between", value1, value2, "proteinExcellent");
            return (Criteria) this;
        }

        public Criteria andProteinGoodIsNull() {
            addCriterion("protein_good is null");
            return (Criteria) this;
        }

        public Criteria andProteinGoodIsNotNull() {
            addCriterion("protein_good is not null");
            return (Criteria) this;
        }

        public Criteria andProteinGoodEqualTo(Integer value) {
            addCriterion("protein_good =", value, "proteinGood");
            return (Criteria) this;
        }

        public Criteria andProteinGoodNotEqualTo(Integer value) {
            addCriterion("protein_good <>", value, "proteinGood");
            return (Criteria) this;
        }

        public Criteria andProteinGoodGreaterThan(Integer value) {
            addCriterion("protein_good >", value, "proteinGood");
            return (Criteria) this;
        }

        public Criteria andProteinGoodGreaterThanOrEqualTo(Integer value) {
            addCriterion("protein_good >=", value, "proteinGood");
            return (Criteria) this;
        }

        public Criteria andProteinGoodLessThan(Integer value) {
            addCriterion("protein_good <", value, "proteinGood");
            return (Criteria) this;
        }

        public Criteria andProteinGoodLessThanOrEqualTo(Integer value) {
            addCriterion("protein_good <=", value, "proteinGood");
            return (Criteria) this;
        }

        public Criteria andProteinGoodIn(List<Integer> values) {
            addCriterion("protein_good in", values, "proteinGood");
            return (Criteria) this;
        }

        public Criteria andProteinGoodNotIn(List<Integer> values) {
            addCriterion("protein_good not in", values, "proteinGood");
            return (Criteria) this;
        }

        public Criteria andProteinGoodBetween(Integer value1, Integer value2) {
            addCriterion("protein_good between", value1, value2, "proteinGood");
            return (Criteria) this;
        }

        public Criteria andProteinGoodNotBetween(Integer value1, Integer value2) {
            addCriterion("protein_good not between", value1, value2, "proteinGood");
            return (Criteria) this;
        }

        public Criteria andProteinOrdinaryIsNull() {
            addCriterion("protein_ordinary is null");
            return (Criteria) this;
        }

        public Criteria andProteinOrdinaryIsNotNull() {
            addCriterion("protein_ordinary is not null");
            return (Criteria) this;
        }

        public Criteria andProteinOrdinaryEqualTo(Integer value) {
            addCriterion("protein_ordinary =", value, "proteinOrdinary");
            return (Criteria) this;
        }

        public Criteria andProteinOrdinaryNotEqualTo(Integer value) {
            addCriterion("protein_ordinary <>", value, "proteinOrdinary");
            return (Criteria) this;
        }

        public Criteria andProteinOrdinaryGreaterThan(Integer value) {
            addCriterion("protein_ordinary >", value, "proteinOrdinary");
            return (Criteria) this;
        }

        public Criteria andProteinOrdinaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("protein_ordinary >=", value, "proteinOrdinary");
            return (Criteria) this;
        }

        public Criteria andProteinOrdinaryLessThan(Integer value) {
            addCriterion("protein_ordinary <", value, "proteinOrdinary");
            return (Criteria) this;
        }

        public Criteria andProteinOrdinaryLessThanOrEqualTo(Integer value) {
            addCriterion("protein_ordinary <=", value, "proteinOrdinary");
            return (Criteria) this;
        }

        public Criteria andProteinOrdinaryIn(List<Integer> values) {
            addCriterion("protein_ordinary in", values, "proteinOrdinary");
            return (Criteria) this;
        }

        public Criteria andProteinOrdinaryNotIn(List<Integer> values) {
            addCriterion("protein_ordinary not in", values, "proteinOrdinary");
            return (Criteria) this;
        }

        public Criteria andProteinOrdinaryBetween(Integer value1, Integer value2) {
            addCriterion("protein_ordinary between", value1, value2, "proteinOrdinary");
            return (Criteria) this;
        }

        public Criteria andProteinOrdinaryNotBetween(Integer value1, Integer value2) {
            addCriterion("protein_ordinary not between", value1, value2, "proteinOrdinary");
            return (Criteria) this;
        }

        public Criteria andFatScoreIsNull() {
            addCriterion("fat_score is null");
            return (Criteria) this;
        }

        public Criteria andFatScoreIsNotNull() {
            addCriterion("fat_score is not null");
            return (Criteria) this;
        }

        public Criteria andFatScoreEqualTo(Double value) {
            addCriterion("fat_score =", value, "fatScore");
            return (Criteria) this;
        }

        public Criteria andFatScoreNotEqualTo(Double value) {
            addCriterion("fat_score <>", value, "fatScore");
            return (Criteria) this;
        }

        public Criteria andFatScoreGreaterThan(Double value) {
            addCriterion("fat_score >", value, "fatScore");
            return (Criteria) this;
        }

        public Criteria andFatScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("fat_score >=", value, "fatScore");
            return (Criteria) this;
        }

        public Criteria andFatScoreLessThan(Double value) {
            addCriterion("fat_score <", value, "fatScore");
            return (Criteria) this;
        }

        public Criteria andFatScoreLessThanOrEqualTo(Double value) {
            addCriterion("fat_score <=", value, "fatScore");
            return (Criteria) this;
        }

        public Criteria andFatScoreIn(List<Double> values) {
            addCriterion("fat_score in", values, "fatScore");
            return (Criteria) this;
        }

        public Criteria andFatScoreNotIn(List<Double> values) {
            addCriterion("fat_score not in", values, "fatScore");
            return (Criteria) this;
        }

        public Criteria andFatScoreBetween(Double value1, Double value2) {
            addCriterion("fat_score between", value1, value2, "fatScore");
            return (Criteria) this;
        }

        public Criteria andFatScoreNotBetween(Double value1, Double value2) {
            addCriterion("fat_score not between", value1, value2, "fatScore");
            return (Criteria) this;
        }

        public Criteria andFatExcellentIsNull() {
            addCriterion("fat_excellent is null");
            return (Criteria) this;
        }

        public Criteria andFatExcellentIsNotNull() {
            addCriterion("fat_excellent is not null");
            return (Criteria) this;
        }

        public Criteria andFatExcellentEqualTo(Integer value) {
            addCriterion("fat_excellent =", value, "fatExcellent");
            return (Criteria) this;
        }

        public Criteria andFatExcellentNotEqualTo(Integer value) {
            addCriterion("fat_excellent <>", value, "fatExcellent");
            return (Criteria) this;
        }

        public Criteria andFatExcellentGreaterThan(Integer value) {
            addCriterion("fat_excellent >", value, "fatExcellent");
            return (Criteria) this;
        }

        public Criteria andFatExcellentGreaterThanOrEqualTo(Integer value) {
            addCriterion("fat_excellent >=", value, "fatExcellent");
            return (Criteria) this;
        }

        public Criteria andFatExcellentLessThan(Integer value) {
            addCriterion("fat_excellent <", value, "fatExcellent");
            return (Criteria) this;
        }

        public Criteria andFatExcellentLessThanOrEqualTo(Integer value) {
            addCriterion("fat_excellent <=", value, "fatExcellent");
            return (Criteria) this;
        }

        public Criteria andFatExcellentIn(List<Integer> values) {
            addCriterion("fat_excellent in", values, "fatExcellent");
            return (Criteria) this;
        }

        public Criteria andFatExcellentNotIn(List<Integer> values) {
            addCriterion("fat_excellent not in", values, "fatExcellent");
            return (Criteria) this;
        }

        public Criteria andFatExcellentBetween(Integer value1, Integer value2) {
            addCriterion("fat_excellent between", value1, value2, "fatExcellent");
            return (Criteria) this;
        }

        public Criteria andFatExcellentNotBetween(Integer value1, Integer value2) {
            addCriterion("fat_excellent not between", value1, value2, "fatExcellent");
            return (Criteria) this;
        }

        public Criteria andFatGoodIsNull() {
            addCriterion("fat_good is null");
            return (Criteria) this;
        }

        public Criteria andFatGoodIsNotNull() {
            addCriterion("fat_good is not null");
            return (Criteria) this;
        }

        public Criteria andFatGoodEqualTo(Integer value) {
            addCriterion("fat_good =", value, "fatGood");
            return (Criteria) this;
        }

        public Criteria andFatGoodNotEqualTo(Integer value) {
            addCriterion("fat_good <>", value, "fatGood");
            return (Criteria) this;
        }

        public Criteria andFatGoodGreaterThan(Integer value) {
            addCriterion("fat_good >", value, "fatGood");
            return (Criteria) this;
        }

        public Criteria andFatGoodGreaterThanOrEqualTo(Integer value) {
            addCriterion("fat_good >=", value, "fatGood");
            return (Criteria) this;
        }

        public Criteria andFatGoodLessThan(Integer value) {
            addCriterion("fat_good <", value, "fatGood");
            return (Criteria) this;
        }

        public Criteria andFatGoodLessThanOrEqualTo(Integer value) {
            addCriterion("fat_good <=", value, "fatGood");
            return (Criteria) this;
        }

        public Criteria andFatGoodIn(List<Integer> values) {
            addCriterion("fat_good in", values, "fatGood");
            return (Criteria) this;
        }

        public Criteria andFatGoodNotIn(List<Integer> values) {
            addCriterion("fat_good not in", values, "fatGood");
            return (Criteria) this;
        }

        public Criteria andFatGoodBetween(Integer value1, Integer value2) {
            addCriterion("fat_good between", value1, value2, "fatGood");
            return (Criteria) this;
        }

        public Criteria andFatGoodNotBetween(Integer value1, Integer value2) {
            addCriterion("fat_good not between", value1, value2, "fatGood");
            return (Criteria) this;
        }

        public Criteria andFatOrdinaryIsNull() {
            addCriterion("fat_ordinary is null");
            return (Criteria) this;
        }

        public Criteria andFatOrdinaryIsNotNull() {
            addCriterion("fat_ordinary is not null");
            return (Criteria) this;
        }

        public Criteria andFatOrdinaryEqualTo(Integer value) {
            addCriterion("fat_ordinary =", value, "fatOrdinary");
            return (Criteria) this;
        }

        public Criteria andFatOrdinaryNotEqualTo(Integer value) {
            addCriterion("fat_ordinary <>", value, "fatOrdinary");
            return (Criteria) this;
        }

        public Criteria andFatOrdinaryGreaterThan(Integer value) {
            addCriterion("fat_ordinary >", value, "fatOrdinary");
            return (Criteria) this;
        }

        public Criteria andFatOrdinaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("fat_ordinary >=", value, "fatOrdinary");
            return (Criteria) this;
        }

        public Criteria andFatOrdinaryLessThan(Integer value) {
            addCriterion("fat_ordinary <", value, "fatOrdinary");
            return (Criteria) this;
        }

        public Criteria andFatOrdinaryLessThanOrEqualTo(Integer value) {
            addCriterion("fat_ordinary <=", value, "fatOrdinary");
            return (Criteria) this;
        }

        public Criteria andFatOrdinaryIn(List<Integer> values) {
            addCriterion("fat_ordinary in", values, "fatOrdinary");
            return (Criteria) this;
        }

        public Criteria andFatOrdinaryNotIn(List<Integer> values) {
            addCriterion("fat_ordinary not in", values, "fatOrdinary");
            return (Criteria) this;
        }

        public Criteria andFatOrdinaryBetween(Integer value1, Integer value2) {
            addCriterion("fat_ordinary between", value1, value2, "fatOrdinary");
            return (Criteria) this;
        }

        public Criteria andFatOrdinaryNotBetween(Integer value1, Integer value2) {
            addCriterion("fat_ordinary not between", value1, value2, "fatOrdinary");
            return (Criteria) this;
        }

        public Criteria andFibrinScoreIsNull() {
            addCriterion("fibrin_score is null");
            return (Criteria) this;
        }

        public Criteria andFibrinScoreIsNotNull() {
            addCriterion("fibrin_score is not null");
            return (Criteria) this;
        }

        public Criteria andFibrinScoreEqualTo(Double value) {
            addCriterion("fibrin_score =", value, "fibrinScore");
            return (Criteria) this;
        }

        public Criteria andFibrinScoreNotEqualTo(Double value) {
            addCriterion("fibrin_score <>", value, "fibrinScore");
            return (Criteria) this;
        }

        public Criteria andFibrinScoreGreaterThan(Double value) {
            addCriterion("fibrin_score >", value, "fibrinScore");
            return (Criteria) this;
        }

        public Criteria andFibrinScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("fibrin_score >=", value, "fibrinScore");
            return (Criteria) this;
        }

        public Criteria andFibrinScoreLessThan(Double value) {
            addCriterion("fibrin_score <", value, "fibrinScore");
            return (Criteria) this;
        }

        public Criteria andFibrinScoreLessThanOrEqualTo(Double value) {
            addCriterion("fibrin_score <=", value, "fibrinScore");
            return (Criteria) this;
        }

        public Criteria andFibrinScoreIn(List<Double> values) {
            addCriterion("fibrin_score in", values, "fibrinScore");
            return (Criteria) this;
        }

        public Criteria andFibrinScoreNotIn(List<Double> values) {
            addCriterion("fibrin_score not in", values, "fibrinScore");
            return (Criteria) this;
        }

        public Criteria andFibrinScoreBetween(Double value1, Double value2) {
            addCriterion("fibrin_score between", value1, value2, "fibrinScore");
            return (Criteria) this;
        }

        public Criteria andFibrinScoreNotBetween(Double value1, Double value2) {
            addCriterion("fibrin_score not between", value1, value2, "fibrinScore");
            return (Criteria) this;
        }

        public Criteria andFibrinExcellentIsNull() {
            addCriterion("fibrin_excellent is null");
            return (Criteria) this;
        }

        public Criteria andFibrinExcellentIsNotNull() {
            addCriterion("fibrin_excellent is not null");
            return (Criteria) this;
        }

        public Criteria andFibrinExcellentEqualTo(Integer value) {
            addCriterion("fibrin_excellent =", value, "fibrinExcellent");
            return (Criteria) this;
        }

        public Criteria andFibrinExcellentNotEqualTo(Integer value) {
            addCriterion("fibrin_excellent <>", value, "fibrinExcellent");
            return (Criteria) this;
        }

        public Criteria andFibrinExcellentGreaterThan(Integer value) {
            addCriterion("fibrin_excellent >", value, "fibrinExcellent");
            return (Criteria) this;
        }

        public Criteria andFibrinExcellentGreaterThanOrEqualTo(Integer value) {
            addCriterion("fibrin_excellent >=", value, "fibrinExcellent");
            return (Criteria) this;
        }

        public Criteria andFibrinExcellentLessThan(Integer value) {
            addCriterion("fibrin_excellent <", value, "fibrinExcellent");
            return (Criteria) this;
        }

        public Criteria andFibrinExcellentLessThanOrEqualTo(Integer value) {
            addCriterion("fibrin_excellent <=", value, "fibrinExcellent");
            return (Criteria) this;
        }

        public Criteria andFibrinExcellentIn(List<Integer> values) {
            addCriterion("fibrin_excellent in", values, "fibrinExcellent");
            return (Criteria) this;
        }

        public Criteria andFibrinExcellentNotIn(List<Integer> values) {
            addCriterion("fibrin_excellent not in", values, "fibrinExcellent");
            return (Criteria) this;
        }

        public Criteria andFibrinExcellentBetween(Integer value1, Integer value2) {
            addCriterion("fibrin_excellent between", value1, value2, "fibrinExcellent");
            return (Criteria) this;
        }

        public Criteria andFibrinExcellentNotBetween(Integer value1, Integer value2) {
            addCriterion("fibrin_excellent not between", value1, value2, "fibrinExcellent");
            return (Criteria) this;
        }

        public Criteria andFibrinGoodIsNull() {
            addCriterion("fibrin_good is null");
            return (Criteria) this;
        }

        public Criteria andFibrinGoodIsNotNull() {
            addCriterion("fibrin_good is not null");
            return (Criteria) this;
        }

        public Criteria andFibrinGoodEqualTo(Integer value) {
            addCriterion("fibrin_good =", value, "fibrinGood");
            return (Criteria) this;
        }

        public Criteria andFibrinGoodNotEqualTo(Integer value) {
            addCriterion("fibrin_good <>", value, "fibrinGood");
            return (Criteria) this;
        }

        public Criteria andFibrinGoodGreaterThan(Integer value) {
            addCriterion("fibrin_good >", value, "fibrinGood");
            return (Criteria) this;
        }

        public Criteria andFibrinGoodGreaterThanOrEqualTo(Integer value) {
            addCriterion("fibrin_good >=", value, "fibrinGood");
            return (Criteria) this;
        }

        public Criteria andFibrinGoodLessThan(Integer value) {
            addCriterion("fibrin_good <", value, "fibrinGood");
            return (Criteria) this;
        }

        public Criteria andFibrinGoodLessThanOrEqualTo(Integer value) {
            addCriterion("fibrin_good <=", value, "fibrinGood");
            return (Criteria) this;
        }

        public Criteria andFibrinGoodIn(List<Integer> values) {
            addCriterion("fibrin_good in", values, "fibrinGood");
            return (Criteria) this;
        }

        public Criteria andFibrinGoodNotIn(List<Integer> values) {
            addCriterion("fibrin_good not in", values, "fibrinGood");
            return (Criteria) this;
        }

        public Criteria andFibrinGoodBetween(Integer value1, Integer value2) {
            addCriterion("fibrin_good between", value1, value2, "fibrinGood");
            return (Criteria) this;
        }

        public Criteria andFibrinGoodNotBetween(Integer value1, Integer value2) {
            addCriterion("fibrin_good not between", value1, value2, "fibrinGood");
            return (Criteria) this;
        }

        public Criteria andFibrinOrdinaryIsNull() {
            addCriterion("fibrin_ordinary is null");
            return (Criteria) this;
        }

        public Criteria andFibrinOrdinaryIsNotNull() {
            addCriterion("fibrin_ordinary is not null");
            return (Criteria) this;
        }

        public Criteria andFibrinOrdinaryEqualTo(Integer value) {
            addCriterion("fibrin_ordinary =", value, "fibrinOrdinary");
            return (Criteria) this;
        }

        public Criteria andFibrinOrdinaryNotEqualTo(Integer value) {
            addCriterion("fibrin_ordinary <>", value, "fibrinOrdinary");
            return (Criteria) this;
        }

        public Criteria andFibrinOrdinaryGreaterThan(Integer value) {
            addCriterion("fibrin_ordinary >", value, "fibrinOrdinary");
            return (Criteria) this;
        }

        public Criteria andFibrinOrdinaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("fibrin_ordinary >=", value, "fibrinOrdinary");
            return (Criteria) this;
        }

        public Criteria andFibrinOrdinaryLessThan(Integer value) {
            addCriterion("fibrin_ordinary <", value, "fibrinOrdinary");
            return (Criteria) this;
        }

        public Criteria andFibrinOrdinaryLessThanOrEqualTo(Integer value) {
            addCriterion("fibrin_ordinary <=", value, "fibrinOrdinary");
            return (Criteria) this;
        }

        public Criteria andFibrinOrdinaryIn(List<Integer> values) {
            addCriterion("fibrin_ordinary in", values, "fibrinOrdinary");
            return (Criteria) this;
        }

        public Criteria andFibrinOrdinaryNotIn(List<Integer> values) {
            addCriterion("fibrin_ordinary not in", values, "fibrinOrdinary");
            return (Criteria) this;
        }

        public Criteria andFibrinOrdinaryBetween(Integer value1, Integer value2) {
            addCriterion("fibrin_ordinary between", value1, value2, "fibrinOrdinary");
            return (Criteria) this;
        }

        public Criteria andFibrinOrdinaryNotBetween(Integer value1, Integer value2) {
            addCriterion("fibrin_ordinary not between", value1, value2, "fibrinOrdinary");
            return (Criteria) this;
        }

        public Criteria andCarbsScoreIsNull() {
            addCriterion("carbs_score is null");
            return (Criteria) this;
        }

        public Criteria andCarbsScoreIsNotNull() {
            addCriterion("carbs_score is not null");
            return (Criteria) this;
        }

        public Criteria andCarbsScoreEqualTo(Double value) {
            addCriterion("carbs_score =", value, "carbsScore");
            return (Criteria) this;
        }

        public Criteria andCarbsScoreNotEqualTo(Double value) {
            addCriterion("carbs_score <>", value, "carbsScore");
            return (Criteria) this;
        }

        public Criteria andCarbsScoreGreaterThan(Double value) {
            addCriterion("carbs_score >", value, "carbsScore");
            return (Criteria) this;
        }

        public Criteria andCarbsScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("carbs_score >=", value, "carbsScore");
            return (Criteria) this;
        }

        public Criteria andCarbsScoreLessThan(Double value) {
            addCriterion("carbs_score <", value, "carbsScore");
            return (Criteria) this;
        }

        public Criteria andCarbsScoreLessThanOrEqualTo(Double value) {
            addCriterion("carbs_score <=", value, "carbsScore");
            return (Criteria) this;
        }

        public Criteria andCarbsScoreIn(List<Double> values) {
            addCriterion("carbs_score in", values, "carbsScore");
            return (Criteria) this;
        }

        public Criteria andCarbsScoreNotIn(List<Double> values) {
            addCriterion("carbs_score not in", values, "carbsScore");
            return (Criteria) this;
        }

        public Criteria andCarbsScoreBetween(Double value1, Double value2) {
            addCriterion("carbs_score between", value1, value2, "carbsScore");
            return (Criteria) this;
        }

        public Criteria andCarbsScoreNotBetween(Double value1, Double value2) {
            addCriterion("carbs_score not between", value1, value2, "carbsScore");
            return (Criteria) this;
        }

        public Criteria andCarbsGoodIsNull() {
            addCriterion("carbs_good is null");
            return (Criteria) this;
        }

        public Criteria andCarbsGoodIsNotNull() {
            addCriterion("carbs_good is not null");
            return (Criteria) this;
        }

        public Criteria andCarbsGoodEqualTo(Integer value) {
            addCriterion("carbs_good =", value, "carbsGood");
            return (Criteria) this;
        }

        public Criteria andCarbsGoodNotEqualTo(Integer value) {
            addCriterion("carbs_good <>", value, "carbsGood");
            return (Criteria) this;
        }

        public Criteria andCarbsGoodGreaterThan(Integer value) {
            addCriterion("carbs_good >", value, "carbsGood");
            return (Criteria) this;
        }

        public Criteria andCarbsGoodGreaterThanOrEqualTo(Integer value) {
            addCriterion("carbs_good >=", value, "carbsGood");
            return (Criteria) this;
        }

        public Criteria andCarbsGoodLessThan(Integer value) {
            addCriterion("carbs_good <", value, "carbsGood");
            return (Criteria) this;
        }

        public Criteria andCarbsGoodLessThanOrEqualTo(Integer value) {
            addCriterion("carbs_good <=", value, "carbsGood");
            return (Criteria) this;
        }

        public Criteria andCarbsGoodIn(List<Integer> values) {
            addCriterion("carbs_good in", values, "carbsGood");
            return (Criteria) this;
        }

        public Criteria andCarbsGoodNotIn(List<Integer> values) {
            addCriterion("carbs_good not in", values, "carbsGood");
            return (Criteria) this;
        }

        public Criteria andCarbsGoodBetween(Integer value1, Integer value2) {
            addCriterion("carbs_good between", value1, value2, "carbsGood");
            return (Criteria) this;
        }

        public Criteria andCarbsGoodNotBetween(Integer value1, Integer value2) {
            addCriterion("carbs_good not between", value1, value2, "carbsGood");
            return (Criteria) this;
        }

        public Criteria andCarbsExcellentIsNull() {
            addCriterion("carbs_excellent is null");
            return (Criteria) this;
        }

        public Criteria andCarbsExcellentIsNotNull() {
            addCriterion("carbs_excellent is not null");
            return (Criteria) this;
        }

        public Criteria andCarbsExcellentEqualTo(Integer value) {
            addCriterion("carbs_excellent =", value, "carbsExcellent");
            return (Criteria) this;
        }

        public Criteria andCarbsExcellentNotEqualTo(Integer value) {
            addCriterion("carbs_excellent <>", value, "carbsExcellent");
            return (Criteria) this;
        }

        public Criteria andCarbsExcellentGreaterThan(Integer value) {
            addCriterion("carbs_excellent >", value, "carbsExcellent");
            return (Criteria) this;
        }

        public Criteria andCarbsExcellentGreaterThanOrEqualTo(Integer value) {
            addCriterion("carbs_excellent >=", value, "carbsExcellent");
            return (Criteria) this;
        }

        public Criteria andCarbsExcellentLessThan(Integer value) {
            addCriterion("carbs_excellent <", value, "carbsExcellent");
            return (Criteria) this;
        }

        public Criteria andCarbsExcellentLessThanOrEqualTo(Integer value) {
            addCriterion("carbs_excellent <=", value, "carbsExcellent");
            return (Criteria) this;
        }

        public Criteria andCarbsExcellentIn(List<Integer> values) {
            addCriterion("carbs_excellent in", values, "carbsExcellent");
            return (Criteria) this;
        }

        public Criteria andCarbsExcellentNotIn(List<Integer> values) {
            addCriterion("carbs_excellent not in", values, "carbsExcellent");
            return (Criteria) this;
        }

        public Criteria andCarbsExcellentBetween(Integer value1, Integer value2) {
            addCriterion("carbs_excellent between", value1, value2, "carbsExcellent");
            return (Criteria) this;
        }

        public Criteria andCarbsExcellentNotBetween(Integer value1, Integer value2) {
            addCriterion("carbs_excellent not between", value1, value2, "carbsExcellent");
            return (Criteria) this;
        }

        public Criteria andCarbsOrdinaryIsNull() {
            addCriterion("carbs_ordinary is null");
            return (Criteria) this;
        }

        public Criteria andCarbsOrdinaryIsNotNull() {
            addCriterion("carbs_ordinary is not null");
            return (Criteria) this;
        }

        public Criteria andCarbsOrdinaryEqualTo(Integer value) {
            addCriterion("carbs_ordinary =", value, "carbsOrdinary");
            return (Criteria) this;
        }

        public Criteria andCarbsOrdinaryNotEqualTo(Integer value) {
            addCriterion("carbs_ordinary <>", value, "carbsOrdinary");
            return (Criteria) this;
        }

        public Criteria andCarbsOrdinaryGreaterThan(Integer value) {
            addCriterion("carbs_ordinary >", value, "carbsOrdinary");
            return (Criteria) this;
        }

        public Criteria andCarbsOrdinaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("carbs_ordinary >=", value, "carbsOrdinary");
            return (Criteria) this;
        }

        public Criteria andCarbsOrdinaryLessThan(Integer value) {
            addCriterion("carbs_ordinary <", value, "carbsOrdinary");
            return (Criteria) this;
        }

        public Criteria andCarbsOrdinaryLessThanOrEqualTo(Integer value) {
            addCriterion("carbs_ordinary <=", value, "carbsOrdinary");
            return (Criteria) this;
        }

        public Criteria andCarbsOrdinaryIn(List<Integer> values) {
            addCriterion("carbs_ordinary in", values, "carbsOrdinary");
            return (Criteria) this;
        }

        public Criteria andCarbsOrdinaryNotIn(List<Integer> values) {
            addCriterion("carbs_ordinary not in", values, "carbsOrdinary");
            return (Criteria) this;
        }

        public Criteria andCarbsOrdinaryBetween(Integer value1, Integer value2) {
            addCriterion("carbs_ordinary between", value1, value2, "carbsOrdinary");
            return (Criteria) this;
        }

        public Criteria andCarbsOrdinaryNotBetween(Integer value1, Integer value2) {
            addCriterion("carbs_ordinary not between", value1, value2, "carbsOrdinary");
            return (Criteria) this;
        }

        public Criteria andAnimalFatScoreIsNull() {
            addCriterion("animal_fat_score is null");
            return (Criteria) this;
        }

        public Criteria andAnimalFatScoreIsNotNull() {
            addCriterion("animal_fat_score is not null");
            return (Criteria) this;
        }

        public Criteria andAnimalFatScoreEqualTo(Double value) {
            addCriterion("animal_fat_score =", value, "animalFatScore");
            return (Criteria) this;
        }

        public Criteria andAnimalFatScoreNotEqualTo(Double value) {
            addCriterion("animal_fat_score <>", value, "animalFatScore");
            return (Criteria) this;
        }

        public Criteria andAnimalFatScoreGreaterThan(Double value) {
            addCriterion("animal_fat_score >", value, "animalFatScore");
            return (Criteria) this;
        }

        public Criteria andAnimalFatScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("animal_fat_score >=", value, "animalFatScore");
            return (Criteria) this;
        }

        public Criteria andAnimalFatScoreLessThan(Double value) {
            addCriterion("animal_fat_score <", value, "animalFatScore");
            return (Criteria) this;
        }

        public Criteria andAnimalFatScoreLessThanOrEqualTo(Double value) {
            addCriterion("animal_fat_score <=", value, "animalFatScore");
            return (Criteria) this;
        }

        public Criteria andAnimalFatScoreIn(List<Double> values) {
            addCriterion("animal_fat_score in", values, "animalFatScore");
            return (Criteria) this;
        }

        public Criteria andAnimalFatScoreNotIn(List<Double> values) {
            addCriterion("animal_fat_score not in", values, "animalFatScore");
            return (Criteria) this;
        }

        public Criteria andAnimalFatScoreBetween(Double value1, Double value2) {
            addCriterion("animal_fat_score between", value1, value2, "animalFatScore");
            return (Criteria) this;
        }

        public Criteria andAnimalFatScoreNotBetween(Double value1, Double value2) {
            addCriterion("animal_fat_score not between", value1, value2, "animalFatScore");
            return (Criteria) this;
        }

        public Criteria andAnimalFatPerIsNull() {
            addCriterion("animal_fat_per is null");
            return (Criteria) this;
        }

        public Criteria andAnimalFatPerIsNotNull() {
            addCriterion("animal_fat_per is not null");
            return (Criteria) this;
        }

        public Criteria andAnimalFatPerEqualTo(Double value) {
            addCriterion("animal_fat_per =", value, "animalFatPer");
            return (Criteria) this;
        }

        public Criteria andAnimalFatPerNotEqualTo(Double value) {
            addCriterion("animal_fat_per <>", value, "animalFatPer");
            return (Criteria) this;
        }

        public Criteria andAnimalFatPerGreaterThan(Double value) {
            addCriterion("animal_fat_per >", value, "animalFatPer");
            return (Criteria) this;
        }

        public Criteria andAnimalFatPerGreaterThanOrEqualTo(Double value) {
            addCriterion("animal_fat_per >=", value, "animalFatPer");
            return (Criteria) this;
        }

        public Criteria andAnimalFatPerLessThan(Double value) {
            addCriterion("animal_fat_per <", value, "animalFatPer");
            return (Criteria) this;
        }

        public Criteria andAnimalFatPerLessThanOrEqualTo(Double value) {
            addCriterion("animal_fat_per <=", value, "animalFatPer");
            return (Criteria) this;
        }

        public Criteria andAnimalFatPerIn(List<Double> values) {
            addCriterion("animal_fat_per in", values, "animalFatPer");
            return (Criteria) this;
        }

        public Criteria andAnimalFatPerNotIn(List<Double> values) {
            addCriterion("animal_fat_per not in", values, "animalFatPer");
            return (Criteria) this;
        }

        public Criteria andAnimalFatPerBetween(Double value1, Double value2) {
            addCriterion("animal_fat_per between", value1, value2, "animalFatPer");
            return (Criteria) this;
        }

        public Criteria andAnimalFatPerNotBetween(Double value1, Double value2) {
            addCriterion("animal_fat_per not between", value1, value2, "animalFatPer");
            return (Criteria) this;
        }

        public Criteria andAnimalFatEvaluationIsNull() {
            addCriterion("animal_fat_evaluation is null");
            return (Criteria) this;
        }

        public Criteria andAnimalFatEvaluationIsNotNull() {
            addCriterion("animal_fat_evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andAnimalFatEvaluationEqualTo(Integer value) {
            addCriterion("animal_fat_evaluation =", value, "animalFatEvaluation");
            return (Criteria) this;
        }

        public Criteria andAnimalFatEvaluationNotEqualTo(Integer value) {
            addCriterion("animal_fat_evaluation <>", value, "animalFatEvaluation");
            return (Criteria) this;
        }

        public Criteria andAnimalFatEvaluationGreaterThan(Integer value) {
            addCriterion("animal_fat_evaluation >", value, "animalFatEvaluation");
            return (Criteria) this;
        }

        public Criteria andAnimalFatEvaluationGreaterThanOrEqualTo(Integer value) {
            addCriterion("animal_fat_evaluation >=", value, "animalFatEvaluation");
            return (Criteria) this;
        }

        public Criteria andAnimalFatEvaluationLessThan(Integer value) {
            addCriterion("animal_fat_evaluation <", value, "animalFatEvaluation");
            return (Criteria) this;
        }

        public Criteria andAnimalFatEvaluationLessThanOrEqualTo(Integer value) {
            addCriterion("animal_fat_evaluation <=", value, "animalFatEvaluation");
            return (Criteria) this;
        }

        public Criteria andAnimalFatEvaluationIn(List<Integer> values) {
            addCriterion("animal_fat_evaluation in", values, "animalFatEvaluation");
            return (Criteria) this;
        }

        public Criteria andAnimalFatEvaluationNotIn(List<Integer> values) {
            addCriterion("animal_fat_evaluation not in", values, "animalFatEvaluation");
            return (Criteria) this;
        }

        public Criteria andAnimalFatEvaluationBetween(Integer value1, Integer value2) {
            addCriterion("animal_fat_evaluation between", value1, value2, "animalFatEvaluation");
            return (Criteria) this;
        }

        public Criteria andAnimalFatEvaluationNotBetween(Integer value1, Integer value2) {
            addCriterion("animal_fat_evaluation not between", value1, value2, "animalFatEvaluation");
            return (Criteria) this;
        }

        public Criteria andGoodProteinScoreIsNull() {
            addCriterion("good_protein_score is null");
            return (Criteria) this;
        }

        public Criteria andGoodProteinScoreIsNotNull() {
            addCriterion("good_protein_score is not null");
            return (Criteria) this;
        }

        public Criteria andGoodProteinScoreEqualTo(Double value) {
            addCriterion("good_protein_score =", value, "goodProteinScore");
            return (Criteria) this;
        }

        public Criteria andGoodProteinScoreNotEqualTo(Double value) {
            addCriterion("good_protein_score <>", value, "goodProteinScore");
            return (Criteria) this;
        }

        public Criteria andGoodProteinScoreGreaterThan(Double value) {
            addCriterion("good_protein_score >", value, "goodProteinScore");
            return (Criteria) this;
        }

        public Criteria andGoodProteinScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("good_protein_score >=", value, "goodProteinScore");
            return (Criteria) this;
        }

        public Criteria andGoodProteinScoreLessThan(Double value) {
            addCriterion("good_protein_score <", value, "goodProteinScore");
            return (Criteria) this;
        }

        public Criteria andGoodProteinScoreLessThanOrEqualTo(Double value) {
            addCriterion("good_protein_score <=", value, "goodProteinScore");
            return (Criteria) this;
        }

        public Criteria andGoodProteinScoreIn(List<Double> values) {
            addCriterion("good_protein_score in", values, "goodProteinScore");
            return (Criteria) this;
        }

        public Criteria andGoodProteinScoreNotIn(List<Double> values) {
            addCriterion("good_protein_score not in", values, "goodProteinScore");
            return (Criteria) this;
        }

        public Criteria andGoodProteinScoreBetween(Double value1, Double value2) {
            addCriterion("good_protein_score between", value1, value2, "goodProteinScore");
            return (Criteria) this;
        }

        public Criteria andGoodProteinScoreNotBetween(Double value1, Double value2) {
            addCriterion("good_protein_score not between", value1, value2, "goodProteinScore");
            return (Criteria) this;
        }

        public Criteria andGoodProteinPerIsNull() {
            addCriterion("good_protein_per is null");
            return (Criteria) this;
        }

        public Criteria andGoodProteinPerIsNotNull() {
            addCriterion("good_protein_per is not null");
            return (Criteria) this;
        }

        public Criteria andGoodProteinPerEqualTo(Double value) {
            addCriterion("good_protein_per =", value, "goodProteinPer");
            return (Criteria) this;
        }

        public Criteria andGoodProteinPerNotEqualTo(Double value) {
            addCriterion("good_protein_per <>", value, "goodProteinPer");
            return (Criteria) this;
        }

        public Criteria andGoodProteinPerGreaterThan(Double value) {
            addCriterion("good_protein_per >", value, "goodProteinPer");
            return (Criteria) this;
        }

        public Criteria andGoodProteinPerGreaterThanOrEqualTo(Double value) {
            addCriterion("good_protein_per >=", value, "goodProteinPer");
            return (Criteria) this;
        }

        public Criteria andGoodProteinPerLessThan(Double value) {
            addCriterion("good_protein_per <", value, "goodProteinPer");
            return (Criteria) this;
        }

        public Criteria andGoodProteinPerLessThanOrEqualTo(Double value) {
            addCriterion("good_protein_per <=", value, "goodProteinPer");
            return (Criteria) this;
        }

        public Criteria andGoodProteinPerIn(List<Double> values) {
            addCriterion("good_protein_per in", values, "goodProteinPer");
            return (Criteria) this;
        }

        public Criteria andGoodProteinPerNotIn(List<Double> values) {
            addCriterion("good_protein_per not in", values, "goodProteinPer");
            return (Criteria) this;
        }

        public Criteria andGoodProteinPerBetween(Double value1, Double value2) {
            addCriterion("good_protein_per between", value1, value2, "goodProteinPer");
            return (Criteria) this;
        }

        public Criteria andGoodProteinPerNotBetween(Double value1, Double value2) {
            addCriterion("good_protein_per not between", value1, value2, "goodProteinPer");
            return (Criteria) this;
        }

        public Criteria andGoodProteinEvaluationIsNull() {
            addCriterion("good_protein_evaluation is null");
            return (Criteria) this;
        }

        public Criteria andGoodProteinEvaluationIsNotNull() {
            addCriterion("good_protein_evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andGoodProteinEvaluationEqualTo(Integer value) {
            addCriterion("good_protein_evaluation =", value, "goodProteinEvaluation");
            return (Criteria) this;
        }

        public Criteria andGoodProteinEvaluationNotEqualTo(Integer value) {
            addCriterion("good_protein_evaluation <>", value, "goodProteinEvaluation");
            return (Criteria) this;
        }

        public Criteria andGoodProteinEvaluationGreaterThan(Integer value) {
            addCriterion("good_protein_evaluation >", value, "goodProteinEvaluation");
            return (Criteria) this;
        }

        public Criteria andGoodProteinEvaluationGreaterThanOrEqualTo(Integer value) {
            addCriterion("good_protein_evaluation >=", value, "goodProteinEvaluation");
            return (Criteria) this;
        }

        public Criteria andGoodProteinEvaluationLessThan(Integer value) {
            addCriterion("good_protein_evaluation <", value, "goodProteinEvaluation");
            return (Criteria) this;
        }

        public Criteria andGoodProteinEvaluationLessThanOrEqualTo(Integer value) {
            addCriterion("good_protein_evaluation <=", value, "goodProteinEvaluation");
            return (Criteria) this;
        }

        public Criteria andGoodProteinEvaluationIn(List<Integer> values) {
            addCriterion("good_protein_evaluation in", values, "goodProteinEvaluation");
            return (Criteria) this;
        }

        public Criteria andGoodProteinEvaluationNotIn(List<Integer> values) {
            addCriterion("good_protein_evaluation not in", values, "goodProteinEvaluation");
            return (Criteria) this;
        }

        public Criteria andGoodProteinEvaluationBetween(Integer value1, Integer value2) {
            addCriterion("good_protein_evaluation between", value1, value2, "goodProteinEvaluation");
            return (Criteria) this;
        }

        public Criteria andGoodProteinEvaluationNotBetween(Integer value1, Integer value2) {
            addCriterion("good_protein_evaluation not between", value1, value2, "goodProteinEvaluation");
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