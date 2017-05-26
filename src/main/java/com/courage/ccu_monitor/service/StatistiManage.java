package com.courage.ccu_monitor.service;

public interface StatistiManage {

	//获取日帖子增量
	public int getTitleIncByDay(String time);
	
	//获取日报警次数
	public int getAlarmCountByDay(String time);
	
	//抓取用户总量
	public int getAllCrawlUser();
	
	//抓取帖子总量
	public int getAllTitle();
	
	//获取帖子周增量
	public int[][] getAWeekTitleInc(String time);
	
	//获取报警周记录
	public int[][] getAWeekAlarmInc(String time);
}
