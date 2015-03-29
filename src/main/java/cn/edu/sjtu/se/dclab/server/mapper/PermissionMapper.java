package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;

import cn.edu.sjtu.se.dclab.server.entity.Permission;

/**
 * Created by changyi yuan on 2015/3/11.
 */
public interface PermissionMapper {
	public Collection<Permission> findPermissionsByUserId(@Param("userId") long userId);
}
