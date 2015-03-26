package cn.edu.sjtu.se.dclab.server.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.entity.Fsrelation;
import cn.edu.sjtu.se.dclab.server.service.FsrelationService;
import cn.edu.sjtu.se.dclab.server.transfer.FsrelationTransfer;

@Controller
@RequestMapping("/fsrelation/")
public class FsrelationController {
	@Autowired
	private FsrelationService fsrelationService;

	@RequestMapping(value="{actp}",method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public FsrelationTransfer getFs(@PathVariable("actp") Long actp) {
		return fsrelationService.getRelationByActp(actp);
	}
	
	@RequestMapping(value="se/{passp}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public FsrelationTransfer getFc(@PathVariable("passp") Long passp) {
		return fsrelationService.getRelationByPassp(passp);
	}

	@RequestMapping(value="create",method = RequestMethod.POST)
	@ResponseBody
	public String createFsrelation(@RequestBody Fsrelation fsrelation) {
		fsrelationService.createFsrelation(fsrelation);
		return "success";
	}

}