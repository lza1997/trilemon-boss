package com.trilemon.boss360.showcase.service;

import com.taobao.api.domain.Item;
import com.trilemon.boss360.infrastructure.base.service.api.TaobaoApiShopService;
import com.trilemon.boss360.showcase.ShowcaseException;
import com.trilemon.boss360.showcase.model.Setting;
import com.trilemon.commons.web.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kevin
 */
@Service
public class SettingService {
    private final static Logger logger = LoggerFactory.getLogger(SettingService.class);
    @Autowired
    private TaobaoApiShopService taobaoApiShopService;

    public void createSetting(Long userId, Setting setting) throws ShowcaseException {

    }

    public void updateSetting(Long userId, Setting setting) throws ShowcaseException {

    }

    public Setting getSetting(Long userId) throws ShowcaseException {
        return null;
    }

    public boolean includeItem(Long numIid) {
        return false;
    }

    public boolean excludeItem(Long numIid) {
        return false;
    }

    public Page<Item> paginateShowcaseItems(Long numIid, int pageNum, int pageSize) {
        return null;
    }

    public void adjust(Setting setting) throws ShowcaseException {
//        ItemsOnsaleGetRequest request = new ItemsOnsaleGetRequest();
//        request.setFields(Joiner.on(",").join(ShowcaseConstants.ITEM_FIELDS));
//        try {
//            Pair<java.util.List<Item>, Long> onSaleItems = taobaoApiShopService.getOnSaleItems(setting.getUserId(), request);
//        } catch (EnhancedApiException e) {
//            ShowcaseException showcaseException = new ShowcaseException("get on sale item error, " +
//                    "setting[" + ToStringBuilder.reflectionToString(setting) + "].", e);
//            Exceptions.logAndThrow(logger, showcaseException);
//        }
    }
}
