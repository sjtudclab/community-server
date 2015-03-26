package cn.edu.sjtu.se.dclab.server.controller.rest;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.service.UserService;
import cn.edu.sjtu.se.dclab.server.transfer.UserRoleTransfer;
import cn.edu.sjtu.se.dclab.server.transfer.UserTransfer;

/**
 * 2015年3月11日 下午6:24:50
 *
 * @author changyi yuan
 */
@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private AuthenticationManager authenticationManager;

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserTransfer login(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(username, password);
		Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		return userService.getUserByUsername(username);
	}

	@RequestMapping(value = "{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserTransfer getUserByUsername(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}
	@RequestMapping(value = "id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserTransfer getUserByUserId(@PathVariable long id){
		return userService.getUserByUserId(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<UserTransfer> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String updateUser(@RequestBody UserTransfer userTransfer){
		userService.updateUser(userTransfer);
		return "success";
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String updateUsers(@RequestBody List<UserRoleTransfer> userRoleTransfers){
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
	public String test(){
		return "test";
	}

}