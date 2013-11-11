package com.trilemon.boss360.rate.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RateSettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RateSettingExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected RateSettingExample(RateSettingExample example) {
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

        public Criteria andNickIsNull() {
            addCriterion("nick is null");
            return (Criteria) this;
        }

        public Criteria andNickIsNotNull() {
            addCriterion("nick is not null");
            return (Criteria) this;
        }

        public Criteria andNickEqualTo(String value) {
            addCriterion("nick =", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickNotEqualTo(String value) {
            addCriterion("nick <>", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickGreaterThan(String value) {
            addCriterion("nick >", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickGreaterThanOrEqualTo(String value) {
            addCriterion("nick >=", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickLessThan(String value) {
            addCriterion("nick <", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickLessThanOrEqualTo(String value) {
            addCriterion("nick <=", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickLike(String value) {
            addCriterion("nick like", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickNotLike(String value) {
            addCriterion("nick not like", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickIn(List<String> values) {
            addCriterion("nick in", values, "nick");
            return (Criteria) this;
        }

        public Criteria andNickNotIn(List<String> values) {
            addCriterion("nick not in", values, "nick");
            return (Criteria) this;
        }

        public Criteria andNickBetween(String value1, String value2) {
            addCriterion("nick between", value1, value2, "nick");
            return (Criteria) this;
        }

        public Criteria andNickNotBetween(String value1, String value2) {
            addCriterion("nick not between", value1, value2, "nick");
            return (Criteria) this;
        }

        public Criteria andIsExpiredIsNull() {
            addCriterion("is_expired is null");
            return (Criteria) this;
        }

        public Criteria andIsExpiredIsNotNull() {
            addCriterion("is_expired is not null");
            return (Criteria) this;
        }

        public Criteria andIsExpiredEqualTo(Integer value) {
            addCriterion("is_expired =", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredNotEqualTo(Integer value) {
            addCriterion("is_expired <>", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredGreaterThan(Integer value) {
            addCriterion("is_expired >", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_expired >=", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredLessThan(Integer value) {
            addCriterion("is_expired <", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredLessThanOrEqualTo(Integer value) {
            addCriterion("is_expired <=", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredIn(List<Integer> values) {
            addCriterion("is_expired in", values, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredNotIn(List<Integer> values) {
            addCriterion("is_expired not in", values, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredBetween(Integer value1, Integer value2) {
            addCriterion("is_expired between", value1, value2, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredNotBetween(Integer value1, Integer value2) {
            addCriterion("is_expired not between", value1, value2, "isExpired");
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

        public Criteria andAutoRateIsNull() {
            addCriterion("auto_rate is null");
            return (Criteria) this;
        }

        public Criteria andAutoRateIsNotNull() {
            addCriterion("auto_rate is not null");
            return (Criteria) this;
        }

        public Criteria andAutoRateEqualTo(Byte value) {
            addCriterion("auto_rate =", value, "autoRate");
            return (Criteria) this;
        }

        public Criteria andAutoRateNotEqualTo(Byte value) {
            addCriterion("auto_rate <>", value, "autoRate");
            return (Criteria) this;
        }

        public Criteria andAutoRateGreaterThan(Byte value) {
            addCriterion("auto_rate >", value, "autoRate");
            return (Criteria) this;
        }

        public Criteria andAutoRateGreaterThanOrEqualTo(Byte value) {
            addCriterion("auto_rate >=", value, "autoRate");
            return (Criteria) this;
        }

        public Criteria andAutoRateLessThan(Byte value) {
            addCriterion("auto_rate <", value, "autoRate");
            return (Criteria) this;
        }

        public Criteria andAutoRateLessThanOrEqualTo(Byte value) {
            addCriterion("auto_rate <=", value, "autoRate");
            return (Criteria) this;
        }

        public Criteria andAutoRateIn(List<Byte> values) {
            addCriterion("auto_rate in", values, "autoRate");
            return (Criteria) this;
        }

        public Criteria andAutoRateNotIn(List<Byte> values) {
            addCriterion("auto_rate not in", values, "autoRate");
            return (Criteria) this;
        }

        public Criteria andAutoRateBetween(Byte value1, Byte value2) {
            addCriterion("auto_rate between", value1, value2, "autoRate");
            return (Criteria) this;
        }

        public Criteria andAutoRateNotBetween(Byte value1, Byte value2) {
            addCriterion("auto_rate not between", value1, value2, "autoRate");
            return (Criteria) this;
        }

        public Criteria andNotifyIsNull() {
            addCriterion("notify is null");
            return (Criteria) this;
        }

        public Criteria andNotifyIsNotNull() {
            addCriterion("notify is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyEqualTo(Byte value) {
            addCriterion("notify =", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyNotEqualTo(Byte value) {
            addCriterion("notify <>", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyGreaterThan(Byte value) {
            addCriterion("notify >", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyGreaterThanOrEqualTo(Byte value) {
            addCriterion("notify >=", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyLessThan(Byte value) {
            addCriterion("notify <", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyLessThanOrEqualTo(Byte value) {
            addCriterion("notify <=", value, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyIn(List<Byte> values) {
            addCriterion("notify in", values, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyNotIn(List<Byte> values) {
            addCriterion("notify not in", values, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyBetween(Byte value1, Byte value2) {
            addCriterion("notify between", value1, value2, "notify");
            return (Criteria) this;
        }

        public Criteria andNotifyNotBetween(Byte value1, Byte value2) {
            addCriterion("notify not between", value1, value2, "notify");
            return (Criteria) this;
        }

        public Criteria andSmsNotifyPhoneIsNull() {
            addCriterion("sms_notify_phone is null");
            return (Criteria) this;
        }

        public Criteria andSmsNotifyPhoneIsNotNull() {
            addCriterion("sms_notify_phone is not null");
            return (Criteria) this;
        }

        public Criteria andSmsNotifyPhoneEqualTo(String value) {
            addCriterion("sms_notify_phone =", value, "smsNotifyPhone");
            return (Criteria) this;
        }

        public Criteria andSmsNotifyPhoneNotEqualTo(String value) {
            addCriterion("sms_notify_phone <>", value, "smsNotifyPhone");
            return (Criteria) this;
        }

        public Criteria andSmsNotifyPhoneGreaterThan(String value) {
            addCriterion("sms_notify_phone >", value, "smsNotifyPhone");
            return (Criteria) this;
        }

        public Criteria andSmsNotifyPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("sms_notify_phone >=", value, "smsNotifyPhone");
            return (Criteria) this;
        }

        public Criteria andSmsNotifyPhoneLessThan(String value) {
            addCriterion("sms_notify_phone <", value, "smsNotifyPhone");
            return (Criteria) this;
        }

        public Criteria andSmsNotifyPhoneLessThanOrEqualTo(String value) {
            addCriterion("sms_notify_phone <=", value, "smsNotifyPhone");
            return (Criteria) this;
        }

        public Criteria andSmsNotifyPhoneLike(String value) {
            addCriterion("sms_notify_phone like", value, "smsNotifyPhone");
            return (Criteria) this;
        }

        public Criteria andSmsNotifyPhoneNotLike(String value) {
            addCriterion("sms_notify_phone not like", value, "smsNotifyPhone");
            return (Criteria) this;
        }

        public Criteria andSmsNotifyPhoneIn(List<String> values) {
            addCriterion("sms_notify_phone in", values, "smsNotifyPhone");
            return (Criteria) this;
        }

        public Criteria andSmsNotifyPhoneNotIn(List<String> values) {
            addCriterion("sms_notify_phone not in", values, "smsNotifyPhone");
            return (Criteria) this;
        }

        public Criteria andSmsNotifyPhoneBetween(String value1, String value2) {
            addCriterion("sms_notify_phone between", value1, value2, "smsNotifyPhone");
            return (Criteria) this;
        }

        public Criteria andSmsNotifyPhoneNotBetween(String value1, String value2) {
            addCriterion("sms_notify_phone not between", value1, value2, "smsNotifyPhone");
            return (Criteria) this;
        }

        public Criteria andIsFilterCreditIsNull() {
            addCriterion("is_filter_credit is null");
            return (Criteria) this;
        }

        public Criteria andIsFilterCreditIsNotNull() {
            addCriterion("is_filter_credit is not null");
            return (Criteria) this;
        }

        public Criteria andIsFilterCreditEqualTo(Boolean value) {
            addCriterion("is_filter_credit =", value, "isFilterCredit");
            return (Criteria) this;
        }

        public Criteria andIsFilterCreditNotEqualTo(Boolean value) {
            addCriterion("is_filter_credit <>", value, "isFilterCredit");
            return (Criteria) this;
        }

        public Criteria andIsFilterCreditGreaterThan(Boolean value) {
            addCriterion("is_filter_credit >", value, "isFilterCredit");
            return (Criteria) this;
        }

        public Criteria andIsFilterCreditGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_filter_credit >=", value, "isFilterCredit");
            return (Criteria) this;
        }

        public Criteria andIsFilterCreditLessThan(Boolean value) {
            addCriterion("is_filter_credit <", value, "isFilterCredit");
            return (Criteria) this;
        }

        public Criteria andIsFilterCreditLessThanOrEqualTo(Boolean value) {
            addCriterion("is_filter_credit <=", value, "isFilterCredit");
            return (Criteria) this;
        }

        public Criteria andIsFilterCreditIn(List<Boolean> values) {
            addCriterion("is_filter_credit in", values, "isFilterCredit");
            return (Criteria) this;
        }

        public Criteria andIsFilterCreditNotIn(List<Boolean> values) {
            addCriterion("is_filter_credit not in", values, "isFilterCredit");
            return (Criteria) this;
        }

        public Criteria andIsFilterCreditBetween(Boolean value1, Boolean value2) {
            addCriterion("is_filter_credit between", value1, value2, "isFilterCredit");
            return (Criteria) this;
        }

        public Criteria andIsFilterCreditNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_filter_credit not between", value1, value2, "isFilterCredit");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMinIsNull() {
            addCriterion("filter_credit_min is null");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMinIsNotNull() {
            addCriterion("filter_credit_min is not null");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMinEqualTo(Integer value) {
            addCriterion("filter_credit_min =", value, "filterCreditMin");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMinNotEqualTo(Integer value) {
            addCriterion("filter_credit_min <>", value, "filterCreditMin");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMinGreaterThan(Integer value) {
            addCriterion("filter_credit_min >", value, "filterCreditMin");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("filter_credit_min >=", value, "filterCreditMin");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMinLessThan(Integer value) {
            addCriterion("filter_credit_min <", value, "filterCreditMin");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMinLessThanOrEqualTo(Integer value) {
            addCriterion("filter_credit_min <=", value, "filterCreditMin");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMinIn(List<Integer> values) {
            addCriterion("filter_credit_min in", values, "filterCreditMin");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMinNotIn(List<Integer> values) {
            addCriterion("filter_credit_min not in", values, "filterCreditMin");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMinBetween(Integer value1, Integer value2) {
            addCriterion("filter_credit_min between", value1, value2, "filterCreditMin");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMinNotBetween(Integer value1, Integer value2) {
            addCriterion("filter_credit_min not between", value1, value2, "filterCreditMin");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMaxIsNull() {
            addCriterion("filter_credit_max is null");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMaxIsNotNull() {
            addCriterion("filter_credit_max is not null");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMaxEqualTo(Integer value) {
            addCriterion("filter_credit_max =", value, "filterCreditMax");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMaxNotEqualTo(Integer value) {
            addCriterion("filter_credit_max <>", value, "filterCreditMax");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMaxGreaterThan(Integer value) {
            addCriterion("filter_credit_max >", value, "filterCreditMax");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("filter_credit_max >=", value, "filterCreditMax");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMaxLessThan(Integer value) {
            addCriterion("filter_credit_max <", value, "filterCreditMax");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMaxLessThanOrEqualTo(Integer value) {
            addCriterion("filter_credit_max <=", value, "filterCreditMax");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMaxIn(List<Integer> values) {
            addCriterion("filter_credit_max in", values, "filterCreditMax");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMaxNotIn(List<Integer> values) {
            addCriterion("filter_credit_max not in", values, "filterCreditMax");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMaxBetween(Integer value1, Integer value2) {
            addCriterion("filter_credit_max between", value1, value2, "filterCreditMax");
            return (Criteria) this;
        }

        public Criteria andFilterCreditMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("filter_credit_max not between", value1, value2, "filterCreditMax");
            return (Criteria) this;
        }

        public Criteria andIsFilterGoodRateIsNull() {
            addCriterion("is_filter_good_rate is null");
            return (Criteria) this;
        }

        public Criteria andIsFilterGoodRateIsNotNull() {
            addCriterion("is_filter_good_rate is not null");
            return (Criteria) this;
        }

        public Criteria andIsFilterGoodRateEqualTo(Boolean value) {
            addCriterion("is_filter_good_rate =", value, "isFilterGoodRate");
            return (Criteria) this;
        }

        public Criteria andIsFilterGoodRateNotEqualTo(Boolean value) {
            addCriterion("is_filter_good_rate <>", value, "isFilterGoodRate");
            return (Criteria) this;
        }

        public Criteria andIsFilterGoodRateGreaterThan(Boolean value) {
            addCriterion("is_filter_good_rate >", value, "isFilterGoodRate");
            return (Criteria) this;
        }

        public Criteria andIsFilterGoodRateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_filter_good_rate >=", value, "isFilterGoodRate");
            return (Criteria) this;
        }

        public Criteria andIsFilterGoodRateLessThan(Boolean value) {
            addCriterion("is_filter_good_rate <", value, "isFilterGoodRate");
            return (Criteria) this;
        }

        public Criteria andIsFilterGoodRateLessThanOrEqualTo(Boolean value) {
            addCriterion("is_filter_good_rate <=", value, "isFilterGoodRate");
            return (Criteria) this;
        }

        public Criteria andIsFilterGoodRateIn(List<Boolean> values) {
            addCriterion("is_filter_good_rate in", values, "isFilterGoodRate");
            return (Criteria) this;
        }

        public Criteria andIsFilterGoodRateNotIn(List<Boolean> values) {
            addCriterion("is_filter_good_rate not in", values, "isFilterGoodRate");
            return (Criteria) this;
        }

        public Criteria andIsFilterGoodRateBetween(Boolean value1, Boolean value2) {
            addCriterion("is_filter_good_rate between", value1, value2, "isFilterGoodRate");
            return (Criteria) this;
        }

        public Criteria andIsFilterGoodRateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_filter_good_rate not between", value1, value2, "isFilterGoodRate");
            return (Criteria) this;
        }

        public Criteria andFilterGoodRateIsNull() {
            addCriterion("filter_good_rate is null");
            return (Criteria) this;
        }

        public Criteria andFilterGoodRateIsNotNull() {
            addCriterion("filter_good_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFilterGoodRateEqualTo(Float value) {
            addCriterion("filter_good_rate =", value, "filterGoodRate");
            return (Criteria) this;
        }

        public Criteria andFilterGoodRateNotEqualTo(Float value) {
            addCriterion("filter_good_rate <>", value, "filterGoodRate");
            return (Criteria) this;
        }

        public Criteria andFilterGoodRateGreaterThan(Float value) {
            addCriterion("filter_good_rate >", value, "filterGoodRate");
            return (Criteria) this;
        }

        public Criteria andFilterGoodRateGreaterThanOrEqualTo(Float value) {
            addCriterion("filter_good_rate >=", value, "filterGoodRate");
            return (Criteria) this;
        }

        public Criteria andFilterGoodRateLessThan(Float value) {
            addCriterion("filter_good_rate <", value, "filterGoodRate");
            return (Criteria) this;
        }

        public Criteria andFilterGoodRateLessThanOrEqualTo(Float value) {
            addCriterion("filter_good_rate <=", value, "filterGoodRate");
            return (Criteria) this;
        }

        public Criteria andFilterGoodRateIn(List<Float> values) {
            addCriterion("filter_good_rate in", values, "filterGoodRate");
            return (Criteria) this;
        }

        public Criteria andFilterGoodRateNotIn(List<Float> values) {
            addCriterion("filter_good_rate not in", values, "filterGoodRate");
            return (Criteria) this;
        }

        public Criteria andFilterGoodRateBetween(Float value1, Float value2) {
            addCriterion("filter_good_rate between", value1, value2, "filterGoodRate");
            return (Criteria) this;
        }

        public Criteria andFilterGoodRateNotBetween(Float value1, Float value2) {
            addCriterion("filter_good_rate not between", value1, value2, "filterGoodRate");
            return (Criteria) this;
        }

        public Criteria andIsFilterBadRateIsNull() {
            addCriterion("is_filter_bad_rate is null");
            return (Criteria) this;
        }

        public Criteria andIsFilterBadRateIsNotNull() {
            addCriterion("is_filter_bad_rate is not null");
            return (Criteria) this;
        }

        public Criteria andIsFilterBadRateEqualTo(Boolean value) {
            addCriterion("is_filter_bad_rate =", value, "isFilterBadRate");
            return (Criteria) this;
        }

        public Criteria andIsFilterBadRateNotEqualTo(Boolean value) {
            addCriterion("is_filter_bad_rate <>", value, "isFilterBadRate");
            return (Criteria) this;
        }

        public Criteria andIsFilterBadRateGreaterThan(Boolean value) {
            addCriterion("is_filter_bad_rate >", value, "isFilterBadRate");
            return (Criteria) this;
        }

        public Criteria andIsFilterBadRateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_filter_bad_rate >=", value, "isFilterBadRate");
            return (Criteria) this;
        }

        public Criteria andIsFilterBadRateLessThan(Boolean value) {
            addCriterion("is_filter_bad_rate <", value, "isFilterBadRate");
            return (Criteria) this;
        }

        public Criteria andIsFilterBadRateLessThanOrEqualTo(Boolean value) {
            addCriterion("is_filter_bad_rate <=", value, "isFilterBadRate");
            return (Criteria) this;
        }

        public Criteria andIsFilterBadRateIn(List<Boolean> values) {
            addCriterion("is_filter_bad_rate in", values, "isFilterBadRate");
            return (Criteria) this;
        }

        public Criteria andIsFilterBadRateNotIn(List<Boolean> values) {
            addCriterion("is_filter_bad_rate not in", values, "isFilterBadRate");
            return (Criteria) this;
        }

        public Criteria andIsFilterBadRateBetween(Boolean value1, Boolean value2) {
            addCriterion("is_filter_bad_rate between", value1, value2, "isFilterBadRate");
            return (Criteria) this;
        }

        public Criteria andIsFilterBadRateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_filter_bad_rate not between", value1, value2, "isFilterBadRate");
            return (Criteria) this;
        }

        public Criteria andFilterBadRateCountIsNull() {
            addCriterion("filter_bad_rate_count is null");
            return (Criteria) this;
        }

        public Criteria andFilterBadRateCountIsNotNull() {
            addCriterion("filter_bad_rate_count is not null");
            return (Criteria) this;
        }

        public Criteria andFilterBadRateCountEqualTo(Float value) {
            addCriterion("filter_bad_rate_count =", value, "filterBadRateCount");
            return (Criteria) this;
        }

        public Criteria andFilterBadRateCountNotEqualTo(Float value) {
            addCriterion("filter_bad_rate_count <>", value, "filterBadRateCount");
            return (Criteria) this;
        }

        public Criteria andFilterBadRateCountGreaterThan(Float value) {
            addCriterion("filter_bad_rate_count >", value, "filterBadRateCount");
            return (Criteria) this;
        }

        public Criteria andFilterBadRateCountGreaterThanOrEqualTo(Float value) {
            addCriterion("filter_bad_rate_count >=", value, "filterBadRateCount");
            return (Criteria) this;
        }

        public Criteria andFilterBadRateCountLessThan(Float value) {
            addCriterion("filter_bad_rate_count <", value, "filterBadRateCount");
            return (Criteria) this;
        }

        public Criteria andFilterBadRateCountLessThanOrEqualTo(Float value) {
            addCriterion("filter_bad_rate_count <=", value, "filterBadRateCount");
            return (Criteria) this;
        }

        public Criteria andFilterBadRateCountIn(List<Float> values) {
            addCriterion("filter_bad_rate_count in", values, "filterBadRateCount");
            return (Criteria) this;
        }

        public Criteria andFilterBadRateCountNotIn(List<Float> values) {
            addCriterion("filter_bad_rate_count not in", values, "filterBadRateCount");
            return (Criteria) this;
        }

        public Criteria andFilterBadRateCountBetween(Float value1, Float value2) {
            addCriterion("filter_bad_rate_count between", value1, value2, "filterBadRateCount");
            return (Criteria) this;
        }

        public Criteria andFilterBadRateCountNotBetween(Float value1, Float value2) {
            addCriterion("filter_bad_rate_count not between", value1, value2, "filterBadRateCount");
            return (Criteria) this;
        }

        public Criteria andIsFilterRegisterDayIsNull() {
            addCriterion("is_filter_register_day is null");
            return (Criteria) this;
        }

        public Criteria andIsFilterRegisterDayIsNotNull() {
            addCriterion("is_filter_register_day is not null");
            return (Criteria) this;
        }

        public Criteria andIsFilterRegisterDayEqualTo(Boolean value) {
            addCriterion("is_filter_register_day =", value, "isFilterRegisterDay");
            return (Criteria) this;
        }

        public Criteria andIsFilterRegisterDayNotEqualTo(Boolean value) {
            addCriterion("is_filter_register_day <>", value, "isFilterRegisterDay");
            return (Criteria) this;
        }

        public Criteria andIsFilterRegisterDayGreaterThan(Boolean value) {
            addCriterion("is_filter_register_day >", value, "isFilterRegisterDay");
            return (Criteria) this;
        }

        public Criteria andIsFilterRegisterDayGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_filter_register_day >=", value, "isFilterRegisterDay");
            return (Criteria) this;
        }

        public Criteria andIsFilterRegisterDayLessThan(Boolean value) {
            addCriterion("is_filter_register_day <", value, "isFilterRegisterDay");
            return (Criteria) this;
        }

        public Criteria andIsFilterRegisterDayLessThanOrEqualTo(Boolean value) {
            addCriterion("is_filter_register_day <=", value, "isFilterRegisterDay");
            return (Criteria) this;
        }

        public Criteria andIsFilterRegisterDayIn(List<Boolean> values) {
            addCriterion("is_filter_register_day in", values, "isFilterRegisterDay");
            return (Criteria) this;
        }

        public Criteria andIsFilterRegisterDayNotIn(List<Boolean> values) {
            addCriterion("is_filter_register_day not in", values, "isFilterRegisterDay");
            return (Criteria) this;
        }

        public Criteria andIsFilterRegisterDayBetween(Boolean value1, Boolean value2) {
            addCriterion("is_filter_register_day between", value1, value2, "isFilterRegisterDay");
            return (Criteria) this;
        }

        public Criteria andIsFilterRegisterDayNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_filter_register_day not between", value1, value2, "isFilterRegisterDay");
            return (Criteria) this;
        }

        public Criteria andFilterRegisterDayIsNull() {
            addCriterion("filter_register_day is null");
            return (Criteria) this;
        }

        public Criteria andFilterRegisterDayIsNotNull() {
            addCriterion("filter_register_day is not null");
            return (Criteria) this;
        }

        public Criteria andFilterRegisterDayEqualTo(Integer value) {
            addCriterion("filter_register_day =", value, "filterRegisterDay");
            return (Criteria) this;
        }

        public Criteria andFilterRegisterDayNotEqualTo(Integer value) {
            addCriterion("filter_register_day <>", value, "filterRegisterDay");
            return (Criteria) this;
        }

        public Criteria andFilterRegisterDayGreaterThan(Integer value) {
            addCriterion("filter_register_day >", value, "filterRegisterDay");
            return (Criteria) this;
        }

        public Criteria andFilterRegisterDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("filter_register_day >=", value, "filterRegisterDay");
            return (Criteria) this;
        }

        public Criteria andFilterRegisterDayLessThan(Integer value) {
            addCriterion("filter_register_day <", value, "filterRegisterDay");
            return (Criteria) this;
        }

        public Criteria andFilterRegisterDayLessThanOrEqualTo(Integer value) {
            addCriterion("filter_register_day <=", value, "filterRegisterDay");
            return (Criteria) this;
        }

        public Criteria andFilterRegisterDayIn(List<Integer> values) {
            addCriterion("filter_register_day in", values, "filterRegisterDay");
            return (Criteria) this;
        }

        public Criteria andFilterRegisterDayNotIn(List<Integer> values) {
            addCriterion("filter_register_day not in", values, "filterRegisterDay");
            return (Criteria) this;
        }

        public Criteria andFilterRegisterDayBetween(Integer value1, Integer value2) {
            addCriterion("filter_register_day between", value1, value2, "filterRegisterDay");
            return (Criteria) this;
        }

        public Criteria andFilterRegisterDayNotBetween(Integer value1, Integer value2) {
            addCriterion("filter_register_day not between", value1, value2, "filterRegisterDay");
            return (Criteria) this;
        }

        public Criteria andIsFilterBlacklistIsNull() {
            addCriterion("is_filter_blacklist is null");
            return (Criteria) this;
        }

        public Criteria andIsFilterBlacklistIsNotNull() {
            addCriterion("is_filter_blacklist is not null");
            return (Criteria) this;
        }

        public Criteria andIsFilterBlacklistEqualTo(Boolean value) {
            addCriterion("is_filter_blacklist =", value, "isFilterBlacklist");
            return (Criteria) this;
        }

        public Criteria andIsFilterBlacklistNotEqualTo(Boolean value) {
            addCriterion("is_filter_blacklist <>", value, "isFilterBlacklist");
            return (Criteria) this;
        }

        public Criteria andIsFilterBlacklistGreaterThan(Boolean value) {
            addCriterion("is_filter_blacklist >", value, "isFilterBlacklist");
            return (Criteria) this;
        }

        public Criteria andIsFilterBlacklistGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_filter_blacklist >=", value, "isFilterBlacklist");
            return (Criteria) this;
        }

        public Criteria andIsFilterBlacklistLessThan(Boolean value) {
            addCriterion("is_filter_blacklist <", value, "isFilterBlacklist");
            return (Criteria) this;
        }

        public Criteria andIsFilterBlacklistLessThanOrEqualTo(Boolean value) {
            addCriterion("is_filter_blacklist <=", value, "isFilterBlacklist");
            return (Criteria) this;
        }

        public Criteria andIsFilterBlacklistIn(List<Boolean> values) {
            addCriterion("is_filter_blacklist in", values, "isFilterBlacklist");
            return (Criteria) this;
        }

        public Criteria andIsFilterBlacklistNotIn(List<Boolean> values) {
            addCriterion("is_filter_blacklist not in", values, "isFilterBlacklist");
            return (Criteria) this;
        }

        public Criteria andIsFilterBlacklistBetween(Boolean value1, Boolean value2) {
            addCriterion("is_filter_blacklist between", value1, value2, "isFilterBlacklist");
            return (Criteria) this;
        }

        public Criteria andIsFilterBlacklistNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_filter_blacklist not between", value1, value2, "isFilterBlacklist");
            return (Criteria) this;
        }

        public Criteria andLastRateTimeIsNull() {
            addCriterion("last_rate_time is null");
            return (Criteria) this;
        }

        public Criteria andLastRateTimeIsNotNull() {
            addCriterion("last_rate_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastRateTimeEqualTo(Date value) {
            addCriterion("last_rate_time =", value, "lastRateTime");
            return (Criteria) this;
        }

        public Criteria andLastRateTimeNotEqualTo(Date value) {
            addCriterion("last_rate_time <>", value, "lastRateTime");
            return (Criteria) this;
        }

        public Criteria andLastRateTimeGreaterThan(Date value) {
            addCriterion("last_rate_time >", value, "lastRateTime");
            return (Criteria) this;
        }

        public Criteria andLastRateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_rate_time >=", value, "lastRateTime");
            return (Criteria) this;
        }

        public Criteria andLastRateTimeLessThan(Date value) {
            addCriterion("last_rate_time <", value, "lastRateTime");
            return (Criteria) this;
        }

        public Criteria andLastRateTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_rate_time <=", value, "lastRateTime");
            return (Criteria) this;
        }

        public Criteria andLastRateTimeIn(List<Date> values) {
            addCriterion("last_rate_time in", values, "lastRateTime");
            return (Criteria) this;
        }

        public Criteria andLastRateTimeNotIn(List<Date> values) {
            addCriterion("last_rate_time not in", values, "lastRateTime");
            return (Criteria) this;
        }

        public Criteria andLastRateTimeBetween(Date value1, Date value2) {
            addCriterion("last_rate_time between", value1, value2, "lastRateTime");
            return (Criteria) this;
        }

        public Criteria andLastRateTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_rate_time not between", value1, value2, "lastRateTime");
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