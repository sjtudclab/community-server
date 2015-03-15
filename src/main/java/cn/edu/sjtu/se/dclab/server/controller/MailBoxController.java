package cn.edu.sjtu.se.dclab.server.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.entity.MailBox;
import cn.edu.sjtu.se.dclab.server.service.MailBoxService;
import cn.edu.sjtu.se.dclab.server.transfer.MailBoxTransfer;

/**
 * 2015年3月11日 下午7:27:42
 *
 * @author changyi yuan
 */
@Controller
@RequestMapping("/mailboxs")
public class MailBoxController {
	@Autowired
	private MailBoxService mailBoxService;

	public MailBoxService getMailBoxService() {
		return mailBoxService;
	}

	public void setMailBoxService(MailBoxService mailBoxService) {
		this.mailBoxService = mailBoxService;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<MailBox> getMailBoxByUserId(@PathVariable long id) {
		return mailBoxService.getMailBoxByUserId(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String createMailBox(@RequestBody MailBoxTransfer mailBoxTransfer) {
		MailBox mailBox = new MailBox(mailBoxTransfer);
		mailBoxService.createMailBox(mailBox);
		return "succeess";
	}
}
