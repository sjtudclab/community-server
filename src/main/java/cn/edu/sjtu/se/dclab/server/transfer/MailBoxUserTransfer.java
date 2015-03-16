package cn.edu.sjtu.se.dclab.server.transfer;

import cn.edu.sjtu.se.dclab.server.entity.User;

/**
 * Created by Huiyi on 2015/3/16.
 */
public class MailBoxUserTransfer {

    public MailBoxUserTransfer() {}

    public MailBoxUserTransfer(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    private long id;
    private String username;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
