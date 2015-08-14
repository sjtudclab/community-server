package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.Group;
import cn.edu.sjtu.se.dclab.server.entity.UserGroup;
import cn.edu.sjtu.se.dclab.server.mapper.GroupMapper;
import cn.edu.sjtu.se.dclab.server.mapper.UserGroupMapper;
import cn.edu.sjtu.se.dclab.server.service.GroupService;

/**
 *2015年4月2日 下午3:44:12
 *@author changyi yuan
 */
@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupMapper groupMapper;
	@Autowired
	private UserGroupMapper userGroupMapper;
	
	public UserGroupMapper getUserGroupMapper() {
		return userGroupMapper;
	}

	public void setUserGroupMapper(UserGroupMapper userGroupMapper) {
		this.userGroupMapper = userGroupMapper;
	}

	public GroupMapper getGroupMapper() {
		return groupMapper;
	}

	public void setGroupMapper(GroupMapper groupMapper) {
		this.groupMapper = groupMapper;
	}

	@Override
	public Collection<Group> findByUserId(long userId) {
		return groupMapper.findByUserId(userId);
	}

	@Override
	public void create(Group group) {
		groupMapper.save(group);
		UserGroup userGroup = new UserGroup();
		userGroup.setGroupId(group.getId());
		userGroup.setUserId(group.getOwner());
		userGroupMapper.save(userGroup);
	}

	@Override
	public Collection<Long> findUsersById(long id) {
		return groupMapper.findUsersById(id);
	}
	@Override
	public Collection<User> findMemberlistById(long id) {return groupMapper.findMemberlistById(id);}
}
