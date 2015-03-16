package cn.edu.sjtu.se.dclab.server.entity;

import java.util.Date;

import cn.edu.sjtu.se.dclab.server.transfer.MailBoxTransfer;

/**
 * Created by Huiyi on 2015/3/11.
 */
public class MailBox {
    private long id;
    private String from;
    private String to;
    private String content;
    private Date submitedDate;
    private String status;

    public MailBox() {
    }
    
    public MailBox(MailBoxTransfer mailBoxTransfer) {
		this.from = mailBoxTransfer.getFrom();
		this.to = mailBoxTransfer.getTo();
		this.content  = mailBoxTransfer.getContent();
		this.submitedDate  = mailBoxTransfer.getSubmitedDate();
        this.status = mailBoxTransfer.getStatus();
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSubmitedDate() {
        return submitedDate;
    }

    public void setSubmitedDate(Date submitedDate) {
        this.submitedDate = submitedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
