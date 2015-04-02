package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.entity.Information;
import cn.edu.sjtu.se.dclab.server.entity.InformationType;
import cn.edu.sjtu.se.dclab.server.entity.UserRelation;
import cn.edu.sjtu.se.dclab.server.mapper.InformationMapper;
import cn.edu.sjtu.se.dclab.server.mapper.UserRelationMapper;
import cn.edu.sjtu.se.dclab.server.service.InformationService;

@Service
public class InformationServiceImpl implements InformationService{

	@Autowired
	InformationMapper informationMapper;
	@Autowired
	UserRelationMapper userRelationMapper;
	
	public UserRelationMapper getUserRelationMapper() {
		return userRelationMapper;
	}
	public void setUserRelationMapper(UserRelationMapper userRelationMapper) {
		this.userRelationMapper = userRelationMapper;
	}
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
	@Override
	public Collection<Information> findByFromIdAndType(long fromId,
			String type) {
		return informationMapper.findByFromIdAndType(fromId,type);
	}
	@Override
	public Collection<Information> findByToIdAndType(long toId,
			String type) {
		return informationMapper.findByToIdAndType(toId,type);
	}
	@Override
	public void updateFriendApplicationById(long applicationId) {
		Information information = informationMapper.findByIdAndType(applicationId,Constants.INFORMATION_ADD_FRIEND);
		UserRelation relation = new UserRelation();
		relation.setFollowerId(information.getFrom());
		relation.setFollowedId(information.getTo());
		relation.setType(userRelationMapper.findByType(Constants.RELATOIN_FRIEND));
		userRelationMapper.create(relation);
	}
	@Override
	public void create(Information information, String type) {
		//InformationType infoType = informationMapper.findByType(type);
	}

}
