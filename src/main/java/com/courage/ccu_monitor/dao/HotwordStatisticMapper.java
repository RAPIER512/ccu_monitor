package com.courage.ccu_monitor.dao;

import com.courage.ccu_monitor.model.HotwordStatistic;

public interface HotwordStatisticMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HotwordStatistic record);

    int insertSelective(HotwordStatistic record);

    HotwordStatistic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HotwordStatistic record);

    int updateByPrimaryKey(HotwordStatistic record);
}