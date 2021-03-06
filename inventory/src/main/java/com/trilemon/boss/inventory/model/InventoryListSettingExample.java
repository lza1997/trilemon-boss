package com.trilemon.boss.inventory.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InventoryListSettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InventoryListSettingExample() {
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

        public Criteria andIncludeBannersIsNull() {
            addCriterion("include_banners is null");
            return (Criteria) this;
        }

        public Criteria andIncludeBannersIsNotNull() {
            addCriterion("include_banners is not null");
            return (Criteria) this;
        }

        public Criteria andIncludeBannersEqualTo(String value) {
            addCriterion("include_banners =", value, "includeBanners");
            return (Criteria) this;
        }

        public Criteria andIncludeBannersNotEqualTo(String value) {
            addCriterion("include_banners <>", value, "includeBanners");
            return (Criteria) this;
        }

        public Criteria andIncludeBannersGreaterThan(String value) {
            addCriterion("include_banners >", value, "includeBanners");
            return (Criteria) this;
        }

        public Criteria andIncludeBannersGreaterThanOrEqualTo(String value) {
            addCriterion("include_banners >=", value, "includeBanners");
            return (Criteria) this;
        }

        public Criteria andIncludeBannersLessThan(String value) {
            addCriterion("include_banners <", value, "includeBanners");
            return (Criteria) this;
        }

        public Criteria andIncludeBannersLessThanOrEqualTo(String value) {
            addCriterion("include_banners <=", value, "includeBanners");
            return (Criteria) this;
        }

        public Criteria andIncludeBannersLike(String value) {
            addCriterion("include_banners like", value, "includeBanners");
            return (Criteria) this;
        }

        public Criteria andIncludeBannersNotLike(String value) {
            addCriterion("include_banners not like", value, "includeBanners");
            return (Criteria) this;
        }

        public Criteria andIncludeBannersIn(List<String> values) {
            addCriterion("include_banners in", values, "includeBanners");
            return (Criteria) this;
        }

        public Criteria andIncludeBannersNotIn(List<String> values) {
            addCriterion("include_banners not in", values, "includeBanners");
            return (Criteria) this;
        }

        public Criteria andIncludeBannersBetween(String value1, String value2) {
            addCriterion("include_banners between", value1, value2, "includeBanners");
            return (Criteria) this;
        }

        public Criteria andIncludeBannersNotBetween(String value1, String value2) {
            addCriterion("include_banners not between", value1, value2, "includeBanners");
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

        public Criteria andAutoAddNewItemIsNull() {
            addCriterion("auto_add_new_item is null");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemIsNotNull() {
            addCriterion("auto_add_new_item is not null");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemEqualTo(Byte value) {
            addCriterion("auto_add_new_item =", value, "autoAddNewItem");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemNotEqualTo(Byte value) {
            addCriterion("auto_add_new_item <>", value, "autoAddNewItem");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemGreaterThan(Byte value) {
            addCriterion("auto_add_new_item >", value, "autoAddNewItem");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemGreaterThanOrEqualTo(Byte value) {
            addCriterion("auto_add_new_item >=", value, "autoAddNewItem");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemLessThan(Byte value) {
            addCriterion("auto_add_new_item <", value, "autoAddNewItem");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemLessThanOrEqualTo(Byte value) {
            addCriterion("auto_add_new_item <=", value, "autoAddNewItem");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemIn(List<Byte> values) {
            addCriterion("auto_add_new_item in", values, "autoAddNewItem");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemNotIn(List<Byte> values) {
            addCriterion("auto_add_new_item not in", values, "autoAddNewItem");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemBetween(Byte value1, Byte value2) {
            addCriterion("auto_add_new_item between", value1, value2, "autoAddNewItem");
            return (Criteria) this;
        }

        public Criteria andAutoAddNewItemNotBetween(Byte value1, Byte value2) {
            addCriterion("auto_add_new_item not between", value1, value2, "autoAddNewItem");
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

        public Criteria andListTypeIsNull() {
            addCriterion("list_type is null");
            return (Criteria) this;
        }

        public Criteria andListTypeIsNotNull() {
            addCriterion("list_type is not null");
            return (Criteria) this;
        }

        public Criteria andListTypeEqualTo(Byte value) {
            addCriterion("list_type =", value, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeNotEqualTo(Byte value) {
            addCriterion("list_type <>", value, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeGreaterThan(Byte value) {
            addCriterion("list_type >", value, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("list_type >=", value, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeLessThan(Byte value) {
            addCriterion("list_type <", value, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeLessThanOrEqualTo(Byte value) {
            addCriterion("list_type <=", value, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeIn(List<Byte> values) {
            addCriterion("list_type in", values, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeNotIn(List<Byte> values) {
            addCriterion("list_type not in", values, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeBetween(Byte value1, Byte value2) {
            addCriterion("list_type between", value1, value2, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("list_type not between", value1, value2, "listType");
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