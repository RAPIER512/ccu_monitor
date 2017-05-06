package com.courage.ccu_monitor.service;

import java.util.List;

import com.courage.ccu_monitor.model.HotwordStatistic;
import com.courage.ccu_monitor.vo.QueryVO;
import com.facebook.presto.sql.tree.Query;

public interface HotwordManage {

	public List<HotwordStatistic> getHotwordByDay(String time);
	
	public List<HotwordStatistic> getHotwordByWeek(String time);
	
	public List<HotwordStatistic> getHotwordByMonth(String time);
}
