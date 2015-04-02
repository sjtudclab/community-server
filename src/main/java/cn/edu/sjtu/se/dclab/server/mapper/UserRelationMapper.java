package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;

import cn.edu.sjtu.se.dclab.server.entity.RelationType;
import cn.edu.sjtu.se.dclab.server.entity.UserRelation;

/**
 *2015年4月2日 上午10:21:23
 *@author changyi yuan
 */
public interface UserRelationMapper {

	public RelationType findByType(String type);

	public void create(UserRelation relation);
	
	public Collection<UserRelation> findByFromIdAndType(@Param("fromId") long fromId, @Param("type") String type);
	public Collection<UserRelation> findByToIdAndType(@Param("toId") long toId, @Param("type") String type);
	public UserRelation findByFromIdAndToIdAndType(@Param("fromId") long fromId, @Param("toId") long toId, @Param("type") String type);

}
