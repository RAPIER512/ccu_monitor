package com.courage.ccu_monitor.dao;

import com.courage.ccu_monitor.model.CrawlUser;

public interface CrawlUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CrawlUser record);

    int insertSelective(CrawlUser record);

    CrawlUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CrawlUser record);

    int updateByPrimaryKey(CrawlUser record);
}