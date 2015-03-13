package cn.edu.sjtu.se.dclab.server.service.impl;

import cn.edu.sjtu.se.dclab.server.entity.Announcement;
import cn.edu.sjtu.se.dclab.server.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/13.
 */
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementService announcementService;

    public AnnouncementService getAnnouncementService() {
        return announcementService;
    }

    public void setAnnouncementService(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @Override
    public void save(Announcement announcement) {
        announcementService.save(announcement);
    }

    @Override
    public Collection<Announcement> findAll() {
        return announcementService.findAll();
    }
}
