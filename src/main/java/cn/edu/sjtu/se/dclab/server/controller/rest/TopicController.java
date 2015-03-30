package cn.edu.sjtu.se.dclab.server.controller.rest;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.entity.Topic;
import cn.edu.sjtu.se.dclab.server.entity.TopicVote;
import cn.edu.sjtu.se.dclab.server.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/30.
 */
@Controller
@RequestMapping(Constants.REST + "topic")
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Topic> findAll() {
        return topicService.findAllTopics();
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void submitTopic(@RequestBody Topic topic) {
        topicService.submitTopic(topic);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Topic findTopic(@PathVariable(value = "id") long id) {
        return topicService.findTopic(id);
    }

    @RequestMapping(value = "vote", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void vote(@RequestBody TopicVote vote) {
        topicService.vote(vote);
    }
}
