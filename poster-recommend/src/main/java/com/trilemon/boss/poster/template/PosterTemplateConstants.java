package com.trilemon.boss.poster.template;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.List;
import java.util.Map;

/**
 * @author kevin
 */
public interface PosterTemplateConstants {
    //preview_type
    byte PREVIEW_TYPE_PIC = 0;
    byte PREVIEW_TYPE_CODE = 1;
    String HTML_TAG_RECOMMEND = "trilemon-poster-recommend";
    //投放位置
    byte PUBLISH_POSITION_TOP = 1;
    byte PUBLISH_POSITION_BOTTOM = 2;
    //模板类型
    byte TEMPLATE_TYPE_ITEM_RECOMMEND = 1;
    //文案 key
    String COPY_KEY_ITEM_ORIGINAL_PRICE = "item_original_price";
    List<String> COPY_KEY_LIST= ImmutableList.of(COPY_KEY_ITEM_ORIGINAL_PRICE);

    //文案显示
    Map<String,String> COPY_KEY_MAP= ImmutableMap.of(COPY_KEY_ITEM_ORIGINAL_PRICE, "原价");
}
