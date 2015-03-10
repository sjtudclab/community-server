/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.entity;

/**
 * @author chenhui
 * 
 * 记录闲置商品的其他信息
 */
public class SecondGoodsForm {
	private Integer id;
	private String owner;
	private String phone;
	private String place;
	private String stage;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}

}
