package com.courage.ccu_monitor.dao;

import java.util.List;

import com.courage.ccu_monitor.model.Keyword;

public interface KeywordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Keyword record);

    int insertSelective(Keyword record);

    Keyword selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Keyword record);

    int updateByPrimaryKey(Keyword record);
    
    List<Keyword> selectAllKeyword();
}