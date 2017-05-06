package com.courage.ccu_monitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.courage.ccu_monitor.service.ContentManage;
import com.courage.ccu_monitor.vo.ContentVO;
import com.courage.ccu_monitor.vo.QueryVO;


@RestController
@RequestMapping("/auth/texttracemanage")
public class TextTraceManage {

	@Autowired
	ContentManage cm;
	
	@RequestMapping(value = "/getcontentvoby.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public List<ContentVO> getContentVOBy(String id,String type){
		return cm.getContentById(id, type);
	}
	
	/**
	 * 全文索引追踪
	 * @param params
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "/getqueryvo.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public List<QueryVO> getQueryVO(String params,String type){
		return cm.getQueryVO(params, type);
	}
}
