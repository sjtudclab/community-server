package cn.edu.sjtu.se.dclab.server.service;


import cn.edu.sjtu.se.dclab.server.entity.Media;

import javax.servlet.http.HttpServletRequest;

public interface MediaService {

    public String save(Media media, HttpServletRequest request);

}
