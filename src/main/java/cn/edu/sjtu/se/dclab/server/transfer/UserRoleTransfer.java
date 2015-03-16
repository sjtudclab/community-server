package cn.edu.sjtu.se.dclab.server.transfer;
/**
 *2015年3月16日 下午5:44:34
 *@author changyi yuan
 */
public class UserRoleTransfer {
	private long userId;
	private long[] roleIds;
	public long[] getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(long[] roleIds) {
		this.roleIds = roleIds;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
}
