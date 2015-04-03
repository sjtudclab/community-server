package cn.edu.sjtu.se.dclab.server.transfer;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.Role;

/**
 *2015年4月2日 下午10:35:26
 *@author changyi yuan
 */
public class CitizenTransfer {
	private long userId;
	private long citizenId;
	private String username;
	private String image;
	private String nickName;
	private String realName;
	private String gender;
	private int age;
	private String phone;
	private String email;
	private boolean hasIdentityCard;
	
	public CitizenTransfer(){
		
	}
	
	public CitizenTransfer(long userId, long citizenId, String username,
			String image, String nickName,
			String realName, String gender, int age, String phone,
			String email, boolean hasIdentityCard) {
		super();
		this.userId = userId;
		this.citizenId = citizenId;
		this.username = username;
		this.image = image;
		this.nickName = nickName;
		this.realName = realName;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.hasIdentityCard = hasIdentityCard;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getCitizenId() {
		return citizenId;
	}
	public void setCitizenId(long citizenId) {
		this.citizenId = citizenId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isHasIdentityCard() {
		return hasIdentityCard;
	}
	public void setHasIdentityCard(boolean hasIdentityCard) {
		this.hasIdentityCard = hasIdentityCard;
	}
}
