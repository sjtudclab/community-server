package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.entity.RelationType;
import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.entity.UserRelation;
import cn.edu.sjtu.se.dclab.server.mapper.UserMapper;
import cn.edu.sjtu.se.dclab.server.mapper.UserRelationMapper;
import cn.edu.sjtu.se.dclab.server.service.UserRelationService;

/**
 *2015年4月2日 上午10:21:02
 *@author changyi yuan
 */
@Service
public class UserRelationServiceImpl implements UserRelationService {
	
	@Autowired
	private UserRelationMapper userRelationMapper;
	@Autowired
	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public UserRelationMapper getUserRelationMapper() {
		return userRelationMapper;
	}

	public void setUserRelationMapper(UserRelationMapper userRelationMapper) {
		this.userRelationMapper = userRelationMapper;
	}

	@Override
	public Collection<User> findByFollowerIdAndType(long fromId,
			String type) {
		Collection<UserRelation> relations =  new ArrayList<UserRelation>();
		Set<Long> ids = new HashSet<Long>();
		if(Constants.RELATOIN_FRIEND.equals(type)){
			Collection<UserRelation> followers = userRelationMapper.findByFromIdAndType(fromId, type);
			Collection<UserRelation> followeds = userRelationMapper.findByToIdAndType(fromId, type);
			for(UserRelation relation : followers)
				ids.add(relation.getFollowedId());
			for(UserRelation relation : followeds)
				ids.add(relation.getFollowerId());
		}else{
			relations = userRelationMapper.findByFromIdAndType(fromId, type);
			for(UserRelation relation : relations)
				ids.add(relation.getFollowedId());
		}
		Collection<User> users = new ArrayList<User>();
		if(ids.size() != 0)
			for(Long id : ids){
				User user = userMapper.findByUserId(id);
				users.add(user);
			}
		return users;
	}

	@Override
	public User findByFollowerIdAndType(long fromId, long toId,
			String type) {
		long friendId = 0;
		if(Constants.RELATOIN_FRIEND.equals(type)){
			UserRelation follower = userRelationMapper.findByFromIdAndToIdAndType(fromId, toId, type);
			if(follower != null)
				friendId = follower.getFollowedId();
			UserRelation followed = userRelationMapper.findByFromIdAndToIdAndType(toId, fromId, type);
			if(followed != null)
				friendId = followed.getFollowerId();
		}else{
			UserRelation relation = userRelationMapper.findByFromIdAndToIdAndType(fromId, toId, type);
			if(relation != null)
				friendId = relation.getFollowedId();
		}
		if(friendId == 0)
			return null;
		User user = userMapper.findByUserId(friendId);
		return user;
	}

	@Override
	public void createAttention(UserRelation relation) {
		RelationType relationType = userRelationMapper.findByType(Constants.RELATION_CIRCLE);
		relation.setRelationType(relationType);
		userRelationMapper.create(relation);
	}

	@Override
	public Collection<User> findFollowedIdAndType(long userId,
			String type) {
		Collection<UserRelation> relations = userRelationMapper.findByToIdAndType(userId, type);
		Collection<User> users = new ArrayList<User>();
		if(relations != null)
			for(UserRelation relation : relations){
				User user = userMapper.findByUserId(relation.getFollowerId());
				users.add(user);
			}
		return users;
	}

}
