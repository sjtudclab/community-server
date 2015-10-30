package cn.edu.sjtu.se.dclab.server.service.impl;

import cn.edu.sjtu.se.dclab.server.entity.Media;
import cn.edu.sjtu.se.dclab.server.service.MediaService;
import cn.edu.sjtu.se.dclab.server.util.FileUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class MediaServiceImpl implements MediaService {


    @Override
    public String save(Media media, HttpServletRequest request) {
        String url = FileUtil.uploadFile(media.getFile(), request);
        return url;
    }
}

