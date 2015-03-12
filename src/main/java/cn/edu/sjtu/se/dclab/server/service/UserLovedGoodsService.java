/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.service;

import java.util.List;

import cn.edu.sjtu.se.dclab.server.entity.UserLovedGoods;

/**
 * @author chenhui
 *
 */
public interface UserLovedGoodsService {
	
	public List<UserLovedGoods> getLovedInfoById(Integer id);
	
	public String getLovedInfoByUserId(Integer id);
	
	public void createLovedGoods(int userID, int goodsID, String stage);

}
