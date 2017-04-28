package com.courage.ccu_monitor.dao;

import com.courage.ccu_monitor.model.KeywordStatistic;

public interface KeywordStatisticMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KeywordStatistic record);

    int insertSelective(KeywordStatistic record);

    KeywordStatistic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KeywordStatistic record);

    int updateByPrimaryKey(KeywordStatistic record);
}