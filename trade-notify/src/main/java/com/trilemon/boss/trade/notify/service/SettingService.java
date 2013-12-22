package com.trilemon.boss.trade.notify.service;

import java.util.Map;

/**
 * 界面设定
 * @author kevin
 */
public class SettingService {
    /**
     * 开启发货通知
     */
    public boolean enableDeliverNotify(Long userId) {
        return false;
    }

    /**
     * 开启延迟发货通知
     */
    public boolean enableDelayDeliverNotify(Long userId) {
        return false;
    }

    /**
     * 开启到达通知
     */
    public boolean enableArriveNotify(Long userId) {
        return false;
    }

    /**
     * 开启确认收货通知
     */
    public boolean enableReceiveNotify(Long userId) {
        return false;
    }

    /**
     * 开启付款通知
     */
    public boolean enablePayNotify(Long userId) {
        return false;
    }

    /**
     * 开启退款通知
     */
    public boolean enableRefundNotify(Long userId) {
        return false;
    }

    /**
     * 关闭发货通知
     */
    public boolean disableDeliverNotify(Long userId) {
        return false;
    }

    /**
     * 关闭延迟发货通知
     */
    public boolean disableDelayDeliverNotify(Long userId) {
        return false;
    }

    /**
     * 关闭到达通知
     */
    public boolean disableArriveNotify(Long userId) {
        return false;
    }

    /**
     * 关闭确认收货通知
     */
    public boolean disableReceiveNotify(Long userId) {
        return false;
    }

    /**
     * 关闭付款通知
     */
    public boolean disablePayNotify(Long userId) {
        return false;
    }

    /**
     * 关闭退款通知
     */
    public boolean disableRefundNotify(Long userId) {
        return false;
    }

    /**
     * 付款 n 小时后未发货再发信息
     *
     * @param hour
     */
    public void setDelayDeliverNotifyAfterHour(Long userId, int hour) {

    }

    /**
     * @param day
     */
    public void setReceiveNotifyAfterDay(Long userId, int day) {

    }

    /**
     * 超过多少小时未付款发送付款通知
     *
     * @param day
     */
    public void setPayNotifyAfterHour(Long userId, int day) {

    }

    /**
     * 设置选中的模板
     *
     * @param userId
     * @param templateId
     * @param templateType
     */
    public void setUsingTemplate(Long userId, Long templateId, byte templateType) {

    }

    /**
     * 获取模板
     *
     * @param userId
     * @param templateType
     */
    public void getTemplates(Long userId, byte templateType) {

    }

    /**
     * 获取模板
     *
     * @param userId
     * @param templateId
     */
    public void getTemplate(Long userId, Long templateId) {

    }

    /**
     * 更新模板
     *
     * @param userId
     * @param templateId
     * @param template
     */
    public void updateTemplate(Long userId, Long templateId, String template) {

    }

    /**
     * 删除模板
     *
     * @param userId
     * @param templateId
     */
    public void deleteTemplate(Long userId, Long templateId) {

    }

    /**
     * 短信发送统计
     *
     * @param smsType
     * @return
     */
    public Map<String, Integer> getSmsSendStatus(byte smsType) {
        return null;
    }
}
