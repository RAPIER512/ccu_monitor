package com.courage.ccu_monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.courage.ccu_monitor.service.StatistiManage;

@RestController
@RequestMapping("/auth/statisticmanage")
public class StatisticManageCtr {
	
	@Autowired
	StatistiManage sm;
	
	//获取日帖子增量
	@RequestMapping(value = "/gettitleincbyday.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public int getTitleIncByDay(@RequestParam("t")String time){
		return sm.getTitleIncByDay(time);
	}
	
	//获取日报警次数
	@RequestMapping(value = "/getalarmdaycount.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public int getAlarmDayCount(@RequestParam("t")String time){
		return sm.getTitleIncByDay(time);
	}
	
	//抓取用户总量
	@RequestMapping(value = "/getallusercount.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public int getAllUserCount(){
		return sm.getAllCrawlUser();
	}
	
	//抓取帖子总量
	@RequestMapping(value = "/getalltitlecount.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public int getAllTitleCount(){
		return sm.getAllTitle();
	}
	
	//获取帖子周增量
	@RequestMapping(value = "/getweekttitleinc.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public int[][] getWeekTtitleInc(@RequestParam("t")String time){
		return sm.getAWeekTitleInc(time);
	}
	
	//获取报警记录周增量
	@RequestMapping(value = "/getweekalarminc.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public int[][] getWeekAlarmInc(@RequestParam("t")String time){
		return sm.getAWeekAlarmInc(time);
	}
}
