package cn.edu.sjtu.se.dclab.server.service;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.transfer.UserTransfer;

/**
 *2015年1月19日 下午9:43:23
 *@author changyi yuan
 */
public interface UserService{
	public UserTransfer getUserByUsername(String username);
	public Collection<UserTransfer> getAllUsers();
	
	public void updateUser(UserTransfer userTransfer);
	
	public UserTransfer authenticateUser(String username,String password);
}
