package cn.edu.sjtu.se.dclab.server.entity;
/**
 *2015年4月2日 上午10:44:07
 *@author changyi yuan
 */
public class InformationType {
	private long id;
	private String type;
	private String description;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
