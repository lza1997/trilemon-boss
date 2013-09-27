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

import java.util.Date;

public class TopSessionParameter {
    private String sessionKey;
    private String sign;
    private Date ts;
    private Byte iframe;
    private Long visitorId;
    private String visitorNick;
    private Integer expiresIn;
    private String refreshToken;
    private Integer reExpiresIn;
    private Long subVisitorId;
    private String subTaobaoUserNick;
    private Integer r1ExpiresIn;
    private Integer w1ExpiresIn;
    private Integer r2ExpiresIn;
    private Integer w2ExpiresIn;

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey == null ? null : sessionKey.trim();
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public Byte getIframe() {
        return iframe;
    }

    public void setIframe(Byte iframe) {
        this.iframe = iframe;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public String getVisitorNick() {
        return visitorNick;
    }

    public void setVisitorNick(String visitorNick) {
        this.visitorNick = visitorNick == null ? null : visitorNick.trim();
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken == null ? null : refreshToken.trim();
    }

    public Long getSubVisitorId() {
        return subVisitorId;
    }

    public void setSubVisitorId(Long subVisitorId) {
        this.subVisitorId = subVisitorId;
    }

    public String getSubTaobaoUserNick() {
        return subTaobaoUserNick;
    }

    public void setSubTaobaoUserNick(String subTaobaoUserNick) {
        this.subTaobaoUserNick = subTaobaoUserNick == null ? null : subTaobaoUserNick.trim();
    }

    public Integer getR1ExpiresIn() {
        return r1ExpiresIn;
    }

    public void setR1ExpiresIn(Integer r1ExpiresIn) {
        this.r1ExpiresIn = r1ExpiresIn;
    }

    public Integer getW1ExpiresIn() {
        return w1ExpiresIn;
    }

    public void setW1ExpiresIn(Integer w1ExpiresIn) {
        this.w1ExpiresIn = w1ExpiresIn;
    }

    public Integer getR2ExpiresIn() {
        return r2ExpiresIn;
    }

    public void setR2ExpiresIn(Integer r2ExpiresIn) {
        this.r2ExpiresIn = r2ExpiresIn;
    }

    public Integer getW2ExpiresIn() {
        return w2ExpiresIn;
    }

    public void setW2ExpiresIn(Integer w2ExpiresIn) {
        this.w2ExpiresIn = w2ExpiresIn;
    }

    public Integer getReExpiresIn() {
        return reExpiresIn;
    }

    public void setReExpiresIn(Integer reExpiresIn) {
        this.reExpiresIn = reExpiresIn;
    }
}