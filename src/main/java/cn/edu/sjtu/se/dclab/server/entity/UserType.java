package cn.edu.sjtu.se.dclab.server.entity;
/**
 *2015年3月30日 下午6:35:49
 *@author changyi yuan
 */
public class UserType {
	private int id;
	private String type;
	private String tableName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
