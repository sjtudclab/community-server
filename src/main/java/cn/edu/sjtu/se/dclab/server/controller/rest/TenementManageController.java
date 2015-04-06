package cn.edu.sjtu.se.dclab.server.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.service.TenementManageService;
import cn.edu.sjtu.se.dclab.server.util.TenementOrderStatus;

@Controller
@RequestMapping(Constants.REST + "/tenement/manage/")
public class TenementManageController {
	
	@Autowired
	private TenementManageService manageService;
	
	@RequestMapping(value="serviceman/all", method=RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String getServicemanScore(){
		return manageService.getServicemanInfo(TenementOrderStatus.COMMENTED).toString();
	}
}
