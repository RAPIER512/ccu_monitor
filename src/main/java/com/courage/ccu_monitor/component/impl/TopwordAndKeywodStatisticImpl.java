package com.courage.ccu_monitor.component.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.courage.ccu_monitor.component.TopwordAndKeywodStatistic;
import com.courage.ccu_monitor.dao.AlarmRecordMapper;
import com.courage.ccu_monitor.dao.CrawlReplyMapper;
import com.courage.ccu_monitor.dao.CrawlTitleMapper;
import com.courage.ccu_monitor.dao.HotwordStatisticMapper;
import com.courage.ccu_monitor.dao.KeywordMapper;
import com.courage.ccu_monitor.dao.KeywordStatisticMapper;
import com.courage.ccu_monitor.model.CrawlReply;
import com.courage.ccu_monitor.model.CrawlTitle;
import com.courage.ccu_monitor.model.HotwordStatistic;
import com.courage.ccu_monitor.model.Keyword;
import com.courage.ccu_monitor.model.KeywordStatistic;
import com.courage.ccu_monitor.util.FileUtil;
import com.courage.ccu_monitor.util.lucene.GetTopTerms;
import com.courage.ccu_monitor.util.lucene.IndexDocs;

@Component
public class TopwordAndKeywodStatisticImpl implements TopwordAndKeywodStatistic {

	@Autowired
	CrawlReplyMapper cReply;

	@Autowired
	CrawlTitleMapper cTitle;

	@Autowired
	KeywordMapper keyword;

	@Autowired
	AlarmRecordMapper aRecord;
	
	@Autowired
	KeywordStatisticMapper kStatistic;
	
	@Autowired
	HotwordStatisticMapper hStatistic;

	String pathIndex = "";
	String pathText = "";
	String textFile = "";
	String indexFile = "";

	Logger logger = Logger.getLogger(AlarmMonitorImpl.class);

	@SuppressWarnings("static-access")
	public void statistic() {

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
		
		int dayNum = cal.DAY_OF_YEAR;
		
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
		if (keywords == null || keywords.size() == 0) {
			logger.error("敏感词汇为空！");
			return;
		}

		// 创建索引 并分词
		IndexDocs.createIndex(sbf.toString(), pathIndex);
		// 读取分词结果
		Map<String, Integer> terms = GetTopTerms.getTermByMap(pathIndex);
		// 根据关键词热度值进行排序
		List<Entry<String, Integer>> sortList = GetTopTerms.sortTermsMap(terms);
		// 获取top 10 关键词 并入库
		for(int i=sortList.size() -1;i>sortList.size()-11;i--){
			hStatistic.insert(new HotwordStatistic(sortList.get(i).getKey(),dayNum,sortList.get(i).getValue(),new Timestamp(System.currentTimeMillis()).toString()));
		}
		// 获取敏感关键词 并入库
		for (int i = 0; i < keywords.size(); i++) {
			if (terms.containsKey(keywords.get(i).getKeyword())) {
				kStatistic.insert(new KeywordStatistic(keywords.get(i).getKeyword(),dayNum,terms.get(keywords.get(i).getKeyword()),new Timestamp(System.currentTimeMillis()).toString()));
			}
		}
	}
}
