package com.bkit.fatdown.entity;

import java.util.ArrayList;
import java.util.List;

public class TbQuestionBasicExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_question_basic
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_question_basic
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_question_basic
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_question_basic
     *
     * @mbg.generated
     */
    public TbQuestionBasicExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_question_basic
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_question_basic
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_question_basic
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_question_basic
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_question_basic
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_question_basic
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_question_basic
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_question_basic
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_question_basic
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_question_basic
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tb_question_basic
     *
     * @mbg.generated
     */
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

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andOptionaIsNull() {
            addCriterion("optionA is null");
            return (Criteria) this;
        }

        public Criteria andOptionaIsNotNull() {
            addCriterion("optionA is not null");
            return (Criteria) this;
        }

        public Criteria andOptionaEqualTo(String value) {
            addCriterion("optionA =", value, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaNotEqualTo(String value) {
            addCriterion("optionA <>", value, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaGreaterThan(String value) {
            addCriterion("optionA >", value, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaGreaterThanOrEqualTo(String value) {
            addCriterion("optionA >=", value, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaLessThan(String value) {
            addCriterion("optionA <", value, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaLessThanOrEqualTo(String value) {
            addCriterion("optionA <=", value, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaLike(String value) {
            addCriterion("optionA like", value, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaNotLike(String value) {
            addCriterion("optionA not like", value, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaIn(List<String> values) {
            addCriterion("optionA in", values, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaNotIn(List<String> values) {
            addCriterion("optionA not in", values, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaBetween(String value1, String value2) {
            addCriterion("optionA between", value1, value2, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaNotBetween(String value1, String value2) {
            addCriterion("optionA not between", value1, value2, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionbIsNull() {
            addCriterion("optionB is null");
            return (Criteria) this;
        }

        public Criteria andOptionbIsNotNull() {
            addCriterion("optionB is not null");
            return (Criteria) this;
        }

        public Criteria andOptionbEqualTo(String value) {
            addCriterion("optionB =", value, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbNotEqualTo(String value) {
            addCriterion("optionB <>", value, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbGreaterThan(String value) {
            addCriterion("optionB >", value, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbGreaterThanOrEqualTo(String value) {
            addCriterion("optionB >=", value, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbLessThan(String value) {
            addCriterion("optionB <", value, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbLessThanOrEqualTo(String value) {
            addCriterion("optionB <=", value, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbLike(String value) {
            addCriterion("optionB like", value, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbNotLike(String value) {
            addCriterion("optionB not like", value, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbIn(List<String> values) {
            addCriterion("optionB in", values, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbNotIn(List<String> values) {
            addCriterion("optionB not in", values, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbBetween(String value1, String value2) {
            addCriterion("optionB between", value1, value2, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbNotBetween(String value1, String value2) {
            addCriterion("optionB not between", value1, value2, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptioncIsNull() {
            addCriterion("optionC is null");
            return (Criteria) this;
        }

        public Criteria andOptioncIsNotNull() {
            addCriterion("optionC is not null");
            return (Criteria) this;
        }

        public Criteria andOptioncEqualTo(String value) {
            addCriterion("optionC =", value, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncNotEqualTo(String value) {
            addCriterion("optionC <>", value, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncGreaterThan(String value) {
            addCriterion("optionC >", value, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncGreaterThanOrEqualTo(String value) {
            addCriterion("optionC >=", value, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncLessThan(String value) {
            addCriterion("optionC <", value, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncLessThanOrEqualTo(String value) {
            addCriterion("optionC <=", value, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncLike(String value) {
            addCriterion("optionC like", value, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncNotLike(String value) {
            addCriterion("optionC not like", value, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncIn(List<String> values) {
            addCriterion("optionC in", values, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncNotIn(List<String> values) {
            addCriterion("optionC not in", values, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncBetween(String value1, String value2) {
            addCriterion("optionC between", value1, value2, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncNotBetween(String value1, String value2) {
            addCriterion("optionC not between", value1, value2, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptiondIsNull() {
            addCriterion("optionD is null");
            return (Criteria) this;
        }

        public Criteria andOptiondIsNotNull() {
            addCriterion("optionD is not null");
            return (Criteria) this;
        }

        public Criteria andOptiondEqualTo(String value) {
            addCriterion("optionD =", value, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondNotEqualTo(String value) {
            addCriterion("optionD <>", value, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondGreaterThan(String value) {
            addCriterion("optionD >", value, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondGreaterThanOrEqualTo(String value) {
            addCriterion("optionD >=", value, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondLessThan(String value) {
            addCriterion("optionD <", value, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondLessThanOrEqualTo(String value) {
            addCriterion("optionD <=", value, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondLike(String value) {
            addCriterion("optionD like", value, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondNotLike(String value) {
            addCriterion("optionD not like", value, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondIn(List<String> values) {
            addCriterion("optionD in", values, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondNotIn(List<String> values) {
            addCriterion("optionD not in", values, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondBetween(String value1, String value2) {
            addCriterion("optionD between", value1, value2, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondNotBetween(String value1, String value2) {
            addCriterion("optionD not between", value1, value2, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptioneIsNull() {
            addCriterion("optionE is null");
            return (Criteria) this;
        }

        public Criteria andOptioneIsNotNull() {
            addCriterion("optionE is not null");
            return (Criteria) this;
        }

        public Criteria andOptioneEqualTo(String value) {
            addCriterion("optionE =", value, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneNotEqualTo(String value) {
            addCriterion("optionE <>", value, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneGreaterThan(String value) {
            addCriterion("optionE >", value, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneGreaterThanOrEqualTo(String value) {
            addCriterion("optionE >=", value, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneLessThan(String value) {
            addCriterion("optionE <", value, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneLessThanOrEqualTo(String value) {
            addCriterion("optionE <=", value, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneLike(String value) {
            addCriterion("optionE like", value, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneNotLike(String value) {
            addCriterion("optionE not like", value, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneIn(List<String> values) {
            addCriterion("optionE in", values, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneNotIn(List<String> values) {
            addCriterion("optionE not in", values, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneBetween(String value1, String value2) {
            addCriterion("optionE between", value1, value2, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneNotBetween(String value1, String value2) {
            addCriterion("optionE not between", value1, value2, "optione");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("value is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("value is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(Double value) {
            addCriterion("value =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(Double value) {
            addCriterion("value <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(Double value) {
            addCriterion("value >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(Double value) {
            addCriterion("value >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(Double value) {
            addCriterion("value <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(Double value) {
            addCriterion("value <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<Double> values) {
            addCriterion("value in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<Double> values) {
            addCriterion("value not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(Double value1, Double value2) {
            addCriterion("value between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(Double value1, Double value2) {
            addCriterion("value not between", value1, value2, "value");
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

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tb_question_basic
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tb_question_basic
     *
     * @mbg.generated
     */
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