package cn.edu.sjtu.se.dclab.server.mapper;

import cn.edu.sjtu.se.dclab.server.entity.User;

/**
 * Created by Huiyi on 2015/3/11.
 */
public interface UserMapper {

    public User findByUserName(String username);
}
