package cn.edu.sjtu.se.dclab.server.controller.rest;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.entity.Media;
import cn.edu.sjtu.se.dclab.server.service.MediaService;
import cn.edu.sjtu.se.dclab.server.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hadoop on 10/30/15.
 */

@Controller
@RequestMapping(Constants.REST + "/media")
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String save(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        int contentType = Integer.valueOf(request.getParameter("contentType"));
        int fileIndex = Integer.valueOf(request.getParameter("fileIndex"));

        MultipartHttpServletRequest req = (MultipartHttpServletRequest)request;
        MultipartFile file = req.getFile("file");

        Media media = new Media();
        media.setFile(file);
        media.setContentType(contentType);
        media.setFileIndex(fileIndex);
        return mediaService.save(media,request);
    }

    @RequestMapping(value = "{url}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MultipartFile findByUrl(@PathVariable(value = "url")String url) {
        return mediaService.findByUrl(url);
    }
}