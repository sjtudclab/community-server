package cn.edu.sjtu.se.dclab.server.mapper;

import org.apache.ibatis.annotations.Param;

import cn.edu.sjtu.se.dclab.server.entity.UserGroup;

/**
 *2015年4月2日 下午4:11:56
 *@author changyi yuan
 */
public interface UserGroupMapper {

	public void save(UserGroup userGroup);
	
	public boolean userIsInGroup(@Param("userId") long userId, @Param("groupId") long groupId);
	
}
