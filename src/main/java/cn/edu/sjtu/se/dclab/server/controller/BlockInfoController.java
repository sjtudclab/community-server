package cn.edu.sjtu.se.dclab.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.service.BlockInfoService;

@Controller
@RequestMapping("/block_info/")
public class BlockInfoController {
	
	@Autowired
	private BlockInfoService blockinfoService;
	
	@RequestMapping(value="{manager}",method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String getInfo(@PathVariable("manager") String manager) {
		String ans = blockinfoService.getInfoByManager(manager);
		System.out.println(ans);
		return ans;
	}
	
}
