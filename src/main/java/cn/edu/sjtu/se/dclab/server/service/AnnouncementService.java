package cn.edu.sjtu.se.dclab.server.service;

import cn.edu.sjtu.se.dclab.server.entity.Announcement;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/13.
 */
public interface AnnouncementService {
    public void save(Announcement announcement);

    public Collection<Announcement> findAll();
}
