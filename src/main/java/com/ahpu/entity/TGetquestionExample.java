package com.ahpu.entity;

import java.util.ArrayList;
import java.util.List;

public class TGetquestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TGetquestionExample() {
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

        public Criteria andGetidIsNull() {
            addCriterion("getID is null");
            return (Criteria) this;
        }

        public Criteria andGetidIsNotNull() {
            addCriterion("getID is not null");
            return (Criteria) this;
        }

        public Criteria andGetidEqualTo(Integer value) {
            addCriterion("getID =", value, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidNotEqualTo(Integer value) {
            addCriterion("getID <>", value, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidGreaterThan(Integer value) {
            addCriterion("getID >", value, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidGreaterThanOrEqualTo(Integer value) {
            addCriterion("getID >=", value, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidLessThan(Integer value) {
            addCriterion("getID <", value, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidLessThanOrEqualTo(Integer value) {
            addCriterion("getID <=", value, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidIn(List<Integer> values) {
            addCriterion("getID in", values, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidNotIn(List<Integer> values) {
            addCriterion("getID not in", values, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidBetween(Integer value1, Integer value2) {
            addCriterion("getID between", value1, value2, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidNotBetween(Integer value1, Integer value2) {
            addCriterion("getID not between", value1, value2, "getid");
            return (Criteria) this;
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

        public Criteria andQuestionidIsNull() {
            addCriterion("questionId is null");
            return (Criteria) this;
        }

        public Criteria andQuestionidIsNotNull() {
            addCriterion("questionId is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionidEqualTo(Integer value) {
            addCriterion("questionId =", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotEqualTo(Integer value) {
            addCriterion("questionId <>", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidGreaterThan(Integer value) {
            addCriterion("questionId >", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("questionId >=", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidLessThan(Integer value) {
            addCriterion("questionId <", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidLessThanOrEqualTo(Integer value) {
            addCriterion("questionId <=", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidIn(List<Integer> values) {
            addCriterion("questionId in", values, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotIn(List<Integer> values) {
            addCriterion("questionId not in", values, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidBetween(Integer value1, Integer value2) {
            addCriterion("questionId between", value1, value2, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotBetween(Integer value1, Integer value2) {
            addCriterion("questionId not between", value1, value2, "questionid");
            return (Criteria) this;
        }

        public Criteria andChooseIsNull() {
            addCriterion("choose is null");
            return (Criteria) this;
        }

        public Criteria andChooseIsNotNull() {
            addCriterion("choose is not null");
            return (Criteria) this;
        }

        public Criteria andChooseEqualTo(String value) {
            addCriterion("choose =", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseNotEqualTo(String value) {
            addCriterion("choose <>", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseGreaterThan(String value) {
            addCriterion("choose >", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseGreaterThanOrEqualTo(String value) {
            addCriterion("choose >=", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseLessThan(String value) {
            addCriterion("choose <", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseLessThanOrEqualTo(String value) {
            addCriterion("choose <=", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseLike(String value) {
            addCriterion("choose like", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseNotLike(String value) {
            addCriterion("choose not like", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseIn(List<String> values) {
            addCriterion("choose in", values, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseNotIn(List<String> values) {
            addCriterion("choose not in", values, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseBetween(String value1, String value2) {
            addCriterion("choose between", value1, value2, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseNotBetween(String value1, String value2) {
            addCriterion("choose not between", value1, value2, "choose");
            return (Criteria) this;
        }

        public Criteria andSubmituserIsNull() {
            addCriterion("submitUser is null");
            return (Criteria) this;
        }

        public Criteria andSubmituserIsNotNull() {
            addCriterion("submitUser is not null");
            return (Criteria) this;
        }

        public Criteria andSubmituserEqualTo(String value) {
            addCriterion("submitUser =", value, "submituser");
            return (Criteria) this;
        }

        public Criteria andSubmituserNotEqualTo(String value) {
            addCriterion("submitUser <>", value, "submituser");
            return (Criteria) this;
        }

        public Criteria andSubmituserGreaterThan(String value) {
            addCriterion("submitUser >", value, "submituser");
            return (Criteria) this;
        }

        public Criteria andSubmituserGreaterThanOrEqualTo(String value) {
            addCriterion("submitUser >=", value, "submituser");
            return (Criteria) this;
        }

        public Criteria andSubmituserLessThan(String value) {
            addCriterion("submitUser <", value, "submituser");
            return (Criteria) this;
        }

        public Criteria andSubmituserLessThanOrEqualTo(String value) {
            addCriterion("submitUser <=", value, "submituser");
            return (Criteria) this;
        }

        public Criteria andSubmituserLike(String value) {
            addCriterion("submitUser like", value, "submituser");
            return (Criteria) this;
        }

        public Criteria andSubmituserNotLike(String value) {
            addCriterion("submitUser not like", value, "submituser");
            return (Criteria) this;
        }

        public Criteria andSubmituserIn(List<String> values) {
            addCriterion("submitUser in", values, "submituser");
            return (Criteria) this;
        }

        public Criteria andSubmituserNotIn(List<String> values) {
            addCriterion("submitUser not in", values, "submituser");
            return (Criteria) this;
        }

        public Criteria andSubmituserBetween(String value1, String value2) {
            addCriterion("submitUser between", value1, value2, "submituser");
            return (Criteria) this;
        }

        public Criteria andSubmituserNotBetween(String value1, String value2) {
            addCriterion("submitUser not between", value1, value2, "submituser");
            return (Criteria) this;
        }

        public Criteria andChoosenumIsNull() {
            addCriterion("chooseNum is null");
            return (Criteria) this;
        }

        public Criteria andChoosenumIsNotNull() {
            addCriterion("chooseNum is not null");
            return (Criteria) this;
        }

        public Criteria andChoosenumEqualTo(Integer value) {
            addCriterion("chooseNum =", value, "choosenum");
            return (Criteria) this;
        }

        public Criteria andChoosenumNotEqualTo(Integer value) {
            addCriterion("chooseNum <>", value, "choosenum");
            return (Criteria) this;
        }

        public Criteria andChoosenumGreaterThan(Integer value) {
            addCriterion("chooseNum >", value, "choosenum");
            return (Criteria) this;
        }

        public Criteria andChoosenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("chooseNum >=", value, "choosenum");
            return (Criteria) this;
        }

        public Criteria andChoosenumLessThan(Integer value) {
            addCriterion("chooseNum <", value, "choosenum");
            return (Criteria) this;
        }

        public Criteria andChoosenumLessThanOrEqualTo(Integer value) {
            addCriterion("chooseNum <=", value, "choosenum");
            return (Criteria) this;
        }

        public Criteria andChoosenumIn(List<Integer> values) {
            addCriterion("chooseNum in", values, "choosenum");
            return (Criteria) this;
        }

        public Criteria andChoosenumNotIn(List<Integer> values) {
            addCriterion("chooseNum not in", values, "choosenum");
            return (Criteria) this;
        }

        public Criteria andChoosenumBetween(Integer value1, Integer value2) {
            addCriterion("chooseNum between", value1, value2, "choosenum");
            return (Criteria) this;
        }

        public Criteria andChoosenumNotBetween(Integer value1, Integer value2) {
            addCriterion("chooseNum not between", value1, value2, "choosenum");
            return (Criteria) this;
        }

        public Criteria andIsmultipleIsNull() {
            addCriterion("isMultiple is null");
            return (Criteria) this;
        }

        public Criteria andIsmultipleIsNotNull() {
            addCriterion("isMultiple is not null");
            return (Criteria) this;
        }

        public Criteria andIsmultipleEqualTo(Integer value) {
            addCriterion("isMultiple =", value, "ismultiple");
            return (Criteria) this;
        }

        public Criteria andIsmultipleNotEqualTo(Integer value) {
            addCriterion("isMultiple <>", value, "ismultiple");
            return (Criteria) this;
        }

        public Criteria andIsmultipleGreaterThan(Integer value) {
            addCriterion("isMultiple >", value, "ismultiple");
            return (Criteria) this;
        }

        public Criteria andIsmultipleGreaterThanOrEqualTo(Integer value) {
            addCriterion("isMultiple >=", value, "ismultiple");
            return (Criteria) this;
        }

        public Criteria andIsmultipleLessThan(Integer value) {
            addCriterion("isMultiple <", value, "ismultiple");
            return (Criteria) this;
        }

        public Criteria andIsmultipleLessThanOrEqualTo(Integer value) {
            addCriterion("isMultiple <=", value, "ismultiple");
            return (Criteria) this;
        }

        public Criteria andIsmultipleIn(List<Integer> values) {
            addCriterion("isMultiple in", values, "ismultiple");
            return (Criteria) this;
        }

        public Criteria andIsmultipleNotIn(List<Integer> values) {
            addCriterion("isMultiple not in", values, "ismultiple");
            return (Criteria) this;
        }

        public Criteria andIsmultipleBetween(Integer value1, Integer value2) {
            addCriterion("isMultiple between", value1, value2, "ismultiple");
            return (Criteria) this;
        }

        public Criteria andIsmultipleNotBetween(Integer value1, Integer value2) {
            addCriterion("isMultiple not between", value1, value2, "ismultiple");
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