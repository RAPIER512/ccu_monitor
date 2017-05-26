package com.courage.ccu_monitor.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courage.ccu_monitor.dao.HotwordStatisticMapper;
import com.courage.ccu_monitor.model.HotwordStatistic;
import com.courage.ccu_monitor.service.HotwordManage;

@Service
public class HotwordManageImpl implements HotwordManage {

	@Autowired
	HotwordStatisticMapper hStatistic;
	
	public List<HotwordStatistic> getHotwordByDay(String time) {
		try{
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sf.parse(time));
			int dayNum = cal.get(Calendar.DAY_OF_YEAR);
			String t_time = time.substring(0,10);
			List<HotwordStatistic> list = hStatistic.seleSticByDay(dayNum, t_time);
			if(list != null && "".equals("")){
				return list;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public List<HotwordStatistic> getHotwordByMonth(String time) {
		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sf.parse(time));
			int dayNum = cal.get(Calendar.MONTH);
			String t_time = cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH);
			List<HotwordStatistic> list = hStatistic.seleSticByMonth(dayNum, t_time);
			if(list != null && "".equals("")){
				return list;
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	public List<HotwordStatistic> getHotwordByWeek(String time) {
		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sf.parse(time));
			int weekNum = cal.get(Calendar.WEEK_OF_YEAR);
			String t_time = cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH);
			List<HotwordStatistic> list = hStatistic.seleSticByWeek(weekNum, t_time);
			if(list != null && "".equals("")){
				return list;
			}
		} catch (Exception e) {
			
		}
		return null;
	}
	
}
