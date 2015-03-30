package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.WorkReport;

public interface WorkReportMapper {
	public Collection<WorkReport> findAll();
	
	public Collection<WorkReport> findByCitizenId(long id);
	
	public void save(WorkReport workReport);
}
