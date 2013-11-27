package com.trilemon.boss.infra.sync.rate;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * @author kevin
 */
public interface RateSyncConstants {
    //rate sync status
    byte RATE_SYNC_STATUS_INIT = 0;
    byte RATE_SYNC_STATUS_SUCCESSFUL = 1;
    byte RATE_SYNC_STATUS_FAILED = 2;
    byte RATE_SYNC_STATUS_DOING = 3;
    ////rate sync status
    byte RATE_CALC_SELLER_DAY_RATE_STATUS_INIT = 0;
    byte RATE_CALC_SELLER_DAY_RATE_STATUS_SUCCESSFUL = 1;
    byte RATE_CALC_SELLER_DAY_RATE_STATUS_FAILED = 2;
    byte RATE_CALC_SELLER_DAY_RATE_STATUS_DOING = 3;
    //rate field
    List<String> RATE_FIELDS = ImmutableList.of("num_iid", "valid_score", "tid", "oid", "role", "nick", "result", "created",
            "rated_nick", "item_title", "item_price", "content", "reply");
    List<String> RATE_TYPES = ImmutableList.of("good", "neutral", "bad");

}
