package com.trilemon.boss.rate.web.controller;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.trilemon.boss.infra.base.model.BuyerBlacklist;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.infra.sync.rate.service.RateSyncException;
import com.trilemon.boss.rate.model.RateCommentSetting;
import com.trilemon.boss.rate.model.RateOrder;
import com.trilemon.boss.rate.model.RateSetting;
import com.trilemon.boss.rate.service.RateService;
import com.trilemon.boss.rate.service.RateSettingService;
import com.trilemon.commons.Collections3;
import com.trilemon.commons.web.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Nullable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author kevin
 */
@Controller
@RequestMapping("/test2")
public class RateTestController {
    @Autowired
    private RateService rateService;
    @Autowired
    private RateSettingService rateSettingService;

    @ResponseBody
    @RequestMapping(value = "/createRateSetting", method = RequestMethod.GET)
    public String createRateSetting(@RequestParam Long userId) throws TaobaoEnhancedApiException, TaobaoSessionExpiredException,
            TaobaoAccessControlException, RateSyncException {
        rateSettingService.createRateSetting(userId);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/resumeRateSetting", method = RequestMethod.GET)
    public String resumeRateSetting(@RequestParam Long userId) throws TaobaoEnhancedApiException, TaobaoSessionExpiredException,
            TaobaoAccessControlException, RateSyncException {
        rateSettingService.resumeRateSetting(userId);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/pauseRateSetting", method = RequestMethod.GET)
    public String pauseRateSetting(@RequestParam Long userId) throws TaobaoEnhancedApiException, TaobaoSessionExpiredException,
            TaobaoAccessControlException, RateSyncException {
        rateSettingService.pauseRateSetting(userId);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/addRateCommentSetting", method = RequestMethod.GET)
    public long addRateCommentSetting(@RequestParam Long userId, @RequestParam String comment) throws
            TaobaoEnhancedApiException,
            TaobaoSessionExpiredException,
            TaobaoAccessControlException, RateSyncException {
        return rateSettingService.addRateCommentSetting(userId, comment);
    }

    @ResponseBody
    @RequestMapping(value = "/getRateCommentSetting", method = RequestMethod.GET)
    public RateCommentSetting getRateCommentSetting(@RequestParam Long userId, @RequestParam Long rateCommentSettingId) throws
            TaobaoEnhancedApiException,
            TaobaoSessionExpiredException,
            TaobaoAccessControlException, RateSyncException {
        return rateSettingService.getRateCommentSetting(userId, rateCommentSettingId);
    }

    @ResponseBody
    @RequestMapping(value = "/updateRateCommentSetting", method = RequestMethod.GET)
    public void updateRateCommentSetting(@RequestParam Long userId,
                                         @RequestParam Long rateCommentSettingId, @RequestParam String comment) throws
            TaobaoEnhancedApiException,
            TaobaoSessionExpiredException,
            TaobaoAccessControlException, RateSyncException {
        rateSettingService.updateRateCommentSetting(userId, rateCommentSettingId, comment);
    }

    @ResponseBody
    @RequestMapping(value = "/expireUser", method = RequestMethod.GET)
    public void expireUser(@RequestParam Long userId) throws
            TaobaoEnhancedApiException,
            TaobaoSessionExpiredException,
            TaobaoAccessControlException, RateSyncException {
        rateSettingService.expireUser(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/getComments", method = RequestMethod.GET)
    public List<String> getComments(@RequestParam Long userId) throws
            TaobaoEnhancedApiException,
            TaobaoSessionExpiredException,
            TaobaoAccessControlException, RateSyncException {
        return rateSettingService.getComments(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/getBuyerBlacklist", method = RequestMethod.GET)
    public List<BuyerBlacklist> getBuyerBlacklist(@RequestParam Long userId) throws
            TaobaoEnhancedApiException,
            TaobaoSessionExpiredException,
            TaobaoAccessControlException, RateSyncException {
        return rateSettingService.getBuyerBlacklist(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/addBlacklist", method = RequestMethod.GET)
    public void addBlacklist(@RequestParam Long userId, @RequestParam String nick) throws
            TaobaoEnhancedApiException,
            TaobaoSessionExpiredException,
            TaobaoAccessControlException, RateSyncException {
        rateSettingService.addBlacklist(userId, nick);
    }

    @ResponseBody
    @RequestMapping(value = "/getRateSetting", method = RequestMethod.GET)
    public RateSetting getRateSetting(@RequestParam Long userId) throws
            TaobaoEnhancedApiException,
            TaobaoSessionExpiredException,
            TaobaoAccessControlException, RateSyncException {
        return rateSettingService.getRateSetting(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/paginateBuyerRate", method = RequestMethod.GET)
    public Page<RateOrder> paginateBuyerRate(@RequestParam Long userId, @RequestParam(required = false) Long tid,
                                             @RequestParam(required = false) String buyerNick, @RequestParam(required = false) Date startDate,
                                             @RequestParam(required = false) Date endDate, @RequestParam int pageNum) throws
            TaobaoEnhancedApiException,
            TaobaoSessionExpiredException,
            TaobaoAccessControlException, RateSyncException {
        return rateSettingService.paginateBuyerWaitingRate(userId, tid, buyerNick, startDate, endDate, pageNum, 1);
    }

    @ResponseBody
    @RequestMapping(value = "/autoRate", method = RequestMethod.GET)
    public Map<Long, Boolean> autoRate(@RequestParam Long userId, @RequestParam String tids) throws
            TaobaoEnhancedApiException,
            TaobaoSessionExpiredException,
            TaobaoAccessControlException, RateSyncException {
        List<String> tidStrList = Collections3.COMMA_SPLITTER.splitToList(tids);
        List<Long> tidList = Lists.transform(tidStrList, new Function<String, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable String input) {
                return Long.valueOf(input);
            }
        });
        return rateSettingService.autoRate(userId, tidList);
    }

    @ResponseBody
    @RequestMapping(value = "/rateJob", method = RequestMethod.GET)
    public void rateJob(@RequestParam Long userId) throws
            TaobaoEnhancedApiException,
            TaobaoSessionExpiredException,
            TaobaoAccessControlException, RateSyncException {
        rateService.rate(userId);
    }
}
