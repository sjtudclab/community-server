package cn.edu.sjtu.se.dclab.server.controller.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *2015年3月26日 下午3:15:36
 *@author changyi yuan
 */
@Controller
public class BasicController {

    @RequestMapping("start-screen-committee")
     public String committeeIndex() {
        return "start-screen-committee";
    }

    @RequestMapping("start-screen-resident")
    public String residentIndex() {
        return "start-screen-resident";
    }

    @RequestMapping("start-screen-tenement")
    public String tenementIndex() {
        return "start-screen-tenement";
    }

    @RequestMapping("start-screen-owner")
    public String ownerIndex() {
        return "start-screen-owner";
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }
}
