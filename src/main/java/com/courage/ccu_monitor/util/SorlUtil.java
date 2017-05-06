package com.courage.ccu_monitor.util;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.methods.HttpGet;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpClientUtil;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import com.alibaba.druid.util.HttpClientUtils;

public class SorlUtil {

	static String titleUrl = "http://localhost:8080/solr/title";
	static String replyUrl = "http://localhost:8080/solr/reply";
	private static SolrClient solrClient;

	@SuppressWarnings("deprecation")
	public static String getTitleByCondition(String str) {
		solrClient = new HttpSolrClient(titleUrl);
		// 查询实现类
		SolrQuery solrQuery = new SolrQuery();
		// 查询关键词 q 管家你字段
		solrQuery.set("q", str);
		solrQuery.set("wt", "json");
		QueryResponse response = null;
		SolrDocumentList results = null;
		try {
			response = solrClient.query(solrQuery);
			results = response.getResults();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (results != null) {
			return results.toString();
		} else {
			return null;
		}
	}

	public static String getReplyByCondition(String str) {
		solrClient = new HttpSolrClient(replyUrl);
		// 查询实现类
		SolrQuery solrQuery = new SolrQuery();
		// 查询关键词 q 管家你字段
		solrQuery.set("q", str);
		solrQuery.set("wt", "json");
		QueryResponse response = null;
		SolrDocumentList results = null;
		try {
			response = solrClient.query(solrQuery);
			results = response.getResults();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (results != null) {
			return results.toString();
		} else {
			return null;
		}
	}

	public static void main(String[] args) throws SolrServerException,
			IOException {
		String url = "http://localhost:8080/solr/mynode";
		// 实例化一个solr
		SolrClient solrClient = new HttpSolrClient(url);
		// 查询实现类
		SolrQuery solrQuery = new SolrQuery();
		// 查询关键词 q 管家你字段
		solrQuery.set("q", "textContent:学习");
		solrQuery.set("wt", "json");

		// 过滤条件
		// solrQuery.addFilterQuery("品牌");
		// 拿出response当中的数据 结果集
		QueryResponse response = solrClient.query(solrQuery);

		SolrDocumentList results = response.getResults();
		// 结果集有多少条数据
		long numFond = results.getNumFound();

		System.out.println("数据条数：" + numFond);
		System.out.println("results" + results.toString());
		for (SolrDocument solrDocument : results) {
			System.out.println(solrDocument.toString());
			String id = (String) solrDocument.get("id");
			String contentTest = solrDocument.get("post_id").toString();
			System.out.println("id:" + id + "===post_id:" + contentTest);
		}
	}
}