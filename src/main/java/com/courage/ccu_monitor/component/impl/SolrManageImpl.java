package com.courage.ccu_monitor.component.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.courage.ccu_monitor.component.SolrManage;
import com.courage.ccu_monitor.util.HttpFetcher;

@Component
public class SolrManageImpl implements SolrManage {

	static String titleUrl = "http://localhost:8080/solr/title";
	static String replyUrl = "http://localhost:8080/solr/reply";
	static String deltaIndexParams = "/dataimport?command=delta-import&clean=false&commit=true";
	static String reBuildIndexParams = "/dataimport?command=full-import&clean=true&commit=true";

	@Scheduled(cron="0 0/10 * * * ?")
	public void getTitleDataImportAll() {
		try{
			new Thread(new Runnable() {
				public void run() {
					System.out.println(HttpFetcher.fetcher(titleUrl+reBuildIndexParams));
				}
			}).start();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("title 重建索引失败！");
		}
	}
	@Scheduled(cron="0 0/10 * * * ?")
	public void getReplyDataImportAll() {
		try{
			new Thread(new Runnable() {
				public void run() {
					System.out.println(HttpFetcher.fetcher(replyUrl+reBuildIndexParams));
				}
			}).start();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("title 重建索引失败！");
		}
	}
	@Scheduled(cron="0 30 23 * * ?")
	public void getTitleDataImprot() {
		try{
			new Thread(new Runnable() {
				public void run() {
					System.out.println(HttpFetcher.fetcher(titleUrl+deltaIndexParams));
				}
			}).start();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("title 增量索引失败！");
		}
	}
	@Scheduled(cron="0 30 23 * * ?")
	public void getReplyDataIMprot() {
		try{
			new Thread(new Runnable() {
				public void run() {
					System.out.println(HttpFetcher.fetcher(replyUrl+deltaIndexParams));
				}
			}).start();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("reply 增量索引失败！");
		}
	}
}
