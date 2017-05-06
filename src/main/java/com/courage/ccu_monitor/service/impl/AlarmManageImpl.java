package com.courage.ccu_monitor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courage.ccu_monitor.dao.AlarmRecordMapper;
import com.courage.ccu_monitor.model.AlarmRecord;
import com.courage.ccu_monitor.service.AlarmManage;

@Service
public class AlarmManageImpl implements AlarmManage {

	@Autowired
	AlarmRecordMapper aRecord;
	
	public List<AlarmRecord> getAlarmRecord(int pageNum,int pageSize) {
		return aRecord.selectAllAlarmRecord();
	}

}
