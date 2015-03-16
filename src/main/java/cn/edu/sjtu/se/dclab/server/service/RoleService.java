package cn.edu.sjtu.se.dclab.server.service;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.Role;

/**
 *2015年3月11日 下午6:57:06
 *@author changyi yuan
 */
public interface RoleService {
	public Collection<Role> getAllRoles();

	public Role findOne(long id);
}
