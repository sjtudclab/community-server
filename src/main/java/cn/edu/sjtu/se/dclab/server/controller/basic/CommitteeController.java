package cn.edu.sjtu.se.dclab.server.controller.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 2015年1月19日 上午10:53:57
 *
 * @author Applex
 */
@Controller
@RequestMapping("/committee")
public class CommitteeController {

	@RequestMapping("notice") 
	public String notice() {
		return "community_notice";
	}

	@RequestMapping("apartment")
	public String apartment() {
		return "block_block_detail";
	}

	@RequestMapping("citizen")
	public String citizen() {
		return "block_citizen_detail";
	}

	@RequestMapping("topic")
	public String submitTopic() {
		return "topic_add";
	}

	@RequestMapping("mailbox")
	public String mailbox() {
		return "mailbox";
	}

	@RequestMapping("activity")
	public String communityActivity() {
		return "activity_add";
	}

	@RequestMapping("market")
	public String market() {
		return "market_committee";
	}

	@RequestMapping("workreport")
	public String workreport() {
		return "workreport";
	}
	
	@RequestMapping("supervise")
	public String supervise() {
		return "monitor";
	}
}
