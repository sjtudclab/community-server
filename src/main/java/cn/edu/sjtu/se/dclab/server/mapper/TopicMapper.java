package cn.edu.sjtu.se.dclab.server.mapper;

import cn.edu.sjtu.se.dclab.server.entity.Topic;
import cn.edu.sjtu.se.dclab.server.entity.TopicOption;
import cn.edu.sjtu.se.dclab.server.entity.TopicVote;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/30.
 */
public interface TopicMapper {

    public void submitTopic(Topic topic);

    public void submitOption(TopicOption option);

    public Collection<Topic> findAllTopicsByTypeId(long typeId);

    public Topic findTopic(long topicId);

    public Collection<TopicOption> findTopicOptions(long topicId);

    public void vote(TopicVote vote);
}
