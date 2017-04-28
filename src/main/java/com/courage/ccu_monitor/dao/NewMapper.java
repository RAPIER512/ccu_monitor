package com.courage.ccu_monitor.dao;

import com.courage.ccu_monitor.model.New;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(New record);

    int insertSelective(New record);

    New selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(New record);

    int updateByPrimaryKeyWithBLOBs(New record);

    int updateByPrimaryKey(New record);

    /*=================================================================*/

    List<New> selectBytype(String type);
}