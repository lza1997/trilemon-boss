package com.trilemon.boss.trade.notify.service;

import com.taobao.api.domain.TransitStepInfo;
import com.taobao.api.response.LogisticsTraceSearchResponse;
import com.trilemon.boss.trade.notify.TradeNotifyConstants;
import com.trilemon.boss.trade.notify.model.TradeNotifyLogistics;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Map;

/**
 * 物流提醒
 *
 * @author kevin
 */
public class TradeLogisticsNotifyService implements ITradeNotifyService {


    @Override
    public void sendSms(Long userId) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * 处理圆通快递
     *
     * @param rsp
     * @param logistics
     * @return
     * @throws Exception
     */
    public int getYuantongLogisticsStatus(LogisticsTraceSearchResponse rsp, TradeNotifyLogistics logistics) throws
            Exception {
        return getLogisticsStatus(rsp, logistics, true, "下车扫描", "派件", "签收");
    }

    public int getShentongLogisticsStatus(LogisticsTraceSearchResponse rsp, TradeNotifyLogistics logistics) throws
            Exception {
        return getLogisticsStatus(rsp, logistics, true, "派件", "快件已到达", "签收");
    }

    public int getYundaLogisticsStatus(LogisticsTraceSearchResponse rsp, TradeNotifyLogistics logistics) throws
            Exception {
        return getLogisticsStatus(rsp, logistics, true, "开始派送", "到达目的地网点", "签收");
    }

    public int getZhongtongLogisticsStatus(LogisticsTraceSearchResponse rsp, TradeNotifyLogistics logistics) throws
            Exception {
        //没有签收
        return getLogisticsStatus(rsp, logistics, false, "派件", "到达", "签收");
    }

    public int getQuanfengLogisticsStatus(LogisticsTraceSearchResponse rsp, TradeNotifyLogistics logistics) throws
            Exception {
        return getLogisticsStatus(rsp, logistics, true, "没有办法判断派件", "快件到达", "签收");
    }

    public int getHaihangtiantianLogisticsStatus(LogisticsTraceSearchResponse rsp, TradeNotifyLogistics logistics)
            throws Exception {
        //没有签收
        return getLogisticsStatus(rsp, logistics, false, "没有办法判断派件", "快件已到达", "签收");
    }

    public int getHuitongLogisticsStatus(LogisticsTraceSearchResponse rsp, TradeNotifyLogistics logistics) throws
            Exception {
        return getLogisticsStatus(rsp, logistics, true, "派件", "快件到达", "签收");
    }

    public int getEmsLogisticsStatus(LogisticsTraceSearchResponse rsp, TradeNotifyLogistics wat) throws Exception {
        //没有签收
        return getLogisticsStatus(rsp, wat, false, "没有办法判断派件", "妥投", "签收");
    }

    //judgeStateForArrived 因为有的快递的信息里面没有省份，所以要为一些快递预留一个排除省份验证的参数
    private int getLogisticsStatus(LogisticsTraceSearchResponse rsp, TradeNotifyLogistics logistics, boolean judgeStateForArrived,
                                   String sendingKey, String arriveKey, String endKey) throws Exception {
        List<TransitStepInfo> transitStepInfos = rsp.getTraceList();
        if (CollectionUtils.isEmpty(transitStepInfos)) {
            return TradeNotifyConstants.LOGISTICS_STATUS_NOT_ARRIVED;
        }
        //判断是否已经结束
        if (isEnd(transitStepInfos, endKey)) {
            return TradeNotifyConstants.LOGISTICS_STATUS_END;
        }
        if (isArrived(transitStepInfos, logistics, arriveKey, judgeStateForArrived)) {
            String sendingTime = getSendingTime(rsp, logistics, sendingKey);
            if (sendingTime != null) {
                if (judgeSendingTimeIsOut(sendingTime)) {
                    return TradeNotifyConstants.LOGISTICS_STATUS_END;
                }
            }
            return TradeNotifyConstants.LOGISTICS_STATUS_ARRIVED;
        }

        return TradeNotifyConstants.LOGISTICS_STATUS_NOT_ARRIVED;


    }

