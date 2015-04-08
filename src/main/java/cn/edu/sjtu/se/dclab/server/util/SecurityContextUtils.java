package cn.edu.sjtu.se.dclab.server.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import cn.edu.sjtu.se.dclab.server.entity.User;

/**
 *2014年12月27日 上午9:59:47
 *@author changyi yuan
 */
public class SecurityContextUtils {
	public final static User getUser(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails)
			return (User)principal;
		return null;
	}
	
	public final static long getUserId(){
		User user = getUser();
		return user.getId();
	}
	
	public static boolean verifyUser(int userId){
		return userId == getUserId();
	}
}
