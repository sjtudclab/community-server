package cn.edu.sjtu.se.dclab.server.controller.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        return "notice_show";
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

    @RequestMapping("market_love")
    public String market_love() {
        return "market_love";
    }

    @RequestMapping("market_add_thing")
    public String market_add_thing() {
        return "market_add_thing";
    }

    @RequestMapping("market_publish")
    public String market_publish() {
        return "market_publish";
    }

    @RequestMapping("market_search")
    public String market_search() {
        return "market_search";
    }

    @RequestMapping("repair")
    public String repair() {
        return "repair";
    }

    @RequestMapping("activity")
    public String activity() {
        return "activity";
    }

    @RequestMapping("user_position")
    public String userPosition() {
    	return "user_position";
    }

    @RequestMapping(value = "vote/{id}", method = RequestMethod.GET)
    public String vote(@PathVariable(value = "id") long topicId) {
        return "topic_vote";
    }
    
    @RequestMapping("setting")
    public String settings() {
        return "settings";
    }

    @RequestMapping(value = "vote/result/{id}", method = RequestMethod.GET)
    public String voteResult() {
        return "topic_vote_result";
    }
}
