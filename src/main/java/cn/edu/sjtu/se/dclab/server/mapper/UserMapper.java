package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.User;

/**
 * Created by Huiyi on 2015/3/11.
 */
public interface UserMapper {

    public User findByUserId(long id);
    public User findByUserName(String username);
    public Collection<User> findAll();
	public User findUserByUserId(long id);
    
}
