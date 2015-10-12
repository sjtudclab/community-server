package cn.edu.sjtu.se.dclab.server.entity;

import java.util.Date;

/**
 * Created by Kaiyang Lv on 10/11/15.
 */
public class BBSReply {
    private long bbs_post_id;
    private long bbs_reply_id;
    private long bbs_replier_id;
    private Date bbs_reply_time;
    private String 	bbs_reply_content;
    private long bbs_another_reply_id;

    public Date getBbs_reply_time() {
        return bbs_reply_time;
    }

    public void setBbs_reply_time(Date bbs_reply_time) {
        this.bbs_reply_time = bbs_reply_time;
    }

    public long getBbs_post_id() {

        return bbs_post_id;
    }

    public void setBbs_post_id(long bbs_post_id) {
        this.bbs_post_id = bbs_post_id;
    }

    public long getBbs_reply_id() {
        return bbs_reply_id;
    }

    public void setBbs_reply_id(long bbs_reply_id) {
        this.bbs_reply_id = bbs_reply_id;
    }

    public long getBbs_replier_id() {
        return bbs_replier_id;
    }

    public void setBbs_replier_id(long bbs_replier_id) {
        this.bbs_replier_id = bbs_replier_id;
    }



    public String getBbs_reply_content() {
        return bbs_reply_content;
    }

    public void setBbs_reply_content(String bbs_reply_content) {
        this.bbs_reply_content = bbs_reply_content;
    }

    public long getBbs_another_reply_id() {
        return bbs_another_reply_id;
    }

    public void setBbs_another_reply_id(long bbs_another_reply_id) {
        this.bbs_another_reply_id = bbs_another_reply_id;
    }
}