    /**
     * 判断一个快递是否已经签收了
     *
     * @param transitStepInfos
     * @param endKey           用来判断已经结束的关键字
     * @return
     */
    private boolean isEnd(List<TransitStepInfo> transitStepInfos, String endKey) {
        for (TransitStepInfo transitStepInfo : transitStepInfos) {
            if (StringUtils.isNotBlank(transitStepInfo.getStatusDesc())) {
                if (transitStepInfo.getStatusDesc().contains(endKey)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断快递是否已经结束（签收）
     *
     * @param rsp
     * @param endKey
     * @return
     */
    private Pair<Boolean, String> checkReceiveConfirm(LogisticsTraceSearchResponse rsp, String endKey) {
        boolean isEnd = false;
        String statusTime = null;
        for (TransitStepInfo transitStepInfo : rsp.getTraceList()) {
            if (StringUtils.isNotBlank(transitStepInfo.getStatusDesc())) {
                if (transitStepInfo.getStatusDesc().contains(endKey)) {
                    isEnd = true;
                    statusTime = transitStepInfo.getStatusTime();
                }
            }
        }
        return Pair.of(isEnd, statusTime);
    }

    private boolean isArrived(List<TransitStepInfo> transitStepInfos, TradeNotifyLogistics logistics,
                              String arrivedKey, boolean judgeState) {
        for (TransitStepInfo transitStepInfo : transitStepInfos) {
            if (StringUtils.isNotBlank(transitStepInfo.getStatusDesc())) {
                boolean stateOK = true;
                if (judgeState) {
                    if (!transitStepInfo.getStatusDesc().contains(filerStateAndCity(logistics.getReceiverState()))) {
                        stateOK = false;
                    }
                }
                if (stateOK && transitStepInfo.getStatusDesc().contains(filerStateAndCity(logistics.getReceiverCity()))) {
                    if (transitStepInfo.getStatusDesc().contains(arrivedKey)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 获取已经派件出去的时间，如果没有派件出去。那么就返回null
     *
     * @param rsp
     * @param logistics
     * @param sendingKey
     * @return
     */
    private String getSendingTime(LogisticsTraceSearchResponse rsp, TradeNotifyLogistics logistics,
                                  String sendingKey) {
        for (TransitStepInfo transitStepInfo : rsp.getTraceList()) {
            if (StringUtils.isNotBlank(transitStepInfo.getStatusDesc())) {
                if (transitStepInfo.getStatusDesc().contains(filerStateAndCity(logistics.getReceiverState()))) {
                    if (transitStepInfo.getStatusDesc().contains(filerStateAndCity(logistics.getReceiverCity()))) {
                        if (transitStepInfo.getStatusDesc().contains(sendingKey)) {
                            return transitStepInfo.getStatusTime();
                        }
                    }
                }
            }
        }
        return null;
    }

    private String filerStateAndCity(String s) {
        return s.replace("省", "").replace("市", "");
    }

    /**
     * 判断已经派件的时间是否超过约定的时间范围
     *
     * @param date
     * @return
     * @throws Exception
     */
    private boolean judgeSendingTimeIsOut(String date) throws Exception {
//        //如果已经超过派件出去的时间1个半小时。那么当做用户已经接收到了
//        Date compareDate = DateUtil.getDistanceDate(new Date(), -90, Calendar.MINUTE);
//        Date sendingTime = null;
//        try {
//            sendingTime = DateUtil.parseDateTime(date);
//        } catch (Exception e) {
//            sendingTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date);
//        }
//        if (compareDate.getTime() > sendingTime.getTime()) {
//            return true;
//        }
//        return false;
        return false;
    }

    /**
     * 判断是否买家已经签收，（不分快递 通用处理）
     *
     * @param rsp
     * @return 返回结构 两个key isEnd:boolean,statusTime:String
     */
    public Map<String, Object> checkReceiveConfirm(LogisticsTraceSearchResponse rsp) {
//        return checkReceiveConfirm(rsp, "签收");
        return null;
    }
}
