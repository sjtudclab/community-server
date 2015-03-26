package cn.edu.sjtu.se.dclab.server.rest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.entity.Vote;
import cn.edu.sjtu.se.dclab.server.service.VoteService;


@Controller
@RequestMapping("/vote/")
public class VoteController {

	@Autowired
    private VoteService voteService;
	
    public VoteService getvoteService() {
        return voteService;
    }

    public void setVoteService(VoteService voteService) {
        this.voteService = voteService;
    }
    
    @RequestMapping(value = "create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void save(@RequestBody Vote vote) {
        voteService.save(vote);
    }
    
    @RequestMapping(value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Vote> findAll() {
        return voteService.findAll();
    }

}
