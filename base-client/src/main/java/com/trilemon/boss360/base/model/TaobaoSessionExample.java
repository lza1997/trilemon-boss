package com.trilemon.boss360.base.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaobaoSessionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaobaoSessionExample() {
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

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Long value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Long value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Long value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Long value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Long value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Long> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Long> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Long value1, Long value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Long value1, Long value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(Integer value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(Integer value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(Integer value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(Integer value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(Integer value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<Integer> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<Integer> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(Integer value1, Integer value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(Integer value1, Integer value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andSessionKeyIsNull() {
            addCriterion("session_key is null");
            return (Criteria) this;
        }

        public Criteria andSessionKeyIsNotNull() {
            addCriterion("session_key is not null");
            return (Criteria) this;
        }

        public Criteria andSessionKeyEqualTo(String value) {
            addCriterion("session_key =", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyNotEqualTo(String value) {
            addCriterion("session_key <>", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyGreaterThan(String value) {
            addCriterion("session_key >", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyGreaterThanOrEqualTo(String value) {
            addCriterion("session_key >=", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyLessThan(String value) {
            addCriterion("session_key <", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyLessThanOrEqualTo(String value) {
            addCriterion("session_key <=", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyLike(String value) {
            addCriterion("session_key like", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyNotLike(String value) {
            addCriterion("session_key not like", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyIn(List<String> values) {
            addCriterion("session_key in", values, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyNotIn(List<String> values) {
            addCriterion("session_key not in", values, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyBetween(String value1, String value2) {
            addCriterion("session_key between", value1, value2, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyNotBetween(String value1, String value2) {
            addCriterion("session_key not between", value1, value2, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSignIsNull() {
            addCriterion("sign is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("sign is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(String value) {
            addCriterion("sign =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(String value) {
            addCriterion("sign <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(String value) {
            addCriterion("sign >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(String value) {
            addCriterion("sign >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(String value) {
            addCriterion("sign <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(String value) {
            addCriterion("sign <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLike(String value) {
            addCriterion("sign like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotLike(String value) {
            addCriterion("sign not like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<String> values) {
            addCriterion("sign in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<String> values) {
            addCriterion("sign not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(String value1, String value2) {
            addCriterion("sign between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(String value1, String value2) {
            addCriterion("sign not between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andTsIsNull() {
            addCriterion("ts is null");
            return (Criteria) this;
        }

        public Criteria andTsIsNotNull() {
            addCriterion("ts is not null");
            return (Criteria) this;
        }

        public Criteria andTsEqualTo(Date value) {
            addCriterion("ts =", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsNotEqualTo(Date value) {
            addCriterion("ts <>", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsGreaterThan(Date value) {
            addCriterion("ts >", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsGreaterThanOrEqualTo(Date value) {
            addCriterion("ts >=", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsLessThan(Date value) {
            addCriterion("ts <", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsLessThanOrEqualTo(Date value) {
            addCriterion("ts <=", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsIn(List<Date> values) {
            addCriterion("ts in", values, "ts");
            return (Criteria) this;
        }

        public Criteria andTsNotIn(List<Date> values) {
            addCriterion("ts not in", values, "ts");
            return (Criteria) this;
        }

        public Criteria andTsBetween(Date value1, Date value2) {
            addCriterion("ts between", value1, value2, "ts");
            return (Criteria) this;
        }

        public Criteria andTsNotBetween(Date value1, Date value2) {
            addCriterion("ts not between", value1, value2, "ts");
            return (Criteria) this;
        }

        public Criteria andIframeIsNull() {
            addCriterion("iframe is null");
            return (Criteria) this;
        }

        public Criteria andIframeIsNotNull() {
            addCriterion("iframe is not null");
            return (Criteria) this;
        }

        public Criteria andIframeEqualTo(Byte value) {
            addCriterion("iframe =", value, "iframe");
            return (Criteria) this;
        }

        public Criteria andIframeNotEqualTo(Byte value) {
            addCriterion("iframe <>", value, "iframe");
            return (Criteria) this;
        }

        public Criteria andIframeGreaterThan(Byte value) {
            addCriterion("iframe >", value, "iframe");
            return (Criteria) this;
        }

        public Criteria andIframeGreaterThanOrEqualTo(Byte value) {
            addCriterion("iframe >=", value, "iframe");
            return (Criteria) this;
        }

        public Criteria andIframeLessThan(Byte value) {
            addCriterion("iframe <", value, "iframe");
            return (Criteria) this;
        }

        public Criteria andIframeLessThanOrEqualTo(Byte value) {
            addCriterion("iframe <=", value, "iframe");
            return (Criteria) this;
        }

        public Criteria andIframeIn(List<Byte> values) {
            addCriterion("iframe in", values, "iframe");
            return (Criteria) this;
        }

        public Criteria andIframeNotIn(List<Byte> values) {
            addCriterion("iframe not in", values, "iframe");
            return (Criteria) this;
        }

        public Criteria andIframeBetween(Byte value1, Byte value2) {
            addCriterion("iframe between", value1, value2, "iframe");
            return (Criteria) this;
        }

        public Criteria andIframeNotBetween(Byte value1, Byte value2) {
            addCriterion("iframe not between", value1, value2, "iframe");
            return (Criteria) this;
        }

        public Criteria andVisitorIdIsNull() {
            addCriterion("visitor_id is null");
            return (Criteria) this;
        }

        public Criteria andVisitorIdIsNotNull() {
            addCriterion("visitor_id is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorIdEqualTo(Long value) {
            addCriterion("visitor_id =", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdNotEqualTo(Long value) {
            addCriterion("visitor_id <>", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdGreaterThan(Long value) {
            addCriterion("visitor_id >", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("visitor_id >=", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdLessThan(Long value) {
            addCriterion("visitor_id <", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdLessThanOrEqualTo(Long value) {
            addCriterion("visitor_id <=", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdIn(List<Long> values) {
            addCriterion("visitor_id in", values, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdNotIn(List<Long> values) {
            addCriterion("visitor_id not in", values, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdBetween(Long value1, Long value2) {
            addCriterion("visitor_id between", value1, value2, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdNotBetween(Long value1, Long value2) {
            addCriterion("visitor_id not between", value1, value2, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorNickIsNull() {
            addCriterion("visitor_nick is null");
            return (Criteria) this;
        }

        public Criteria andVisitorNickIsNotNull() {
            addCriterion("visitor_nick is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorNickEqualTo(String value) {
            addCriterion("visitor_nick =", value, "visitorNick");
            return (Criteria) this;
        }

        public Criteria andVisitorNickNotEqualTo(String value) {
            addCriterion("visitor_nick <>", value, "visitorNick");
            return (Criteria) this;
        }

        public Criteria andVisitorNickGreaterThan(String value) {
            addCriterion("visitor_nick >", value, "visitorNick");
            return (Criteria) this;
        }

        public Criteria andVisitorNickGreaterThanOrEqualTo(String value) {
            addCriterion("visitor_nick >=", value, "visitorNick");
            return (Criteria) this;
        }

        public Criteria andVisitorNickLessThan(String value) {
            addCriterion("visitor_nick <", value, "visitorNick");
            return (Criteria) this;
        }

        public Criteria andVisitorNickLessThanOrEqualTo(String value) {
            addCriterion("visitor_nick <=", value, "visitorNick");
            return (Criteria) this;
        }

        public Criteria andVisitorNickLike(String value) {
            addCriterion("visitor_nick like", value, "visitorNick");
            return (Criteria) this;
        }

        public Criteria andVisitorNickNotLike(String value) {
            addCriterion("visitor_nick not like", value, "visitorNick");
            return (Criteria) this;
        }

        public Criteria andVisitorNickIn(List<String> values) {
            addCriterion("visitor_nick in", values, "visitorNick");
            return (Criteria) this;
        }

        public Criteria andVisitorNickNotIn(List<String> values) {
            addCriterion("visitor_nick not in", values, "visitorNick");
            return (Criteria) this;
        }

        public Criteria andVisitorNickBetween(String value1, String value2) {
            addCriterion("visitor_nick between", value1, value2, "visitorNick");
            return (Criteria) this;
        }

        public Criteria andVisitorNickNotBetween(String value1, String value2) {
            addCriterion("visitor_nick not between", value1, value2, "visitorNick");
            return (Criteria) this;
        }

        public Criteria andExpiresInIsNull() {
            addCriterion("expires_in is null");
            return (Criteria) this;
        }

        public Criteria andExpiresInIsNotNull() {
            addCriterion("expires_in is not null");
            return (Criteria) this;
        }

        public Criteria andExpiresInEqualTo(Integer value) {
            addCriterion("expires_in =", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInNotEqualTo(Integer value) {
            addCriterion("expires_in <>", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInGreaterThan(Integer value) {
            addCriterion("expires_in >", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInGreaterThanOrEqualTo(Integer value) {
            addCriterion("expires_in >=", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInLessThan(Integer value) {
            addCriterion("expires_in <", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInLessThanOrEqualTo(Integer value) {
            addCriterion("expires_in <=", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInIn(List<Integer> values) {
            addCriterion("expires_in in", values, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInNotIn(List<Integer> values) {
            addCriterion("expires_in not in", values, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInBetween(Integer value1, Integer value2) {
            addCriterion("expires_in between", value1, value2, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInNotBetween(Integer value1, Integer value2) {
            addCriterion("expires_in not between", value1, value2, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenIsNull() {
            addCriterion("refresh_token is null");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenIsNotNull() {
            addCriterion("refresh_token is not null");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenEqualTo(String value) {
            addCriterion("refresh_token =", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenNotEqualTo(String value) {
            addCriterion("refresh_token <>", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenGreaterThan(String value) {
            addCriterion("refresh_token >", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenGreaterThanOrEqualTo(String value) {
            addCriterion("refresh_token >=", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenLessThan(String value) {
            addCriterion("refresh_token <", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenLessThanOrEqualTo(String value) {
            addCriterion("refresh_token <=", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenLike(String value) {
            addCriterion("refresh_token like", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenNotLike(String value) {
            addCriterion("refresh_token not like", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenIn(List<String> values) {
            addCriterion("refresh_token in", values, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenNotIn(List<String> values) {
            addCriterion("refresh_token not in", values, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenBetween(String value1, String value2) {
            addCriterion("refresh_token between", value1, value2, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenNotBetween(String value1, String value2) {
            addCriterion("refresh_token not between", value1, value2, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andReExpiresInIsNull() {
            addCriterion("re_expires_in is null");
            return (Criteria) this;
        }

        public Criteria andReExpiresInIsNotNull() {
            addCriterion("re_expires_in is not null");
            return (Criteria) this;
        }

        public Criteria andReExpiresInEqualTo(Integer value) {
            addCriterion("re_expires_in =", value, "reExpiresIn");
            return (Criteria) this;
        }

        public Criteria andReExpiresInNotEqualTo(Integer value) {
            addCriterion("re_expires_in <>", value, "reExpiresIn");
            return (Criteria) this;
        }

        public Criteria andReExpiresInGreaterThan(Integer value) {
            addCriterion("re_expires_in >", value, "reExpiresIn");
            return (Criteria) this;
        }

        public Criteria andReExpiresInGreaterThanOrEqualTo(Integer value) {
            addCriterion("re_expires_in >=", value, "reExpiresIn");
            return (Criteria) this;
        }

        public Criteria andReExpiresInLessThan(Integer value) {
            addCriterion("re_expires_in <", value, "reExpiresIn");
            return (Criteria) this;
        }

        public Criteria andReExpiresInLessThanOrEqualTo(Integer value) {
            addCriterion("re_expires_in <=", value, "reExpiresIn");
            return (Criteria) this;
        }

        public Criteria andReExpiresInIn(List<Integer> values) {
            addCriterion("re_expires_in in", values, "reExpiresIn");
            return (Criteria) this;
        }

        public Criteria andReExpiresInNotIn(List<Integer> values) {
            addCriterion("re_expires_in not in", values, "reExpiresIn");
            return (Criteria) this;
        }

        public Criteria andReExpiresInBetween(Integer value1, Integer value2) {
            addCriterion("re_expires_in between", value1, value2, "reExpiresIn");
            return (Criteria) this;
        }

        public Criteria andReExpiresInNotBetween(Integer value1, Integer value2) {
            addCriterion("re_expires_in not between", value1, value2, "reExpiresIn");
            return (Criteria) this;
        }

        public Criteria andSubVisitorIdIsNull() {
            addCriterion("sub_visitor_id is null");
            return (Criteria) this;
        }

        public Criteria andSubVisitorIdIsNotNull() {
            addCriterion("sub_visitor_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubVisitorIdEqualTo(Long value) {
            addCriterion("sub_visitor_id =", value, "subVisitorId");
            return (Criteria) this;
        }

        public Criteria andSubVisitorIdNotEqualTo(Long value) {
            addCriterion("sub_visitor_id <>", value, "subVisitorId");
            return (Criteria) this;
        }

        public Criteria andSubVisitorIdGreaterThan(Long value) {
            addCriterion("sub_visitor_id >", value, "subVisitorId");
            return (Criteria) this;
        }

        public Criteria andSubVisitorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sub_visitor_id >=", value, "subVisitorId");
            return (Criteria) this;
        }

        public Criteria andSubVisitorIdLessThan(Long value) {
            addCriterion("sub_visitor_id <", value, "subVisitorId");
            return (Criteria) this;
        }

        public Criteria andSubVisitorIdLessThanOrEqualTo(Long value) {
            addCriterion("sub_visitor_id <=", value, "subVisitorId");
            return (Criteria) this;
        }

        public Criteria andSubVisitorIdIn(List<Long> values) {
            addCriterion("sub_visitor_id in", values, "subVisitorId");
            return (Criteria) this;
        }

        public Criteria andSubVisitorIdNotIn(List<Long> values) {
            addCriterion("sub_visitor_id not in", values, "subVisitorId");
            return (Criteria) this;
        }

        public Criteria andSubVisitorIdBetween(Long value1, Long value2) {
            addCriterion("sub_visitor_id between", value1, value2, "subVisitorId");
            return (Criteria) this;
        }

        public Criteria andSubVisitorIdNotBetween(Long value1, Long value2) {
            addCriterion("sub_visitor_id not between", value1, value2, "subVisitorId");
            return (Criteria) this;
        }

        public Criteria andSubTaobaoUserNickIsNull() {
            addCriterion("sub_taobao_user_nick is null");
            return (Criteria) this;
        }

        public Criteria andSubTaobaoUserNickIsNotNull() {
            addCriterion("sub_taobao_user_nick is not null");
            return (Criteria) this;
        }

        public Criteria andSubTaobaoUserNickEqualTo(String value) {
            addCriterion("sub_taobao_user_nick =", value, "subTaobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andSubTaobaoUserNickNotEqualTo(String value) {
            addCriterion("sub_taobao_user_nick <>", value, "subTaobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andSubTaobaoUserNickGreaterThan(String value) {
            addCriterion("sub_taobao_user_nick >", value, "subTaobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andSubTaobaoUserNickGreaterThanOrEqualTo(String value) {
            addCriterion("sub_taobao_user_nick >=", value, "subTaobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andSubTaobaoUserNickLessThan(String value) {
            addCriterion("sub_taobao_user_nick <", value, "subTaobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andSubTaobaoUserNickLessThanOrEqualTo(String value) {
            addCriterion("sub_taobao_user_nick <=", value, "subTaobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andSubTaobaoUserNickLike(String value) {
            addCriterion("sub_taobao_user_nick like", value, "subTaobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andSubTaobaoUserNickNotLike(String value) {
            addCriterion("sub_taobao_user_nick not like", value, "subTaobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andSubTaobaoUserNickIn(List<String> values) {
            addCriterion("sub_taobao_user_nick in", values, "subTaobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andSubTaobaoUserNickNotIn(List<String> values) {
            addCriterion("sub_taobao_user_nick not in", values, "subTaobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andSubTaobaoUserNickBetween(String value1, String value2) {
            addCriterion("sub_taobao_user_nick between", value1, value2, "subTaobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andSubTaobaoUserNickNotBetween(String value1, String value2) {
            addCriterion("sub_taobao_user_nick not between", value1, value2, "subTaobaoUserNick");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInIsNull() {
            addCriterion("r1_expires_in is null");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInIsNotNull() {
            addCriterion("r1_expires_in is not null");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInEqualTo(Integer value) {
            addCriterion("r1_expires_in =", value, "r1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInNotEqualTo(Integer value) {
            addCriterion("r1_expires_in <>", value, "r1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInGreaterThan(Integer value) {
            addCriterion("r1_expires_in >", value, "r1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInGreaterThanOrEqualTo(Integer value) {
            addCriterion("r1_expires_in >=", value, "r1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInLessThan(Integer value) {
            addCriterion("r1_expires_in <", value, "r1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInLessThanOrEqualTo(Integer value) {
            addCriterion("r1_expires_in <=", value, "r1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInIn(List<Integer> values) {
            addCriterion("r1_expires_in in", values, "r1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInNotIn(List<Integer> values) {
            addCriterion("r1_expires_in not in", values, "r1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInBetween(Integer value1, Integer value2) {
            addCriterion("r1_expires_in between", value1, value2, "r1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR1ExpiresInNotBetween(Integer value1, Integer value2) {
            addCriterion("r1_expires_in not between", value1, value2, "r1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInIsNull() {
            addCriterion("w1_expires_in is null");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInIsNotNull() {
            addCriterion("w1_expires_in is not null");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInEqualTo(Integer value) {
            addCriterion("w1_expires_in =", value, "w1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInNotEqualTo(Integer value) {
            addCriterion("w1_expires_in <>", value, "w1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInGreaterThan(Integer value) {
            addCriterion("w1_expires_in >", value, "w1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInGreaterThanOrEqualTo(Integer value) {
            addCriterion("w1_expires_in >=", value, "w1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInLessThan(Integer value) {
            addCriterion("w1_expires_in <", value, "w1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInLessThanOrEqualTo(Integer value) {
            addCriterion("w1_expires_in <=", value, "w1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInIn(List<Integer> values) {
            addCriterion("w1_expires_in in", values, "w1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInNotIn(List<Integer> values) {
            addCriterion("w1_expires_in not in", values, "w1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInBetween(Integer value1, Integer value2) {
            addCriterion("w1_expires_in between", value1, value2, "w1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW1ExpiresInNotBetween(Integer value1, Integer value2) {
            addCriterion("w1_expires_in not between", value1, value2, "w1ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInIsNull() {
            addCriterion("r2_expires_in is null");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInIsNotNull() {
            addCriterion("r2_expires_in is not null");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInEqualTo(Integer value) {
            addCriterion("r2_expires_in =", value, "r2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInNotEqualTo(Integer value) {
            addCriterion("r2_expires_in <>", value, "r2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInGreaterThan(Integer value) {
            addCriterion("r2_expires_in >", value, "r2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInGreaterThanOrEqualTo(Integer value) {
            addCriterion("r2_expires_in >=", value, "r2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInLessThan(Integer value) {
            addCriterion("r2_expires_in <", value, "r2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInLessThanOrEqualTo(Integer value) {
            addCriterion("r2_expires_in <=", value, "r2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInIn(List<Integer> values) {
            addCriterion("r2_expires_in in", values, "r2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInNotIn(List<Integer> values) {
            addCriterion("r2_expires_in not in", values, "r2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInBetween(Integer value1, Integer value2) {
            addCriterion("r2_expires_in between", value1, value2, "r2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andR2ExpiresInNotBetween(Integer value1, Integer value2) {
            addCriterion("r2_expires_in not between", value1, value2, "r2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInIsNull() {
            addCriterion("w2_expires_in is null");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInIsNotNull() {
            addCriterion("w2_expires_in is not null");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInEqualTo(Integer value) {
            addCriterion("w2_expires_in =", value, "w2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInNotEqualTo(Integer value) {
            addCriterion("w2_expires_in <>", value, "w2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInGreaterThan(Integer value) {
            addCriterion("w2_expires_in >", value, "w2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInGreaterThanOrEqualTo(Integer value) {
            addCriterion("w2_expires_in >=", value, "w2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInLessThan(Integer value) {
            addCriterion("w2_expires_in <", value, "w2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInLessThanOrEqualTo(Integer value) {
            addCriterion("w2_expires_in <=", value, "w2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInIn(List<Integer> values) {
            addCriterion("w2_expires_in in", values, "w2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInNotIn(List<Integer> values) {
            addCriterion("w2_expires_in not in", values, "w2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInBetween(Integer value1, Integer value2) {
            addCriterion("w2_expires_in between", value1, value2, "w2ExpiresIn");
            return (Criteria) this;
        }

        public Criteria andW2ExpiresInNotBetween(Integer value1, Integer value2) {
            addCriterion("w2_expires_in not between", value1, value2, "w2ExpiresIn");
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