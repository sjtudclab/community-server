package cn.edu.sjtu.se.dclab.server.transfer;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.Role;
import cn.edu.sjtu.se.dclab.server.entity.UserRole;

/**
 *2015年3月30日 下午3:23:38
 *@author changyi yuan
 */
public class ResidentCitizenTransfer {
	private long id;
	private String name;
	private long userId;
	private String image;
	private Collection<Role> roles;
	
	public ResidentCitizenTransfer(){
		
	}
	
	public ResidentCitizenTransfer(long id, String name, long userId,
			String image, Collection<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.userId = userId;
		this.image = image;
		this.roles = roles;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

}
