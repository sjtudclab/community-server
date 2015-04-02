package cn.edu.sjtu.se.dclab.server.controller.rest;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.entity.ManagementCitizen;
import cn.edu.sjtu.se.dclab.server.entity.ResidentCitizen;
import cn.edu.sjtu.se.dclab.server.entity.Role;
import cn.edu.sjtu.se.dclab.server.entity.ServiceCitizen;
import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.service.ManagementCitizenService;
import cn.edu.sjtu.se.dclab.server.service.ResidentCitizenService;
import cn.edu.sjtu.se.dclab.server.service.RoleService;
import cn.edu.sjtu.se.dclab.server.service.ServiceCitizenService;
import cn.edu.sjtu.se.dclab.server.service.UserService;
import cn.edu.sjtu.se.dclab.server.transfer.CitizenTransfer;
import cn.edu.sjtu.se.dclab.server.transfer.UserRoleTransfer;
import cn.edu.sjtu.se.dclab.server.transfer.UserTransfer;
import cn.edu.sjtu.se.dclab.server.util.TransferUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 2015年3月11日 下午6:24:50
 *
 * @author changyi yuan
 */
@Controller
@RequestMapping("rest/users")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ManagementCitizenService managementCitizenService;
	@Autowired
	private ServiceCitizenService serviceCitizenService;
	@Autowired
	private ResidentCitizenService residentCitizenService;

	public ManagementCitizenService getManagementCitizenService() {
		return managementCitizenService;
	}

	public void setManagementCitizenService(
			ManagementCitizenService managementCitizenService) {
		this.managementCitizenService = managementCitizenService;
	}

	public ServiceCitizenService getServiceCitizenService() {
		return serviceCitizenService;
	}

	public void setServiceCitizenService(
			ServiceCitizenService serviceCitizenService) {
		this.serviceCitizenService = serviceCitizenService;
	}

	public ResidentCitizenService getResidentCitizenService() {
		return residentCitizenService;
	}

	public void setResidentCitizenService(
			ResidentCitizenService residentCitizenService) {
		this.residentCitizenService = residentCitizenService;
	}

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(
			AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@RequestMapping(value = "login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserTransfer login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				username, password);
		Authentication authentication = this.authenticationManager
				.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		HttpSession session = request.getSession();
		UserTransfer userTransfer = userService.getUserByUsername(username);
		session.setAttribute(Constants.SESSION_USER_ID, userTransfer.getId());

		return userTransfer;
	}

	@RequestMapping(value = "hardwarelogin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String hardwareLogin(HttpServletRequest request)
			throws JsonProcessingException {
		String cardNumber = request.getParameter("cardnumber");
		String cardType = request.getParameter("cardtype");
		String citizenType = request.getParameter("citizentype");

		cardNumber = cardNumber.trim();

		UserTransfer transfer = userService.getUserByCardInfo(cardType,
				cardNumber, citizenType);
		if (transfer == null)
			return "User not found";

		UserDetails userDetails = userService.loadUserByUsername(transfer
				.getUsername());
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				transfer.getUsername(), userDetails.getPassword(),
				userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(
				authenticationToken);

		HttpSession session = request.getSession();
		session.setAttribute(Constants.SESSION_USER_ID, transfer.getId());

		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(transfer);

	}

	@RequestMapping(value = "{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserTransfer getUserByUsername(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}

	@RequestMapping(value = "id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserTransfer getUserByUserId(@PathVariable long id) {
		User user = userService.getUserByUserId(id);
		Collection<Role> roles = roleService.getRolesByUserId(user.getId());
		return convertUserToUserTransfer(user, roles);
	}

	@RequestMapping(value = "{id}/citizens", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CitizenTransfer getAllUserInfo(@PathVariable long id) {
		User user = userService.getUserByUserId(id);
		if (user == null)
			return new CitizenTransfer();
		if (Constants.USER_TYPE_MANAGEMENT.equals(user.getUserType().getType())) {
			ManagementCitizen citizen = managementCitizenService
					.findByUserId(user.getId());
			return TransferUtil.convertUserAndCitizenToCitizenTransfer(user,citizen);
		} else if (Constants.USER_TYPE_RESIDNET.equals(user.getUserType()
				.getType())) {
			ResidentCitizen citizen = residentCitizenService
					.findByUserId(user.getId());
			return TransferUtil.convertUserAndCitizenToCitizenTransfer(user,citizen);
		} 
		ServiceCitizen citizen = serviceCitizenService.findByUserId(user
					.getId());
		return TransferUtil.convertUserAndCitizenToCitizenTransfer(user,citizen);
		
	}

	private UserTransfer convertUserToUserTransfer(User user,
			Collection<Role> roles) {
		UserTransfer userTransfer = new UserTransfer();
		userTransfer.setId(user.getId());
		userTransfer.setUsername(user.getUsername());
		userTransfer.setRoles(roles);
		userTransfer.setImage(user.getImage());
		return userTransfer;
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<UserTransfer> getAllUsers() {
		return userService.getAllUsers();
	}

	@RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String updateUser(@RequestBody UserTransfer userTransfer) {
		userService.updateUser(userTransfer);
		return "success";
	}

	@RequestMapping(value = "", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String updateUsers(
			@RequestBody List<UserRoleTransfer> userRoleTransfers) {
		userService.updateUserRoles(userRoleTransfers);
		return "success";
	}

	@RequestMapping(value = "committee", method = RequestMethod.GET, produces = "application/json;utf-8")
	@ResponseBody
	public Collection<UserTransfer> getAllCommitteeUser() {
		return userService.getUserByCategory("居委会");
	}

	@RequestMapping(value = "owner", method = RequestMethod.GET, produces = "application/json;utf-8")
	@ResponseBody
	public Collection<UserTransfer> getAllOwnerUser() {
		return userService.getUserByCategory("业委会");
	}

	@RequestMapping(value = "tenement", method = RequestMethod.GET, produces = "application/json;utf-8")
	@ResponseBody
	public Collection<UserTransfer> getAllTenementUser() {
		return userService.getUserByCategory("物业");
	}

	@RequestMapping(value = "test", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String test() {
		return "test";
	}

}
