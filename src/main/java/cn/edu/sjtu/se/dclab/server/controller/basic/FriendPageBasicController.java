package cn.edu.sjtu.se.dclab.server.controller.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("friendpage")
public class FriendPageBasicController {

	@RequestMapping("")
	String getFriendPage() {
		return "friendpage";
	}
	
	@RequestMapping("friendchat")
	String getChatPage() {
		return "friendchat";
	}
}
