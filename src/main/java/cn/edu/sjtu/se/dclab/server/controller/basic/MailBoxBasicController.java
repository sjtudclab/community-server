package cn.edu.sjtu.se.dclab.server.controller.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/mailbox")
public class MailBoxBasicController {

	@RequestMapping("")
	String mailbox() {
		return "mailbox";
	}
	
}
