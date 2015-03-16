package cn.edu.sjtu.se.dclab.server.transfer;

import java.util.Date;

/**
 *2015年3月12日 上午8:48:03
 *@author changyi yuan
 */
public class MailBoxTransfer {
	private long id;
    private MailBoxUserTransfer from;
    private MailBoxUserTransfer to;
    private String content;
    private Date submitedDate;
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public MailBoxUserTransfer getFrom() {
        return from;
    }

    public void setFrom(MailBoxUserTransfer from) {
        this.from = from;
    }

    public MailBoxUserTransfer getTo() {
        return to;
    }

    public void setTo(MailBoxUserTransfer to) {
        this.to = to;
    }
}
