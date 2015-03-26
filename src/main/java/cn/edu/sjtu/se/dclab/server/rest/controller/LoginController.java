package cn.edu.sjtu.se.dclab.server.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.security.TokenUtils;

/**
 *2015年1月19日 下午11:39:29
 *@author changyi yuan
 */

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UserDetailsService userService;
	
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;
	
	@ResponseBody
	@RequestMapping(value="",method=RequestMethod.POST)
	public String login(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username == null)
			username = "";
		if(password == null)
			password = "";
		
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(username, password);
		Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
		
		UserDetails userDetails = null;
		
		if(!authentication.isAuthenticated())
			return "authenticate error!";
		
		userDetails = this.userService.loadUserByUsername(username);
		
		return TokenUtils.createToken(userDetails);
	}
}
