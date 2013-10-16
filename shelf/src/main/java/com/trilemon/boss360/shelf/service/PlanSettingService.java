package com.trilemon.boss360.shelf.service;

import com.trilemon.boss360.shelf.ShelfException;
import com.trilemon.boss360.shelf.dao.PlanMapper;
import com.trilemon.boss360.shelf.dao.PlanSettingMapper;
import com.trilemon.boss360.shelf.model.PlanSetting;
import com.trilemon.commons.Languages;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void savePlanSetting(PlanSetting planSetting) throws ShelfException {
        try {
            String hanYuPinyin = Languages.getHanYuPinyin(planSetting.getName());
            planSetting.setNamePinyin(hanYuPinyin);
            planSettingMapper.insertSelective(planSetting);
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            logger.error("save plan setting error.", badHanyuPinyinOutputFormatCombination);
            throw new ShelfException(badHanyuPinyinOutputFormatCombination);
        }
    }

    public List<PlanSetting> getPlanSettings(Long userId) {
        return planSettingMapper.selectByUserId(userId);
    }

    public void updatePlanSetting(PlanSetting planSetting) throws ShelfException {
        planSettingMapper.updateByPrimaryKeySelective(planSetting);
        planMapper.deleteByPlanSettingId(planSetting.getId());
        planService.plan(planSetting);
    }

    public PlanSetting getPlanSetting(Long planSettingId) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
