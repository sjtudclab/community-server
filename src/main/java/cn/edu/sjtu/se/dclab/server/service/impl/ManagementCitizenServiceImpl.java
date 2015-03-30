package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.ManagementCitizen;
import cn.edu.sjtu.se.dclab.server.mapper.ManagementCitizenMapper;
import cn.edu.sjtu.se.dclab.server.service.ManagementCitizenService;

/**
 *2015年3月30日 下午3:08:51
 *@author changyi yuan
 */
@Service
public class ManagementCitizenServiceImpl implements ManagementCitizenService {
	
	@Autowired
	private ManagementCitizenMapper managementCitizenMapper;

	public ManagementCitizenMapper getManagementCitizenMapper() {
		return managementCitizenMapper;
	}

	public void setManagementCitizenMapper(
			ManagementCitizenMapper managementCitizenMapper) {
		this.managementCitizenMapper = managementCitizenMapper;
	}

	@Override
	public Collection<ManagementCitizen> findAll() {
		return managementCitizenMapper.findAll();
	}

}
