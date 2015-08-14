package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.User;
import org.apache.ibatis.annotations.Param;

import cn.edu.sjtu.se.dclab.server.entity.Group;

/**
 *2015年4月2日 下午3:51:50
 *@author changyi yuan
 */
public interface GroupMapper {

	public Collection<Group> findByUserId(long userId);

	public void save(Group group);

	public Group findById(@Param("groupId") long groupId);

	public void update(Group group);

	public Collection<Long> findUsersById(@Param("groupId") long groupId);

	public Collection<User> findMemberlistById(long id);

}
