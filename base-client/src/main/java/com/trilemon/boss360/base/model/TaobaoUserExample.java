package com.trilemon.boss360.base.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TaobaoUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaobaoUserExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditLevelIsNull() {
            addCriterion("buyer_credit_level is null");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditLevelIsNotNull() {
            addCriterion("buyer_credit_level is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditLevelEqualTo(Byte value) {
            addCriterion("buyer_credit_level =", value, "buyerCreditLevel");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditLevelNotEqualTo(Byte value) {
            addCriterion("buyer_credit_level <>", value, "buyerCreditLevel");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditLevelGreaterThan(Byte value) {
            addCriterion("buyer_credit_level >", value, "buyerCreditLevel");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("buyer_credit_level >=", value, "buyerCreditLevel");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditLevelLessThan(Byte value) {
            addCriterion("buyer_credit_level <", value, "buyerCreditLevel");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditLevelLessThanOrEqualTo(Byte value) {
            addCriterion("buyer_credit_level <=", value, "buyerCreditLevel");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditLevelIn(List<Byte> values) {
            addCriterion("buyer_credit_level in", values, "buyerCreditLevel");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditLevelNotIn(List<Byte> values) {
            addCriterion("buyer_credit_level not in", values, "buyerCreditLevel");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditLevelBetween(Byte value1, Byte value2) {
            addCriterion("buyer_credit_level between", value1, value2, "buyerCreditLevel");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("buyer_credit_level not between", value1, value2, "buyerCreditLevel");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditScoreIsNull() {
            addCriterion("buyer_credit_score is null");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditScoreIsNotNull() {
            addCriterion("buyer_credit_score is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditScoreEqualTo(Integer value) {
            addCriterion("buyer_credit_score =", value, "buyerCreditScore");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditScoreNotEqualTo(Integer value) {
            addCriterion("buyer_credit_score <>", value, "buyerCreditScore");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditScoreGreaterThan(Integer value) {
            addCriterion("buyer_credit_score >", value, "buyerCreditScore");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("buyer_credit_score >=", value, "buyerCreditScore");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditScoreLessThan(Integer value) {
            addCriterion("buyer_credit_score <", value, "buyerCreditScore");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditScoreLessThanOrEqualTo(Integer value) {
            addCriterion("buyer_credit_score <=", value, "buyerCreditScore");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditScoreIn(List<Integer> values) {
            addCriterion("buyer_credit_score in", values, "buyerCreditScore");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditScoreNotIn(List<Integer> values) {
            addCriterion("buyer_credit_score not in", values, "buyerCreditScore");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditScoreBetween(Integer value1, Integer value2) {
            addCriterion("buyer_credit_score between", value1, value2, "buyerCreditScore");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("buyer_credit_score not between", value1, value2, "buyerCreditScore");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditTotalNumIsNull() {
            addCriterion("buyer_credit_total_num is null");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditTotalNumIsNotNull() {
            addCriterion("buyer_credit_total_num is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditTotalNumEqualTo(Integer value) {
            addCriterion("buyer_credit_total_num =", value, "buyerCreditTotalNum");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditTotalNumNotEqualTo(Integer value) {
            addCriterion("buyer_credit_total_num <>", value, "buyerCreditTotalNum");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditTotalNumGreaterThan(Integer value) {
            addCriterion("buyer_credit_total_num >", value, "buyerCreditTotalNum");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditTotalNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("buyer_credit_total_num >=", value, "buyerCreditTotalNum");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditTotalNumLessThan(Integer value) {
            addCriterion("buyer_credit_total_num <", value, "buyerCreditTotalNum");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditTotalNumLessThanOrEqualTo(Integer value) {
            addCriterion("buyer_credit_total_num <=", value, "buyerCreditTotalNum");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditTotalNumIn(List<Integer> values) {
            addCriterion("buyer_credit_total_num in", values, "buyerCreditTotalNum");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditTotalNumNotIn(List<Integer> values) {
            addCriterion("buyer_credit_total_num not in", values, "buyerCreditTotalNum");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditTotalNumBetween(Integer value1, Integer value2) {
            addCriterion("buyer_credit_total_num between", value1, value2, "buyerCreditTotalNum");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditTotalNumNotBetween(Integer value1, Integer value2) {
            addCriterion("buyer_credit_total_num not between", value1, value2, "buyerCreditTotalNum");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditGoodNumIsNull() {
            addCriterion("buyer_credit_good_num is null");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditGoodNumIsNotNull() {
            addCriterion("buyer_credit_good_num is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditGoodNumEqualTo(Integer value) {
            addCriterion("buyer_credit_good_num =", value, "buyerCreditGoodNum");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditGoodNumNotEqualTo(Integer value) {
            addCriterion("buyer_credit_good_num <>", value, "buyerCreditGoodNum");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditGoodNumGreaterThan(Integer value) {
            addCriterion("buyer_credit_good_num >", value, "buyerCreditGoodNum");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditGoodNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("buyer_credit_good_num >=", value, "buyerCreditGoodNum");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditGoodNumLessThan(Integer value) {
            addCriterion("buyer_credit_good_num <", value, "buyerCreditGoodNum");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditGoodNumLessThanOrEqualTo(Integer value) {
            addCriterion("buyer_credit_good_num <=", value, "buyerCreditGoodNum");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditGoodNumIn(List<Integer> values) {
            addCriterion("buyer_credit_good_num in", values, "buyerCreditGoodNum");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditGoodNumNotIn(List<Integer> values) {
            addCriterion("buyer_credit_good_num not in", values, "buyerCreditGoodNum");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditGoodNumBetween(Integer value1, Integer value2) {
            addCriterion("buyer_credit_good_num between", value1, value2, "buyerCreditGoodNum");
            return (Criteria) this;
        }

        public Criteria andBuyerCreditGoodNumNotBetween(Integer value1, Integer value2) {
            addCriterion("buyer_credit_good_num not between", value1, value2, "buyerCreditGoodNum");
            return (Criteria) this;
        }

        public Criteria andSellerCreditLevelIsNull() {
            addCriterion("seller_credit_level is null");
            return (Criteria) this;
        }

        public Criteria andSellerCreditLevelIsNotNull() {
            addCriterion("seller_credit_level is not null");
            return (Criteria) this;
        }

        public Criteria andSellerCreditLevelEqualTo(Byte value) {
            addCriterion("seller_credit_level =", value, "sellerCreditLevel");
            return (Criteria) this;
        }

        public Criteria andSellerCreditLevelNotEqualTo(Byte value) {
            addCriterion("seller_credit_level <>", value, "sellerCreditLevel");
            return (Criteria) this;
        }

        public Criteria andSellerCreditLevelGreaterThan(Byte value) {
            addCriterion("seller_credit_level >", value, "sellerCreditLevel");
            return (Criteria) this;
        }

        public Criteria andSellerCreditLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("seller_credit_level >=", value, "sellerCreditLevel");
            return (Criteria) this;
        }

        public Criteria andSellerCreditLevelLessThan(Byte value) {
            addCriterion("seller_credit_level <", value, "sellerCreditLevel");
            return (Criteria) this;
        }

        public Criteria andSellerCreditLevelLessThanOrEqualTo(Byte value) {
            addCriterion("seller_credit_level <=", value, "sellerCreditLevel");
            return (Criteria) this;
        }

        public Criteria andSellerCreditLevelIn(List<Byte> values) {
            addCriterion("seller_credit_level in", values, "sellerCreditLevel");
            return (Criteria) this;
        }

        public Criteria andSellerCreditLevelNotIn(List<Byte> values) {
            addCriterion("seller_credit_level not in", values, "sellerCreditLevel");
            return (Criteria) this;
        }

        public Criteria andSellerCreditLevelBetween(Byte value1, Byte value2) {
            addCriterion("seller_credit_level between", value1, value2, "sellerCreditLevel");
            return (Criteria) this;
        }

        public Criteria andSellerCreditLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("seller_credit_level not between", value1, value2, "sellerCreditLevel");
            return (Criteria) this;
        }

        public Criteria andSellerCreditScoreIsNull() {
            addCriterion("seller_credit_score is null");
            return (Criteria) this;
        }

        public Criteria andSellerCreditScoreIsNotNull() {
            addCriterion("seller_credit_score is not null");
            return (Criteria) this;
        }

        public Criteria andSellerCreditScoreEqualTo(Integer value) {
            addCriterion("seller_credit_score =", value, "sellerCreditScore");
            return (Criteria) this;
        }

        public Criteria andSellerCreditScoreNotEqualTo(Integer value) {
            addCriterion("seller_credit_score <>", value, "sellerCreditScore");
            return (Criteria) this;
        }

        public Criteria andSellerCreditScoreGreaterThan(Integer value) {
            addCriterion("seller_credit_score >", value, "sellerCreditScore");
            return (Criteria) this;
        }

        public Criteria andSellerCreditScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("seller_credit_score >=", value, "sellerCreditScore");
            return (Criteria) this;
        }

        public Criteria andSellerCreditScoreLessThan(Integer value) {
            addCriterion("seller_credit_score <", value, "sellerCreditScore");
            return (Criteria) this;
        }

        public Criteria andSellerCreditScoreLessThanOrEqualTo(Integer value) {
            addCriterion("seller_credit_score <=", value, "sellerCreditScore");
            return (Criteria) this;
        }

        public Criteria andSellerCreditScoreIn(List<Integer> values) {
            addCriterion("seller_credit_score in", values, "sellerCreditScore");
            return (Criteria) this;
        }

        public Criteria andSellerCreditScoreNotIn(List<Integer> values) {
            addCriterion("seller_credit_score not in", values, "sellerCreditScore");
            return (Criteria) this;
        }

        public Criteria andSellerCreditScoreBetween(Integer value1, Integer value2) {
            addCriterion("seller_credit_score between", value1, value2, "sellerCreditScore");
            return (Criteria) this;
        }

        public Criteria andSellerCreditScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("seller_credit_score not between", value1, value2, "sellerCreditScore");
            return (Criteria) this;
        }

        public Criteria andSellerCreditTotalNumIsNull() {
            addCriterion("seller_credit_total_num is null");
            return (Criteria) this;
        }

        public Criteria andSellerCreditTotalNumIsNotNull() {
            addCriterion("seller_credit_total_num is not null");
            return (Criteria) this;
        }

        public Criteria andSellerCreditTotalNumEqualTo(Integer value) {
            addCriterion("seller_credit_total_num =", value, "sellerCreditTotalNum");
            return (Criteria) this;
        }

        public Criteria andSellerCreditTotalNumNotEqualTo(Integer value) {
            addCriterion("seller_credit_total_num <>", value, "sellerCreditTotalNum");
            return (Criteria) this;
        }

        public Criteria andSellerCreditTotalNumGreaterThan(Integer value) {
            addCriterion("seller_credit_total_num >", value, "sellerCreditTotalNum");
            return (Criteria) this;
        }

        public Criteria andSellerCreditTotalNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("seller_credit_total_num >=", value, "sellerCreditTotalNum");
            return (Criteria) this;
        }

        public Criteria andSellerCreditTotalNumLessThan(Integer value) {
            addCriterion("seller_credit_total_num <", value, "sellerCreditTotalNum");
            return (Criteria) this;
        }

        public Criteria andSellerCreditTotalNumLessThanOrEqualTo(Integer value) {
            addCriterion("seller_credit_total_num <=", value, "sellerCreditTotalNum");
            return (Criteria) this;
        }

        public Criteria andSellerCreditTotalNumIn(List<Integer> values) {
            addCriterion("seller_credit_total_num in", values, "sellerCreditTotalNum");
            return (Criteria) this;
        }

        public Criteria andSellerCreditTotalNumNotIn(List<Integer> values) {
            addCriterion("seller_credit_total_num not in", values, "sellerCreditTotalNum");
            return (Criteria) this;
        }

        public Criteria andSellerCreditTotalNumBetween(Integer value1, Integer value2) {
            addCriterion("seller_credit_total_num between", value1, value2, "sellerCreditTotalNum");
            return (Criteria) this;
        }

        public Criteria andSellerCreditTotalNumNotBetween(Integer value1, Integer value2) {
            addCriterion("seller_credit_total_num not between", value1, value2, "sellerCreditTotalNum");
            return (Criteria) this;
        }

        public Criteria andSellerCreditGoodNumIsNull() {
            addCriterion("seller_credit_good_num is null");
            return (Criteria) this;
        }

        public Criteria andSellerCreditGoodNumIsNotNull() {
            addCriterion("seller_credit_good_num is not null");
            return (Criteria) this;
        }

        public Criteria andSellerCreditGoodNumEqualTo(Integer value) {
            addCriterion("seller_credit_good_num =", value, "sellerCreditGoodNum");
            return (Criteria) this;
        }

        public Criteria andSellerCreditGoodNumNotEqualTo(Integer value) {
            addCriterion("seller_credit_good_num <>", value, "sellerCreditGoodNum");
            return (Criteria) this;
        }

        public Criteria andSellerCreditGoodNumGreaterThan(Integer value) {
            addCriterion("seller_credit_good_num >", value, "sellerCreditGoodNum");
            return (Criteria) this;
        }

        public Criteria andSellerCreditGoodNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("seller_credit_good_num >=", value, "sellerCreditGoodNum");
            return (Criteria) this;
        }

        public Criteria andSellerCreditGoodNumLessThan(Integer value) {
            addCriterion("seller_credit_good_num <", value, "sellerCreditGoodNum");
            return (Criteria) this;
        }

        public Criteria andSellerCreditGoodNumLessThanOrEqualTo(Integer value) {
            addCriterion("seller_credit_good_num <=", value, "sellerCreditGoodNum");
            return (Criteria) this;
        }

        public Criteria andSellerCreditGoodNumIn(List<Integer> values) {
            addCriterion("seller_credit_good_num in", values, "sellerCreditGoodNum");
            return (Criteria) this;
        }

        public Criteria andSellerCreditGoodNumNotIn(List<Integer> values) {
            addCriterion("seller_credit_good_num not in", values, "sellerCreditGoodNum");
            return (Criteria) this;
        }

        public Criteria andSellerCreditGoodNumBetween(Integer value1, Integer value2) {
            addCriterion("seller_credit_good_num between", value1, value2, "sellerCreditGoodNum");
            return (Criteria) this;
        }

        public Criteria andSellerCreditGoodNumNotBetween(Integer value1, Integer value2) {
            addCriterion("seller_credit_good_num not between", value1, value2, "sellerCreditGoodNum");
            return (Criteria) this;
        }

        public Criteria andLocationCountryIsNull() {
            addCriterion("location_country is null");
            return (Criteria) this;
        }

        public Criteria andLocationCountryIsNotNull() {
            addCriterion("location_country is not null");
            return (Criteria) this;
        }

        public Criteria andLocationCountryEqualTo(String value) {
            addCriterion("location_country =", value, "locationCountry");
            return (Criteria) this;
        }

        public Criteria andLocationCountryNotEqualTo(String value) {
            addCriterion("location_country <>", value, "locationCountry");
            return (Criteria) this;
        }

        public Criteria andLocationCountryGreaterThan(String value) {
            addCriterion("location_country >", value, "locationCountry");
            return (Criteria) this;
        }

        public Criteria andLocationCountryGreaterThanOrEqualTo(String value) {
            addCriterion("location_country >=", value, "locationCountry");
            return (Criteria) this;
        }

        public Criteria andLocationCountryLessThan(String value) {
            addCriterion("location_country <", value, "locationCountry");
            return (Criteria) this;
        }

        public Criteria andLocationCountryLessThanOrEqualTo(String value) {
            addCriterion("location_country <=", value, "locationCountry");
            return (Criteria) this;
        }

        public Criteria andLocationCountryLike(String value) {
            addCriterion("location_country like", value, "locationCountry");
            return (Criteria) this;
        }

        public Criteria andLocationCountryNotLike(String value) {
            addCriterion("location_country not like", value, "locationCountry");
            return (Criteria) this;
        }

        public Criteria andLocationCountryIn(List<String> values) {
            addCriterion("location_country in", values, "locationCountry");
            return (Criteria) this;
        }

        public Criteria andLocationCountryNotIn(List<String> values) {
            addCriterion("location_country not in", values, "locationCountry");
            return (Criteria) this;
        }

        public Criteria andLocationCountryBetween(String value1, String value2) {
            addCriterion("location_country between", value1, value2, "locationCountry");
            return (Criteria) this;
        }

        public Criteria andLocationCountryNotBetween(String value1, String value2) {
            addCriterion("location_country not between", value1, value2, "locationCountry");
            return (Criteria) this;
        }

        public Criteria andLocationStateIsNull() {
            addCriterion("location_state is null");
            return (Criteria) this;
        }

        public Criteria andLocationStateIsNotNull() {
            addCriterion("location_state is not null");
            return (Criteria) this;
        }

        public Criteria andLocationStateEqualTo(String value) {
            addCriterion("location_state =", value, "locationState");
            return (Criteria) this;
        }

        public Criteria andLocationStateNotEqualTo(String value) {
            addCriterion("location_state <>", value, "locationState");
            return (Criteria) this;
        }

        public Criteria andLocationStateGreaterThan(String value) {
            addCriterion("location_state >", value, "locationState");
            return (Criteria) this;
        }

        public Criteria andLocationStateGreaterThanOrEqualTo(String value) {
            addCriterion("location_state >=", value, "locationState");
            return (Criteria) this;
        }

        public Criteria andLocationStateLessThan(String value) {
            addCriterion("location_state <", value, "locationState");
            return (Criteria) this;
        }

        public Criteria andLocationStateLessThanOrEqualTo(String value) {
            addCriterion("location_state <=", value, "locationState");
            return (Criteria) this;
        }

        public Criteria andLocationStateLike(String value) {
            addCriterion("location_state like", value, "locationState");
            return (Criteria) this;
        }

        public Criteria andLocationStateNotLike(String value) {
            addCriterion("location_state not like", value, "locationState");
            return (Criteria) this;
        }

        public Criteria andLocationStateIn(List<String> values) {
            addCriterion("location_state in", values, "locationState");
            return (Criteria) this;
        }

        public Criteria andLocationStateNotIn(List<String> values) {
            addCriterion("location_state not in", values, "locationState");
            return (Criteria) this;
        }

        public Criteria andLocationStateBetween(String value1, String value2) {
            addCriterion("location_state between", value1, value2, "locationState");
            return (Criteria) this;
        }

        public Criteria andLocationStateNotBetween(String value1, String value2) {
            addCriterion("location_state not between", value1, value2, "locationState");
            return (Criteria) this;
        }

        public Criteria andLocationCityIsNull() {
            addCriterion("location_city is null");
            return (Criteria) this;
        }

        public Criteria andLocationCityIsNotNull() {
            addCriterion("location_city is not null");
            return (Criteria) this;
        }

        public Criteria andLocationCityEqualTo(String value) {
            addCriterion("location_city =", value, "locationCity");
            return (Criteria) this;
        }

        public Criteria andLocationCityNotEqualTo(String value) {
            addCriterion("location_city <>", value, "locationCity");
            return (Criteria) this;
        }

        public Criteria andLocationCityGreaterThan(String value) {
            addCriterion("location_city >", value, "locationCity");
            return (Criteria) this;
        }

        public Criteria andLocationCityGreaterThanOrEqualTo(String value) {
            addCriterion("location_city >=", value, "locationCity");
            return (Criteria) this;
        }

        public Criteria andLocationCityLessThan(String value) {
            addCriterion("location_city <", value, "locationCity");
            return (Criteria) this;
        }

        public Criteria andLocationCityLessThanOrEqualTo(String value) {
            addCriterion("location_city <=", value, "locationCity");
            return (Criteria) this;
        }

        public Criteria andLocationCityLike(String value) {
            addCriterion("location_city like", value, "locationCity");
            return (Criteria) this;
        }

        public Criteria andLocationCityNotLike(String value) {
            addCriterion("location_city not like", value, "locationCity");
            return (Criteria) this;
        }

        public Criteria andLocationCityIn(List<String> values) {
            addCriterion("location_city in", values, "locationCity");
            return (Criteria) this;
        }

        public Criteria andLocationCityNotIn(List<String> values) {
            addCriterion("location_city not in", values, "locationCity");
            return (Criteria) this;
        }

        public Criteria andLocationCityBetween(String value1, String value2) {
            addCriterion("location_city between", value1, value2, "locationCity");
            return (Criteria) this;
        }

        public Criteria andLocationCityNotBetween(String value1, String value2) {
            addCriterion("location_city not between", value1, value2, "locationCity");
            return (Criteria) this;
        }

        public Criteria andLocationDistrictIsNull() {
            addCriterion("location_district is null");
            return (Criteria) this;
        }

        public Criteria andLocationDistrictIsNotNull() {
            addCriterion("location_district is not null");
            return (Criteria) this;
        }

        public Criteria andLocationDistrictEqualTo(String value) {
            addCriterion("location_district =", value, "locationDistrict");
            return (Criteria) this;
        }

        public Criteria andLocationDistrictNotEqualTo(String value) {
            addCriterion("location_district <>", value, "locationDistrict");
            return (Criteria) this;
        }

        public Criteria andLocationDistrictGreaterThan(String value) {
            addCriterion("location_district >", value, "locationDistrict");
            return (Criteria) this;
        }

        public Criteria andLocationDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("location_district >=", value, "locationDistrict");
            return (Criteria) this;
        }

        public Criteria andLocationDistrictLessThan(String value) {
            addCriterion("location_district <", value, "locationDistrict");
            return (Criteria) this;
        }

        public Criteria andLocationDistrictLessThanOrEqualTo(String value) {
            addCriterion("location_district <=", value, "locationDistrict");
            return (Criteria) this;
        }

        public Criteria andLocationDistrictLike(String value) {
            addCriterion("location_district like", value, "locationDistrict");
            return (Criteria) this;
        }

        public Criteria andLocationDistrictNotLike(String value) {
            addCriterion("location_district not like", value, "locationDistrict");
            return (Criteria) this;
        }

        public Criteria andLocationDistrictIn(List<String> values) {
            addCriterion("location_district in", values, "locationDistrict");
            return (Criteria) this;
        }

        public Criteria andLocationDistrictNotIn(List<String> values) {
            addCriterion("location_district not in", values, "locationDistrict");
            return (Criteria) this;
        }

        public Criteria andLocationDistrictBetween(String value1, String value2) {
            addCriterion("location_district between", value1, value2, "locationDistrict");
            return (Criteria) this;
        }

        public Criteria andLocationDistrictNotBetween(String value1, String value2) {
            addCriterion("location_district not between", value1, value2, "locationDistrict");
            return (Criteria) this;
        }

        public Criteria andLocationAddressIsNull() {
            addCriterion("location_address is null");
            return (Criteria) this;
        }

        public Criteria andLocationAddressIsNotNull() {
            addCriterion("location_address is not null");
            return (Criteria) this;
        }

        public Criteria andLocationAddressEqualTo(String value) {
            addCriterion("location_address =", value, "locationAddress");
            return (Criteria) this;
        }

        public Criteria andLocationAddressNotEqualTo(String value) {
            addCriterion("location_address <>", value, "locationAddress");
            return (Criteria) this;
        }

        public Criteria andLocationAddressGreaterThan(String value) {
            addCriterion("location_address >", value, "locationAddress");
            return (Criteria) this;
        }

        public Criteria andLocationAddressGreaterThanOrEqualTo(String value) {
            addCriterion("location_address >=", value, "locationAddress");
            return (Criteria) this;
        }

        public Criteria andLocationAddressLessThan(String value) {
            addCriterion("location_address <", value, "locationAddress");
            return (Criteria) this;
        }

        public Criteria andLocationAddressLessThanOrEqualTo(String value) {
            addCriterion("location_address <=", value, "locationAddress");
            return (Criteria) this;
        }

        public Criteria andLocationAddressLike(String value) {
            addCriterion("location_address like", value, "locationAddress");
            return (Criteria) this;
        }

        public Criteria andLocationAddressNotLike(String value) {
            addCriterion("location_address not like", value, "locationAddress");
            return (Criteria) this;
        }

        public Criteria andLocationAddressIn(List<String> values) {
            addCriterion("location_address in", values, "locationAddress");
            return (Criteria) this;
        }

        public Criteria andLocationAddressNotIn(List<String> values) {
            addCriterion("location_address not in", values, "locationAddress");
            return (Criteria) this;
        }

        public Criteria andLocationAddressBetween(String value1, String value2) {
            addCriterion("location_address between", value1, value2, "locationAddress");
            return (Criteria) this;
        }

        public Criteria andLocationAddressNotBetween(String value1, String value2) {
            addCriterion("location_address not between", value1, value2, "locationAddress");
            return (Criteria) this;
        }

        public Criteria andLocationZipIsNull() {
            addCriterion("location_zip is null");
            return (Criteria) this;
        }

        public Criteria andLocationZipIsNotNull() {
            addCriterion("location_zip is not null");
            return (Criteria) this;
        }

        public Criteria andLocationZipEqualTo(String value) {
            addCriterion("location_zip =", value, "locationZip");
            return (Criteria) this;
        }

        public Criteria andLocationZipNotEqualTo(String value) {
            addCriterion("location_zip <>", value, "locationZip");
            return (Criteria) this;
        }

        public Criteria andLocationZipGreaterThan(String value) {
            addCriterion("location_zip >", value, "locationZip");
            return (Criteria) this;
        }

        public Criteria andLocationZipGreaterThanOrEqualTo(String value) {
            addCriterion("location_zip >=", value, "locationZip");
            return (Criteria) this;
        }

        public Criteria andLocationZipLessThan(String value) {
            addCriterion("location_zip <", value, "locationZip");
            return (Criteria) this;
        }

        public Criteria andLocationZipLessThanOrEqualTo(String value) {
            addCriterion("location_zip <=", value, "locationZip");
            return (Criteria) this;
        }

        public Criteria andLocationZipLike(String value) {
            addCriterion("location_zip like", value, "locationZip");
            return (Criteria) this;
        }

        public Criteria andLocationZipNotLike(String value) {
            addCriterion("location_zip not like", value, "locationZip");
            return (Criteria) this;
        }

        public Criteria andLocationZipIn(List<String> values) {
            addCriterion("location_zip in", values, "locationZip");
            return (Criteria) this;
        }

        public Criteria andLocationZipNotIn(List<String> values) {
            addCriterion("location_zip not in", values, "locationZip");
            return (Criteria) this;
        }

        public Criteria andLocationZipBetween(String value1, String value2) {
            addCriterion("location_zip between", value1, value2, "locationZip");
            return (Criteria) this;
        }

        public Criteria andLocationZipNotBetween(String value1, String value2) {
            addCriterion("location_zip not between", value1, value2, "locationZip");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andLastVisitIsNull() {
            addCriterion("last_visit is null");
            return (Criteria) this;
        }

        public Criteria andLastVisitIsNotNull() {
            addCriterion("last_visit is not null");
            return (Criteria) this;
        }

        public Criteria andLastVisitEqualTo(Date value) {
            addCriterion("last_visit =", value, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitNotEqualTo(Date value) {
            addCriterion("last_visit <>", value, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitGreaterThan(Date value) {
            addCriterion("last_visit >", value, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitGreaterThanOrEqualTo(Date value) {
            addCriterion("last_visit >=", value, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitLessThan(Date value) {
            addCriterion("last_visit <", value, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitLessThanOrEqualTo(Date value) {
            addCriterion("last_visit <=", value, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitIn(List<Date> values) {
            addCriterion("last_visit in", values, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitNotIn(List<Date> values) {
            addCriterion("last_visit not in", values, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitBetween(Date value1, Date value2) {
            addCriterion("last_visit between", value1, value2, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitNotBetween(Date value1, Date value2) {
            addCriterion("last_visit not between", value1, value2, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
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

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andHasMorePicIsNull() {
            addCriterion("has_more_pic is null");
            return (Criteria) this;
        }

        public Criteria andHasMorePicIsNotNull() {
            addCriterion("has_more_pic is not null");
            return (Criteria) this;
        }

        public Criteria andHasMorePicEqualTo(Boolean value) {
            addCriterion("has_more_pic =", value, "hasMorePic");
            return (Criteria) this;
        }

        public Criteria andHasMorePicNotEqualTo(Boolean value) {
            addCriterion("has_more_pic <>", value, "hasMorePic");
            return (Criteria) this;
        }

        public Criteria andHasMorePicGreaterThan(Boolean value) {
            addCriterion("has_more_pic >", value, "hasMorePic");
            return (Criteria) this;
        }

        public Criteria andHasMorePicGreaterThanOrEqualTo(Boolean value) {
            addCriterion("has_more_pic >=", value, "hasMorePic");
            return (Criteria) this;
        }

        public Criteria andHasMorePicLessThan(Boolean value) {
            addCriterion("has_more_pic <", value, "hasMorePic");
            return (Criteria) this;
        }

        public Criteria andHasMorePicLessThanOrEqualTo(Boolean value) {
            addCriterion("has_more_pic <=", value, "hasMorePic");
            return (Criteria) this;
        }

        public Criteria andHasMorePicIn(List<Boolean> values) {
            addCriterion("has_more_pic in", values, "hasMorePic");
            return (Criteria) this;
        }

        public Criteria andHasMorePicNotIn(List<Boolean> values) {
            addCriterion("has_more_pic not in", values, "hasMorePic");
            return (Criteria) this;
        }

        public Criteria andHasMorePicBetween(Boolean value1, Boolean value2) {
            addCriterion("has_more_pic between", value1, value2, "hasMorePic");
            return (Criteria) this;
        }

        public Criteria andHasMorePicNotBetween(Boolean value1, Boolean value2) {
            addCriterion("has_more_pic not between", value1, value2, "hasMorePic");
            return (Criteria) this;
        }

        public Criteria andItemImgNumIsNull() {
            addCriterion("item_img_num is null");
            return (Criteria) this;
        }

        public Criteria andItemImgNumIsNotNull() {
            addCriterion("item_img_num is not null");
            return (Criteria) this;
        }

        public Criteria andItemImgNumEqualTo(Integer value) {
            addCriterion("item_img_num =", value, "itemImgNum");
            return (Criteria) this;
        }

        public Criteria andItemImgNumNotEqualTo(Integer value) {
            addCriterion("item_img_num <>", value, "itemImgNum");
            return (Criteria) this;
        }

        public Criteria andItemImgNumGreaterThan(Integer value) {
            addCriterion("item_img_num >", value, "itemImgNum");
            return (Criteria) this;
        }

        public Criteria andItemImgNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_img_num >=", value, "itemImgNum");
            return (Criteria) this;
        }

        public Criteria andItemImgNumLessThan(Integer value) {
            addCriterion("item_img_num <", value, "itemImgNum");
            return (Criteria) this;
        }

        public Criteria andItemImgNumLessThanOrEqualTo(Integer value) {
            addCriterion("item_img_num <=", value, "itemImgNum");
            return (Criteria) this;
        }

        public Criteria andItemImgNumIn(List<Integer> values) {
            addCriterion("item_img_num in", values, "itemImgNum");
            return (Criteria) this;
        }

        public Criteria andItemImgNumNotIn(List<Integer> values) {
            addCriterion("item_img_num not in", values, "itemImgNum");
            return (Criteria) this;
        }

        public Criteria andItemImgNumBetween(Integer value1, Integer value2) {
            addCriterion("item_img_num between", value1, value2, "itemImgNum");
            return (Criteria) this;
        }

        public Criteria andItemImgNumNotBetween(Integer value1, Integer value2) {
            addCriterion("item_img_num not between", value1, value2, "itemImgNum");
            return (Criteria) this;
        }

        public Criteria andItemImgSizeIsNull() {
            addCriterion("item_img_size is null");
            return (Criteria) this;
        }

        public Criteria andItemImgSizeIsNotNull() {
            addCriterion("item_img_size is not null");
            return (Criteria) this;
        }

        public Criteria andItemImgSizeEqualTo(Integer value) {
            addCriterion("item_img_size =", value, "itemImgSize");
            return (Criteria) this;
        }

        public Criteria andItemImgSizeNotEqualTo(Integer value) {
            addCriterion("item_img_size <>", value, "itemImgSize");
            return (Criteria) this;
        }

        public Criteria andItemImgSizeGreaterThan(Integer value) {
            addCriterion("item_img_size >", value, "itemImgSize");
            return (Criteria) this;
        }

        public Criteria andItemImgSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_img_size >=", value, "itemImgSize");
            return (Criteria) this;
        }

        public Criteria andItemImgSizeLessThan(Integer value) {
            addCriterion("item_img_size <", value, "itemImgSize");
            return (Criteria) this;
        }

        public Criteria andItemImgSizeLessThanOrEqualTo(Integer value) {
            addCriterion("item_img_size <=", value, "itemImgSize");
            return (Criteria) this;
        }

        public Criteria andItemImgSizeIn(List<Integer> values) {
            addCriterion("item_img_size in", values, "itemImgSize");
            return (Criteria) this;
        }

        public Criteria andItemImgSizeNotIn(List<Integer> values) {
            addCriterion("item_img_size not in", values, "itemImgSize");
            return (Criteria) this;
        }

        public Criteria andItemImgSizeBetween(Integer value1, Integer value2) {
            addCriterion("item_img_size between", value1, value2, "itemImgSize");
            return (Criteria) this;
        }

        public Criteria andItemImgSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("item_img_size not between", value1, value2, "itemImgSize");
            return (Criteria) this;
        }

        public Criteria andPropImgNumIsNull() {
            addCriterion("prop_img_num is null");
            return (Criteria) this;
        }

        public Criteria andPropImgNumIsNotNull() {
            addCriterion("prop_img_num is not null");
            return (Criteria) this;
        }

        public Criteria andPropImgNumEqualTo(Integer value) {
            addCriterion("prop_img_num =", value, "propImgNum");
            return (Criteria) this;
        }

        public Criteria andPropImgNumNotEqualTo(Integer value) {
            addCriterion("prop_img_num <>", value, "propImgNum");
            return (Criteria) this;
        }

        public Criteria andPropImgNumGreaterThan(Integer value) {
            addCriterion("prop_img_num >", value, "propImgNum");
            return (Criteria) this;
        }

        public Criteria andPropImgNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("prop_img_num >=", value, "propImgNum");
            return (Criteria) this;
        }

        public Criteria andPropImgNumLessThan(Integer value) {
            addCriterion("prop_img_num <", value, "propImgNum");
            return (Criteria) this;
        }

        public Criteria andPropImgNumLessThanOrEqualTo(Integer value) {
            addCriterion("prop_img_num <=", value, "propImgNum");
            return (Criteria) this;
        }

        public Criteria andPropImgNumIn(List<Integer> values) {
            addCriterion("prop_img_num in", values, "propImgNum");
            return (Criteria) this;
        }

        public Criteria andPropImgNumNotIn(List<Integer> values) {
            addCriterion("prop_img_num not in", values, "propImgNum");
            return (Criteria) this;
        }

        public Criteria andPropImgNumBetween(Integer value1, Integer value2) {
            addCriterion("prop_img_num between", value1, value2, "propImgNum");
            return (Criteria) this;
        }

        public Criteria andPropImgNumNotBetween(Integer value1, Integer value2) {
            addCriterion("prop_img_num not between", value1, value2, "propImgNum");
            return (Criteria) this;
        }

        public Criteria andPropImgSizeIsNull() {
            addCriterion("prop_img_size is null");
            return (Criteria) this;
        }

        public Criteria andPropImgSizeIsNotNull() {
            addCriterion("prop_img_size is not null");
            return (Criteria) this;
        }

        public Criteria andPropImgSizeEqualTo(Integer value) {
            addCriterion("prop_img_size =", value, "propImgSize");
            return (Criteria) this;
        }

        public Criteria andPropImgSizeNotEqualTo(Integer value) {
            addCriterion("prop_img_size <>", value, "propImgSize");
            return (Criteria) this;
        }

        public Criteria andPropImgSizeGreaterThan(Integer value) {
            addCriterion("prop_img_size >", value, "propImgSize");
            return (Criteria) this;
        }

        public Criteria andPropImgSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("prop_img_size >=", value, "propImgSize");
            return (Criteria) this;
        }

        public Criteria andPropImgSizeLessThan(Integer value) {
            addCriterion("prop_img_size <", value, "propImgSize");
            return (Criteria) this;
        }

        public Criteria andPropImgSizeLessThanOrEqualTo(Integer value) {
            addCriterion("prop_img_size <=", value, "propImgSize");
            return (Criteria) this;
        }

        public Criteria andPropImgSizeIn(List<Integer> values) {
            addCriterion("prop_img_size in", values, "propImgSize");
            return (Criteria) this;
        }

        public Criteria andPropImgSizeNotIn(List<Integer> values) {
            addCriterion("prop_img_size not in", values, "propImgSize");
            return (Criteria) this;
        }

        public Criteria andPropImgSizeBetween(Integer value1, Integer value2) {
            addCriterion("prop_img_size between", value1, value2, "propImgSize");
            return (Criteria) this;
        }

        public Criteria andPropImgSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("prop_img_size not between", value1, value2, "propImgSize");
            return (Criteria) this;
        }

        public Criteria andAutoRepostIsNull() {
            addCriterion("auto_repost is null");
            return (Criteria) this;
        }

        public Criteria andAutoRepostIsNotNull() {
            addCriterion("auto_repost is not null");
            return (Criteria) this;
        }

        public Criteria andAutoRepostEqualTo(String value) {
            addCriterion("auto_repost =", value, "autoRepost");
            return (Criteria) this;
        }

        public Criteria andAutoRepostNotEqualTo(String value) {
            addCriterion("auto_repost <>", value, "autoRepost");
            return (Criteria) this;
        }

        public Criteria andAutoRepostGreaterThan(String value) {
            addCriterion("auto_repost >", value, "autoRepost");
            return (Criteria) this;
        }

        public Criteria andAutoRepostGreaterThanOrEqualTo(String value) {
            addCriterion("auto_repost >=", value, "autoRepost");
            return (Criteria) this;
        }

        public Criteria andAutoRepostLessThan(String value) {
            addCriterion("auto_repost <", value, "autoRepost");
            return (Criteria) this;
        }

        public Criteria andAutoRepostLessThanOrEqualTo(String value) {
            addCriterion("auto_repost <=", value, "autoRepost");
            return (Criteria) this;
        }

        public Criteria andAutoRepostLike(String value) {
            addCriterion("auto_repost like", value, "autoRepost");
            return (Criteria) this;
        }

        public Criteria andAutoRepostNotLike(String value) {
            addCriterion("auto_repost not like", value, "autoRepost");
            return (Criteria) this;
        }

        public Criteria andAutoRepostIn(List<String> values) {
            addCriterion("auto_repost in", values, "autoRepost");
            return (Criteria) this;
        }

        public Criteria andAutoRepostNotIn(List<String> values) {
            addCriterion("auto_repost not in", values, "autoRepost");
            return (Criteria) this;
        }

        public Criteria andAutoRepostBetween(String value1, String value2) {
            addCriterion("auto_repost between", value1, value2, "autoRepost");
            return (Criteria) this;
        }

        public Criteria andAutoRepostNotBetween(String value1, String value2) {
            addCriterion("auto_repost not between", value1, value2, "autoRepost");
            return (Criteria) this;
        }

        public Criteria andPromotedTypeIsNull() {
            addCriterion("promoted_type is null");
            return (Criteria) this;
        }

        public Criteria andPromotedTypeIsNotNull() {
            addCriterion("promoted_type is not null");
            return (Criteria) this;
        }

        public Criteria andPromotedTypeEqualTo(String value) {
            addCriterion("promoted_type =", value, "promotedType");
            return (Criteria) this;
        }

        public Criteria andPromotedTypeNotEqualTo(String value) {
            addCriterion("promoted_type <>", value, "promotedType");
            return (Criteria) this;
        }

        public Criteria andPromotedTypeGreaterThan(String value) {
            addCriterion("promoted_type >", value, "promotedType");
            return (Criteria) this;
        }

        public Criteria andPromotedTypeGreaterThanOrEqualTo(String value) {
            addCriterion("promoted_type >=", value, "promotedType");
            return (Criteria) this;
        }

        public Criteria andPromotedTypeLessThan(String value) {
            addCriterion("promoted_type <", value, "promotedType");
            return (Criteria) this;
        }

        public Criteria andPromotedTypeLessThanOrEqualTo(String value) {
            addCriterion("promoted_type <=", value, "promotedType");
            return (Criteria) this;
        }

        public Criteria andPromotedTypeLike(String value) {
            addCriterion("promoted_type like", value, "promotedType");
            return (Criteria) this;
        }

        public Criteria andPromotedTypeNotLike(String value) {
            addCriterion("promoted_type not like", value, "promotedType");
            return (Criteria) this;
        }

        public Criteria andPromotedTypeIn(List<String> values) {
            addCriterion("promoted_type in", values, "promotedType");
            return (Criteria) this;
        }

        public Criteria andPromotedTypeNotIn(List<String> values) {
            addCriterion("promoted_type not in", values, "promotedType");
            return (Criteria) this;
        }

        public Criteria andPromotedTypeBetween(String value1, String value2) {
            addCriterion("promoted_type between", value1, value2, "promotedType");
            return (Criteria) this;
        }

        public Criteria andPromotedTypeNotBetween(String value1, String value2) {
            addCriterion("promoted_type not between", value1, value2, "promotedType");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAlipayBindIsNull() {
            addCriterion("alipay_bind is null");
            return (Criteria) this;
        }

        public Criteria andAlipayBindIsNotNull() {
            addCriterion("alipay_bind is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayBindEqualTo(String value) {
            addCriterion("alipay_bind =", value, "alipayBind");
            return (Criteria) this;
        }

        public Criteria andAlipayBindNotEqualTo(String value) {
            addCriterion("alipay_bind <>", value, "alipayBind");
            return (Criteria) this;
        }

        public Criteria andAlipayBindGreaterThan(String value) {
            addCriterion("alipay_bind >", value, "alipayBind");
            return (Criteria) this;
        }

        public Criteria andAlipayBindGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_bind >=", value, "alipayBind");
            return (Criteria) this;
        }

        public Criteria andAlipayBindLessThan(String value) {
            addCriterion("alipay_bind <", value, "alipayBind");
            return (Criteria) this;
        }

        public Criteria andAlipayBindLessThanOrEqualTo(String value) {
            addCriterion("alipay_bind <=", value, "alipayBind");
            return (Criteria) this;
        }

        public Criteria andAlipayBindLike(String value) {
            addCriterion("alipay_bind like", value, "alipayBind");
            return (Criteria) this;
        }

        public Criteria andAlipayBindNotLike(String value) {
            addCriterion("alipay_bind not like", value, "alipayBind");
            return (Criteria) this;
        }

        public Criteria andAlipayBindIn(List<String> values) {
            addCriterion("alipay_bind in", values, "alipayBind");
            return (Criteria) this;
        }

        public Criteria andAlipayBindNotIn(List<String> values) {
            addCriterion("alipay_bind not in", values, "alipayBind");
            return (Criteria) this;
        }

        public Criteria andAlipayBindBetween(String value1, String value2) {
            addCriterion("alipay_bind between", value1, value2, "alipayBind");
            return (Criteria) this;
        }

        public Criteria andAlipayBindNotBetween(String value1, String value2) {
            addCriterion("alipay_bind not between", value1, value2, "alipayBind");
            return (Criteria) this;
        }

        public Criteria andConsumerProtectionIsNull() {
            addCriterion("consumer_protection is null");
            return (Criteria) this;
        }

        public Criteria andConsumerProtectionIsNotNull() {
            addCriterion("consumer_protection is not null");
            return (Criteria) this;
        }

        public Criteria andConsumerProtectionEqualTo(Boolean value) {
            addCriterion("consumer_protection =", value, "consumerProtection");
            return (Criteria) this;
        }

        public Criteria andConsumerProtectionNotEqualTo(Boolean value) {
            addCriterion("consumer_protection <>", value, "consumerProtection");
            return (Criteria) this;
        }

        public Criteria andConsumerProtectionGreaterThan(Boolean value) {
            addCriterion("consumer_protection >", value, "consumerProtection");
            return (Criteria) this;
        }

        public Criteria andConsumerProtectionGreaterThanOrEqualTo(Boolean value) {
            addCriterion("consumer_protection >=", value, "consumerProtection");
            return (Criteria) this;
        }

        public Criteria andConsumerProtectionLessThan(Boolean value) {
            addCriterion("consumer_protection <", value, "consumerProtection");
            return (Criteria) this;
        }

        public Criteria andConsumerProtectionLessThanOrEqualTo(Boolean value) {
            addCriterion("consumer_protection <=", value, "consumerProtection");
            return (Criteria) this;
        }

        public Criteria andConsumerProtectionIn(List<Boolean> values) {
            addCriterion("consumer_protection in", values, "consumerProtection");
            return (Criteria) this;
        }

        public Criteria andConsumerProtectionNotIn(List<Boolean> values) {
            addCriterion("consumer_protection not in", values, "consumerProtection");
            return (Criteria) this;
        }

        public Criteria andConsumerProtectionBetween(Boolean value1, Boolean value2) {
            addCriterion("consumer_protection between", value1, value2, "consumerProtection");
            return (Criteria) this;
        }

        public Criteria andConsumerProtectionNotBetween(Boolean value1, Boolean value2) {
            addCriterion("consumer_protection not between", value1, value2, "consumerProtection");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNull() {
            addCriterion("avatar is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("avatar is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("avatar =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("avatar <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("avatar >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("avatar >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("avatar <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("avatar <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("avatar like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("avatar not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("avatar in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("avatar not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("avatar between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("avatar not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andLiangpinIsNull() {
            addCriterion("liangpin is null");
            return (Criteria) this;
        }

        public Criteria andLiangpinIsNotNull() {
            addCriterion("liangpin is not null");
            return (Criteria) this;
        }

        public Criteria andLiangpinEqualTo(Boolean value) {
            addCriterion("liangpin =", value, "liangpin");
            return (Criteria) this;
        }

        public Criteria andLiangpinNotEqualTo(Boolean value) {
            addCriterion("liangpin <>", value, "liangpin");
            return (Criteria) this;
        }

        public Criteria andLiangpinGreaterThan(Boolean value) {
            addCriterion("liangpin >", value, "liangpin");
            return (Criteria) this;
        }

        public Criteria andLiangpinGreaterThanOrEqualTo(Boolean value) {
            addCriterion("liangpin >=", value, "liangpin");
            return (Criteria) this;
        }

        public Criteria andLiangpinLessThan(Boolean value) {
            addCriterion("liangpin <", value, "liangpin");
            return (Criteria) this;
        }

        public Criteria andLiangpinLessThanOrEqualTo(Boolean value) {
            addCriterion("liangpin <=", value, "liangpin");
            return (Criteria) this;
        }

        public Criteria andLiangpinIn(List<Boolean> values) {
            addCriterion("liangpin in", values, "liangpin");
            return (Criteria) this;
        }

        public Criteria andLiangpinNotIn(List<Boolean> values) {
            addCriterion("liangpin not in", values, "liangpin");
            return (Criteria) this;
        }

        public Criteria andLiangpinBetween(Boolean value1, Boolean value2) {
            addCriterion("liangpin between", value1, value2, "liangpin");
            return (Criteria) this;
        }

        public Criteria andLiangpinNotBetween(Boolean value1, Boolean value2) {
            addCriterion("liangpin not between", value1, value2, "liangpin");
            return (Criteria) this;
        }

        public Criteria andSignFoodSellerPromiseIsNull() {
            addCriterion("sign_food_seller_promise is null");
            return (Criteria) this;
        }

        public Criteria andSignFoodSellerPromiseIsNotNull() {
            addCriterion("sign_food_seller_promise is not null");
            return (Criteria) this;
        }

        public Criteria andSignFoodSellerPromiseEqualTo(Boolean value) {
            addCriterion("sign_food_seller_promise =", value, "signFoodSellerPromise");
            return (Criteria) this;
        }

        public Criteria andSignFoodSellerPromiseNotEqualTo(Boolean value) {
            addCriterion("sign_food_seller_promise <>", value, "signFoodSellerPromise");
            return (Criteria) this;
        }

        public Criteria andSignFoodSellerPromiseGreaterThan(Boolean value) {
            addCriterion("sign_food_seller_promise >", value, "signFoodSellerPromise");
            return (Criteria) this;
        }

        public Criteria andSignFoodSellerPromiseGreaterThanOrEqualTo(Boolean value) {
            addCriterion("sign_food_seller_promise >=", value, "signFoodSellerPromise");
            return (Criteria) this;
        }

        public Criteria andSignFoodSellerPromiseLessThan(Boolean value) {
            addCriterion("sign_food_seller_promise <", value, "signFoodSellerPromise");
            return (Criteria) this;
        }

        public Criteria andSignFoodSellerPromiseLessThanOrEqualTo(Boolean value) {
            addCriterion("sign_food_seller_promise <=", value, "signFoodSellerPromise");
            return (Criteria) this;
        }

        public Criteria andSignFoodSellerPromiseIn(List<Boolean> values) {
            addCriterion("sign_food_seller_promise in", values, "signFoodSellerPromise");
            return (Criteria) this;
        }

        public Criteria andSignFoodSellerPromiseNotIn(List<Boolean> values) {
            addCriterion("sign_food_seller_promise not in", values, "signFoodSellerPromise");
            return (Criteria) this;
        }

        public Criteria andSignFoodSellerPromiseBetween(Boolean value1, Boolean value2) {
            addCriterion("sign_food_seller_promise between", value1, value2, "signFoodSellerPromise");
            return (Criteria) this;
        }

        public Criteria andSignFoodSellerPromiseNotBetween(Boolean value1, Boolean value2) {
            addCriterion("sign_food_seller_promise not between", value1, value2, "signFoodSellerPromise");
            return (Criteria) this;
        }

        public Criteria andHasShopIsNull() {
            addCriterion("has_shop is null");
            return (Criteria) this;
        }

        public Criteria andHasShopIsNotNull() {
            addCriterion("has_shop is not null");
            return (Criteria) this;
        }

        public Criteria andHasShopEqualTo(Boolean value) {
            addCriterion("has_shop =", value, "hasShop");
            return (Criteria) this;
        }

        public Criteria andHasShopNotEqualTo(Boolean value) {
            addCriterion("has_shop <>", value, "hasShop");
            return (Criteria) this;
        }

        public Criteria andHasShopGreaterThan(Boolean value) {
            addCriterion("has_shop >", value, "hasShop");
            return (Criteria) this;
        }

        public Criteria andHasShopGreaterThanOrEqualTo(Boolean value) {
            addCriterion("has_shop >=", value, "hasShop");
            return (Criteria) this;
        }

        public Criteria andHasShopLessThan(Boolean value) {
            addCriterion("has_shop <", value, "hasShop");
            return (Criteria) this;
        }

        public Criteria andHasShopLessThanOrEqualTo(Boolean value) {
            addCriterion("has_shop <=", value, "hasShop");
            return (Criteria) this;
        }

        public Criteria andHasShopIn(List<Boolean> values) {
            addCriterion("has_shop in", values, "hasShop");
            return (Criteria) this;
        }

        public Criteria andHasShopNotIn(List<Boolean> values) {
            addCriterion("has_shop not in", values, "hasShop");
            return (Criteria) this;
        }

        public Criteria andHasShopBetween(Boolean value1, Boolean value2) {
            addCriterion("has_shop between", value1, value2, "hasShop");
            return (Criteria) this;
        }

        public Criteria andHasShopNotBetween(Boolean value1, Boolean value2) {
            addCriterion("has_shop not between", value1, value2, "hasShop");
            return (Criteria) this;
        }

        public Criteria andIsLightningConsignmentIsNull() {
            addCriterion("is_lightning_consignment is null");
            return (Criteria) this;
        }

        public Criteria andIsLightningConsignmentIsNotNull() {
            addCriterion("is_lightning_consignment is not null");
            return (Criteria) this;
        }

        public Criteria andIsLightningConsignmentEqualTo(Boolean value) {
            addCriterion("is_lightning_consignment =", value, "isLightningConsignment");
            return (Criteria) this;
        }

        public Criteria andIsLightningConsignmentNotEqualTo(Boolean value) {
            addCriterion("is_lightning_consignment <>", value, "isLightningConsignment");
            return (Criteria) this;
        }

        public Criteria andIsLightningConsignmentGreaterThan(Boolean value) {
            addCriterion("is_lightning_consignment >", value, "isLightningConsignment");
            return (Criteria) this;
        }

        public Criteria andIsLightningConsignmentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_lightning_consignment >=", value, "isLightningConsignment");
            return (Criteria) this;
        }

        public Criteria andIsLightningConsignmentLessThan(Boolean value) {
            addCriterion("is_lightning_consignment <", value, "isLightningConsignment");
            return (Criteria) this;
        }

        public Criteria andIsLightningConsignmentLessThanOrEqualTo(Boolean value) {
            addCriterion("is_lightning_consignment <=", value, "isLightningConsignment");
            return (Criteria) this;
        }

        public Criteria andIsLightningConsignmentIn(List<Boolean> values) {
            addCriterion("is_lightning_consignment in", values, "isLightningConsignment");
            return (Criteria) this;
        }

        public Criteria andIsLightningConsignmentNotIn(List<Boolean> values) {
            addCriterion("is_lightning_consignment not in", values, "isLightningConsignment");
            return (Criteria) this;
        }

        public Criteria andIsLightningConsignmentBetween(Boolean value1, Boolean value2) {
            addCriterion("is_lightning_consignment between", value1, value2, "isLightningConsignment");
            return (Criteria) this;
        }

        public Criteria andIsLightningConsignmentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_lightning_consignment not between", value1, value2, "isLightningConsignment");
            return (Criteria) this;
        }

        public Criteria andHasSubStockIsNull() {
            addCriterion("has_sub_stock is null");
            return (Criteria) this;
        }

        public Criteria andHasSubStockIsNotNull() {
            addCriterion("has_sub_stock is not null");
            return (Criteria) this;
        }

        public Criteria andHasSubStockEqualTo(Boolean value) {
            addCriterion("has_sub_stock =", value, "hasSubStock");
            return (Criteria) this;
        }

        public Criteria andHasSubStockNotEqualTo(Boolean value) {
            addCriterion("has_sub_stock <>", value, "hasSubStock");
            return (Criteria) this;
        }

        public Criteria andHasSubStockGreaterThan(Boolean value) {
            addCriterion("has_sub_stock >", value, "hasSubStock");
            return (Criteria) this;
        }

        public Criteria andHasSubStockGreaterThanOrEqualTo(Boolean value) {
            addCriterion("has_sub_stock >=", value, "hasSubStock");
            return (Criteria) this;
        }

        public Criteria andHasSubStockLessThan(Boolean value) {
            addCriterion("has_sub_stock <", value, "hasSubStock");
            return (Criteria) this;
        }

        public Criteria andHasSubStockLessThanOrEqualTo(Boolean value) {
            addCriterion("has_sub_stock <=", value, "hasSubStock");
            return (Criteria) this;
        }

        public Criteria andHasSubStockIn(List<Boolean> values) {
            addCriterion("has_sub_stock in", values, "hasSubStock");
            return (Criteria) this;
        }

        public Criteria andHasSubStockNotIn(List<Boolean> values) {
            addCriterion("has_sub_stock not in", values, "hasSubStock");
            return (Criteria) this;
        }

        public Criteria andHasSubStockBetween(Boolean value1, Boolean value2) {
            addCriterion("has_sub_stock between", value1, value2, "hasSubStock");
            return (Criteria) this;
        }

        public Criteria andHasSubStockNotBetween(Boolean value1, Boolean value2) {
            addCriterion("has_sub_stock not between", value1, value2, "hasSubStock");
            return (Criteria) this;
        }

        public Criteria andIsGoldenSellerIsNull() {
            addCriterion("is_golden_seller is null");
            return (Criteria) this;
        }

        public Criteria andIsGoldenSellerIsNotNull() {
            addCriterion("is_golden_seller is not null");
            return (Criteria) this;
        }

        public Criteria andIsGoldenSellerEqualTo(Boolean value) {
            addCriterion("is_golden_seller =", value, "isGoldenSeller");
            return (Criteria) this;
        }

        public Criteria andIsGoldenSellerNotEqualTo(Boolean value) {
            addCriterion("is_golden_seller <>", value, "isGoldenSeller");
            return (Criteria) this;
        }

        public Criteria andIsGoldenSellerGreaterThan(Boolean value) {
            addCriterion("is_golden_seller >", value, "isGoldenSeller");
            return (Criteria) this;
        }

        public Criteria andIsGoldenSellerGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_golden_seller >=", value, "isGoldenSeller");
            return (Criteria) this;
        }

        public Criteria andIsGoldenSellerLessThan(Boolean value) {
            addCriterion("is_golden_seller <", value, "isGoldenSeller");
            return (Criteria) this;
        }

        public Criteria andIsGoldenSellerLessThanOrEqualTo(Boolean value) {
            addCriterion("is_golden_seller <=", value, "isGoldenSeller");
            return (Criteria) this;
        }

        public Criteria andIsGoldenSellerIn(List<Boolean> values) {
            addCriterion("is_golden_seller in", values, "isGoldenSeller");
            return (Criteria) this;
        }

        public Criteria andIsGoldenSellerNotIn(List<Boolean> values) {
            addCriterion("is_golden_seller not in", values, "isGoldenSeller");
            return (Criteria) this;
        }

        public Criteria andIsGoldenSellerBetween(Boolean value1, Boolean value2) {
            addCriterion("is_golden_seller between", value1, value2, "isGoldenSeller");
            return (Criteria) this;
        }

        public Criteria andIsGoldenSellerNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_golden_seller not between", value1, value2, "isGoldenSeller");
            return (Criteria) this;
        }

        public Criteria andVipInfoIsNull() {
            addCriterion("vip_info is null");
            return (Criteria) this;
        }

        public Criteria andVipInfoIsNotNull() {
            addCriterion("vip_info is not null");
            return (Criteria) this;
        }

        public Criteria andVipInfoEqualTo(String value) {
            addCriterion("vip_info =", value, "vipInfo");
            return (Criteria) this;
        }

        public Criteria andVipInfoNotEqualTo(String value) {
            addCriterion("vip_info <>", value, "vipInfo");
            return (Criteria) this;
        }

        public Criteria andVipInfoGreaterThan(String value) {
            addCriterion("vip_info >", value, "vipInfo");
            return (Criteria) this;
        }

        public Criteria andVipInfoGreaterThanOrEqualTo(String value) {
            addCriterion("vip_info >=", value, "vipInfo");
            return (Criteria) this;
        }

        public Criteria andVipInfoLessThan(String value) {
            addCriterion("vip_info <", value, "vipInfo");
            return (Criteria) this;
        }

        public Criteria andVipInfoLessThanOrEqualTo(String value) {
            addCriterion("vip_info <=", value, "vipInfo");
            return (Criteria) this;
        }

        public Criteria andVipInfoLike(String value) {
            addCriterion("vip_info like", value, "vipInfo");
            return (Criteria) this;
        }

        public Criteria andVipInfoNotLike(String value) {
            addCriterion("vip_info not like", value, "vipInfo");
            return (Criteria) this;
        }

        public Criteria andVipInfoIn(List<String> values) {
            addCriterion("vip_info in", values, "vipInfo");
            return (Criteria) this;
        }

        public Criteria andVipInfoNotIn(List<String> values) {
            addCriterion("vip_info not in", values, "vipInfo");
            return (Criteria) this;
        }

        public Criteria andVipInfoBetween(String value1, String value2) {
            addCriterion("vip_info between", value1, value2, "vipInfo");
            return (Criteria) this;
        }

        public Criteria andVipInfoNotBetween(String value1, String value2) {
            addCriterion("vip_info not between", value1, value2, "vipInfo");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andMagazineSubscribeIsNull() {
            addCriterion("magazine_subscribe is null");
            return (Criteria) this;
        }

        public Criteria andMagazineSubscribeIsNotNull() {
            addCriterion("magazine_subscribe is not null");
            return (Criteria) this;
        }

        public Criteria andMagazineSubscribeEqualTo(Boolean value) {
            addCriterion("magazine_subscribe =", value, "magazineSubscribe");
            return (Criteria) this;
        }

        public Criteria andMagazineSubscribeNotEqualTo(Boolean value) {
            addCriterion("magazine_subscribe <>", value, "magazineSubscribe");
            return (Criteria) this;
        }

        public Criteria andMagazineSubscribeGreaterThan(Boolean value) {
            addCriterion("magazine_subscribe >", value, "magazineSubscribe");
            return (Criteria) this;
        }

        public Criteria andMagazineSubscribeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("magazine_subscribe >=", value, "magazineSubscribe");
            return (Criteria) this;
        }

        public Criteria andMagazineSubscribeLessThan(Boolean value) {
            addCriterion("magazine_subscribe <", value, "magazineSubscribe");
            return (Criteria) this;
        }

        public Criteria andMagazineSubscribeLessThanOrEqualTo(Boolean value) {
            addCriterion("magazine_subscribe <=", value, "magazineSubscribe");
            return (Criteria) this;
        }

        public Criteria andMagazineSubscribeIn(List<Boolean> values) {
            addCriterion("magazine_subscribe in", values, "magazineSubscribe");
            return (Criteria) this;
        }

        public Criteria andMagazineSubscribeNotIn(List<Boolean> values) {
            addCriterion("magazine_subscribe not in", values, "magazineSubscribe");
            return (Criteria) this;
        }

        public Criteria andMagazineSubscribeBetween(Boolean value1, Boolean value2) {
            addCriterion("magazine_subscribe between", value1, value2, "magazineSubscribe");
            return (Criteria) this;
        }

        public Criteria andMagazineSubscribeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("magazine_subscribe not between", value1, value2, "magazineSubscribe");
            return (Criteria) this;
        }

        public Criteria andVerticalMarketIsNull() {
            addCriterion("vertical_market is null");
            return (Criteria) this;
        }

        public Criteria andVerticalMarketIsNotNull() {
            addCriterion("vertical_market is not null");
            return (Criteria) this;
        }

        public Criteria andVerticalMarketEqualTo(String value) {
            addCriterion("vertical_market =", value, "verticalMarket");
            return (Criteria) this;
        }

        public Criteria andVerticalMarketNotEqualTo(String value) {
            addCriterion("vertical_market <>", value, "verticalMarket");
            return (Criteria) this;
        }

        public Criteria andVerticalMarketGreaterThan(String value) {
            addCriterion("vertical_market >", value, "verticalMarket");
            return (Criteria) this;
        }

        public Criteria andVerticalMarketGreaterThanOrEqualTo(String value) {
            addCriterion("vertical_market >=", value, "verticalMarket");
            return (Criteria) this;
        }

        public Criteria andVerticalMarketLessThan(String value) {
            addCriterion("vertical_market <", value, "verticalMarket");
            return (Criteria) this;
        }

        public Criteria andVerticalMarketLessThanOrEqualTo(String value) {
            addCriterion("vertical_market <=", value, "verticalMarket");
            return (Criteria) this;
        }

        public Criteria andVerticalMarketLike(String value) {
            addCriterion("vertical_market like", value, "verticalMarket");
            return (Criteria) this;
        }

        public Criteria andVerticalMarketNotLike(String value) {
            addCriterion("vertical_market not like", value, "verticalMarket");
            return (Criteria) this;
        }

        public Criteria andVerticalMarketIn(List<String> values) {
            addCriterion("vertical_market in", values, "verticalMarket");
            return (Criteria) this;
        }

        public Criteria andVerticalMarketNotIn(List<String> values) {
            addCriterion("vertical_market not in", values, "verticalMarket");
            return (Criteria) this;
        }

        public Criteria andVerticalMarketBetween(String value1, String value2) {
            addCriterion("vertical_market between", value1, value2, "verticalMarket");
            return (Criteria) this;
        }

        public Criteria andVerticalMarketNotBetween(String value1, String value2) {
            addCriterion("vertical_market not between", value1, value2, "verticalMarket");
            return (Criteria) this;
        }

        public Criteria andOnlineGamingIsNull() {
            addCriterion("online_gaming is null");
            return (Criteria) this;
        }

        public Criteria andOnlineGamingIsNotNull() {
            addCriterion("online_gaming is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineGamingEqualTo(Boolean value) {
            addCriterion("online_gaming =", value, "onlineGaming");
            return (Criteria) this;
        }

        public Criteria andOnlineGamingNotEqualTo(Boolean value) {
            addCriterion("online_gaming <>", value, "onlineGaming");
            return (Criteria) this;
        }

        public Criteria andOnlineGamingGreaterThan(Boolean value) {
            addCriterion("online_gaming >", value, "onlineGaming");
            return (Criteria) this;
        }

        public Criteria andOnlineGamingGreaterThanOrEqualTo(Boolean value) {
            addCriterion("online_gaming >=", value, "onlineGaming");
            return (Criteria) this;
        }

        public Criteria andOnlineGamingLessThan(Boolean value) {
            addCriterion("online_gaming <", value, "onlineGaming");
            return (Criteria) this;
        }

        public Criteria andOnlineGamingLessThanOrEqualTo(Boolean value) {
            addCriterion("online_gaming <=", value, "onlineGaming");
            return (Criteria) this;
        }

        public Criteria andOnlineGamingIn(List<Boolean> values) {
            addCriterion("online_gaming in", values, "onlineGaming");
            return (Criteria) this;
        }

        public Criteria andOnlineGamingNotIn(List<Boolean> values) {
            addCriterion("online_gaming not in", values, "onlineGaming");
            return (Criteria) this;
        }

        public Criteria andOnlineGamingBetween(Boolean value1, Boolean value2) {
            addCriterion("online_gaming between", value1, value2, "onlineGaming");
            return (Criteria) this;
        }

        public Criteria andOnlineGamingNotBetween(Boolean value1, Boolean value2) {
            addCriterion("online_gaming not between", value1, value2, "onlineGaming");
            return (Criteria) this;
        }

        public Criteria andAlipayIdIsNull() {
            addCriterion("alipay_id is null");
            return (Criteria) this;
        }

        public Criteria andAlipayIdIsNotNull() {
            addCriterion("alipay_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayIdEqualTo(String value) {
            addCriterion("alipay_id =", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdNotEqualTo(String value) {
            addCriterion("alipay_id <>", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdGreaterThan(String value) {
            addCriterion("alipay_id >", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_id >=", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdLessThan(String value) {
            addCriterion("alipay_id <", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdLessThanOrEqualTo(String value) {
            addCriterion("alipay_id <=", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdLike(String value) {
            addCriterion("alipay_id like", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdNotLike(String value) {
            addCriterion("alipay_id not like", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdIn(List<String> values) {
            addCriterion("alipay_id in", values, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdNotIn(List<String> values) {
            addCriterion("alipay_id not in", values, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdBetween(String value1, String value2) {
            addCriterion("alipay_id between", value1, value2, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdNotBetween(String value1, String value2) {
            addCriterion("alipay_id not between", value1, value2, "alipayId");
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