package com.courage.ccu_monitor.controller;

import com.alibaba.fastjson.JSON;
import com.courage.ccu_monitor.dao.NewMapper;
import com.courage.ccu_monitor.model.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by courage on 2016/7/13.
 */

@RestController
@RequestMapping("/NewsManage")
public class NewsManageCtr {

    @Autowired
    NewMapper newMapper;

    @RequestMapping(value = "/publishNews.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int publishNews(@RequestParam String news){

        New news1 = JSON.parseObject(news,New.class);

        SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd-hh:mm:ss");
        news1.setTime(sf.format(new Date()));
        news1.setId(null);
        return newMapper.insert(news1);
    }

    @RequestMapping(value = "/publishNews1.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int publishNews1(@RequestBody New news){

        SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd-hh:mm:ss");
        news.setTime(sf.format(new Date()));
        news.setId(null);
        return newMapper.insert(news);
    }


    @RequestMapping(value = "/removeNews.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int removeNews(@RequestParam int id){
        return newMapper.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "/modifyNews.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int modifyNews(@RequestBody New news){
        return newMapper.updateByPrimaryKeySelective(news);
    }

    @RequestMapping(value = "/getNews.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<New> getNws(@RequestParam String type){
        return newMapper.selectBytype(type);
    }


    @RequestMapping(value = "/getOneNews.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public New getOneNws(@RequestParam Integer id){
        return newMapper.selectByPrimaryKey(id);
    }

}
