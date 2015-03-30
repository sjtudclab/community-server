package cn.edu.sjtu.se.dclab.server.controller.rest;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.entity.Citizen;
import cn.edu.sjtu.se.dclab.server.entity.ResidentCitizen;
import cn.edu.sjtu.se.dclab.server.service.CitizenService;
import cn.edu.sjtu.se.dclab.server.service.ResidentCitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/13.
 */
@Controller
@RequestMapping(Constants.REST + "/citizen")
public class CitizenController {

    @Autowired
    private ResidentCitizenService rcService;

    public ResidentCitizenService getCitizenService() {
        return rcService;
    }

    public void setCitizenService(ResidentCitizenService rcService) {
        this.rcService = rcService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<ResidentCitizen> findAll() {
        return rcService.findAll();
    }
}
