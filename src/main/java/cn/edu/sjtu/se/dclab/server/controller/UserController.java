package cn.edu.sjtu.se.dclab.server.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.service.UserService;
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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserTransfer getUserByUsername(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<UserTransfer> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String updateUser(UserTransfer userTransfer){
		userService.updateUser(userTransfer);
		return "success";
	}
	
	@RequestMapping(value = "test", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String test(){
		return "test";
	}

}
