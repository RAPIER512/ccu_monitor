package com.courage.ccu_monitor.component.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.courage.ccu_monitor.component.AlarmMonitor;
import com.courage.ccu_monitor.dao.AlarmRecordMapper;
import com.courage.ccu_monitor.dao.CrawlReplyMapper;
import com.courage.ccu_monitor.dao.CrawlTitleMapper;
import com.courage.ccu_monitor.dao.KeywordMapper;
import com.courage.ccu_monitor.model.AlarmRecord;
import com.courage.ccu_monitor.model.CrawlReply;
import com.courage.ccu_monitor.model.CrawlTitle;
import com.courage.ccu_monitor.model.Keyword;
import com.courage.ccu_monitor.util.FileUtil;
import com.courage.ccu_monitor.util.lucene.GetTopTerms;
import com.courage.ccu_monitor.util.lucene.IndexDocs;

@Component
public class AlarmMonitorImpl implements AlarmMonitor {
	@Autowired
	CrawlReplyMapper cReply;
	
	@Autowired
	CrawlTitleMapper cTitle;

	@Autowired
	KeywordMapper keyword;
	
	@Autowired
	AlarmRecordMapper aRecord;
	
	String pathIndex = "";
	String pathText = "";
	String textFile = "";
	String indexFile = "";
	
	Logger logger = Logger.getLogger(AlarmMonitorImpl.class);
	
	public void getSensitive() {

		// 1删除 2查找 3分词 4匹配 5入库 6触发报警
		
		// 重新创建索引目录
		try {
			FileUtil.deleteFile(pathIndex);
			FileUtil.createFile(pathText);
			FileUtil.createFile(pathIndex);
			FileUtil.createFile(pathText);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String start = sf.format(cal.getTime());
		cal.add(Calendar.MINUTE, -30);
		String end = sf.format(cal.getTime());

		StringBuffer sbf = new StringBuffer();
		List<CrawlReply> lreply = cReply.selectByTimeScope(start, end);
		for (int i = 0; i < lreply.size(); i++) {
			sbf.append(lreply.get(i).getText());
		}
		List<CrawlTitle> ltitle = cTitle.selectByTimeScope(start, end);
		for (int i = 0; i < ltitle.size(); i++) {
			sbf.append(ltitle.get(i).getText());
		}
		if (sbf.length() == 0) {
			logger.error("索引数据为空！");
			return;
		}
		
		List<Keyword> keywords = keyword.selectAllKeyword();
		if(keywords == null || keywords.size() ==0){
			logger.error("敏感词汇为空！");
			return;
		}
		
		//创建索引 并分词
		IndexDocs.createIndex(sbf.toString(), pathIndex);
		//读取分词结果
		Map<String, Integer> terms = GetTopTerms.getTermByMap(pathIndex);
		
		for(int i=0;i<keywords.size();i++){
			if(terms.containsKey(keywords.get(i).getKeyword())){
				//触发敏感词汇报警    1入库 2发邮件报警 
				AlarmRecord record = new AlarmRecord();
				record.setRecord(start+"到"+end+" "+keywords.get(i).getKeyword()+"出现报警");
				record.setStatus(1);
				record.setCreteTime(new Timestamp(System.currentTimeMillis()).toString());
				aRecord.insert(record);
			}
		}
	}

}
