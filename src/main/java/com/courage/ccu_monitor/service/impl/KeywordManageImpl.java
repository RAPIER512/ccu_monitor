package com.courage.ccu_monitor.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courage.ccu_monitor.dao.KeywordMapper;
import com.courage.ccu_monitor.dao.KeywordStatisticMapper;
import com.courage.ccu_monitor.model.Keyword;
import com.courage.ccu_monitor.model.KeywordStatistic;
import com.courage.ccu_monitor.service.KeywordManage;

@Service
public class KeywordManageImpl implements KeywordManage{

	@Autowired
	KeywordStatisticMapper kStatistic;
	
	@Autowired
	KeywordMapper kMapper;
	
	public List<KeywordStatistic> getKeywordByDay(String time) {
		try{
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sf.parse(time));
			int dayNum = cal.get(Calendar.DAY_OF_YEAR);
			String t_time = cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DAY_OF_MONTH);
			List<KeywordStatistic> list = kStatistic.selectSticByDay(dayNum, t_time);
			if(list != null && "".equals("")){
				return list;
			}
		}catch(Exception e){
			
		}
		return null;
	}

	public List<KeywordStatistic> getKeywordByMonth(String time) {
		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sf.parse(time));
			int dayNum = cal.get(Calendar.MONTH);
			String t_time = cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH);
			List<KeywordStatistic> list = kStatistic.selectSticByMonth(dayNum, t_time);
			if(list != null && "".equals("")){
				return list;
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	public List<KeywordStatistic> getKeywordByWeek(String time) {
		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sf.parse(time));
			int weekNum = cal.get(Calendar.WEEK_OF_YEAR);
			String t_time = cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH);
			List<KeywordStatistic> list = kStatistic.selectSticByWeek(weekNum, t_time);
			if(list != null && "".equals("")){
				return list;
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	public int addKeyword(Keyword kword) {
		return kMapper.insert(kword);
	}

	public int removeKeyword(int id) {
		return kMapper.deleteByPrimaryKey(id);
	}

	public int modifyKeyword(Keyword kword) {
		return kMapper.updateByPrimaryKey(kword);
	}

	public List<Keyword> getKeywordList() {
		return kMapper.selectAllKeyword();
	}

}
