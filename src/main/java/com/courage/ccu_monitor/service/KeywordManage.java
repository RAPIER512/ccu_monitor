package com.courage.ccu_monitor.service;

import java.util.List;

import com.courage.ccu_monitor.model.Keyword;
import com.courage.ccu_monitor.model.KeywordStatistic;


public interface KeywordManage {

	public List<KeywordStatistic> getKeywordByDay(String time);

	public List<KeywordStatistic> getKeywordByWeek(String time);

	public List<KeywordStatistic> getKeywordByMonth(String time);
	
	public int addKeyword(Keyword kword);
	
	public int removeKeyword(int id);
	
	public int modifyKeyword(Keyword kword);
	
	public List<Keyword> getKeywordList();
	
}
