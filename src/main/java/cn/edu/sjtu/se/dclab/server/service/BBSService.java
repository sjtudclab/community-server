package cn.edu.sjtu.se.dclab.server.service;

import cn.edu.sjtu.se.dclab.server.entity.BBSPost;

import java.util.Collection;

public interface BBSService {
	
	public Collection<BBSPost> findAll();	//JSON
	
}
