package cn.edu.sjtu.se.dclab.server.controller.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("neighborgroup")
public class NeighborGroupBasicController {

	@RequestMapping("")
	String getNeighborGroup() {
		return "neighborgroup";
	}
	
	@RequestMapping("groupchat")
	String getChatPage() {
		return "groupchat";
	}
}
