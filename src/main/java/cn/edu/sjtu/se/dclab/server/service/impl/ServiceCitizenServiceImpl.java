package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.Role;
import cn.edu.sjtu.se.dclab.server.entity.ServiceCitizen;
import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.mapper.RoleMapper;
import cn.edu.sjtu.se.dclab.server.mapper.ServiceCitizenMapper;
import cn.edu.sjtu.se.dclab.server.mapper.UserMapper;
import cn.edu.sjtu.se.dclab.server.service.ServiceCitizenService;
import cn.edu.sjtu.se.dclab.server.transfer.ServiceCitizenTransfer;

/**
 *2015年3月30日 下午9:54:37
 *@author changyi yuan
 */
@Service
public class ServiceCitizenServiceImpl implements ServiceCitizenService {
	@Autowired
	private ServiceCitizenMapper serviceCitizenMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;

	public RoleMapper getRoleMapper() {
		return roleMapper;
	}

	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public ServiceCitizenMapper getServiceCitizenMapper() {
		return serviceCitizenMapper;
	}

	public void setServiceCitizenMapper(ServiceCitizenMapper serviceCitizenMapper) {
		this.serviceCitizenMapper = serviceCitizenMapper;
	}

	@Override
	public ServiceCitizenTransfer findById(long id) {
		ServiceCitizen citizen = serviceCitizenMapper.findById(id);
		User user = userMapper.findByUserId(citizen.getUser().getId());
		List<Role> roles = (List<Role>) roleMapper.findByUserId(user.getId());
		ServiceCitizenTransfer transfer = new ServiceCitizenTransfer(
				citizen.getId(), citizen.getName(), user.getId(),
				user.getImage(), roles);

		return transfer;
	}

}
