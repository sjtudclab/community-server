package cn.edu.sjtu.se.dclab.server.controller.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.service.ManagementCitizenService;
import cn.edu.sjtu.se.dclab.server.transfer.ManagementCitizenTransfer;

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

	@RequestMapping(value = "committee", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<ManagementCitizenTransfer> findAllCommittees(){
		return managementCitizenService.findAll(Constants.ROLE_COMMITTEE);
	}
	
	@RequestMapping(value = "owner", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<ManagementCitizenTransfer> findAllOwners(){
		return managementCitizenService.findAll(Constants.ROLE_OWNER);
	}
	
	@RequestMapping(value = "TENEMENT", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<ManagementCitizenTransfer> findAllTenments(){
		return managementCitizenService.findAll(Constants.ROLE_TENEMENT);
	}
}
