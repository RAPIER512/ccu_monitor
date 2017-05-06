package com.courage.ccu_monitor.util;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

@SuppressWarnings("deprecation")
public class HttpFetcher {

	private static HttpClient httpClient;

	public static String fetcher(String url) {
		String result = "";
		try {
			// 根据地址获取请求
			HttpGet request = new HttpGet(url);// 这里发送get请求
			httpClient = new DefaultHttpClient();
			// 通过请求对象获取响应对象
			HttpResponse response = httpClient.execute(request);
			// 判断网络连接状态码是否正常(0--200都数正常)
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result = EntityUtils.toString(response.getEntity(), "utf-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		// ....result是用户信息,站内业务以及具体的json转换这里也不写了...
	}
	
	public static void main(String[] args) {
		System.out.println(fetcher("http://localhost:8080/solr/reply/select?q=textContent:%E5%AD%A6%E6%A0%A1&wt=json&rows=6"));
	}
}
