package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.Group;
import cn.edu.sjtu.se.dclab.server.entity.UserGroup;
import cn.edu.sjtu.se.dclab.server.mapper.GroupMapper;
import cn.edu.sjtu.se.dclab.server.mapper.UserGroupMapper;
import cn.edu.sjtu.se.dclab.server.service.UserGroupService;

/**
 *2015年4月2日 下午4:28:21
 *@author changyi yuan
 */
@Service
public class UserGroupServiceImpl implements UserGroupService {
	
	@Autowired
	private UserGroupMapper userGroupMapper;
	@Autowired
	private GroupMapper groupMapper;

	public GroupMapper getGroupMapper() {
		return groupMapper;
	}

	public void setGroupMapper(GroupMapper groupMapper) {
		this.groupMapper = groupMapper;
	}

	public UserGroupMapper getUserGroupMapper() {
		return userGroupMapper;
	}

	public void setUserGroupMapper(UserGroupMapper userGroupMapper) {
		this.userGroupMapper = userGroupMapper;
	}

	@Override
	public void create(UserGroup userGroup) {
		if(userGroupMapper.userIsInGroup(userGroup.getUserId(), userGroup.getGroupId()))
			return;
		userGroupMapper.save(userGroup);
		Group group = groupMapper.findById(userGroup.getGroupId());
		group.setCount(group.getCount() + 1);
		groupMapper.update(group);
	}

	@Override
	public void createGroups(Collection<UserGroup> groups) {
		for(UserGroup group : groups)
			create(group);
	}

}
