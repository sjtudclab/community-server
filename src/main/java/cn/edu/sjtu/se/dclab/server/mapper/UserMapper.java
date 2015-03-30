package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;

import cn.edu.sjtu.se.dclab.server.entity.User;

/**
 * Created by Huiyi on 2015/3/11.
 */
public interface UserMapper {

    public User findByUserId(long id);
    public User findByUserName(String username);
    public Collection<User> findAll();
	public Collection<User> findUserByApartmentId(long id);
    
	public void deleteUserRole(long userId);
	public void insertUserRole(@Param("userId") long userId,@Param("roleId") long roleId);
}
