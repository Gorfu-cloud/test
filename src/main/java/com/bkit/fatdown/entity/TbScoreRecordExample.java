package com.bkit.fatdown.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbScoreRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbScoreRecordExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andUserIsNull() {
            addCriterion("user is null");
            return (Criteria) this;
        }

        public Criteria andUserIsNotNull() {
            addCriterion("user is not null");
            return (Criteria) this;
        }

        public Criteria andUserEqualTo(Integer value) {
            addCriterion("user =", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotEqualTo(Integer value) {
            addCriterion("user <>", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThan(Integer value) {
            addCriterion("user >", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("user >=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThan(Integer value) {
            addCriterion("user <", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThanOrEqualTo(Integer value) {
            addCriterion("user <=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserIn(List<Integer> values) {
            addCriterion("user in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotIn(List<Integer> values) {
            addCriterion("user not in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserBetween(Integer value1, Integer value2) {
            addCriterion("user between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotBetween(Integer value1, Integer value2) {
            addCriterion("user not between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andStartIsNull() {
            addCriterion("start is null");
            return (Criteria) this;
        }

        public Criteria andStartIsNotNull() {
            addCriterion("start is not null");
            return (Criteria) this;
        }

        public Criteria andStartEqualTo(Date value) {
            addCriterionForJDBCDate("start =", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotEqualTo(Date value) {
            addCriterionForJDBCDate("start <>", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartGreaterThan(Date value) {
            addCriterionForJDBCDate("start >", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start >=", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLessThan(Date value) {
            addCriterionForJDBCDate("start <", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start <=", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartIn(List<Date> values) {
            addCriterionForJDBCDate("start in", values, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotIn(List<Date> values) {
            addCriterionForJDBCDate("start not in", values, "start");
            return (Criteria) this;
        }

        public Criteria andStartBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start between", value1, value2, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start not between", value1, value2, "start");
            return (Criteria) this;
        }

        public Criteria andEndIsNull() {
            addCriterion("end is null");
            return (Criteria) this;
        }

        public Criteria andEndIsNotNull() {
            addCriterion("end is not null");
            return (Criteria) this;
        }

        public Criteria andEndEqualTo(Date value) {
            addCriterionForJDBCDate("end =", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotEqualTo(Date value) {
            addCriterionForJDBCDate("end <>", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndGreaterThan(Date value) {
            addCriterionForJDBCDate("end >", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end >=", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndLessThan(Date value) {
            addCriterionForJDBCDate("end <", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end <=", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndIn(List<Date> values) {
            addCriterionForJDBCDate("end in", values, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotIn(List<Date> values) {
            addCriterionForJDBCDate("end not in", values, "end");
            return (Criteria) this;
        }

        public Criteria andEndBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end between", value1, value2, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end not between", value1, value2, "end");
            return (Criteria) this;
        }

        public Criteria andDietIsNull() {
            addCriterion("diet is null");
            return (Criteria) this;
        }

        public Criteria andDietIsNotNull() {
            addCriterion("diet is not null");
            return (Criteria) this;
        }

        public Criteria andDietEqualTo(Double value) {
            addCriterion("diet =", value, "diet");
            return (Criteria) this;
        }

        public Criteria andDietNotEqualTo(Double value) {
            addCriterion("diet <>", value, "diet");
            return (Criteria) this;
        }

        public Criteria andDietGreaterThan(Double value) {
            addCriterion("diet >", value, "diet");
            return (Criteria) this;
        }

        public Criteria andDietGreaterThanOrEqualTo(Double value) {
            addCriterion("diet >=", value, "diet");
            return (Criteria) this;
        }

        public Criteria andDietLessThan(Double value) {
            addCriterion("diet <", value, "diet");
            return (Criteria) this;
        }

        public Criteria andDietLessThanOrEqualTo(Double value) {
            addCriterion("diet <=", value, "diet");
            return (Criteria) this;
        }

        public Criteria andDietIn(List<Double> values) {
            addCriterion("diet in", values, "diet");
            return (Criteria) this;
        }

        public Criteria andDietNotIn(List<Double> values) {
            addCriterion("diet not in", values, "diet");
            return (Criteria) this;
        }

        public Criteria andDietBetween(Double value1, Double value2) {
            addCriterion("diet between", value1, value2, "diet");
            return (Criteria) this;
        }

        public Criteria andDietNotBetween(Double value1, Double value2) {
            addCriterion("diet not between", value1, value2, "diet");
            return (Criteria) this;
        }

        public Criteria andSportIsNull() {
            addCriterion("sport is null");
            return (Criteria) this;
        }

        public Criteria andSportIsNotNull() {
            addCriterion("sport is not null");
            return (Criteria) this;
        }

        public Criteria andSportEqualTo(Double value) {
            addCriterion("sport =", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportNotEqualTo(Double value) {
            addCriterion("sport <>", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportGreaterThan(Double value) {
            addCriterion("sport >", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportGreaterThanOrEqualTo(Double value) {
            addCriterion("sport >=", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportLessThan(Double value) {
            addCriterion("sport <", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportLessThanOrEqualTo(Double value) {
            addCriterion("sport <=", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportIn(List<Double> values) {
            addCriterion("sport in", values, "sport");
            return (Criteria) this;
        }

        public Criteria andSportNotIn(List<Double> values) {
            addCriterion("sport not in", values, "sport");
            return (Criteria) this;
        }

        public Criteria andSportBetween(Double value1, Double value2) {
            addCriterion("sport between", value1, value2, "sport");
            return (Criteria) this;
        }

        public Criteria andSportNotBetween(Double value1, Double value2) {
            addCriterion("sport not between", value1, value2, "sport");
            return (Criteria) this;
        }

        public Criteria andLearnIsNull() {
            addCriterion("learn is null");
            return (Criteria) this;
        }

        public Criteria andLearnIsNotNull() {
            addCriterion("learn is not null");
            return (Criteria) this;
        }

        public Criteria andLearnEqualTo(Double value) {
            addCriterion("learn =", value, "learn");
            return (Criteria) this;
        }

        public Criteria andLearnNotEqualTo(Double value) {
            addCriterion("learn <>", value, "learn");
            return (Criteria) this;
        }

        public Criteria andLearnGreaterThan(Double value) {
            addCriterion("learn >", value, "learn");
            return (Criteria) this;
        }

        public Criteria andLearnGreaterThanOrEqualTo(Double value) {
            addCriterion("learn >=", value, "learn");
            return (Criteria) this;
        }

        public Criteria andLearnLessThan(Double value) {
            addCriterion("learn <", value, "learn");
            return (Criteria) this;
        }

        public Criteria andLearnLessThanOrEqualTo(Double value) {
            addCriterion("learn <=", value, "learn");
            return (Criteria) this;
        }

        public Criteria andLearnIn(List<Double> values) {
            addCriterion("learn in", values, "learn");
            return (Criteria) this;
        }

        public Criteria andLearnNotIn(List<Double> values) {
            addCriterion("learn not in", values, "learn");
            return (Criteria) this;
        }

        public Criteria andLearnBetween(Double value1, Double value2) {
            addCriterion("learn between", value1, value2, "learn");
            return (Criteria) this;
        }

        public Criteria andLearnNotBetween(Double value1, Double value2) {
            addCriterion("learn not between", value1, value2, "learn");
            return (Criteria) this;
        }

        public Criteria andTestIsNull() {
            addCriterion("test is null");
            return (Criteria) this;
        }

        public Criteria andTestIsNotNull() {
            addCriterion("test is not null");
            return (Criteria) this;
        }

        public Criteria andTestEqualTo(Double value) {
            addCriterion("test =", value, "test");
            return (Criteria) this;
        }

        public Criteria andTestNotEqualTo(Double value) {
            addCriterion("test <>", value, "test");
            return (Criteria) this;
        }

        public Criteria andTestGreaterThan(Double value) {
            addCriterion("test >", value, "test");
            return (Criteria) this;
        }

        public Criteria andTestGreaterThanOrEqualTo(Double value) {
            addCriterion("test >=", value, "test");
            return (Criteria) this;
        }

        public Criteria andTestLessThan(Double value) {
            addCriterion("test <", value, "test");
            return (Criteria) this;
        }

        public Criteria andTestLessThanOrEqualTo(Double value) {
            addCriterion("test <=", value, "test");
            return (Criteria) this;
        }

        public Criteria andTestIn(List<Double> values) {
            addCriterion("test in", values, "test");
            return (Criteria) this;
        }

        public Criteria andTestNotIn(List<Double> values) {
            addCriterion("test not in", values, "test");
            return (Criteria) this;
        }

        public Criteria andTestBetween(Double value1, Double value2) {
            addCriterion("test between", value1, value2, "test");
            return (Criteria) this;
        }

        public Criteria andTestNotBetween(Double value1, Double value2) {
            addCriterion("test not between", value1, value2, "test");
            return (Criteria) this;
        }

        public Criteria andActiveIsNull() {
            addCriterion("active is null");
            return (Criteria) this;
        }

        public Criteria andActiveIsNotNull() {
            addCriterion("active is not null");
            return (Criteria) this;
        }

        public Criteria andActiveEqualTo(Double value) {
            addCriterion("active =", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotEqualTo(Double value) {
            addCriterion("active <>", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThan(Double value) {
            addCriterion("active >", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThanOrEqualTo(Double value) {
            addCriterion("active >=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThan(Double value) {
            addCriterion("active <", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThanOrEqualTo(Double value) {
            addCriterion("active <=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveIn(List<Double> values) {
            addCriterion("active in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotIn(List<Double> values) {
            addCriterion("active not in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveBetween(Double value1, Double value2) {
            addCriterion("active between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotBetween(Double value1, Double value2) {
            addCriterion("active not between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andShareIsNull() {
            addCriterion("share is null");
            return (Criteria) this;
        }

        public Criteria andShareIsNotNull() {
            addCriterion("share is not null");
            return (Criteria) this;
        }

        public Criteria andShareEqualTo(Double value) {
            addCriterion("share =", value, "share");
            return (Criteria) this;
        }

        public Criteria andShareNotEqualTo(Double value) {
            addCriterion("share <>", value, "share");
            return (Criteria) this;
        }

        public Criteria andShareGreaterThan(Double value) {
            addCriterion("share >", value, "share");
            return (Criteria) this;
        }

        public Criteria andShareGreaterThanOrEqualTo(Double value) {
            addCriterion("share >=", value, "share");
            return (Criteria) this;
        }

        public Criteria andShareLessThan(Double value) {
            addCriterion("share <", value, "share");
            return (Criteria) this;
        }

        public Criteria andShareLessThanOrEqualTo(Double value) {
            addCriterion("share <=", value, "share");
            return (Criteria) this;
        }

        public Criteria andShareIn(List<Double> values) {
            addCriterion("share in", values, "share");
            return (Criteria) this;
        }

        public Criteria andShareNotIn(List<Double> values) {
            addCriterion("share not in", values, "share");
            return (Criteria) this;
        }

        public Criteria andShareBetween(Double value1, Double value2) {
            addCriterion("share between", value1, value2, "share");
            return (Criteria) this;
        }

        public Criteria andShareNotBetween(Double value1, Double value2) {
            addCriterion("share not between", value1, value2, "share");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Double value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Double value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Double value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Double value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Double value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Double> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Double> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Double value1, Double value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Double value1, Double value2) {
            addCriterion("total not between", value1, value2, "total");
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