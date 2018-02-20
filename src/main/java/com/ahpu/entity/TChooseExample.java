package com.ahpu.entity;

import java.util.ArrayList;
import java.util.List;

public class TChooseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TChooseExample() {
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

        public Criteria andCidIsNull() {
            addCriterion("cId is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cId is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cId =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cId <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cId >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cId >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cId <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cId <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cId in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cId not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cId between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cId not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andQidIsNull() {
            addCriterion("qId is null");
            return (Criteria) this;
        }

        public Criteria andQidIsNotNull() {
            addCriterion("qId is not null");
            return (Criteria) this;
        }

        public Criteria andQidEqualTo(Integer value) {
            addCriterion("qId =", value, "qid");
            return (Criteria) this;
        }

        public Criteria andQidNotEqualTo(Integer value) {
            addCriterion("qId <>", value, "qid");
            return (Criteria) this;
        }

        public Criteria andQidGreaterThan(Integer value) {
            addCriterion("qId >", value, "qid");
            return (Criteria) this;
        }

        public Criteria andQidGreaterThanOrEqualTo(Integer value) {
            addCriterion("qId >=", value, "qid");
            return (Criteria) this;
        }

        public Criteria andQidLessThan(Integer value) {
            addCriterion("qId <", value, "qid");
            return (Criteria) this;
        }

        public Criteria andQidLessThanOrEqualTo(Integer value) {
            addCriterion("qId <=", value, "qid");
            return (Criteria) this;
        }

        public Criteria andQidIn(List<Integer> values) {
            addCriterion("qId in", values, "qid");
            return (Criteria) this;
        }

        public Criteria andQidNotIn(List<Integer> values) {
            addCriterion("qId not in", values, "qid");
            return (Criteria) this;
        }

        public Criteria andQidBetween(Integer value1, Integer value2) {
            addCriterion("qId between", value1, value2, "qid");
            return (Criteria) this;
        }

        public Criteria andQidNotBetween(Integer value1, Integer value2) {
            addCriterion("qId not between", value1, value2, "qid");
            return (Criteria) this;
        }

        public Criteria andQuestionoptionIsNull() {
            addCriterion("questionoption is null");
            return (Criteria) this;
        }

        public Criteria andQuestionoptionIsNotNull() {
            addCriterion("questionoption is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionoptionEqualTo(String value) {
            addCriterion("questionoption =", value, "questionoption");
            return (Criteria) this;
        }

        public Criteria andQuestionoptionNotEqualTo(String value) {
            addCriterion("questionoption <>", value, "questionoption");
            return (Criteria) this;
        }

        public Criteria andQuestionoptionGreaterThan(String value) {
            addCriterion("questionoption >", value, "questionoption");
            return (Criteria) this;
        }

        public Criteria andQuestionoptionGreaterThanOrEqualTo(String value) {
            addCriterion("questionoption >=", value, "questionoption");
            return (Criteria) this;
        }

        public Criteria andQuestionoptionLessThan(String value) {
            addCriterion("questionoption <", value, "questionoption");
            return (Criteria) this;
        }

        public Criteria andQuestionoptionLessThanOrEqualTo(String value) {
            addCriterion("questionoption <=", value, "questionoption");
            return (Criteria) this;
        }

        public Criteria andQuestionoptionLike(String value) {
            addCriterion("questionoption like", value, "questionoption");
            return (Criteria) this;
        }

        public Criteria andQuestionoptionNotLike(String value) {
            addCriterion("questionoption not like", value, "questionoption");
            return (Criteria) this;
        }

        public Criteria andQuestionoptionIn(List<String> values) {
            addCriterion("questionoption in", values, "questionoption");
            return (Criteria) this;
        }

        public Criteria andQuestionoptionNotIn(List<String> values) {
            addCriterion("questionoption not in", values, "questionoption");
            return (Criteria) this;
        }

        public Criteria andQuestionoptionBetween(String value1, String value2) {
            addCriterion("questionoption between", value1, value2, "questionoption");
            return (Criteria) this;
        }

        public Criteria andQuestionoptionNotBetween(String value1, String value2) {
            addCriterion("questionoption not between", value1, value2, "questionoption");
            return (Criteria) this;
        }

        public Criteria andOptioncontentIsNull() {
            addCriterion("optionContent is null");
            return (Criteria) this;
        }

        public Criteria andOptioncontentIsNotNull() {
            addCriterion("optionContent is not null");
            return (Criteria) this;
        }

        public Criteria andOptioncontentEqualTo(String value) {
            addCriterion("optionContent =", value, "optioncontent");
            return (Criteria) this;
        }

        public Criteria andOptioncontentNotEqualTo(String value) {
            addCriterion("optionContent <>", value, "optioncontent");
            return (Criteria) this;
        }

        public Criteria andOptioncontentGreaterThan(String value) {
            addCriterion("optionContent >", value, "optioncontent");
            return (Criteria) this;
        }

        public Criteria andOptioncontentGreaterThanOrEqualTo(String value) {
            addCriterion("optionContent >=", value, "optioncontent");
            return (Criteria) this;
        }

        public Criteria andOptioncontentLessThan(String value) {
            addCriterion("optionContent <", value, "optioncontent");
            return (Criteria) this;
        }

        public Criteria andOptioncontentLessThanOrEqualTo(String value) {
            addCriterion("optionContent <=", value, "optioncontent");
            return (Criteria) this;
        }

        public Criteria andOptioncontentLike(String value) {
            addCriterion("optionContent like", value, "optioncontent");
            return (Criteria) this;
        }

        public Criteria andOptioncontentNotLike(String value) {
            addCriterion("optionContent not like", value, "optioncontent");
            return (Criteria) this;
        }

        public Criteria andOptioncontentIn(List<String> values) {
            addCriterion("optionContent in", values, "optioncontent");
            return (Criteria) this;
        }

        public Criteria andOptioncontentNotIn(List<String> values) {
            addCriterion("optionContent not in", values, "optioncontent");
            return (Criteria) this;
        }

        public Criteria andOptioncontentBetween(String value1, String value2) {
            addCriterion("optionContent between", value1, value2, "optioncontent");
            return (Criteria) this;
        }

        public Criteria andOptioncontentNotBetween(String value1, String value2) {
            addCriterion("optionContent not between", value1, value2, "optioncontent");
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