package cn.edu.sjtu.se.dclab.server.mapper;

import cn.edu.sjtu.se.dclab.server.entity.BBSPost;
import cn.edu.sjtu.se.dclab.server.entity.Block_manager;

import java.util.Collection;

public interface BBSMapper {
	
	public Collection<BBSPost> findAll();
	public void save(BBSPost bbsPost);
}
