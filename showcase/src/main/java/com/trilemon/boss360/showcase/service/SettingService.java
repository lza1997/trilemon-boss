package com.trilemon.boss360.showcase.service;

import com.taobao.api.domain.Item;
import com.trilemon.boss360.showcase.ShowcaseException;
import com.trilemon.boss360.showcase.model.Setting;
import com.trilemon.commons.web.Page;

/**
 * @author kevin
 */
public class SettingService {

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
}
