package cn.edu.sjtu.se.dclab.server.entity;

import java.util.Date;


public class Information {
	private long informationId;
	private long from;
	private long to;
	private int status;
	private String title;
	private String content;
	private Date submitTime;
	private int informationType;
	private String attachment;

	public long getInformationId() {
		return informationId;
	}

	public void setInformationId(long informationId) {
		this.informationId = informationId;
	}

	public long getFrom() {
		return from;
	}

	public void setFrom(long from) {
		this.from = from;
	}

	public long getTo() {
		return to;
	}

	public void setTo(long to) {
		this.to = to;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
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

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public int getInformationType() {
		return informationType;
	}

	public void setInformationType(int informationType) {
		this.informationType = informationType;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
}
