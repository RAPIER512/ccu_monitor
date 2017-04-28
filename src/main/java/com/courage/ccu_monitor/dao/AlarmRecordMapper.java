package com.courage.ccu_monitor.dao;

import java.util.List;

import com.courage.ccu_monitor.model.AlarmRecord;

public interface AlarmRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AlarmRecord record);

    int insertSelective(AlarmRecord record);

    AlarmRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AlarmRecord record);

    int updateByPrimaryKey(AlarmRecord record);
    
    
    List<AlarmRecord> selectAllAlarmRecord();
    
    List<AlarmRecord> selectAlarmRecordByStatus(int status);
}