package cn.edu.sjtu.se.dclab.server.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.service.BlockRoomService;

@Controller
@RequestMapping("/block_room/")
public class BlockRoomController {
	
	@Autowired
	private BlockRoomService sv;
	
	@RequestMapping(value="{block}",method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String getManager(@PathVariable("block") String block) {
		String ans = sv.getRoomByBlock(block);
		System.out.println(ans);
		return ans;
	}	
}







