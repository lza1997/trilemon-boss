/*
 * Copyright (c) 2013 Raycloud.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.trilemon.top.boss360.shelf;

/**
 *
 * 开放平台工具类
 *
 * @author kevin
 */
public class TopApiUtils {
//    public final static ObjectMapper jsonMapper = new ObjectMapper();
//    private static Logger logger = LoggerFactory.getLogger(TopApiUtils.class);
//
//    /**
//     * 刷新session key
//     *
//     * @param appKey       app key
//     * @param appSecret    app secret
//     * @param refreshToken refresh token
//     * @param sessionKey   session key
//     * @return {@link TopParameters}
//     * @throws java.io.IOException 解析{@link TopParameters}过程发生错误。
//     */
//    public static TopParameters refreshSessionKey(String appKey, String appSecret, String refreshToken,
//                                                  String sessionKey) throws IOException {
//        Map<String, String> signParams = Maps.newTreeMap();
//        signParams.put("appkey", appKey);
//        signParams.put("refresh_token", refreshToken);
//        signParams.put("sessionkey", sessionKey);
//
//        StringBuilder params = new StringBuilder();
//        for (Map.Entry paramEntry : signParams.entrySet()) {
//            params.append(paramEntry.getKey()).append(paramEntry.getValue());
//        }
//        String sign = DigestUtils.md5Hex((params.toString() + appSecret).getBytes("utf-8")).toUpperCase();
//        String signEncoder = URLEncoder.encode(sign, "utf-8");
//        String appkeyEncoder = URLEncoder.encode(appKey, "utf-8");
//        String refreshTokenEncoder = URLEncoder.encode(refreshToken, "utf-8");
//        String sessionKeyEncoder = URLEncoder.encode(sessionKey, "utf-8");
//
//        String freshUrl = "http://container.api.taobao.com/container/refresh?appkey=" + appkeyEncoder
//                + "&refresh_token=" + refreshTokenEncoder + "&sessionkey=" + sessionKeyEncoder + "&sign="
//                + signEncoder;
//        String topParametersJson = WebUtils.doPost(freshUrl, null, "utf-8", 30 * 1000 * 60, 30 * 1000 * 60);
//
//        TopParameters topParameters = jsonMapper.readValue(topParametersJson, TopParameters.class);
//        return topParameters;
//    }
//
//    @Nullable
//    public static String getRefreshToken(String queryUrl) throws UnsupportedEncodingException {
//        return getTopSessionParameter(queryUrl).getRefreshToken();
//    }
//
//    public static TopSessionParameter getTopSessionParameter(String queryUrl) throws UnsupportedEncodingException {
//        Map<String, String> parameters = Maps.newHashMap();
//        for (String topParameter : queryUrl.split("&")) {
//            String[] kv = topParameter.split("=");
//            if (kv.length != 2) {
//                logger.warn("parameters[{}] length is not valid.", topParameter);
//            } else {
//                if (kv[0].equals("top_parameters")) {
//                    String topParameterValue = kv[1];
//                    String decodeTopParameterValue = new String(Base64.decodeBase64(URLDecoder
//                            .decode(topParameterValue, "GBK")), "GBK");
//                    for (String parameter : decodeTopParameterValue.split("&")) {
//                        String[] parameterKv = parameter.split("=");
//                        parameters.put(parameterKv[0], parameterKv[1]);
//                    }
//                } else {
//                    parameters.put(kv[0], kv[1]);
//                }
//            }
//        }
//        return BeanMapper.map(parameters, TopSessionParameter.class);
//    }
//
//    @Nullable
//    public static com.taobao.api.domain.Trade convertJson2TopTrade(String json) {
//        ObjectJsonParser<TradeFullinfoGetResponse> parser = new ObjectJsonParser(TradeFullinfoGetResponse.class);
//        try {
//            return parser.parse(json).getTrade();
//        } catch (Exception e) {
//            logger.error(json, e);
//            return null;
//        }
//    }
//
//    @Nullable
//    public static Trade convertTopTrade2SuperTrade(com.taobao.api.domain.Trade topTrade) {
//        if (null == topTrade) {
//            return null;
//        }
//        Trade trade;
//        try {
//            trade = BeanMapper.map(topTrade, Trade.class);
//        } catch (Throwable t) {
//            logger.error(ToStringBuilder.reflectionToString(topTrade), t);
//            return null;
//        }
//        Collection<Order> orders = trade.getOrders();
//        Collection<ServiceOrder> serviceOrders = trade.getServiceOrders();
//        Collection<PromotionDetail> promotionDetails = trade.getPromotionDetails();
//
//        if (null != orders) {
//            for (Order order : orders) {
//                order.setTradeId(trade.getId());
//                order.setTradeCreated(trade.getCreated());
//            }
//        }
//        if (null != serviceOrders) {
//            for (ServiceOrder serviceOrder : serviceOrders) {
//                serviceOrder.setTradeId(trade.getId());
//                serviceOrder.setTradeCreated(trade.getCreated());
//            }
//        }
//        if (null != promotionDetails) {
//            for (PromotionDetail promotionDetail : promotionDetails) {
//                promotionDetail.setTradeId(trade.getId());
//                promotionDetail.setTradeCreated(trade.getCreated());
//            }
//        }
//        return trade;
//    }
//
//    @Nullable
//    public static List<Trade> batchConvertTopTrade2SuperTrade(List<com.taobao.api.domain.Trade> topTrades) {
//        List<Trade> trades = Lists.newArrayList();
//        for (com.taobao.api.domain.Trade topTrade : topTrades) {
//            Trade trade = convertTopTrade2SuperTrade(topTrade);
//            if (null == trade) {
//                return null;
//            }
//            trades.add(convertTopTrade2SuperTrade(topTrade));
//        }
//        return null;
//    }
//
//    @Nullable
//    public static User convertTopUser2SuperUser(com.taobao.api.domain.User topUser) {
//        if (null == topUser) {
//            return null;
//        }
//        try {
//            return BeanMapper.map(topUser, User.class);
//        } catch (Throwable t) {
//            logger.error(ToStringBuilder.reflectionToString(topUser), t);
//            return null;
//        }
//    }
//
//    @Nullable
//    public static Shop convertTopShop2SuperShop(com.taobao.api.domain.Shop topShop) {
//        if (null == topShop) {
//            return null;
//        }
//        try {
//            return BeanMapper.map(topShop, Shop.class);
//        } catch (Throwable t) {
//            logger.error(ToStringBuilder.reflectionToString(topShop), t);
//            return null;
//        }
//    }
//
//    public static Refund convertTopRefund2SuperRefund(com.taobao.api.domain.Refund topRefund) {
//        if (null == topRefund) {
//            return null;
//        }
//        try {
//            return BeanMapper.map(topRefund, Refund.class);
//        } catch (Throwable t) {
//            logger.error(ToStringBuilder.reflectionToString(topRefund), t);
//            return null;
//        }
//    }
}
