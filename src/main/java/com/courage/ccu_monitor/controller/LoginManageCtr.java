package com.courage.ccu_monitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.courage.ccu_monitor.dao.UserMapper;
import com.courage.ccu_monitor.model.User;


/**
 * Created by courage on 2016/7/13.
 */

@RestController
@RequestMapping("/LoginManage")
public class LoginManageCtr {

    @Autowired
    UserMapper userMapper;


    @RequestMapping(value = "/login.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int login(@RequestParam String user){
        User user1  = JSON.parseObject(user,User.class);
        List<User> list = userMapper.selectByName(user1.getName());
        if(list.size()>0){
            if(list.get(0).getPassword().equals(user1.getPassword())&&list.get(0).getType()==user1.getType()){
                return 100;
            }else {
                return 101;
            }
        }else {
            return 102;
        }
    }

    @RequestMapping(value = "/login1.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int login1(@RequestBody User user){
        List<User> list = userMapper.selectByName(user.getName());
        if(list.size()>0){
            if(list.get(0).getPassword().equals(user.getPassword())&&list.get(0).getType()==user.getType()){
                return 100;
            }else {
                return 101;
            }
        }else {
            return 102;
        }
    }
}
