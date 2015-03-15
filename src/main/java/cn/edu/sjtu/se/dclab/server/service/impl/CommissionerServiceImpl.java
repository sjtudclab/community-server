package cn.edu.sjtu.se.dclab.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.Commissioner;
import cn.edu.sjtu.se.dclab.server.mapper.CommissionerMapper;
import cn.edu.sjtu.se.dclab.server.service.CommissionerService;

@Service
public class CommissionerServiceImpl implements CommissionerService {
	@Autowired
	private CommissionerMapper commissionerMapper;

	public CommissionerMapper getCommissionerMapper() {
		return commissionerMapper;
	}

	public void setCommissionerMapper(CommissionerMapper commissionerMapper) {
		this.commissionerMapper = commissionerMapper;
	}

	@Override
	public Commissioner getCommissionerById(Integer id) {
		return commissionerMapper.getCommissionerById(id);
	}

	@Override
	public Commissioner createCommissioner(Commissioner commissioner) {
		return commissionerMapper.createCommissioner(commissioner);
	}

	@Override
	public void deleteCommissionerById(Integer id) {
	}

}