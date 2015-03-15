package cn.edu.sjtu.se.dclab.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.entity.Commissioner;
import cn.edu.sjtu.se.dclab.server.service.CommissionerService;

@Controller
@RequestMapping("/commissioner/")
public class CommissionerController {
	@Autowired
	private CommissionerService commissionerService;
	@RequestMapping(value="{id}",method = RequestMethod.GET)
	@ResponseBody
	public String getCommissioner(@PathVariable("id") int id) {
		Commissioner commissioner = commissionerService.getCommissionerById(id);
		return commissioner.getName();
	}	

}
