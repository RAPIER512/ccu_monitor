package com.courage.ccu_monitor.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courage.ccu_monitor.dao.AlarmRecordMapper;
import com.courage.ccu_monitor.dao.CrawlTitleMapper;
import com.courage.ccu_monitor.dao.CrawlUserMapper;
import com.courage.ccu_monitor.service.StatistiManage;

@Service
public class StatistiManageImp implements StatistiManage{

	@Autowired
	private CrawlTitleMapper ct;
	
	@Autowired
	private AlarmRecordMapper ar;
	
	@Autowired
	private CrawlUserMapper cu;
	
	public int getTitleIncByDay(String time) {
		return ct.selectCountOfDay(time);
	}

	public int getAlarmCountByDay(String time) {
		return ar.selectCountOfDay(time);
	}

	public int getAllCrawlUser() {
		return cu.selectAllUserCount();
	}

	public int getAllTitle() {
		return ct.selectAllTitleCount();
	}

	public int[][] getAWeekTitleInc(String time) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			int[][] result = new int[10][2];
			Date date = sf.parse(time);
			Calendar cal = Calendar.getInstance();
			for(int i=-9;i<=0;i++){
				cal.setTime(date);
				cal.add(Calendar.DAY_OF_MONTH, i);
				String t = sf.format(cal.getTime());
				result[i+9][0]= i+10;
				result[i+9][1]= ct.selectCountOfDay(t);
			}
			return result;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int[][] getAWeekAlarmInc(String time) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			int[][] result = new int[10][2];
			Date date = sf.parse(time);
			Calendar cal = Calendar.getInstance();
			for(int i=-9;i<=0;i++){
				cal.setTime(date);
				cal.add(Calendar.DAY_OF_MONTH, i);
				String t = sf.format(cal.getTime());
				result[i+9][0]= i+10;
				result[i+9][1]= ar.selectCountOfDay(t);
			}
			return result;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
