package cn.edu.sjtu.se.dclab.server.transfer;

import java.util.Date;


public class WorkReportTransfer {
	private long reportId;
	private long citizenId;
	private Date reportTime;
	private String content;
	private String attachment;
	
	public void setReportId(long id) {
		this.reportId = id;
	}
	public long getReportId() {
		return this.reportId;
	}
	
	public void setCitizenId(long id) {
		this.citizenId = id;
	}
	public long getCitizenId() {
		return this.citizenId;
	}
	
	public void setReportTime(Date time) {
		this.reportTime = time;
	}
	public Date getReportTime() {
		return this.reportTime;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return this.content;
	}
	
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getAttachment() {
		return this.attachment;
	}
}
