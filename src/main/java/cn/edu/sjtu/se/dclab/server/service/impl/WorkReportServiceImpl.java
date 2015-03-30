package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.Citizen;
import cn.edu.sjtu.se.dclab.server.entity.WorkReport;
import cn.edu.sjtu.se.dclab.server.mapper.CitizenMapper;
import cn.edu.sjtu.se.dclab.server.mapper.WorkReportMapper;
import cn.edu.sjtu.se.dclab.server.service.WorkReportService;
@Service
public class WorkReportServiceImpl implements WorkReportService {

	@Autowired
	private WorkReportMapper workReportMapper;
	@Autowired
	private CitizenMapper citizenMapper;
	
	public void setWrokReportMapper(WorkReportMapper workReportMapper) {
		this.workReportMapper = workReportMapper;
	}
	public WorkReportMapper getWorkReportMapper() {
		return this.workReportMapper;
	}
	
	public void setCitizenMapper(CitizenMapper citizenMapper) {
		this.citizenMapper = citizenMapper;
	}
	public CitizenMapper getCitizenMapper() {
		return this.citizenMapper;
	}
	
	@Override
	public Collection<WorkReport> findAll() {
		// TODO Auto-generated method stub
		Collection<WorkReport> workReports = workReportMapper.findAll();
		return workReports;
	}

	@Override
	public Collection<WorkReport> findByCitizenId(long id) {
		// TODO Auto-generated method stub
		Collection<WorkReport> workReports = workReportMapper.findByCitizenId(id);
		return workReports;
	}

	@Override
	public void save(WorkReport workReport) {
		// TODO Auto-generated method stub
		workReportMapper.save(workReport);
	}
	
}
