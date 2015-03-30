package cn.edu.sjtu.se.dclab.server.entity;

import java.util.Date;

import cn.edu.sjtu.se.dclab.server.transfer.WorkReportTransfer;

public class WorkReport {
	private long reportId;

	private Citizen citizen;

	private Date reportTime;
	
	private String content;
	
	private String attachment;
	
	public WorkReport() {}
	
	public WorkReport(WorkReportTransfer workReportTransfer) {
		Citizen citizen = new Citizen();
		citizen.setId(workReportTransfer.getCitizenId());
		this.setCitizen(citizen);
		this.setReportTime(workReportTransfer.getReportTime());
		this.setContent(workReportTransfer.getContent());
		this.setAttachment(workReportTransfer.getAttachment());
	}
	
	public void setReportId(long id) {
		this.reportId = id;
	}
	
	public long getReportId() {
		return this.reportId;
	}
	
	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}
	
	public Citizen getCitizen() {
		return this.citizen;
	}
	
	public void setReportTime(Date time){
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
