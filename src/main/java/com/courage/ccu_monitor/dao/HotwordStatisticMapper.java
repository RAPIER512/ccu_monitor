package com.courage.ccu_monitor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.courage.ccu_monitor.model.HotwordStatistic;

public interface HotwordStatisticMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HotwordStatistic record);

    int insertSelective(HotwordStatistic record);

    HotwordStatistic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HotwordStatistic record);

    int updateByPrimaryKey(HotwordStatistic record);
    
    
    List<HotwordStatistic> seleSticByDay(int dayNum ,String time);
    
    List<HotwordStatistic> seleSticByWeek(int weekNum,String time);
    
    List<HotwordStatistic> seleSticByMonth(int monthNum,String time);
    
    List<HotwordStatistic> seleSticByTimeScope(@Param("start")String start,@Param("end")String end);
    
}