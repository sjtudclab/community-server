package cn.edu.sjtu.se.dclab.server.controller.basic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.service.UserService;

/**
 *2015年3月30日 下午6:11:22
 *@author changyi yuan
 */
@Controller
@RequestMapping("logout")
public class LogoutBasicController {
	@Autowired
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		long userId = (Long)session.getAttribute(Constants.SESSION_USER_ID);
		User user = userService.getUserByUserId(userId);
		String userType = user.getUserType().getType();
		session.invalidate();
		if(Constants.USER_TYPE_MANAGEMENT.equals(userType)){
			return "redirect:/login/committee";
		}else if(Constants.USER_TYPE_SERVICE.equals(userType)){
			return "redirect:/login/tenement";
		}
		return "redirect:/login/resident";
	}
}
