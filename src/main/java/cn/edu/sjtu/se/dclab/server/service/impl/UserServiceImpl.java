package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.Role;
import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.mapper.RoleMapper;
import cn.edu.sjtu.se.dclab.server.mapper.UserMapper;
import cn.edu.sjtu.se.dclab.server.service.UserService;
import cn.edu.sjtu.se.dclab.server.transfer.UserRoleTransfer;
import cn.edu.sjtu.se.dclab.server.transfer.UserTransfer;

/**
 *2015年1月19日 下午9:44:00
 *@author changyi yuan
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public RoleMapper getRoleMapper() {
		return roleMapper;
	}

	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	@Override
	public UserTransfer getUserByUsername(String username) {
		User user = userMapper.findByUserName(username);
		if(user == null)
			return null;
		Collection<Role> roles = roleMapper.findByUserId(user.getId());
		
		UserTransfer userTransfer = new UserTransfer();
		userTransfer.setId(user.getId());
		userTransfer.setUsername(user.getUsername());
		userTransfer.setRoles(roles);
		userTransfer.setImageUrl(user.getImageUrl());
		
		return userTransfer;
	}

	@Override
	public Collection<UserTransfer> getAllUsers() {
		Collection<User> users = userMapper.findAll();
		Collection<UserTransfer> userTransfers = new ArrayList<UserTransfer>();
		for(User user : users){
			UserTransfer userTransfer = new UserTransfer();
			userTransfer.setId(user.getId());
			userTransfer.setUsername(user.getUsername());
			userTransfer.setRoles(roleMapper.findByUserId(user.getId()));
			userTransfer.setImageUrl(user.getImageUrl());
			userTransfers.add(userTransfer);
		}
		return userTransfers;
	}

	@Override
	public Collection<UserTransfer> getUserByCategory(String category) {
		Collection<User> users = userMapper.findAll();
		Collection<UserTransfer> userTransfers = new ArrayList<UserTransfer>();

		Iterator<User> iter = users.iterator();
		while (iter.hasNext()) {
			User user = iter.next();
			Collection<Role> roles = roleMapper.findByUserId(user.getId());

			UserTransfer userTransfer = new UserTransfer();
			userTransfer.setId(user.getId());
			userTransfer.setUsername(user.getUsername());
			userTransfer.setRoles(roles);
			userTransfer.setImageUrl(user.getImageUrl());

			boolean flag = false;
			if (category.equals("业委会")) {
				for (Role role : roles) {
					if (role.getName().startsWith("业委会")) {
						flag = true;
						break;
					}
				}
				if (flag) userTransfers.add(userTransfer);
			} else if (category.equals("居委会")) {
				for (Role role : roles) {
					if (role.getName().endsWith("主任")
							|| role.getName().endsWith("书记")
							|| role.getName().endsWith("员")||role.getName().endsWith("民警")) {
						flag = true;
						break;
					}
				}
				if (flag) userTransfers.add(userTransfer);
			} else {
				for (Role role : roles) {
					if (role.getName().endsWith("保安")) {
						flag = true;
						break;
					}
				}
				if (flag) userTransfers.add(userTransfer);
			}
		}

		return userTransfers;
	}

	@Override
	public UserTransfer authenticateUser(String username, String password) {
		User user = userMapper.findByUserName(username);
		if(user == null)
			return null;
		if(user.getPassword().equals(password)){
			Collection<Role> roles = roleMapper.findByUserId(user.getId());
			
			UserTransfer userTransfer = new UserTransfer();
			userTransfer.setId(user.getId());
			userTransfer.setUsername(user.getUsername());
			userTransfer.setRoles(roles);
			userTransfer.setImageUrl(user.getImageUrl());
			
			return userTransfer;
		}else{
			return null;
		}
	}

	@Override
	public UserTransfer getUserByUserId(long id) {
		User user = userMapper.findUserByUserId(id);
		UserTransfer userTransfer = new UserTransfer();
		userTransfer.setId(user.getId());
		userTransfer.setUsername(user.getUsername());
		userTransfer.setRoles(roleMapper.findByUserId(user.getId()));
		userTransfer.setImageUrl(user.getImageUrl());
		return userTransfer;
	}

	@Override
	public void updateUser(UserTransfer userTransfer) {
	}

	@Override
	public void updateUserRole(UserRoleTransfer userRoleTransfer) {
		long userId = userRoleTransfer.getUserId();
		long[] roleIds = userRoleTransfer.getRoleIds();
		userMapper.deleteUserRole(userId);
		for(long roleId : roleIds){
			userMapper.insertUserRole(userId, roleId);
		}
	}

	@Override
	public void updateUserRoles(List<UserRoleTransfer> userRoleTransfers) {
		for(UserRoleTransfer userRoleTransfer : userRoleTransfers){
			updateUserRole(userRoleTransfer);
		}
	}

}
