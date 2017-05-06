package com.courage.ccu_monitor.service;

import java.util.List;

import com.courage.ccu_monitor.model.AlarmRecord;

public interface AlarmManage {

	public List<AlarmRecord> getAlarmRecord(int pageNum,int pageSize);
}
