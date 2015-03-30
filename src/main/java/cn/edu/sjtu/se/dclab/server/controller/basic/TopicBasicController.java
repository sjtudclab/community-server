package cn.edu.sjtu.se.dclab.server.controller.basic;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/topic")
public class TopicBasicController {

	@RequestMapping("")
	public String serve() {
		return "topic";
	}
}
