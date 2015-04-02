package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

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
public class InformationServiceImpl implements InformationService {

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
	public Collection<Information> findByFromIdAndType(long fromId, String type) {
		return informationMapper.findByFromIdAndType(fromId, type);
	}

	@Override
	public Collection<Information> findByToIdAndType(long toId, String type) {
		return informationMapper.findByToIdAndType(toId, type);
	}

	@Override
	public void updateFriendApplicationById(long applicationId) {
		Information information = informationMapper.findByIdAndType(
				applicationId, Constants.INFORMATION_ADD_FRIEND);
		information.setStatus(Constants.INFORMATION_DONE_STATUS);
		informationMapper.update(information);

		UserRelation relation = new UserRelation();
		relation.setFollowerId(information.getFrom());
		relation.setFollowedId(information.getTo());
		relation.setType(userRelationMapper
				.findByType(Constants.RELATOIN_FRIEND));
		userRelationMapper.create(relation);
	}

	@Override
	public void create(Information information, String type) {
		InformationType infoType = informationMapper.findByType(type);
		information.setInformationType(infoType.getId());
		informationMapper.save(information);
	}

	@Override
	public Collection<Information> findChats(long userId, long friendId,
			long startId, long count) {
		Collection<Information> infos = informationMapper
				.findByFromIdAndToIdAndType(userId, friendId,
						Constants.INFORMATION_FRIEND_MESSAGE);
		if(infos == null)
			return null;
		Information[] infoArray = new Information[infos.size()];
		infos.toArray(infoArray);
		Arrays.sort(infoArray,new Comparator<Information>() {

			@Override
			public int compare(Information info1, Information info2) {
				if(info1.getSubmitTime().before(info2.getSubmitTime()))
					return 1;
				if(info1.getSubmitTime().after(info2.getSubmitTime()))
					return -1;
				return 0;
			}
		});
		
		Collection<Information> results = new ArrayList<Information>();
		int i = 0;
		
		if (startId == 0) {
			for(Information info : infoArray){
				if((i++) == count)
					return results;
				results.add(info);
			}
		}
		
		for(Information info : infoArray){
			if(info.getInformationId() < startId && (i++) < count)
				results.add(info);
			else
				break;
		}
		return results;
	}

}
