package cn.edu.sjtu.se.dclab.server.service.impl;

import cn.edu.sjtu.se.dclab.server.entity.Media;
import cn.edu.sjtu.se.dclab.server.service.MediaService;
import cn.edu.sjtu.se.dclab.server.util.FileUtil;
import cn.edu.sjtu.se.dclab.server.util.HDFSUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

@Service
@Qualifier("MediaServiceHDFSImpl")
public class MediaServiceHDFSImpl implements MediaService {


    @Override
    public String save(Media media, HttpServletRequest request) {
        String hdfsURL = HDFSUtil.uploadFile(media.getFile());
        return hdfsURL;
    }

    public MultipartFile findByUrl(String url)
    {
        MultipartFile f = null;
        return f;
    }

    @Override
    public InputStream getInputStreamFromPath(String path) {
        InputStream is = null;
        try{
            is = HDFSUtil.getFileFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();;
        }
        return is;
    }
}

