package com.trilemon.top.boss360.base.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaobaoApiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaobaoApiExample() {
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

        public Criteria andServicenameIsNull() {
            addCriterion("serviceName is null");
            return (Criteria) this;
        }

        public Criteria andServicenameIsNotNull() {
            addCriterion("serviceName is not null");
            return (Criteria) this;
        }

        public Criteria andServicenameEqualTo(String value) {
            addCriterion("serviceName =", value, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameNotEqualTo(String value) {
            addCriterion("serviceName <>", value, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameGreaterThan(String value) {
            addCriterion("serviceName >", value, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameGreaterThanOrEqualTo(String value) {
            addCriterion("serviceName >=", value, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameLessThan(String value) {
            addCriterion("serviceName <", value, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameLessThanOrEqualTo(String value) {
            addCriterion("serviceName <=", value, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameLike(String value) {
            addCriterion("serviceName like", value, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameNotLike(String value) {
            addCriterion("serviceName not like", value, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameIn(List<String> values) {
            addCriterion("serviceName in", values, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameNotIn(List<String> values) {
            addCriterion("serviceName not in", values, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameBetween(String value1, String value2) {
            addCriterion("serviceName between", value1, value2, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameNotBetween(String value1, String value2) {
            addCriterion("serviceName not between", value1, value2, "servicename");
            return (Criteria) this;
        }

        public Criteria andServiceipIsNull() {
            addCriterion("serviceIp is null");
            return (Criteria) this;
        }

        public Criteria andServiceipIsNotNull() {
            addCriterion("serviceIp is not null");
            return (Criteria) this;
        }

        public Criteria andServiceipEqualTo(Long value) {
            addCriterion("serviceIp =", value, "serviceip");
            return (Criteria) this;
        }

        public Criteria andServiceipNotEqualTo(Long value) {
            addCriterion("serviceIp <>", value, "serviceip");
            return (Criteria) this;
        }

        public Criteria andServiceipGreaterThan(Long value) {
            addCriterion("serviceIp >", value, "serviceip");
            return (Criteria) this;
        }

        public Criteria andServiceipGreaterThanOrEqualTo(Long value) {
            addCriterion("serviceIp >=", value, "serviceip");
            return (Criteria) this;
        }

        public Criteria andServiceipLessThan(Long value) {
            addCriterion("serviceIp <", value, "serviceip");
            return (Criteria) this;
        }

        public Criteria andServiceipLessThanOrEqualTo(Long value) {
            addCriterion("serviceIp <=", value, "serviceip");
            return (Criteria) this;
        }

        public Criteria andServiceipIn(List<Long> values) {
            addCriterion("serviceIp in", values, "serviceip");
            return (Criteria) this;
        }

        public Criteria andServiceipNotIn(List<Long> values) {
            addCriterion("serviceIp not in", values, "serviceip");
            return (Criteria) this;
        }

        public Criteria andServiceipBetween(Long value1, Long value2) {
            addCriterion("serviceIp between", value1, value2, "serviceip");
            return (Criteria) this;
        }

        public Criteria andServiceipNotBetween(Long value1, Long value2) {
            addCriterion("serviceIp not between", value1, value2, "serviceip");
            return (Criteria) this;
        }

        public Criteria andTapbapAppKeyIsNull() {
            addCriterion("tapbap_app_key is null");
            return (Criteria) this;
        }

        public Criteria andTapbapAppKeyIsNotNull() {
            addCriterion("tapbap_app_key is not null");
            return (Criteria) this;
        }

        public Criteria andTapbapAppKeyEqualTo(String value) {
            addCriterion("tapbap_app_key =", value, "tapbapAppKey");
            return (Criteria) this;
        }

        public Criteria andTapbapAppKeyNotEqualTo(String value) {
            addCriterion("tapbap_app_key <>", value, "tapbapAppKey");
            return (Criteria) this;
        }

        public Criteria andTapbapAppKeyGreaterThan(String value) {
            addCriterion("tapbap_app_key >", value, "tapbapAppKey");
            return (Criteria) this;
        }

        public Criteria andTapbapAppKeyGreaterThanOrEqualTo(String value) {
            addCriterion("tapbap_app_key >=", value, "tapbapAppKey");
            return (Criteria) this;
        }

        public Criteria andTapbapAppKeyLessThan(String value) {
            addCriterion("tapbap_app_key <", value, "tapbapAppKey");
            return (Criteria) this;
        }

        public Criteria andTapbapAppKeyLessThanOrEqualTo(String value) {
            addCriterion("tapbap_app_key <=", value, "tapbapAppKey");
            return (Criteria) this;
        }

        public Criteria andTapbapAppKeyLike(String value) {
            addCriterion("tapbap_app_key like", value, "tapbapAppKey");
            return (Criteria) this;
        }

        public Criteria andTapbapAppKeyNotLike(String value) {
            addCriterion("tapbap_app_key not like", value, "tapbapAppKey");
            return (Criteria) this;
        }

        public Criteria andTapbapAppKeyIn(List<String> values) {
            addCriterion("tapbap_app_key in", values, "tapbapAppKey");
            return (Criteria) this;
        }

        public Criteria andTapbapAppKeyNotIn(List<String> values) {
            addCriterion("tapbap_app_key not in", values, "tapbapAppKey");
            return (Criteria) this;
        }

        public Criteria andTapbapAppKeyBetween(String value1, String value2) {
            addCriterion("tapbap_app_key between", value1, value2, "tapbapAppKey");
            return (Criteria) this;
        }

        public Criteria andTapbapAppKeyNotBetween(String value1, String value2) {
            addCriterion("tapbap_app_key not between", value1, value2, "tapbapAppKey");
            return (Criteria) this;
        }

        public Criteria andApiNameIsNull() {
            addCriterion("api_name is null");
            return (Criteria) this;
        }

        public Criteria andApiNameIsNotNull() {
            addCriterion("api_name is not null");
            return (Criteria) this;
        }

        public Criteria andApiNameEqualTo(String value) {
            addCriterion("api_name =", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotEqualTo(String value) {
            addCriterion("api_name <>", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameGreaterThan(String value) {
            addCriterion("api_name >", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameGreaterThanOrEqualTo(String value) {
            addCriterion("api_name >=", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLessThan(String value) {
            addCriterion("api_name <", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLessThanOrEqualTo(String value) {
            addCriterion("api_name <=", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLike(String value) {
            addCriterion("api_name like", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotLike(String value) {
            addCriterion("api_name not like", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameIn(List<String> values) {
            addCriterion("api_name in", values, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotIn(List<String> values) {
            addCriterion("api_name not in", values, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameBetween(String value1, String value2) {
            addCriterion("api_name between", value1, value2, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotBetween(String value1, String value2) {
            addCriterion("api_name not between", value1, value2, "apiName");
            return (Criteria) this;
        }

        public Criteria andSuccessfulCallIsNull() {
            addCriterion("successful_call is null");
            return (Criteria) this;
        }

        public Criteria andSuccessfulCallIsNotNull() {
            addCriterion("successful_call is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessfulCallEqualTo(Long value) {
            addCriterion("successful_call =", value, "successfulCall");
            return (Criteria) this;
        }

        public Criteria andSuccessfulCallNotEqualTo(Long value) {
            addCriterion("successful_call <>", value, "successfulCall");
            return (Criteria) this;
        }

        public Criteria andSuccessfulCallGreaterThan(Long value) {
            addCriterion("successful_call >", value, "successfulCall");
            return (Criteria) this;
        }

        public Criteria andSuccessfulCallGreaterThanOrEqualTo(Long value) {
            addCriterion("successful_call >=", value, "successfulCall");
            return (Criteria) this;
        }

        public Criteria andSuccessfulCallLessThan(Long value) {
            addCriterion("successful_call <", value, "successfulCall");
            return (Criteria) this;
        }

        public Criteria andSuccessfulCallLessThanOrEqualTo(Long value) {
            addCriterion("successful_call <=", value, "successfulCall");
            return (Criteria) this;
        }

        public Criteria andSuccessfulCallIn(List<Long> values) {
            addCriterion("successful_call in", values, "successfulCall");
            return (Criteria) this;
        }

        public Criteria andSuccessfulCallNotIn(List<Long> values) {
            addCriterion("successful_call not in", values, "successfulCall");
            return (Criteria) this;
        }

        public Criteria andSuccessfulCallBetween(Long value1, Long value2) {
            addCriterion("successful_call between", value1, value2, "successfulCall");
            return (Criteria) this;
        }

        public Criteria andSuccessfulCallNotBetween(Long value1, Long value2) {
            addCriterion("successful_call not between", value1, value2, "successfulCall");
            return (Criteria) this;
        }

        public Criteria andFailedCallIsNull() {
            addCriterion("failed_call is null");
            return (Criteria) this;
        }

        public Criteria andFailedCallIsNotNull() {
            addCriterion("failed_call is not null");
            return (Criteria) this;
        }

        public Criteria andFailedCallEqualTo(Long value) {
            addCriterion("failed_call =", value, "failedCall");
            return (Criteria) this;
        }

        public Criteria andFailedCallNotEqualTo(Long value) {
            addCriterion("failed_call <>", value, "failedCall");
            return (Criteria) this;
        }

        public Criteria andFailedCallGreaterThan(Long value) {
            addCriterion("failed_call >", value, "failedCall");
            return (Criteria) this;
        }

        public Criteria andFailedCallGreaterThanOrEqualTo(Long value) {
            addCriterion("failed_call >=", value, "failedCall");
            return (Criteria) this;
        }

        public Criteria andFailedCallLessThan(Long value) {
            addCriterion("failed_call <", value, "failedCall");
            return (Criteria) this;
        }

        public Criteria andFailedCallLessThanOrEqualTo(Long value) {
            addCriterion("failed_call <=", value, "failedCall");
            return (Criteria) this;
        }

        public Criteria andFailedCallIn(List<Long> values) {
            addCriterion("failed_call in", values, "failedCall");
            return (Criteria) this;
        }

        public Criteria andFailedCallNotIn(List<Long> values) {
            addCriterion("failed_call not in", values, "failedCall");
            return (Criteria) this;
        }

        public Criteria andFailedCallBetween(Long value1, Long value2) {
            addCriterion("failed_call between", value1, value2, "failedCall");
            return (Criteria) this;
        }

        public Criteria andFailedCallNotBetween(Long value1, Long value2) {
            addCriterion("failed_call not between", value1, value2, "failedCall");
            return (Criteria) this;
        }

        public Criteria andAvgExecTimeIsNull() {
            addCriterion("avg_exec_time is null");
            return (Criteria) this;
        }

        public Criteria andAvgExecTimeIsNotNull() {
            addCriterion("avg_exec_time is not null");
            return (Criteria) this;
        }

        public Criteria andAvgExecTimeEqualTo(Integer value) {
            addCriterion("avg_exec_time =", value, "avgExecTime");
            return (Criteria) this;
        }

        public Criteria andAvgExecTimeNotEqualTo(Integer value) {
            addCriterion("avg_exec_time <>", value, "avgExecTime");
            return (Criteria) this;
        }

        public Criteria andAvgExecTimeGreaterThan(Integer value) {
            addCriterion("avg_exec_time >", value, "avgExecTime");
            return (Criteria) this;
        }

        public Criteria andAvgExecTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("avg_exec_time >=", value, "avgExecTime");
            return (Criteria) this;
        }

        public Criteria andAvgExecTimeLessThan(Integer value) {
            addCriterion("avg_exec_time <", value, "avgExecTime");
            return (Criteria) this;
        }

        public Criteria andAvgExecTimeLessThanOrEqualTo(Integer value) {
            addCriterion("avg_exec_time <=", value, "avgExecTime");
            return (Criteria) this;
        }

        public Criteria andAvgExecTimeIn(List<Integer> values) {
            addCriterion("avg_exec_time in", values, "avgExecTime");
            return (Criteria) this;
        }

        public Criteria andAvgExecTimeNotIn(List<Integer> values) {
            addCriterion("avg_exec_time not in", values, "avgExecTime");
            return (Criteria) this;
        }

        public Criteria andAvgExecTimeBetween(Integer value1, Integer value2) {
            addCriterion("avg_exec_time between", value1, value2, "avgExecTime");
            return (Criteria) this;
        }

        public Criteria andAvgExecTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("avg_exec_time not between", value1, value2, "avgExecTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNull() {
            addCriterion("upd_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNotNull() {
            addCriterion("upd_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeEqualTo(Date value) {
            addCriterion("upd_time =", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotEqualTo(Date value) {
            addCriterion("upd_time <>", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThan(Date value) {
            addCriterion("upd_time >", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("upd_time >=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThan(Date value) {
            addCriterion("upd_time <", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThanOrEqualTo(Date value) {
            addCriterion("upd_time <=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIn(List<Date> values) {
            addCriterion("upd_time in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotIn(List<Date> values) {
            addCriterion("upd_time not in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeBetween(Date value1, Date value2) {
            addCriterion("upd_time between", value1, value2, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotBetween(Date value1, Date value2) {
            addCriterion("upd_time not between", value1, value2, "updTime");
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