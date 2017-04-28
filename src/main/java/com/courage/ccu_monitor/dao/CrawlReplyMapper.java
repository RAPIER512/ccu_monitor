package com.courage.ccu_monitor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.courage.ccu_monitor.model.CrawlReply;

public interface CrawlReplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CrawlReply record);

    int insertSelective(CrawlReply record);

    CrawlReply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CrawlReply record);

    int updateByPrimaryKeyWithBLOBs(CrawlReply record);

    int updateByPrimaryKey(CrawlReply record);
    
    
    List<CrawlReply> selectByTimeScope(@Param("start")String start,@Param("end")String end);
}