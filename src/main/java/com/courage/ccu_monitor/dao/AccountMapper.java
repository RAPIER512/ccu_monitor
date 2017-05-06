package com.courage.ccu_monitor.dao;

import java.util.List;

import com.courage.ccu_monitor.model.Account;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
    
    List<Account> getAllAccount();
}