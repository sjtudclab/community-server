package cn.edu.sjtu.se.dclab.server.controller.rest;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.common.Result;
import cn.edu.sjtu.se.dclab.server.entity.BBSPost;
import cn.edu.sjtu.se.dclab.server.service.BBSService;
import cn.edu.sjtu.se.dclab.server.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
