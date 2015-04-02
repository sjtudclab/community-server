package cn.edu.sjtu.se.dclab.server.service;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.Group;

/**
 *2015年4月2日 下午3:34:41
 *@author changyi yuan
 */
public interface GroupService {

	public Collection<Group> findByUserId(long userId);

	public void create(Group group);

}
