package cn.edu.sjtu.se.dclab.server.controller.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Huiyi on 2015/3/26.
 */
@Controller
public class BasicLoginController {

    @RequestMapping("resident")
    public String residentLogin() {
        return "login_resident";
    }

    @RequestMapping("login/committee")
    public String committeeLogin() {
        return "login_committee";
    }

    @RequestMapping("login/tenement")
    public String tenementLogin() {
        return "login_tenement";
    }
}
