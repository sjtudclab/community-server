package cn.edu.sjtu.se.dclab.server.mapper;

import cn.edu.sjtu.se.dclab.server.entity.Announcement;

/**
 * Created by Huiyi on 2015/3/13.
 */
public interface AnnouncementMapper {
    public void save(Announcement announcement);

    public void findAll();
}
