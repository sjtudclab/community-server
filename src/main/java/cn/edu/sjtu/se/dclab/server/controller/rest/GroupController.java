package cn.edu.sjtu.se.dclab.server.controller.rest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.common.Result;

/**
 *2015年4月2日 下午3:06:01
 *@author changyi yuan
 */
@Controller
@RequestMapping(value = Constants.REST + "/groups")
public class GroupController {
	
	@RequestMapping(value = "0/users/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getGroups(@PathVariable long userId){
		return "";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String createGroup(){
		return Result.SUCCESS;
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String addIntoGroup(){
		return Result.SUCCESS;
	}
}
