package cn.edu.sjtu.se.dclab.server.controller;

import cn.edu.sjtu.se.dclab.server.entity.Announcement;
import cn.edu.sjtu.se.dclab.server.entity.Apartment;
import cn.edu.sjtu.se.dclab.server.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/13.
 */
@Controller
@RequestMapping("/announcement")
public class AnnouncementController {

    @Autowired
    private
    AnnouncementService announcementService;

    public AnnouncementService getAnnouncementService() {
        return announcementService;
    }

    public void setAnnouncementService(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void save(@RequestBody Announcement announcement) {
        announcementService.save(announcement);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Announcement> findAll() {
        return announcementService.findAll();
    }
}
