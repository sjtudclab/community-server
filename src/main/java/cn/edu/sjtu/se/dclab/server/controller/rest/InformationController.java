package cn.edu.sjtu.se.dclab.server.controller.rest;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sjtu.se.dclab.server.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.entity.Information;
import cn.edu.sjtu.se.dclab.server.service.InformationService;

@Controller
@RequestMapping(Constants.REST + "/information")
public class InformationController {
	
	@Autowired
	private InformationService informationService;

	public InformationService getInformationService() {
		return informationService;
	}
	public void setInformationService(InformationService informationService) {
		this.informationService = informationService;
	}
	
	@RequestMapping(value = "{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<Information> findAll(@PathVariable(value = "type")int type) {
		return informationService.findAllByType(type);
	}
	
	@RequestMapping(value = "{type}/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<Information> findById(@PathVariable(value = "type")int type, @PathVariable(value = "id")long id) {
		return informationService.findById(id, type);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String save(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String contentString = request.getParameter("content");
		int type = Integer.valueOf(request.getParameter("infotype"));
		long from = Long.parseLong(request.getParameter("from"));

		MultipartHttpServletRequest req = (MultipartHttpServletRequest)request;
		MultipartFile file = req.getFile("file");
		String attachment = FileUtil.uploadFile(file, request);
		
		Information information = new Information();
		information.setTitle(title);
		information.setFrom(from);
		information.setAttachment(attachment);
		information.setContent(contentString);
		information.setInformationType(type);
		information.setSubmitTime(new Date());

		informationService.save(information);

		return "redirect:" + request.getParameter("redirect_url");
	}

	@RequestMapping(value = "search/{keyword}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<Information> findByKeyword(@PathVariable(value = "keyword")String keyword) {
		return informationService.findByKeyword(keyword);
	}

	@RequestMapping(value = "block/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String blockById(@PathVariable(value = "id") long id) {
		informationService.blockById(id);
		return "success";
	}
}
