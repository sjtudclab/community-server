package cn.edu.sjtu.se.dclab.server.transfer;

import java.util.List;

/**
 *2015年3月30日 下午3:23:38
 *@author changyi yuan
 */
public class ManagementCitizenTransfer {
	private long id;
	private String name;
	private long userId;
	private String image;
	private List<String> roleNames;
	
	public ManagementCitizenTransfer(){
		
	}
	
	public ManagementCitizenTransfer(long id, String name, long userId,
			String image, List<String> roleNames) {
		super();
		this.id = id;
		this.name = name;
		this.userId = userId;
		this.image = image;
		this.roleNames = roleNames;
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

	public List<String> getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(List<String> roleNames) {
		this.roleNames = roleNames;
	}
}
