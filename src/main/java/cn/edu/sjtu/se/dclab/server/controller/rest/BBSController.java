package cn.edu.sjtu.se.dclab.server.controller.rest;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.entity.BBSPost;
import cn.edu.sjtu.se.dclab.server.service.BBSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * Created by Yongfeng on 10/9/15.
 */
@Controller
@RequestMapping(value = Constants.REST + "/bbsposts")
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
}
