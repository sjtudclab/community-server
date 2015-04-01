package cn.edu.sjtu.se.dclab.server.service;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.Information;

public interface InformationService {
	public Collection<Information> findAllByType(int type);
	
	public Collection<Information> findById(long id, int type);
	public Collection<Information> findByKeyword(String keyword);
	
	public void save(Information information);
	public void blockById(long id);
}
