package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

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
		relation.setRelationType(userRelationMapper
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
			long startId, long count, String messageType) {
		Collection<Information> infos = new ArrayList<Information>();
		Collection<Information> sendInfos = informationMapper
				.findByFromIdAndToIdAndType(userId, friendId,
						Constants.INFORMATION_FRIEND_MESSAGE);
		Collection<Information> receiveInfos = informationMapper
				.findByFromIdAndToIdAndType(friendId, userId,
						Constants.INFORMATION_FRIEND_MESSAGE);
		infos.addAll(sendInfos);
		infos.addAll(receiveInfos);
		if(Constants.MESSAGE_BACK.equals(messageType))
			return resolveBack(infos, startId, count);
		return resolveForward(infos, startId, count);
	}

	@Override
	public Collection<Information> findByToIdAndType(long toId, String type,
			long startId, long count) {
		Collection<Information> infos = informationMapper.findByToIdAndType(
				toId, type);
		return resolveBack(infos, startId, count);
	}
	
	private Collection<Information> resolveForward(Collection<Information> infos,
			long startId, long count) {
		if (infos == null)
			return null;
		Information[] infoArray = new Information[infos.size()];
		infos.toArray(infoArray);
		Arrays.sort(infoArray, new Comparator<Information>() {

			@Override
			public int compare(Information info1, Information info2) {
				if (info1.getSubmitTime().before(info2.getSubmitTime()))
					return -1;
				if (info1.getSubmitTime().after(info2.getSubmitTime()))
					return 1;
				return 0;
			}
		});

		Collection<Information> results = new ArrayList<Information>();
		int i = 0;

		if (startId == 0) {
			for (Information info : infoArray) {
				if ((i++) == count)
					return results;
				results.add(info);
			}
			return results;
		}

		for (Information info : infoArray) {
			if (i < count) {
				if (info.getId() > startId) {
					results.add(info);
					i++;
				}
			} else
				break;
		}
		return results;
	}

	private Collection<Information> resolveBack(Collection<Information> infos,
			long startId, long count) {
		if (infos == null)
			return null;
		Information[] infoArray = new Information[infos.size()];
		infos.toArray(infoArray);
		Arrays.sort(infoArray, new Comparator<Information>() {

			@Override
			public int compare(Information info1, Information info2) {
				if (info1.getSubmitTime().before(info2.getSubmitTime()))
					return 1;
				if (info1.getSubmitTime().after(info2.getSubmitTime()))
					return -1;
				return 0;
			}
		});

		 Deque<Information> stack = new ArrayDeque<Information>();
		int i = 0;

		if (startId == 0) {
			for (Information info : infoArray) {
				if ((i++) == count)
					return stack;
				stack.push(info);
			}
			return stack;
		}

		for (Information info : infoArray) {
			if (i < count) {
				if (info.getId() < startId) {
					stack.push(info);
					i++;
				}
			} else
				break;
		}
		
		return stack;
	}

	@Override
	public Collection<Information> findByFromIdAndType(long fromId,
			String type, long startId, long count) {
		if (Constants.INFORMATION_CIRCLE_MESSAGE.equals(type)) {
			Set<Long> circles = new HashSet<Long>();
			Collection<Information> results = new ArrayList<Information>();

			Collection<UserRelation> followers = userRelationMapper
					.findByFromIdAndType(fromId, Constants.RELATION_CIRCLE);
			Collection<UserRelation> followeds = userRelationMapper
					.findByToIdAndType(fromId, Constants.RELATION_CIRCLE);

			for (UserRelation relation : followers) {
				circles.add(relation.getFollowerId());
				circles.add(relation.getFollowedId());
			}
			for (UserRelation relation : followeds) {
				circles.add(relation.getFollowerId());
				circles.add(relation.getFollowedId());
			}

			for (long userId : circles) {
				Collection<Information> infos = informationMapper
						.findByFromIdAndType(userId, type);
				results.addAll(infos);
			}

			return resolveBack(results, startId, count);
		}
		return informationMapper.findByFromIdAndType(fromId, type);
	}

}
