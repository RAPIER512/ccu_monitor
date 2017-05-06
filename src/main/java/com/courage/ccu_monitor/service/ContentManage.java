package com.courage.ccu_monitor.service;

import java.util.List;

import com.courage.ccu_monitor.vo.ContentVO;
import com.courage.ccu_monitor.vo.QueryVO;

public interface ContentManage {

	public List<ContentVO> getContentById(String id,String type);
	
	public List<QueryVO> getQueryVO(String parms,String type);
}
