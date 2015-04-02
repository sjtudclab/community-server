package cn.edu.sjtu.se.dclab.server.service.impl;

import cn.edu.sjtu.se.dclab.server.entity.ResidentCitizen;
import cn.edu.sjtu.se.dclab.server.entity.Role;
import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.mapper.ResidentCitizenMapper;
import cn.edu.sjtu.se.dclab.server.mapper.RoleMapper;
import cn.edu.sjtu.se.dclab.server.mapper.UserMapper;
import cn.edu.sjtu.se.dclab.server.service.ResidentCitizenService;
import cn.edu.sjtu.se.dclab.server.transfer.ResidentCitizenTransfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by Huiyi on 2015/3/30.
 */
@Service
public class ResidentCitizenServiceImpl implements ResidentCitizenService {
	@Autowired
	private final ResidentCitizenMapper rcMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public RoleMapper getRoleMapper() {
		return roleMapper;
	}

	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	@Autowired
	public ResidentCitizenServiceImpl(ResidentCitizenMapper rcMapper) {
		this.rcMapper = rcMapper;
	}

	@Override
	public Collection<ResidentCitizen> findAll() {
		return rcMapper.findAll();
	}

	@Override
	public ResidentCitizenTransfer findById(long id) {
		ResidentCitizen citizen = rcMapper.findById(id);
		User user = userMapper.findByUserId(citizen.getUser().getId());
		List<Role> roles = (List<Role>) roleMapper.findByUserId(user.getId());
		ResidentCitizenTransfer transfer = new ResidentCitizenTransfer(
				citizen.getId(), citizen.getName(), user.getId(),
				user.getImage(), roles);

		return transfer;
	}

	@Override
	public ResidentCitizen findByUserId(long userId) {
		return rcMapper.findByUserId(userId);
	}
}
