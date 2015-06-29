package cn.edu.sjtu.se.dclab.server.controller.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("merchant")
public class MerchanController {
    @RequestMapping("")
    public String merchantInfo() {
    	return "start-screen-merchant";
    }
    
    @RequestMapping("transinfo")
    public String transInfo() {
    	return "transinfo";
    }
}
