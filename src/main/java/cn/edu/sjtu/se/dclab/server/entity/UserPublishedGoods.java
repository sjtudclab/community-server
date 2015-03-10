package cn.edu.sjtu.se.dclab.server.entity;


/**
 * @author chenhui
 *
 */
public class UserPublishedGoods {
	
	private Integer userID;
	private Integer goodsID;
	private String stage;
	
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(Integer goodsID) {
		this.goodsID = goodsID;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}

}
