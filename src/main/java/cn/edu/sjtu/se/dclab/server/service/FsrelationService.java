package cn.edu.sjtu.se.dclab.server.service;

import java.util.List;

import cn.edu.sjtu.se.dclab.server.entity.Fsrelation;

public interface FsrelationService {
	
	public List<Fsrelation> getRelationByActp(Long actp);  //search by Active
	
	public List<Fsrelation> getFsrelationByPassp(Long passp);  //search by Passive
	
	public Fsrelation createFsrelation(Fsrelation fsrelation);  //add relation
	
	public void deleteFsrelationById(Integer id);  //delete relation
	
	public void updateFsrelationById(Integer id);  //update relation

}