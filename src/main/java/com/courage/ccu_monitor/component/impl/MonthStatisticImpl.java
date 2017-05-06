package com.courage.ccu_monitor.component.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.courage.ccu_monitor.component.MonthStatistic;
import com.courage.ccu_monitor.dao.HotwordStatisticMapper;
import com.courage.ccu_monitor.dao.KeywordStatisticMapper;
import com.courage.ccu_monitor.model.HotwordStatistic;
import com.courage.ccu_monitor.model.KeywordStatistic;
import com.courage.ccu_monitor.util.TimeUtil;


@Component
public class MonthStatisticImpl implements MonthStatistic {

	@Autowired
	HotwordStatisticMapper hs;

	@Autowired
	KeywordStatisticMapper ks;

	@Scheduled(cron="0 45 23 28 * ?")
	public void getStatistic() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-hh HH:mm:ss");
		Date weekStart = TimeUtil.getBeginDayOfMonth();
		Date weekEnd = TimeUtil.getEndDayOfMonth();

		Calendar cal = Calendar.getInstance();
		cal.setTime(weekStart);
		int monthNum = cal.get(Calendar.MONTH);

		String createTime = new Timestamp(System.currentTimeMillis()) + "";

		List<HotwordStatistic> hotList = hs.seleSticByTimeScope(
				sf.format(weekStart), sf.format(weekEnd));
		for (HotwordStatistic hws : hotList) {
			hws.setMonNum(monthNum);
			hws.setCreateTime(createTime);
			hs.insert(hws);
		}
		List<KeywordStatistic> keyList = ks.selectSticByTimeScope(
				sf.format(weekStart), sf.format(weekEnd));
		for (KeywordStatistic kws : keyList) {
			kws.setMonthNum(monthNum);
			kws.setCreateTime(createTime);
			ks.insert(kws);
		}
	}
}
