package cn.edu.sjtu.se.dclab.server.controller.rest;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.entity.Topic;
import cn.edu.sjtu.se.dclab.server.entity.TopicOption;
import cn.edu.sjtu.se.dclab.server.entity.TopicVote;
import cn.edu.sjtu.se.dclab.server.service.TopicService;
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
    public Collection<Topic> findAll() {
        return topicService.findAllTopics();
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String submitTopic(HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        Topic topic = new Topic();
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
        if (!file.isEmpty()) {
            ServletContext sc = request.getSession().getServletContext();
            String dir = sc.getRealPath("/uploadimage");    //设定文件保存的目录

            String filename = file.getOriginalFilename();    //得到上传时的文件名

            String newFilename =  getFileNameWithoutExt(filename) + System.currentTimeMillis() + "." + getFileType(filename);
            topic.setAttachment("uploadimage/" + newFilename);

            FileUtils.writeByteArrayToFile(new File(dir, newFilename), file.getBytes());
        }

        topicService.submitTopic(topic);

        return "redirect:/start-screen-committee";
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

    private String getFileNameWithoutExt(String filename) {
        return filename.split("\\.")[0];
    }

    private String getFileType(String filename){
        String[] arr = filename.split("\\.");
        return arr[1];
    }
}
