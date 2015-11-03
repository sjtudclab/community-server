package cn.edu.sjtu.se.dclab.server.service.impl;

import cn.edu.sjtu.se.dclab.server.entity.Media;
import cn.edu.sjtu.se.dclab.server.service.MediaService;
import cn.edu.sjtu.se.dclab.server.util.FileUtil;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Service
@Qualifier("MediaServiceImpl")
public class MediaServiceImpl implements MediaService {


    @Override
    public String save(Media media, HttpServletRequest request) {
        String url = FileUtil.uploadFile(media.getFile(), request);
        return url;
    }

    public MultipartFile findByUrl(String url)
    {
        MultipartFile f = null;
        return f;
    }
}

