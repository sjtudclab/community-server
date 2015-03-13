package cn.edu.sjtu.se.dclab.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Huiyi on 2015/3/13.
 */
public class Announcement {
    @JsonProperty(value = "id")
    private long id;

    @JsonProperty(value = "content")
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
