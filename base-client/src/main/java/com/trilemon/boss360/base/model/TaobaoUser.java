package com.trilemon.boss360.base.model;

import java.util.Date;

public class TaobaoUser {
    private Long id;

    private Long userId;

    private String uid;

    private String nick;

    private String sex;

    private Byte buyerCreditLevel;

    private Integer buyerCreditScore;

    private Integer buyerCreditTotalNum;

    private Integer buyerCreditGoodNum;

    private Byte sellerCreditLevel;

    private Integer sellerCreditScore;

    private Integer sellerCreditTotalNum;

    private Integer sellerCreditGoodNum;

    private String locationCountry;

    private String locationState;

    private String locationCity;

    private String locationDistrict;

    private String locationAddress;

    private String locationZip;

    private Date created;

    private Date lastVisit;

    private Date birthday;

    private String type;

    private Boolean hasMorePic;

    private Integer itemImgNum;

    private Integer itemImgSize;

    private Integer propImgNum;

    private Integer propImgSize;

    private String autoRepost;

    private String promotedType;

    private String status;

    private String alipayBind;

    private Boolean consumerProtection;

    private String avatar;

    private Boolean liangpin;

    private Boolean signFoodSellerPromise;

    private Boolean hasShop;

    private Boolean isLightningConsignment;

    private Boolean hasSubStock;

    private Boolean isGoldenSeller;

    private String vipInfo;

    private String email;

    private Boolean magazineSubscribe;

    private String verticalMarket;

    private Boolean onlineGaming;

    private String alipayId;

    private Date addTime;

    private Date updTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Byte getBuyerCreditLevel() {
        return buyerCreditLevel;
    }

    public void setBuyerCreditLevel(Byte buyerCreditLevel) {
        this.buyerCreditLevel = buyerCreditLevel;
    }

    public Integer getBuyerCreditScore() {
        return buyerCreditScore;
    }

    public void setBuyerCreditScore(Integer buyerCreditScore) {
        this.buyerCreditScore = buyerCreditScore;
    }

    public Integer getBuyerCreditTotalNum() {
        return buyerCreditTotalNum;
    }

    public void setBuyerCreditTotalNum(Integer buyerCreditTotalNum) {
        this.buyerCreditTotalNum = buyerCreditTotalNum;
    }

    public Integer getBuyerCreditGoodNum() {
        return buyerCreditGoodNum;
    }

    public void setBuyerCreditGoodNum(Integer buyerCreditGoodNum) {
        this.buyerCreditGoodNum = buyerCreditGoodNum;
    }

    public Byte getSellerCreditLevel() {
        return sellerCreditLevel;
    }

    public void setSellerCreditLevel(Byte sellerCreditLevel) {
        this.sellerCreditLevel = sellerCreditLevel;
    }

    public Integer getSellerCreditScore() {
        return sellerCreditScore;
    }

    public void setSellerCreditScore(Integer sellerCreditScore) {
        this.sellerCreditScore = sellerCreditScore;
    }

    public Integer getSellerCreditTotalNum() {
        return sellerCreditTotalNum;
    }

    public void setSellerCreditTotalNum(Integer sellerCreditTotalNum) {
        this.sellerCreditTotalNum = sellerCreditTotalNum;
    }

    public Integer getSellerCreditGoodNum() {
        return sellerCreditGoodNum;
    }

    public void setSellerCreditGoodNum(Integer sellerCreditGoodNum) {
        this.sellerCreditGoodNum = sellerCreditGoodNum;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry == null ? null : locationCountry.trim();
    }

    public String getLocationState() {
        return locationState;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState == null ? null : locationState.trim();
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity == null ? null : locationCity.trim();
    }

    public String getLocationDistrict() {
        return locationDistrict;
    }

    public void setLocationDistrict(String locationDistrict) {
        this.locationDistrict = locationDistrict == null ? null : locationDistrict.trim();
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress == null ? null : locationAddress.trim();
    }

