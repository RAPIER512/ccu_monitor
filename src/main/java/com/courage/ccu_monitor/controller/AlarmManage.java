package com.courage.ccu_monitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.courage.ccu_monitor.model.AlarmRecord;
import com.courage.ccu_monitor.model.Keyword;
import com.courage.ccu_monitor.model.KeywordStatistic;
import com.courage.ccu_monitor.service.ContentManage;
import com.courage.ccu_monitor.service.KeywordManage;
import com.courage.ccu_monitor.vo.ContentVO;


@RestController
@RequestMapping("/auth/alarmmanage")
public class AlarmManage {

	@Autowired
	com.courage.ccu_monitor.service.AlarmManage am;
	
	@Autowired
	KeywordManage km;
	
	@Autowired
	ContentManage cm;
	
	@RequestMapping(value = "/getkeywordSticbyday.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public List<KeywordStatistic> getKeyWordSticByDay(@RequestParam("t")String time){
		return km.getKeywordByDay(time);
	}
	
	@RequestMapping(value = "/getkeywordsticbyweek.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public List<KeywordStatistic> getKeyWordSticByWeek(@RequestParam("t")String time){
		return km.getKeywordByWeek(time);
	}
	
	@RequestMapping(value = "/getkeywordsticbymonth.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public List<KeywordStatistic> getKeyWordSticByMonth(@RequestParam("t")String time){
		return km.getKeywordByMonth(time);
	}
	
	@RequestMapping(value = "/getalarmrecordbypage.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public List<AlarmRecord> getAlarmRecordByPage(@RequestParam("pageNum")int pageNum,@RequestParam("pageSize")int pageSize){
		return am.getAlarmRecord(pageNum,pageSize);
	}
	
	@RequestMapping(value = "/getcontentvobyid.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public List<ContentVO> getContentVOById(@RequestParam("id")String id,@RequestParam("type")String type){
		return cm.getContentById(id, type);
	}
	
	@RequestMapping(value = "/addkeyword.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public int addKeyWord(Keyword kword){
		return km.addKeyword(kword);
	}
	
	@RequestMapping(value = "/removekeyword.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public int removeKeyWord(@RequestParam("id")int id){
		return km.removeKeyword(id);
	}
	
	@RequestMapping(value = "/modifykeyword.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public int modifyKeyWord(Keyword kword){
		return km.modifyKeyword(kword);
	}
	
	@RequestMapping(value = "/getallkeyword.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public List<Keyword> getAllKeyWord(){
		return km.getKeywordList();
	}
}
