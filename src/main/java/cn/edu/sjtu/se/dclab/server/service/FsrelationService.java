package cn.edu.sjtu.se.dclab.server.service;

import cn.edu.sjtu.se.dclab.server.entity.Fsrelation;
import cn.edu.sjtu.se.dclab.server.transfer.FsrelationTransfer;

public interface FsrelationService {
	
	public FsrelationTransfer getRelationByActp(Long actp);  //search by Active
	
	public FsrelationTransfer getRelationByPassp(Long passp);  //search by Passive
	
	public Fsrelation createFsrelation(Fsrelation fsrelation);  //add relation
	
	public void deleteFsrelationById(Integer id);  //delete relation
	
	public void updateFsrelationById(Integer id);  //update relation

}