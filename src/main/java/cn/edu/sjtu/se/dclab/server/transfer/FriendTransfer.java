package cn.edu.sjtu.se.dclab.server.transfer;
/**
 *2015年4月2日 上午10:13:41
 *@author changyi yuan
 */
public class FriendTransfer {
	private long friendId;
	private String name;
	private String image;
	
	public FriendTransfer(){
		
	}
	
	public FriendTransfer(long friendId, String name, String image) {
		super();
		this.friendId = friendId;
		this.name = name;
		this.image = image;
	}
	public long getFriendId() {
		return friendId;
	}
	public void setFriendId(long friendId) {
		this.friendId = friendId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
