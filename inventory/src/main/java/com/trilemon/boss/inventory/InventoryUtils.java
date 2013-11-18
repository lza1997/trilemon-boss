package com.trilemon.boss.inventory;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.taobao.api.domain.Item;
import com.trilemon.boss.inventory.model.InventoryListItem;
import com.trilemon.boss.inventory.model.InventoryListSetting;
import com.trilemon.boss.inventory.model.dto.InventoryItem;
import com.trilemon.commons.Languages;
import com.trilemon.commons.LocalTimeInterval;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.joda.time.DateTime;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;

import static com.trilemon.boss.inventory.InventoryConstants.LIST_STATUS_WAITING_ADJUST;

/**
 * @author kevin
 */
public class InventoryUtils {
    public static List<Long> getInventoryListItemNumIids(List<InventoryListItem> listItems) {
        return Lists.transform(listItems, new Function<InventoryListItem, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable InventoryListItem input) {
                return input.getItemNumIid();
            }
        });
    }

    public static List<InventoryListItem> getInventoryListItem(List<InventoryListItem> inventoryListItems,
                                                               Set<Long> numIids) {
        List<InventoryListItem> filerListItems = Lists.newArrayList();
        for (InventoryListItem listItem : inventoryListItems) {
            if (numIids.contains(listItem.getItemNumIid())) {
                filerListItems.add(listItem);
            }
        }
        return filerListItems;
    }

    public static InventoryListItem buildListItem(InventoryListSetting setting, InventoryItem inventoryItem,
                                                  DateTime planListingDay,
                                                  LocalTimeInterval hourInterval) throws
            InventoryException {
        InventoryListItem plan = new InventoryListItem();
        Item item = inventoryItem.getItem();
        plan.setInventoryListSettingId(setting.getId());
        plan.setUserId(setting.getUserId());
        plan.setPlanAdjustDay(planListingDay.toDate());
        plan.setPlanAdjustStartTime(hourInterval.getFrom().toDateTimeToday().toDate());
        plan.setPlanAdjustEndTime(hourInterval.getTo().toDateTimeToday().toDate());
        plan.setItemNumIid(item.getNumIid());
        plan.setItemTitle(item.getTitle());
        plan.setItemPicUrl(item.getPicUrl());
        plan.setStatus(LIST_STATUS_WAITING_ADJUST);
        plan.setBanner(inventoryItem.getBanner());
        try {
            plan.setItemTitlePinyin(Languages.getHanYuPinyin(item.getTitle()));
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            throw new InventoryException("get pinyin of itemTitle[" + item.getTitle() + "] itemIid[" + item.getNumIid()
                    + "] error", e);
        }
        return plan;
    }

    public static List<Long> getInventoryItemNumIids(List<InventoryItem> inventoryItems) {
        return Lists.transform(inventoryItems, new Function<InventoryItem, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable InventoryItem input) {
                return input.getItem().getNumIid();
            }
        });
    }

    public static List<InventoryItem> getInventoryItems(List<InventoryItem> inventoryItems, List<Long> numIids) {
        List<InventoryItem> filerInventoryItems = Lists.newArrayList();

        for (InventoryItem InventoryItem : inventoryItems) {
            if (numIids.contains(InventoryItem.getItem().getNumIid())) {
                filerInventoryItems.add(InventoryItem);
            }
        }
        return filerInventoryItems;
    }

    public static List<InventoryItem> getInventoryItems(List<Item> items) {
        return Lists.transform(items, new Function<Item, InventoryItem>() {
            @Nullable
            @Override
            public InventoryItem apply(@Nullable Item input) {
                InventoryItem inventoryItem = new InventoryItem();
                inventoryItem.setItem(input);
                return inventoryItem;
            }
        });
    }

    public static List<Item> getItems(List<InventoryItem> inventoryItems) {
        return Lists.transform(inventoryItems, new Function<InventoryItem, Item>() {
            @Nullable
            @Override
            public Item apply(@Nullable InventoryItem input) {
                return input.getItem();
            }
        });
    }
}
