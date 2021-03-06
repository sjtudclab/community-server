package cn.edu.sjtu.se.dclab.server.controller.rest;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.entity.Topic;
import cn.edu.sjtu.se.dclab.server.entity.TopicOption;
import cn.edu.sjtu.se.dclab.server.entity.TopicVote;
import cn.edu.sjtu.se.dclab.server.service.TopicService;
import cn.edu.sjtu.se.dclab.server.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Huiyi on 2015/3/30.
 */
@Controller
@RequestMapping(Constants.REST + "/topic")
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Topic> findAllByTypeId(HttpServletRequest request) {
        long typeId = Long.parseLong(request.getParameter("type"));
        return topicService.findAllTopicsByTypeId(typeId);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void submitTopic(HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        Topic topic = new Topic();
        topic.setTitle(request.getParameter("title"));
        topic.setContent(request.getParameter("content"));
        topic.setTopicTypeId(Long.parseLong(request.getParameter("topic_type_id")));
        topic.setCreatedBy(Long.parseLong(request.getParameter("from")));

        String[] options = request.getParameter("options").split(",");
        Collection<TopicOption> tos = new ArrayList<TopicOption>();
        for (String option : options) {
            TopicOption to = new TopicOption();
            to.setName(option);

            tos.add(to);
        }
        topic.setOptions(tos);

        MultipartHttpServletRequest req = (MultipartHttpServletRequest)request;
        MultipartFile file = req.getFile("file");
        String attachment = FileUtil.uploadFile(file, request);
        topic.setAttachment(attachment);
        topic.setSubmitTime(new Date());

        topicService.submitTopic(topic);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Topic findTopic(@PathVariable(value = "id") long id) {
        return topicService.findTopic(id);
    }

    @RequestMapping(value = "vote", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void vote(@RequestBody TopicVote vote) {
        topicService.vote(vote);
    }

    @RequestMapping(value = "vote/result/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<TopicOption> voteResult(@PathVariable(value = "id") long id) {
        return topicService.getResult(id);
    }
}
