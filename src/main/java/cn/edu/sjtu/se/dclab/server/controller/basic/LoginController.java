package cn.edu.sjtu.se.dclab.server.controller.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Huiyi on 2015/3/26.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("resident")
    public String residentLogin(Model model) {
        return "login_resident";
    }
}
