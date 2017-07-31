package com.gms.web.domain;

import java.io.Serializable;

public class ArticleBean implements Serializable {
	private static final long serialVersionUID=1L;
	private String id, title, content, regdate;
	private int seq, hitcount;
	
	
	public String getTitle() {
		return title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getArticleSeq() {
		return seq;
	}
	public void setArticleSeq(int articleSeq) {
		this.seq = articleSeq;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getHitcount() {
		return hitcount;
	}
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
	@Override
	public String toString() {
		return "ArticleBean [id=" + id + ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", seq="
				+ seq + ", hitcount=" + hitcount + "]\n";
	}
		

}
