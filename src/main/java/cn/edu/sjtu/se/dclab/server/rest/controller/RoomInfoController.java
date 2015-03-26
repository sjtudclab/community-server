package cn.edu.sjtu.se.dclab.server.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.service.BlockRoomService;

@Controller
@RequestMapping("/room_info/")
public class RoomInfoController {
	@Autowired
	private BlockRoomService sv;
	@RequestMapping(value="{name}",method = RequestMethod.GET)
	@ResponseBody
	public String getManager(@PathVariable("name") String name) {
		String ans = sv.getRoomByName(name);
		System.out.println(ans);
		return ans;
	}	
}
