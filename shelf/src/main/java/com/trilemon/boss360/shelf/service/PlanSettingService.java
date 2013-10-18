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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
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

    public void createPlanSetting(PlanSetting planSetting) throws ShelfException {
        try {
            String hanYuPinyin = Languages.getHanYuPinyin(planSetting.getName());
            planSetting.setNamePinyin(hanYuPinyin);
            planSettingMapper.insertSelective(planSetting);
            //planJob.fillQueue(planSetting);
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            logger.error("save plan setting error.", badHanyuPinyinOutputFormatCombination);
            throw new ShelfException(badHanyuPinyinOutputFormatCombination);
        }
    }

    public List<PlanSetting> getPlanSettings(Long userId) {
        return planSettingMapper.selectByUserId(userId);
    }

    @NotNull
    public Page<PlanSetting> paginatePlanSettings(Long userId, int pageNum, int pageSize) {
        List<Byte> statusList = ImmutableList.of(PLAN_SETTING_STATUS_RUNNING, PLAN_SETTING_STATUS_WAITING_PLAN);
        int totalSize = planSettingMapper.countByUserIdAndStatus(userId, statusList);
        List<PlanSetting> planSettings = planSettingMapper.paginationByUserIdAndStatus(userId, (pageNum - 1) * pageSize,
                pageSize, statusList);
        if (CollectionUtils.isEmpty(planSettings)) {
            return Page.create(totalSize, pageNum, pageSize, Lists.<PlanSetting>newArrayList());
        } else {
            Page<PlanSetting> page = Page.create(totalSize, pageNum, pageSize, planSettings);
            return page;
        }
    }

    /**
     * 考虑只更新名字的情况
     * @param planSetting
     * @throws ShelfException
     */
    public void updatePlanSetting(PlanSetting planSetting) throws ShelfException {
        planSettingMapper.updateByPrimaryKeySelective(planSetting);
        planMapper.deleteByPlanSettingId(planSetting.getId());
        planService.plan(planSetting);
    }

    public PlanSetting getPlanSetting(Long planSettingId) {
        return planSettingMapper.selectByPrimaryKey(planSettingId);
    }

    public boolean deletePlanSetting(Long planSettingId) {
        int rows = planSettingMapper.deleteByPrimaryKey(planSettingId);
        return rows > 0;
    }
}
