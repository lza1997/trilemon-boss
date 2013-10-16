package com.trilemon.boss360.shelf.model;

import java.util.ArrayList;
import java.util.Date;
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

        public Criteria andPlanSettingIdIsNull() {
            addCriterion("plan_setting_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdIsNotNull() {
            addCriterion("plan_setting_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdEqualTo(Long value) {
            addCriterion("plan_setting_id =", value, "planSettingId");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdNotEqualTo(Long value) {
            addCriterion("plan_setting_id <>", value, "planSettingId");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdGreaterThan(Long value) {
            addCriterion("plan_setting_id >", value, "planSettingId");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_setting_id >=", value, "planSettingId");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdLessThan(Long value) {
            addCriterion("plan_setting_id <", value, "planSettingId");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdLessThanOrEqualTo(Long value) {
            addCriterion("plan_setting_id <=", value, "planSettingId");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdIn(List<Long> values) {
            addCriterion("plan_setting_id in", values, "planSettingId");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdNotIn(List<Long> values) {
            addCriterion("plan_setting_id not in", values, "planSettingId");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdBetween(Long value1, Long value2) {
            addCriterion("plan_setting_id between", value1, value2, "planSettingId");
            return (Criteria) this;
        }

        public Criteria andPlanSettingIdNotBetween(Long value1, Long value2) {
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

        public Criteria andItemIidIsNull() {
            addCriterion("item_iid is null");
            return (Criteria) this;
        }

        public Criteria andItemIidIsNotNull() {
            addCriterion("item_iid is not null");
            return (Criteria) this;
        }

        public Criteria andItemIidEqualTo(Long value) {
            addCriterion("item_iid =", value, "itemIid");
            return (Criteria) this;
        }

        public Criteria andItemIidNotEqualTo(Long value) {
            addCriterion("item_iid <>", value, "itemIid");
            return (Criteria) this;
        }

        public Criteria andItemIidGreaterThan(Long value) {
            addCriterion("item_iid >", value, "itemIid");
            return (Criteria) this;
        }

        public Criteria andItemIidGreaterThanOrEqualTo(Long value) {
            addCriterion("item_iid >=", value, "itemIid");
            return (Criteria) this;
        }

        public Criteria andItemIidLessThan(Long value) {
            addCriterion("item_iid <", value, "itemIid");
            return (Criteria) this;
        }

        public Criteria andItemIidLessThanOrEqualTo(Long value) {
            addCriterion("item_iid <=", value, "itemIid");
            return (Criteria) this;
        }

        public Criteria andItemIidIn(List<Long> values) {
            addCriterion("item_iid in", values, "itemIid");
            return (Criteria) this;
        }

        public Criteria andItemIidNotIn(List<Long> values) {
            addCriterion("item_iid not in", values, "itemIid");
            return (Criteria) this;
        }

        public Criteria andItemIidBetween(Long value1, Long value2) {
            addCriterion("item_iid between", value1, value2, "itemIid");
            return (Criteria) this;
        }

        public Criteria andItemIidNotBetween(Long value1, Long value2) {
            addCriterion("item_iid not between", value1, value2, "itemIid");
            return (Criteria) this;
        }

        public Criteria andIsNewItemIsNull() {
            addCriterion("is_new_item is null");
            return (Criteria) this;
        }

        public Criteria andIsNewItemIsNotNull() {
            addCriterion("is_new_item is not null");
            return (Criteria) this;
        }

        public Criteria andIsNewItemEqualTo(Boolean value) {
            addCriterion("is_new_item =", value, "isNewItem");
            return (Criteria) this;
        }

        public Criteria andIsNewItemNotEqualTo(Boolean value) {
            addCriterion("is_new_item <>", value, "isNewItem");
            return (Criteria) this;
        }

        public Criteria andIsNewItemGreaterThan(Boolean value) {
            addCriterion("is_new_item >", value, "isNewItem");
            return (Criteria) this;
        }

        public Criteria andIsNewItemGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_new_item >=", value, "isNewItem");
            return (Criteria) this;
        }

        public Criteria andIsNewItemLessThan(Boolean value) {
            addCriterion("is_new_item <", value, "isNewItem");
            return (Criteria) this;
        }

        public Criteria andIsNewItemLessThanOrEqualTo(Boolean value) {
            addCriterion("is_new_item <=", value, "isNewItem");
            return (Criteria) this;
        }

        public Criteria andIsNewItemIn(List<Boolean> values) {
            addCriterion("is_new_item in", values, "isNewItem");
            return (Criteria) this;
        }

        public Criteria andIsNewItemNotIn(List<Boolean> values) {
            addCriterion("is_new_item not in", values, "isNewItem");
            return (Criteria) this;
        }

        public Criteria andIsNewItemBetween(Boolean value1, Boolean value2) {
            addCriterion("is_new_item between", value1, value2, "isNewItem");
            return (Criteria) this;
        }

        public Criteria andIsNewItemNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_new_item not between", value1, value2, "isNewItem");
            return (Criteria) this;
        }

        public Criteria andItemTitleIsNull() {
            addCriterion("item_title is null");
            return (Criteria) this;
        }

        public Criteria andItemTitleIsNotNull() {
            addCriterion("item_title is not null");
            return (Criteria) this;
        }

        public Criteria andItemTitleEqualTo(String value) {
            addCriterion("item_title =", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleNotEqualTo(String value) {
            addCriterion("item_title <>", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleGreaterThan(String value) {
            addCriterion("item_title >", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleGreaterThanOrEqualTo(String value) {
            addCriterion("item_title >=", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleLessThan(String value) {
            addCriterion("item_title <", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleLessThanOrEqualTo(String value) {
            addCriterion("item_title <=", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleLike(String value) {
            addCriterion("item_title like", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleNotLike(String value) {
            addCriterion("item_title not like", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleIn(List<String> values) {
            addCriterion("item_title in", values, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleNotIn(List<String> values) {
            addCriterion("item_title not in", values, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleBetween(String value1, String value2) {
            addCriterion("item_title between", value1, value2, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleNotBetween(String value1, String value2) {
            addCriterion("item_title not between", value1, value2, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitlePinyinIsNull() {
            addCriterion("item_title_pinyin is null");
            return (Criteria) this;
        }

        public Criteria andItemTitlePinyinIsNotNull() {
            addCriterion("item_title_pinyin is not null");
            return (Criteria) this;
        }

        public Criteria andItemTitlePinyinEqualTo(String value) {
            addCriterion("item_title_pinyin =", value, "itemTitlePinyin");
            return (Criteria) this;
        }

        public Criteria andItemTitlePinyinNotEqualTo(String value) {
            addCriterion("item_title_pinyin <>", value, "itemTitlePinyin");
            return (Criteria) this;
        }

        public Criteria andItemTitlePinyinGreaterThan(String value) {
            addCriterion("item_title_pinyin >", value, "itemTitlePinyin");
            return (Criteria) this;
        }

        public Criteria andItemTitlePinyinGreaterThanOrEqualTo(String value) {
            addCriterion("item_title_pinyin >=", value, "itemTitlePinyin");
            return (Criteria) this;
        }

        public Criteria andItemTitlePinyinLessThan(String value) {
            addCriterion("item_title_pinyin <", value, "itemTitlePinyin");
            return (Criteria) this;
        }

        public Criteria andItemTitlePinyinLessThanOrEqualTo(String value) {
            addCriterion("item_title_pinyin <=", value, "itemTitlePinyin");
            return (Criteria) this;
        }

        public Criteria andItemTitlePinyinLike(String value) {
            addCriterion("item_title_pinyin like", value, "itemTitlePinyin");
            return (Criteria) this;
        }

        public Criteria andItemTitlePinyinNotLike(String value) {
            addCriterion("item_title_pinyin not like", value, "itemTitlePinyin");
            return (Criteria) this;
        }

        public Criteria andItemTitlePinyinIn(List<String> values) {
            addCriterion("item_title_pinyin in", values, "itemTitlePinyin");
            return (Criteria) this;
        }

        public Criteria andItemTitlePinyinNotIn(List<String> values) {
            addCriterion("item_title_pinyin not in", values, "itemTitlePinyin");
            return (Criteria) this;
        }

        public Criteria andItemTitlePinyinBetween(String value1, String value2) {
            addCriterion("item_title_pinyin between", value1, value2, "itemTitlePinyin");
            return (Criteria) this;
        }

        public Criteria andItemTitlePinyinNotBetween(String value1, String value2) {
            addCriterion("item_title_pinyin not between", value1, value2, "itemTitlePinyin");
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

        public Criteria andItemPicUrlEqualTo(String value) {
            addCriterion("item_pic_url =", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlNotEqualTo(String value) {
            addCriterion("item_pic_url <>", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlGreaterThan(String value) {
            addCriterion("item_pic_url >", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("item_pic_url >=", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlLessThan(String value) {
            addCriterion("item_pic_url <", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlLessThanOrEqualTo(String value) {
            addCriterion("item_pic_url <=", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlLike(String value) {
            addCriterion("item_pic_url like", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlNotLike(String value) {
            addCriterion("item_pic_url not like", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlIn(List<String> values) {
            addCriterion("item_pic_url in", values, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlNotIn(List<String> values) {
            addCriterion("item_pic_url not in", values, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlBetween(String value1, String value2) {
            addCriterion("item_pic_url between", value1, value2, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlNotBetween(String value1, String value2) {
            addCriterion("item_pic_url not between", value1, value2, "itemPicUrl");
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

        public Criteria andPlanAdjustTimeIsNull() {
            addCriterion("plan_adjust_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanAdjustTimeIsNotNull() {
            addCriterion("plan_adjust_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanAdjustTimeEqualTo(Date value) {
            addCriterion("plan_adjust_time =", value, "planAdjustTime");
            return (Criteria) this;
        }

        public Criteria andPlanAdjustTimeNotEqualTo(Date value) {
            addCriterion("plan_adjust_time <>", value, "planAdjustTime");
            return (Criteria) this;
        }

        public Criteria andPlanAdjustTimeGreaterThan(Date value) {
            addCriterion("plan_adjust_time >", value, "planAdjustTime");
            return (Criteria) this;
        }

        public Criteria andPlanAdjustTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_adjust_time >=", value, "planAdjustTime");
            return (Criteria) this;
        }

        public Criteria andPlanAdjustTimeLessThan(Date value) {
            addCriterion("plan_adjust_time <", value, "planAdjustTime");
            return (Criteria) this;
        }

        public Criteria andPlanAdjustTimeLessThanOrEqualTo(Date value) {
            addCriterion("plan_adjust_time <=", value, "planAdjustTime");
            return (Criteria) this;
        }

        public Criteria andPlanAdjustTimeIn(List<Date> values) {
            addCriterion("plan_adjust_time in", values, "planAdjustTime");
            return (Criteria) this;
        }

        public Criteria andPlanAdjustTimeNotIn(List<Date> values) {
            addCriterion("plan_adjust_time not in", values, "planAdjustTime");
            return (Criteria) this;
        }

        public Criteria andPlanAdjustTimeBetween(Date value1, Date value2) {
            addCriterion("plan_adjust_time between", value1, value2, "planAdjustTime");
            return (Criteria) this;
        }

        public Criteria andPlanAdjustTimeNotBetween(Date value1, Date value2) {
            addCriterion("plan_adjust_time not between", value1, value2, "planAdjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeIsNull() {
            addCriterion("adjust_time is null");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeIsNotNull() {
            addCriterion("adjust_time is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeEqualTo(Date value) {
            addCriterion("adjust_time =", value, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeNotEqualTo(Date value) {
            addCriterion("adjust_time <>", value, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeGreaterThan(Date value) {
            addCriterion("adjust_time >", value, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("adjust_time >=", value, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeLessThan(Date value) {
            addCriterion("adjust_time <", value, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeLessThanOrEqualTo(Date value) {
            addCriterion("adjust_time <=", value, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeIn(List<Date> values) {
            addCriterion("adjust_time in", values, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeNotIn(List<Date> values) {
            addCriterion("adjust_time not in", values, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeBetween(Date value1, Date value2) {
            addCriterion("adjust_time between", value1, value2, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeNotBetween(Date value1, Date value2) {
            addCriterion("adjust_time not between", value1, value2, "adjustTime");
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