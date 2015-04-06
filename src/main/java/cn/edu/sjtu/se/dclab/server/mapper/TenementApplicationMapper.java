package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.List;

import cn.edu.sjtu.se.dclab.server.entity.TenementServiceApplication;

public interface TenementApplicationMapper {
	
	public void createServiceApplication(TenementServiceApplication tmp);
	
	public TenementServiceApplication getApplicationById(Integer serve_id);
	
	public List<TenementServiceApplication> getAllApplicationByStage(String stage);
	
	public void updateApplicationStatus(TenementServiceApplication tmp);

}
