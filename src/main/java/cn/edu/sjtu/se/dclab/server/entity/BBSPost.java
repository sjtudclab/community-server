package cn.edu.sjtu.se.dclab.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Yongfeng on 10/9/15.
 */
public class BBSPost {

    private long communityId;

    private long id;

    private String title;

    private String type;

    private long posterId;

    private String posterName;

    private long replyNums;

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    private long goodNums;

    private String content;

    public long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(long communityId) {
        this.communityId = communityId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPosterId() {
        return posterId;
    }

    public void setPosterId(long posterId) {
        this.posterId = posterId;
    }

    public long getReplyNums() {
        return replyNums;
    }

    public void setReplyNums(long replyNums) {
        this.replyNums = replyNums;
    }

    public long getGoodNums() {
        return goodNums;
    }

    public void setGoodNums(long goodNums) {
        this.goodNums = goodNums;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
