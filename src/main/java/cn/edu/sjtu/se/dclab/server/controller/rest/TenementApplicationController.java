package cn.edu.sjtu.se.dclab.server.controller.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.entity.TenementManage;
import cn.edu.sjtu.se.dclab.server.entity.TenementServiceApplication;
import cn.edu.sjtu.se.dclab.server.service.TenementApplicationService;
import cn.edu.sjtu.se.dclab.server.service.TenementManageService;
import cn.edu.sjtu.se.dclab.server.util.TenementApplicationStatus;
import cn.edu.sjtu.se.dclab.server.util.TenementManageStatus;

@Controller
@RequestMapping(Constants.REST + "/tenement/serving/")
public class TenementApplicationController {
	
	@Autowired
	private TenementApplicationService applicationService;
	
	@Autowired
	private TenementManageService manageService;
	
	@RequestMapping(value="user/application/create", method=RequestMethod.POST)
	@ResponseBody
	public String createServiceApplication(HttpServletRequest request,
			HttpServletResponse response) {
		
		int serve_id = Integer.parseInt(request.getParameter("serve_id"));
		String real_name = request.getParameter("real_name");
		String certification = request.getParameter("certification");
		String serve_time = request.getParameter("serve_time");
		String contact_address = request.getParameter("address");
		String contact_phone = request.getParameter("phone");
		String description = request.getParameter("description");
		String stage = TenementApplicationStatus.INITIAL;
		
		TenementServiceApplication tmp = new TenementServiceApplication();
		tmp.setServe_id(serve_id);
		tmp.setReal_name(real_name);
		tmp.setCertification(certification);
		tmp.setServe_time(serve_time);
		tmp.setContact_address(contact_address);
		tmp.setContact_phone(contact_phone);
		tmp.setDescription(description);
		tmp.setStage(stage);
		
		applicationService.createTenementApplication(tmp);
		
		//生成一条初始的管理数据
		TenementManage tmp2 = new TenementManage();
		tmp2.setServe_id(serve_id);
		tmp2.setStage(TenementManageStatus.INITIAL);
		manageService.createServicemanManage(tmp2);
		
		return "application success";
	}
	
	@RequestMapping(value="{id}/application/check", method=RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String checkServiceApplicationStatus(@PathVariable("id") int id) {
		return applicationService.getApplicationById(id).toString();
	}
	
	@RequestMapping(value="application/all", method=RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String getAllInitialApplication(){
		return applicationService.getAllApplicationByStage(TenementApplicationStatus.INITIAL).toString();
	}
	
	@RequestMapping(value="application/{serve_id}/pass", method=RequestMethod.POST)
	@ResponseBody
	public String passApplication(@PathVariable("serve_id") int serve_id) {
		applicationService.updateApplicationStatus(serve_id, TenementApplicationStatus.PASSED);
		return "pass application";
	}
	
	@RequestMapping(value="application/{serve_id}/unpass", method=RequestMethod.POST)
	@ResponseBody
	public String unpassApplication(@PathVariable("serve_id") int serve_id) {
		applicationService.updateApplicationStatus(serve_id, TenementApplicationStatus.FAILED);
		return "unpass application";
	}

}
