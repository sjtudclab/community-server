package cn.edu.sjtu.se.dclab.server.controller.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *2015年3月29日 下午1:06:41
 *@author changyi yuan
 */
@Controller
@RequestMapping("users")
public class UserBasicController {
	
	@RequestMapping("accessDenied")
	public String acceesDenied(){
		return "accessDenied";
	}
	
}
