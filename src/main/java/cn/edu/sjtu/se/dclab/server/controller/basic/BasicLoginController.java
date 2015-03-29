package cn.edu.sjtu.se.dclab.server.controller.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Huiyi on 2015/3/26.
 */
@Controller
@RequestMapping("login")
public class BasicLoginController {

    @RequestMapping("resident")
    public String residentLogin() {
        return "login_resident";
    }

    @RequestMapping("committee")
    public String committeeLogin() {
        return "login_committee";
    }

    @RequestMapping("tenement")
    public String tenementLogin() {
        return "login_tenement";
    }
}
