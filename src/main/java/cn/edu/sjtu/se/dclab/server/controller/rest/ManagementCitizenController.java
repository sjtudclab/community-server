package cn.edu.sjtu.se.dclab.server.controller.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.entity.ManagementCitizen;
import cn.edu.sjtu.se.dclab.server.service.ManagementCitizenService;

/**
 *2015年3月30日 下午3:04:05
 *@author changyi yuan
 */
@Controller
@RequestMapping(value = Constants.REST + "/managementCitizens")
public class ManagementCitizenController {
	
	@Autowired
	private ManagementCitizenService managementCitizenService;
	
	public ManagementCitizenService getManagementCitizenService() {
		return managementCitizenService;
	}

	public void setManagementCitizenService(
			ManagementCitizenService managementCitizenService) {
		this.managementCitizenService = managementCitizenService;
	}

	@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<ManagementCitizen> findAll(){
		return managementCitizenService.findAll();
	}
}
