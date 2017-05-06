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

	public List<QueryVO> getQueryVO(String parms,String type) {
		String result = null;
		if("title".equals(type)){
			result = SorlUtil.getTitleByCondition(parms);
		}else if("reply".equals(type)){
			result = SorlUtil.getReplyByCondition(parms);
		}else{
			return null;
		}
		JSONObject jo = (JSONObject) JSON.parse(result);
		try {
			List<QueryVO> list = new ArrayList<QueryVO>();
			JSONArray ja = jo.getJSONObject("response").getJSONArray("docs");
			if(ja.size()>0){
				for(int i=0;i<ja.size();i++){
					JSONObject jo1= ja.getJSONObject(i);
					QueryVO qv = JSON.parseObject(jo1.toJSONString(), QueryVO.class);
					list.add(qv);
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
