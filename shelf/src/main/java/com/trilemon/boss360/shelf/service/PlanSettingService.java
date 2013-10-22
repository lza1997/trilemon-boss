package com.trilemon.boss360.shelf.service;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.trilemon.boss360.infrastructure.base.service.AppService;
import com.trilemon.boss360.shelf.ShelfConstants;
import com.trilemon.boss360.shelf.ShelfException;
import com.trilemon.boss360.shelf.dao.PlanMapper;
import com.trilemon.boss360.shelf.dao.PlanSettingMapper;
import com.trilemon.boss360.shelf.model.Plan;
import com.trilemon.boss360.shelf.model.PlanSetting;
import com.trilemon.boss360.shelf.service.vo.PlanStatus;
import com.trilemon.commons.Languages;
import com.trilemon.commons.web.Page;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.trilemon.boss360.shelf.ShelfConstants.*;

/**
 * @author kevin
 */
@Service
public class PlanSettingService {
    private final static Logger logger = LoggerFactory.getLogger(PlanSettingService.class);
    @Autowired
    private PlanSettingMapper planSettingMapper;
    @Autowired
    private PlanMapper planMapper;
    @Autowired
    private PlanService planService;
    @Autowired
    private AppService appService;

    /**
     * 创建计划设置
     *
     * @param planSetting
     */
    public void createPlanSetting(Long userId, PlanSetting planSetting) throws ShelfException {
        planSetting.setUserId(userId);
        planSetting.setStatus(PLAN_SETTING_STATUS_WAITING_PLAN);
        try {
            String hanYuPinyin = Languages.getHanYuPinyin(planSetting.getName());
            planSetting.setNamePinyin(hanYuPinyin);
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            logger.error("create createPlan setting error, planSetting[" + ToStringBuilder.reflectionToString(planSetting) + "].",
                    badHanyuPinyinOutputFormatCombination);
        }
        planSetting.setAddTime(appService.getLocalSystemTime().toDate());
        planSettingMapper.insertSelective(planSetting);
        planService.createPlan(userId, planSetting);
    }

    /**
     * 翻页获取用户计划设置
     *
     * @param userId
     * @return
     */
    public Page<PlanSetting> paginatePlanSettings(Long userId, int pageNum, int pageSize) {
        List<Byte> statusList = ImmutableList.of(PLAN_SETTING_STATUS_RUNNING, PLAN_SETTING_STATUS_WAITING_PLAN, PLAN_SETTING_STATUS_PAUSED);
        int totalSize = planSettingMapper.countByUserIdAndStatus(userId, statusList);
        List<PlanSetting> planSettings = planSettingMapper.paginateByUserIdAndStatus(userId, (pageNum - 1) * pageSize,
                pageSize, statusList);
        if (CollectionUtils.isEmpty(planSettings)) {
            return Page.create(totalSize, pageNum, pageSize, Lists.<PlanSetting>newArrayList());
        } else {
            //处理额外字段（总共需要调整宝贝数量，新加入宝贝数量，待调整宝贝数量）
            for (PlanSetting planSetting : planSettings) {
                PlanStatus planStatus = planMapper.calcPlanStatus(planSetting.getId(), planSetting.getLastPlanTime());
                if (null != planStatus) {
                    planSetting.setItemNum(planStatus.getItemNum());
                    planSetting.setNewItemNum(planStatus.getNewItemNum());
                    planSetting.setWaitAdjustItemNum(planStatus.getWaitAdjustItemNum());
                } else {
                    planSetting.setItemNum(0);
                    planSetting.setNewItemNum(0);
                    planSetting.setWaitAdjustItemNum(0);
                }
            }
            return Page.create(totalSize, pageNum, pageSize, planSettings);
        }
    }

    /**
     * @param planSetting
     * @throws ShelfException
     */
    public void updatePlanSetting(Long userId, PlanSetting planSetting) throws ShelfException {
        planSetting.setUserId(userId);
        planSettingMapper.updateByPrimaryKeyAndUserIdSelective(planSetting);
        planMapper.deleteByUserIdAndPlanSettingId(userId, planSetting.getId());
        planService.updatePlan(planSetting.getId());
    }

