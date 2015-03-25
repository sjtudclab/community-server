package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.Vote;
import cn.edu.sjtu.se.dclab.server.mapper.VoteMapper;
import cn.edu.sjtu.se.dclab.server.service.VoteService;

@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteMapper voteMapper;
	
	public VoteMapper getVoteMapper() {
        return voteMapper;
    }

    public void setAnnouncementMapper(VoteMapper voteMapper) {
        this.voteMapper = voteMapper;
    }
	
	@Override
	public void save(Vote vote) {
		voteMapper.save(vote);
	}

	@Override
	public Collection<Vote> findAll() {
		return voteMapper.findAll();
	}

}
