package com.courage.ccu_monitor.dao;

import java.util.List;

import com.courage.ccu_monitor.model.UserMsg;

public interface UserMsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserMsg record);

    int insertSelective(UserMsg record);

    UserMsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserMsg record);

    int updateByPrimaryKey(UserMsg record);
    
    List<UserMsg> selectAll();
}