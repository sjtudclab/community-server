package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.Information;
import cn.edu.sjtu.se.dclab.server.mapper.InformationMapper;
import cn.edu.sjtu.se.dclab.server.service.InformationService;

@Service
public class InformationServiceImpl implements InformationService{

	@Autowired
	InformationMapper informationMapper;
	
	public void setInformationMapper(InformationMapper informationMapper) {
		this.informationMapper = informationMapper;
	}
	public InformationMapper getInformationMapper() {
		return informationMapper;
	}
	
	@Override
	public Collection<Information> findAllByType(int type) {
		// TODO Auto-generated method stub
		
		return informationMapper.findAllByType(type);
	}

	@Override
	public Collection<Information> findById(long id, int type) {
		// TODO Auto-generated method stub
		return informationMapper.findById(id, type);
	}
	
	@Override
	public Collection<Information> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return informationMapper.findByKeyword(keyword);
	}

	@Override
	public void save(Information information) {
		// TODO Auto-generated method stub
		informationMapper.save(information);
	}

	public void blockById(long id) {
		informationMapper.blockById(id);
	}

}
