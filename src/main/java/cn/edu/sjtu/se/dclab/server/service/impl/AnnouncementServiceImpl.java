package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.Announcement;
import cn.edu.sjtu.se.dclab.server.mapper.AnnouncementMapper;
import cn.edu.sjtu.se.dclab.server.service.AnnouncementService;

/**
 * Created by Huiyi on 2015/3/13.
 */
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementMapper announcementMapper;

    public AnnouncementMapper getAnnouncementMapper() {
        return announcementMapper;
    }

    public void setAnnouncementMapper(AnnouncementMapper announcementMapper) {
        this.announcementMapper = announcementMapper;
    }

    @Override
    public void save(Announcement announcement) {
        announcementMapper.save(announcement);
    }

    @Override
    public Collection<Announcement> findAll() {
        return announcementMapper.findAll();
    }
}