    public String getLocationZip() {
        return locationZip;
    }

    public void setLocationZip(String locationZip) {
        this.locationZip = locationZip == null ? null : locationZip.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Boolean getHasMorePic() {
        return hasMorePic;
    }

    public void setHasMorePic(Boolean hasMorePic) {
        this.hasMorePic = hasMorePic;
    }

    public Integer getItemImgNum() {
        return itemImgNum;
    }

    public void setItemImgNum(Integer itemImgNum) {
        this.itemImgNum = itemImgNum;
    }

    public Integer getItemImgSize() {
        return itemImgSize;
    }

    public void setItemImgSize(Integer itemImgSize) {
        this.itemImgSize = itemImgSize;
    }

    public Integer getPropImgNum() {
        return propImgNum;
    }

    public void setPropImgNum(Integer propImgNum) {
        this.propImgNum = propImgNum;
    }

    public Integer getPropImgSize() {
        return propImgSize;
    }

    public void setPropImgSize(Integer propImgSize) {
        this.propImgSize = propImgSize;
    }

    public String getAutoRepost() {
        return autoRepost;
    }

    public void setAutoRepost(String autoRepost) {
        this.autoRepost = autoRepost == null ? null : autoRepost.trim();
    }

    public String getPromotedType() {
        return promotedType;
    }

    public void setPromotedType(String promotedType) {
        this.promotedType = promotedType == null ? null : promotedType.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getAlipayBind() {
        return alipayBind;
    }

    public void setAlipayBind(String alipayBind) {
        this.alipayBind = alipayBind == null ? null : alipayBind.trim();
    }

    public Boolean getConsumerProtection() {
        return consumerProtection;
    }

    public void setConsumerProtection(Boolean consumerProtection) {
        this.consumerProtection = consumerProtection;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Boolean getLiangpin() {
        return liangpin;
    }

    public void setLiangpin(Boolean liangpin) {
        this.liangpin = liangpin;
    }

    public Boolean getSignFoodSellerPromise() {
        return signFoodSellerPromise;
    }

    public void setSignFoodSellerPromise(Boolean signFoodSellerPromise) {
        this.signFoodSellerPromise = signFoodSellerPromise;
    }

    public Boolean getHasShop() {
        return hasShop;
    }

    public void setHasShop(Boolean hasShop) {
        this.hasShop = hasShop;
    }

    public Boolean getIsLightningConsignment() {
        return isLightningConsignment;
    }

    public void setIsLightningConsignment(Boolean isLightningConsignment) {
        this.isLightningConsignment = isLightningConsignment;
    }

    public Boolean getHasSubStock() {
        return hasSubStock;
    }

    public void setHasSubStock(Boolean hasSubStock) {
        this.hasSubStock = hasSubStock;
    }

    public Boolean getIsGoldenSeller() {
        return isGoldenSeller;
    }

    public void setIsGoldenSeller(Boolean isGoldenSeller) {
        this.isGoldenSeller = isGoldenSeller;
    }

    public String getVipInfo() {
        return vipInfo;
    }

    public void setVipInfo(String vipInfo) {
        this.vipInfo = vipInfo == null ? null : vipInfo.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Boolean getMagazineSubscribe() {
        return magazineSubscribe;
    }

    public void setMagazineSubscribe(Boolean magazineSubscribe) {
        this.magazineSubscribe = magazineSubscribe;
    }

    public String getVerticalMarket() {
        return verticalMarket;
    }

    public void setVerticalMarket(String verticalMarket) {
        this.verticalMarket = verticalMarket == null ? null : verticalMarket.trim();
    }

    public Boolean getOnlineGaming() {
        return onlineGaming;
    }

    public void setOnlineGaming(Boolean onlineGaming) {
        this.onlineGaming = onlineGaming;
    }

    public String getAlipayId() {
        return alipayId;
    }

    public void setAlipayId(String alipayId) {
        this.alipayId = alipayId == null ? null : alipayId.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }
}