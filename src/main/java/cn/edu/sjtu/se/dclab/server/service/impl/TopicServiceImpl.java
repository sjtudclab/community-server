package cn.edu.sjtu.se.dclab.server.service.impl;

import cn.edu.sjtu.se.dclab.server.entity.Topic;
import cn.edu.sjtu.se.dclab.server.entity.TopicOption;
import cn.edu.sjtu.se.dclab.server.entity.TopicVote;
import cn.edu.sjtu.se.dclab.server.mapper.TopicMapper;
import cn.edu.sjtu.se.dclab.server.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/30.
 */
@Service
public class TopicServiceImpl implements TopicService {

    private final TopicMapper topicMapper;

    @Autowired
    public TopicServiceImpl(TopicMapper topicMapper) {
        this.topicMapper = topicMapper;
    }

    @Override
    @Transactional
    public void submitTopic(Topic topic) {
        topicMapper.submitTopic(topic);
        for (TopicOption option : topic.getOptions()) {
            option.setTopic(topic);
            topicMapper.submitOption(option);
        }
    }

    @Override
    @Transactional
    public Collection<Topic> findAllTopicsByTypeId(long typeId) {
        return topicMapper.findAllTopicsByTypeId(typeId);
    }

    @Override
    @Transactional
    public Topic findTopic(long topicId) {
        Topic topic = topicMapper.findTopic(topicId);
        topic.setOptions(topicMapper.findTopicOptions(topicId));

        for (TopicOption option : topic.getOptions()) {
            option.setVoteCount(topicMapper.getOptionCount(option.getId()));
        }

        return topic;
    }

    @Override
    @Transactional
    public void vote(TopicVote vote) {
        topicMapper.vote(vote);
    }

    @Override
    public Collection<TopicOption> getResult(long topicId) {
        Collection<TopicOption> options = topicMapper.findTopicOptions(topicId);
        for (TopicOption option : options) {
            option.setVoteCount(topicMapper.getOptionCount(option.getId()));
        }

        return options;
    }
}
