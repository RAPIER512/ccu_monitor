package com.courage.ccu_monitor.model;

public class KeywordStatistic {
    private Integer id;

    private String keyword;

    private Integer dayNum;

    private Integer weekNum;

    private Integer monthNum;

    private Integer type;

    private Integer hontNum;

    private Integer status;

    private String createTime;

    public KeywordStatistic(){
    	
    }
    
    public KeywordStatistic(String keyword,int dayNum,int hontNum,String createTime){
    	this.keyword = keyword;
    	this.dayNum = dayNum;
    	this.createTime = createTime;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Integer getDayNum() {
        return dayNum;
    }

    public void setDayNum(Integer dayNum) {
        this.dayNum = dayNum;
    }

    public Integer getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(Integer weekNum) {
        this.weekNum = weekNum;
    }

    public Integer getMonthNum() {
        return monthNum;
    }

    public void setMonthNum(Integer monthNum) {
        this.monthNum = monthNum;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getHontNum() {
        return hontNum;
    }

    public void setHontNum(Integer hontNum) {
        this.hontNum = hontNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}