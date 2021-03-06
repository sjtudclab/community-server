package cn.edu.sjtu.se.dclab.server.service;

import cn.edu.sjtu.se.dclab.server.entity.Topic;
import cn.edu.sjtu.se.dclab.server.entity.TopicOption;
import cn.edu.sjtu.se.dclab.server.entity.TopicVote;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/30.
 */
public interface TopicService {

    public void submitTopic(Topic topic);

    public Collection<Topic> findAllTopicsByTypeId(long typeId);

    public Topic findTopic(long topicId);

    public void vote(TopicVote vote);

    public Collection<TopicOption> getResult(long topicId);
}