    /**
     * 只更新名字
     *
     * @param userId
     * @param planSettingId
     * @param name
     * @throws ShelfException
     */
    public void updatePlanSettingName(Long userId, Long planSettingId, String name) throws ShelfException {
        PlanSetting planSetting = new PlanSetting();
        planSetting.setId(planSettingId);
        planSetting.setName(name);
        planSetting.setUserId(userId);
        try {
            String hanYuPinyin = Languages.getHanYuPinyin(planSetting.getName());
            planSetting.setNamePinyin(hanYuPinyin);
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            logger.error("create createPlan setting error, planSetting[" + ToStringBuilder.reflectionToString(planSetting) + "].",
                    badHanyuPinyinOutputFormatCombination);
        }
        planSettingMapper.updateByPrimaryKeyAndUserIdSelective(planSetting);
    }

    /**
     * 获取计划设置
     *
     * @param planSettingId
     * @return
     */
    public PlanSetting getPlanSetting(Long userId, Long planSettingId) {
        return planSettingMapper.selectByPrimaryKeyAndUserId(planSettingId, userId);
    }

    /**
     * 删除计划设置
     *
     * @param planSettingId
     * @return
     */
    @Transactional
    public boolean deletePlanSetting(Long userId, Long planSettingId) {
        int rows = planSettingMapper.deleteByPrimaryKeyAndUserId(planSettingId, userId);
        planService.deletePlan(userId, planSettingId);
        return rows > 0;
    }

    public boolean pausePlanSetting(Long userId, Long planSettingId) {
        PlanSetting planSetting = new PlanSetting();
        planSetting.setUserId(userId);
        planSetting.setId(planSettingId);
        planSetting.setStatus(ShelfConstants.PLAN_SETTING_STATUS_PAUSED);
        int rows = planSettingMapper.updateByPrimaryKeyAndUserIdSelective(planSetting);
        return rows > 0;
    }

    public boolean resumePlanSetting(Long userId, Long planSettingId) {
        PlanSetting planSetting = new PlanSetting();
        planSetting.setUserId(userId);
        planSetting.setId(planSettingId);
        planSetting.setStatus(ShelfConstants.PLAN_SETTING_STATUS_RUNNING);
        int rows = planSettingMapper.updateByPrimaryKeyAndUserIdSelective(planSetting);
        return rows > 0;
    }

    public Page<PlanSetting> searchPlanSettings(Long userId, String query, int pageNum, int pageSize) {
        int totalSize = planSettingMapper.countByUserIdAndName(userId, query);
        List<PlanSetting> planSettings = planSettingMapper.paginateByUserIdAndName(userId,
                query, (pageNum - 1) * pageSize,
                pageSize);
        if (CollectionUtils.isEmpty(planSettings)) {
            return Page.create(totalSize, pageNum, pageSize, Lists.<PlanSetting>newArrayList());
        } else {
            return Page.create(totalSize, pageNum, pageSize, planSettings);
        }
    }

    public Page<Plan> paginatePlans(Long userId, Long planSettingId, int pageNum, int pageSize) {
        List<Byte> statusList = ImmutableList.of(PLAN_STATUS_SUCCESSFUL, PLAN_STATUS_WAITING_ADJUST);
        int totalSize = planMapper.countByUserIdAndPlanSettingIdAndStatus(userId, planSettingId, statusList);
        List<Plan> plans = planMapper.paginateByUserIdAndPlanSettingIdAndStatus(userId,
                planSettingId, statusList, (pageNum - 1) * pageSize,
                pageSize);
        if (CollectionUtils.isEmpty(plans)) {
            return Page.create(totalSize, pageNum, pageSize, Lists.<Plan>newArrayList());
        } else {
            return Page.create(totalSize, pageNum, pageSize, plans);
        }
    }
}
