package cn.edu.sjtu.se.dclab.server.entity;

import java.util.Date;


public class Information {
	private long informationId;
	private String title;
	private String content;
	private Date submitTime;
	private int informationType;
	private String attachment;
	
	public void setInformationId(long id) {
		this.informationId = id;
	}
	public long getInformationId() {
		return this.informationId;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return this.title;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return this.content;
	}
	
	public void setSubmitTime(Date date) {
		this.submitTime = date;
	}
	public Date getSubmitTime() {
		return this.submitTime;
	}
	
	public void setInformationType(int type) {
		this.informationType = type;
	}
	public int getInformationType() {
		return this.informationType;
	}
	
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getAttachment() {
		return this.attachment;
	}
}
