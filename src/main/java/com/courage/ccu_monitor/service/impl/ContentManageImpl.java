package com.courage.ccu_monitor.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.courage.ccu_monitor.dao.CrawlReplyMapper;
import com.courage.ccu_monitor.dao.CrawlTitleMapper;
import com.courage.ccu_monitor.model.CrawlReply;
import com.courage.ccu_monitor.service.ContentManage;
import com.courage.ccu_monitor.util.SorlUtil;
import com.courage.ccu_monitor.vo.AllQueryVO;
import com.courage.ccu_monitor.vo.ContentVO;
import com.courage.ccu_monitor.vo.QueryVO;

@Service
public class ContentManageImpl implements ContentManage {
	
	@Autowired
	CrawlTitleMapper ctitle;
	
	@Autowired
	CrawlReplyMapper creply;
	
	public List<ContentVO> getContentById(String id, String type) {
		List<ContentVO> list = null;
		if("title".equals(type)){
			list = ctitle.selectContentVOById(id);
		}else if("reply".equals(type)){
			String title_id = "";
			CrawlReply cr = creply.selectByPostId(id);
			if(cr != null){
				title_id = cr.getTitleId();
				list = ctitle.selectContentVOById(title_id);
			}
		}
		return list;
	}

	public AllQueryVO getQueryVO(String parms,String type) {
		AllQueryVO allQueryVO = new AllQueryVO();
		String result = null;
		String result2 = null;
		if(type.contains("title")){
			result = SorlUtil.getTitleByCondition(parms);
			System.out.println("&&&&&&&&&&&&&"+result.toString());
			JSONArray jo = JSON.parseArray(result);
			try {
				List<QueryVO> list = new ArrayList<QueryVO>();
				if(jo.size()>0){
					for(int i=0;i<jo.size();i++){
						JSONObject jo1= jo.getJSONObject(i);
						QueryVO qv = JSON.parseObject(jo1.toJSONString(), QueryVO.class);
						list.add(qv);
					}
				}
				allQueryVO.setTitles(list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(type.contains("reply")){
			result2 = SorlUtil.getReplyByCondition(parms);
			System.out.println("&&&&&33333&&&&&"+result2.toString());
			JSONArray jo = JSON.parseArray(result2);
			try {
				List<QueryVO> list = new ArrayList<QueryVO>();
				if(jo.size()>0){
					for(int i=0;i<jo.size();i++){
						JSONObject jo1= jo.getJSONObject(i);
						QueryVO qv = JSON.parseObject(jo1.toJSONString(), QueryVO.class);
						list.add(qv);
					}
				}
				allQueryVO.setReplys(list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return allQueryVO;
	}
}
