package com.trilemon.boss360.shelf.service;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.trilemon.boss360.shelf.ShelfException;
import com.trilemon.boss360.shelf.dao.PlanMapper;
import com.trilemon.boss360.shelf.dao.PlanSettingMapper;
import com.trilemon.boss360.shelf.model.PlanSetting;
import com.trilemon.boss360.shelf.service.job.PlanJob;
import com.trilemon.commons.Languages;
import com.trilemon.commons.web.Page;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.trilemon.boss360.shelf.ShelfConstants.PLAN_SETTING_STATUS_RUNNING;
import static com.trilemon.boss360.shelf.ShelfConstants.PLAN_SETTING_STATUS_WAITING_PLAN;

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
    //@Autowired
    private PlanJob planJob;

    /**
     * 创建计划设置
     * @param planSetting
     * @throws ShelfException
     */
    public void createPlanSetting(Long userId,PlanSetting planSetting) throws ShelfException {
        try {
            String hanYuPinyin = Languages.getHanYuPinyin(planSetting.getName());
            planSetting.setUserId(userId);
            planSetting.setNamePinyin(hanYuPinyin);
            planSettingMapper.insertSelective(planSetting);
            //planJob.fillQueue(planSetting);
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            throw new ShelfException("create plan setting error, planSetting[" + ToStringBuilder.reflectionToString(planSetting) + "].",
                    badHanyuPinyinOutputFormatCombination);
        }
    }

    /**
     * 获取用户所有的计划设置
     * @param userId
     * @return
     */
    public List<PlanSetting> getPlanSettings(Long userId) {
        return planSettingMapper.selectByUserId(userId);
    }

    /**
     * 翻页获取用户计划设置
     * @param userId
     * @return
     */
    public Page<PlanSetting> paginatePlanSettings(Long userId, int pageNum, int pageSize) {
        List<Byte> statusList = ImmutableList.of(PLAN_SETTING_STATUS_RUNNING, PLAN_SETTING_STATUS_WAITING_PLAN);
        int totalSize = planSettingMapper.countByUserIdAndStatus(userId, statusList);
        List<PlanSetting> planSettings = planSettingMapper.paginateByUserIdAndStatus(userId, (pageNum - 1) * pageSize,
                pageSize, statusList);
        if (CollectionUtils.isEmpty(planSettings)) {
            return Page.create(totalSize, pageNum, pageSize, Lists.<PlanSetting>newArrayList());
        } else {
            Page<PlanSetting> page = Page.create(totalSize, pageNum, pageSize, planSettings);
            return page;
        }
    }

    /**
     * TODO 考虑只更新名字的情况
     * 更新计划
     *
     * @param planSetting
     * @throws ShelfException
     */
    public void updatePlanSetting(Long userId,PlanSetting planSetting) throws ShelfException {
        planSettingMapper.updateByPrimaryKeyAndUserIdSelective(planSetting,userId);
        planMapper.deleteByUserIdAndPlanSettingId(userId,planSetting.getId());
        planService.plan(userId,planSetting);
    }

    /**
     * 获取计划设置
     * @param planSettingId
     * @return
     */
    public PlanSetting getPlanSetting(Long userId,Long planSettingId) {
        return planSettingMapper.selectByPrimaryKeyAndUserId(planSettingId,userId);
    }

    /**
     * 删除计划设置
     * @param planSettingId
     * @return
     */
    public boolean deletePlanSetting(Long userId,Long planSettingId) {
        int rows = planSettingMapper.deleteByPrimaryKeyAndUserId(planSettingId, userId);
        return rows > 0;
    }
}
