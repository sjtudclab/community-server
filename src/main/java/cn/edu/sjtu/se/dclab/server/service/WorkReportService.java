package cn.edu.sjtu.se.dclab.server.service;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.WorkReport;

public interface WorkReportService {
	public Collection<WorkReport> findAll();
	
	public Collection<WorkReport> findByCitizenId(long id);
	
	public void save(WorkReport workReport);
}
