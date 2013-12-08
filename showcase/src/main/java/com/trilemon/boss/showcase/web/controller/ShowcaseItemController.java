package com.trilemon.boss.showcase.web.controller;

import com.taobao.api.domain.Item;
import com.trilemon.boss.infra.base.service.SessionService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.showcase.ShowcaseException;
import com.trilemon.boss.showcase.service.SettingService;
import com.trilemon.commons.web.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author edokeh
 */
@Controller
@RequestMapping("/showcase-items")
public class ShowcaseItemController {
    @Autowired
    private SettingService settingService;
    @Autowired
    private SessionService sessionService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Page<Item> index(String key, @RequestParam(defaultValue = "1") Integer page) throws
            ShowcaseException,
            TaobaoSessionExpiredException,
            TaobaoEnhancedApiException, TaobaoAccessControlException {
        return settingService.paginateShowcaseItems(sessionService.getUserId(), key, null, page, 2, false, null);
    }
}
