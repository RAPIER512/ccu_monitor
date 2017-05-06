package com.courage.ccu_monitor.vo;

public class QueryVO {

	private String post_id;
	
	private String create_time;
	
	private String pub_time;
	
	private String[] textContent;
	
	private String _version_;

	public String getPost_id() {
		return post_id;
	}

	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getPub_time() {
		return pub_time;
	}

	public void setPub_time(String pub_time) {
		this.pub_time = pub_time;
	}

	public String[] getTextContent() {
		return textContent;
	}

	public void setTextContent(String[] textContent) {
		this.textContent = textContent;
	}

	public String get_version_() {
		return _version_;
	}

	public void set_version_(String _version_) {
		this._version_ = _version_;
	}
}
