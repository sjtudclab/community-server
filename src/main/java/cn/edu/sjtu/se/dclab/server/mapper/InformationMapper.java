package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.Information;

public interface InformationMapper {

	public Collection<Information> findAllByType(int type);
	
	public Collection<Information> findById(long id, int type);
	
	public void save(Information information);

}
