package cn.edu.sjtu.se.dclab.server.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.service.BlockManagerService;

@Controller
@RequestMapping("/block_manager/")
public class BlockManagerController {

	@Autowired
	private BlockManagerService blockmanagerService;
	@RequestMapping(value="{name}",method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String getManager(@PathVariable("name") String name){
		String bm = blockmanagerService.getManagerByName(name);
		System.out.println(bm);
		return bm;
	}
	
	
}
