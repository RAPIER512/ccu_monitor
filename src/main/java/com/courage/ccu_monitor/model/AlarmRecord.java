package com.courage.ccu_monitor.model;


public class AlarmRecord {
    private Integer id;

    private String record;

    private Integer status;

    private String creteTime;

    public AlarmRecord(){
    	
    }
    
    public AlarmRecord(int id,int status){
    	this.id = id;
    	this.status=status;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record == null ? null : record.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreteTime() {
        return creteTime;
    }

    public void setCreteTime(String creteTime) {
        this.creteTime = creteTime;
    }
}