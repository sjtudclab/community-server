package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.List;

import cn.edu.sjtu.se.dclab.server.entity.Fsrelation;

public interface FsrelationMapper {
	
	public List<Fsrelation> getFsrelationByActp(Long actp);  //search by Active
	
	public List<Fsrelation> getFsrelationByPassp(Long passp);  //search by Passive
	
	public void createFsrelation(Fsrelation fsrelation);  //add relation
	
	public void deleteFsrelationById(Integer id);  //delete relation
	
	public void updateFsrelationById(Integer id);  //update relation

}