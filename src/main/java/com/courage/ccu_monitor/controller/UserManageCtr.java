package com.courage.ccu_monitor.controller;

import com.courage.ccu_monitor.dao.UserMapper;
import com.courage.ccu_monitor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by courage on 2016/7/13.
 */
@RestController
@RequestMapping("/UserManage")
public class UserManageCtr {

    @Autowired
    UserMapper userMapper;


    @RequestMapping(value = "/removeUser.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int removeUser(@RequestParam int id){
        return userMapper.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "/modifyUser.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int modifyUser(@RequestBody User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @RequestMapping(value = "/getUsers.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<User> getUsers(){
        return userMapper.seletAll();
    }

    @RequestMapping(value = "/addUser.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int addUser(@RequestBody User user){
        System.out.println(user.toString());
        user.setId(null);
        return userMapper.insertSelective(user);
    }


}
