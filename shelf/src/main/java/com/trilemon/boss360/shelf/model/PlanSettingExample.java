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

        public Criteria andIncludeSellerCidsIsNull() {
            addCriterion("include_seller_cids is null");
            return (Criteria) this;
        }

        public Criteria andIncludeSellerCidsIsNotNull() {
            addCriterion("include_seller_cids is not null");
            return (Criteria) this;
        }

        public Criteria andIncludeSellerCidsEqualTo(String value) {
            addCriterion("include_seller_cids =", value, "includeSellerCids");
            return (Criteria) this;
        }

        public Criteria andIncludeSellerCidsNotEqualTo(String value) {
            addCriterion("include_seller_cids <>", value, "includeSellerCids");
            return (Criteria) this;
        }

        public Criteria andIncludeSellerCidsGreaterThan(String value) {
            addCriterion("include_seller_cids >", value, "includeSellerCids");
            return (Criteria) this;
        }

        public Criteria andIncludeSellerCidsGreaterThanOrEqualTo(String value) {
            addCriterion("include_seller_cids >=", value, "includeSellerCids");
            return (Criteria) this;
        }

        public Criteria andIncludeSellerCidsLessThan(String value) {
            addCriterion("include_seller_cids <", value, "includeSellerCids");
            return (Criteria) this;
        }

        public Criteria andIncludeSellerCidsLessThanOrEqualTo(String value) {
            addCriterion("include_seller_cids <=", value, "includeSellerCids");
            return (Criteria) this;
        }

        public Criteria andIncludeSellerCidsLike(String value) {
            addCriterion("include_seller_cids like", value, "includeSellerCids");
            return (Criteria) this;
        }

        public Criteria andIncludeSellerCidsNotLike(String value) {
            addCriterion("include_seller_cids not like", value, "includeSellerCids");
            return (Criteria) this;
        }

        public Criteria andIncludeSellerCidsIn(List<String> values) {
            addCriterion("include_seller_cids in", values, "includeSellerCids");
            return (Criteria) this;
        }

        public Criteria andIncludeSellerCidsNotIn(List<String> values) {
            addCriterion("include_seller_cids not in", values, "includeSellerCids");
            return (Criteria) this;
        }

        public Criteria andIncludeSellerCidsBetween(String value1, String value2) {
            addCriterion("include_seller_cids between", value1, value2, "includeSellerCids");
            return (Criteria) this;
        }

        public Criteria andIncludeSellerCidsNotBetween(String value1, String value2) {
            addCriterion("include_seller_cids not between", value1, value2, "includeSellerCids");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemsIsNull() {
            addCriterion("auto_add_new_items is null");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemsIsNotNull() {
            addCriterion("auto_add_new_items is not null");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemsEqualTo(Boolean value) {
            addCriterion("auto_add_new_items =", value, "autoAddNewItems");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemsNotEqualTo(Boolean value) {
            addCriterion("auto_add_new_items <>", value, "autoAddNewItems");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemsGreaterThan(Boolean value) {
            addCriterion("auto_add_new_items >", value, "autoAddNewItems");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("auto_add_new_items >=", value, "autoAddNewItems");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemsLessThan(Boolean value) {
            addCriterion("auto_add_new_items <", value, "autoAddNewItems");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemsLessThanOrEqualTo(Boolean value) {
            addCriterion("auto_add_new_items <=", value, "autoAddNewItems");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemsIn(List<Boolean> values) {
            addCriterion("auto_add_new_items in", values, "autoAddNewItems");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemsNotIn(List<Boolean> values) {
            addCriterion("auto_add_new_items not in", values, "autoAddNewItems");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemsBetween(Boolean value1, Boolean value2) {
            addCriterion("auto_add_new_items between", value1, value2, "autoAddNewItems");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("auto_add_new_items not between", value1, value2, "autoAddNewItems");
            return (Criteria) this;
        }

        public Criteria andExcludeItemNumIidsIsNull() {
            addCriterion("exclude_item_num_iids is null");
            return (Criteria) this;
        }

        public Criteria andExcludeItemNumIidsIsNotNull() {
            addCriterion("exclude_item_num_iids is not null");
            return (Criteria) this;
        }

        public Criteria andExcludeItemNumIidsEqualTo(String value) {
            addCriterion("exclude_item_num_iids =", value, "excludeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemNumIidsNotEqualTo(String value) {
            addCriterion("exclude_item_num_iids <>", value, "excludeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemNumIidsGreaterThan(String value) {
            addCriterion("exclude_item_num_iids >", value, "excludeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemNumIidsGreaterThanOrEqualTo(String value) {
            addCriterion("exclude_item_num_iids >=", value, "excludeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemNumIidsLessThan(String value) {
            addCriterion("exclude_item_num_iids <", value, "excludeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemNumIidsLessThanOrEqualTo(String value) {
            addCriterion("exclude_item_num_iids <=", value, "excludeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemNumIidsLike(String value) {
            addCriterion("exclude_item_num_iids like", value, "excludeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemNumIidsNotLike(String value) {
            addCriterion("exclude_item_num_iids not like", value, "excludeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemNumIidsIn(List<String> values) {
            addCriterion("exclude_item_num_iids in", values, "excludeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemNumIidsNotIn(List<String> values) {
            addCriterion("exclude_item_num_iids not in", values, "excludeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemNumIidsBetween(String value1, String value2) {
            addCriterion("exclude_item_num_iids between", value1, value2, "excludeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andExcludeItemNumIidsNotBetween(String value1, String value2) {
            addCriterion("exclude_item_num_iids not between", value1, value2, "excludeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andDistributionIsNull() {
            addCriterion("distribution is null");
            return (Criteria) this;
        }

        public Criteria andDistributionIsNotNull() {
            addCriterion("distribution is not null");
            return (Criteria) this;
        }

        public Criteria andDistributionEqualTo(String value) {
            addCriterion("distribution =", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionNotEqualTo(String value) {
            addCriterion("distribution <>", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionGreaterThan(String value) {
            addCriterion("distribution >", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionGreaterThanOrEqualTo(String value) {
            addCriterion("distribution >=", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionLessThan(String value) {
            addCriterion("distribution <", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionLessThanOrEqualTo(String value) {
            addCriterion("distribution <=", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionLike(String value) {
            addCriterion("distribution like", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionNotLike(String value) {
            addCriterion("distribution not like", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionIn(List<String> values) {
            addCriterion("distribution in", values, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionNotIn(List<String> values) {
            addCriterion("distribution not in", values, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionBetween(String value1, String value2) {
            addCriterion("distribution between", value1, value2, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionNotBetween(String value1, String value2) {
            addCriterion("distribution not between", value1, value2, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeIsNull() {
            addCriterion("distribution_type is null");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeIsNotNull() {
            addCriterion("distribution_type is not null");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeEqualTo(Byte value) {
            addCriterion("distribution_type =", value, "distributionType");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeNotEqualTo(Byte value) {
            addCriterion("distribution_type <>", value, "distributionType");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeGreaterThan(Byte value) {
            addCriterion("distribution_type >", value, "distributionType");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("distribution_type >=", value, "distributionType");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeLessThan(Byte value) {
            addCriterion("distribution_type <", value, "distributionType");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeLessThanOrEqualTo(Byte value) {
            addCriterion("distribution_type <=", value, "distributionType");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeIn(List<Byte> values) {
            addCriterion("distribution_type in", values, "distributionType");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeNotIn(List<Byte> values) {
            addCriterion("distribution_type not in", values, "distributionType");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeBetween(Byte value1, Byte value2) {
            addCriterion("distribution_type between", value1, value2, "distributionType");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("distribution_type not between", value1, value2, "distributionType");
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

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andLastPlanTimeIsNull() {
            addCriterion("last_plan_time is null");
            return (Criteria) this;
        }

        public Criteria andLastPlanTimeIsNotNull() {
            addCriterion("last_plan_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastPlanTimeEqualTo(Date value) {
            addCriterion("last_plan_time =", value, "lastPlanTime");
            return (Criteria) this;
        }

        public Criteria andLastPlanTimeNotEqualTo(Date value) {
            addCriterion("last_plan_time <>", value, "lastPlanTime");
            return (Criteria) this;
        }

        public Criteria andLastPlanTimeGreaterThan(Date value) {
            addCriterion("last_plan_time >", value, "lastPlanTime");
            return (Criteria) this;
        }

        public Criteria andLastPlanTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_plan_time >=", value, "lastPlanTime");
            return (Criteria) this;
        }

        public Criteria andLastPlanTimeLessThan(Date value) {
            addCriterion("last_plan_time <", value, "lastPlanTime");
            return (Criteria) this;
        }

        public Criteria andLastPlanTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_plan_time <=", value, "lastPlanTime");
            return (Criteria) this;
        }

        public Criteria andLastPlanTimeIn(List<Date> values) {
            addCriterion("last_plan_time in", values, "lastPlanTime");
            return (Criteria) this;
        }

        public Criteria andLastPlanTimeNotIn(List<Date> values) {
            addCriterion("last_plan_time not in", values, "lastPlanTime");
            return (Criteria) this;
        }

        public Criteria andLastPlanTimeBetween(Date value1, Date value2) {
            addCriterion("last_plan_time between", value1, value2, "lastPlanTime");
            return (Criteria) this;
        }

        public Criteria andLastPlanTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_plan_time not between", value1, value2, "lastPlanTime");
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