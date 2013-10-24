package com.trilemon.boss360.center.web.auth.shiro;

import java.util.Objects;

/**
 * @author kevin
 */
public class ShiroTaobaoUser {
    private static final long serialVersionUID = -1373760761780840081L;
    public Long taobaoUserId;
    public String taobaoUserNick;

    public ShiroTaobaoUser(Long taobaoUserId, String taobaoUserNick) {
        this.taobaoUserId = taobaoUserId;
        this.taobaoUserNick = taobaoUserNick;
    }

    public ShiroTaobaoUser() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getTaobaoUserId() {
        return taobaoUserId;
    }

    public void setTaobaoUserId(Long taobaoUserId) {
        this.taobaoUserId = taobaoUserId;
    }

    public String getTaobaoUserNick() {
        return taobaoUserNick;
    }

    public void setTaobaoUserNick(String taobaoUserNick) {
        this.taobaoUserNick = taobaoUserNick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShiroTaobaoUser that = (ShiroTaobaoUser) o;

        if (!taobaoUserId.equals(that.taobaoUserId)) return false;
        if (!taobaoUserNick.equals(that.taobaoUserNick)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(taobaoUserId + taobaoUserNick);
    }
}
