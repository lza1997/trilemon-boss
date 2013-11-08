package com.trilemon.boss360.rate.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RateFilterTradeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RateFilterTradeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected RateFilterTradeExample(RateFilterTradeExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.distinct = example.distinct;
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
        protected List<String> criteriaWithoutValue;

        protected List<Map<String, Object>> criteriaWithSingleValue;

        protected List<Map<String, Object>> criteriaWithListValue;

        protected List<Map<String, Object>> criteriaWithBetweenValue;

        protected GeneratedCriteria() {
            super();
            criteriaWithoutValue = new ArrayList<String>();
            criteriaWithSingleValue = new ArrayList<Map<String, Object>>();
            criteriaWithListValue = new ArrayList<Map<String, Object>>();
            criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List<String> getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List<Map<String, Object>> getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List<Map<String, Object>> getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List<Map<String, Object>> getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List<? extends Object> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List<Object> list = new ArrayList<Object>();
            list.add(value1);
            list.add(value2);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
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

        public Criteria andItemNumIidIsNull() {
            addCriterion("item_num_iid is null");
            return (Criteria) this;
        }

        public Criteria andItemNumIidIsNotNull() {
            addCriterion("item_num_iid is not null");
            return (Criteria) this;
        }

        public Criteria andItemNumIidEqualTo(Long value) {
            addCriterion("item_num_iid =", value, "itemNumIid");
            return (Criteria) this;
        }

        public Criteria andItemNumIidNotEqualTo(Long value) {
            addCriterion("item_num_iid <>", value, "itemNumIid");
            return (Criteria) this;
        }

        public Criteria andItemNumIidGreaterThan(Long value) {
            addCriterion("item_num_iid >", value, "itemNumIid");
            return (Criteria) this;
        }

        public Criteria andItemNumIidGreaterThanOrEqualTo(Long value) {
            addCriterion("item_num_iid >=", value, "itemNumIid");
            return (Criteria) this;
        }

        public Criteria andItemNumIidLessThan(Long value) {
            addCriterion("item_num_iid <", value, "itemNumIid");
            return (Criteria) this;
        }

        public Criteria andItemNumIidLessThanOrEqualTo(Long value) {
            addCriterion("item_num_iid <=", value, "itemNumIid");
            return (Criteria) this;
        }

        public Criteria andItemNumIidIn(List<Long> values) {
            addCriterion("item_num_iid in", values, "itemNumIid");
            return (Criteria) this;
        }

        public Criteria andItemNumIidNotIn(List<Long> values) {
            addCriterion("item_num_iid not in", values, "itemNumIid");
            return (Criteria) this;
        }

        public Criteria andItemNumIidBetween(Long value1, Long value2) {
            addCriterion("item_num_iid between", value1, value2, "itemNumIid");
            return (Criteria) this;
        }

        public Criteria andItemNumIidNotBetween(Long value1, Long value2) {
            addCriterion("item_num_iid not between", value1, value2, "itemNumIid");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdIsNull() {
            addCriterion("buyer_user_id is null");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdIsNotNull() {
            addCriterion("buyer_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdEqualTo(Long value) {
            addCriterion("buyer_user_id =", value, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdNotEqualTo(Long value) {
            addCriterion("buyer_user_id <>", value, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdGreaterThan(Long value) {
            addCriterion("buyer_user_id >", value, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("buyer_user_id >=", value, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdLessThan(Long value) {
            addCriterion("buyer_user_id <", value, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdLessThanOrEqualTo(Long value) {
            addCriterion("buyer_user_id <=", value, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdIn(List<Long> values) {
            addCriterion("buyer_user_id in", values, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdNotIn(List<Long> values) {
            addCriterion("buyer_user_id not in", values, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdBetween(Long value1, Long value2) {
            addCriterion("buyer_user_id between", value1, value2, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdNotBetween(Long value1, Long value2) {
            addCriterion("buyer_user_id not between", value1, value2, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerNickIsNull() {
            addCriterion("buyer_nick is null");
            return (Criteria) this;
        }

        public Criteria andBuyerNickIsNotNull() {
            addCriterion("buyer_nick is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerNickEqualTo(String value) {
            addCriterion("buyer_nick =", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickNotEqualTo(String value) {
            addCriterion("buyer_nick <>", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickGreaterThan(String value) {
            addCriterion("buyer_nick >", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_nick >=", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickLessThan(String value) {
            addCriterion("buyer_nick <", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickLessThanOrEqualTo(String value) {
            addCriterion("buyer_nick <=", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickLike(String value) {
            addCriterion("buyer_nick like", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickNotLike(String value) {
            addCriterion("buyer_nick not like", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickIn(List<String> values) {
            addCriterion("buyer_nick in", values, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickNotIn(List<String> values) {
            addCriterion("buyer_nick not in", values, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickBetween(String value1, String value2) {
            addCriterion("buyer_nick between", value1, value2, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickNotBetween(String value1, String value2) {
            addCriterion("buyer_nick not between", value1, value2, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Long value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Long value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Long value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Long value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Long value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Long value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Long> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Long> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Long value1, Long value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Long value1, Long value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andOidIsNull() {
            addCriterion("oid is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oid is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(Long value) {
            addCriterion("oid =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(Long value) {
            addCriterion("oid <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(Long value) {
            addCriterion("oid >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Long value) {
            addCriterion("oid >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(Long value) {
            addCriterion("oid <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(Long value) {
            addCriterion("oid <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<Long> values) {
            addCriterion("oid in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<Long> values) {
            addCriterion("oid not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(Long value1, Long value2) {
            addCriterion("oid between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(Long value1, Long value2) {
            addCriterion("oid not between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andIsSellerRateIsNull() {
            addCriterion("is_seller_rate is null");
            return (Criteria) this;
        }

        public Criteria andIsSellerRateIsNotNull() {
            addCriterion("is_seller_rate is not null");
            return (Criteria) this;
        }

        public Criteria andIsSellerRateEqualTo(Boolean value) {
            addCriterion("is_seller_rate =", value, "isSellerRate");
            return (Criteria) this;
        }

        public Criteria andIsSellerRateNotEqualTo(Boolean value) {
            addCriterion("is_seller_rate <>", value, "isSellerRate");
            return (Criteria) this;
        }

        public Criteria andIsSellerRateGreaterThan(Boolean value) {
            addCriterion("is_seller_rate >", value, "isSellerRate");
            return (Criteria) this;
        }

        public Criteria andIsSellerRateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_seller_rate >=", value, "isSellerRate");
            return (Criteria) this;
        }

        public Criteria andIsSellerRateLessThan(Boolean value) {
            addCriterion("is_seller_rate <", value, "isSellerRate");
            return (Criteria) this;
        }

        public Criteria andIsSellerRateLessThanOrEqualTo(Boolean value) {
            addCriterion("is_seller_rate <=", value, "isSellerRate");
            return (Criteria) this;
        }

        public Criteria andIsSellerRateIn(List<Boolean> values) {
            addCriterion("is_seller_rate in", values, "isSellerRate");
            return (Criteria) this;
        }

        public Criteria andIsSellerRateNotIn(List<Boolean> values) {
            addCriterion("is_seller_rate not in", values, "isSellerRate");
            return (Criteria) this;
        }

        public Criteria andIsSellerRateBetween(Boolean value1, Boolean value2) {
            addCriterion("is_seller_rate between", value1, value2, "isSellerRate");
            return (Criteria) this;
        }

        public Criteria andIsSellerRateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_seller_rate not between", value1, value2, "isSellerRate");
            return (Criteria) this;
        }

        public Criteria andIsBuyerRateIsNull() {
            addCriterion("is_buyer_rate is null");
            return (Criteria) this;
        }

        public Criteria andIsBuyerRateIsNotNull() {
            addCriterion("is_buyer_rate is not null");
            return (Criteria) this;
        }

        public Criteria andIsBuyerRateEqualTo(Boolean value) {
            addCriterion("is_buyer_rate =", value, "isBuyerRate");
            return (Criteria) this;
        }

        public Criteria andIsBuyerRateNotEqualTo(Boolean value) {
            addCriterion("is_buyer_rate <>", value, "isBuyerRate");
            return (Criteria) this;
        }

        public Criteria andIsBuyerRateGreaterThan(Boolean value) {
            addCriterion("is_buyer_rate >", value, "isBuyerRate");
            return (Criteria) this;
        }

        public Criteria andIsBuyerRateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_buyer_rate >=", value, "isBuyerRate");
            return (Criteria) this;
        }

        public Criteria andIsBuyerRateLessThan(Boolean value) {
            addCriterion("is_buyer_rate <", value, "isBuyerRate");
            return (Criteria) this;
        }

        public Criteria andIsBuyerRateLessThanOrEqualTo(Boolean value) {
            addCriterion("is_buyer_rate <=", value, "isBuyerRate");
            return (Criteria) this;
        }

        public Criteria andIsBuyerRateIn(List<Boolean> values) {
            addCriterion("is_buyer_rate in", values, "isBuyerRate");
            return (Criteria) this;
        }

        public Criteria andIsBuyerRateNotIn(List<Boolean> values) {
            addCriterion("is_buyer_rate not in", values, "isBuyerRate");
            return (Criteria) this;
        }

        public Criteria andIsBuyerRateBetween(Boolean value1, Boolean value2) {
            addCriterion("is_buyer_rate between", value1, value2, "isBuyerRate");
            return (Criteria) this;
        }

        public Criteria andIsBuyerRateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_buyer_rate not between", value1, value2, "isBuyerRate");
            return (Criteria) this;
        }

        public Criteria andFilterTypeIsNull() {
            addCriterion("filter_type is null");
            return (Criteria) this;
        }

        public Criteria andFilterTypeIsNotNull() {
            addCriterion("filter_type is not null");
            return (Criteria) this;
        }

        public Criteria andFilterTypeEqualTo(Byte value) {
            addCriterion("filter_type =", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeNotEqualTo(Byte value) {
            addCriterion("filter_type <>", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeGreaterThan(Byte value) {
            addCriterion("filter_type >", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("filter_type >=", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeLessThan(Byte value) {
            addCriterion("filter_type <", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeLessThanOrEqualTo(Byte value) {
            addCriterion("filter_type <=", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeIn(List<Byte> values) {
            addCriterion("filter_type in", values, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeNotIn(List<Byte> values) {
            addCriterion("filter_type not in", values, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeBetween(Byte value1, Byte value2) {
            addCriterion("filter_type between", value1, value2, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("filter_type not between", value1, value2, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTimeIsNull() {
            addCriterion("filter_time is null");
            return (Criteria) this;
        }

        public Criteria andFilterTimeIsNotNull() {
            addCriterion("filter_time is not null");
            return (Criteria) this;
        }

        public Criteria andFilterTimeEqualTo(Date value) {
            addCriterion("filter_time =", value, "filterTime");
            return (Criteria) this;
        }

        public Criteria andFilterTimeNotEqualTo(Date value) {
            addCriterion("filter_time <>", value, "filterTime");
            return (Criteria) this;
        }

        public Criteria andFilterTimeGreaterThan(Date value) {
            addCriterion("filter_time >", value, "filterTime");
            return (Criteria) this;
        }

        public Criteria andFilterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("filter_time >=", value, "filterTime");
            return (Criteria) this;
        }

        public Criteria andFilterTimeLessThan(Date value) {
            addCriterion("filter_time <", value, "filterTime");
            return (Criteria) this;
        }

        public Criteria andFilterTimeLessThanOrEqualTo(Date value) {
            addCriterion("filter_time <=", value, "filterTime");
            return (Criteria) this;
        }

        public Criteria andFilterTimeIn(List<Date> values) {
            addCriterion("filter_time in", values, "filterTime");
            return (Criteria) this;
        }

        public Criteria andFilterTimeNotIn(List<Date> values) {
            addCriterion("filter_time not in", values, "filterTime");
            return (Criteria) this;
        }

        public Criteria andFilterTimeBetween(Date value1, Date value2) {
            addCriterion("filter_time between", value1, value2, "filterTime");
            return (Criteria) this;
        }

        public Criteria andFilterTimeNotBetween(Date value1, Date value2) {
            addCriterion("filter_time not between", value1, value2, "filterTime");
            return (Criteria) this;
        }

        public Criteria andRateTimeIsNull() {
            addCriterion("rate_time is null");
            return (Criteria) this;
        }

        public Criteria andRateTimeIsNotNull() {
            addCriterion("rate_time is not null");
            return (Criteria) this;
        }

        public Criteria andRateTimeEqualTo(Date value) {
            addCriterion("rate_time =", value, "rateTime");
            return (Criteria) this;
        }

        public Criteria andRateTimeNotEqualTo(Date value) {
            addCriterion("rate_time <>", value, "rateTime");
            return (Criteria) this;
        }

        public Criteria andRateTimeGreaterThan(Date value) {
            addCriterion("rate_time >", value, "rateTime");
            return (Criteria) this;
        }

        public Criteria andRateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rate_time >=", value, "rateTime");
            return (Criteria) this;
        }

        public Criteria andRateTimeLessThan(Date value) {
            addCriterion("rate_time <", value, "rateTime");
            return (Criteria) this;
        }

        public Criteria andRateTimeLessThanOrEqualTo(Date value) {
            addCriterion("rate_time <=", value, "rateTime");
            return (Criteria) this;
        }

        public Criteria andRateTimeIn(List<Date> values) {
            addCriterion("rate_time in", values, "rateTime");
            return (Criteria) this;
        }

        public Criteria andRateTimeNotIn(List<Date> values) {
            addCriterion("rate_time not in", values, "rateTime");
            return (Criteria) this;
        }

        public Criteria andRateTimeBetween(Date value1, Date value2) {
            addCriterion("rate_time between", value1, value2, "rateTime");
            return (Criteria) this;
        }

        public Criteria andRateTimeNotBetween(Date value1, Date value2) {
            addCriterion("rate_time not between", value1, value2, "rateTime");
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
}