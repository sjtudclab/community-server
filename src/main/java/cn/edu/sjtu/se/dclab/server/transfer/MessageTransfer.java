package cn.edu.sjtu.se.dclab.server.transfer;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *2015年4月2日 下午2:09:00
 *@author changyi yuan
 */
public class MessageTransfer {
	private long messageId;
	
	@JsonInclude(Include.NON_NULL) 
	private String content;
	
	@JsonInclude(Include.NON_NULL) 
	private Date submitTime;
	
	@JsonInclude(Include.NON_DEFAULT) 
	private long userId;
	
	@JsonInclude(Include.NON_NULL) 
	private String name;
	
	@JsonInclude(Include.NON_NULL) 
	private String image;
	
	public MessageTransfer(){
		
	}
	
	public MessageTransfer(long messageId, String content, Date submitTime,
			long userId, String name, String image) {
		super();
		this.messageId = messageId;
		this.content = content;
		this.submitTime = submitTime;
		this.userId = userId;
		this.name = name;
		this.image = image;
	}

	public long getMessageId() {
		return messageId;
	}
	public void setMessageId(long messageId) {
		this.messageId = messageId;
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
