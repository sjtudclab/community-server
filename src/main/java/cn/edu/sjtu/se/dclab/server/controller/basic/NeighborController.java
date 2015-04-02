package cn.edu.sjtu.se.dclab.server.controller.basic;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Huiyi on 2015/4/2.
 */
@Controller
@RequestMapping(value = "resident/neighbor")
public class NeighborController {

    @RequestMapping("friend/request")
    public String friendRequest() {
        return "friend_request";
    }
    
    @RequestMapping("/friend")
    public String getFriendPage() {
    	return "friendpage";
    }
    
    @RequestMapping("/group")
    public String getGroupPage() {
    	return "neighborgroup";
    }
    
    @RequestMapping("/friendchat")
    public String friendchat() {
    	return "friendchat";
    }
    
    @RequestMapping("/groupchat")
    public String groupchat() {
    	return "groupchat";
    }
}
