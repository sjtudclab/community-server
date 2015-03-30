package cn.edu.sjtu.se.dclab.server.controller.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Huiyi on 2015/3/29.
 */
@Controller
@RequestMapping("resident")
public class ResidentController {

    @RequestMapping("committee")
    public String committee() {
        return "committee";
    }

    @RequestMapping("owner")
    public String owner() {
        return "owner";
    }

    @RequestMapping("tenement")
    public String tenement() {
        return "tenement";
    }

    @RequestMapping("notice")
    public String notice() {
        return "notice";
    }

    @RequestMapping("neighbor")
    public String neighbor() {
        return "neighbor";
    }

    @RequestMapping("topic")
    public String topic() {
        return "topic";
    }

    @RequestMapping("market")
    public String market() {
        return "market";
    }

    @RequestMapping("repair")
    public String repair() {
        return "repair";
    }

    @RequestMapping("activity")
    public String activity() {
        return "activity";
    }

    @RequestMapping("setting")
    public String setting() {
        return "setting";
    }
    
    @RequestMapping("user_position")
    public String userPosition() {
    	return "user_position";
    }
}
