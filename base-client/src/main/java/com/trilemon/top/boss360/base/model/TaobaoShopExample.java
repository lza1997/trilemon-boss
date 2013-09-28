package com.trilemon.top.boss360.base.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaobaoShopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaobaoShopExample() {
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

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Long value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Long value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Long value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Long value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Long value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Long value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Long> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Long> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Long value1, Long value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Long value1, Long value2) {
            addCriterion("cid not between", value1, value2, "cid");
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andBulletinIsNull() {
            addCriterion("bulletin is null");
            return (Criteria) this;
        }

        public Criteria andBulletinIsNotNull() {
            addCriterion("bulletin is not null");
            return (Criteria) this;
        }

        public Criteria andBulletinEqualTo(String value) {
            addCriterion("bulletin =", value, "bulletin");
            return (Criteria) this;
        }

        public Criteria andBulletinNotEqualTo(String value) {
            addCriterion("bulletin <>", value, "bulletin");
            return (Criteria) this;
        }

        public Criteria andBulletinGreaterThan(String value) {
            addCriterion("bulletin >", value, "bulletin");
            return (Criteria) this;
        }

        public Criteria andBulletinGreaterThanOrEqualTo(String value) {
            addCriterion("bulletin >=", value, "bulletin");
            return (Criteria) this;
        }

        public Criteria andBulletinLessThan(String value) {
            addCriterion("bulletin <", value, "bulletin");
            return (Criteria) this;
        }

        public Criteria andBulletinLessThanOrEqualTo(String value) {
            addCriterion("bulletin <=", value, "bulletin");
            return (Criteria) this;
        }

        public Criteria andBulletinLike(String value) {
            addCriterion("bulletin like", value, "bulletin");
            return (Criteria) this;
        }

        public Criteria andBulletinNotLike(String value) {
            addCriterion("bulletin not like", value, "bulletin");
            return (Criteria) this;
        }

        public Criteria andBulletinIn(List<String> values) {
            addCriterion("bulletin in", values, "bulletin");
            return (Criteria) this;
        }

        public Criteria andBulletinNotIn(List<String> values) {
            addCriterion("bulletin not in", values, "bulletin");
            return (Criteria) this;
        }

        public Criteria andBulletinBetween(String value1, String value2) {
            addCriterion("bulletin between", value1, value2, "bulletin");
            return (Criteria) this;
        }

        public Criteria andBulletinNotBetween(String value1, String value2) {
            addCriterion("bulletin not between", value1, value2, "bulletin");
            return (Criteria) this;
        }

        public Criteria andPicPathIsNull() {
            addCriterion("pic_path is null");
            return (Criteria) this;
        }

        public Criteria andPicPathIsNotNull() {
            addCriterion("pic_path is not null");
            return (Criteria) this;
        }

        public Criteria andPicPathEqualTo(String value) {
            addCriterion("pic_path =", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotEqualTo(String value) {
            addCriterion("pic_path <>", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathGreaterThan(String value) {
            addCriterion("pic_path >", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathGreaterThanOrEqualTo(String value) {
            addCriterion("pic_path >=", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathLessThan(String value) {
            addCriterion("pic_path <", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathLessThanOrEqualTo(String value) {
            addCriterion("pic_path <=", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathLike(String value) {
            addCriterion("pic_path like", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotLike(String value) {
            addCriterion("pic_path not like", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathIn(List<String> values) {
            addCriterion("pic_path in", values, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotIn(List<String> values) {
            addCriterion("pic_path not in", values, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathBetween(String value1, String value2) {
            addCriterion("pic_path between", value1, value2, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotBetween(String value1, String value2) {
            addCriterion("pic_path not between", value1, value2, "picPath");
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

        public Criteria andModifiedIsNull() {
            addCriterion("modified is null");
            return (Criteria) this;
        }

        public Criteria andModifiedIsNotNull() {
            addCriterion("modified is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedEqualTo(Date value) {
            addCriterion("modified =", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotEqualTo(Date value) {
            addCriterion("modified <>", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedGreaterThan(Date value) {
            addCriterion("modified >", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("modified >=", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedLessThan(Date value) {
            addCriterion("modified <", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedLessThanOrEqualTo(Date value) {
            addCriterion("modified <=", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedIn(List<Date> values) {
            addCriterion("modified in", values, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotIn(List<Date> values) {
            addCriterion("modified not in", values, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedBetween(Date value1, Date value2) {
            addCriterion("modified between", value1, value2, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotBetween(Date value1, Date value2) {
            addCriterion("modified not between", value1, value2, "modified");
            return (Criteria) this;
        }

        public Criteria andShopScoreItemScoreIsNull() {
            addCriterion("shop_score_item_score is null");
            return (Criteria) this;
        }

        public Criteria andShopScoreItemScoreIsNotNull() {
            addCriterion("shop_score_item_score is not null");
            return (Criteria) this;
        }

        public Criteria andShopScoreItemScoreEqualTo(String value) {
            addCriterion("shop_score_item_score =", value, "shopScoreItemScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreItemScoreNotEqualTo(String value) {
            addCriterion("shop_score_item_score <>", value, "shopScoreItemScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreItemScoreGreaterThan(String value) {
            addCriterion("shop_score_item_score >", value, "shopScoreItemScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreItemScoreGreaterThanOrEqualTo(String value) {
            addCriterion("shop_score_item_score >=", value, "shopScoreItemScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreItemScoreLessThan(String value) {
            addCriterion("shop_score_item_score <", value, "shopScoreItemScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreItemScoreLessThanOrEqualTo(String value) {
            addCriterion("shop_score_item_score <=", value, "shopScoreItemScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreItemScoreLike(String value) {
            addCriterion("shop_score_item_score like", value, "shopScoreItemScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreItemScoreNotLike(String value) {
            addCriterion("shop_score_item_score not like", value, "shopScoreItemScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreItemScoreIn(List<String> values) {
            addCriterion("shop_score_item_score in", values, "shopScoreItemScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreItemScoreNotIn(List<String> values) {
            addCriterion("shop_score_item_score not in", values, "shopScoreItemScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreItemScoreBetween(String value1, String value2) {
            addCriterion("shop_score_item_score between", value1, value2, "shopScoreItemScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreItemScoreNotBetween(String value1, String value2) {
            addCriterion("shop_score_item_score not between", value1, value2, "shopScoreItemScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreServiceScoreIsNull() {
            addCriterion("shop_score_service_score is null");
            return (Criteria) this;
        }

        public Criteria andShopScoreServiceScoreIsNotNull() {
            addCriterion("shop_score_service_score is not null");
            return (Criteria) this;
        }

        public Criteria andShopScoreServiceScoreEqualTo(String value) {
            addCriterion("shop_score_service_score =", value, "shopScoreServiceScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreServiceScoreNotEqualTo(String value) {
            addCriterion("shop_score_service_score <>", value, "shopScoreServiceScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreServiceScoreGreaterThan(String value) {
            addCriterion("shop_score_service_score >", value, "shopScoreServiceScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreServiceScoreGreaterThanOrEqualTo(String value) {
            addCriterion("shop_score_service_score >=", value, "shopScoreServiceScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreServiceScoreLessThan(String value) {
            addCriterion("shop_score_service_score <", value, "shopScoreServiceScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreServiceScoreLessThanOrEqualTo(String value) {
            addCriterion("shop_score_service_score <=", value, "shopScoreServiceScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreServiceScoreLike(String value) {
            addCriterion("shop_score_service_score like", value, "shopScoreServiceScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreServiceScoreNotLike(String value) {
            addCriterion("shop_score_service_score not like", value, "shopScoreServiceScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreServiceScoreIn(List<String> values) {
            addCriterion("shop_score_service_score in", values, "shopScoreServiceScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreServiceScoreNotIn(List<String> values) {
            addCriterion("shop_score_service_score not in", values, "shopScoreServiceScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreServiceScoreBetween(String value1, String value2) {
            addCriterion("shop_score_service_score between", value1, value2, "shopScoreServiceScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreServiceScoreNotBetween(String value1, String value2) {
            addCriterion("shop_score_service_score not between", value1, value2, "shopScoreServiceScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreDeliveryScoreIsNull() {
            addCriterion("shop_score_delivery_score is null");
            return (Criteria) this;
        }

        public Criteria andShopScoreDeliveryScoreIsNotNull() {
            addCriterion("shop_score_delivery_score is not null");
            return (Criteria) this;
        }

        public Criteria andShopScoreDeliveryScoreEqualTo(String value) {
            addCriterion("shop_score_delivery_score =", value, "shopScoreDeliveryScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreDeliveryScoreNotEqualTo(String value) {
            addCriterion("shop_score_delivery_score <>", value, "shopScoreDeliveryScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreDeliveryScoreGreaterThan(String value) {
            addCriterion("shop_score_delivery_score >", value, "shopScoreDeliveryScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreDeliveryScoreGreaterThanOrEqualTo(String value) {
            addCriterion("shop_score_delivery_score >=", value, "shopScoreDeliveryScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreDeliveryScoreLessThan(String value) {
            addCriterion("shop_score_delivery_score <", value, "shopScoreDeliveryScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreDeliveryScoreLessThanOrEqualTo(String value) {
            addCriterion("shop_score_delivery_score <=", value, "shopScoreDeliveryScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreDeliveryScoreLike(String value) {
            addCriterion("shop_score_delivery_score like", value, "shopScoreDeliveryScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreDeliveryScoreNotLike(String value) {
            addCriterion("shop_score_delivery_score not like", value, "shopScoreDeliveryScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreDeliveryScoreIn(List<String> values) {
            addCriterion("shop_score_delivery_score in", values, "shopScoreDeliveryScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreDeliveryScoreNotIn(List<String> values) {
            addCriterion("shop_score_delivery_score not in", values, "shopScoreDeliveryScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreDeliveryScoreBetween(String value1, String value2) {
            addCriterion("shop_score_delivery_score between", value1, value2, "shopScoreDeliveryScore");
            return (Criteria) this;
        }

        public Criteria andShopScoreDeliveryScoreNotBetween(String value1, String value2) {
            addCriterion("shop_score_delivery_score not between", value1, value2, "shopScoreDeliveryScore");
            return (Criteria) this;
        }

        public Criteria andRemainCountIsNull() {
            addCriterion("remain_count is null");
            return (Criteria) this;
        }

        public Criteria andRemainCountIsNotNull() {
            addCriterion("remain_count is not null");
            return (Criteria) this;
        }

        public Criteria andRemainCountEqualTo(Long value) {
            addCriterion("remain_count =", value, "remainCount");
            return (Criteria) this;
        }

        public Criteria andRemainCountNotEqualTo(Long value) {
            addCriterion("remain_count <>", value, "remainCount");
            return (Criteria) this;
        }

        public Criteria andRemainCountGreaterThan(Long value) {
            addCriterion("remain_count >", value, "remainCount");
            return (Criteria) this;
        }

        public Criteria andRemainCountGreaterThanOrEqualTo(Long value) {
            addCriterion("remain_count >=", value, "remainCount");
            return (Criteria) this;
        }

        public Criteria andRemainCountLessThan(Long value) {
            addCriterion("remain_count <", value, "remainCount");
            return (Criteria) this;
        }

        public Criteria andRemainCountLessThanOrEqualTo(Long value) {
            addCriterion("remain_count <=", value, "remainCount");
            return (Criteria) this;
        }

        public Criteria andRemainCountIn(List<Long> values) {
            addCriterion("remain_count in", values, "remainCount");
            return (Criteria) this;
        }

        public Criteria andRemainCountNotIn(List<Long> values) {
            addCriterion("remain_count not in", values, "remainCount");
            return (Criteria) this;
        }

        public Criteria andRemainCountBetween(Long value1, Long value2) {
            addCriterion("remain_count between", value1, value2, "remainCount");
            return (Criteria) this;
        }

        public Criteria andRemainCountNotBetween(Long value1, Long value2) {
            addCriterion("remain_count not between", value1, value2, "remainCount");
            return (Criteria) this;
        }

        public Criteria andAllCountIsNull() {
            addCriterion("all_count is null");
            return (Criteria) this;
        }

        public Criteria andAllCountIsNotNull() {
            addCriterion("all_count is not null");
            return (Criteria) this;
        }

        public Criteria andAllCountEqualTo(Long value) {
            addCriterion("all_count =", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountNotEqualTo(Long value) {
            addCriterion("all_count <>", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountGreaterThan(Long value) {
            addCriterion("all_count >", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountGreaterThanOrEqualTo(Long value) {
            addCriterion("all_count >=", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountLessThan(Long value) {
            addCriterion("all_count <", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountLessThanOrEqualTo(Long value) {
            addCriterion("all_count <=", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountIn(List<Long> values) {
            addCriterion("all_count in", values, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountNotIn(List<Long> values) {
            addCriterion("all_count not in", values, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountBetween(Long value1, Long value2) {
            addCriterion("all_count between", value1, value2, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountNotBetween(Long value1, Long value2) {
            addCriterion("all_count not between", value1, value2, "allCount");
            return (Criteria) this;
        }

        public Criteria andUsedCountIsNull() {
            addCriterion("used_count is null");
            return (Criteria) this;
        }

        public Criteria andUsedCountIsNotNull() {
            addCriterion("used_count is not null");
            return (Criteria) this;
        }

        public Criteria andUsedCountEqualTo(Long value) {
            addCriterion("used_count =", value, "usedCount");
            return (Criteria) this;
        }

        public Criteria andUsedCountNotEqualTo(Long value) {
            addCriterion("used_count <>", value, "usedCount");
            return (Criteria) this;
        }

        public Criteria andUsedCountGreaterThan(Long value) {
            addCriterion("used_count >", value, "usedCount");
            return (Criteria) this;
        }

        public Criteria andUsedCountGreaterThanOrEqualTo(Long value) {
            addCriterion("used_count >=", value, "usedCount");
            return (Criteria) this;
        }

        public Criteria andUsedCountLessThan(Long value) {
            addCriterion("used_count <", value, "usedCount");
            return (Criteria) this;
        }

        public Criteria andUsedCountLessThanOrEqualTo(Long value) {
            addCriterion("used_count <=", value, "usedCount");
            return (Criteria) this;
        }

        public Criteria andUsedCountIn(List<Long> values) {
            addCriterion("used_count in", values, "usedCount");
            return (Criteria) this;
        }

        public Criteria andUsedCountNotIn(List<Long> values) {
            addCriterion("used_count not in", values, "usedCount");
            return (Criteria) this;
        }

        public Criteria andUsedCountBetween(Long value1, Long value2) {
            addCriterion("used_count between", value1, value2, "usedCount");
            return (Criteria) this;
        }

        public Criteria andUsedCountNotBetween(Long value1, Long value2) {
            addCriterion("used_count not between", value1, value2, "usedCount");
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