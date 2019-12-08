package com.dbmysql.entity;

import java.util.ArrayList;
import java.util.List;

public class PayAccountNotifyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitLength = -1;

    public PayAccountNotifyExample() {
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

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitLength(int limitLength) {
        this.limitLength=limitLength;
    }

    public int getLimitLength() {
        return limitLength;
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

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andNotifyIsNull() {
            addCriterion("`notify` is null");
            return (Criteria) this;
        }

        public Criteria andNotifyIsNotNull() {
            addCriterion("`notify` is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyEqualTo(String value) {
            addCriterion("`notify` =", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyNotEqualTo(String value) {
            addCriterion("`notify` <>", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyGreaterThan(String value) {
            addCriterion("`notify` >", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyGreaterThanOrEqualTo(String value) {
            addCriterion("`notify` >=", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyLessThan(String value) {
            addCriterion("`notify` <", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyLessThanOrEqualTo(String value) {
            addCriterion("`notify` <=", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyLike(String value) {
            addCriterion("`notify` like", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyNotLike(String value) {
            addCriterion("`notify` not like", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyIn(List<String> values) {
            addCriterion("`notify` in", values, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyNotIn(List<String> values) {
            addCriterion("`notify` not in", values, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyBetween(String value1, String value2) {
            addCriterion("`notify` between", value1, value2, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyNotBetween(String value1, String value2) {
            addCriterion("`notify` not between", value1, value2, "notify");
            return (Criteria) this;
        }

        public Criteria andShowTypeIsNull() {
            addCriterion("show_type is null");
            return (Criteria) this;
        }

        public Criteria andShowTypeIsNotNull() {
            addCriterion("show_type is not null");
            return (Criteria) this;
        }

        public Criteria andShowTypeEqualTo(Integer value) {
            addCriterion("show_type =", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeNotEqualTo(Integer value) {
            addCriterion("show_type <>", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeGreaterThan(Integer value) {
            addCriterion("show_type >", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_type >=", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeLessThan(Integer value) {
            addCriterion("show_type <", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeLessThanOrEqualTo(Integer value) {
            addCriterion("show_type <=", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeIn(List<Integer> values) {
            addCriterion("show_type in", values, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeNotIn(List<Integer> values) {
            addCriterion("show_type not in", values, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeBetween(Integer value1, Integer value2) {
            addCriterion("show_type between", value1, value2, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("show_type not between", value1, value2, "showType");
            return (Criteria) this;
        }

        public Criteria andStatisticNotifyIsNull() {
            addCriterion("statistic_notify is null");
            return (Criteria) this;
        }

        public Criteria andStatisticNotifyIsNotNull() {
            addCriterion("statistic_notify is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticNotifyEqualTo(String value) {
            addCriterion("statistic_notify =", value, "statisticNotify");
            return (Criteria) this;
        }

        public Criteria andStatisticNotifyNotEqualTo(String value) {
            addCriterion("statistic_notify <>", value, "statisticNotify");
            return (Criteria) this;
        }

        public Criteria andStatisticNotifyGreaterThan(String value) {
            addCriterion("statistic_notify >", value, "statisticNotify");
            return (Criteria) this;
        }

        public Criteria andStatisticNotifyGreaterThanOrEqualTo(String value) {
            addCriterion("statistic_notify >=", value, "statisticNotify");
            return (Criteria) this;
        }

        public Criteria andStatisticNotifyLessThan(String value) {
            addCriterion("statistic_notify <", value, "statisticNotify");
            return (Criteria) this;
        }

        public Criteria andStatisticNotifyLessThanOrEqualTo(String value) {
            addCriterion("statistic_notify <=", value, "statisticNotify");
            return (Criteria) this;
        }

        public Criteria andStatisticNotifyLike(String value) {
            addCriterion("statistic_notify like", value, "statisticNotify");
            return (Criteria) this;
        }

        public Criteria andStatisticNotifyNotLike(String value) {
            addCriterion("statistic_notify not like", value, "statisticNotify");
            return (Criteria) this;
        }

        public Criteria andStatisticNotifyIn(List<String> values) {
            addCriterion("statistic_notify in", values, "statisticNotify");
            return (Criteria) this;
        }

        public Criteria andStatisticNotifyNotIn(List<String> values) {
            addCriterion("statistic_notify not in", values, "statisticNotify");
            return (Criteria) this;
        }

        public Criteria andStatisticNotifyBetween(String value1, String value2) {
            addCriterion("statistic_notify between", value1, value2, "statisticNotify");
            return (Criteria) this;
        }

        public Criteria andStatisticNotifyNotBetween(String value1, String value2) {
            addCriterion("statistic_notify not between", value1, value2, "statisticNotify");
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