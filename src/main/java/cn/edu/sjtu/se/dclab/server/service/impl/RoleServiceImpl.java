package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.Role;
import cn.edu.sjtu.se.dclab.server.mapper.RoleMapper;
import cn.edu.sjtu.se.dclab.server.service.RoleService;

/**
 *2015年3月11日 下午6:57:27
 *@author changyi yuan
 */
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;

	public RoleMapper getRoleMapper() {
		return roleMapper;
	}

	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	@Override
	public Collection<Role> getAllRoles() {
		return roleMapper.findAll();
	}

	@Override
	public Role findOne(long id) {
		return roleMapper.findOne(id);
	}

}
