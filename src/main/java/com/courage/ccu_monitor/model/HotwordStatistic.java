package com.courage.ccu_monitor.model;

public class HotwordStatistic {
    private Integer id;

    private String hotWord;

    private Integer dayNum;

    private Integer weekNum;

    private Integer monNum;

    private Integer hontNum;

    private Integer status;

    private String createTime;

    public HotwordStatistic(){
    	
    }
    
    public HotwordStatistic(String keyword,int dayNum,int hontNum,String createTime){
    	this.hotWord = keyword;
    	this.dayNum = dayNum;
    	this.createTime = createTime;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHotWord() {
        return hotWord;
    }

    public void setHotWord(String hotWord) {
        this.hotWord = hotWord == null ? null : hotWord.trim();
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

    public Integer getMonNum() {
        return monNum;
    }

    public void setMonNum(Integer monNum) {
        this.monNum = monNum;
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