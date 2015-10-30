package cn.edu.sjtu.se.dclab.server.service;


import cn.edu.sjtu.se.dclab.server.entity.Media;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface MediaService {

    public String save(Media media, HttpServletRequest request);

    public MultipartFile findByUrl(String url);

}
