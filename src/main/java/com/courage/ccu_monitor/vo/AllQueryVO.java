package com.courage.ccu_monitor.vo;

import java.util.List;

public class AllQueryVO {

	private List<QueryVO> titles;
	private List<QueryVO> replys;
	public List<QueryVO> getTitles() {
		return titles;
	}
	public void setTitles(List<QueryVO> titles) {
		this.titles = titles;
	}
	public List<QueryVO> getReplys() {
		return replys;
	}
	public void setReplys(List<QueryVO> replys) {
		this.replys = replys;
	}
}
