package com.trilemon.boss.rate.service;

import com.google.common.collect.ImmutableList;
import com.trilemon.boss.infra.base.BaseConstants;
import com.trilemon.boss.infra.base.client.BaseClient;
import com.trilemon.boss.infra.base.model.BuyerBlacklist;
import com.trilemon.boss.rate.dao.RateCommentSettingDAO;
import com.trilemon.boss.rate.dao.RateSettingDAO;
import com.trilemon.boss.rate.model.RateSetting;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.trilemon.boss.rate.RateConstants.*;

/**
 * @author kevin
 */
@Service
public class RateSettingService {
    @Autowired
    private RateCommentSettingDAO rateCommentSettingDAO;
    @Autowired
    private RateSettingDAO rateSettingDAO;
    @Autowired
    private BaseClient baseClient;

    public void createRateSetting(Long userId, RateSetting rateSetting) {
        if (null==rateSettingDAO.selectByUserId(userId)) {
            rateSetting.setUserId(userId);
        }
    }

    public void expireUser(Long userId) {
        RateSetting rateSetting = new RateSetting();
        rateSetting.setUserId(userId);
        rateSetting.setStatus(RATE_SETTING_EXPIRED);
        rateSettingDAO.updateByUserId(rateSetting);
    }

    public List<String> getComments(Long userId) {
        List<String> commentContents = rateCommentSettingDAO.selectContentByUserIdAndStatus(userId,
                ImmutableList.of(RATE_COMMENT_SETTING_STATUS_VALID));

        if (CollectionUtils.isEmpty(commentContents)) {
            return DEFAULT_COMMENT_LIST;
        } else {
            return commentContents;
        }
    }

    public List<BuyerBlacklist> paginateBuyerBlacklist(Long userId, int pageNum, int pageSize) {
        return baseClient.paginateBuyerBlacklist(userId, BaseConstants.BLACKLIST_TYPE_RATE, pageNum, pageSize, null, null);
    }

    public void addBlacklist(Long userId, String nick) {
        BuyerBlacklist buyerBlacklist = new BuyerBlacklist();
        buyerBlacklist.setUserId(userId);
        buyerBlacklist.setBuyerNick(nick);
        buyerBlacklist.setType(BaseConstants.BLACKLIST_TYPE_RATE);
        baseClient.addBuyerBlacklist(buyerBlacklist);
    }
}
