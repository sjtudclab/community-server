package cn.edu.sjtu.se.dclab.server.entity;

import java.util.Date;

public class Topic {
	private long topicId;
	private String name;
	private String content;
	private String desc;
	private long voteCount;
	private Date startTime;
	private Date endTime;
	private long topicTypeId;
	private long parentTopicId;
	private String attachment;
	
	public void setTopicId(long id) {
		this.topicId = id;
	}
	public long getTopicId() {
		return this.topicId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return this.content;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDesc() {
		return this.desc;
	}
	
	public void setVoteCount(long voteCount) {
		this.voteCount = voteCount;
	}
	public long getVoteCount() {
		return this.voteCount;
	}
	
	public void setStartTime(Date time) {
		this.startTime = time;
	}
	public Date getStartTime(Date time) {
		return this.startTime;
	}
	
	public void setEndTime(Date time) {
		this.endTime = time;
	}
	public Date getEndTime() {
		return this.endTime;
	}
	
	public void setTopicTypeId(long id) {
		this.topicTypeId = id;
	}
	public long getTopicTypeId() {
		return this.topicTypeId;
	}
	
	public void setParentTopicId(long id) {
		this.parentTopicId = id;
	}
	public long getParentTopicId() {
		return this.parentTopicId;
	}
	
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getAttachment() {
		return this.attachment;
	}
}
