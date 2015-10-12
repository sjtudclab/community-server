package cn.edu.sjtu.se.dclab.server.controller.rest;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.common.Result;
import cn.edu.sjtu.se.dclab.server.entity.BBSPost;
import cn.edu.sjtu.se.dclab.server.entity.BBSReply;
import cn.edu.sjtu.se.dclab.server.service.BBSService;
import cn.edu.sjtu.se.dclab.server.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Yongfeng on 10/9/15.
 */
@Controller
@RequestMapping(value = Constants.REST + "/bbspost")
public class BBSController {
    @Autowired
    private BBSService bbsService;

    public BBSService getBBSService() {
        return bbsService;
    }

    public void setBBSService(BBSService bbsService) {
        this.bbsService = bbsService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<BBSPost> findAll() {
        return bbsService.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public String postBbspost(@RequestBody BBSPost bbsPost)  {
        bbsService.save(bbsPost);
        return Result.SUCCESS;

    }

    @RequestMapping(value = "reply/{post_id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String replyBbspost(@PathVariable long post_id, @RequestBody BBSReply bbsReply)  {
        bbsReply.setBbs_post_id(post_id);
        bbsService.saveReply(bbsReply);
        return Result.SUCCESS;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<BBSPost> getBbsPost(@PathVariable long id)  {
        return bbsService.findBbsPostById(id);

    }

    @RequestMapping(value = "/{post_id}/replies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<BBSReply> getBbsPostReplies(@PathVariable long post_id)  {
        return bbsService.findBbsRepliesByPostId(post_id);

    }
}
