package com.courage.ccu_monitor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.courage.ccu_monitor.model.KeywordStatistic;

public interface KeywordStatisticMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KeywordStatistic record);

    int insertSelective(KeywordStatistic record);

    KeywordStatistic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KeywordStatistic record);

    int updateByPrimaryKey(KeywordStatistic record);
   
    
    
    List<KeywordStatistic> selectSticByDay(int dayNum ,String time);
    
    List<KeywordStatistic> selectSticByWeek(int weekNum ,String time);
    
    List<KeywordStatistic> selectSticByMonth(int monthNum ,String time);
    
    List<KeywordStatistic> selectAllStic();
    
    List<KeywordStatistic> selectSticByTimeScope(@Param("start")String start,@Param("end")String end);
}