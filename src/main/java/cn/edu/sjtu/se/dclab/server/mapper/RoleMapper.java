package cn.edu.sjtu.se.dclab.server.mapper;

import cn.edu.sjtu.se.dclab.server.entity.Role;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/11.
 */
public interface RoleMapper {

    public Collection<Role> findAll();
    
    public Collection<Role> findByUserId(long id);
    
    public Role findOne(long id);
}
