package cn.edu.sjtu.se.dclab.server.entity;
/**
 *2015年4月2日 上午9:57:05
 *@author changyi yuan
 */
public class UserRelation {
	private long followerId;
	private long followedId;
	private RelationType type;
	public long getFollowerId() {
		return followerId;
	}
	public void setFollowerId(long followerId) {
		this.followerId = followerId;
	}
	public long getFollowedId() {
		return followedId;
	}
	public void setFollowedId(long followedId) {
		this.followedId = followedId;
	}
	public RelationType getType() {
		return type;
	}
	public void setType(RelationType type) {
		this.type = type;
	}
}
