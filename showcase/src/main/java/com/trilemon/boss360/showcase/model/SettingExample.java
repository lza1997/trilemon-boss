package com.trilemon.boss360.showcase.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SettingExample() {
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

        public Criteria andRuleTypeIsNull() {
            addCriterion("rule_type is null");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIsNotNull() {
            addCriterion("rule_type is not null");
            return (Criteria) this;
        }

        public Criteria andRuleTypeEqualTo(Byte value) {
            addCriterion("rule_type =", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNotEqualTo(Byte value) {
            addCriterion("rule_type <>", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeGreaterThan(Byte value) {
            addCriterion("rule_type >", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("rule_type >=", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeLessThan(Byte value) {
            addCriterion("rule_type <", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeLessThanOrEqualTo(Byte value) {
            addCriterion("rule_type <=", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIn(List<Byte> values) {
            addCriterion("rule_type in", values, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNotIn(List<Byte> values) {
            addCriterion("rule_type not in", values, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeBetween(Byte value1, Byte value2) {
            addCriterion("rule_type between", value1, value2, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("rule_type not between", value1, value2, "ruleType");
            return (Criteria) this;
        }

        public Criteria andMinSaleVolumeIsNull() {
            addCriterion("min_sale_volume is null");
            return (Criteria) this;
        }

        public Criteria andMinSaleVolumeIsNotNull() {
            addCriterion("min_sale_volume is not null");
            return (Criteria) this;
        }

        public Criteria andMinSaleVolumeEqualTo(Integer value) {
            addCriterion("min_sale_volume =", value, "minSaleVolume");
            return (Criteria) this;
        }

        public Criteria andMinSaleVolumeNotEqualTo(Integer value) {
            addCriterion("min_sale_volume <>", value, "minSaleVolume");
            return (Criteria) this;
        }

        public Criteria andMinSaleVolumeGreaterThan(Integer value) {
            addCriterion("min_sale_volume >", value, "minSaleVolume");
            return (Criteria) this;
        }

        public Criteria andMinSaleVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_sale_volume >=", value, "minSaleVolume");
            return (Criteria) this;
        }

        public Criteria andMinSaleVolumeLessThan(Integer value) {
            addCriterion("min_sale_volume <", value, "minSaleVolume");
            return (Criteria) this;
        }

        public Criteria andMinSaleVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("min_sale_volume <=", value, "minSaleVolume");
            return (Criteria) this;
        }

        public Criteria andMinSaleVolumeIn(List<Integer> values) {
            addCriterion("min_sale_volume in", values, "minSaleVolume");
            return (Criteria) this;
        }

        public Criteria andMinSaleVolumeNotIn(List<Integer> values) {
            addCriterion("min_sale_volume not in", values, "minSaleVolume");
            return (Criteria) this;
        }

        public Criteria andMinSaleVolumeBetween(Integer value1, Integer value2) {
            addCriterion("min_sale_volume between", value1, value2, "minSaleVolume");
            return (Criteria) this;
        }

        public Criteria andMinSaleVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("min_sale_volume not between", value1, value2, "minSaleVolume");
            return (Criteria) this;
        }

        public Criteria andMaxSaleVolumeIsNull() {
            addCriterion("max_sale_volume is null");
            return (Criteria) this;
        }

        public Criteria andMaxSaleVolumeIsNotNull() {
            addCriterion("max_sale_volume is not null");
            return (Criteria) this;
        }

        public Criteria andMaxSaleVolumeEqualTo(Integer value) {
            addCriterion("max_sale_volume =", value, "maxSaleVolume");
            return (Criteria) this;
        }

        public Criteria andMaxSaleVolumeNotEqualTo(Integer value) {
            addCriterion("max_sale_volume <>", value, "maxSaleVolume");
            return (Criteria) this;
        }

        public Criteria andMaxSaleVolumeGreaterThan(Integer value) {
            addCriterion("max_sale_volume >", value, "maxSaleVolume");
            return (Criteria) this;
        }

        public Criteria andMaxSaleVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_sale_volume >=", value, "maxSaleVolume");
            return (Criteria) this;
        }

        public Criteria andMaxSaleVolumeLessThan(Integer value) {
            addCriterion("max_sale_volume <", value, "maxSaleVolume");
            return (Criteria) this;
        }

        public Criteria andMaxSaleVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("max_sale_volume <=", value, "maxSaleVolume");
            return (Criteria) this;
        }

        public Criteria andMaxSaleVolumeIn(List<Integer> values) {
            addCriterion("max_sale_volume in", values, "maxSaleVolume");
            return (Criteria) this;
        }

        public Criteria andMaxSaleVolumeNotIn(List<Integer> values) {
            addCriterion("max_sale_volume not in", values, "maxSaleVolume");
            return (Criteria) this;
        }

        public Criteria andMaxSaleVolumeBetween(Integer value1, Integer value2) {
            addCriterion("max_sale_volume between", value1, value2, "maxSaleVolume");
            return (Criteria) this;
        }

        public Criteria andMaxSaleVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("max_sale_volume not between", value1, value2, "maxSaleVolume");
            return (Criteria) this;
        }

        public Criteria andMinPriceIsNull() {
            addCriterion("min_price is null");
            return (Criteria) this;
        }

        public Criteria andMinPriceIsNotNull() {
            addCriterion("min_price is not null");
            return (Criteria) this;
        }

        public Criteria andMinPriceEqualTo(BigDecimal value) {
            addCriterion("min_price =", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceNotEqualTo(BigDecimal value) {
            addCriterion("min_price <>", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceGreaterThan(BigDecimal value) {
            addCriterion("min_price >", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("min_price >=", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceLessThan(BigDecimal value) {
            addCriterion("min_price <", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("min_price <=", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceIn(List<BigDecimal> values) {
            addCriterion("min_price in", values, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceNotIn(List<BigDecimal> values) {
            addCriterion("min_price not in", values, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_price between", value1, value2, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_price not between", value1, value2, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceIsNull() {
            addCriterion("max_price is null");
            return (Criteria) this;
        }

        public Criteria andMaxPriceIsNotNull() {
            addCriterion("max_price is not null");
            return (Criteria) this;
        }

        public Criteria andMaxPriceEqualTo(BigDecimal value) {
            addCriterion("max_price =", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceNotEqualTo(BigDecimal value) {
            addCriterion("max_price <>", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceGreaterThan(BigDecimal value) {
            addCriterion("max_price >", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("max_price >=", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceLessThan(BigDecimal value) {
            addCriterion("max_price <", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("max_price <=", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceIn(List<BigDecimal> values) {
            addCriterion("max_price in", values, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceNotIn(List<BigDecimal> values) {
            addCriterion("max_price not in", values, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_price between", value1, value2, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_price not between", value1, value2, "maxPrice");
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

        public Criteria andIncludeItemNumIidsIsNull() {
            addCriterion("include_item_num_iids is null");
            return (Criteria) this;
        }

        public Criteria andIncludeItemNumIidsIsNotNull() {
            addCriterion("include_item_num_iids is not null");
            return (Criteria) this;
        }

        public Criteria andIncludeItemNumIidsEqualTo(String value) {
            addCriterion("include_item_num_iids =", value, "includeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemNumIidsNotEqualTo(String value) {
            addCriterion("include_item_num_iids <>", value, "includeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemNumIidsGreaterThan(String value) {
            addCriterion("include_item_num_iids >", value, "includeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemNumIidsGreaterThanOrEqualTo(String value) {
            addCriterion("include_item_num_iids >=", value, "includeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemNumIidsLessThan(String value) {
            addCriterion("include_item_num_iids <", value, "includeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemNumIidsLessThanOrEqualTo(String value) {
            addCriterion("include_item_num_iids <=", value, "includeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemNumIidsLike(String value) {
            addCriterion("include_item_num_iids like", value, "includeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemNumIidsNotLike(String value) {
            addCriterion("include_item_num_iids not like", value, "includeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemNumIidsIn(List<String> values) {
            addCriterion("include_item_num_iids in", values, "includeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemNumIidsNotIn(List<String> values) {
            addCriterion("include_item_num_iids not in", values, "includeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemNumIidsBetween(String value1, String value2) {
            addCriterion("include_item_num_iids between", value1, value2, "includeItemNumIids");
            return (Criteria) this;
        }

        public Criteria andIncludeItemNumIidsNotBetween(String value1, String value2) {
            addCriterion("include_item_num_iids not between", value1, value2, "includeItemNumIids");
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

        public Criteria andExcludeItemDelistingWithinIsNull() {
            addCriterion("exclude_item_delisting_within is null");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingWithinIsNotNull() {
            addCriterion("exclude_item_delisting_within is not null");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingWithinEqualTo(Integer value) {
            addCriterion("exclude_item_delisting_within =", value, "excludeItemDelistingWithin");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingWithinNotEqualTo(Integer value) {
            addCriterion("exclude_item_delisting_within <>", value, "excludeItemDelistingWithin");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingWithinGreaterThan(Integer value) {
            addCriterion("exclude_item_delisting_within >", value, "excludeItemDelistingWithin");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingWithinGreaterThanOrEqualTo(Integer value) {
            addCriterion("exclude_item_delisting_within >=", value, "excludeItemDelistingWithin");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingWithinLessThan(Integer value) {
            addCriterion("exclude_item_delisting_within <", value, "excludeItemDelistingWithin");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingWithinLessThanOrEqualTo(Integer value) {
            addCriterion("exclude_item_delisting_within <=", value, "excludeItemDelistingWithin");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingWithinIn(List<Integer> values) {
            addCriterion("exclude_item_delisting_within in", values, "excludeItemDelistingWithin");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingWithinNotIn(List<Integer> values) {
            addCriterion("exclude_item_delisting_within not in", values, "excludeItemDelistingWithin");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingWithinBetween(Integer value1, Integer value2) {
            addCriterion("exclude_item_delisting_within between", value1, value2, "excludeItemDelistingWithin");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingWithinNotBetween(Integer value1, Integer value2) {
            addCriterion("exclude_item_delisting_within not between", value1, value2, "excludeItemDelistingWithin");
            return (Criteria) this;
        }

        public Criteria andExcludeItemInventoryLtIsNull() {
            addCriterion("exclude_item_inventory_lt is null");
            return (Criteria) this;
        }

        public Criteria andExcludeItemInventoryLtIsNotNull() {
            addCriterion("exclude_item_inventory_lt is not null");
            return (Criteria) this;
        }

        public Criteria andExcludeItemInventoryLtEqualTo(Integer value) {
            addCriterion("exclude_item_inventory_lt =", value, "excludeItemInventoryLt");
            return (Criteria) this;
        }

        public Criteria andExcludeItemInventoryLtNotEqualTo(Integer value) {
            addCriterion("exclude_item_inventory_lt <>", value, "excludeItemInventoryLt");
            return (Criteria) this;
        }

        public Criteria andExcludeItemInventoryLtGreaterThan(Integer value) {
            addCriterion("exclude_item_inventory_lt >", value, "excludeItemInventoryLt");
            return (Criteria) this;
        }

        public Criteria andExcludeItemInventoryLtGreaterThanOrEqualTo(Integer value) {
            addCriterion("exclude_item_inventory_lt >=", value, "excludeItemInventoryLt");
            return (Criteria) this;
        }

        public Criteria andExcludeItemInventoryLtLessThan(Integer value) {
            addCriterion("exclude_item_inventory_lt <", value, "excludeItemInventoryLt");
            return (Criteria) this;
        }

        public Criteria andExcludeItemInventoryLtLessThanOrEqualTo(Integer value) {
            addCriterion("exclude_item_inventory_lt <=", value, "excludeItemInventoryLt");
            return (Criteria) this;
        }

        public Criteria andExcludeItemInventoryLtIn(List<Integer> values) {
            addCriterion("exclude_item_inventory_lt in", values, "excludeItemInventoryLt");
            return (Criteria) this;
        }

        public Criteria andExcludeItemInventoryLtNotIn(List<Integer> values) {
            addCriterion("exclude_item_inventory_lt not in", values, "excludeItemInventoryLt");
            return (Criteria) this;
        }

        public Criteria andExcludeItemInventoryLtBetween(Integer value1, Integer value2) {
            addCriterion("exclude_item_inventory_lt between", value1, value2, "excludeItemInventoryLt");
            return (Criteria) this;
        }

        public Criteria andExcludeItemInventoryLtNotBetween(Integer value1, Integer value2) {
            addCriterion("exclude_item_inventory_lt not between", value1, value2, "excludeItemInventoryLt");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingAfterIsNull() {
            addCriterion("exclude_item_delisting_after is null");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingAfterIsNotNull() {
            addCriterion("exclude_item_delisting_after is not null");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingAfterEqualTo(Integer value) {
            addCriterion("exclude_item_delisting_after =", value, "excludeItemDelistingAfter");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingAfterNotEqualTo(Integer value) {
            addCriterion("exclude_item_delisting_after <>", value, "excludeItemDelistingAfter");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingAfterGreaterThan(Integer value) {
            addCriterion("exclude_item_delisting_after >", value, "excludeItemDelistingAfter");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingAfterGreaterThanOrEqualTo(Integer value) {
            addCriterion("exclude_item_delisting_after >=", value, "excludeItemDelistingAfter");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingAfterLessThan(Integer value) {
            addCriterion("exclude_item_delisting_after <", value, "excludeItemDelistingAfter");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingAfterLessThanOrEqualTo(Integer value) {
            addCriterion("exclude_item_delisting_after <=", value, "excludeItemDelistingAfter");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingAfterIn(List<Integer> values) {
            addCriterion("exclude_item_delisting_after in", values, "excludeItemDelistingAfter");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingAfterNotIn(List<Integer> values) {
            addCriterion("exclude_item_delisting_after not in", values, "excludeItemDelistingAfter");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingAfterBetween(Integer value1, Integer value2) {
            addCriterion("exclude_item_delisting_after between", value1, value2, "excludeItemDelistingAfter");
            return (Criteria) this;
        }

        public Criteria andExcludeItemDelistingAfterNotBetween(Integer value1, Integer value2) {
            addCriterion("exclude_item_delisting_after not between", value1, value2, "excludeItemDelistingAfter");
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