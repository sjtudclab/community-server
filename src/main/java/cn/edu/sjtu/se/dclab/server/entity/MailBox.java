package cn.edu.sjtu.se.dclab.server.entity;

import java.util.Date;

import cn.edu.sjtu.se.dclab.server.transfer.MailBoxTransfer;

/**
 * Created by Huiyi on 2015/3/11.
 */
public class MailBox {
    private long id;
    private User from;
    private User to;
    private String content;
    private Date submitedDate;
    private String status;

    public MailBox() {
    }
    
    public MailBox(MailBoxTransfer mailBoxTransfer) {
        User fromUser = new User();
        fromUser.setId(mailBoxTransfer.getFrom().getId());
        User toUser = new User();
        toUser.setId(mailBoxTransfer.getTo().getId());

		this.setFrom(fromUser);
		this.setTo(toUser);
		this.setContent(mailBoxTransfer.getContent());
		this.setSubmitedDate(mailBoxTransfer.getSubmitedDate());
        this.setStatus(mailBoxTransfer.getStatus());
	}


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

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }
}
