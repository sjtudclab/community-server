package cn.edu.sjtu.se.dclab.server.entity;

/**
 * Created by Huiyi on 2015/3/30.
 */
public class TopicOption {
    private long id;
    private String name;
    private Topic topic;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
