package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.Role;
import cn.edu.sjtu.se.dclab.server.entity.UserRole;

/**
 * Created by Huiyi on 2015/3/11.
 */
public interface RoleMapper {

    public Collection<Role> findAll();
    
    public Collection<Role> findByUserId(long id);
    
    public Collection<UserRole> findUserRoleByUserId(long id);
    
    public Role findOne(long id);
}
