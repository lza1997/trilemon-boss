package com.trilemon.boss360.shelf.service;

import com.trilemon.boss360.shelf.ShelfException;
import com.trilemon.boss360.shelf.dao.PlanSettingMapper;
import com.trilemon.boss360.shelf.model.PlanSetting;
import com.trilemon.commons.Languages;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kevin
 */
@Service
public class PlanSettingService {
    private final static Logger logger = LoggerFactory.getLogger(PlanSettingService.class);
    @Autowired
    private PlanSettingMapper planSettingMapper;

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

    public PlanSetting getPlanSetting(Long userId) {
        return planSettingMapper.selectByUserId(userId);
    }
}
