package cn.edu.sjtu.se.dclab.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.sjtu.se.dclab.server.entity.UserGroup;
import cn.edu.sjtu.se.dclab.server.mapper.UserGroupMapper;
import cn.edu.sjtu.se.dclab.server.service.UserGroupService;

/**
 *2015年4月2日 下午4:28:21
 *@author changyi yuan
 */
public class UserGroupServiceImpl implements UserGroupService {
	
	@Autowired
	private UserGroupMapper userGroupMapper;

	public UserGroupMapper getUserGroupMapper() {
		return userGroupMapper;
	}

	public void setUserGroupMapper(UserGroupMapper userGroupMapper) {
		this.userGroupMapper = userGroupMapper;
	}

	@Override
	public void create(UserGroup userGroup) {
		userGroupMapper.save(userGroup);
	}

}
