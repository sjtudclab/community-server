package cn.edu.sjtu.se.dclab.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *2015年1月21日 下午4:31:05
 *@author changyi yuan
 */
public class HelloController {

	@RequestMapping("/hello")
	@ResponseBody
	public String hell(){
		return "Hello";
	}
}
