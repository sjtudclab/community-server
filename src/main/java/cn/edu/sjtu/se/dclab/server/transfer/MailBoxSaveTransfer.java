package cn.edu.sjtu.se.dclab.server.transfer;

import java.util.Date;

/**
 * Created by Huiyi on 2015/3/16.
 */
public class MailBoxSaveTransfer {
    private long id;
    private long from;
    private long to;
    private String content;
    private Date submitedDate;
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
