package com.flyer.springboot.rest.web.req;

/**
 * Created by jianying.li on 2018/9/16.
 */
public class SaveOrUpdateUser {

    /**
     *
     */
    private Long id;
    /**
     *
     */
    private java.util.Date addTime;
    /**
     *
     */
    private String openId;
    /**
     *
     */
    private String unionId;
    /**
     *
     */
    private String cellphone;
    /**
     *
     */
    private String wechat;
    /**
     *
     */
    private String nickName;
    /**
     *
     */
    private String country;
    /**
     *
     */
    private String language;
    /**
     *
     */
    private String province;
    /**
     *
     */
    private String city;
    /**
     *
     */
    private Integer sex;
    /**
     *
     */
    private String headImgUrl;
    /**
     *
     */
    private String remark;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAddTime(java.util.Date addTime) {
        this.addTime = addTime;
    }

    public java.util.Date getAddTime() {
        return addTime;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getWechat() {
        return wechat;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getSex() {
        return sex;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }
}
