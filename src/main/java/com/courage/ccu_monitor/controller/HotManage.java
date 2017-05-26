package com.courage.ccu_monitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.courage.ccu_monitor.model.HotwordStatistic;
import com.courage.ccu_monitor.service.ContentManage;
import com.courage.ccu_monitor.service.HotwordManage;
import com.courage.ccu_monitor.vo.ContentVO;


@RestController
@RequestMapping("/auth/hotmanage")
public class HotManage {

	@Autowired
	HotwordManage hm;
	
	@Autowired
	ContentManage cm;
	
	@RequestMapping(value = "/gethotwordsticbyday.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public List<HotwordStatistic> getHotWordSticByDay(@RequestParam("t")String time){
		return hm.getHotwordByDay(time);
	}
	
	@RequestMapping(value = "/gethotwordsticbyweek.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public List<HotwordStatistic> getHotWordSticByWeek(@RequestParam("t")String time){
		return hm.getHotwordByWeek(time);
	}
	
	@RequestMapping(value = "/gethotwordsticbymonth.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public List<HotwordStatistic> getHotWordSticByMonth(@RequestParam("t")String time){
		return hm.getHotwordByMonth(time);
	}
	
	@RequestMapping(value = "/getcontentvobyid.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public List<ContentVO> getContentVOById(@RequestParam("id")String id,@RequestParam("type")String type){
		return cm.getContentById(id, type);
	}
}
