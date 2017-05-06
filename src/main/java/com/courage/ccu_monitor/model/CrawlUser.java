package com.courage.ccu_monitor.model;

import java.util.Date;

public class CrawlUser {
    private Integer id;

    private String userId;

    private String userName;

    private String userSex;

    private String nameU;

    private String portrait;

    private String publishTestNum;

    private String tiebaAge;

    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getNameU() {
        return nameU;
    }

    public void setNameU(String nameU) {
        this.nameU = nameU == null ? null : nameU.trim();
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait == null ? null : portrait.trim();
    }

    public String getPublishTestNum() {
        return publishTestNum;
    }

    public void setPublishTestNum(String publishTestNum) {
        this.publishTestNum = publishTestNum == null ? null : publishTestNum.trim();
    }

    public String getTiebaAge() {
        return tiebaAge;
    }

    public void setTiebaAge(String tiebaAge) {
        this.tiebaAge = tiebaAge == null ? null : tiebaAge.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}