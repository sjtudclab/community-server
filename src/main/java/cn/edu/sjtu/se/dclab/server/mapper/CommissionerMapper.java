package cn.edu.sjtu.se.dclab.server.mapper;

import cn.edu.sjtu.se.dclab.server.entity.Commissioner;

public interface CommissionerMapper {
	
	public Commissioner getCommissionerById(Integer id);
	   
    public Commissioner createCommissioner(Commissioner commissioner);
   
    public void deleteCommissionerById(Integer id);
   
}