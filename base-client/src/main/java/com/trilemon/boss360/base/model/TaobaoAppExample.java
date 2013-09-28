package com.trilemon.boss360.base.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaobaoAppExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaobaoAppExample() {
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

        public Criteria andArticleCodeIsNull() {
            addCriterion("article_code is null");
            return (Criteria) this;
        }

        public Criteria andArticleCodeIsNotNull() {
            addCriterion("article_code is not null");
            return (Criteria) this;
        }

        public Criteria andArticleCodeEqualTo(String value) {
            addCriterion("article_code =", value, "articleCode");
            return (Criteria) this;
        }

        public Criteria andArticleCodeNotEqualTo(String value) {
            addCriterion("article_code <>", value, "articleCode");
            return (Criteria) this;
        }

        public Criteria andArticleCodeGreaterThan(String value) {
            addCriterion("article_code >", value, "articleCode");
            return (Criteria) this;
        }

        public Criteria andArticleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("article_code >=", value, "articleCode");
            return (Criteria) this;
        }

        public Criteria andArticleCodeLessThan(String value) {
            addCriterion("article_code <", value, "articleCode");
            return (Criteria) this;
        }

        public Criteria andArticleCodeLessThanOrEqualTo(String value) {
            addCriterion("article_code <=", value, "articleCode");
            return (Criteria) this;
        }

        public Criteria andArticleCodeLike(String value) {
            addCriterion("article_code like", value, "articleCode");
            return (Criteria) this;
        }

        public Criteria andArticleCodeNotLike(String value) {
            addCriterion("article_code not like", value, "articleCode");
            return (Criteria) this;
        }

        public Criteria andArticleCodeIn(List<String> values) {
            addCriterion("article_code in", values, "articleCode");
            return (Criteria) this;
        }

        public Criteria andArticleCodeNotIn(List<String> values) {
            addCriterion("article_code not in", values, "articleCode");
            return (Criteria) this;
        }

        public Criteria andArticleCodeBetween(String value1, String value2) {
            addCriterion("article_code between", value1, value2, "articleCode");
            return (Criteria) this;
        }

        public Criteria andArticleCodeNotBetween(String value1, String value2) {
            addCriterion("article_code not between", value1, value2, "articleCode");
            return (Criteria) this;
        }

        public Criteria andAppSecretIsNull() {
            addCriterion("app_secret is null");
            return (Criteria) this;
        }

        public Criteria andAppSecretIsNotNull() {
            addCriterion("app_secret is not null");
            return (Criteria) this;
        }

        public Criteria andAppSecretEqualTo(String value) {
            addCriterion("app_secret =", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotEqualTo(String value) {
            addCriterion("app_secret <>", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretGreaterThan(String value) {
            addCriterion("app_secret >", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretGreaterThanOrEqualTo(String value) {
            addCriterion("app_secret >=", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLessThan(String value) {
            addCriterion("app_secret <", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLessThanOrEqualTo(String value) {
            addCriterion("app_secret <=", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLike(String value) {
            addCriterion("app_secret like", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotLike(String value) {
            addCriterion("app_secret not like", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretIn(List<String> values) {
            addCriterion("app_secret in", values, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotIn(List<String> values) {
            addCriterion("app_secret not in", values, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretBetween(String value1, String value2) {
            addCriterion("app_secret between", value1, value2, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotBetween(String value1, String value2) {
            addCriterion("app_secret not between", value1, value2, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppKeyIsNull() {
            addCriterion("app_key is null");
            return (Criteria) this;
        }

        public Criteria andAppKeyIsNotNull() {
            addCriterion("app_key is not null");
            return (Criteria) this;
        }

        public Criteria andAppKeyEqualTo(String value) {
            addCriterion("app_key =", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotEqualTo(String value) {
            addCriterion("app_key <>", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyGreaterThan(String value) {
            addCriterion("app_key >", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyGreaterThanOrEqualTo(String value) {
            addCriterion("app_key >=", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLessThan(String value) {
            addCriterion("app_key <", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLessThanOrEqualTo(String value) {
            addCriterion("app_key <=", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLike(String value) {
            addCriterion("app_key like", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotLike(String value) {
            addCriterion("app_key not like", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyIn(List<String> values) {
            addCriterion("app_key in", values, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotIn(List<String> values) {
            addCriterion("app_key not in", values, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyBetween(String value1, String value2) {
            addCriterion("app_key between", value1, value2, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotBetween(String value1, String value2) {
            addCriterion("app_key not between", value1, value2, "appKey");
            return (Criteria) this;
        }

        public Criteria andSandboxAppKeyIsNull() {
            addCriterion("sandbox_app_key is null");
            return (Criteria) this;
        }

        public Criteria andSandboxAppKeyIsNotNull() {
            addCriterion("sandbox_app_key is not null");
            return (Criteria) this;
        }

        public Criteria andSandboxAppKeyEqualTo(String value) {
            addCriterion("sandbox_app_key =", value, "sandboxAppKey");
            return (Criteria) this;
        }

        public Criteria andSandboxAppKeyNotEqualTo(String value) {
            addCriterion("sandbox_app_key <>", value, "sandboxAppKey");
            return (Criteria) this;
        }

        public Criteria andSandboxAppKeyGreaterThan(String value) {
            addCriterion("sandbox_app_key >", value, "sandboxAppKey");
            return (Criteria) this;
        }

        public Criteria andSandboxAppKeyGreaterThanOrEqualTo(String value) {
            addCriterion("sandbox_app_key >=", value, "sandboxAppKey");
            return (Criteria) this;
        }

        public Criteria andSandboxAppKeyLessThan(String value) {
            addCriterion("sandbox_app_key <", value, "sandboxAppKey");
            return (Criteria) this;
        }

        public Criteria andSandboxAppKeyLessThanOrEqualTo(String value) {
            addCriterion("sandbox_app_key <=", value, "sandboxAppKey");
            return (Criteria) this;
        }

        public Criteria andSandboxAppKeyLike(String value) {
            addCriterion("sandbox_app_key like", value, "sandboxAppKey");
            return (Criteria) this;
        }

        public Criteria andSandboxAppKeyNotLike(String value) {
            addCriterion("sandbox_app_key not like", value, "sandboxAppKey");
            return (Criteria) this;
        }

        public Criteria andSandboxAppKeyIn(List<String> values) {
            addCriterion("sandbox_app_key in", values, "sandboxAppKey");
            return (Criteria) this;
        }

        public Criteria andSandboxAppKeyNotIn(List<String> values) {
            addCriterion("sandbox_app_key not in", values, "sandboxAppKey");
            return (Criteria) this;
        }

        public Criteria andSandboxAppKeyBetween(String value1, String value2) {
            addCriterion("sandbox_app_key between", value1, value2, "sandboxAppKey");
            return (Criteria) this;
        }

        public Criteria andSandboxAppKeyNotBetween(String value1, String value2) {
            addCriterion("sandbox_app_key not between", value1, value2, "sandboxAppKey");
            return (Criteria) this;
        }

        public Criteria andSandboxAppSecretIsNull() {
            addCriterion("sandbox_app_secret is null");
            return (Criteria) this;
        }

        public Criteria andSandboxAppSecretIsNotNull() {
            addCriterion("sandbox_app_secret is not null");
            return (Criteria) this;
        }

        public Criteria andSandboxAppSecretEqualTo(String value) {
            addCriterion("sandbox_app_secret =", value, "sandboxAppSecret");
            return (Criteria) this;
        }

        public Criteria andSandboxAppSecretNotEqualTo(String value) {
            addCriterion("sandbox_app_secret <>", value, "sandboxAppSecret");
            return (Criteria) this;
        }

        public Criteria andSandboxAppSecretGreaterThan(String value) {
            addCriterion("sandbox_app_secret >", value, "sandboxAppSecret");
            return (Criteria) this;
        }

        public Criteria andSandboxAppSecretGreaterThanOrEqualTo(String value) {
            addCriterion("sandbox_app_secret >=", value, "sandboxAppSecret");
            return (Criteria) this;
        }

        public Criteria andSandboxAppSecretLessThan(String value) {
            addCriterion("sandbox_app_secret <", value, "sandboxAppSecret");
            return (Criteria) this;
        }

        public Criteria andSandboxAppSecretLessThanOrEqualTo(String value) {
            addCriterion("sandbox_app_secret <=", value, "sandboxAppSecret");
            return (Criteria) this;
        }

        public Criteria andSandboxAppSecretLike(String value) {
            addCriterion("sandbox_app_secret like", value, "sandboxAppSecret");
            return (Criteria) this;
        }

        public Criteria andSandboxAppSecretNotLike(String value) {
            addCriterion("sandbox_app_secret not like", value, "sandboxAppSecret");
            return (Criteria) this;
        }

        public Criteria andSandboxAppSecretIn(List<String> values) {
            addCriterion("sandbox_app_secret in", values, "sandboxAppSecret");
            return (Criteria) this;
        }

        public Criteria andSandboxAppSecretNotIn(List<String> values) {
            addCriterion("sandbox_app_secret not in", values, "sandboxAppSecret");
            return (Criteria) this;
        }

        public Criteria andSandboxAppSecretBetween(String value1, String value2) {
            addCriterion("sandbox_app_secret between", value1, value2, "sandboxAppSecret");
            return (Criteria) this;
        }

        public Criteria andSandboxAppSecretNotBetween(String value1, String value2) {
            addCriterion("sandbox_app_secret not between", value1, value2, "sandboxAppSecret");
            return (Criteria) this;
        }

        public Criteria andAppCallbackUrlIsNull() {
            addCriterion("app_callback_url is null");
            return (Criteria) this;
        }

        public Criteria andAppCallbackUrlIsNotNull() {
            addCriterion("app_callback_url is not null");
            return (Criteria) this;
        }

        public Criteria andAppCallbackUrlEqualTo(String value) {
            addCriterion("app_callback_url =", value, "appCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppCallbackUrlNotEqualTo(String value) {
            addCriterion("app_callback_url <>", value, "appCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppCallbackUrlGreaterThan(String value) {
            addCriterion("app_callback_url >", value, "appCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppCallbackUrlGreaterThanOrEqualTo(String value) {
            addCriterion("app_callback_url >=", value, "appCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppCallbackUrlLessThan(String value) {
            addCriterion("app_callback_url <", value, "appCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppCallbackUrlLessThanOrEqualTo(String value) {
            addCriterion("app_callback_url <=", value, "appCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppCallbackUrlLike(String value) {
            addCriterion("app_callback_url like", value, "appCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppCallbackUrlNotLike(String value) {
            addCriterion("app_callback_url not like", value, "appCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppCallbackUrlIn(List<String> values) {
            addCriterion("app_callback_url in", values, "appCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppCallbackUrlNotIn(List<String> values) {
            addCriterion("app_callback_url not in", values, "appCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppCallbackUrlBetween(String value1, String value2) {
            addCriterion("app_callback_url between", value1, value2, "appCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppCallbackUrlNotBetween(String value1, String value2) {
            addCriterion("app_callback_url not between", value1, value2, "appCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppExtraCallbackUrlIsNull() {
            addCriterion("app_extra_callback_url is null");
            return (Criteria) this;
        }

        public Criteria andAppExtraCallbackUrlIsNotNull() {
            addCriterion("app_extra_callback_url is not null");
            return (Criteria) this;
        }

        public Criteria andAppExtraCallbackUrlEqualTo(String value) {
            addCriterion("app_extra_callback_url =", value, "appExtraCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppExtraCallbackUrlNotEqualTo(String value) {
            addCriterion("app_extra_callback_url <>", value, "appExtraCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppExtraCallbackUrlGreaterThan(String value) {
            addCriterion("app_extra_callback_url >", value, "appExtraCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppExtraCallbackUrlGreaterThanOrEqualTo(String value) {
            addCriterion("app_extra_callback_url >=", value, "appExtraCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppExtraCallbackUrlLessThan(String value) {
            addCriterion("app_extra_callback_url <", value, "appExtraCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppExtraCallbackUrlLessThanOrEqualTo(String value) {
            addCriterion("app_extra_callback_url <=", value, "appExtraCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppExtraCallbackUrlLike(String value) {
            addCriterion("app_extra_callback_url like", value, "appExtraCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppExtraCallbackUrlNotLike(String value) {
            addCriterion("app_extra_callback_url not like", value, "appExtraCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppExtraCallbackUrlIn(List<String> values) {
            addCriterion("app_extra_callback_url in", values, "appExtraCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppExtraCallbackUrlNotIn(List<String> values) {
            addCriterion("app_extra_callback_url not in", values, "appExtraCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppExtraCallbackUrlBetween(String value1, String value2) {
            addCriterion("app_extra_callback_url between", value1, value2, "appExtraCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andAppExtraCallbackUrlNotBetween(String value1, String value2) {
            addCriterion("app_extra_callback_url not between", value1, value2, "appExtraCallbackUrl");
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