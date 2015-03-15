package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.Role;
import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.mapper.RoleMapper;
import cn.edu.sjtu.se.dclab.server.mapper.UserMapper;
import cn.edu.sjtu.se.dclab.server.service.UserService;
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

			boolean flag = false;
			if (category.equals("业委会")) {
				for (Role role : roles) {
					if (role.getName().endsWith("长")) {
						flag = true;
						break;
					}
				}
				if (flag) userTransfers.add(userTransfer);
			} else if (category.equals("居委会")) {
				for (Role role : roles) {
					if (role.getName().endsWith("主任")
							|| role.getName().endsWith("书记")
							|| role.getName().endsWith("员")) {
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
	public void updateUser(UserTransfer userTransfer) {
		User user = new User();
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
			
			return userTransfer;
		}else{
			return null;
		}
	}

}
