package cn.edu.sjtu.se.dclab.server.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.service.ServiceCitizenService;
import cn.edu.sjtu.se.dclab.server.transfer.ServiceCitizenTransfer;

/**
 *2015年3月30日 下午9:15:07
 *@author changyi yuan
 */
@Controller
@RequestMapping(value = Constants.REST + "/serviceCitizens")
public class CitizenServiceController {
	@Autowired
	private ServiceCitizenService serviceCitizenService;
	
	public ServiceCitizenService getServiceCitizenService() {
		return serviceCitizenService;
	}

	public void setServiceCitizenService(ServiceCitizenService serviceCitizenService) {
		this.serviceCitizenService = serviceCitizenService;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ServiceCitizenTransfer getResidentById(@PathVariable long id){
		return serviceCitizenService.findById(id);
	}
}
