package cn.edu.sjtu.se.dclab.server.entity;
/**
 *2015年4月2日 上午9:57:05
 *@author changyi yuan
 */
public class UserRelation {
	private int id;
	private long followerId;
	private long followedId;
	private RelationType relationType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public RelationType getRelationType() {
		return relationType;
	}
	public void setRelationType(RelationType relationType) {
		this.relationType = relationType;
	}
}
