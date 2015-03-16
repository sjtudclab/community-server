package cn.edu.sjtu.se.dclab.server.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.entity.Fsrelation;
import cn.edu.sjtu.se.dclab.server.service.FsrelationService;

@Controller
@RequestMapping("/fsrelation/")
public class FsrelationController {
	@Autowired
	private FsrelationService fsrelationService;

	@RequestMapping(value="{actp}",method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Fsrelation> getFs(@PathVariable("actp") Long actp) {
		System.out.println("+controllerp25+++++++++++++++++");
		List<Fsrelation> tmp = fsrelationService.getRelationByActp(actp);
		System.out.println("++controller27++++++++++++++++++++++++++++"+tmp);
		return tmp;
	}
	
	@RequestMapping(value="se/{passp}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Fsrelation> getFc(@PathVariable("passp") Long passp) {
		System.out.println("+controller37+++++++++++++++");
		List<Fsrelation> tmp = fsrelationService.getRelationByPassp(passp);
		return tmp;
	}

	@RequestMapping(value="create",method = RequestMethod.GET)
	@ResponseBody
	public String createFsrelation(HttpServletRequest request,
			HttpServletResponse response) {
		return "index";
	}

}