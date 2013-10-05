package com.trilemon.boss360.shelf.model;

import java.util.ArrayList;
import java.util.Date;
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
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

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
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

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNamePinyinIsNull() {
            addCriterion("name_pinyin is null");
            return (Criteria) this;
        }

        public Criteria andNamePinyinIsNotNull() {
            addCriterion("name_pinyin is not null");
            return (Criteria) this;
        }

        public Criteria andNamePinyinEqualTo(String value) {
            addCriterion("name_pinyin =", value, "namePinyin");
            return (Criteria) this;
        }

        public Criteria andNamePinyinNotEqualTo(String value) {
            addCriterion("name_pinyin <>", value, "namePinyin");
            return (Criteria) this;
        }

        public Criteria andNamePinyinGreaterThan(String value) {
            addCriterion("name_pinyin >", value, "namePinyin");
            return (Criteria) this;
        }

        public Criteria andNamePinyinGreaterThanOrEqualTo(String value) {
            addCriterion("name_pinyin >=", value, "namePinyin");
            return (Criteria) this;
        }

        public Criteria andNamePinyinLessThan(String value) {
            addCriterion("name_pinyin <", value, "namePinyin");
            return (Criteria) this;
        }

        public Criteria andNamePinyinLessThanOrEqualTo(String value) {
            addCriterion("name_pinyin <=", value, "namePinyin");
            return (Criteria) this;
        }

        public Criteria andNamePinyinLike(String value) {
            addCriterion("name_pinyin like", value, "namePinyin");
            return (Criteria) this;
        }

        public Criteria andNamePinyinNotLike(String value) {
            addCriterion("name_pinyin not like", value, "namePinyin");
            return (Criteria) this;
        }

        public Criteria andNamePinyinIn(List<String> values) {
            addCriterion("name_pinyin in", values, "namePinyin");
            return (Criteria) this;
        }

        public Criteria andNamePinyinNotIn(List<String> values) {
            addCriterion("name_pinyin not in", values, "namePinyin");
            return (Criteria) this;
        }

        public Criteria andNamePinyinBetween(String value1, String value2) {
            addCriterion("name_pinyin between", value1, value2, "namePinyin");
            return (Criteria) this;
        }

        public Criteria andNamePinyinNotBetween(String value1, String value2) {
            addCriterion("name_pinyin not between", value1, value2, "namePinyin");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIsNull() {
            addCriterion("plan_type is null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIsNotNull() {
            addCriterion("plan_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeEqualTo(Boolean value) {
            addCriterion("plan_type =", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotEqualTo(Boolean value) {
            addCriterion("plan_type <>", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThan(Boolean value) {
            addCriterion("plan_type >", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("plan_type >=", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThan(Boolean value) {
            addCriterion("plan_type <", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("plan_type <=", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIn(List<Boolean> values) {
            addCriterion("plan_type in", values, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotIn(List<Boolean> values) {
            addCriterion("plan_type not in", values, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("plan_type between", value1, value2, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("plan_type not between", value1, value2, "planType");
            return (Criteria) this;
        }

        public Criteria andAdjustShowcaseIsNull() {
            addCriterion("adjust_showcase is null");
            return (Criteria) this;
        }

        public Criteria andAdjustShowcaseIsNotNull() {
            addCriterion("adjust_showcase is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustShowcaseEqualTo(Boolean value) {
            addCriterion("adjust_showcase =", value, "adjustShowcase");
            return (Criteria) this;
        }

        public Criteria andAdjustShowcaseNotEqualTo(Boolean value) {
            addCriterion("adjust_showcase <>", value, "adjustShowcase");
            return (Criteria) this;
        }

        public Criteria andAdjustShowcaseGreaterThan(Boolean value) {
            addCriterion("adjust_showcase >", value, "adjustShowcase");
            return (Criteria) this;
        }

        public Criteria andAdjustShowcaseGreaterThanOrEqualTo(Boolean value) {
            addCriterion("adjust_showcase >=", value, "adjustShowcase");
            return (Criteria) this;
        }

        public Criteria andAdjustShowcaseLessThan(Boolean value) {
            addCriterion("adjust_showcase <", value, "adjustShowcase");
            return (Criteria) this;
        }

        public Criteria andAdjustShowcaseLessThanOrEqualTo(Boolean value) {
            addCriterion("adjust_showcase <=", value, "adjustShowcase");
            return (Criteria) this;
        }

        public Criteria andAdjustShowcaseIn(List<Boolean> values) {
            addCriterion("adjust_showcase in", values, "adjustShowcase");
            return (Criteria) this;
        }

        public Criteria andAdjustShowcaseNotIn(List<Boolean> values) {
            addCriterion("adjust_showcase not in", values, "adjustShowcase");
            return (Criteria) this;
        }

        public Criteria andAdjustShowcaseBetween(Boolean value1, Boolean value2) {
            addCriterion("adjust_showcase between", value1, value2, "adjustShowcase");
            return (Criteria) this;
        }

        public Criteria andAdjustShowcaseNotBetween(Boolean value1, Boolean value2) {
            addCriterion("adjust_showcase not between", value1, value2, "adjustShowcase");
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

        public Criteria andExcludeKeywordsEqualTo(String value) {
            addCriterion("exclude_keywords =", value, "excludeKeywords");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsNotEqualTo(String value) {
            addCriterion("exclude_keywords <>", value, "excludeKeywords");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsGreaterThan(String value) {
            addCriterion("exclude_keywords >", value, "excludeKeywords");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("exclude_keywords >=", value, "excludeKeywords");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsLessThan(String value) {
            addCriterion("exclude_keywords <", value, "excludeKeywords");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsLessThanOrEqualTo(String value) {
            addCriterion("exclude_keywords <=", value, "excludeKeywords");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsLike(String value) {
            addCriterion("exclude_keywords like", value, "excludeKeywords");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsNotLike(String value) {
            addCriterion("exclude_keywords not like", value, "excludeKeywords");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsIn(List<String> values) {
            addCriterion("exclude_keywords in", values, "excludeKeywords");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsNotIn(List<String> values) {
            addCriterion("exclude_keywords not in", values, "excludeKeywords");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsBetween(String value1, String value2) {
            addCriterion("exclude_keywords between", value1, value2, "excludeKeywords");
            return (Criteria) this;
        }

        public Criteria andExcludeKeywordsNotBetween(String value1, String value2) {
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

        public Criteria andExcludeItemIidsEqualTo(String value) {
            addCriterion("exclude_item_iids =", value, "excludeItemIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsNotEqualTo(String value) {
            addCriterion("exclude_item_iids <>", value, "excludeItemIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsGreaterThan(String value) {
            addCriterion("exclude_item_iids >", value, "excludeItemIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsGreaterThanOrEqualTo(String value) {
            addCriterion("exclude_item_iids >=", value, "excludeItemIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsLessThan(String value) {
            addCriterion("exclude_item_iids <", value, "excludeItemIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsLessThanOrEqualTo(String value) {
            addCriterion("exclude_item_iids <=", value, "excludeItemIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsLike(String value) {
            addCriterion("exclude_item_iids like", value, "excludeItemIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsNotLike(String value) {
            addCriterion("exclude_item_iids not like", value, "excludeItemIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsIn(List<String> values) {
            addCriterion("exclude_item_iids in", values, "excludeItemIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsNotIn(List<String> values) {
            addCriterion("exclude_item_iids not in", values, "excludeItemIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsBetween(String value1, String value2) {
            addCriterion("exclude_item_iids between", value1, value2, "excludeItemIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemIidsNotBetween(String value1, String value2) {
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

        public Criteria andIncludeCidsEqualTo(String value) {
            addCriterion("include_cids =", value, "includeCids");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsNotEqualTo(String value) {
            addCriterion("include_cids <>", value, "includeCids");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsGreaterThan(String value) {
            addCriterion("include_cids >", value, "includeCids");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsGreaterThanOrEqualTo(String value) {
            addCriterion("include_cids >=", value, "includeCids");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsLessThan(String value) {
            addCriterion("include_cids <", value, "includeCids");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsLessThanOrEqualTo(String value) {
            addCriterion("include_cids <=", value, "includeCids");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsLike(String value) {
            addCriterion("include_cids like", value, "includeCids");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsNotLike(String value) {
            addCriterion("include_cids not like", value, "includeCids");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsIn(List<String> values) {
            addCriterion("include_cids in", values, "includeCids");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsNotIn(List<String> values) {
            addCriterion("include_cids not in", values, "includeCids");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsBetween(String value1, String value2) {
            addCriterion("include_cids between", value1, value2, "includeCids");
            return (Criteria) this;
        }

        public Criteria andIncludeCidsNotBetween(String value1, String value2) {
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

        public Criteria andIncludeKeywordsEqualTo(String value) {
            addCriterion("include_keywords =", value, "includeKeywords");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsNotEqualTo(String value) {
            addCriterion("include_keywords <>", value, "includeKeywords");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsGreaterThan(String value) {
            addCriterion("include_keywords >", value, "includeKeywords");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("include_keywords >=", value, "includeKeywords");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsLessThan(String value) {
            addCriterion("include_keywords <", value, "includeKeywords");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsLessThanOrEqualTo(String value) {
            addCriterion("include_keywords <=", value, "includeKeywords");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsLike(String value) {
            addCriterion("include_keywords like", value, "includeKeywords");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsNotLike(String value) {
            addCriterion("include_keywords not like", value, "includeKeywords");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsIn(List<String> values) {
            addCriterion("include_keywords in", values, "includeKeywords");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsNotIn(List<String> values) {
            addCriterion("include_keywords not in", values, "includeKeywords");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsBetween(String value1, String value2) {
            addCriterion("include_keywords between", value1, value2, "includeKeywords");
            return (Criteria) this;
        }

        public Criteria andIncludeKeywordsNotBetween(String value1, String value2) {
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

        public Criteria andIncludeItemIidsEqualTo(String value) {
            addCriterion("include_item_iids =", value, "includeItemIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsNotEqualTo(String value) {
            addCriterion("include_item_iids <>", value, "includeItemIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsGreaterThan(String value) {
            addCriterion("include_item_iids >", value, "includeItemIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsGreaterThanOrEqualTo(String value) {
            addCriterion("include_item_iids >=", value, "includeItemIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsLessThan(String value) {
            addCriterion("include_item_iids <", value, "includeItemIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsLessThanOrEqualTo(String value) {
            addCriterion("include_item_iids <=", value, "includeItemIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsLike(String value) {
            addCriterion("include_item_iids like", value, "includeItemIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsNotLike(String value) {
            addCriterion("include_item_iids not like", value, "includeItemIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsIn(List<String> values) {
            addCriterion("include_item_iids in", values, "includeItemIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsNotIn(List<String> values) {
            addCriterion("include_item_iids not in", values, "includeItemIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsBetween(String value1, String value2) {
            addCriterion("include_item_iids between", value1, value2, "includeItemIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemIidsNotBetween(String value1, String value2) {
            addCriterion("include_item_iids not between", value1, value2, "includeItemIids");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsIsNull() {
            addCriterion("adjust_intervals is null");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsIsNotNull() {
            addCriterion("adjust_intervals is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsEqualTo(String value) {
            addCriterion("adjust_intervals =", value, "adjustIntervals");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsNotEqualTo(String value) {
            addCriterion("adjust_intervals <>", value, "adjustIntervals");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsGreaterThan(String value) {
            addCriterion("adjust_intervals >", value, "adjustIntervals");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsGreaterThanOrEqualTo(String value) {
            addCriterion("adjust_intervals >=", value, "adjustIntervals");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsLessThan(String value) {
            addCriterion("adjust_intervals <", value, "adjustIntervals");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsLessThanOrEqualTo(String value) {
            addCriterion("adjust_intervals <=", value, "adjustIntervals");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsLike(String value) {
            addCriterion("adjust_intervals like", value, "adjustIntervals");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsNotLike(String value) {
            addCriterion("adjust_intervals not like", value, "adjustIntervals");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsIn(List<String> values) {
            addCriterion("adjust_intervals in", values, "adjustIntervals");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsNotIn(List<String> values) {
            addCriterion("adjust_intervals not in", values, "adjustIntervals");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsBetween(String value1, String value2) {
            addCriterion("adjust_intervals between", value1, value2, "adjustIntervals");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsNotBetween(String value1, String value2) {
            addCriterion("adjust_intervals not between", value1, value2, "adjustIntervals");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsTypeIsNull() {
            addCriterion("adjust_intervals_type is null");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsTypeIsNotNull() {
            addCriterion("adjust_intervals_type is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsTypeEqualTo(Boolean value) {
            addCriterion("adjust_intervals_type =", value, "adjustIntervalsType");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsTypeNotEqualTo(Boolean value) {
            addCriterion("adjust_intervals_type <>", value, "adjustIntervalsType");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsTypeGreaterThan(Boolean value) {
            addCriterion("adjust_intervals_type >", value, "adjustIntervalsType");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("adjust_intervals_type >=", value, "adjustIntervalsType");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsTypeLessThan(Boolean value) {
            addCriterion("adjust_intervals_type <", value, "adjustIntervalsType");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("adjust_intervals_type <=", value, "adjustIntervalsType");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsTypeIn(List<Boolean> values) {
            addCriterion("adjust_intervals_type in", values, "adjustIntervalsType");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsTypeNotIn(List<Boolean> values) {
            addCriterion("adjust_intervals_type not in", values, "adjustIntervalsType");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("adjust_intervals_type between", value1, value2, "adjustIntervalsType");
            return (Criteria) this;
        }

        public Criteria andAdjustIntervalsTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("adjust_intervals_type not between", value1, value2, "adjustIntervalsType");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andLastAdjustItemNumIsNull() {
            addCriterion("last_adjust_item_num is null");
            return (Criteria) this;
        }

        public Criteria andLastAdjustItemNumIsNotNull() {
            addCriterion("last_adjust_item_num is not null");
            return (Criteria) this;
        }

        public Criteria andLastAdjustItemNumEqualTo(Integer value) {
            addCriterion("last_adjust_item_num =", value, "lastAdjustItemNum");
            return (Criteria) this;
        }

        public Criteria andLastAdjustItemNumNotEqualTo(Integer value) {
            addCriterion("last_adjust_item_num <>", value, "lastAdjustItemNum");
            return (Criteria) this;
        }

        public Criteria andLastAdjustItemNumGreaterThan(Integer value) {
            addCriterion("last_adjust_item_num >", value, "lastAdjustItemNum");
            return (Criteria) this;
        }

        public Criteria andLastAdjustItemNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_adjust_item_num >=", value, "lastAdjustItemNum");
            return (Criteria) this;
        }

        public Criteria andLastAdjustItemNumLessThan(Integer value) {
            addCriterion("last_adjust_item_num <", value, "lastAdjustItemNum");
            return (Criteria) this;
        }

        public Criteria andLastAdjustItemNumLessThanOrEqualTo(Integer value) {
            addCriterion("last_adjust_item_num <=", value, "lastAdjustItemNum");
            return (Criteria) this;
        }

        public Criteria andLastAdjustItemNumIn(List<Integer> values) {
            addCriterion("last_adjust_item_num in", values, "lastAdjustItemNum");
            return (Criteria) this;
        }

        public Criteria andLastAdjustItemNumNotIn(List<Integer> values) {
            addCriterion("last_adjust_item_num not in", values, "lastAdjustItemNum");
            return (Criteria) this;
        }

        public Criteria andLastAdjustItemNumBetween(Integer value1, Integer value2) {
            addCriterion("last_adjust_item_num between", value1, value2, "lastAdjustItemNum");
            return (Criteria) this;
        }

        public Criteria andLastAdjustItemNumNotBetween(Integer value1, Integer value2) {
            addCriterion("last_adjust_item_num not between", value1, value2, "lastAdjustItemNum");
            return (Criteria) this;
        }

        public Criteria andLastAdjustTimeIsNull() {
            addCriterion("last_adjust_time is null");
            return (Criteria) this;
        }

        public Criteria andLastAdjustTimeIsNotNull() {
            addCriterion("last_adjust_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastAdjustTimeEqualTo(Date value) {
            addCriterion("last_adjust_time =", value, "lastAdjustTime");
            return (Criteria) this;
        }

        public Criteria andLastAdjustTimeNotEqualTo(Date value) {
            addCriterion("last_adjust_time <>", value, "lastAdjustTime");
            return (Criteria) this;
        }

        public Criteria andLastAdjustTimeGreaterThan(Date value) {
            addCriterion("last_adjust_time >", value, "lastAdjustTime");
            return (Criteria) this;
        }

        public Criteria andLastAdjustTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_adjust_time >=", value, "lastAdjustTime");
            return (Criteria) this;
        }

        public Criteria andLastAdjustTimeLessThan(Date value) {
            addCriterion("last_adjust_time <", value, "lastAdjustTime");
            return (Criteria) this;
        }

        public Criteria andLastAdjustTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_adjust_time <=", value, "lastAdjustTime");
            return (Criteria) this;
        }

        public Criteria andLastAdjustTimeIn(List<Date> values) {
            addCriterion("last_adjust_time in", values, "lastAdjustTime");
            return (Criteria) this;
        }

        public Criteria andLastAdjustTimeNotIn(List<Date> values) {
            addCriterion("last_adjust_time not in", values, "lastAdjustTime");
            return (Criteria) this;
        }

        public Criteria andLastAdjustTimeBetween(Date value1, Date value2) {
            addCriterion("last_adjust_time between", value1, value2, "lastAdjustTime");
            return (Criteria) this;
        }

        public Criteria andLastAdjustTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_adjust_time not between", value1, value2, "lastAdjustTime");
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