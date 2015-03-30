package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.ManagementCitizen;
import cn.edu.sjtu.se.dclab.server.entity.Role;
import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.mapper.ManagementCitizenMapper;
import cn.edu.sjtu.se.dclab.server.mapper.RoleMapper;
import cn.edu.sjtu.se.dclab.server.mapper.UserMapper;
import cn.edu.sjtu.se.dclab.server.service.ManagementCitizenService;
import cn.edu.sjtu.se.dclab.server.transfer.ManagementCitizenTransfer;

/**
 * 2015年3月30日 下午3:08:51
 *
 * @author changyi yuan
 */
@Service
public class ManagementCitizenServiceImpl implements ManagementCitizenService {

	@Autowired
	private ManagementCitizenMapper managementCitizenMapper;
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

	public ManagementCitizenMapper getManagementCitizenMapper() {
		return managementCitizenMapper;
	}

	public void setManagementCitizenMapper(
			ManagementCitizenMapper managementCitizenMapper) {
		this.managementCitizenMapper = managementCitizenMapper;
	}

	@Override
	public Collection<ManagementCitizenTransfer> findAll(String type) {
		Collection<ManagementCitizenTransfer> transfers = new ArrayList<ManagementCitizenTransfer>();
		Collection<ManagementCitizen> citizens = managementCitizenMapper
				.findAll();
		for (ManagementCitizen citizen : citizens) {
			User user = userMapper.findByUserId(citizen.getUser().getId());
			Collection<Role> roles = roleMapper.findByUserId(user.getId());
			List<String> roleNames = new ArrayList<String>();
			for (Role role : roles){
				if(type.equals(role.getRoleType().getType())){
					roleNames.add(role.getName());
					ManagementCitizenTransfer transfer = new ManagementCitizenTransfer(
							citizen.getId(), citizen.getName(), user.getId(), user.getImage(), roleNames);
					transfers.add(transfer);
				}
			}
		}
		return transfers;
	}

}
