package cn.edu.sjtu.se.dclab.server.service;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.Vote;


public interface VoteService {
    public void save(Vote vote);

    public Collection<Vote> findAll();
}
