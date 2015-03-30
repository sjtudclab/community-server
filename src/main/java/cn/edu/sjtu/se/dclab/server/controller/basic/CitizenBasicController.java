package cn.edu.sjtu.se.dclab.server.controller.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.sjtu.se.dclab.server.common.Constants;

/**
 *2015年3月26日 下午3:40:31
 *@author changyi yuan
 */
@Controller
@RequestMapping(value = "/committee")
public class CitizenBasicController {
	
	@RequestMapping(value = "manage")
	public String manage(){
		return "renshiguanli";
	}
	
}
