package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.List;

import cn.edu.sjtu.se.dclab.server.entity.Vote;

public interface VoteMapper {
    public void save(Vote vote);

    public List<Vote> findAll();
}
