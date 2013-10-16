package com.trilemon.boss360.shelf;

/**
 * @author kevin
 */
public interface ShelfConstants {
    //interval
    byte PLAN_SETTING_DISTRIBUTE_TYPE_AUTO = 0;
    byte PLAN_SETTING_DISTRIBUTE_TYPE_MANUAL = 1;
    //status
    byte PLAN_SETTING_STATUS_WAITING_PLAN = 0;
    byte PLAN_SETTING_STATUS_RUNNING = 1;
    byte PLAN_SETTING_STATUS_PAUSE = 2;
    byte PLAN_SETTING_STATUS_DELETE = 3;
    //plan status
    byte PLAN_STATUS_WAITING_ADJUST = 0;
    byte PLAN_STATUS_SUCCESSFUL = 1;
    byte PLAN_STATUS_FAILED = 2;
}
