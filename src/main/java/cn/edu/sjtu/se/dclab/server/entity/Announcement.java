package cn.edu.sjtu.se.dclab.server.entity;

/**
 * Created by Huiyi on 2015/3/13.
 */
public class Announcement {
    private long id;
    private String content;

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
}
