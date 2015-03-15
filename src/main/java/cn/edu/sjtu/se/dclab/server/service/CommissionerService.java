package cn.edu.sjtu.se.dclab.server.service;

import cn.edu.sjtu.se.dclab.server.entity.Commissioner;

public interface CommissionerService {
	
	public Commissioner getCommissionerById(Integer id);
	   
    public Commissioner createCommissioner(Commissioner commissioner);
   
    public void deleteCommissionerById(Integer id);
}