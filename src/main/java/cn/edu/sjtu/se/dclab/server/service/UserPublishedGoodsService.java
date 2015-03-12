/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.service;

import java.util.List;

import org.json.JSONObject;

import cn.edu.sjtu.se.dclab.server.entity.UserPublishedGoods;

/**
 * @author chenhui
 *
 */
public interface UserPublishedGoodsService {
	
	public List<UserPublishedGoods> getPublishedInfoById(Integer id);
	
	public String getPublishedInfoByUserId(Integer id);
	
	public void createPublishedGoods(int userID, int goodsID, String stage);

}
