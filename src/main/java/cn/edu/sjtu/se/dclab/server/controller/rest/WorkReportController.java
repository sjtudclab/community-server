package cn.edu.sjtu.se.dclab.server.controller.rest;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import cn.edu.sjtu.se.dclab.server.entity.WorkReport;
import cn.edu.sjtu.se.dclab.server.service.WorkReportService;
import cn.edu.sjtu.se.dclab.server.transfer.WorkReportTransfer;

@Controller
@RequestMapping(Constants.REST + "/work_report/")
public class WorkReportController {

	@Autowired
	private WorkReportService workReportService;
	
	public void setWorkReportService(WorkReportService workReportService) {
		this.workReportService = workReportService;
	}
	public WorkReportService getWorkReportService() {
		return this.workReportService;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<WorkReport> findByCitizenId(@PathVariable(value = "id") long id) {
		return workReportService.findByCitizenId(id);
	}
	
	@RequestMapping(value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<WorkReport> findAll() {
		return workReportService.findAll();
	}
	
    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String save(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ParseException, ServletException {
    	// get form info
    	MultipartHttpServletRequest req = (MultipartHttpServletRequest)request;
    	MultipartFile file = req.getFile("file");
    	
    	String citizenId = request.getParameter("citizenId");
    	String content = request.getParameter("content");
    	String attachment = "";
    	
    	if (!file.isEmpty()) {
			ServletContext sc = request.getSession().getServletContext();
			String dir = sc.getRealPath("/uploadimage");    //设定文件保存的目录
			
			String filename = file.getOriginalFilename();    //得到上传时的文件名
			
			String newFilename =  getFileNameWithoutExt(filename) + System.currentTimeMillis() + "." + getFileType(filename);
			attachment = "uploadimage/" + newFilename;

			FileUtils.writeByteArrayToFile(new File(dir,newFilename), file.getBytes());
    	}
    	System.out.println(citizenId + ":" + ":" + content + ":" + attachment);
    	
    	WorkReportTransfer workReportTransfer = new WorkReportTransfer();
    	workReportTransfer.setCitizenId(Long.valueOf(citizenId));
    	workReportTransfer.setReportTime(new Date());
    	workReportTransfer.setContent(content);
    	workReportTransfer.setAttachment(attachment);
    	
    	WorkReport workReport = new WorkReport(workReportTransfer);
        workReportService.save(workReport);
        
        return "redirect:/workreport";
    }
    
    private String getFileNameWithoutExt(String filename) {
    	return filename.split("\\.")[0];
    }
    
	private String getFileType(String filename){
		String[] arr = filename.split("\\.");
		return arr[1];
	}
}
