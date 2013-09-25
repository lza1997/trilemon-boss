package com.trilemon.top.boss360.shelf.model;

import java.util.ArrayList;
import java.util.List;

public class PlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlanExample() {
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

        public Criteria andPlanSettingIdIsNull() {
            addCriterion("plan_setting_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdIsNotNull() {
            addCriterion("plan_setting_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdEqualTo(Integer value) {
            addCriterion("plan_setting_id =", value, "planSettingId");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdNotEqualTo(Integer value) {
            addCriterion("plan_setting_id <>", value, "planSettingId");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdGreaterThan(Integer value) {
            addCriterion("plan_setting_id >", value, "planSettingId");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_setting_id >=", value, "planSettingId");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdLessThan(Integer value) {
            addCriterion("plan_setting_id <", value, "planSettingId");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdLessThanOrEqualTo(Integer value) {
            addCriterion("plan_setting_id <=", value, "planSettingId");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdIn(List<Integer> values) {
            addCriterion("plan_setting_id in", values, "planSettingId");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdNotIn(List<Integer> values) {
            addCriterion("plan_setting_id not in", values, "planSettingId");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdBetween(Integer value1, Integer value2) {
            addCriterion("plan_setting_id between", value1, value2, "planSettingId");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_setting_id not between", value1, value2, "planSettingId");
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

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andItemIidIsNull() {
            addCriterion("item_iid is null");
            return (Criteria) this;
        }

        public Criteria andItemIidIsNotNull() {
            addCriterion("item_iid is not null");
            return (Criteria) this;
        }

        public Criteria andItemIidEqualTo(Integer value) {
            addCriterion("item_iid =", value, "itemIid");
            return (Criteria) this;
        }

        public Criteria andItemIidNotEqualTo(Integer value) {
            addCriterion("item_iid <>", value, "itemIid");
            return (Criteria) this;
        }

        public Criteria andItemIidGreaterThan(Integer value) {
            addCriterion("item_iid >", value, "itemIid");
            return (Criteria) this;
        }

        public Criteria andItemIidGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_iid >=", value, "itemIid");
            return (Criteria) this;
        }

        public Criteria andItemIidLessThan(Integer value) {
            addCriterion("item_iid <", value, "itemIid");
            return (Criteria) this;
        }

        public Criteria andItemIidLessThanOrEqualTo(Integer value) {
            addCriterion("item_iid <=", value, "itemIid");
            return (Criteria) this;
        }

        public Criteria andItemIidIn(List<Integer> values) {
            addCriterion("item_iid in", values, "itemIid");
            return (Criteria) this;
        }

        public Criteria andItemIidNotIn(List<Integer> values) {
            addCriterion("item_iid not in", values, "itemIid");
            return (Criteria) this;
        }

        public Criteria andItemIidBetween(Integer value1, Integer value2) {
            addCriterion("item_iid between", value1, value2, "itemIid");
            return (Criteria) this;
        }

        public Criteria andItemIidNotBetween(Integer value1, Integer value2) {
            addCriterion("item_iid not between", value1, value2, "itemIid");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("item_name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("item_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(Integer value) {
            addCriterion("item_name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(Integer value) {
            addCriterion("item_name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(Integer value) {
            addCriterion("item_name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(Integer value) {
            addCriterion("item_name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(Integer value) {
            addCriterion("item_name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<Integer> values) {
            addCriterion("item_name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<Integer> values) {
            addCriterion("item_name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(Integer value1, Integer value2) {
            addCriterion("item_name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(Integer value1, Integer value2) {
            addCriterion("item_name not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlIsNull() {
            addCriterion("item_pic_url is null");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlIsNotNull() {
            addCriterion("item_pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlEqualTo(Integer value) {
            addCriterion("item_pic_url =", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlNotEqualTo(Integer value) {
            addCriterion("item_pic_url <>", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlGreaterThan(Integer value) {
            addCriterion("item_pic_url >", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_pic_url >=", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlLessThan(Integer value) {
            addCriterion("item_pic_url <", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlLessThanOrEqualTo(Integer value) {
            addCriterion("item_pic_url <=", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlIn(List<Integer> values) {
            addCriterion("item_pic_url in", values, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlNotIn(List<Integer> values) {
            addCriterion("item_pic_url not in", values, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlBetween(Integer value1, Integer value2) {
            addCriterion("item_pic_url between", value1, value2, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlNotBetween(Integer value1, Integer value2) {
            addCriterion("item_pic_url not between", value1, value2, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andPlanListingTimeIsNull() {
            addCriterion("plan_listing_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanListingTimeIsNotNull() {
            addCriterion("plan_listing_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanListingTimeEqualTo(Integer value) {
            addCriterion("plan_listing_time =", value, "planListingTime");
            return (Criteria) this;
        }

        public Criteria andPlanListingTimeNotEqualTo(Integer value) {
            addCriterion("plan_listing_time <>", value, "planListingTime");
            return (Criteria) this;
        }

        public Criteria andPlanListingTimeGreaterThan(Integer value) {
            addCriterion("plan_listing_time >", value, "planListingTime");
            return (Criteria) this;
        }

        public Criteria andPlanListingTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_listing_time >=", value, "planListingTime");
            return (Criteria) this;
        }

        public Criteria andPlanListingTimeLessThan(Integer value) {
            addCriterion("plan_listing_time <", value, "planListingTime");
            return (Criteria) this;
        }

        public Criteria andPlanListingTimeLessThanOrEqualTo(Integer value) {
            addCriterion("plan_listing_time <=", value, "planListingTime");
            return (Criteria) this;
        }

        public Criteria andPlanListingTimeIn(List<Integer> values) {
            addCriterion("plan_listing_time in", values, "planListingTime");
            return (Criteria) this;
        }

        public Criteria andPlanListingTimeNotIn(List<Integer> values) {
            addCriterion("plan_listing_time not in", values, "planListingTime");
            return (Criteria) this;
        }

        public Criteria andPlanListingTimeBetween(Integer value1, Integer value2) {
            addCriterion("plan_listing_time between", value1, value2, "planListingTime");
            return (Criteria) this;
        }

        public Criteria andPlanListingTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_listing_time not between", value1, value2, "planListingTime");
            return (Criteria) this;
        }

        public Criteria andListingTimeIsNull() {
            addCriterion("listing_time is null");
            return (Criteria) this;
        }

        public Criteria andListingTimeIsNotNull() {
            addCriterion("listing_time is not null");
            return (Criteria) this;
        }

        public Criteria andListingTimeEqualTo(Integer value) {
            addCriterion("listing_time =", value, "listingTime");
            return (Criteria) this;
        }

        public Criteria andListingTimeNotEqualTo(Integer value) {
            addCriterion("listing_time <>", value, "listingTime");
            return (Criteria) this;
        }

        public Criteria andListingTimeGreaterThan(Integer value) {
            addCriterion("listing_time >", value, "listingTime");
            return (Criteria) this;
        }

        public Criteria andListingTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("listing_time >=", value, "listingTime");
            return (Criteria) this;
        }

        public Criteria andListingTimeLessThan(Integer value) {
            addCriterion("listing_time <", value, "listingTime");
            return (Criteria) this;
        }

        public Criteria andListingTimeLessThanOrEqualTo(Integer value) {
            addCriterion("listing_time <=", value, "listingTime");
            return (Criteria) this;
        }

        public Criteria andListingTimeIn(List<Integer> values) {
            addCriterion("listing_time in", values, "listingTime");
            return (Criteria) this;
        }

        public Criteria andListingTimeNotIn(List<Integer> values) {
            addCriterion("listing_time not in", values, "listingTime");
            return (Criteria) this;
        }

        public Criteria andListingTimeBetween(Integer value1, Integer value2) {
            addCriterion("listing_time between", value1, value2, "listingTime");
            return (Criteria) this;
        }

        public Criteria andListingTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("listing_time not between", value1, value2, "listingTime");
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

        public Criteria andAddTimeEqualTo(Integer value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Integer value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Integer value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Integer value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Integer value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Integer> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Integer> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Integer value1, Integer value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Integer value1, Integer value2) {
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

        public Criteria andUpdTimeEqualTo(Integer value) {
            addCriterion("upd_time =", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotEqualTo(Integer value) {
            addCriterion("upd_time <>", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThan(Integer value) {
            addCriterion("upd_time >", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("upd_time >=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThan(Integer value) {
            addCriterion("upd_time <", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThanOrEqualTo(Integer value) {
            addCriterion("upd_time <=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIn(List<Integer> values) {
            addCriterion("upd_time in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotIn(List<Integer> values) {
            addCriterion("upd_time not in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeBetween(Integer value1, Integer value2) {
            addCriterion("upd_time between", value1, value2, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotBetween(Integer value1, Integer value2) {
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