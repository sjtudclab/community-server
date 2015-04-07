package cn.edu.sjtu.se.dclab.server.controller.rest;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.service.ManagementCitizenService;
import cn.edu.sjtu.se.dclab.server.service.UserService;
import cn.edu.sjtu.se.dclab.server.transfer.ManagementCitizenTransfer;
import cn.edu.sjtu.se.dclab.server.transfer.UserRoleTransfer;

/**
 * 2015年3月30日 下午3:04:05
 *
 * @author changyi yuan
 */
@Controller
@RequestMapping(value = Constants.REST + "/managementCitizens")
public class CitizenManagementController {

	@Autowired
	private ManagementCitizenService managementCitizenService;
	@Autowired
	private UserService userService;

	public ManagementCitizenService getManagementCitizenService() {
		return managementCitizenService;
	}

	public void setManagementCitizenService(
			ManagementCitizenService managementCitizenService) {
		this.managementCitizenService = managementCitizenService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "committee", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<ManagementCitizenTransfer> findAllCommittees() {
		return managementCitizenService.findAll(Constants.ROLE_COMMITTEE);
	}

	@RequestMapping(value = "owner", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<ManagementCitizenTransfer> findAllOwners() {
		return managementCitizenService.findAll(Constants.ROLE_OWNER);
	}

	@RequestMapping(value = "tenement", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<ManagementCitizenTransfer> findAllTenments() {
		return managementCitizenService.findAll(Constants.ROLE_TENEMENT);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String updateCitizens(
			@RequestBody List<UserRoleTransfer> userRoleTransfers) {
		userService.updateUserRoles(userRoleTransfers);
		return "success";
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ManagementCitizenTransfer getCitizenById(@PathVariable long id) {
		return managementCitizenService.findById(id);
	}
	
	@RequestMapping(value = "blockLeader", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<ManagementCitizenTransfer> getBlockLeaders(){
		return managementCitizenService.findBlockLeaders();
	}
}
