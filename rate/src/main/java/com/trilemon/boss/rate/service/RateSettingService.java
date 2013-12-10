package com.trilemon.boss.rate.service;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.trilemon.boss.infra.base.BaseConstants;
import com.trilemon.boss.infra.base.client.BaseClient;
import com.trilemon.boss.infra.base.model.BuyerBlacklist;
import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.infra.sync.rate.client.RateClient;
import com.trilemon.boss.rate.dao.RateCommentSettingDAO;
import com.trilemon.boss.rate.dao.RateOrderDAO;
import com.trilemon.boss.rate.dao.RateSettingDAO;
import com.trilemon.boss.rate.model.RateCommentSetting;
import com.trilemon.boss.rate.model.RateOrder;
import com.trilemon.boss.rate.model.RateSetting;
import com.trilemon.commons.Collections3;
import com.trilemon.commons.web.Page;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private RateClient rateClient;
    @Autowired
    private AppService appService;
    @Autowired
    private RateService rateService;
    @Autowired
    private RateOrderDAO rateOrderDAO;

    /**
     * 创建
     *
     * @param userId
     */
    public void createRateSetting(Long userId) {
        if (null == rateSettingDAO.selectByUserId(userId)) {
            RateSetting rateSetting = new RateSetting();
            rateSetting.setUserId(userId);
            rateSetting.setRateType(RATE_TYPE_IMMEDIATELY);
            rateSetting.setAutoGoodRate(true);
            rateSetting.setAutoNeutralRate(false);
            rateSetting.setAutoBadRate(false);
            rateSetting.setEnableCreditFilter(false);
            rateSetting.setEnableRegisterDayFilter(false);
            rateSetting.setEnableGoodRateFilter(false);
            rateSetting.setEnableBadRateFilter(false);
            rateSetting.setEnableBlacklistFilter(false);
            rateSetting.setEnableSmsNotify(false);
            rateSetting.setUserId(userId);
            rateSetting.setStatus(RATE_SETTING_STATUS_RUNNING);
            rateSetting.setAddTime(appService.getLocalSystemTime().toDate());
            rateSetting.setAutoGoodRate(true);
            rateSettingDAO.insertSelective(rateSetting);
        }
    }

    /**
     * 恢复运行，如果设置不存在直接返回
     *
     * @param userId
     */
    public void resumeRateSetting(Long userId) {
        RateSetting rateSetting = rateSettingDAO.selectByUserId(userId);
        if (null != rateSetting) {
            RateSetting newRateSetting = new RateSetting();
            newRateSetting.setUserId(userId);
            newRateSetting.setStatus(RATE_SETTING_STATUS_RUNNING);
            rateSettingDAO.updateByUserId(newRateSetting);
        }
    }

    /**
     * 暂停运行，如果设置不存在直接返回
     *
     * @param userId
     */
    public void pauseRateSetting(Long userId) {
        RateSetting rateSetting = rateSettingDAO.selectByUserId(userId);
        if (null != rateSetting) {
            RateSetting newRateSetting = new RateSetting();
            newRateSetting.setUserId(userId);
            newRateSetting.setStatus(RATE_SETTING_STATUS_PAUSE);
            rateSettingDAO.updateByUserId(newRateSetting);
        }
    }

    /**
     * 添加评论设置
     *
     * @param userId
     * @param comment
     */
    public void addRateCommentSetting(Long userId, String comment) {
        RateCommentSetting rateCommentSetting = new RateCommentSetting();
        rateCommentSetting.setUserId(userId);
        rateCommentSetting.setAddTime(appService.getLocalSystemTime().toDate());
        rateCommentSetting.setContent(comment);
        rateCommentSetting.setStatus(RATE_COMMENT_SETTING_STATUS_VALID);
        rateCommentSettingDAO.insertSelective(rateCommentSetting);
    }

    /**
     * 获取评论设置
     *
     * @param userId
     * @param rateCommentSettingId
     */
    public RateCommentSetting getRateCommentSetting(Long userId, Long rateCommentSettingId) {
        return rateCommentSettingDAO.selectByPrimaryKeyAndUserId(rateCommentSettingId, userId);
    }

    /**
     * 更新评论设置
     *
     * @param userId
     * @param comment
     */
    public void updateRateCommentSetting(Long userId, Long rateCommentSettingId, String comment) {
        RateCommentSetting rateCommentSetting = getRateCommentSetting(userId, rateCommentSettingId);
        if (null == rateCommentSetting) {
            return;
        }
        rateCommentSetting.setContent(comment);
        rateCommentSettingDAO.updateByPrimaryKeySelective(rateCommentSetting);
    }

    /**
     * 设置用户状态为过期
     *
     * @param userId
     */
    public void expireUser(Long userId) {
        RateSetting rateSetting = rateSettingDAO.selectByUserId(userId);
        if (null != rateSetting) {
            RateSetting newRateSetting = new RateSetting();
            newRateSetting.setUserId(userId);
            newRateSetting.setStatus(RATE_SETTING_STATUS_EXPIRED);
            rateSettingDAO.updateByUserId(newRateSetting);
        }
    }

    /**
     * 获取评论的内容
     */

    public List<String> getComments(Long userId) {
        List<String> commentContents = rateCommentSettingDAO.selectContentByUserIdAndStatus(userId,
                ImmutableList.of(RATE_COMMENT_SETTING_STATUS_VALID));

        if (CollectionUtils.isEmpty(commentContents)) {
            return DEFAULT_COMMENT_LIST;
        } else {
            return commentContents;
        }
    }

    /**
     * 获取评论的内容
     */

    public List<RateCommentSetting> getRateCommentSettings(Long userId) {
        List<RateCommentSetting> rateCommentSettings = rateCommentSettingDAO.selectByUserIdAndStatus(userId,
                ImmutableList.of(RATE_COMMENT_SETTING_STATUS_VALID));

        if (CollectionUtils.isEmpty(rateCommentSettings)) {
            return Lists.newArrayList();
        } else {
            return rateCommentSettings;
        }
    }

    /**
     * 查询黑名单买家
     *
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<BuyerBlacklist> paginateBuyerBlacklist(Long userId, int pageNum, int pageSize) {
        return baseClient.paginateBuyerBlacklist(userId, BaseConstants.BLACKLIST_TYPE_RATE, pageNum, pageSize, null, null);
    }

    /**
     * 一次性查询黑名单买家（最多查询1000个）
     *
     * @param userId
     * @return
     */
    public List<BuyerBlacklist> getBuyerBlacklist(Long userId) {
        return baseClient.paginateBuyerBlacklist(userId, BaseConstants.BLACKLIST_TYPE_RATE, 1, 1000, null, null);
    }

    /**
     * 添加黑名单用户
     *
     * @param userId
     * @param nick
     */
    public void addBlacklist(Long userId, String nick) {
        BuyerBlacklist buyerBlacklist = new BuyerBlacklist();
        buyerBlacklist.setUserId(userId);
        buyerBlacklist.setBuyerNick(nick);
        buyerBlacklist.setType(BaseConstants.BLACKLIST_TYPE_RATE);
        baseClient.addBuyerBlacklist(buyerBlacklist);
    }

    /**
     * 获取评论设置
     *
     * @param userId
     * @return
     */
    public RateSetting getRateSetting(Long userId) {
        return rateSettingDAO.selectByUserId(userId);
    }

    /**
     * 获取评论设置（包括过滤设置）
     *
     * @param userId
     * @return
     */
    public void updateRateSetting(final Long userId, RateSetting rateSetting) {
        //保存黑名单
        final List<String> blacklist = rateSetting.getBlacklistBuyerNicks();
        List<BuyerBlacklist> buyerBlacklists = Lists.transform(blacklist, new Function<String, BuyerBlacklist>() {
            @Nullable
            @Override
            public BuyerBlacklist apply(@Nullable String input) {
                BuyerBlacklist buyerBlacklist = new BuyerBlacklist();
                buyerBlacklist.setAddTime(appService.getLocalSystemTime().toDate());
                buyerBlacklist.setBuyerNick(input);
                buyerBlacklist.setUserId(userId);
                buyerBlacklist.setStatus(BaseConstants.BLACKLIST_STATUS_ENABLE);
                buyerBlacklist.setType(BaseConstants.BLACKLIST_TYPE_RATE);
                return buyerBlacklist;
            }
        });
        baseClient.addBuyerBlacklists(buyerBlacklists);
        //保存设置
        rateSetting.setUserId(userId);
        if (null == getRateSetting(userId)) {
            return;
        }
        rateSettingDAO.updateByUserId(rateSetting);
    }

    /**
     * 查询中差评论,按照评论时间降序排序
     *
     * @param userId
     * @param tid
     * @param buyerNick
     * @param startDate
     * @param endDate
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<RateOrder> paginateBuyerWaitingRate(Long userId, Long tid, String buyerNick,
                                                    Date startDate, Date endDate,
                                                    int pageNum, int pageSize) {
        List<String> rateTypes = ImmutableList.of("neutral", "bad");
        int count = rateOrderDAO.countBuyerRate(userId, tid, buyerNick, RATE_ORDER_STATUS_LIST_NOT_RATED, rateTypes, startDate, endDate,
                (pageNum - 1) * pageSize, pageSize);
        List<RateOrder> rateOrders = rateOrderDAO.paginateBuyerRate(userId, tid, buyerNick, RATE_ORDER_STATUS_LIST_NOT_RATED, rateTypes,
                startDate, endDate, (pageNum - 1) * pageSize, pageSize);
        return Page.create(count, pageNum, pageSize, rateOrders);
    }

    /**
     * 自动评论
     *
     * @param userId
     * @param oids
     * @return
     */
    public Map<Long, Boolean> autoRate(Long userId, List<Long> oids) throws TaobaoEnhancedApiException, TaobaoSessionExpiredException, TaobaoAccessControlException {
        //TODO 筛选没有评价的评论
        Map<Long, Boolean> resultMap = Maps.newHashMap();
        for (Long oid : oids) {
            boolean result = autoRate(userId, oid, null);
            resultMap.put(oid, result);
        }
        return resultMap;
    }

    public boolean autoRate(Long userId, Long oid, String comment) throws TaobaoEnhancedApiException, TaobaoSessionExpiredException, TaobaoAccessControlException {
        if (StringUtils.isEmpty(comment)) {
            List<String> comments = getComments(userId);
            comment = Collections3.getRandomElem(comments);
        }
        return rateService.rate(userId, oid, comment);
    }
}
