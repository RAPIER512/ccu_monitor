package com.courage.ccu_monitor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.courage.ccu_monitor.model.CrawlTitle;
import com.courage.ccu_monitor.vo.ContentVO;

public interface CrawlTitleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CrawlTitle record);

    int insertSelective(CrawlTitle record);

    CrawlTitle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CrawlTitle record);

    int updateByPrimaryKeyWithBLOBs(CrawlTitle record);

    int updateByPrimaryKey(CrawlTitle record);
    
    
    
    List<CrawlTitle> selectByTimeScope1(@Param("start")String start,@Param("end")String end);
    
    List<ContentVO>  selectContentVOById(String titleId);
}