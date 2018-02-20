package com.ahpu.entity;

import java.util.ArrayList;
import java.util.List;

public class TitleSubmitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TitleSubmitExample() {
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

        public Criteria andTitleidIsNull() {
            addCriterion("titleId is null");
            return (Criteria) this;
        }

        public Criteria andTitleidIsNotNull() {
            addCriterion("titleId is not null");
            return (Criteria) this;
        }

        public Criteria andTitleidEqualTo(Integer value) {
            addCriterion("titleId =", value, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidNotEqualTo(Integer value) {
            addCriterion("titleId <>", value, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidGreaterThan(Integer value) {
            addCriterion("titleId >", value, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("titleId >=", value, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidLessThan(Integer value) {
            addCriterion("titleId <", value, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidLessThanOrEqualTo(Integer value) {
            addCriterion("titleId <=", value, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidIn(List<Integer> values) {
            addCriterion("titleId in", values, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidNotIn(List<Integer> values) {
            addCriterion("titleId not in", values, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidBetween(Integer value1, Integer value2) {
            addCriterion("titleId between", value1, value2, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidNotBetween(Integer value1, Integer value2) {
            addCriterion("titleId not between", value1, value2, "titleid");
            return (Criteria) this;
        }

        public Criteria andSubmittimesIsNull() {
            addCriterion("submitTimes is null");
            return (Criteria) this;
        }

        public Criteria andSubmittimesIsNotNull() {
            addCriterion("submitTimes is not null");
            return (Criteria) this;
        }

        public Criteria andSubmittimesEqualTo(Integer value) {
            addCriterion("submitTimes =", value, "submittimes");
            return (Criteria) this;
        }

        public Criteria andSubmittimesNotEqualTo(Integer value) {
            addCriterion("submitTimes <>", value, "submittimes");
            return (Criteria) this;
        }

        public Criteria andSubmittimesGreaterThan(Integer value) {
            addCriterion("submitTimes >", value, "submittimes");
            return (Criteria) this;
        }

        public Criteria andSubmittimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("submitTimes >=", value, "submittimes");
            return (Criteria) this;
        }

        public Criteria andSubmittimesLessThan(Integer value) {
            addCriterion("submitTimes <", value, "submittimes");
            return (Criteria) this;
        }

        public Criteria andSubmittimesLessThanOrEqualTo(Integer value) {
            addCriterion("submitTimes <=", value, "submittimes");
            return (Criteria) this;
        }

        public Criteria andSubmittimesIn(List<Integer> values) {
            addCriterion("submitTimes in", values, "submittimes");
            return (Criteria) this;
        }

        public Criteria andSubmittimesNotIn(List<Integer> values) {
            addCriterion("submitTimes not in", values, "submittimes");
            return (Criteria) this;
        }

        public Criteria andSubmittimesBetween(Integer value1, Integer value2) {
            addCriterion("submitTimes between", value1, value2, "submittimes");
            return (Criteria) this;
        }

        public Criteria andSubmittimesNotBetween(Integer value1, Integer value2) {
            addCriterion("submitTimes not between", value1, value2, "submittimes");
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