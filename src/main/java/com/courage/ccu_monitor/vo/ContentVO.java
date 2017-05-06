package com.courage.ccu_monitor.vo;

import java.util.List;

public class ContentVO {

	private Integer id;

    private String postId;

    private String replyNum;

    private String authorName;

    private String authorId;

    private String pubTime;

    private String createTime;

    private String text;
    
    private List<ReplyVO> replyVOs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(String replyNum) {
		this.replyNum = replyNum;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getPubTime() {
		return pubTime;
	}

	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<ReplyVO> getReplyVOs() {
		return replyVOs;
	}

	public void setReplyVOs(List<ReplyVO> replyVOs) {
		this.replyVOs = replyVOs;
	}
}
