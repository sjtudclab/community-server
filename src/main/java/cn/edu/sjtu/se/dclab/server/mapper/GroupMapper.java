package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.Group;

/**
 *2015年4月2日 下午3:51:50
 *@author changyi yuan
 */
public interface GroupMapper {

	public Collection<Group> findByUserId(long userId);

	public Group save(Group group);

}