package com.trilemon.boss.infra.sync.rate;

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
}
