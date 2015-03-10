package cn.edu.sjtu.se.dclab.server.entity;

public class Room_member {
    private String room;
    private Integer user_id;
    private Integer is_owner;
    
	public String getRoom() {
		return room;
	}
	
	public void setRoom(String room) {
		this.room = room;
	}
	
	public Integer getMember() {
		return user_id;
	}
	
	public void setMember(Integer id) {
		this.user_id = id;
	}	
	
	public Integer getOwner() {
		return is_owner;
	}
	
	public void setOwner(Integer is_owner) {
		this.is_owner = is_owner;
	}
}
