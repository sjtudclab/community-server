package cn.edu.sjtu.se.dclab.server.service;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.Information;

public interface InformationService {
	public Collection<Information> findAll(int type);
	
	public Collection<Information> findById(long id, int type);
	
	public void save(Information information);
}
