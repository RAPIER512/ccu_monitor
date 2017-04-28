package com.courage.ccu_monitor.dao;

import com.courage.ccu_monitor.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /*======================================================================*/
    List<User> seletAll();

    List<User> selectByName(String name);
}