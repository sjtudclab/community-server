package cn.edu.sjtu.se.dclab.server.entity;

/**
 * Created by Huiyi on 2015/3/30.
 */
public class TopicVote {
    private long id;
    private Topic topic;
    private User user;
    private TopicOption option;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TopicOption getOption() {
        return option;
    }

    public void setOption(TopicOption option) {
        this.option = option;
    }
}
