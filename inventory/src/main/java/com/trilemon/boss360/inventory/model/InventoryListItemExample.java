package com.trilemon.boss360.inventory.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class InventoryListItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InventoryListItemExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
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

        public Criteria andInventoryListSettingIdIsNull() {
            addCriterion("inventory_list_setting_id is null");
            return (Criteria) this;
        }

        public Criteria andInventoryListSettingIdIsNotNull() {
            addCriterion("inventory_list_setting_id is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryListSettingIdEqualTo(Long value) {
            addCriterion("inventory_list_setting_id =", value, "inventoryListSettingId");
            return (Criteria) this;
        }

        public Criteria andInventoryListSettingIdNotEqualTo(Long value) {
            addCriterion("inventory_list_setting_id <>", value, "inventoryListSettingId");
            return (Criteria) this;
        }

        public Criteria andInventoryListSettingIdGreaterThan(Long value) {
            addCriterion("inventory_list_setting_id >", value, "inventoryListSettingId");
            return (Criteria) this;
        }

        public Criteria andInventoryListSettingIdGreaterThanOrEqualTo(Long value) {
            addCriterion("inventory_list_setting_id >=", value, "inventoryListSettingId");
            return (Criteria) this;
        }

        public Criteria andInventoryListSettingIdLessThan(Long value) {
            addCriterion("inventory_list_setting_id <", value, "inventoryListSettingId");
            return (Criteria) this;
        }

        public Criteria andInventoryListSettingIdLessThanOrEqualTo(Long value) {
            addCriterion("inventory_list_setting_id <=", value, "inventoryListSettingId");
            return (Criteria) this;
        }

        public Criteria andInventoryListSettingIdIn(List<Long> values) {
            addCriterion("inventory_list_setting_id in", values, "inventoryListSettingId");
            return (Criteria) this;
        }

        public Criteria andInventoryListSettingIdNotIn(List<Long> values) {
            addCriterion("inventory_list_setting_id not in", values, "inventoryListSettingId");
            return (Criteria) this;
        }

        public Criteria andInventoryListSettingIdBetween(Long value1, Long value2) {
            addCriterion("inventory_list_setting_id between", value1, value2, "inventoryListSettingId");
            return (Criteria) this;
        }

        public Criteria andInventoryListSettingIdNotBetween(Long value1, Long value2) {
            addCriterion("inventory_list_setting_id not between", value1, value2, "inventoryListSettingId");
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

        public Criteria andPlanListDayIsNull() {
            addCriterion("plan_list_day is null");
            return (Criteria) this;
        }

        public Criteria andPlanListDayIsNotNull() {
            addCriterion("plan_list_day is not null");
            return (Criteria) this;
        }

        public Criteria andPlanListDayEqualTo(Date value) {
            addCriterion("plan_list_day =", value, "planListDay");
            return (Criteria) this;
        }

        public Criteria andPlanListDayNotEqualTo(Date value) {
            addCriterion("plan_list_day <>", value, "planListDay");
            return (Criteria) this;
        }

        public Criteria andPlanListDayGreaterThan(Date value) {
            addCriterion("plan_list_day >", value, "planListDay");
            return (Criteria) this;
        }

        public Criteria andPlanListDayGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_list_day >=", value, "planListDay");
            return (Criteria) this;
        }

        public Criteria andPlanListDayLessThan(Date value) {
            addCriterion("plan_list_day <", value, "planListDay");
            return (Criteria) this;
        }

        public Criteria andPlanListDayLessThanOrEqualTo(Date value) {
            addCriterion("plan_list_day <=", value, "planListDay");
            return (Criteria) this;
        }

        public Criteria andPlanListDayIn(List<Date> values) {
            addCriterion("plan_list_day in", values, "planListDay");
            return (Criteria) this;
        }

        public Criteria andPlanListDayNotIn(List<Date> values) {
            addCriterion("plan_list_day not in", values, "planListDay");
            return (Criteria) this;
        }

        public Criteria andPlanListDayBetween(Date value1, Date value2) {
            addCriterion("plan_list_day between", value1, value2, "planListDay");
            return (Criteria) this;
        }

        public Criteria andPlanListDayNotBetween(Date value1, Date value2) {
            addCriterion("plan_list_day not between", value1, value2, "planListDay");
            return (Criteria) this;
        }

        public Criteria andPlanListStartTimeIsNull() {
            addCriterion("plan_list_start_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanListStartTimeIsNotNull() {
            addCriterion("plan_list_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanListStartTimeEqualTo(Date value) {
            addCriterionForJDBCTime("plan_list_start_time =", value, "planListStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanListStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("plan_list_start_time <>", value, "planListStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanListStartTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("plan_list_start_time >", value, "planListStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanListStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("plan_list_start_time >=", value, "planListStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanListStartTimeLessThan(Date value) {
            addCriterionForJDBCTime("plan_list_start_time <", value, "planListStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanListStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("plan_list_start_time <=", value, "planListStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanListStartTimeIn(List<Date> values) {
            addCriterionForJDBCTime("plan_list_start_time in", values, "planListStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanListStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("plan_list_start_time not in", values, "planListStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanListStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("plan_list_start_time between", value1, value2, "planListStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanListStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("plan_list_start_time not between", value1, value2, "planListStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanListEndTimeIsNull() {
            addCriterion("plan_list_end_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanListEndTimeIsNotNull() {
            addCriterion("plan_list_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanListEndTimeEqualTo(Date value) {
            addCriterionForJDBCTime("plan_list_end_time =", value, "planListEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanListEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("plan_list_end_time <>", value, "planListEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanListEndTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("plan_list_end_time >", value, "planListEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanListEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("plan_list_end_time >=", value, "planListEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanListEndTimeLessThan(Date value) {
            addCriterionForJDBCTime("plan_list_end_time <", value, "planListEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanListEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("plan_list_end_time <=", value, "planListEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanListEndTimeIn(List<Date> values) {
            addCriterionForJDBCTime("plan_list_end_time in", values, "planListEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanListEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("plan_list_end_time not in", values, "planListEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanListEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("plan_list_end_time between", value1, value2, "planListEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanListEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("plan_list_end_time not between", value1, value2, "planListEndTime");
            return (Criteria) this;
        }

        public Criteria andListTimeIsNull() {
            addCriterion("list_time is null");
            return (Criteria) this;
        }

        public Criteria andListTimeIsNotNull() {
            addCriterion("list_time is not null");
            return (Criteria) this;
        }

        public Criteria andListTimeEqualTo(Date value) {
            addCriterion("list_time =", value, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeNotEqualTo(Date value) {
            addCriterion("list_time <>", value, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeGreaterThan(Date value) {
            addCriterion("list_time >", value, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("list_time >=", value, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeLessThan(Date value) {
            addCriterion("list_time <", value, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeLessThanOrEqualTo(Date value) {
            addCriterion("list_time <=", value, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeIn(List<Date> values) {
            addCriterion("list_time in", values, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeNotIn(List<Date> values) {
            addCriterion("list_time not in", values, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeBetween(Date value1, Date value2) {
            addCriterion("list_time between", value1, value2, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeNotBetween(Date value1, Date value2) {
            addCriterion("list_time not between", value1, value2, "listTime");
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