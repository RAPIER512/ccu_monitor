package com.courage.ccu_monitor.util;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {

	public static String kafka_metadata_broker_list = "";
	public static String kafka_serializer_class = "";
	public static String kafka_news_topic = "";

	public static String redis_url = "";
	public static String redis_auth = "";
	public static int redis_port = 0;

	public static String hub_page_sql = "";

	public static String mysql_driver_className = "";
	public static String mysql_username = "";
	public static String mysql_password = "";
	public static String mysql_url = "";
	public static int mysql_pool_size = 0;

	public static String cb_nodes = "";
	public static int cb_timeout = 0;
	public static int cb_keepalive = 0;
	public static int cb_autorelease = 0;

	public static String mongo_ip1 = "";
	public static int mongo_port1 = 0;
	public static String mongo_ip2 = "";
	public static int mongo_port2 = 0;
	public static String mongo_ip3 = "";
	public static int mongo_port3 = 0;
	public static String mongo_user = "";
	public static String mongo_pwd = "";

	public static String mail_user = "";
	public static String main_pwd = "";
	public static String main_to = "";

	public static int is_theme = 0;

	public static String mongo_db = "";

	public static String wangyi_t = "";

	public static String yidian_s = "";

	public static String tiantian_d = "";

	public static String sogou_s = "";

	public static String append_url = "";

	public static String append_url_test = "";

	public static String append_url_video_test = "";

	public static String thumbnail_suffix = "";

	public static String script = "";

	public static String script_td = "";

	public static String script_aqy = "";
	
	public static String script_ls = "";
	
	public static void init(String conf_path) {
		try {
			FileInputStream fis = new FileInputStream(conf_path);
			Properties props = new Properties();
			props.load(fis);
			/*kafka_metadata_broker_list = props.getProperty("kafka_metadata_broker_list");
			kafka_serializer_class = props.getProperty("kafka_serializer_class");
			kafka_news_topic = props.getProperty("kafka_news_topic");

			redis_url = props.getProperty("redis_url");
			redis_auth = props.getProperty("redis_auth");
			redis_port = Integer.parseInt(props.getProperty("redis_port"));*/

			hub_page_sql = props.getProperty("hub_page_sql");

			mysql_driver_className = props.getProperty("mysql_driver_className");
			mysql_username = props.getProperty("mysql_username");
			mysql_password = props.getProperty("mysql_password");
			mysql_url = props.getProperty("mysql_url");
			mysql_pool_size = Integer.parseInt(props.getProperty("mysql_pool_size"));

			/*cb_nodes = props.getProperty("cb_nodes");
			cb_timeout = Integer.parseInt(props.getProperty("cb_timeout"));
			cb_keepalive = Integer.parseInt(props.getProperty("cb_keepalive"));
			cb_autorelease = Integer.parseInt(props.getProperty("cb_autorelease"));

			mongo_db = props.getProperty("mongo_db");
			mongo_ip1 = props.getProperty("mongo_ip1");
			mongo_port1 = Integer.parseInt(props.getProperty("mongo_port1"));
			mongo_ip2 = props.getProperty("mongo_ip2");
			mongo_port2 = Integer.parseInt(props.getProperty("mongo_port2"));
			mongo_ip3 = props.getProperty("mongo_ip3");
			mongo_port3 = Integer.parseInt(props.getProperty("mongo_port3"));
			mongo_user = props.getProperty("mongo_user");
			mongo_pwd = props.getProperty("mongo_pwd");*/

			mail_user = props.getProperty("mail_user");
			main_pwd = props.getProperty("main_pwd");
			main_to = props.getProperty("main_to");

			wangyi_t = props.getProperty("wangyi_t");

			yidian_s = props.getProperty("yidian_s");

			tiantian_d = props.getProperty("tiantian_d");

			sogou_s = props.getProperty("sogou_s");

			/*append_url = props.getProperty("append_url");

			append_url_test = props.getProperty("append_url_test");

			append_url_video_test = props.getProperty("append_url_video_test");*/

			thumbnail_suffix = props.getProperty("thumbnail_suffix");

			script = props.getProperty("script");

			script_td = props.getProperty("script_td");

			script_aqy = props.getProperty("script_aqy");
			
			script_ls = props.getProperty("script_ls");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}