package cn.edu.sjtu.se.dclab.server.service;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.entity.UserRelation;

/**
 * 2015年4月2日 上午9:55:32
 *
 * @author changyi yuan
 */
public interface UserRelationService {

	public Collection<User> findByFollowerIdAndType(long fromId,
			String friendRelatoin);

	public User findByFollowerIdAndType(long fromId, long toId,
			String friendRelatoin);

	public void createAttention(UserRelation relation);

	public Collection<User> findFollowedIdAndType(long userId,
			String type);

}
