package com.trilemon.top.boss360.shelf.model;

import java.util.ArrayList;
import java.util.List;

public class PlanSettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlanSettingExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(Integer value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(Integer value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(Integer value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(Integer value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(Integer value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(Integer value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<Integer> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<Integer> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(Integer value1, Integer value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(Integer value1, Integer value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andExcludeKeywordsIsNull() {
            addCriterion("exclude_keywords is null");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsIsNotNull() {
            addCriterion("exclude_keywords is not null");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsEqualTo(Integer value) {
            addCriterion("exclude_keywords =", value, "excludeKeywords");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsNotEqualTo(Integer value) {
            addCriterion("exclude_keywords <>", value, "excludeKeywords");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsGreaterThan(Integer value) {
            addCriterion("exclude_keywords >", value, "excludeKeywords");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsGreaterThanOrEqualTo(Integer value) {
            addCriterion("exclude_keywords >=", value, "excludeKeywords");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsLessThan(Integer value) {
            addCriterion("exclude_keywords <", value, "excludeKeywords");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsLessThanOrEqualTo(Integer value) {
            addCriterion("exclude_keywords <=", value, "excludeKeywords");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsIn(List<Integer> values) {
            addCriterion("exclude_keywords in", values, "excludeKeywords");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsNotIn(List<Integer> values) {
            addCriterion("exclude_keywords not in", values, "excludeKeywords");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsBetween(Integer value1, Integer value2) {
            addCriterion("exclude_keywords between", value1, value2, "excludeKeywords");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsNotBetween(Integer value1, Integer value2) {
            addCriterion("exclude_keywords not between", value1, value2, "excludeKeywords");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsIsNull() {
            addCriterion("exclude_item_iids is null");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsIsNotNull() {
            addCriterion("exclude_item_iids is not null");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsEqualTo(Integer value) {
            addCriterion("exclude_item_iids =", value, "excludeItemIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsNotEqualTo(Integer value) {
            addCriterion("exclude_item_iids <>", value, "excludeItemIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsGreaterThan(Integer value) {
            addCriterion("exclude_item_iids >", value, "excludeItemIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsGreaterThanOrEqualTo(Integer value) {
            addCriterion("exclude_item_iids >=", value, "excludeItemIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsLessThan(Integer value) {
            addCriterion("exclude_item_iids <", value, "excludeItemIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsLessThanOrEqualTo(Integer value) {
            addCriterion("exclude_item_iids <=", value, "excludeItemIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsIn(List<Integer> values) {
            addCriterion("exclude_item_iids in", values, "excludeItemIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsNotIn(List<Integer> values) {
            addCriterion("exclude_item_iids not in", values, "excludeItemIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsBetween(Integer value1, Integer value2) {
            addCriterion("exclude_item_iids between", value1, value2, "excludeItemIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsNotBetween(Integer value1, Integer value2) {
            addCriterion("exclude_item_iids not between", value1, value2, "excludeItemIids");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsIsNull() {
            addCriterion("include_cids is null");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsIsNotNull() {
            addCriterion("include_cids is not null");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsEqualTo(Integer value) {
            addCriterion("include_cids =", value, "includeCids");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsNotEqualTo(Integer value) {
            addCriterion("include_cids <>", value, "includeCids");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsGreaterThan(Integer value) {
            addCriterion("include_cids >", value, "includeCids");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsGreaterThanOrEqualTo(Integer value) {
            addCriterion("include_cids >=", value, "includeCids");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsLessThan(Integer value) {
            addCriterion("include_cids <", value, "includeCids");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsLessThanOrEqualTo(Integer value) {
            addCriterion("include_cids <=", value, "includeCids");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsIn(List<Integer> values) {
            addCriterion("include_cids in", values, "includeCids");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsNotIn(List<Integer> values) {
            addCriterion("include_cids not in", values, "includeCids");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsBetween(Integer value1, Integer value2) {
            addCriterion("include_cids between", value1, value2, "includeCids");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsNotBetween(Integer value1, Integer value2) {
            addCriterion("include_cids not between", value1, value2, "includeCids");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsIsNull() {
            addCriterion("include_keywords is null");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsIsNotNull() {
            addCriterion("include_keywords is not null");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsEqualTo(Integer value) {
            addCriterion("include_keywords =", value, "includeKeywords");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsNotEqualTo(Integer value) {
            addCriterion("include_keywords <>", value, "includeKeywords");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsGreaterThan(Integer value) {
            addCriterion("include_keywords >", value, "includeKeywords");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsGreaterThanOrEqualTo(Integer value) {
            addCriterion("include_keywords >=", value, "includeKeywords");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsLessThan(Integer value) {
            addCriterion("include_keywords <", value, "includeKeywords");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsLessThanOrEqualTo(Integer value) {
            addCriterion("include_keywords <=", value, "includeKeywords");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsIn(List<Integer> values) {
            addCriterion("include_keywords in", values, "includeKeywords");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsNotIn(List<Integer> values) {
            addCriterion("include_keywords not in", values, "includeKeywords");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsBetween(Integer value1, Integer value2) {
            addCriterion("include_keywords between", value1, value2, "includeKeywords");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsNotBetween(Integer value1, Integer value2) {
            addCriterion("include_keywords not between", value1, value2, "includeKeywords");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsIsNull() {
            addCriterion("include_item_iids is null");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsIsNotNull() {
            addCriterion("include_item_iids is not null");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsEqualTo(Integer value) {
            addCriterion("include_item_iids =", value, "includeItemIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsNotEqualTo(Integer value) {
            addCriterion("include_item_iids <>", value, "includeItemIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsGreaterThan(Integer value) {
            addCriterion("include_item_iids >", value, "includeItemIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsGreaterThanOrEqualTo(Integer value) {
            addCriterion("include_item_iids >=", value, "includeItemIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsLessThan(Integer value) {
            addCriterion("include_item_iids <", value, "includeItemIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsLessThanOrEqualTo(Integer value) {
            addCriterion("include_item_iids <=", value, "includeItemIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsIn(List<Integer> values) {
            addCriterion("include_item_iids in", values, "includeItemIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsNotIn(List<Integer> values) {
            addCriterion("include_item_iids not in", values, "includeItemIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsBetween(Integer value1, Integer value2) {
            addCriterion("include_item_iids between", value1, value2, "includeItemIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsNotBetween(Integer value1, Integer value2) {
            addCriterion("include_item_iids not between", value1, value2, "includeItemIids");
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

        public Criteria andAddTimeEqualTo(Integer value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Integer value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Integer value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Integer value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Integer value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Integer> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Integer> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Integer value1, Integer value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Integer value1, Integer value2) {
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

        public Criteria andUpdTimeEqualTo(Integer value) {
            addCriterion("upd_time =", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotEqualTo(Integer value) {
            addCriterion("upd_time <>", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThan(Integer value) {
            addCriterion("upd_time >", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("upd_time >=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThan(Integer value) {
            addCriterion("upd_time <", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThanOrEqualTo(Integer value) {
            addCriterion("upd_time <=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIn(List<Integer> values) {
            addCriterion("upd_time in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotIn(List<Integer> values) {
            addCriterion("upd_time not in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeBetween(Integer value1, Integer value2) {
            addCriterion("upd_time between", value1, value2, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotBetween(Integer value1, Integer value2) {
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