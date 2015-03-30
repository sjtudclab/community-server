package cn.edu.sjtu.se.dclab.server.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.service.ResidentCitizenService;
import cn.edu.sjtu.se.dclab.server.transfer.ResidentCitizenTransfer;

/**
 *2015年3月30日 下午9:15:35
 *@author changyi yuan
 */
@Controller
@RequestMapping(value = Constants.REST + "/citizenResidents")
public class CitizenResidentController {
	@Autowired
	private ResidentCitizenService residentCitizenService;
	
	public ResidentCitizenService getResidentCitizenService() {
		return residentCitizenService;
	}

	public void setResidentCitizenService(
			ResidentCitizenService residentCitizenService) {
		this.residentCitizenService = residentCitizenService;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResidentCitizenTransfer getResidentById(@PathVariable long id){
		return residentCitizenService.findById(id);
	}
	
}
